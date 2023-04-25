package org.example.services;

import org.example.entity.Customer;
import org.example.entity.Product;
import org.example.entity.Store;
import org.example.entity.User;
import java.util.List;

public interface CashierService {
    void minusQuantity(Product product, int quantity, Store store);
    void checkout(User cashier, Customer customer, Store store);
    void receipt(Customer customer, List<Product> products, double total);
}
