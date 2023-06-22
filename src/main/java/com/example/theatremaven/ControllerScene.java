package com.example.theatremaven;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.example.theatremaven.entity.Role;
import com.example.theatremaven.entity.Ticket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerScene {

    DatabaseManager databaseManager = new DatabaseManager();
    Connection connection = databaseManager.getConnection();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_act;

    @FXML
    private Button btn_actor;

    @FXML
    private Button btn_contract_role_act;

    @FXML
    private Button btn_contract_role_actor;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_insert;

    @FXML
    private Button btn_performance;

    @FXML
    private Button btn_person;

    @FXML
    private Button btn_piece;

    @FXML
    private Button btn_rent;

    @FXML
    private Button btn_role;

    @FXML
    private Button btn_scene;

    @FXML
    private Button btn_theatre;

    @FXML
    private Button btn_ticket;

    @FXML
    private Button btn_update;

    @FXML
    private Button btn_viewer;

    @FXML
    private TableColumn<com.example.theatremaven.entity.Scene, String> col_address;

    @FXML
    private TableColumn<com.example.theatremaven.entity.Scene, Short> col_capacity;

    @FXML
    private TableColumn<com.example.theatremaven.entity.Scene, Short> col_height;

    @FXML
    private TableColumn<com.example.theatremaven.entity.Scene, Short> col_id_scene;

    @FXML
    private TableColumn<com.example.theatremaven.entity.Scene, Short> col_square;

    @FXML
    private TableColumn<com.example.theatremaven.entity.Scene, String> col_title;

    @FXML
    private TableColumn<com.example.theatremaven.entity.Scene, String> col_type;

    @FXML
    private TextField tf_address;

    @FXML
    private TextField tf_capacity;

    @FXML
    private TextField tf_height;

    @FXML
    private TextField tf_id_scene;

    @FXML
    private TextField tf_square;

    @FXML
    private TextField tf_title;

    @FXML
    private TextField tf_type;

    @FXML
    private TableView<com.example.theatremaven.entity.Scene> tv;

    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == btn_insert) {
            insertRecord();
        } else if (event.getSource() == btn_update) {
            updateRecord();
        } else if (event.getSource() == btn_delete) {
            deleteButton();
        }else if (event.getSource() == btn_act) {//1
            FXMLLoader loader = new FXMLLoader(getClass().getResource("act.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btn_act.getScene().getWindow();
            stage.setScene(new Scene(root));
        }else if (event.getSource() == btn_actor){//2
            FXMLLoader loader = new FXMLLoader(getClass().getResource("actor.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btn_actor.getScene().getWindow();
            stage.setScene(new Scene(root));
        }else if (event.getSource() == btn_theatre){//3
            FXMLLoader loader = new FXMLLoader(getClass().getResource("theatre.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btn_theatre.getScene().getWindow();
            stage.setScene(new Scene(root));
        }else if (event.getSource() == btn_performance){//4
            FXMLLoader loader = new FXMLLoader(getClass().getResource("performance.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btn_performance.getScene().getWindow();
            stage.setScene(new Scene(root));
        }else if (event.getSource() == btn_rent){//5
            FXMLLoader loader = new FXMLLoader(getClass().getResource("rent.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btn_rent.getScene().getWindow();
            stage.setScene(new Scene(root));
        }else if (event.getSource() == btn_person){//6
            FXMLLoader loader = new FXMLLoader(getClass().getResource("person.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btn_person.getScene().getWindow();
            stage.setScene(new Scene(root));
        }else if (event.getSource() == btn_piece){//7
            FXMLLoader loader = new FXMLLoader(getClass().getResource("piece.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btn_piece.getScene().getWindow();
            stage.setScene(new Scene(root));
        }else if (event.getSource() == btn_role){//8
            FXMLLoader loader = new FXMLLoader(getClass().getResource("role.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btn_role.getScene().getWindow();
            stage.setScene(new Scene(root));
        }else if (event.getSource() == btn_scene){//9
            FXMLLoader loader = new FXMLLoader(getClass().getResource("scene.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btn_scene.getScene().getWindow();
            stage.setScene(new Scene(root));
        }else if (event.getSource() == btn_contract_role_act){//10
            FXMLLoader loader = new FXMLLoader(getClass().getResource("role_act.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btn_contract_role_act.getScene().getWindow();
            stage.setScene(new Scene(root));
        }else if (event.getSource() == btn_contract_role_actor){//11
            FXMLLoader loader = new FXMLLoader(getClass().getResource("role_actor.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btn_contract_role_actor.getScene().getWindow();
            stage.setScene(new Scene(root));
        }else if (event.getSource() == btn_ticket){//12
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ticket.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btn_ticket.getScene().getWindow();
            stage.setScene(new Scene(root));
        }else if (event.getSource() == btn_viewer){//13
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewer.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btn_viewer.getScene().getWindow();
            stage.setScene(new Scene(root));
        }else if (event.getSource() == btn_sql_query){
            openSQLQueryWindow();
        }
    }
    @FXML
    private Button btn_sql_query;
    private void openSQLQueryWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sql_query_window.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) btn_sql_query.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public ObservableList<com.example.theatremaven.entity.Scene> getSceneList(){
        ObservableList<com.example.theatremaven.entity.Scene> sceneList = FXCollections.observableArrayList();
        Connection conn = connection;
        String query = "SELECT * FROM scene";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            com.example.theatremaven.entity.Scene scene;
            while (rs.next()){
                scene = new com.example.theatremaven.entity.Scene(rs.getShort("scene_id"), rs.getString("address"), rs.getShort("capacity"), rs.getShort("square"), rs.getShort("height"), rs.getString("type"), rs.getString("title"));
                sceneList.add(scene);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return sceneList;
    }

    public void showScene() {
        ObservableList<com.example.theatremaven.entity.Scene> list = getSceneList();

        col_id_scene.setCellValueFactory(new PropertyValueFactory<com.example.theatremaven.entity.Scene, Short>("scene_id"));
        col_address.setCellValueFactory(new PropertyValueFactory<com.example.theatremaven.entity.Scene, String>("address"));
        col_capacity.setCellValueFactory(new PropertyValueFactory<com.example.theatremaven.entity.Scene, Short>("capacity"));
        col_square.setCellValueFactory(new PropertyValueFactory<com.example.theatremaven.entity.Scene, Short>("square"));
        col_height.setCellValueFactory(new PropertyValueFactory<com.example.theatremaven.entity.Scene, Short>("height"));
        col_type.setCellValueFactory(new PropertyValueFactory<com.example.theatremaven.entity.Scene, String>("type"));
        col_title.setCellValueFactory(new PropertyValueFactory<com.example.theatremaven.entity.Scene, String>("title"));

        tv.setItems(list);
    }

    private void insertRecord(){
        String query = "INSERT INTO scene VALUES (" + tf_id_scene.getText() + ",'"
                + tf_address.getText() + "'," + tf_capacity + "," + tf_square.getText() + "," + tf_height + ",'" + tf_type + "','" + tf_title + "')";
        executeQuery(query);
        showScene();
    }

    private void updateRecord (){
        String query = "UPDATE scene SET address = '" + tf_address.getText()
                + "', capacity = " + tf_capacity.getText() + ", square = " + tf_square.getText() + ", height = " + tf_height + " , type = '" + tf_type + "', title = '" + tf_title +   "' WHERE scene_id = " + tf_id_scene.getText() + "";
        executeQuery(query);
        showScene();
    }

    private void deleteButton(){
        String query = "DELETE FROM scene WHERE scene_id = " + tf_id_scene.getText() + "";
        executeQuery(query);
        showScene();
    }

    private void executeQuery(String query) {
        Connection conn = connection;
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Ошибка выполнения запроса");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            ex.printStackTrace();
        }
    }

    @FXML
    void handleMouseAction(MouseEvent event) {
        com.example.theatremaven.entity.Scene scene = tv.getSelectionModel().getSelectedItem();

        tf_id_scene.setText("" + scene.getScene_id());
        tf_address.setText(scene.getAddress());
        tf_capacity.setText("" + scene.getCapacity());
        tf_square.setText("" + scene.getSquare());
        tf_height.setText("" + scene.getHeight());
        tf_type.setText(scene.getType());
        tf_title.setText(scene.getTitle());

    }

    @FXML
    private TextField tf_search;

    private void search() {
        String searchText = tf_search.getText();
        ObservableList<com.example.theatremaven.entity.Scene> searchResults = FXCollections.observableArrayList();

        for (com.example.theatremaven.entity.Scene scene : tv.getItems()) {
            if (String.valueOf(scene.getScene_id()).contains(searchText) || String.valueOf(scene.getAddress()).contains(searchText)
                    || String.valueOf(scene.getCapacity()).contains(searchText) || String.valueOf(scene.getSquare()).contains(searchText)
                    || String.valueOf(scene.getHeight()).contains(searchText) || String.valueOf(scene.getType()).contains(searchText)
                    || String.valueOf(scene.getTitle()).contains(searchText)) {
                searchResults.add(scene);
            }
        }
        tv.setItems(searchResults);
    }

    @FXML
    void initialize() {
        showScene();
        tf_search.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                search();
            }
        });
    }
}

