package se2203b.assignments.adminapp;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

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

    public ArrayList<Pair<Item, Integer>> getItems() {
        ArrayList<Pair<Item, Integer>> returnItems = new ArrayList<>();
        Pair<Item, Integer> item = new Pair<>(null, null);
        for (int i = 0; i < items.size(); i ++){
            item.setKey(getItems().get(i).getKey());
            item.setValue(getItems().get(i).getValue());
            returnItems.add(item);
        }
        return returnItems;
    }

    public void setItems(ArrayList<Pair<Item, SimpleIntegerProperty>> items) {
        this.items = items;
    }

    public double getSubtotal() {
        return subtotal.get();
    }

    public SimpleDoubleProperty subtotalProperty() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal.set(subtotal);
    }

    public String getPaymentMethod() {
        return paymentMethod.get();
    }

    public SimpleStringProperty paymentMethodProperty() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod.set(paymentMethod);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
