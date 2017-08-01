/*
 * TCSS 305 - SPRING 2016
 * Assignment 2 - Shopping Cart
 */

package model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a Shopping Cart.
 * 
 * @author John
 * @version 15 April 2016
 */
public class ShoppingCart {
    /** Discount value for users with membership. */
    public static final BigDecimal DISCOUNT = new BigDecimal("0.9");
    
    /** A list of items in a shopping cart. */
    private final Map<Item, BigDecimal> myCart;
    
    /** Whether or not there is a membership. */
    private boolean myMembership;

    /**
     * Constructs the shopping cart map.
     */
    public ShoppingCart() {
        myCart = new HashMap<Item, BigDecimal>();
    }

    /**
     * Appends an item order to the shopping cart.
     * 
     * @param theOrder the item order that will be added to shopping cart
     * @throws NullPointerException if the order is null
     */
    public void add(final ItemOrder theOrder) {
        myCart.put(Objects.requireNonNull(theOrder).getItem(), 
                   theOrder.calculateOrderTotal());
    }

    /**
     * Sets the membership status to true or false. 
     * 
     * @param theMembership whether or not the user has membership
     */
    public void setMembership(final boolean theMembership) {
        myMembership = theMembership;
    }

    /**
     * Calculates the total cost of shopping cart and includes membership discount
     * if applicable.
     * 
     * @return the total cost of cart
     */
    public BigDecimal calculateTotal() {
        final Iterator<Item> itr = myCart.keySet().iterator();
        BigDecimal total = BigDecimal.ZERO;
        while (itr.hasNext()) {
            total = total.add(myCart.get(itr.next()));
        }
        if (myMembership) {
            total = total.multiply(DISCOUNT);
        }
        return total.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
    
    /**
     * Clears the shopping cart.
     */
    public void clear() {
        myCart.clear();
    }

    /**
     * String representation of Shopping cart will be represented as follows:
     * for non-bulk items: "value X string, $value = value",
     * for bulk items: "value X string, $value (value for $value) = value"
     * .. Total: value".
     */
    @Override
    public String toString() {
        final StringBuilder receipt = new StringBuilder();
        final Iterator<Item> itr = myCart.keySet().iterator();
        while (itr.hasNext()) {
            receipt.append(itr.next().toString() + '\n');
        }
        receipt.append('=' + ' ' + this.calculateTotal().toString());
        return receipt.toString();
    }

}
