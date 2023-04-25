package org.example.utility;

import org.example.entity.Customer;
import org.example.entity.Store;
import org.example.entity.User;
import org.example.services.CashierService;
import java.util.PriorityQueue;

public class CheckoutPriority{
    private PriorityQueue<Customer> queue;

    public CheckoutPriority() {
        queue = new PriorityQueue<Customer>((c1, c2) -> c2.getBasket().size() - c1.getBasket().size());
    }
    public void addToCustomerQueue(Customer customer){
        queue.add(customer);
    }
    public void transact(User cashier, CashierService cashierService, Store store){
        while (!queue.isEmpty()){
            Customer customer = queue.poll();
            cashierService.checkout(cashier, customer, store);
        }
    }
}
