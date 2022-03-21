package se2203b.assignments.adminapp;

import javafx.beans.property.SimpleStringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CommentsFeedback {

    private SimpleStringProperty text;
    private SimpleStringProperty userID;
    private Date date;

    public CommentsFeedback(String text, String user, Date date) {
        this.text.set(text);
        this.userID.set(user);
        this.date = date;
    }

    public String getText() {
        return text.get();
    }

    public SimpleStringProperty textProperty() {
        return text;
    }

    public void setText(String text) {
        this.text.set(text);
    }

    public String getUserID() {
        return userID.get();
    }

    public SimpleStringProperty userIDProperty() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID.set(userID);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
