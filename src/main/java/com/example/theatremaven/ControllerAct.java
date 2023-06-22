package com.example.theatremaven;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.example.theatremaven.entity.Act;
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

public class ControllerAct {

    DatabaseManager databaseManager = new DatabaseManager();
    Connection connection = databaseManager.getConnection();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_insert;

    @FXML
    private Button btn_sql_query;

    @FXML
    private Button btn_update;

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
    private TableColumn<Act, Short> col_duration;

    @FXML
    private TableColumn<Act, Short> col_id_act;

    @FXML
    private TableColumn<Act, Short> col_id_performance;

    @FXML
    private TableColumn<Act, Short> col_sequence_number;

    @FXML
    private TextField tf_duration;

    @FXML
    private TextField tf_id_act;

    @FXML
    private TextField tf_id_performance;

    @FXML
    private TextField tf_sequence_number;

    @FXML
    private TextField tf_search;

    @FXML
    private TableView<Act> tv;

    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == btn_insert) {
            insertRecord();
        } else if (event.getSource() == btn_update) {
            updateRecord();
        } else if (event.getSource() == btn_delete) {
            deleteButton();
        }else if (event.getSource() == btn_sql_query) {
            openSQLQueryWindow();
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
        }
    }

    private void openSQLQueryWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sql_query_window.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) btn_sql_query.getScene().getWindow();
        stage.setScene(new Scene(root));
    }


    public ObservableList<Act> getActList(){
        ObservableList<Act> actList = FXCollections.observableArrayList();
        Connection conn = connection;
        String query = "SELECT * FROM act";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Act act;
            while (rs.next()){
                act = new Act(rs.getShort("act_id"), rs.getShort("performance_id"), rs.getShort("duration"), rs.getShort("sequence_number"));
                actList.add(act);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return actList;
    }

    public void showAct() {
        ObservableList<Act> list = getActList();

        col_id_act.setCellValueFactory(new PropertyValueFactory<Act, Short>("act_id"));
        col_id_performance.setCellValueFactory(new PropertyValueFactory<Act, Short>("performance_id"));
        col_duration.setCellValueFactory(new PropertyValueFactory<Act, Short>("duration"));
        col_sequence_number.setCellValueFactory((new PropertyValueFactory<Act, Short>("sequence_number")));

        tv.setItems(list);
    }

    private void insertRecord(){
        String query = "INSERT INTO act VALUES (" + tf_id_act.getText() + ","
                + tf_id_performance.getText() + "," + tf_duration.getText() + "," + tf_sequence_number.getText() + ")";
        executeQuery(query);
        showAct();
    }

    private void updateRecord (){
        String query = "UPDATE act SET performance_id = " + tf_id_performance.getText()
                + ", duration = " + tf_duration.getText() + ", sequence_number = " + tf_sequence_number.getText() + " WHERE act_id = " + tf_id_act.getText() + "";
        executeQuery(query);
        showAct();
    }

    private void deleteButton(){
        String query = "DELETE FROM act WHERE act_id = " + tf_id_act.getText() + "";
        executeQuery(query);
        showAct();
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

    private void searchAct() {
        String searchText = tf_search.getText();
        ObservableList<Act> searchResults = FXCollections.observableArrayList();

        for (Act act : tv.getItems()) {
            if (String.valueOf(act.getAct_id()).contains(searchText) || String.valueOf(act.getPerformance_id()).contains(searchText)
                    || String.valueOf(act.getDuration()).contains(searchText) || String.valueOf(act.getSequence_number()).contains(searchText)) {
                searchResults.add(act);
            }
        }

        tv.setItems(searchResults);
    }

    @FXML
    void handleMouseAction(MouseEvent event) {
        Act act = tv.getSelectionModel().getSelectedItem();
        tf_id_act.setText("" + act.getAct_id());
        tf_id_performance.setText("" + act.getPerformance_id());
        tf_duration.setText("" + act.getDuration());
        tf_sequence_number.setText("" + act.getSequence_number());
    }

    @FXML
    void initialize() {
        showAct();
        tf_search.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                searchAct();
            }
        });
    }
}
