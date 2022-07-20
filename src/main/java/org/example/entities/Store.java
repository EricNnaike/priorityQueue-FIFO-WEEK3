package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
public class Store {
    public static HashMap<String, Product> stockList = new HashMap<>();


    public HashMap<String, Product> getStockList() {
        return stockList;
    }

    public void setStockList(HashMap<String, Product> stockList) {
        Store.stockList = stockList;
    }

//    public List<Product> searchCategory(String category) {
//        return productsInStore.stream().filter(product ->
//                product.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
//    }

}
