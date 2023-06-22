package com.example.theatremaven;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.example.theatremaven.entity.Act;
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

public class ControllerTicket {

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
    private TableColumn<Ticket, Short> col_id_performance;

    @FXML
    private TableColumn<Ticket, Short> col_id_ticket;

    @FXML
    private TableColumn<Ticket, Short> col_id_viewer;

    @FXML
    private TableColumn<Ticket, String> col_type;

    @FXML
    private TableColumn<Ticket, Short> col_place_number;

    @FXML
    private TableColumn<Ticket, Integer> col_price;

    @FXML
    private TableColumn<Ticket, Short> col_row_number;

    @FXML
    private TextField tf_id_performance;

    @FXML
    private TextField tf_id_ticket;

    @FXML
    private TextField tf_id_viewer;

    @FXML
    private TextField tf_place_number;

    @FXML
    private TextField tf_price;

    @FXML
    private TextField tf_row_number;

    @FXML
    private TextField tf_type;

    @FXML
    private TableView<Ticket> tv;

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

    public ObservableList<Ticket> getTicketList(){
        ObservableList<Ticket> ticketList = FXCollections.observableArrayList();
        Connection conn = connection;
        String query = "SELECT * FROM ticket";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Ticket ticket;
            while (rs.next()){
                ticket = new Ticket(rs.getShort("ticket_id"), rs.getShort("performance_id"), rs.getShort("viewer_id"), rs.getInt("price"), rs.getString("type"), rs.getShort("place_number"), rs.getShort("row_number"));
                ticketList.add(ticket);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ticketList;
    }

    public void showTicket() {
        ObservableList<Ticket> list = getTicketList();

        col_id_ticket.setCellValueFactory(new PropertyValueFactory<Ticket, Short>("ticket_id"));
        col_id_performance.setCellValueFactory(new PropertyValueFactory<Ticket, Short>("performance_id"));
        col_id_viewer.setCellValueFactory(new PropertyValueFactory<Ticket, Short>("viewer_id"));
        col_price.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("price"));
        col_type.setCellValueFactory(new PropertyValueFactory<Ticket, String>("type"));
        col_place_number.setCellValueFactory(new PropertyValueFactory<Ticket, Short>("place_number"));
        col_row_number.setCellValueFactory(new PropertyValueFactory<Ticket, Short>("row_number"));

        tv.setItems(list);
    }

    private void insertRecord(){
        String query = "INSERT INTO ticket VALUES (" + tf_id_ticket.getText() + ","
                + tf_id_performance.getText() + "," + tf_id_viewer + "," + tf_price.getText() + ",'" + tf_type + "'," + tf_place_number + "," + tf_row_number + ")";
        executeQuery(query);
        showTicket();
    }

    private void updateRecord (){
        String query = "UPDATE ticket SET performance_id = " + tf_id_performance.getText()
                + ", viewer_id = " + tf_id_viewer.getText() + ", price = " + tf_price.getText() + ", type = '" + tf_type + "' , place_number = " + tf_place_number + ", row_number = " + tf_row_number +   " WHERE ticket_id = " + tf_id_ticket.getText() + "";
        executeQuery(query);
        showTicket();
    }

    private void deleteButton(){
        String query = "DELETE FROM ticket WHERE ticket_id = " + tf_id_ticket.getText() + "";
        executeQuery(query);
        showTicket();
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
        Ticket ticket = tv.getSelectionModel().getSelectedItem();
        tf_id_ticket.setText("" + ticket.getTicket_id());
        tf_id_performance.setText("" + ticket.getPerformance_id());
        tf_id_viewer.setText("" + ticket.getViewer_id());
        tf_price.setText("" + ticket.getPrice());
        tf_type.setText("" + ticket.getType());
        tf_place_number.setText("" + ticket.getPlace_number());
        tf_row_number.setText("" + ticket.getRow_number());

    }

    @FXML
    private TextField tf_search;

    private void search() {
        String searchText = tf_search.getText();
        ObservableList<Ticket> searchResults = FXCollections.observableArrayList();

        for (Ticket ticket : tv.getItems()) {
            if (String.valueOf(ticket.getTicket_id()).contains(searchText) || String.valueOf(ticket.getPerformance_id()).contains(searchText)
                    || String.valueOf(ticket.getViewer_id()).contains(searchText) || String.valueOf(ticket.getPrice()).contains(searchText)
                    || String.valueOf(ticket.getType()).contains(searchText) || String.valueOf(ticket.getPlace_number()).contains(searchText)
                    || String.valueOf(ticket.getRow_number()).contains(searchText)) {
                searchResults.add(ticket);
            }
        }
        tv.setItems(searchResults);
    }

    @FXML
    void initialize() {
        showTicket();
        tf_search.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                search();
            }
        });
    }

}

