package se2203b.assignments.adminapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemAdapter {

    Connection connection;

    public ItemAdapter(Connection conn, boolean drop) throws SQLException {

        connection = conn;

        Statement stmt = connection.createStatement();

        if (drop) {
            try {
                stmt.execute("DROP TABLE Items");
            } catch (SQLException e) {

            } finally {
                stmt.execute("CREATE TABLE Items (" +
                        "ItemID int NOT NULL, " +
                        "Name CHAR(45) NOT NULL, Category CHAR(20) NOT NULL, " +
                        "SubCategory CHAR(20) NOT NULL, Brand Char(20) NOT NULL," +
                        "Department Char(8) NOT NULL, Price Double NOT NULL," +
                        "Quantity int NOT NULL, Description CHAR(250))");
            }
        }


    }

    public void addItem(String name, String cat, String subcat, String brand, String dept, double price, int quantity, String desc) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs;

        //get latest itemID
        String SQL_Statment = "SELECT MAX(ItemID) FROM Items";
        rs = stmt.executeQuery(SQL_Statment);

        int newID = 0;

        //set new ID to be highest + 1
        if(rs.next()) {
            try {
                newID = rs.getInt(1);
            } catch (SQLException e) {System.out.println(e.getMessage());}
        }
        newID++;

        //add new item to table
        SQL_Statment = "INSERT INTO Items (ItemID, Name, Category, SubCategory, Brand, Department, Price, Quantity, Description) VALUES ("+newID+",'"+name+"','"+cat+"','"+subcat+"','"+brand+"','"+dept+"',"+price+","+quantity+",'"+desc+"')";
        stmt.executeUpdate(SQL_Statment);
    }

    public ArrayList<Item> getItemsByCategory(String cat) throws SQLException {
        ArrayList<Item> returnlist = new ArrayList<>();

        Statement stmt = connection.createStatement();
        ResultSet rs;

        String SQL_Statement = "SELECT * FROM Items WHERE Category = '" + cat + "'";
        rs = stmt.executeQuery(SQL_Statement);

        while (rs.next()) {
            ArrayList<CommentsFeedback> comments = new ArrayList<>();

            //get the comments for the item
            String SQL_Statement2 = "SELECT * FROM Comments WHERE ItemID = '" + rs.getInt("ItemID") + "'";
            ResultSet rs2 = stmt.executeQuery(SQL_Statement2);

            while(rs2.next()) {
                comments.add(new CommentsFeedback(rs2.getString("Text"), rs2.getString("UserID"), rs2.getDate("Date")));
            }

            returnlist.add(new Item(rs.getString("Name"), rs.getInt("ItemID"), rs.getString("Department"), rs.getString("Category"),
                    rs. getString("SubCategory"), rs.getString("Brand"), rs.getString("Description"), rs.getDouble("Price"),
                    rs.getInt("Quantity"), comments));
        }
        return returnlist;
    }

    public ArrayList<Item> getItemsBySubCategory(String cat, String subCat) throws SQLException {
        ArrayList<Item> returnlist = new ArrayList<>();

        Statement stmt = connection.createStatement();
        ResultSet rs;

        String SQL_Statement = "SELECT * FROM Items WHERE Category = '" + cat + "' AND SubCategory = '" + subCat + "'";
        rs = stmt.executeQuery(SQL_Statement);

        while (rs.next()) {
            ArrayList<CommentsFeedback> comments = new ArrayList<>();

            //get the comments for the item
            String SQL_Statement2 = "SELECT * FROM Comments WHERE ItemID = '" + rs.getInt("ItemID") + "'";
            ResultSet rs2 = stmt.executeQuery(SQL_Statement2);

            while(rs2.next()) {
                comments.add(new CommentsFeedback(rs2.getString("Text"), rs2.getString("UserID"), rs2.getDate("Date")));
            }

            returnlist.add(new Item(rs.getString("Name"), rs.getInt("ItemID"), rs.getString("Department"), rs.getString("Category"),
                    rs. getString("SubCategory"), rs.getString("Brand"), rs.getString("Description"), rs.getDouble("Price"),
                    rs.getInt("Quantity"), comments));
        }
        return returnlist;
    }

    public ArrayList<Item> getItemsByDepartment(String dept) throws SQLException{
        ArrayList<Item> returnlist = new ArrayList<>();

        Statement stmt = connection.createStatement();
        ResultSet rs;

        String SQL_Statement = "SELECT * FROM Items WHERE Department = '" + dept + "'";
        rs = stmt.executeQuery(SQL_Statement);

        while (rs.next()) {
            ArrayList<CommentsFeedback> comments = new ArrayList<>();

            //get the comments for the item
            String SQL_Statement2 = "SELECT * FROM Comments WHERE ItemID = '" + rs.getInt("ItemID") + "'";
            ResultSet rs2 = stmt.executeQuery(SQL_Statement2);

            while(rs2.next()) {
                comments.add(new CommentsFeedback(rs2.getString("Text"), rs2.getString("UserID"), rs2.getDate("Date")));
            }

            returnlist.add(new Item(rs.getString("Name"), rs.getInt("ItemID"), rs.getString("Department"), rs.getString("Category"),
                    rs. getString("SubCategory"), rs.getString("Brand"), rs.getString("Description"), rs.getDouble("Price"),
                    rs.getInt("Quantity"), comments));
        }
        return returnlist;
    }

    public ArrayList<Item> getItemsByBrand(String brand) throws SQLException {
        ArrayList<Item> returnlist = new ArrayList<>();

        Statement stmt = connection.createStatement();
        ResultSet rs;

        String SQL_Statement = "SELECT * FROM Items WHERE Brand = '" + brand + "'";
        rs = stmt.executeQuery(SQL_Statement);

        while (rs.next()) {
            ArrayList<CommentsFeedback> comments = new ArrayList<>();

            //get the comments for the item
            String SQL_Statement2 = "SELECT * FROM Comments WHERE ItemID = '" + rs.getInt("ItemID") + "'";
            ResultSet rs2 = stmt.executeQuery(SQL_Statement2);

            while(rs2.next()) {
                comments.add(new CommentsFeedback(rs2.getString("Text"), rs2.getString("UserID"), rs2.getDate("Date")));
            }

            returnlist.add(new Item(rs.getString("Name"), rs.getInt("ItemID"), rs.getString("Department"), rs.getString("Category"),
                    rs. getString("SubCategory"), rs.getString("Brand"), rs.getString("Description"), rs.getDouble("Price"),
                    rs.getInt("Quantity"), comments));
        }
        return returnlist;
    }

    public ArrayList<Item> getAllItems() throws SQLException {
        ArrayList<Item> returnlist = new ArrayList<>();

        Statement stmt = connection.createStatement();
        Statement stmt2 = connection.createStatement();
        ResultSet rs;

        String SQL_Statement = "SELECT * FROM Items";
        rs = stmt.executeQuery(SQL_Statement);

        while (rs.next()) {
            ArrayList<CommentsFeedback> comments = new ArrayList<>();

            //get the comments for the item
            String SQL_Statement2 = "SELECT * FROM Comments WHERE ItemID = " + rs.getInt("ItemID");
            ResultSet rs2 = stmt2.executeQuery(SQL_Statement2);

            while(rs2.next()) {
                comments.add(new CommentsFeedback(rs2.getString("Text"), rs2.getString("UserID"), rs2.getDate("Date")));
            }

            returnlist.add(new Item(rs.getString("Name"), rs.getInt("ItemID"), rs.getString("Department"), rs.getString("Category"),
                    rs. getString("SubCategory"), rs.getString("Brand"), rs.getString("Description"), rs.getDouble("Price"),
                    rs.getInt("Quantity"), comments));
        }
        return returnlist;

    }

    public void updateItem(int itemID ,String name, String cat, String subcat, String brand, String dept, double price, int quantity, String desc) throws SQLException {

        Statement stmt = connection.createStatement();
        String SQL_Statement = "UPDATE Items SET Name = '" + name + "' WHERE ItemID = " + itemID;
        stmt.executeUpdate(SQL_Statement);
        SQL_Statement = "UPDATE Items SET Category = '" + cat + "' WHERE ItemID = " + itemID;
        stmt.executeUpdate(SQL_Statement);
        SQL_Statement = "UPDATE Items SET SubCategory = '" + subcat + "' WHERE ItemID = " + itemID;
        stmt.executeUpdate(SQL_Statement);
        SQL_Statement = "UPDATE Items SET Brand = '" + brand + "' WHERE ItemID = " + itemID;
        stmt.executeUpdate(SQL_Statement);
        SQL_Statement = "UPDATE Items SET Department = '" + dept + "' WHERE ItemID = " + itemID;
        stmt.executeUpdate(SQL_Statement);
        SQL_Statement = "UPDATE Items SET Price = " + price + " WHERE ItemID = " + itemID;
        stmt.executeUpdate(SQL_Statement);
        SQL_Statement = "UPDATE Items SET Quantity = " + quantity + " WHERE ItemID = " + itemID;
        stmt.executeUpdate(SQL_Statement);
        SQL_Statement = "UPDATE Items SET Description = '" + desc + "' WHERE ItemID = " + itemID;
        stmt.executeUpdate(SQL_Statement);
    }

    public void removeItem(int itemID) throws SQLException {
        Statement stmt = connection.createStatement();
        String SQL_Statement = "DELETE FROM Items WHERE ItemID = " + itemID;
        stmt.executeUpdate(SQL_Statement);
    }

}
