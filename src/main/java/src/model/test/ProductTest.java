package model.test;

import model.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @org.junit.jupiter.api.Test
    public void createProduct(){
        Product a1 = new Product(50,'a');
        Assertions.assertEquals('a',a1.getSku_id());
        Assertions.assertEquals(50,a1.getPrice());
        Assertions.assertNotEquals(0,a1.getPrice());

    }

}