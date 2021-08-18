package model.test;

import PromotionImpl.PromotionImplementation;
import Promotions.BundlePromotion;
import Promotions.Promotion;
import Promotions.MultiItemsPromotion;
import model.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class UseCasesTest {

    private Product a, b, c, d;
    private Cart cart;
    private HashMap<Product,Double> discountedItems;
    private List<Promotion> promotions;
    private PromotionImplementation promoImpl;

    @BeforeEach
    void initializeEnvironment(){
        a = new Product(50,'a');
        b = new Product(30,'b');
        c = new Product(20,'c');
        d = new Product(15,'d');
        cart = new Cart();
        discountedItems = new HashMap<>();
        promotions = new ArrayList<>();
        promoImpl = new PromotionImplementation();
    }
    @Test
    void test1() {
        cart.addProduct(a, 1);
        cart.addProduct(b,1);
        cart.addProduct(c,1);

        discountedItems.put(c,(double)1);
        discountedItems.put(d,(double)1);

        promotions.add(new MultiItemsPromotion(a,3,130));
        promotions.add(new MultiItemsPromotion(b,2,45));
        promotions.add(new BundlePromotion(discountedItems,30));

        Assertions.assertEquals(100, promoImpl.getDiscountedPrice(cart,promotions));
    }
    @Test
    void test2() {
        cart.addProduct(a, 5);
        cart.addProduct(b,5);
        cart.addProduct(c,1);

        discountedItems.put(c,(double)1);
        discountedItems.put(d,(double)1);

        promotions.add(new MultiItemsPromotion(a,3,130));
        promotions.add(new MultiItemsPromotion(b,2,45));
        promotions.add(new BundlePromotion(discountedItems,30));

        Assertions.assertEquals(370, promoImpl.getDiscountedPrice(cart,promotions));
    }
    @Test
    void test3() {
        cart.addProduct(a, 3);
        cart.addProduct(b,5);
        cart.addProduct(c,1);
        cart.addProduct(d,1);

        discountedItems.put(c,(double)1);
        discountedItems.put(d,(double)1);

        promotions.add(new MultiItemsPromotion(a,3,130));
        promotions.add(new MultiItemsPromotion(b,2,45));
        promotions.add(new BundlePromotion(discountedItems,30));

        Assertions.assertEquals(280, promoImpl.getDiscountedPrice(cart,promotions));
    }

}