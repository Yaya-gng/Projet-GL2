package dateBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Question extends BD {
    public static void setQuestion(int idQuiz,String q,String r,String c1,String c2,String c3,String c4){
    try {
        Connection con = connect();
        PreparedStatement pr = con.prepareStatement("insert into Question (question,reponse,choix1,choix2,choix3,choix4,idQuiz)values (?,?,?,?,?,?,?)");
        pr.setString(1,q);
        pr.setString(2,r);
        pr.setString(3,c1);
        pr.setString(4,c2);
        pr.setString(5,c3);
        pr.setString(6,c4);
        pr.setInt(7,idQuiz);
        pr.execute();
        System.out.println("Insertion question faite");

    }catch (SQLException e){
     System.out.println(e.getMessage());
    }
    }

}
