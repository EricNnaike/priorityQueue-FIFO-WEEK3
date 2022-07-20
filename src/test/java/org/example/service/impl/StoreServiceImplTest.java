package org.example.service.impl;

import org.example.entities.Product;
import org.example.entities.QueueClass;
import org.example.entities.Store;
import org.example.entities.User;
import org.example.enums.Roles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.*;

class StoreServiceImplTest {

    public StoreServiceImpl storeService;
    CashierTransactionsImpl transact;
    User user;
    Product product;



    @BeforeEach
    void setUp() {
        this.storeService = new StoreServiceImpl();
        storeService.setStore(new Store());
        storeService.setQueueClass(new QueueClass());
    }


    @Test
    @DisplayName("Should return a message when the cashier is in the queue")
    void prioritySellQueWhenCashierIsInTheQueueThenReturnMessage() {
        PriorityQueue<User> listQueue = new PriorityQueue<>();
        User cashier = new User(Roles.Customer, "Cashier", 0);
        String message = storeService.prioritySellQue(listQueue, cashier);
        assertEquals("Not A cashier", message);
    }


    @Test
    @DisplayName("Should return true when the customer has enough money")
    void sellProductWhenCustomerHasEnoughMoneyThenReturnTrue() {
        user = new User(Roles.Cashier, "Cashier", 100);
        User customer = new User(Roles.Customer, "Customer", 100);
        Product product = new Product("Product", 10, 1, "Category");
        customer.getCart().getCustomerCart().put("Product", product);
        assertTrue(storeService.sellProduct(user, customer));
    }


    @Test
    @DisplayName("Should not sell the product when the cashier is not a cashier")
    void fifoSellWhenCashierIsNotCashierThenNotSellProduct() {
        User cashier = new User(Roles.Manager, "John", 100);
        User customer = new User(Roles.Customer, "John", 100);
        Queue<User> queue = new LinkedList<>();
        queue.add(customer);
        storeService.getQueueClass().setQueue(queue);
        assertFalse(storeService.fifoSell(storeService.getQueueClass().getQueue(), cashier));
    }
}