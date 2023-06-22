module com.example.theatremaven {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;
    requires lombok;
    requires org.postgresql.jdbc;
    requires java.sql;


    opens com.example.theatremaven to javafx.fxml, java.sql;
    exports com.example.theatremaven;
    opens com.example.theatremaven.entity to org.hibernate.orm.core, lombok;
    exports com.example.theatremaven.entity;
//    exports com.example.theatremaven.controllers;
//    opens com.example.theatremaven.controllers to java.sql, javafx.fxml;
}