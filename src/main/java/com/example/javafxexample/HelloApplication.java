package com.example.javafxexample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloApplication extends Application {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/javafx";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("customer_list.fxml"));
            VBox root = loader.load();

            CustomerListController controller = loader.getController();

            ObservableList<Customer> customers = getCustomerData();
            controller.setCustomerData(customers);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    private ObservableList<Customer> getCustomerData() {
        ObservableList<Customer> customers = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM customer")) {

            while (rs.next()) {
                int id = rs.getInt("idCustomer");
                String name = rs.getString("name");
                String email = rs.getString("email");

                Customer customer = new Customer(id, name, email);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
}