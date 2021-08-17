package model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    public HashMap<Product, Double> cart;

    public Cart() {
        this.cart = new HashMap<>();
    }


    public void addProduct(Product product, double amount) {
        double newAmount = amount;
        if(this.cart.containsKey(product)){
            double oldAmount = this.cart.get(product);
            newAmount = oldAmount + newAmount;
        }
        this.cart.put(product,newAmount);
    }

    public void removeProduct(Product product, double amount) {
        double oldAmount;
        double newAmount = 0;
        if (this.cart.containsKey(product)){
            oldAmount = this.cart.get(product);
            newAmount = oldAmount - amount >= 0 ? oldAmount - amount: 0;
        }
        this.updateProductAmount(product,newAmount);
    }


    public int getUniqueCount() {
        return this.cart.size();
    }

    public double getTotalCount() {//total items in the cart
        double totalCount = 0;
        for (Map.Entry<Product, Double> entry : this.cart.entrySet()) {
            Double integer = entry.getValue();
            totalCount = totalCount + integer;
        }
        return totalCount;
    }


    public HashMap<Product, Double> getCart() {
        return this.cart;
    }


        public Double getProductCount(Product product) {//number of unique product
        return this.cart.getOrDefault(product, (double) 0);

    }

    public boolean containsProduct(Product product) {//checks if a product exists in the cart
        return this.getCart().containsKey(product);
    }


    public void updateProductAmount(Product product, double newAmount) {
        if (newAmount>0){//update in case of non zero product amount
            this.cart.put(product,newAmount);
        }
        else {//remove the product from cart
            this.cart.remove(product);
        }
    }

    public double getCartTotal() {//total value in the cart
        double cartTotal = 0;
        HashMap<Product, Double> cartItems = this.getCart();

        for (Map.Entry<Product, Double> entry : cartItems.entrySet()) {
            cartTotal = cartTotal + entry.getKey().getPrice() * entry.getValue();
        }
        return cartTotal;
    }
}