package kata5p1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        Class.forName("org.sqlite.JDBC");
        Connection connec = DriverManager.getConnection("jdbc:sqlite:kata5.db");
        Statement st = connec.createStatement();
        String query = "SELECT * FROM PEOPLE;";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()){
            System.out.println( "id = " + rs.getInt("id") + "name = " + rs.getString("name"));
        }
        
    }
    
}
