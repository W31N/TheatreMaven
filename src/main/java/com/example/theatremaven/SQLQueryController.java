package com.example.theatremaven;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SQLQueryController implements Initializable {

    private Connection connection;

    @FXML
    private TextArea txtQuery;

    @FXML
    private Button btnExecute;

    @FXML
    private Button btn_back;

    @FXML
    private Button request_1;
    @FXML
    private Button request_2;
    @FXML
    private Button request_3;
    @FXML
    private Button request_4;
    @FXML
    private Button request_5;
    @FXML
    private Button request_6;


    @FXML
    private TableView<ObservableList<String>> tblResult;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connection = DatabaseManager.getConnection();

        // Привязка действия к кнопке
        btnExecute.setOnAction(event -> executeQuery());
        btn_back.setOnAction(event -> {
            try {
                back();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Tooltip tooltip1 = new Tooltip("Вывести спектакли, у которых жанр – драма и дата начала 22.05.2023");
        request_1.setTooltip(tooltip1);

        Tooltip tooltip2 = new Tooltip("Вывести номера билетов на спектакль “Укрощение строптивой”, стоимость которых больше 5000");
        request_2.setTooltip(tooltip2);

        Tooltip tooltip3 = new Tooltip("Вывести табельные номера мужчин актеров с ростом более 180, играющих роль – “Петруччо”");
        request_3.setTooltip(tooltip3);

        Tooltip tooltip4 = new Tooltip("Вывести название театра со сценой, вместимость которой больше 400, в котором исполняется спектакль “Дон Карлос”, которой основан на пьесе Фридриха Шиллера");
        request_4.setTooltip(tooltip4);

        Tooltip tooltip5 = new Tooltip("Вывести названия спектаклей и жанры пьес, на которых спектакли основаны");
        request_5.setTooltip(tooltip5);

        Tooltip tooltip6 = new Tooltip("Вывести Названия спектаклей, у которых есть хотя бы один акт продолжительностью более 60 минут");
        request_6.setTooltip(tooltip6);

        request_1.setOnAction(event -> {
            String textToAdd = "SELECT *\n" +
                    "FROM performance\n" +
                    "WHERE genre = 'драма' AND start_date = '2023-05-22'\n";
            txtQuery.clear();
            txtQuery.appendText(textToAdd);

        });

        request_2.setOnAction(event -> {
            String textToAdd = "SELECT ticket_id\n" +
                    "FROM ticket\n" +
                    "JOIN performance ON ticket.performance_id = performance.performance_id\n" +
                    "WHERE performance.title = 'Укрощение строптивой' AND ticket.price > 5000\n";
            txtQuery.clear();
            txtQuery.appendText(textToAdd);
        });
        request_3.setOnAction(event -> {
            String textToAdd = "SELECT personnel_number\n" +
                    "FROM actor\n" +
                    "WHERE personnel_number IN (SELECT personnel_number\n" +
                    "FROM contract_role_actor\n" +
                    "WHERE role_id IN (SELECT role_id\n" +
                    "FROM role\n" +
                    "WHERE name = 'Петруччо'))\n" +
                    "AND passport_data IN (SELECT passport_data\n" +
                    "FROM person\n" +
                    "WHERE gender = 'мужчина')\n" +
                    "AND height > 180\n" +
                    "ORDER BY height\n";
            txtQuery.clear();
            txtQuery.appendText(textToAdd);
        });
        request_4.setOnAction(event -> {
            String textToAdd = "SELECT theatre.title\n" +
                    "FROM theatre\n" +
                    "WHERE theatre_id IN (SELECT theatre_id\n" +
                    "FROM rent\n" +
                    "WHERE scene_id IN (SELECT scene_id\n" +
                    "FROM scene\n" +
                    "WHERE scene_id IN (SELECT scene_id\n" +
                    "FROM performance\n" +
                    "WHERE piece_id IN (SELECT piece_id\n" +
                    "FROM piece\n" +
                    "WHERE piece.author = 'Фридрих Шиллер'\n" +
                    ") AND title = 'Дон Карлос') AND capacity > 400))\n";
            txtQuery.clear();
            txtQuery.appendText(textToAdd);
        });
        request_5.setOnAction(event -> {
            String textToAdd = "SELECT performance.title, piece.genre\n" +
                    "FROM performance, piece\n" +
                    "WHERE  performance.piece_id = piece.piece_id\n";
            txtQuery.clear();
            txtQuery.appendText(textToAdd);
        });
        request_6.setOnAction(event -> {
            String textToAdd = "SELECT title\n" +
                    "FROM performance\n" +
                    "WHERE EXISTS (SELECT performance_id FROM act\n" +
                    "WHERE performance_id = performance.performance_id\n" +
                    "AND duration > 60)\n";
            txtQuery.clear();
            txtQuery.appendText(textToAdd);
        });

    }

    private void back() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("act.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) btn_back.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    private void executeQuery() {
        String query = txtQuery.getText().trim();

        try (Statement statement = connection.createStatement()) {
            boolean isResultSet = statement.execute(query);

            if (isResultSet) {
                // Обработка запросов, возвращающих результаты
                try (ResultSet resultSet = statement.getResultSet()) {
                    tblResult.getItems().clear();
                    tblResult.getColumns().clear();

                    // Создание столбцов для каждого результата запроса
                    for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                        final int columnIndex = i - 1;
                        TableColumn<ObservableList<String>, String> column = new TableColumn<>(resultSet.getMetaData().getColumnName(i));
                        column.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(columnIndex)));
                        tblResult.getColumns().add(column);
                    }

                    // Добавление строк с значениями столбцов результата
                    while (resultSet.next()) {
                        ObservableList<String> row = FXCollections.observableArrayList();
                        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                            row.add(resultSet.getString(i));
                        }
                        tblResult.getItems().add(row);
                    }
                }
            } else {
                // Сообщение об успешном выполнении запроса, не возвращающего результаты
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Успех");
                successAlert.setHeaderText("Запрос выполнен успешно");
                successAlert.setContentText("Запрос был успешно выполнен.");
                successAlert.showAndWait();
            }
        } catch (SQLException ex) {
            // Сообщение об ошибке выполнения запроса
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Ошибка");
            errorAlert.setHeaderText("Ошибка выполнения запроса");
            errorAlert.setContentText(ex.getMessage());
            errorAlert.showAndWait();
            ex.printStackTrace();
        }
    }
}