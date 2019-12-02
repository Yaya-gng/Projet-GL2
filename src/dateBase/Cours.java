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

		PreparedStatement pr = con.prepareStatement("insert into courF(titre,contenu,numF)values(?,?,?,?)");
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


	public static ArrayList<Cour> afficherCours(String nomF, int id) {
		ArrayList<Cour> cours = new ArrayList<>();
		try(
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("select titre from coursF where numF=(Select numF from formation where nomF=?)");
				){

			pr.setString(1,nomF);
			ResultSet rs = pr.executeQuery();
				while(rs.next()) {
				cours.add(new Cour(rs.getString("titre")));
					}
			return cours;

		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
