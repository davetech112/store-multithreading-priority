package org.example.entity;

import org.example.enums.Roles;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private String name;
    private double storeWallet;
    private User user;
    private List<User> cashierList;
    private List<User> applicantList;
    private List<Product> productList;
    private List<Customer> customerList;

    public Store(String name, double storeWallet) {
        this.name = name;
        this.storeWallet = storeWallet;
        this.cashierList = new ArrayList<>();
        this.applicantList = new ArrayList<>();
        this.productList = new ArrayList<>();
        this.customerList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public synchronized double getStoreWallet() {
        return storeWallet;
    }

    public synchronized void setStoreWallet(double storeWallet) {
        this.storeWallet = storeWallet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getCashierList() {
        return cashierList;
    }

    public void setCashierList(User cashier) {
        if(cashier.getRole() == Roles.CASHIER){
            this.cashierList.add(cashier);
            System.out.println("You have successfully added "+ cashier.getName() +" to your store cashier list");
        } else{
            System.out.println("This user is not a cashier");
        }

    }

    public List<User> getApplicantList() {
        return applicantList;
    }

    public void setApplicantList(List<User> applicantList) {
        this.applicantList = applicantList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    public void addStoreProduct(Product product){
        productList.add(product);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }



    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", storeWallet=" + storeWallet +
                "}";
    }
}
