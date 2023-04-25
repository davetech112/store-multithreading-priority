package org.example.entity;

import org.example.enums.Roles;
import org.example.services.implementation.CashierServiceImplementation;
import org.example.services.implementation.ManagerServiceImplementation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    Store store = new Store("Daveson", 0.0);
    User manager = new User("Fed", Roles.MANAGER, "MAN664", store);
    User cashier = new User("Dave", Roles.CASHIER,"CASH674",store);
    CashierServiceImplementation cashierServiceImplementation = new CashierServiceImplementation();
    ManagerServiceImplementation managerServiceImplementation = new ManagerServiceImplementation();
    Customer customer = new Customer("John", 50000);

    Product product = new Product("apple", 200, 200);
    Product product1 = new Product("beans", 300, 300);
    @Test
    void getStoreWallet() {
        managerServiceImplementation.setStoreProduct(manager,product,store);
        managerServiceImplementation.setStoreProduct(manager, product1, store);
        customer.addToBasket(product1, 5);
        customer.addToBasket(product, 1);
        cashierServiceImplementation.checkout(cashier, customer, store);
        assertEquals(1700, (store.getStoreWallet()));

    }

    Customer customer1 = new Customer("John", 10_000);

    Customer customer2 = new Customer("James", 10_000);

    @Test
    void testGetStoreWallet() {
        customer1.addToBasket(product,10);
        customer2.addToBasket(product,10);
        Thread thread1 = new Thread(() -> {
            cashierServiceImplementation.checkout(cashier,customer1,store);
        });
        Thread thread2 = new Thread(() -> {
            cashierServiceImplementation.checkout(cashier,customer2,store);
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        assertEquals(4000, (store.getStoreWallet()));
    }


}