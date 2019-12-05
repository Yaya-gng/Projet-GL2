package dateBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Accee extends BD {

    public static void setAccee(int matricule, int numF){
        try(
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("insert into accee(matricule, numF) values(?,?)");
                ){
            pr.setInt(1,matricule);
            pr.setInt(2,numF);
            pr.execute();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }



    }
}
