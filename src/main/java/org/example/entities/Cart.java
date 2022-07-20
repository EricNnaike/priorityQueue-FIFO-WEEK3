package org.example.entities;

import org.example.service.impl.StoreServiceImpl;

import java.util.HashMap;

public class Cart {
    private HashMap<String, Product> customerCart;
    private Product product;
//    StoreServiceImpl service;

    public Cart() {
        this.customerCart = new HashMap<>();
    }


    public int getTotalQtyOfProductInCart(){
        int totalQty = 0;
        for (Product product : customerCart.values()){
            totalQty += product.getQuantity();
        }
        return totalQty;
    }
    public HashMap<String, Product> getCustomerCart() {
        return customerCart;
    }

    public void setCustomerCart(HashMap<String, Product> customerCart) {
        this.customerCart = customerCart;
    }

    public void addToMyCart(String productName, Product product) {
        this.customerCart.put(productName, product);
    }

    @Override
    public String toString() {
        return "Quantity{" +
                getTotalQtyOfProductInCart()+
                '}';
    }
}
