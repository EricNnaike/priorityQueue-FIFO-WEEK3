package org.example.entities;

import org.example.enums.Roles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueueClassTest {

    QueueClass queueClass;

    @BeforeEach
    void setUp() {
        queueClass = new QueueClass();
    }

    @Test
    @DisplayName("Should not add the user to the queue when the user is not a customer")
    void addToQueueWhenUserIsNotCustomer() {
        User user = new User(Roles.Manager, "John", 100);
        queueClass.addToQueue(user);
        assertEquals(0, queueClass.getQueue().size());
    }

    @Test
    @DisplayName("Should add the user to the queue when the user is a customer")
    void addToQueueWhenUserIsCustomer() {
        User user = new User(Roles.Customer, "John", 100);
        queueClass.addToQueue(user);
        assertEquals(1, queueClass.getQueue().size());
    }
    
}