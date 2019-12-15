package dateBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Blog;
import sample.listTwoPar;

import java.sql.Date;

public class BlogBD extends BD {

	public static void CreerBlog(String nomB, String contenu, String image1, String image2, int numUser, String createur) {

		try (
				Connection con = connect();

				PreparedStatement pr = con.prepareStatement("insert into blog(nomB,contenu,image1,image2,numUser,createur)values(?,?,?,?,?,?)");
		) {

			pr.setString(1, nomB);
			pr.setString(2, contenu);
			pr.setString(3, image1);
			pr.setString(4, image2);
			pr.setInt(5, numUser);
			pr.setString(6, createur);
			pr.execute();

			System.out.println("Creation du blog effecuté");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void partager(String titre) {

		try (
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("update blog set partager=true where titre=?");
		) {

			pr.setString(1, titre);
			pr.execute();
			System.out.println("Partage fait");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}


	public static ArrayList<listTwoPar> getBlogs(){
		ArrayList<listTwoPar> l = new ArrayList<>();
		try (
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("select nomB,createur from blog");
		) {
			ResultSet r = pr.executeQuery();
			while(r.next()){
				l.add(new listTwoPar(r.getString("nomB"), r.getString("createur")));
			}
			return l;

		}catch (SQLException e){
			System.out.println(e.getMessage());
		}
			return null;

		}

    public static ArrayList<listTwoPar> getMyBlogs(int numUser){
        ArrayList<listTwoPar> l = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("select nomB,createur from blog where numUser=?");
        ) {
            pr.setInt(1,numUser);
            ResultSet r = pr.executeQuery();
            while(r.next()){
                l.add(new listTwoPar(r.getString("nomB"), r.getString("createur")));
            }
            return l;

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;

    }

    public static void supprimerBlog(String nomB){

        try (
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("delete from blog where nomB=?");
        ) {
            pr.setString(1,nomB);
            pr.execute();

            System.out.println("Suppression effectue");


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
	}




}