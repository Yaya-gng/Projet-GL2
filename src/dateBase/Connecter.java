package dateBase;

import java.sql.*;

public class Connecter extends BD {

	public static int getConnected() {

		try(Connection con = connect();
				
				PreparedStatement pr = con.prepareStatement("Select id from Connecter");
				){
			
			ResultSet r = pr.executeQuery();
			if(r.next())
			return r.getInt("id");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}
}
