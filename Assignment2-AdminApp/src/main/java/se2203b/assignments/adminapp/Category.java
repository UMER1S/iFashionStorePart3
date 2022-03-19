package se2203b.assignments.adminapp;

import javafx.beans.property.SimpleStringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Category {

    private SimpleStringProperty categoryName;
    private ArrayList<SimpleStringProperty> subCategory;



    public Category(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            //TODO: add data from sql results set to correct fields
        }
    }

    public Category(String categoryName, ArrayList<String> subCategory) {
        this.categoryName.set(categoryName);
        for (String subcat : subCategory) this.subCategory.add(new SimpleStringProperty(subcat));
    }

    public String getCategoryName() {
        return categoryName.get();
    }

    public SimpleStringProperty categoryNameProperty() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName.set(categoryName);
    }

    public ArrayList<SimpleStringProperty> getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(ArrayList<SimpleStringProperty> subCategory) {
        this.subCategory = subCategory;
    }

    public void addSubcategory(String subcategory){
        this.subCategory.add(new SimpleStringProperty(subcategory));
    }

    public void removeSubcategory(String subcategory){
        this.subCategory.remove(new SimpleStringProperty(subcategory));
    }
}
