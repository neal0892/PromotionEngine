package Promotions;

import model.*;

public class MultiItemsPromotion implements Promotion {
    protected Product product;
    protected double amount;
    protected double promotionPrice;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(double promotionPrice) {
        this.promotionPrice = promotionPrice;
    }


    public MultiItemsPromotion(Product product, double amount, double discountedPrice) {
        this.product = product;
        this.amount = amount;
        this.promotionPrice = discountedPrice;
    }

    @Override
    public boolean isPromotionEligible(Cart cartI) {
        double cartAmount ;
        if (cartI.getCart().containsKey(this.product)){
            cartAmount = cartI.getCart().get(this.product);
            return cartAmount >=this.amount;
        }
        return false;
    }

    @Override
    public double getDiscountedTotal(Cart cart) {
        double newPrice =0;
        if (cart.getCart().containsKey(this.product)){
            double cartAmount = cart.getCart().get(this.product);
            if (cartAmount >= this.amount){
                double nrPromotionsApplied = Math.floor(cartAmount/this.amount);
                newPrice =
                        nrPromotionsApplied * this.promotionPrice +
                                this.product.getPrice() * (cartAmount % this.amount);
                cart.updateProductAmount(this.product, cartAmount - nrPromotionsApplied * this.amount);
            }
            else {
                newPrice = cart.getCart().get(this.product) * this.product.getPrice();
            }
        }
        return newPrice;
    }
}
