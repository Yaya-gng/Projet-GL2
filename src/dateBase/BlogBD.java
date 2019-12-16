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

	public static void CreerBlog(String nomB, String contenu, String image1, String image2, int numUser, String createur, String proposC) {

		try (
				Connection con = connect();

				PreparedStatement pr = con.prepareStatement("insert into blog(nomB,contenu,image1,image2,numUser,createur,proposC) values(?,?,?,?,?,?,?)");
		) {

			pr.setString(1, nomB);
			pr.setString(2, contenu);
			pr.setString(3, image1);
			pr.setString(4, image2);
			pr.setInt(5, numUser);
			pr.setString(6, createur);
			pr.setString(7,proposC);
			pr.execute();

			System.out.println("Creation du blog effecuté");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void modifierBlog(String nomB, String contenu, String image1, String image2, int numUser, String proposC){
		try (
				Connection con = connect();

				PreparedStatement pr = con.prepareStatement("update blog set contenu=?, image1=?, image2=?, proposC=? where nomB=?");
		) {

			pr.setString(1,contenu);
			pr.setString(2,image1);
			pr.setString(3,image2);
			pr.setString(4,proposC);
			pr.setString(5,nomB);
			pr.execute();

			System.out.println("Modification réussite");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static ArrayList<Blog> consulterBlog(String nomB){
		ArrayList<Blog> l = new ArrayList<>();
		try (
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("select * from blog where nomB=?");
		) {
			pr.setString(1,nomB);
			ResultSet r = pr.executeQuery();
			if(r.next()){
				l.add(new Blog(r.getInt("numB"), r.getString("nomB"), r.getString("contenu"),r.getString("image1"), r.getString("image2"), r.getInt("numUser"), r.getString("createur"), r.getString("proposC"), r.getBoolean("partager")));
			}

			System.out.println("Selection du blog faite");
			return l;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
			return null;
	}


	public static void partager(String nomB) {

		try (
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("update blog set partager=true where nomB=?");
		) {

			pr.setString(1, nomB);
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
				PreparedStatement pr = con.prepareStatement("select nomB,createur from blog where partager=?");
		) {
			pr.setBoolean(1,true);
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