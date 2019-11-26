package dateBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Formations extends BD {

	
	public static void creerFormation(String nomF, Date dateC, int id) {
		
		try(
				Connection con = connect();
				
				PreparedStatement pr = con.prepareStatement("insert into formation(nomF,dateC,id)values(?,?,?)");
				){
			
			pr.setString(1,nomF);
			pr.setDate(2,dateC);
			pr.setInt(3,id);
			
			pr.execute();
			
				System.out.println("Creation de la formation avec succé");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	
	public static void modifierFormation(int numF, String nomF, Date dateC) {
		
		try(
				Connection con = connect();
				
				PreparedStatement pr = con.prepareStatement("update formation set nomF=?, dateC=? where numF=?");
				){
			
			pr.setString(1,nomF);
			pr.setDate(2,dateC);
			pr.setInt(3,numF);
			
			pr.execute();
			
				System.out.println("Modification éffectuée avec succée");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
public static void gererDroitAcces(ArrayList<Integer> app, int numF){
		
		try(
				Connection con = connect();
				
				){
			
			for(int i=0;i<app.size();i++) {
				
		        PreparedStatement pr = con.prepareStatement("insert into accee(matricule,numF)values(?,?)");
				
				pr.setInt(1,app.get(i));
				pr.setInt(2,numF);
				pr.execute();
				
				System.out.println("Accee des etudiants vers le cours est effecté");
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
