package se2203b.assignments.adminapp;

import javafx.beans.property.SimpleStringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Query {
    private SimpleStringProperty text;
    private User user;
    private Date date;

    public Query(String text, User user, Date date) {
        this.text.set(text);
        this.user = user;
        this.date = date;
    }

    public Query(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            //TODO: add data from sql results set to correct fields
        }
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
