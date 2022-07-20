package org.example.service.impl;

import org.example.entities.Cart;
import org.example.entities.Product;
import org.example.entities.Store;
import org.example.entities.User;
import org.example.enums.Roles;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StoreServiceImplTest {
    Store store;

    private final String productName = "Carrot";
    private final int qty = 8;
    User custmer = new User(Roles.Customer, "Ebuka", 200);
    Cart cart;

    @org.junit.jupiter.api.Test
    void addToCustomerCart() {
        StoreServiceImpl ssi = new StoreServiceImpl();

        var a = store.getStockList().forEach(product -> product.);
        var a = ssi.addToCustomerCart(custmer, "Carrot", 10);
        assertEquals(expect, a);
    }

    @org.junit.jupiter.api.Test
    void fifoSell() {

    }

    @org.junit.jupiter.api.Test
    void prioritySellQue() {
    }

    @org.junit.jupiter.api.Test
    void sellProduct() {

    }
}