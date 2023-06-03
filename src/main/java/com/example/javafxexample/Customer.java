package com.example.javafxexample;

public class Customer {

    private int idCustomer;
    private String name;
    private String email;

    public Customer() {
    }

    public Customer(int idCustomer, String name, String email) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.email = email;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
