package com.example.theatremaven;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.example.theatremaven.entity.Rent;
import com.example.theatremaven.entity.Role;
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

public class ControllerRole {

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
    private TableColumn<Role, Short> col_id_performance;

    @FXML
    private TableColumn<Role, Short> col_id_role;

    @FXML
    private TableColumn<Role, String> col_title;

    @FXML
    private TextField tf_id_performance;

    @FXML
    private TextField tf_id_role;

    @FXML
    private TextField tf_title;

    @FXML
    private TableView<Role> tv;

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
    public ObservableList<Role> getRoleList(){
        ObservableList<Role> roleList = FXCollections.observableArrayList();
        Connection conn = connection;
        String query = "SELECT * FROM role";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Role role;
            while (rs.next()){
                role = new Role(rs.getShort("role_id"), rs.getShort("performance_id"), rs.getString("name"));
                roleList.add(role);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return roleList;
    }

    public void showRole() {
        ObservableList<Role> list = getRoleList();

        col_id_role.setCellValueFactory(new PropertyValueFactory<Role, Short>("role_id"));
        col_id_performance.setCellValueFactory(new PropertyValueFactory<Role, Short>("performance_id"));
        col_title.setCellValueFactory(new PropertyValueFactory<Role, String>("name"));

        tv.setItems(list);
    }

    private void insertRecord(){
        String query = "INSERT INTO role VALUES (" + tf_id_role.getText() + ","
                + tf_id_performance + ",'" + tf_title + "')";
        executeQuery(query);
        showRole();
    }

    private void updateRecord (){
        String query = "UPDATE role SET performance_id = " + tf_id_performance.getText()
                + ", name = '" + tf_title.getText() + "' WHERE role_id = " + tf_id_role.getText() + "";
        executeQuery(query);
        showRole();
    }

    private void deleteButton(){
        String query = "DELETE FROM role WHERE role_id = " + tf_id_role.getText() + "";
        executeQuery(query);
        showRole();
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
        Role role = tv.getSelectionModel().getSelectedItem();

        tf_id_role.setText("" + role.getRole_id());
        tf_id_performance.setText("" + role.getPerformance_id());
        tf_title.setText(role.getName());

    }
    @FXML
    private TextField tf_search;

    private void search() {
        String searchText = tf_search.getText();
        ObservableList<Role> searchResults = FXCollections.observableArrayList();

        for (Role role : tv.getItems()) {
            if (String.valueOf(role.getRole_id()).contains(searchText) || String.valueOf(role.getPerformance_id()).contains(searchText)
                    || String.valueOf(role.getName()).contains(searchText)) {
                searchResults.add(role);
            }
        }
        tv.setItems(searchResults);
    }

    @FXML
    void initialize() {
        showRole();
        tf_search.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                search();
            }
        });
    }
}
