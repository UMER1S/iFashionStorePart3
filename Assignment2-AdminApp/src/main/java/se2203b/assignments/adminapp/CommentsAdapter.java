package se2203b.assignments.adminapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//TODO: Functions not implemented as not needed yet and this assignment has already taken 3 days.

public class CommentsAdapter {
    private Connection connection;

    public CommentsAdapter(Connection conn) throws SQLException {

        connection = conn;
        Statement stmt = connection.createStatement();

        try {
            stmt.execute("DROP TABLE Comments");
        }
        catch (SQLException e) {

        } finally {
            stmt.execute("CREATE TABLE Comments (" +
                    "ItemID int NOT NULL, " +
                    "Text VARCHAR(250), UserID Char(20) NOT NULL, " +
                    "Date DATE NOT NULL)");
        }
    }
}
