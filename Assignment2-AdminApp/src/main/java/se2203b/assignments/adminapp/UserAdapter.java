package se2203b.assignments.adminapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//TODO: Functions not implemented as not needed yet and this assignment has already taken 3 days.

public class UserAdapter {

    private Connection connection;

    public UserAdapter(Connection conn) throws SQLException {

        connection = conn;
        Statement stmt = connection.createStatement();

        try {
            stmt.execute("DROP TABLE Users");
        }
        catch (SQLException e) {

        } finally {
            stmt.execute("CREATE TABLE Users (" +
                    "UserID CHAR(20) NOT NULL PRIMARY KEY, " +
                    "Email CHAR(30) NOT NULL, Phone CHAR(10), " +
                    "Password CHAR(15) NOT NULL)");
        }


    }
}
