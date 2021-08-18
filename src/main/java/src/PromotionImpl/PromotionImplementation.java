package PromotionImpl;

import Promotions.BundlePromotion;
import Promotions.Promotion;
import Promotions.MultiItemsPromotion;
import model.*;

import java.util.List;

public class PromotionImplementation {

    public double getDiscountedPrice(Cart cart, List<Promotion> promotions) {
        double discountedPrice = 0;
        for (Promotion promotion : promotions) {
            if (promotion.isPromotionEligible(cart)) {
                // Apply promotion
                discountedPrice += promotion.getDiscountedTotal(cart);
                System.out.println(discountedPrice);
                if (promotion instanceof BundlePromotion){
                    // remove products of the same promotion from cart
                    // since they are already accounted for
                    for (Product product : ((BundlePromotion) promotion).getPromotionItems().keySet()){
                        cart.updateProductAmount(product, 0);
                    }
                } else {
                    //in case of nItemsPromotion
                    cart.updateProductAmount(((MultiItemsPromotion)promotion).getProduct(), 0);
                }
            }
        }

        for(Product product : cart.getCart().keySet()) {
            discountedPrice += product.getPrice() * cart.getCart().get(product);
        }
        return discountedPrice;
    }
}

