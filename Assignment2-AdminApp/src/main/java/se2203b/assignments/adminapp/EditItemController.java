package se2203b.assignments.adminapp;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class EditItemController {

    private ItemAdapter itemAdapter;
    private CategoryAdapter categoryAdapter;
    private ArrayList<Item> itemList;
    private ArrayList<String> itemNames;

    public void setModel(ItemAdapter itemAdapter, CategoryAdapter categoryAdapter) {
        this.itemAdapter = itemAdapter;
        this.categoryAdapter = categoryAdapter;

        //have to load this now, cannot do it in initializable as the models have yet to be passed through
        updateItemList();
    }

    @FXML
    Button removeBtn, submitBtn;

    @FXML
    ComboBox<String> catCmbo, subCatCmbo, deptCmbo, itemCmbo;

    @FXML
    Label reqBrandLbl, reqCatLbl, reqSubCatLbl, reqDeptLbl, reqNameLbl, reqPriceLbl, reqQuantityLbl;

    @FXML
    TextArea descTxt;

    @FXML
    TextField brandTxt, nameTxt, priceTxt, quantityTxt;

    @FXML
    Label itemIDLbl;

    @FXML
    private void updateFields() { //update all fields
        //get item
        Item item = itemList.get(itemCmbo.getSelectionModel().getSelectedIndex());

        //update fields
        //category
        try {
            catCmbo.setItems(FXCollections.observableArrayList(categoryAdapter.getCategories()));
            catCmbo.getSelectionModel().select(item.getCategory());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        //subcategory
        try {
            subCatCmbo.setItems(FXCollections.observableArrayList(categoryAdapter.getSubCategories(item.getSubCategory())));
            subCatCmbo.getSelectionModel().select(item.getSubCategory());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        //department, brand, price, quantity, name, and description
        deptCmbo.setItems(FXCollections.observableArrayList("Mens", "Womens", "Kids"));
        deptCmbo.getSelectionModel().select(item.getDepartment());
        brandTxt.setText(item.getBrand());
        priceTxt.setText(String.format( "%.2f", item.getPrice()));
        quantityTxt.setText(String.format("%d", item.getStock()));
        nameTxt.setText(item.getName());
        descTxt.setText(item.getDescription());
        itemIDLbl.setText(String.format("%d", item.getItemID()));
        updateSubCategories();

    }

    @FXML //updates subcategories field
    private void updateSubCategories() {
        String selection = catCmbo.getSelectionModel().getSelectedItem();

        try {
            subCatCmbo.setItems(FXCollections.observableArrayList(categoryAdapter.getSubCategories(selection)));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @FXML //updates the item in the database with new data
    public void updateItem() throws SQLException {
        Item item = itemList.get(itemCmbo.getSelectionModel().getSelectedIndex());

        item.setName(nameTxt.getText());
        item.setCategory(catCmbo.getSelectionModel().getSelectedItem());
        item.setSubCategory(subCatCmbo.getSelectionModel().getSelectedItem());
        item.setBrand(brandTxt.getText());
        item.setDepartment(deptCmbo.getSelectionModel().getSelectedItem());
        item.setPrice(Double.parseDouble(priceTxt.getText()));
        item.setStock(Integer.parseInt(quantityTxt.getText()));
        item.setDescription(descTxt.getText());

        itemAdapter.updateItem(item.getItemID(), item.getName(), item.getCategory(), item.getSubCategory(), item.getBrand(), item.getDepartment(), item.getPrice(), item.getStock(), item.getDescription());
    }

    @FXML //removes item from database
    public void removeItem() throws SQLException {
        Item item = itemList.get(itemCmbo.getSelectionModel().getSelectedIndex());

        itemAdapter.removeItem(item.getItemID());

        itemList.remove(item);
        updateItemList();
        itemCmbo.getSelectionModel().select(0);
    }

    private void updateItemList() {
        try {
            itemList = itemAdapter.getAllItems();
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        itemNames = new ArrayList<>();
        for (Item item : itemList){
            itemNames.add(item.getName());
        }
        if(itemNames == null) { itemNames = new ArrayList<String>(Arrays.asList("No Items")); }
        //initialize item list
        itemCmbo.setItems(FXCollections.observableArrayList(itemNames));
    }
}
