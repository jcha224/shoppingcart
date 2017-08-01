/*
 * TCSS 305 - SPRING 2016
 * Assignment 2 - Shopping Cart
 */
package model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Represents an Item Order.
 * 
 * @author John
 * @version 15 April 2016
 */
public final class ItemOrder {
    
    /** An item object in an item order. */
    private final Item myItem;
    
    /** The number of items in an item order. */
    private final int myQuantity;

    /**
     * Constructs item order with a specific item and quantity.
     * 
     * @param theItem is an item in this item order
     * @param theQuantity the number of items in this item order
     */
    public ItemOrder(final Item theItem, final int theQuantity) {
        myItem = theItem;
        myQuantity = theQuantity;
    }

    /**
     * Calculates the total cost of an item order.
     * @return the cost for the item order
     * @throws NullPointerException if myItem is null
     */
    public BigDecimal calculateOrderTotal() {
        return Objects.requireNonNull(myItem).calculateItemTotal(myQuantity);
    }

    /**
     * Retrieves the Item in an item order.
     * 
     * @return the item in item order
     * @throws NullPointerException if myItem is null
     */
    public Item getItem() {
        return (Item) Objects.requireNonNull(myItem);
    }
    
    /**
     * Retrieves the quantity of items in an item order.
     * @return the quantity of items
     */
    public int getQuantity() {
        return myQuantity;
    }

    /**
     * String representation of this ItemOrder will be formatted as follows:
     * for non-bulk items: "value X string, $value = value",
     * for bulk items: "value X string, $value (value for $value) = value".
     */
    @Override
    public String toString() {
        return myQuantity + " X " + myItem.toString() + " = "
                        + this.calculateOrderTotal();
    }
    
}
