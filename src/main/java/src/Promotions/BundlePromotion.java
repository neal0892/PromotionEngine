package Promotions;

import model.*;

import java.util.HashMap;
import java.util.Map;

public class BundlePromotion implements Promotion{
    protected HashMap<Product, Double> promotionItems;
    protected double promotionPrice;

    public HashMap<Product, Double> getPromotionItems() {
        return promotionItems;
    }

    public double getPromotionPrice() {
        return promotionPrice;
    }

    public BundlePromotion(HashMap<Product, Double> Items, double Price) {
        this.promotionItems = Items;
        this.promotionPrice = Price;
    }

    public double getPromotionProductAmount(Product product){
        if (this.promotionItems.containsKey(product)){
            return this.promotionItems.get(product);
        }
        else{
            return 0;
        }
    }

    public boolean checkforRequiredProducts(Cart cart){//check if the cart contains the product also the quantiy in cart > reqd amount for prmotion
        for (Map.Entry<Product, Double> entry : this.promotionItems.entrySet()) {
            Product key = entry.getKey();
            double reqAmount = this.getPromotionProductAmount(key);
            if (!cart.containsProduct(key) || reqAmount > cart.getProductCount(key)) {
                return false;
            }
        }
        return true;
    }
    //    To get the applicable number of promotions for the bundle promotion
    public int countOfPromotionsApplicable(Cart cart){
        int minPromotions = Integer.MAX_VALUE;
        for (Map.Entry<Product, Double> entry : this.promotionItems.entrySet()) {
            Product key = entry.getKey();
            double reqAmount = this.getPromotionProductAmount(key);
            if (!cart.containsProduct(key) || reqAmount > cart.getProductCount(key)) {
                return 0;
            } else {
                minPromotions = Math.min(minPromotions, (int)Math.floor(cart.getProductCount(key)/reqAmount));
            }
        }
        return minPromotions;
    }

    @Override
    public boolean isPromotionEligible(Cart cart) {
        return this.checkforRequiredProducts(cart);
    }

    @Override
    public double getDiscountedTotal(Cart cart) {
        double totalPrice = 0;

        int minPromotionsApplicable = countOfPromotionsApplicable(cart);
        totalPrice += this.promotionPrice * minPromotionsApplicable;//add promotion discount to the sumtotal

        for (Map.Entry<Product,Double> entry: this.promotionItems.entrySet()){
            Product product = entry.getKey();
            double amount = entry.getValue();
            double amountForPromotion = this.promotionItems.get(product);
            //remaining price
            totalPrice += product.getPrice() * (amount - (amountForPromotion * minPromotionsApplicable));
        }

        return totalPrice;
    }
}
