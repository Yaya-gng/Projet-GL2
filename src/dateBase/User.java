package dateBase;

import sample.listTwoPar;
import sample.listTwoPar1;

import java.sql.*;
import java.util.ArrayList;

public class User extends BD {
	
	public static int Connect(String username, String password) {
		
		try{
			Connection con = connect();
			
			PreparedStatement ps,pc;
			ps = con.prepareStatement("Select * from user where Nom=? and password=?");
			ps.setString(1, username);
		    ps.setString(2, password);
			ResultSet re = ps.executeQuery();
			
			pc = con.prepareStatement("delete from Connecter");
			
			if(re.next()) {
				
				if(re.getBoolean("admin")) 
					{
					
					pc.execute();
					PreparedStatement p = con.prepareStatement( "Insert into Connecter(id,nom,prenom, photo) values(?,?,?,?)");
					p.setInt(1, re.getInt("numUser"));
					p.setString(2,re.getString("nom"));
					p.setString(3,re.getString("prenom"));
					p.setString(4,re.getString("photo"));
					p.execute();
					  return 0;
					}
				else if(re.getBoolean("instructeur")) 
					{
					
					pc.execute();
						PreparedStatement p = con.prepareStatement( "Insert into Connecter(id,nom,prenom, photo) values(?,?,?,?)");
						p.setInt(1, re.getInt("numUser"));
						p.setString(2,re.getString("nom"));
						p.setString(3,re.getString("prenom"));
                        p.setString(4,re.getString("photo"));
					p.execute();
					  return 1;	
					}
				else if(re.getBoolean("apprenant")) 
					{
					
					pc.execute();
						PreparedStatement p = con.prepareStatement( "Insert into Connecter(id,nom,prenom,photo) values(?,?,?,?)");
						p.setInt(1, re.getInt("numUser"));
						p.setString(2,re.getString("nom"));
						p.setString(3,re.getString("prenom"));
                        p.setString(4,re.getString("photo"));
					p.execute();
					return 2;	
					}
				
				
			}
			else ps.close();
			
			return -1;
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}


	public static ArrayList<listTwoPar1> afficherP(int numF){
		ArrayList<listTwoPar1> s = new ArrayList<>();
		try(
				Connection con = connect();

				PreparedStatement pr = con.prepareStatement("Select nom, prenom from Apprenant where matricule in(select matricule from accee where numF=?)");
		){
			pr.setInt(1,numF);
			ResultSet r = pr.executeQuery();

			while (r.next()) s.add(new listTwoPar1(r.getString("nom"),r.getString("prenom")));

			return s;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
			return s;
	}

	public static ArrayList<listTwoPar1> afficherIns(int numF){
		ArrayList<listTwoPar1> s = new ArrayList<>();
		try(
				Connection con = connect();

				PreparedStatement pr = con.prepareStatement("Select nom, prenom from instructeur where id in(select id from formation where numF=?)");
		){
			pr.setInt(1,numF);
			ResultSet r = pr.executeQuery();

			while (r.next()) s.add(new listTwoPar1(r.getString("nom"),r.getString("prenom")));

			return s;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return s;
	}
	
}
