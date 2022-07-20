package org.example.entities;

import org.example.enums.Roles;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueClass {

    public static Queue<User> queue = new LinkedList<>();
    public static Queue<User> priorityQue = new PriorityQueue<>((a, b) ->
            Integer.compare(b.getCart().getTotalQtyOfProductInCart(),
                    a.getCart().getTotalQtyOfProductInCart()));
    Product product;

    public QueueClass() {

    }

    public Queue<User> getPriorityQue() {
        return priorityQue;
    }
    public Queue<User> getQueue() {
        return queue;
    }

    public void setQueue(Queue<User> queue) {
        QueueClass.queue = queue;
    }

    public void setPriorityQue(Queue<User> priorityQue) {
        QueueClass.priorityQue = priorityQue;
    }

    public void addToQueue(User user) {
        if (user.getRole().equals(Roles.Customer)) {
            queue.add(user);
        }
    }

    public void processQueue(){
        while (queue.peek() != null) {
            System.out.println(queue.poll());
        }
    }
}
