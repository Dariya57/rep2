import models.Person;

import java.sql.*;
import java.util.ArrayList;

public class MyApplication {
    public static void main(String[] args) {
        String connectionString = "jdbc:postgresql://localhost:5432/simpledb";
        ArrayList<Person> persons = new ArrayList<>();
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionString, "postgres", "0000");

            String sql = "SELECT id, name, surname FROM persons ORDER BY id;";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                Person person = new Person(id, name, surname);
                persons.add(person);
            }
        } catch (SQLException e) {
            System.out.println("connection error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("driver error: " + e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("could not close the connection: " + e.getMessage());
                }
            }
        }

        for (Person person : persons) {
            System.out.println(persons);
        }
    }
}