package dateBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Sondage;

public class SondageBD extends BD{
	
	public static void creerSondage(int id,String contenu, Date dateC) {
		
		try(  
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("insert into sondage(contenu,dateC,numUser)values(?,?,?)");
				
				){
			pr.setString(1,contenu);
			pr.setDate(2,dateC);
			pr.setInt(3,id);
			pr.execute();
						
			System.out.println("Creation du sondage éffectué");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}


	public static ArrayList<Sondage> consulterSondage(int numS) {
		ArrayList<Sondage> snd = new ArrayList<>();
		try(
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("select * from sondage where numS=?");
				){
			
			pr.setInt(1,numS);
			ResultSet rs = pr.executeQuery();
			
			
			if(rs.next()) {
				
				snd.add(new Sondage(numS, rs.getString("contenu"), rs.getDate("dateC"), rs.getInt("vote"), rs.getInt("id")));
				
				return snd;
				
			}
			else return null;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public static void supprimer(int numS) {
		
		try(
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("delete from sondage where numS=?");
				){
			
			pr.setInt(1,numS);
			pr.execute();
			
					
			System.out.println("Suppression éffectée");
			
		}catch(SQLException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void participer(int numS) {
		
		try(
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("update sondage set vote=? where numS=?");
				){
			
			pr.setInt(1, +1);
			pr.setInt(2, numS);
			pr.execute();
			
			System.out.println("Ajout participation");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
			
		
		
	}
}
