package dateBase;

import java.sql.*;
import java.util.ArrayList;

public class ChatBD extends BD {

        public static void envoyerMessage(int numUser1, int numUser2, String contenu){
            try {
                Connection con = connect();
                Statement st=con.createStatement();
                st.executeUpdate("insert into Messages(sender,receiver,content) values ('"+numUser1+"','"+numUser2+"','"+contenu+"') ");
            } catch (SQLException e) {
                System.out.println("erreur insertion messages\n"+e);
            }

        }

        public static ArrayList<String> getApp() {
                ArrayList<String> s = new ArrayList<>();
            try {
                Connection con = connect();
                Statement st = con.createStatement();
                ResultSet r = st.executeQuery("select nom from user");

                while (r.next()) {
                    s.add(r.getString("nom"));
                }
                return s;

            } catch (SQLException e) {
                System.out.println("erreur insertion messages\n" + e);
            }
            return null;
        }

        public static String getMessages(int u1,int u2){

        String condition="sender in('"+u1+"','"+u2+
        "') and receiver in('"+u1+"','"+u2+"') order by nummessage;";
        Connection con = connect();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select from messages where "+ condition);

        String t="";
        try {
            while(rs.next()){
                t+=rs.getString("sender")+": "+rs.getString("content")+"\n\n";
            }
            return t;
        }catch(Exception ek){
            System.out.println("error at selecting Messages\n"+ek);
        }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static int getNumUser(String nom){
        try {
            Connection con = connect();
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery("select numUser from user nom="+nom);


            while (r.next()) {
                return r.getInt("numUser");
            }

        } catch (SQLException e) {
            System.out.println("erreur insertion messages\n" + e);
        }
            return -1;
    }

}
