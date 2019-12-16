package dateBase;

import Model.Wiki;
import sample.listTwoPar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WikiBD extends BD {

    public static void creerWiki(String nomW, String problem, String contenu,int numUser, String createur ){
        try (
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("insert into wiki(nomW,problem,contenu,numUser,createur) values(?,?,?,?,?)");
        ) {
            pr.setString(1,nomW);
            pr.setString(2,problem);
            pr.setString(3,contenu);
            pr.setInt(4,numUser);
            pr.setString(5,createur);
            pr.execute();

            System.out.println("Creation du wiki");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


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



    public static void editierWiki(String nomW, String contenu, String editeur){
        try (
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("update wiki set contenu=?,editeur=? where nomW=?");
        ) {
            pr.setString(1,contenu);
            pr.setString(2,editeur);
            pr.setString(3,nomW);
            pr.execute();

            System.out.println("Wiki edité par "+editeur);

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Wiki> consulterWiki(String nomW){
        ArrayList<Wiki> l = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("select * from wiki where nomW=?");
        ) {
        pr.setString(1,nomW);
        ResultSet r = pr.executeQuery();

        if(r.next()){
            l.add(new Wiki(r.getInt("numW"),r.getString("nomW"), r.getString("problem"), r.getString("contenu"), r.getInt("numUser"), r.getString("createur"), r.getString("editeur")));
        }
        return l;

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static String getEditeur(String nomW){
        try (
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("select editeur from wiki where nomW=?");
        ) {
            pr.setString(1,nomW);
            ResultSet r = pr.executeQuery();
            if(r.next()) return r.getString("editeur");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
