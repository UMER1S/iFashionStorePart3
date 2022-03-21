package se2203b.assignments.adminapp;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddCategoryController {

    private CategoryAdapter categoryAdapter;

    public void setModel(CategoryAdapter categoryAdapter) {
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
    Button cancelBtn, submitCatBtn, submitSubCatBtn;

    @FXML
    ComboBox<String> catCmbo;

    @FXML
    Label reqCatLbl, reqCatLbl2, reqSubCatLbl;

    @FXML
    TextField catTxt, subCatTxt;

    @FXML
    private void addCategory() {

        String cat = catTxt.getText();
        if (cat.equals("")) { //if no selection
            reqCatLbl.setVisible(true); //show required field
            return;
        }

        reqCatLbl.setVisible(false);
        //add category
        try {
            categoryAdapter.addCategory(cat, null);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        //update the category list on the page
        try {
            catCmbo.setItems(FXCollections.observableArrayList(categoryAdapter.getCategories()));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void addSubCategory() {
        boolean error = false;
        String cat = catCmbo.getSelectionModel().getSelectedItem(), subCat = subCatTxt.getText();
        if (cat == null) { //if no selection
            reqCatLbl2.setVisible(true); //show required field
            error = true;
        }
        if (subCat.equals("")) {
            reqSubCatLbl.setVisible(true);
            error = true;
        }
        if(error) { return; }
        reqCatLbl2.setVisible(false); //show required field
        reqSubCatLbl.setVisible(false);

        //add category
        try {
            categoryAdapter.addCategory(cat, subCat);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void exit() {
        // Get current stage reference
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        // Close stage
        stage.close();
    }


}
