package se2203b.assignments.adminapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderItemsAdapter {

    private Connection connection;

    public OrderItemsAdapter(Connection conn) throws SQLException {

        connection = conn;
        Statement stmt = connection.createStatement();

        try {
            stmt.execute("DROP TABLE OrderItems");
        }
        catch (SQLException e) {

        } finally {
            stmt.execute("CREATE TABLE OrderItems (" +
                    "OrderID in NOT NULL, Item NOT NULL," +
                    "Quantity NOT NULL)");
        }

    }
}
