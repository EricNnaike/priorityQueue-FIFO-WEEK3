package org.example.service.impl;

import lombok.Getter;
import lombok.Setter;
import org.example.entities.*;
import org.example.enums.Roles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Setter
@Getter
public class StoreServiceImpl {
    private BufferedReader reader;
    Store store;
    QueueClass queueClass;
    CashierTransactionsImpl cti = new CashierTransactionsImpl();

    public void readProduct(String path) throws IOException {
        HashMap<String, Product> stockList = this.store.getStockList();
        reader = new BufferedReader(new FileReader(path));
        String read = "";
        reader.readLine();
        while ((read = reader.readLine()) != null) {
            String[] productArray = read.split(",");
            String name = productArray[4];
            double price = Double.parseDouble(productArray[6]);
            int quantity = Integer.parseInt(productArray[5]);
            String category = productArray[3];
            if (stockList.containsKey(name)) {
                Product productInStore = stockList.get(name);
                productInStore.setQuantity(productInStore.getQuantity() + quantity);
            } else {
                Product newProduct = new Product(name, price, quantity, category);
                stockList.put(name, newProduct);
            }
        }
        reader.close();
    }

    public void addToCustomerCart(User customer, String productName, int qty) {
        Cart customerCart = customer.getCart();
        if (store.getStockList().containsKey(productName)) {
            if (qty <= store.getStockList().get(productName).getQuantity()) {
                Product productInStore = store.getStockList().get(productName);
                Product purchasedProduct = new Product(productInStore.getName(), productInStore.getPrice(), qty, productInStore.getCategory());
                customerCart.addToMyCart(productInStore.getName(), purchasedProduct);
                productInStore.setQuantity(productInStore.getQuantity() - qty);
//                System.out.println("Successfully added " + productInStore.getName() + " in your cart");
            } else {
                System.out.println("OUT OF STOCK");
            }
        } else {
            System.out.println("Product not available");
        }
    }

    public boolean fifoSell(Queue<User> listQueue, User cashier) {
       if(!listQueue.isEmpty()){
           if (cashier.getRole().equals(Roles.Cashier)){
               for (int i = 0; i <= listQueue.size()+3 ; i++){
                   User user1 = listQueue.remove();
                   sellProduct(cashier, user1);
               }
           }
       }
        return false;
    }
    public String prioritySellQue(PriorityQueue<User> listQueue, User cashier) {
        String message = "";
        if (cashier.getRole().equals(Roles.Cashier)) {
            for (int i = 0; i <= listQueue.size()+2; i++) {
                User user1 = listQueue.remove();
                message = user1.getName()+" sold";
                sellProduct(cashier, user1);
                message = "sold";
            }
        }else {
            message = "Not A cashier";
        }
        return message;
    }

    public boolean sellProduct(User cashier, User customer) {
        HashMap<String, Product> cartProduct = customer.getCart().getCustomerCart();
        double totalPrice = 0;
        for (Product product : cartProduct.values()) {
            totalPrice += product.getPrice();
        }
        if (cashier.getRole().equals(Roles.Cashier)) {
            if (customer.getWallet().getAmount() >= totalPrice) {
                customer.getWallet().setAmount(customer.getWallet().getAmount() - totalPrice);
                //print receipt
                cti.printReceipt(customer);
                return true;
            } else {
                // return the product into the store as your money no reach.
                for (Product productInCustomerCart : cartProduct.values()) {
                    Product productInStore = store.getStockList().get(productInCustomerCart.getName());
                    productInStore.setQuantity(productInStore.getQuantity() + productInCustomerCart.getQuantity());
                }
                System.out.println("Insufficient funds");
                return false;
            }
        }
        System.out.println("Only a cashier can make a sale");
        return false;
    }

}


