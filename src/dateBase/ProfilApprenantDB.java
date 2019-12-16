package dateBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Apprenant;


public class ProfilApprenantDB extends BD{
	
	
public static ArrayList<Apprenant> display(int matricule) {
	ArrayList<Apprenant> app = new ArrayList<>();
	try( Connection con = connect();
			PreparedStatement pr = con.prepareStatement("Select * from apprenant where matricule=?");
			){
			System.out.println("rzetrezt");
		   pr.setInt(1,matricule);
		   ResultSet r = pr.executeQuery();
		while(r.next()) {
			app.add(new Apprenant(r.getInt("matricule"),r.getString("nom"),r.getString("prenom"), r.getDate("dateNaiss"), r.getString("adresse"), r.getString("password"), r.getInt("section"), r.getInt("niveau"), r.getString("specialite"), r.getString("photo")));
			
			System.out.println("Affichage reussie");
			return app;
		}
		
	}catch(SQLException e) {
		System.out.println(e.getMessage());
	}
			
	return null;
}


public static void modify(int matricule, String nom, String prenom, String adresse, String password, String specialite, String niveau, String section) {
	
	try( Connection con = connect();
			PreparedStatement pr1 = con.prepareStatement("Update apprenant set nom=?,prenom=?, adresse=?,section=?, niveau=?, specliate=?, password=? where matricule=? ");

			){

		  pr1.setString(1,nom);
		  pr1.setString(2,prenom);
		  ;
		  pr1.setString(3,adresse);
		  pr1.setString(4,section);
		  pr1.setString(5,niveau);
		  pr1.setString(6,specialite);
		  pr1.setString(7,password);

		  pr1.setInt(8,matricule);
		  
		  pr1.execute();
		  System.out.println("Modification effectuée avec succée");
		  
		
	}catch(SQLException e) {
		System.out.println(e.getMessage());
	}
	
}



public static void Inscrire(int mat,String nom, String prenom, Date date, String adresse,String specialite, int niveau, int section, String password, String photo) {
	
	try(
			Connection con = connect();
	PreparedStatement pr = con.prepareStatement("Insert into apprenant(matricule,nom,prenom,dateNaiss,adresse,section,niveau,specialite,password, photo)values(?,?,?,?,?,?,?,?,?,?)");
	) {

	pr.setInt(1,mat);
	pr.setString(2,nom);
	pr.setString(3,prenom);
	pr.setDate(4,date);
	pr.setString(5,adresse);
	pr.setInt(6,section);
	pr.setInt(7,niveau);
	pr.setString(8,specialite);
	pr.setString(9, password);
	pr.setString(10,photo);
	
	pr.execute();
	System.out.println("Inscription d'un apprenant");
	PreparedStatement pr1 = con.prepareStatement("Insert into user(numUser,nom,prenom,password,apprenant,photo)values(?,?,?,?,?,?)");
	
	pr1.setInt(1,mat);
	pr1.setString(2,nom);
	pr1.setString(3,prenom);
	pr1.setString(4, password);
	pr1.setBoolean(5, true);
	pr1.setString(6,photo);
	pr1.execute();
	
	System.out.println("Apprenant ajouté dans la table user");
	
	}catch(SQLException e) {
		System.out.println(e.getMessage());
		
	}
}
}
