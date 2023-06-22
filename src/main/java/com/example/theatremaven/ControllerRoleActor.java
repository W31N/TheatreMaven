package com.example.theatremaven;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.example.theatremaven.entity.ContractRoleActor;
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

public class ControllerRoleActor {

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
    private TableColumn<ContractRoleActor, Short> col_id_actor;

    @FXML
    private TableColumn<ContractRoleActor, Short> col_id_role;

    @FXML
    private TableColumn<ContractRoleActor, Short> col_id_role_actor;

    @FXML
    private TextField tf_id_actor;

    @FXML
    private TextField tf_id_role;

    @FXML
    private TextField tf_id_role_actor;

    @FXML
    private TableView<ContractRoleActor> tv;

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

    public ObservableList<ContractRoleActor> getRoleActorList(){
        ObservableList<ContractRoleActor> roleActorList = FXCollections.observableArrayList();
        Connection conn = connection;
        String query = "SELECT * FROM contract_role_actor";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            ContractRoleActor contractRoleActor;
            while (rs.next()){
                contractRoleActor = new ContractRoleActor(rs.getShort("role_actor_id"), rs.getShort("personnel_number"), rs.getShort("role_id"));
                roleActorList.add(contractRoleActor);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return roleActorList;
    }

    public void showContractRoleActor() {
        ObservableList<ContractRoleActor> list = getRoleActorList();

        col_id_role_actor.setCellValueFactory(new PropertyValueFactory<ContractRoleActor, Short>("role_actor_id"));
        col_id_actor.setCellValueFactory(new PropertyValueFactory<ContractRoleActor, Short>("personnel_number"));
        col_id_role.setCellValueFactory(new PropertyValueFactory<ContractRoleActor, Short>("role_id"));

        tv.setItems(list);
    }

    private void insertRecord(){
        String query = "INSERT INTO contract_role_actor VALUES (" + tf_id_role_actor.getText() + ","
                + tf_id_actor.getText() + "," + tf_id_role.getText() + ")";
        executeQuery(query);
        showContractRoleActor();
    }

    private void updateRecord (){
        String query = "UPDATE contract_role_actor SET personnel_number = " + tf_id_actor.getText()
                + ", role_id = " + tf_id_role.getText() + " WHERE role_actor_id = " + tf_id_role_actor.getText() + "";
        executeQuery(query);
        showContractRoleActor();
    }

    private void deleteButton(){
        String query = "DELETE FROM contract_role_actor WHERE role_actor_id = " + tf_id_role_actor.getText() + "";
        executeQuery(query);
        showContractRoleActor();
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
        ContractRoleActor contractRoleActor = tv.getSelectionModel().getSelectedItem();

        tf_id_role_actor.setText("" + contractRoleActor.getRole_actor_id());
        tf_id_actor.setText("" + contractRoleActor.getPersonnel_number());
        tf_id_role.setText("" + contractRoleActor.getRole_id());

    }

    @FXML
    private TextField tf_search;

    private void search() {
        String searchText = tf_search.getText();
        ObservableList<ContractRoleActor> searchResults = FXCollections.observableArrayList();

        for (ContractRoleActor contractRoleActor : tv.getItems()) {
            if (String.valueOf(contractRoleActor.getRole_actor_id()).contains(searchText) || String.valueOf(contractRoleActor.getPersonnel_number()).contains(searchText)
                    || String.valueOf(contractRoleActor.getRole_id()).contains(searchText)) {
                searchResults.add(contractRoleActor);
            }
        }
        tv.setItems(searchResults);
    }

    @FXML
    void initialize() {
        showContractRoleActor();
        tf_search.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                search();
            }
        });
    }

}
