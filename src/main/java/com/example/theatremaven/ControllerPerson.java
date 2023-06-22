package com.example.theatremaven;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

import com.example.theatremaven.entity.Performance;
import com.example.theatremaven.entity.Person;
import com.example.theatremaven.entity.Piece;
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

public class ControllerPerson {

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
    private TableColumn<Person, Date> col_birthdate;

    @FXML
    private TableColumn<Person, String> col_full_name;

    @FXML
    private TableColumn<Person, String> col_gender;

    @FXML
    private TableColumn<Person, Long> col_passport_data;

    @FXML
    private TextField tf_birthdate;

    @FXML
    private TextField tf_full_name;

    @FXML
    private TextField tf_gender;

    @FXML
    private TextField tf_passport_data;

    @FXML
    private TableView<Person> tv;

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
    public ObservableList<Person> getPersonList(){
        ObservableList<Person> personList = FXCollections.observableArrayList();
        Connection conn = connection;
        String query = "SELECT * FROM person";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Person person;
            while (rs.next()){
                person = new Person(rs.getLong("passport_data"), rs.getString("gender"), rs.getString("full_name"), rs.getDate("birthdate"));
                personList.add(person);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return personList;
    }

    public void showPerson() {
        ObservableList<Person> list = getPersonList();

        col_passport_data.setCellValueFactory(new PropertyValueFactory<Person, Long>("passport_data"));
        col_gender.setCellValueFactory(new PropertyValueFactory<Person, String>("gender"));
        col_full_name.setCellValueFactory(new PropertyValueFactory<Person, String>("full_name"));
        col_birthdate.setCellValueFactory(new PropertyValueFactory<Person, Date>("birthdate"));

        tv.setItems(list);
    }

    private void insertRecord(){
        String query = "INSERT INTO person VALUES (" + tf_passport_data.getText() + ",'"
                + tf_gender.getText() + "','" + tf_full_name.getText() +"','" + tf_birthdate.getText() + "')";
        executeQuery(query);
        showPerson();
    }

    private void updateRecord (){
        String query = "UPDATE person SET gender = '" + tf_gender.getText()
                + "', full_name = '" + tf_full_name.getText() + "', birthdate = '" + tf_birthdate.getText() + "' WHERE passport_data = " + tf_passport_data.getText() + "";
        executeQuery(query);
        showPerson();
    }

    private void deleteButton(){
        String query = "DELETE FROM person WHERE passport_data = " + tf_passport_data.getText() + "";
        executeQuery(query);
        showPerson();
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
        Person person = tv.getSelectionModel().getSelectedItem();

        tf_passport_data.setText("" + person.getPassport_data());
        tf_gender.setText(person.getGender());
        tf_full_name.setText(person.getFull_name());
        tf_passport_data.setText("" + person.getPassport_data());

    }

    @FXML
    private TextField tf_search;

    private void search() {
        String searchText = tf_search.getText();
        ObservableList<Person> searchResults = FXCollections.observableArrayList();

        for (Person person : tv.getItems()) {
            if (String.valueOf(person.getPassport_data()).contains(searchText) || String.valueOf(person.getGender()).contains(searchText)
                    || String.valueOf(person.getFull_name()).contains(searchText) || String.valueOf(person.getBirthdate()).contains(searchText)) {
                searchResults.add(person);
            }
        }
        tv.setItems(searchResults);
    }

    @FXML
    void initialize() {
        showPerson();
        tf_search.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                search();
            }
        });
    }
}
