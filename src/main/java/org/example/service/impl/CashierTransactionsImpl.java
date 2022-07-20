package org.example.service.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entities.Product;
import org.example.entities.User;
import org.example.service.interfac.CashierTransactions;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class CashierTransactionsImpl implements CashierTransactions {
    private Product product;

    /**
     * this method implements selling of a product
     * By the cashier to the customer
     */

    @Override
    public void printReceipt(User customer) {
        //loop through the customer cart
        // print the name of all the product and their total price
        for (Product entry : customer.getCart().getCustomerCart().values()){
            System.out.println("Recipt for customer "+ customer.getName()+":\nProduct :"+entry.getName()+"\nPrice"+ entry.getPrice()+"" +
                    "\nQuantity "+ entry.getQuantity()+"\nTotal price "+ entry.getPrice() * entry.getQuantity());
            System.out.println();
        }
    }

}



