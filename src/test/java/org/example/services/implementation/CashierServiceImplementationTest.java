package org.example.services.implementation;

import org.example.entity.Customer;
import org.example.entity.Product;
import org.example.entity.Store;
import org.example.entity.User;
import org.example.enums.Roles;

import static org.junit.jupiter.api.Assertions.*;

class CashierServiceImplementationTest {
    Store store = new Store("Daveson", 100000);
    User manager = new User("Fed", Roles.MANAGER, "MAN664", store);
    User cashier = new User("Dave", Roles.CASHIER,"CASH674",store);
    CashierServiceImplementation cashierServiceImplementation = new CashierServiceImplementation();
    ManagerServiceImplementation managerServiceImplementation = new ManagerServiceImplementation();
    Customer customer = new Customer("John", 50000);

    Product product = new Product("apple", 200, 200);
    Product product1 = new Product("beans", 300, 300);
    @org.junit.jupiter.api.Test
    void minusQuantity() {
        managerServiceImplementation.setStoreProduct(manager,product,store);
        customer.addToBasket(product,50);
        cashierServiceImplementation.checkout(cashier, customer, store);
        assertEquals(150, (product.getQuantity()));

    }

    @org.junit.jupiter.api.Test
    void checkout() {
        managerServiceImplementation.setStoreProduct(manager,product,store);
        managerServiceImplementation.setStoreProduct(manager, product1, store);
        customer.addToBasket(product1, 5);
        customer.addToBasket(product, 1);
        cashierServiceImplementation.checkout(cashier, customer, store);
        assertEquals(48300, (customer.getWallet()));
    }
}