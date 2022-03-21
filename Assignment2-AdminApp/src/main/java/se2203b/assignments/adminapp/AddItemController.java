package se2203b.assignments.adminapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class AddItemController implements Initializable {

    private ItemAdapter itemAdapter;
    private CategoryAdapter categoryAdapter;

    public void setModel(ItemAdapter itemAdapter, CategoryAdapter categoryAdapter) {
        this.itemAdapter = itemAdapter;
        this.categoryAdapter = categoryAdapter;


        //have to load this now, cannot do it in initializable as the models have yet to be passed through
        try {
            catCmbo.setItems(FXCollections.observableArrayList(categoryAdapter.getCategories()));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @FXML
    Button closeBtn, submitBtn;

    @FXML
    ComboBox<String> catCmbo, subCatCmbo, deptCmbo;

    @FXML
    Label reqBrandLbl, reqCatLbl, reqSubCatLbl, reqDeptLbl, reqNameLbl, reqPriceLbl, reqQuantityLbl;

    @FXML
    TextArea descTxt;

    @FXML
    TextField brandTxt, nameTxt, priceTxt, quantityTxt;

    @FXML
    private void addItem() {
        boolean error = false;
        String name = nameTxt.getText(), brand = brandTxt.getText(), priceString = priceTxt.getText(), quantityString = quantityTxt.getText(),
        cat = catCmbo.getSelectionModel().getSelectedItem(), subcat = subCatCmbo.getSelectionModel().getSelectedItem(), dept = deptCmbo.getSelectionModel().getSelectedItem();
        if (name.equals("")) {
            error = true;
            reqNameLbl.setVisible(true);
        }
        if (brand.equals("")) {
            error = true;
            reqBrandLbl.setVisible(true);
        }
        if (priceString.equals("")) {
            error = true;
            reqPriceLbl.setVisible(true);
        }
        if (quantityString.equals("")) {
            error = true;
            reqQuantityLbl.setVisible(true);
        }
        if (cat == null) {
            error = true;
            reqCatLbl.setVisible(true);
        }
        if (subcat == null) {
            error = true;
            reqSubCatLbl.setVisible(true);
        }
        if (dept == null) {
            error = true;
            reqDeptLbl.setVisible(true);
        }
        if(error) { return; }
        reqNameLbl.setVisible(false);
        reqBrandLbl.setVisible(false);
        reqPriceLbl.setVisible(false);
        reqQuantityLbl.setVisible(false);

        double price = Double.parseDouble(priceString);
        int quantity = Integer.parseInt(quantityString);

        try {
            itemAdapter.addItem(name, cat, subcat, brand, dept, price, quantity, descTxt.getText());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


    }

    @FXML
    private void updateSubCategories() {
        String selection = catCmbo.getSelectionModel().getSelectedItem();

        try {
            subCatCmbo.setItems(FXCollections.observableArrayList(categoryAdapter.getSubCategories(selection)));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void exit() {
        // Get current stage reference
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        // Close stage
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        deptCmbo.setItems(FXCollections.observableArrayList("Mens", "Womens", "Kids"));

    }
}
