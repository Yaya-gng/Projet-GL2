package dateBase;

import sample.AllApprenant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public static ArrayList<AllApprenant> getApprenant(int numF){
        ArrayList<AllApprenant> alp = new ArrayList<>();
        try(
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("select matricule,nom,prenom,specialite from apprenant where matricule in (select matricule from accee where numF=?)");
                ){
                pr.setInt(1,numF);
            ResultSet r = pr.executeQuery();
            while(r.next()){
                alp.add(new AllApprenant(r.getInt("matricule"),r.getString("nom"),r.getString("prenom"),r.getString("specialite")));
            }
            return alp;


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
 }
