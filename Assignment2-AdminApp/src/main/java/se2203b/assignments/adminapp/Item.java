package se2203b.assignments.adminapp;

import javafx.beans.property.*;

import java.util.ArrayList;

import java.sql.*;


public class Item
{
    private SimpleStringProperty                      name;
    private SimpleStringProperty                      itemID;
    private SimpleStringProperty                      department;
    private ArrayList<Category>                       category;
    private SimpleStringProperty                      brand;
    private SimpleStringProperty                      description;
    private SimpleDoubleProperty                      price;
    private ArrayList<SimpleStringProperty>           sizes;
    private SimpleIntegerProperty                     stock;
    private ArrayList<CommentsFeedback>               comments;



    public Item(ResultSet resultSet) throws SQLException {
        while(resultSet.next()){
            //TODO: add data from sql results set to correct fields
        }

    }

    public Item(String name, String itemID, String department, ArrayList<Category> category, String brand, String description, Double price, ArrayList<String> sizes, Integer stock, ArrayList<CommentsFeedback> comments) {
        this.name.set(name);
        this.itemID.set(itemID);
        this.department.set(department);
        this.category = category;
        this.brand.set(brand);
        this.description.set(description);
        this.price.set(price);
        this.stock.set(stock);
        this.comments = comments;
        for (String size : sizes) this.sizes.add(new SimpleStringProperty(size));
    }

    public String getItemID() {
        return itemID.get();
    }

    public SimpleStringProperty itemIDProperty() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID.set(itemID);
    }

    public String getDepartment() {
        return department.get();
    }

    public SimpleStringProperty departmentProperty() {
        return department;
    }

    public void setDepartment(String department) {
        this.department.set(department);
    }

    public ArrayList<Category> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<Category> category) {
        this.category = category;
    }

    public void addCategory(Category category) {
        this.category.add(category);
    }

    public void removeCategory(Category category) {
        this.category.remove(category);
    }

    public String getBrand() {
        return brand.get();
    }

    public SimpleStringProperty brandProperty() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public ArrayList<SimpleStringProperty> getSizes() {
        return sizes;
    }

    public void setSizes(ArrayList<SimpleStringProperty> sizes) {
        this.sizes = sizes;
    }

    public void addSize(String size) {
        this.sizes.add(new SimpleStringProperty(size));
    }

    public void removeSize(String size) {
        this.sizes.remove(new SimpleStringProperty(size));
    }

    public int getStock() {
        return stock.get();
    }

    public SimpleIntegerProperty stockProperty() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock.set(stock);
    }

    public ArrayList<CommentsFeedback> getComments() {
        return comments;
    }

    public void setComments(ArrayList<CommentsFeedback> comments) {
        this.comments = comments;
    }

    public void addComment(CommentsFeedback comment){
        this.comments.add(comment);
    }

    public void removeComment(CommentsFeedback comment){
        this.comments.remove(comment);
    }
}
