package com.example.theatremaven;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;

import com.example.theatremaven.entity.Actor;
import com.example.theatremaven.entity.Performance;
import com.example.theatremaven.entity.Person;
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
import org.hibernate.persister.spi.PersisterFactory;

public class ControllerPerformance {

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
    private TableColumn<Performance, String> col_director;

    @FXML
    private TableColumn<Performance, Time> col_end_time;

    @FXML
    private TableColumn<Performance, String> col_genre;

    @FXML
    private TableColumn<Performance, Short> col_id_performance;

    @FXML
    private TableColumn<Performance, Short> col_id_piece;

    @FXML
    private TableColumn<Performance, Short> col_id_scene;

    @FXML
    private TableColumn<Performance, Date> col_start_date;

    @FXML
    private TableColumn<Performance, Time> col_start_time;

    @FXML
    private TableColumn<Performance, String> col_title;

    @FXML
    private TextField tf_director;

    @FXML
    private TextField tf_end_time;

    @FXML
    private TextField tf_genre;

    @FXML
    private TextField tf_id_performance;

    @FXML
    private TextField tf_id_piece;

    @FXML
    private TextField tf_id_scene;

    @FXML
    private TextField tf_start_date;

    @FXML
    private TextField tf_start_time;

    @FXML
    private TextField tf_title;

    @FXML
    private TableView<Performance> tv;

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
    public ObservableList<Performance> getPerformanceList(){
        ObservableList<Performance> performanceList = FXCollections.observableArrayList();
        Connection conn = connection;
        String query = "SELECT * FROM performance";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Performance performance;
            while (rs.next()){
                performance = new Performance(rs.getShort("performance_id"), rs.getShort("scene_id"), rs.getShort("piece_id"), rs.getString("genre"), rs.getString("director"), rs.getDate("start_date"), rs.getTime("start_time"), rs.getTime("end_time"), rs.getString("title"));
                performanceList.add(performance);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return performanceList;
    }

    public void showPerformance() {
        ObservableList<Performance> list = getPerformanceList();

        col_id_performance.setCellValueFactory(new PropertyValueFactory<Performance, Short>("performance_id"));
        col_id_scene.setCellValueFactory(new PropertyValueFactory<Performance, Short>("scene_id"));
        col_id_piece.setCellValueFactory(new PropertyValueFactory<Performance, Short>("piece_id"));
        col_genre.setCellValueFactory(new PropertyValueFactory<Performance, String>("genre"));
        col_director.setCellValueFactory(new PropertyValueFactory<Performance, String>("director"));
        col_start_date.setCellValueFactory(new PropertyValueFactory<Performance, Date>("start_date"));
        col_start_time.setCellValueFactory(new PropertyValueFactory<Performance, Time>("start_time"));
        col_end_time.setCellValueFactory(new PropertyValueFactory<Performance, Time>("end_time"));
        col_title.setCellValueFactory(new PropertyValueFactory<Performance, String>("title"));

        tv.setItems(list);
    }

    private void insertRecord(){
        String query = "INSERT INTO performance VALUES (" + tf_id_performance.getText() + ","
                + tf_id_scene.getText() + "," + tf_id_piece.getText() +",'" + tf_genre.getText() + "','" + tf_director.getText() + "','"  + tf_start_date.getText() + "','" + tf_start_time.getText() + "','" + tf_end_time.getText() + "','" + tf_title.getText() + "')";
        executeQuery(query);
        showPerformance();
    }

    private void updateRecord (){
        String query = "UPDATE performance SET scene_id = " + tf_id_scene.getText()
                + ", piece_id = " + tf_id_piece.getText() + ", genre = '" + tf_genre.getText() + "', director = '" + tf_director.getText() + "', start_date = '" + tf_start_date.getText() + "', start_time =  '" + tf_start_time.getText() + "', end_time = '" + tf_end_time.getText() + "', title = '" + tf_title.getText() +"' WHERE performance_id = " + tf_id_performance.getText() + "";
        executeQuery(query);
        showPerformance();
    }

    private void deleteButton(){
        String query = "DELETE FROM performance WHERE performance_id = " + tf_id_performance.getText() + "";
        executeQuery(query);
        showPerformance();
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
        Performance performance = tv.getSelectionModel().getSelectedItem();

        tf_id_performance.setText("" + performance.getPerformance_id());
        tf_id_scene.setText("" + performance.getScene_id());
        tf_id_piece.setText("" + performance.getPiece_id());
        tf_genre.setText(performance.getGenre());
        tf_director.setText(performance.getDirector());
        tf_start_date.setText("" + performance.getStart_date());
        tf_start_time.setText("" + performance.getStart_time());
        tf_end_time.setText("" + performance.getEnd_time());
        tf_title.setText(performance.getTitle());

    }

    @FXML
    private TextField tf_search;

    private void search() {
        String searchText = tf_search.getText();
        ObservableList<Performance> searchResults = FXCollections.observableArrayList();

        for (Performance performance : tv.getItems()) {
            if (String.valueOf(performance.getPerformance_id()).contains(searchText) || String.valueOf(performance.getScene_id()).contains(searchText)
                    || String.valueOf(performance.getPiece_id()).contains(searchText) || String.valueOf(performance.getGenre()).contains(searchText) ||
                    String.valueOf(performance.getDirector()).contains(searchText) || String.valueOf(performance.getStart_date()).contains(searchText) || String.valueOf(performance.getStart_time()).contains(searchText) || String.valueOf(performance.getEnd_time()).contains(searchText) || String.valueOf(performance.getTitle()).contains(searchText)) {
                searchResults.add(performance);
            }
        }
        tv.setItems(searchResults);
    }

    @FXML
    void initialize() {
        showPerformance();
        tf_search.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                search();
            }
        });
    }

}
