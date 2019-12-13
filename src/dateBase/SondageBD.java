package dateBase;

import java.sql.*;
import java.util.ArrayList;

import Model.Sondage;

import javax.print.attribute.ResolutionSyntax;

public class SondageBD extends BD{
	
	public static void creerSondage(String titre, String contenu, String choix1, String choix2, String choix3, String choix4, int numUser) {
		
		try(  
				Connection con = connect();
				PreparedStatement pr1 = con.prepareStatement("select nom from user where numUser=?");
				PreparedStatement pr = con.prepareStatement("insert into sondage(titre,contenu,choix1,choix2,choix3,choix4,numUser,createur)values(?,?,?,?,?,?,?,?)");
				
				){
			pr.setInt(1,numUser);
			ResultSet r = pr1.executeQuery();
			pr.setString(1,titre);
			pr.setString(2,contenu);
			pr.setString(3,choix1);
			pr.setString(4,choix2);
			pr.setString(5,choix3);
			pr.setString(6,choix4);
			pr.setInt(7,numUser);
			pr.setString(8,r.getString("nom"));
			pr.execute();
						
			System.out.println("Creation du sondage éffectué");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static ArrayList<String, String> afficherSondage(){
		ArrayList<String,String> s = new ArrayList<>();
		try(
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("select titre,createur from sondage");
		) {
			ResultSet r = pr.executeQuery();

			while(r.next()){
				s.add(r.getString("titre"), r.getInt("createur"));
			}
			return s;

		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}


	public static ArrayList<Sondage> consulterSondage(int numS) {
		ArrayList<Sondage> snd = new ArrayList<>();
			try(
					Connection con = connect();
					PreparedStatement pr = con.prepareStatement("select * from sondage where numS=?");
					PreparedStatement pr1 = con.prepareStatement("select nom, prenom from user where numUser=?");
			){
			
			pr.setInt(1,numS);
			ResultSet rs = pr.executeQuery();

			pr1.setInt(1, rs.getInt("numUser"));
			ResultSet rs1 = pr1.executeQuery();
			
			if(rs.next()) {
				
				snd.add(new Sondage(numS,rs.getString("titre"), rs.getString("contenu"), rs.getString("choix1"), rs.getString("choix3"), rs.getString("choix4"), rs.getInt("numUser"), rs1.getString("nom")));
				
				return snd;
				
			}
			else return null;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public static void supprimer(int numS, int numUser) {
		
		try(
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("delete from sondage where numS=? and numUser=?");
				){
			
			pr.setInt(1,numS);
			pr.setInt(2,numUser);
			pr.execute();

			System.out.println("Suppression éffectée");
			
		}catch(SQLException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void participer(int numS, int idUser, String choix) {
		
		try(
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("insert into particpation (numS,idUser,choix) values(?,?,?)");
				){

			pr.setInt(1, numS);
			pr.setInt(2, idUser);
			pr.setString(3,choix);
			pr.execute();
			
			System.out.println("Ajout participation");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
			
		
		
	}
}
