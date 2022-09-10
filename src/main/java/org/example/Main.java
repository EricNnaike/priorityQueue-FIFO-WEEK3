package org.example;

//import org.example.entities.CustomerDTO;
import org.example.entities.*;
import org.example.enums.Roles;
import org.example.service.impl.CashierTransactionsImpl;
import org.example.service.impl.CustomerTransactionImpl;
import org.example.service.impl.StoreServiceImpl;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StoreServiceImpl ssi = new StoreServiceImpl();
        String path = "src/main/resources/storeProduct.csv";
        Store store = new Store();
        ssi.setStore(store);
        User cashier = new User(25, "Uche", Roles.Cashier);

        // READ STOCK PRODUCTS
        ssi.readProduct(path);
//        store.getStockList().forEach((name, product1) -> System.out.println(name+": "+product1));

        //Populating the customer
        User Ebuka = new User(Roles.Customer,"Ebuka Eze", 200);
        User Tobi = new User(Roles.Customer, "Tobi Oladele", 50);
        User Amanda = new User(Roles.Customer, "Amanda Okeke", 150);
        User Femi = new User(Roles.Customer, "Femi Idowu", 10);

        //Populating customer cart
        ssi.addToCustomerCart(Ebuka,"Banana", 40);
        ssi.addToCustomerCart(Femi,"Banana", 20);
        ssi.addToCustomerCart(Amanda,"Pretzels", 50);
        ssi.addToCustomerCart(Tobi,"Arrowroot", 500);

       //INSTANTIATING QUEUE CLASS
        QueueClass queueCon = new QueueClass();

        //POPULATING THE QUEUE BASE ON FIFO
        Queue<User> fifoQueue = queueCon.getQueue();
        fifoQueue.add(Tobi);
        fifoQueue.add(Ebuka);
        fifoQueue.add(Amanda);
        fifoQueue.add(Femi);
        System.out.println(queueCon.getQueue().size());
        // SELLING TO CUSTOMER BASE ON FIFO
        System.out.println("SELLING TO CUSTOMER BASE ON FIFO");
        System.out.println("****************************************************");
        ssi.fifoSell(fifoQueue, cashier);

        System.out.println("****************************************************");
        System.out.println("****************************************************");
        System.out.println("****************************************************");
        System.out.println();

        //POPULATING THE QUEUE BASE ON QUANTITY OF PRODUCTS
        Queue<User>  priority = queueCon.getPriorityQue();
        priority.add(Ebuka);
        priority.add(Tobi);
        priority.add(Femi);
        priority.add(Amanda);
        System.out.println(queueCon.getPriorityQue().size());
        // SELLING TO CUSTOMER BASE ON QUANTITY OF PRODUCTS
        System.out.println("SELLING TO CUSTOMER BASE ON QUANTITY OF PRODUCTS");
        System.out.println("****************************************************");
        System.out.println(ssi.prioritySellQue((PriorityQueue<User>) priority, cashier));

        //SEARCH PRODUCT BY CATEGORY
        CustomerTransactionImpl transact = new CustomerTransactionImpl();
        transact.searchCategory("Cookies");
    }

}