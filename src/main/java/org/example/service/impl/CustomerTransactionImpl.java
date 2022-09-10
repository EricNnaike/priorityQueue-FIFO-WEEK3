package org.example.service.impl;

//import org.example.entities.CustomerDTO;
import org.example.entities.Product;
import org.example.entities.Store;
import org.example.entities.User;
import org.example.enums.Roles;
import org.example.service.interfac.CustomerTransaction;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class CustomerTransactionImpl implements CustomerTransaction {

    @Override
    public String buyProduct(User user, String productName, int quantity) {
        String output = "";
        if (user.getRole().equals(Roles.Customer)) {
            
        }else {
            output = "Only customers can buy product";
        }
        return output;
    }


    @Override
    public String printReceipt(User customer, Product product, int quantity) {
        String output = "";
        return output= "Receipt\nName: " +product.getName()+ "\nPrice: $"+
                product.getPrice()+ "\nQuantity purchased: "+ quantity+
                "\nSold to "+customer.getName()+" on "+ LocalDate.now();
    }

    public void searchCategory(String category) {
        //todo; Search products by category
        for (Product entry: Store.stockList.values()){
            if (entry.getCategory().equalsIgnoreCase(category)) {
                System.out.println(entry);
            }
        }
    }

}
