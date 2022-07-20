package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Roles;
import org.example.service.impl.CashierTransactionsImpl;

import java.util.Comparator;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private String name;
    private int qty;
    private Roles role;
    private Wallet wallet;
    private Cart cart;
    private int assessmentScore;
    CashierTransactionsImpl transact;
    Product product;

    public User(Roles role, String name, double walletAmount) {
        this.name = name;
        this.role = role;
        this.wallet = new Wallet(walletAmount);
        this.cart = new Cart();
        this.transact = new CashierTransactionsImpl();
    }

//    public User(User customer, int qty) {
//        this.name = customer.getName();
//        this.qty = customer.getCart().getTotalQtyOfProductInCart();
//    }
    public User(int assessmentScore, String name, Roles role) {
        this.name = name;
        this.role = role;
        this.assessmentScore = assessmentScore;
    }

    public CashierTransactionsImpl getTransact() {
        return transact;
    }


    public void loadWallet(double amount) {
        wallet.setAmount(amount);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", qty=" + qty +
                ", role=" + role +
                ", wallet=" + wallet +
                ", cart=" + cart +
                '}';
    }


//    @Override
//    public int compare(User a, User b) {
//        int aTotal = a.getCart().getTotalQtyOfProductInCart();
//        int bTotal = b.getCart().getTotalQtyOfProductInCart();
//        if ( aTotal == bTotal){
//            return 0;
//        }else if (aTotal < bTotal){
//            return 1;
//        }
//        return -1;
//    }



}
