import models.Person;
import java.sql.*;
import java.util.ArrayList;
public class MyApplication {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;

        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            con = DriverManager.getConnection(connectionUrl, "postgres", "7777");

            // The object of statement is responsible to execute queries with the database
            stmt = con.createStatement();

            // The executeQuery() method of Statement interface is used to execute queries
            // to the database. This method returns the object of ResultSet that can be
            // used to get all the records of a table that matches the sql statement
            rs = stmt.executeQuery("select * from person");

            while (rs.next()) { // Processing the result
                System.out.println(rs.getInt("id") + " "
                        + rs.getString("name") + " "
                        + rs.getString("email"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try { // Close connection – clean up system resources
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
