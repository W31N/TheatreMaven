package com.example.theatremaven;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.example.theatremaven.entity.ContractRoleAct;
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

public class ControllerRoleAct {

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
    private TableColumn<ContractRoleAct, Short> col_id_act;

    @FXML
    private TableColumn<ContractRoleAct, Short> col_id_role;

    @FXML
    private TableColumn<ContractRoleAct, Short> col_id_role_act;

    @FXML
    private TextField tf_id_act;

    @FXML
    private TextField tf_id_role;

    @FXML
    private TextField tf_id_role_act;

    @FXML
    private TableView<ContractRoleAct> tv;

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
    public ObservableList<ContractRoleAct> getRoleActList(){
        ObservableList<ContractRoleAct> roleActList = FXCollections.observableArrayList();
        Connection conn = connection;
        String query = "SELECT * FROM contract_role_act";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            ContractRoleAct contractRoleAct;
            while (rs.next()){
                contractRoleAct = new ContractRoleAct(rs.getShort("role_act_id"), rs.getShort("act_id"), rs.getShort("role_id"));
                roleActList.add(contractRoleAct);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return roleActList;
    }

    public void showContractRoleAct() {
        ObservableList<ContractRoleAct> list = getRoleActList();

        col_id_role_act.setCellValueFactory(new PropertyValueFactory<ContractRoleAct, Short>("role_act_id"));
        col_id_act.setCellValueFactory(new PropertyValueFactory<ContractRoleAct, Short>("act_id"));
        col_id_role.setCellValueFactory(new PropertyValueFactory<ContractRoleAct, Short>("role_id"));

        tv.setItems(list);
    }

    private void insertRecord(){
        String query = "INSERT INTO contract_role_act VALUES (" + tf_id_role_act.getText() + ","
                + tf_id_act.getText() + "," + tf_id_role.getText() + ")";
        executeQuery(query);
        showContractRoleAct();
    }

    private void updateRecord (){
        String query = "UPDATE contract_role_act SET act_id = " + tf_id_act.getText()
                + ", role_id = " + tf_id_role.getText() + " WHERE role_act_id = " + tf_id_role_act.getText() + "";
        executeQuery(query);
        showContractRoleAct();
    }

    private void deleteButton(){
        String query = "DELETE FROM contract_role_act WHERE role_act_id = " + tf_id_role_act.getText() + "";
        executeQuery(query);
        showContractRoleAct();
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
        ContractRoleAct contractRoleAct = tv.getSelectionModel().getSelectedItem();

        tf_id_role_act.setText("" + contractRoleAct.getRole_act_id());
        tf_id_act.setText("" + contractRoleAct.getAct_id());
        tf_id_role.setText("" + contractRoleAct.getRole_id());

    }

    @FXML
    private TextField tf_search;

    private void search() {
        String searchText = tf_search.getText();
        ObservableList<ContractRoleAct> searchResults = FXCollections.observableArrayList();

        for (ContractRoleAct contractRoleAct : tv.getItems()) {
            if (String.valueOf(contractRoleAct.getRole_act_id()).contains(searchText) || String.valueOf(contractRoleAct.getAct_id()).contains(searchText)
                    || String.valueOf(contractRoleAct.getRole_id()).contains(searchText)) {
                searchResults.add(contractRoleAct);
            }
        }
        tv.setItems(searchResults);
    }

    @FXML
    void initialize() {
        showContractRoleAct();
        tf_search.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                search();
            }
        });
    }

}
