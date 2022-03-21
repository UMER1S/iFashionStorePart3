package se2203b.assignments.adminapp;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {

    private SimpleStringProperty UserID;
    private SimpleStringProperty password;
    private SimpleBooleanProperty loggedIn;

    public User(String userID, String password, Boolean loggedIn) {
        this.UserID.set(userID);
        this.password.set(password);
        this.loggedIn.set(loggedIn);
    }

    public String getUserID() {
        return UserID.get();
    }

    public SimpleStringProperty userIDProperty() {
        return UserID;
    }

    public void setUserID(String userID) {
        this.UserID.set(userID);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public boolean isLoggedIn() {
        return loggedIn.get();
    }

    public SimpleBooleanProperty loggedInProperty() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn.set(loggedIn);
    }
}
