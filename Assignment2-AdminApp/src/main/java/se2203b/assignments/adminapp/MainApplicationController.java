package se2203b.assignments.adminapp;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 *
 * @author Abdelkader Ouda
 */
public class MainApplicationController implements Initializable {

    private Connection conn;
    private CommentsAdapter commentsAdapter;
    private OrderItemsAdapter orderItemsAdapter;
    private OrderAdapter orderAdapter;
    private UserAdapter userAdapter;
    private ItemAdapter itemAdapter;
    private CategoryAdapter categoryAdapter;

    @FXML
    private MenuBar mainMenu;

    @FXML
    MenuItem addItemMenu;

    @FXML
    public void showAbout() throws Exception {
        // load the fxml file (the UI elements)
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplicationController.class.getResource("About-view.fxml"));
        // create the root node
        Parent About =  fxmlLoader.load();
        // create new stage
        Stage stage = new Stage();
        // add the about's UI elements to the stage
        stage.setScene(new Scene(About));
        // add icon to the About window
        stage.getIcons().add(new Image("file:src/main/resources/se2203b/assignments/adminapp/WesternLogo.png"));
        stage.setTitle("About Us");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    public void showAddItem() throws Exception {

        itemAdapter = new ItemAdapter(conn, false);
        categoryAdapter = new CategoryAdapter(conn, false);

        // load the fxml file (the UI elements)
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplicationController.class.getResource("AddItem-view.fxml"));
        // create the root node
        Parent AddItem = (Parent) fxmlLoader.load();
        AddItemController addItemController = (AddItemController) fxmlLoader.getController();
        addItemController.setModel(itemAdapter, categoryAdapter);
        // create new stage
        Stage stage = new Stage();
        // add the AddItem's UI elements to the stage
        stage.setScene(new Scene(AddItem));
        // add icon to the About window
        stage.getIcons().add(new Image("file:src/main/resources/se2203b/assignments/adminapp/WesternLogo.png"));
        stage.setTitle("Add Item");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    public void showAddCategory() throws Exception {

        categoryAdapter = new CategoryAdapter(conn, false);

        // load the fxml file (the UI elements)
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplicationController.class.getResource("AddCategory-view.fxml"));
        // create the root node
        Parent AddCategory = (Parent) fxmlLoader.load();
        AddCategoryController addCategoryController = (AddCategoryController) fxmlLoader.getController();
        addCategoryController.setModel(categoryAdapter);
        // create new stage
        Stage stage = new Stage();
        // add the AddItem's UI elements to the stage
        stage.setScene(new Scene(AddCategory));
        // add icon to the About window
        stage.getIcons().add(new Image("file:src/main/resources/se2203b/assignments/adminapp/WesternLogo.png"));
        stage.setTitle("Add Category");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    public void showEditItem() throws Exception {

        itemAdapter = new ItemAdapter(conn, false);
        categoryAdapter = new CategoryAdapter(conn, false);

        // load the fxml file (the UI elements)
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplicationController.class.getResource("EditItem-view.fxml"));
        // create the root node
        Parent EditItem = (Parent) fxmlLoader.load();
        EditItemController editItemController = (EditItemController) fxmlLoader.getController();
        editItemController.setModel(itemAdapter,categoryAdapter);
        // create new stage
        Stage stage = new Stage();
        // add the AddItem's UI elements to the stage
        stage.setScene(new Scene(EditItem));
        // add icon to the About window
        stage.getIcons().add(new Image("file:src/main/resources/se2203b/assignments/adminapp/WesternLogo.png"));
        stage.setTitle("Edit Item");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void exit() {
        // Get current stage reference
        Stage stage = (Stage) mainMenu.getScene().getWindow();
        // Close stage
        stage.close();
    }

    private void displayAlert(String msg) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Alert.fxml"));
            Parent ERROR = loader.load();
            AlertController controller = (AlertController) loader.getController();

            Scene scene = new Scene(ERROR);
            Stage stage = new Stage();
            stage.setScene(scene);

            stage.getIcons().add(new Image("file:src/main/resources/se2203b/lab5/tennisballgames/WesternLogo.png"));
            controller.setAlertText(msg);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException ex1) {

        }
    }

    private void resetDB() {
        //create new tables
        try {
            commentsAdapter = new CommentsAdapter(conn);
        } catch (SQLException e) {
            displayAlert(e.getMessage());
        }
        try {
            orderItemsAdapter = new OrderItemsAdapter(conn);
        } catch (SQLException e) {
            displayAlert(e.getMessage());
        }
        try {
            orderAdapter = new OrderAdapter(conn);
        } catch (SQLException e) {
            displayAlert(e.getMessage());
        }
        try {
            userAdapter = new UserAdapter(conn);
        } catch (SQLException e) {
            displayAlert(e.getMessage());
        }
        try {
            itemAdapter = new ItemAdapter(conn, false);
        } catch (SQLException e) {
            displayAlert(e.getMessage());
        }
        try {
            categoryAdapter = new CategoryAdapter(conn, false);
        } catch (SQLException e) {
            displayAlert(e.getMessage());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try{
            String DB_URL = "jdbc:derby:iFashionStore;create=true";
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException ex){
            displayAlert(ex.getMessage());
        }

        resetDB();




    }

}
