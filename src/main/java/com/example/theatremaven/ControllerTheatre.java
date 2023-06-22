package com.example.theatremaven;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.example.theatremaven.entity.Role;
import com.example.theatremaven.entity.Theatre;

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
import javafx.stage.Stage;


public class ControllerTheatre {

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
    private Button btn_viewer;

    @FXML
    private Button btn_delete_theatre;

    @FXML
    private Button btn_insert_theatre;

    @FXML
    private Button btn_update_theatre;

    @FXML
    private TableColumn<Theatre, String> col_address_theatre;

    @FXML
    private TableColumn<Theatre, Short> col_id_theatre;

    @FXML
    private TableColumn<Theatre, String> col_title_theatre;

    @FXML
    private TextField tf_address_theatre;

    @FXML
    private TextField tf_id_theatre;

    @FXML
    private TextField tf_title_theatre;

    @FXML
    private TableView<Theatre> tv_theatre;

    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == btn_insert_theatre) {
            insertRecord();
        } else if (event.getSource() == btn_update_theatre) {
            updateRecord();
        } else if (event.getSource() == btn_delete_theatre) {
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

    public ObservableList<Theatre> getTheatreList(){
        ObservableList<Theatre> theatreList = FXCollections.observableArrayList();
        Connection conn = connection;
        String query = "SELECT * FROM theatre";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Theatre theatre;
            while (rs.next()){
                theatre = new Theatre(rs.getShort("theatre_id"), rs.getString("address"), rs.getString("title"));
                theatreList.add(theatre);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return theatreList;
    }

    public void showTheatre() {
        ObservableList<Theatre> list = getTheatreList();

        col_id_theatre.setCellValueFactory(new PropertyValueFactory<Theatre, Short>("theatre_id"));
        col_address_theatre.setCellValueFactory(new PropertyValueFactory<Theatre, String>("address"));
        col_title_theatre.setCellValueFactory(new PropertyValueFactory<Theatre, String>("title"));

        tv_theatre.setItems(list);
    }

    private void insertRecord(){
        String query = "INSERT INTO theatre VALUES (" + tf_id_theatre.getText() + ",'"
                + tf_address_theatre.getText() + "','" + tf_title_theatre.getText() + "')";
        executeQuery(query);
        showTheatre();
    }

    private void updateRecord (){
        String query = "UPDATE theatre SET address = '" + tf_address_theatre.getText()
                + "', title = '" + tf_title_theatre.getText() + "' WHERE theatre_id = " + tf_id_theatre.getText() + "";
        executeQuery(query);
        showTheatre();
    }

    private void deleteButton(){
        String query = "DELETE FROM theatre WHERE theatre_id = " + tf_id_theatre.getText() + "";
        executeQuery(query);
        showTheatre();
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

    public void handleMouseAction(javafx.scene.input.MouseEvent mouseEvent) {
        Theatre theatre = tv_theatre.getSelectionModel().getSelectedItem();
        tf_id_theatre.setText("" + theatre.getTheatre_id());
        tf_address_theatre.setText(theatre.getAddress());
        tf_title_theatre.setText(theatre.getTitle());
    }
    @FXML
    private TextField tf_search;

    private void search() {
        String searchText = tf_search.getText();
        ObservableList<Theatre> searchResults = FXCollections.observableArrayList();

        for (Theatre theatre : tv_theatre.getItems()) {
            if (String.valueOf(theatre.getTheatre_id()).contains(searchText) || String.valueOf(theatre.getAddress()).contains(searchText)
                    || String.valueOf(theatre.getTitle()).contains(searchText)) {
                searchResults.add(theatre);
            }
        }
        tv_theatre.setItems(searchResults);
    }

    @FXML
    void initialize() {
        showTheatre();
        tf_search.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                search();
            }
        });
    }
}
