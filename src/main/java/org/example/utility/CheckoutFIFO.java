package org.example.utility;

import org.example.entity.Customer;
import org.example.entity.Store;
import org.example.entity.User;
import org.example.services.CashierService;
import java.util.LinkedList;
import java.util.Queue;

public class CheckoutFIFO {
    private Queue<Customer> queue;

    public CheckoutFIFO() {
        queue = new LinkedList<Customer>();
    }
    public void addToCustomerQueue(Customer customer){
        queue.add(customer);
    }

    public void transact(User cashier, CashierService cashierService, Store store) {
        while (!queue.isEmpty()) {
            System.out.println("==============================");
            System.out.println("==============================");
            Customer customer = queue.poll();
            cashierService.checkout(cashier, customer, store);
            System.out.println("==============================");
            System.out.println("==============================");
        }
    }
}
