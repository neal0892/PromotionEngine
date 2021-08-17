package main;

import model.Cart;
import model.Product;

public class App {

    public static void main(String[] args) {
        Product p1 = new Product(30,'a');
        Product p2 = new Product(20,'a');
        Product p3 = new Product(10,'a');

        Cart cart1 = new Cart();
        cart1.addProduct(p1,1);
        cart1.addProduct(p2,3);
        cart1.removeProduct(p2,1);
        cart1.addProduct(p3,2);

        System.out.println(cart1.getProductCount(p2));
        System.out.println(cart1.getUniqueCount());
        System.out.println(cart1.getCartTotal());
    }

}
