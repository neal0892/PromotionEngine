package model;

public class Product {

    private double price;
    private char sku_id;

    public Product(double price, char sku_id) {
        this.price = price;
        this.sku_id = sku_id;
    }

    public char getSku_id() {
        return sku_id;
    }

    public void setSku_id(char sku_id) {
        this.sku_id = sku_id;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }




}
