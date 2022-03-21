package se2203b.assignments.adminapp;

import javafx.beans.property.*;

import java.util.ArrayList;

import java.sql.*;


public class Item
{
    private SimpleStringProperty                      name;
    private SimpleIntegerProperty                     itemID;
    private SimpleStringProperty                      category;
    private SimpleStringProperty                      subCategory;
    private SimpleStringProperty                      department;
    private SimpleStringProperty                      brand;
    private SimpleStringProperty                      description;
    private SimpleDoubleProperty                      price;
    private ArrayList<SimpleStringProperty>           sizes;
    private SimpleIntegerProperty                     stock;
    private ArrayList<CommentsFeedback>               comments;


    public Item(String name, int itemID, String department, String category, String subCategory, String brand, String description, Double price, Integer stock, ArrayList<CommentsFeedback> comments) {
        this.name = new SimpleStringProperty(name);
        this.itemID = new SimpleIntegerProperty(itemID);
        this.department = new SimpleStringProperty(department);
        this.category = new SimpleStringProperty(category);
        this.subCategory = new SimpleStringProperty(subCategory);
        this.brand = new SimpleStringProperty(brand);
        this.description = new SimpleStringProperty(description);
        this.price = new SimpleDoubleProperty(price);
        this.stock = new SimpleIntegerProperty(stock);
        this.comments = comments;
        //for (String size : sizes) this.sizes.add(new SimpleStringProperty(size));
    }

    // ALL THE GETTER/SETTER METHODS ARE BELOW

    public int getItemID() {
        return itemID.get();
    }

    public SimpleIntegerProperty itemIDProperty() {
        return itemID;
    }

    public String getName() {
        return name.get();
    }

    public void setItemID(int itemID) {
        this.itemID.set(itemID);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
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

    public String getCategory() {
        return category.get();
    }

    public SimpleStringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public String getSubCategory() {
        return subCategory.get();
    }

    public SimpleStringProperty subCategoryProperty() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory.set(subCategory);
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
