package org.example.services.implementation;

import org.example.entity.Customer;
import org.example.entity.Product;
import org.example.entity.Store;
import org.example.entity.User;
import org.example.enums.Roles;
import org.example.services.CashierService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CashierServiceImplementation implements CashierService {
    public void minusQuantity(Product product, int quantity, Store store){
        for(Product p : store.getProductList() ){
            if(p.getName().equals(product.getName())){
                p.setQuantity(p.getQuantity() - quantity);
                return;

            }
        }


    }



    public void checkout(User cashier, Customer customer, Store store){
        if(customer.getBasket().size()!=0){
            if(cashier.getRole() == Roles.CASHIER) {
            double total = 0.0;
            for (Product prod : customer.getBasket()) {
                System.out.println(prod.getName() + " qty " + prod.getQuantity() + " price " + prod.getPrice());
                total += (prod.getQuantity() * prod.getPrice());
            }
            if (total > customer.getWallet()) {
                System.out.println("insufficient funds");
            } else {
                for (Product prod : customer.getBasket()) {
                    minusQuantity(prod, prod.getQuantity(), store);
                }
                store.setStoreWallet(store.getStoreWallet() + total);
                customer.setWallet(customer.getWallet() - total);
                receipt(customer, customer.getBasket(), total);
            }
            } else {
                System.out.println("Unauthorized Access");
            }
        } else{
            System.out.println(customer.getName() + " has an empty basket and cannot proceed to checkout.");
        }
    }
    public void receipt(Customer customer, List<Product> products, double total){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Receipt for " + customer.getName() + " on: " + dtf.format(now));
        for(Product p : products) {
            System.out.println(p.toString());
        }
        System.out.println("Total " + total);
        System.out.println("Thanks for shopping with us");
        customer.getBasket().clear();
    }
}
