package model.test;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    private Cart testCart;
    private Product a;
    private Product b;

    @BeforeEach
    void CreateCart() {
        testCart = new Cart();
        a = new Product(50,'a');
        b = new Product(30,'b');
    }

    @Test
    void test1() {
        Assertions.assertEquals(testCart.getTotalCount(), 0);
        Assertions.assertEquals(testCart.getUniqueCount(), 0);
    }
    @Test
    void testCounts(){
        testCart.addProduct(a,1);
        Assertions.assertEquals(1, testCart.getTotalCount());
        Assertions.assertEquals(1, testCart.getUniqueCount());
    }

    @Test
    void testCounts2(){
        testCart.addProduct(a,1);
        testCart.addProduct(b,1);
        Assertions.assertEquals(2, testCart.getTotalCount());
        Assertions.assertEquals(2, testCart.getUniqueCount());
    }

    @Test
    void testAddAndRemoveFromCart(){
        testCart.addProduct(a,1);
        testCart.addProduct(b,7);
        Assertions.assertEquals(testCart.getTotalCount(),8);

        testCart.removeProduct(a,1);
        Assertions.assertEquals(testCart.getTotalCount(),7);
    }

    @Test
    void testTotalValue(){
        testCart.addProduct(a,1);
        testCart.addProduct(b,7);
        Assertions.assertEquals(testCart.getCartTotal(),260);

    }

}