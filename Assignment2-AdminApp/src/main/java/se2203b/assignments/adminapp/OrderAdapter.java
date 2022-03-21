package se2203b.assignments.adminapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//TODO: Functions not implemented as not needed yet and this assignment has already taken 3 days.

public class OrderAdapter {

    private Connection connection;

    public OrderAdapter (Connection conn) throws SQLException {

        connection = conn;
        Statement stmt = connection.createStatement();

        try {
            stmt.execute("DROP TABLE Orders");
        }
        catch (SQLException e) {

        } finally {
            stmt.execute("CREATE TABLE Orders (" +
                    "OrderID int NOT NULL PRIMARY KEY, " +
                    "User CHAR(20) NOT NULL, SubTotal double NOT NULL, " +
                    "ShippingAddress CHAR(30) NOT NULL, Payment CHAR(10) NOT NULL, " +
                    "Date DATE NOT NULL)");
        }


    }
}
