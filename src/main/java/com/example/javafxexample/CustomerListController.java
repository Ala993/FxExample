package com.example.javafxexample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class CustomerListController {
    @FXML
    private ListView<Customer> customerListView;

    public void setCustomerData(ObservableList<Customer> customers) {
        customerListView.setItems(customers);
    }
}
