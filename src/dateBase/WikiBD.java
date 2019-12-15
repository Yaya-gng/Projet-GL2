package dateBase;

import sample.listTwoPar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WikiBD extends BD {


    public static ArrayList<listTwoPar> getWikis(){
        ArrayList<listTwoPar> l = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("select nomW,createur from wiki");
        ) {
            ResultSet r = pr.executeQuery();
            while(r.next()){
                l.add(new listTwoPar(r.getString("nomW"), r.getString("createur")));
            }
            return l;

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;

    }

    public static ArrayList<listTwoPar> getMyWikis(int numUser){
        ArrayList<listTwoPar> l = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("select nomW,createur from wiki where numUser=?");
        ) {
            pr.setInt(1,numUser);
            ResultSet r = pr.executeQuery();
            while(r.next()){
                l.add(new listTwoPar(r.getString("nomW"), r.getString("createur")));
            }
            return l;

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;

    }

    public static void supprimerWiki(String nomW){

        try (
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("delete from wiki where nomW=?");
        ) {
            pr.setString(1,nomW);
            pr.execute();

            System.out.println("Suppression effectue");


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
