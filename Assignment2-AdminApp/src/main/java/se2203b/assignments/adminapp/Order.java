package se2203b.assignments.adminapp;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.util.Pair;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Order {

    private ArrayList<Pair<Item, SimpleIntegerProperty>> items;
    private SimpleDoubleProperty subtotal;
    private SimpleStringProperty paymentMethod;
    private User user;



    public Order(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            //TODO: add data from sql results set to correct fields
        }
    }

    public Order(ArrayList<Pair<Item, SimpleIntegerProperty>> items, double subtotal, String paymentMethod, User user) {
        this.items = items;
        this.subtotal.set(subtotal);
        this.paymentMethod.set(paymentMethod);
        this.user = user;
    }
}
