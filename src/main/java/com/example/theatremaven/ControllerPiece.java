package com.example.theatremaven;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

import com.example.theatremaven.entity.Person;
import com.example.theatremaven.entity.Piece;
import com.example.theatremaven.entity.Rent;
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

public class ControllerPiece {

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
    private TableColumn<Piece, String> col_author;

    @FXML
    private TableColumn<Piece, String> col_genre;

    @FXML
    private TableColumn<Piece, Short> col_id_piece;

    @FXML
    private TableColumn<Piece, Date> col_publication_date;

    @FXML
    private TableColumn<Piece, String> col_title;

    @FXML
    private TextField tf_author;

    @FXML
    private TextField tf_genre;

    @FXML
    private TextField tf_id_piece;

    @FXML
    private TextField tf_publication_date;

    @FXML
    private TextField tf_title;

    @FXML
    private TableView<Piece> tv;

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
    public ObservableList<Piece> getPieceList(){
        ObservableList<Piece> pieceList = FXCollections.observableArrayList();
        Connection conn = connection;
        String query = "SELECT * FROM piece";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Piece piece;
            while (rs.next()){
                piece = new Piece(rs.getShort("piece_id"), rs.getString("title"), rs.getString("author"), rs.getString("genre"), rs.getDate("publication_date"));
                pieceList.add(piece);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return pieceList;
    }

    public void showPiece() {
        ObservableList<Piece> list = getPieceList();

        col_id_piece.setCellValueFactory(new PropertyValueFactory<Piece, Short>("piece_id"));
        col_title.setCellValueFactory(new PropertyValueFactory<Piece, String>("title"));
        col_author.setCellValueFactory(new PropertyValueFactory<Piece, String>("author"));
        col_genre.setCellValueFactory(new PropertyValueFactory<Piece, String>("genre"));
        col_publication_date.setCellValueFactory(new PropertyValueFactory<Piece, Date>("publication_date"));

        tv.setItems(list);
    }

    private void insertRecord(){
        String query = "INSERT INTO piece VALUES (" + tf_id_piece.getText() + ",'"
                + tf_title.getText() + "','" + tf_author.getText() +"','" + tf_genre.getText() + "','" + tf_publication_date.getText() +  "')";
        executeQuery(query);
        showPiece();
    }

    private void updateRecord (){
        String query = "UPDATE piece SET title = '" + tf_title.getText()
                + "', author = '" + tf_author.getText() + "', genre = '" + tf_genre.getText() + "', publication_date = '" + tf_publication_date.getText() +  "' WHERE piece_id = " + tf_id_piece.getText() + "";
        executeQuery(query);
        showPiece();
    }

    private void deleteButton(){
        String query = "DELETE FROM piece WHERE piece_id = " + tf_id_piece.getText() + "";
        executeQuery(query);
        showPiece();
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
        Piece piece = tv.getSelectionModel().getSelectedItem();

        tf_id_piece.setText("" + piece.getPiece_id());
        tf_title.setText(piece.getTitle());
        tf_author.setText(piece.getAuthor());
        tf_genre.setText(piece.getGenre());
        tf_publication_date.setText("" + piece.getPublication_date());

    }

    @FXML
    private TextField tf_search;

    private void search() {
        String searchText = tf_search.getText();
        ObservableList<Piece> searchResults = FXCollections.observableArrayList();

        for (Piece piece : tv.getItems()) {
            if (String.valueOf(piece.getPiece_id()).contains(searchText) || String.valueOf(piece.getTitle()).contains(searchText)
                    || String.valueOf(piece.getAuthor()).contains(searchText) || String.valueOf(piece.getGenre()).contains(searchText) || String.valueOf(piece.getPublication_date()).contains(searchText)) {
                searchResults.add(piece);
            }
        }
        tv.setItems(searchResults);
    }

    @FXML
    void initialize() {
        showPiece();
        tf_search.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                search();
            }
        });
    }
}
