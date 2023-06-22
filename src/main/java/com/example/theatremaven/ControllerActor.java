package com.example.theatremaven;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import com.example.theatremaven.entity.Act;
import com.example.theatremaven.entity.Actor;
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

public class ControllerActor {

    DatabaseManager databaseManager = new DatabaseManager();
    Connection connection = databaseManager.getConnection();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_role;

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
    private TableColumn<Actor, Short> col_career_start_year;

    @FXML
    private TableColumn<Actor, Short> col_height;

    @FXML
    private TableColumn<Actor, Long> col_passport_data;

    @FXML
    private TableColumn<Actor, Short> col_personnel_number;

    @FXML
    private TableColumn<Actor, Short> col_weight;

    @FXML
    private TextField tf_career_start_year;

    @FXML
    private TextField tf_height;

    @FXML
    private TextField tf_passport_data;

    @FXML
    private TextField tf_personnel_number;

    @FXML
    private TextField tf_weight;



    @FXML
    private TableView<Actor> tv;

    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == btn_insert) {
            insertRecord();
        } else if (event.getSource() == btn_update) {
            updateRecord();
        } else if (event.getSource() == btn_delete) {
            deleteButton();
        } else if (event.getSource() == btn_act) {//1
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

    public ObservableList<Actor> getActorList(){
        ObservableList<Actor> actorList = FXCollections.observableArrayList();
        Connection conn = connection;
        String query = "SELECT * FROM actor";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Actor actor;
            while (rs.next()){
                actor = new Actor(rs.getShort("personnel_number"), rs.getLong("passport_data"), rs.getShort("height"), rs.getShort("weight"), rs.getShort("career_start_year"));
                actorList.add(actor);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return actorList;
    }

    public void showActor() {
        ObservableList<Actor> list = getActorList();

        col_personnel_number.setCellValueFactory(new PropertyValueFactory<Actor, Short>("personnel_number"));
        col_passport_data.setCellValueFactory(new PropertyValueFactory<Actor, Long>("passport_data"));
        col_height.setCellValueFactory(new PropertyValueFactory<Actor, Short>("height"));
        col_weight.setCellValueFactory((new PropertyValueFactory<Actor, Short>("weight")));
        col_career_start_year.setCellValueFactory(new PropertyValueFactory<Actor, Short>("career_start_year"));

        tv.setItems(list);
    }

    private void insertRecord(){
        String query = "INSERT INTO actor VALUES (" + tf_personnel_number.getText() + ","
                + tf_passport_data.getText() + "," + tf_height.getText() + "," + tf_weight.getText() + "," + tf_career_start_year.getText() + ")";
        executeQuery(query);
        showActor();
    }

    private void updateRecord (){
        String query = "UPDATE actor SET passport_data = " + tf_passport_data.getText()
                + ", height = " + tf_height.getText() + ", weight = " + tf_weight.getText() + ", career_start_year = " + tf_career_start_year + " WHERE personnel_number = " + tf_personnel_number.getText() + "";
        executeQuery(query);
        showActor();
    }

    private void deleteButton(){
        String query = "DELETE FROM actor WHERE personnel_number = " + tf_personnel_number.getText() + "";
        executeQuery(query);
        showActor();
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
        Actor actor = tv.getSelectionModel().getSelectedItem();
        tf_personnel_number.setText("" + actor.getPersonnel_number());
        tf_passport_data.setText("" + actor.getPassport_data());
        tf_height.setText("" + actor.getHeight());
        tf_weight.setText("" + actor.getWeight());
        tf_career_start_year.setText("" + actor.getCareer_start_year());
    }

    @FXML
    private TextField tf_search;

    private void searchActor() {
        String searchText = tf_search.getText();
        ObservableList<Actor> searchResults = FXCollections.observableArrayList();

        for (Actor actor : tv.getItems()) {
            if (String.valueOf(actor.getPersonnel_number()).contains(searchText) || String.valueOf(actor.getPassport_data()).contains(searchText)
                    || String.valueOf(actor.getHeight()).contains(searchText) || String.valueOf(actor.getWeight()).contains(searchText) || String.valueOf(actor.getCareer_start_year()).contains(searchText)) {
                searchResults.add(actor);
            }
        }
        tv.setItems(searchResults);
    }

    @FXML
    void initialize() {
        showActor();
        tf_search.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                searchActor();
            }
        });
    }
}
