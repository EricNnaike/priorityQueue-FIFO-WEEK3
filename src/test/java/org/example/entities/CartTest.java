package org.example.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartTest {

    @Test
    @DisplayName("Should add the product to the cart when the product is not in the cart")
    void addToMyCartWhenProductIsNotInTheCart() {
        Cart cart = new Cart();
        Product product = new Product("Milk", 2.5, 2, "Food");
        cart.addToMyCart("Milk", product);
        assertEquals(1, cart.getCustomerCart().size());
    }

    @Test
    @DisplayName(
            "Should update the quantity of the product in the cart when the product is already in the cart")
    void addToMyCartWhenProductIsAlreadyInTheCartThenUpdateQuantity() {
        Cart cart = new Cart();
        Product product = new Product("Milk", 2.5, 2, "Food");
        cart.addToMyCart("Milk", product);
        cart.addToMyCart("Milk", product);
        assertEquals(2, cart.getTotalQtyOfProductInCart());
    }
}