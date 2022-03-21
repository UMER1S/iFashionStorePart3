package se2203b.assignments.adminapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryAdapter {

    Connection connection;

    public CategoryAdapter(Connection conn, boolean drop) throws SQLException {

        connection = conn;
        Statement stmt = connection.createStatement();

        if (drop) {
            try {
                stmt.execute("DROP TABLE Categories");
            } catch (SQLException e) {

            } finally {
                stmt.execute("CREATE TABLE Categories (" +
                        "Category CHAR(20) NOT NULL, " +
                        "SubCategory CHAR(20))");
            }
        }


    }

    public void addCategory(String cat, String subcat) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs;

        //add new category to table
        String SQL_Statment = "INSERT INTO Categories (Category, SubCategory) VALUES ('"+cat+"','"+subcat+"')";
        if (subcat == null)
            SQL_Statment = "INSERT INTO Categories (Category, SubCategory) VALUES ('"+cat+"', 'NULL')";
        stmt.executeUpdate(SQL_Statment);
    }

    public ArrayList<String> getCategories() throws SQLException {
        ArrayList<String> returnlist = new ArrayList<>();

        Statement stmt = connection.createStatement();
        ResultSet rs;

        String SQL_Statement = "SELECT Category FROM Categories WHERE SubCategory = 'NULL'";
        rs = stmt.executeQuery(SQL_Statement);

        while (rs.next()) {
            returnlist.add(rs.getString("Category"));
        }
        return returnlist;
    }

    public ArrayList<String> getSubCategories(String cat) throws SQLException {
        ArrayList<String> returnlist = new ArrayList<>();

        Statement stmt = connection.createStatement();
        ResultSet rs;

        String SQL_Statement = "SELECT SubCategory FROM Categories WHERE Category = '" + cat + "' AND NOT SubCategory = 'NULL'";
        rs = stmt.executeQuery(SQL_Statement);

        while (rs.next()) {
            returnlist.add(rs.getString("SubCategory"));
        }
        return returnlist;
    }
}
