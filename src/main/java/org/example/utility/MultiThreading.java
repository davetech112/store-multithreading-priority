package org.example.utility;


import org.example.entity.Customer;
import org.example.entity.Store;
import org.example.entity.User;
import org.example.enums.Roles;
import org.example.services.implementation.CashierServiceImplementation;

public class MultiThreading implements Runnable{

    private Store store;
    private Customer customer;

    public MultiThreading(Customer customer, Store store){
        this.customer = customer;
        this.store = store;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        User cashier = new User("James", Roles.CASHIER, "CASH554", store);
        CashierServiceImplementation cashierService = new CashierServiceImplementation();
        System.out.println("*********************");
        cashierService.checkout(cashier, customer, store);
        System.out.println("*********************");
    }


}
