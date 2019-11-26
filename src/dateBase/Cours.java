package dateBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Cour;



public class Cours extends BD{

	public static void creerCour(String module, String titre, String contenu,int numF) {
		try(
		Connection con = connect();

		PreparedStatement pr = con.prepareStatement("insert into courF(module,titre,contenu,numF)values(?,?,?,?)");
		){
	
	pr.setString(1,module);
	pr.setString(2,titre);
	pr.setString(3,contenu);
	pr.setInt(4,numF);
	
	pr.execute();
	
		System.out.println("Creation du cour avec succé");
	
}catch(SQLException e) {
	System.out.println(e.getMessage());
}
	}
	
		
	public static ArrayList<Cour> afficherCours(int matricule) {
		ArrayList<Cour> cours = new ArrayList<>();
		try( 
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("select numC,module,titre,contenu from coursF where numC in(select numC from accee where matricule=?) ");
				){
			
			pr.setInt(1,matricule);
			
			ResultSet rs = pr.executeQuery();
			
			PreparedStatement pr1 = con.prepareStatement("select * from formation where numF in(select numF from coursF where numC=?)");
			pr1.setInt(1,rs.getInt("numC"));
			
			ResultSet r = pr1.executeQuery();
			
			while(r.next()){
				while(rs.next()) {
				cours.add(new Cour(rs.getInt("numC"), r.getInt("numF"), rs.getString("module"), rs.getString("titre"), rs.getString("contenu"), r.getString("nomF"), r.getDate("dateC"), r.getInt("id")));
				}
					}
			if(cours.isEmpty() == true) return cours;
			else return null;
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
