package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private double wallet;
    private List<Product> basket;

    public Customer(String name, double wallet) {
        this.name = name;
        this.wallet = wallet;
        this.basket = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public List<Product> getBasket() {
        return basket;
    }

    public void setBasket(List<Product> basket) {
        this.basket = basket;
    }
    public void addBasket(Product product){
        basket.add(product);
    }
    public void makePayment(double amount){
        this.wallet-= amount;
        System.out.println("you have been debited " + amount + " your new balance is " + getWallet());
    }

    public void addToBasket(Product product, int quantity){
        if(product.getQuantity() <= 0){
            System.out.println("Sorry "+ product.getName() + " is out of stock.");
        } else {
            if(product.getQuantity() >= quantity){
                Product item = new Product(product.getName(), quantity, product.getPrice());
                basket.add(item);
               // System.out.println(product.getName() + " has been added to the basket. quantity = "
               //         + quantity + " unit price = " + product.getPrice());
            } else {
                System.out.println("Sorry "+ product.getName() + " has only " + product.getQuantity() +
                        " left. Kindly pick " + product.getQuantity() + " or less.");
            }
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", wallet=" + wallet +
                ", basket=" + basket +
                '}';
    }
}
