package dateBase;

import Model.Quizs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Quiz extends BD {

    public static ArrayList<String> getQuiz(int numF){
        ArrayList<String> q = new ArrayList<>();

        try(
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("select nomQ from Quiz where numF=?");
                ){
            pr.setInt(1,numF);

            ResultSet r = pr.executeQuery();

            while(r.next()){
                q.add(r.getString("nomQ"));
            }
            return q;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return null;

    }

	
	
}
