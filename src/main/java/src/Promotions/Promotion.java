package Promotions;

import model.Cart;

public interface Promotion {
    boolean isPromotionEligible(Cart cart);
    double getDiscountedTotal(Cart cart);
}
