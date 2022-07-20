package org.example.service.interfac;

//import org.example.entities.CustomerDTO;
import org.example.entities.Product;
import org.example.entities.User;

import java.util.Map;
import java.util.PriorityQueue;

public interface CustomerTransaction {
    public String buyProduct(User user, String productName, int quantity);
    public String printReceipt(User customer, Product product, int quantity);
//    void addToPriorityQueue(CustomerDTO customerDTO, Map<String, PriorityQueue<CustomerDTO>> priorityQueueMap, PriorityQueue priorityQueue);

//    CustomerDTO removeFromQueue(Map<String, PriorityQueue<CustomerDTO>> priorityQueueMap);
}
