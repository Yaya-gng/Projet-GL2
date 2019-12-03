
package dateBase;

import Model.Apprenant;
import sample.AllApprenant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AllLearners extends BD {

    public static ArrayList<AllApprenant> diplayAll(){
        ArrayList<AllApprenant> app = new ArrayList<>();
        try(
                Connection com = connect();

                PreparedStatement pr = connect().prepareStatement("select nom,prenom,specialite from apprenant");
                ){
            ResultSet r = pr.executeQuery();
                while(r.next()) app.add(new AllApprenant(r.getString("nom"), r.getString("prenom"), r.getString("specialite")));
                    System.out.println(app.size()+" "+app.get(0).toString());
                return app;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }




}
