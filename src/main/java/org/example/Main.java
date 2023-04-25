package org.example;


import org.example.entity.Customer;
import org.example.entity.Product;
import org.example.entity.Store;
import org.example.entity.User;
import org.example.enums.Roles;
import org.example.services.implementation.ManagerServiceImplementation;
import org.example.utility.MultiThreading;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Store store = new Store("Devstore", 0.0);
        User manager = new User("John", Roles.MANAGER, "MAN1133", store);

        ManagerServiceImplementation managerService = new ManagerServiceImplementation();


        Product yam = new Product("yam", 500, 250);
        Product apple = new Product("apple", 500, 100);
        Product egg = new Product("egg", 290, 70);
        managerService.setStoreProduct(manager, yam, store);
        managerService.setStoreProduct(manager, apple, store);
        managerService.setStoreProduct(manager, egg, store);




        Customer customer0 = new Customer("Matte", 10000);
        customer0.addToBasket(yam,15);
        customer0.addToBasket(egg,17);


        Customer customer1 = new Customer("Jacob", 10000);
        customer1.addToBasket(yam,5);
        customer1.addToBasket(egg,6);


        Customer customer2 = new Customer("Lucas", 10000);
        customer2.addToBasket(yam,3);
        customer2.addToBasket(egg,34);


        Customer customer3 = new Customer("Shawn", 10000);
        customer3.addToBasket(yam,13);
        customer3.addToBasket(egg,6);



        Customer customer4 = new Customer("Edwin", 10000);
        customer4.addToBasket(yam,32);
        customer4.addToBasket(egg,25);


        Customer customer5 = new Customer("Clark-son", 10000);
        customer5.addToBasket(yam,31);
        customer5.addToBasket(egg,25);


        Customer customer6 = new Customer("Manuel", 10000);
        customer6.addToBasket(yam,7);
        customer6.addToBasket(egg,33);

        List<Customer> customers = store.getCustomerList();
        customers.add(customer0);
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
        customers.add(customer6);


        for(Customer customer : customers) {
           Thread thread = new Thread(new MultiThreading(customer, store));
           thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
        System.out.println("00000000000000000000000000");
        System.out.println(store.getStoreWallet());
        System.out.println(customer1.getBasket()+ customer1.getName());
        System.out.println("00000000000000000000000000");


    }

}