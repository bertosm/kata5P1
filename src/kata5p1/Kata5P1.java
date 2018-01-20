package kata5p1;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        
        Class.forName("org.sqlite.JDBC");
        Connection connec = DriverManager.getConnection("jdbc:sqlite:kata5.db");
        Statement st = connec.createStatement();
        String query = "SELECT * FROM PEOPLE;";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()){
            System.out.println( "id = " + rs.getInt("id") + "name = " + rs.getString("name"));
        }
        
        st.execute("CREATE TABLE IF NOT EXISTS MAIL ('id' INTEGER PRIMARY KEY AUTOINCREMENT , 'Mail' TEXT NOT NULL);");
        
        String filename = "emailsFile.txt";
        
        BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
        String mail;
        String query2;
        
        while ((mail = reader.readLine()) != null) {
            if (!mail.contains("@")) continue;
            query2 = "ISERT INTO MAIL (mail) VALUES ('" + mail + "');";
            st.executeUpdate(query2);
        }
    }
    
}
