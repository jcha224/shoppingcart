/**
 * TCSS 305 - SPRING 2016
 * Assignment 2 - Shopping Cart
 */

package model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Represents an Item.
 * 
 * @author John
 * @version 15 April 2016
 */
public final class Item {
    
    /** The name of item. */
    private final String myName;
    
    /** The price of item. */
    private final BigDecimal myPrice;
    
    /** The number of items necessary to receive bulk price. */
    private final BigDecimal myBulkQuantity;
    
    /** The bulk price of item. */
    private final BigDecimal myBulkPrice;
    
    /**
     * Constructs an item with a specific name and price.
     * 
     * @param theName the name of this item
     * @param thePrice the price of this item
     * @throws IllegalArgumentException if the price is less than 0
     */
    public Item(final String theName, final BigDecimal thePrice) { 
        if (thePrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException();
        }
        myName = theName;
        myPrice = thePrice;
        myBulkQuantity = BigDecimal.ZERO;
        myBulkPrice = BigDecimal.ZERO;
    }

    /**
     * Constructs an item with specific name, price, bulk price, 
     * and bulk quantity.
     * 
     * @param theName the name of this item
     * @param thePrice the price of this item
     * @param theBulkQuantity the quantity required for bulk price for this item
     * @param theBulkPrice the bulk price of item for this item
     * @throws IllegalArgumentException if price is less than 0
     * @throws IllegalArgumentException if bulk price is less than 0
     * @throws IllegalArgumentException if bulk quantity is less than 0
     */
    public Item(final String theName, final BigDecimal thePrice, 
                final int theBulkQuantity, 
                final BigDecimal theBulkPrice) {
        if (thePrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException();
        }
        if (theBulkQuantity <= 0) {
            throw new IllegalArgumentException();
        }
        if (theBulkPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException();
        }
        myName = theName;
        myPrice = thePrice;
        myBulkQuantity = BigDecimal.valueOf(theBulkQuantity);
        myBulkPrice = theBulkPrice;
    }

    /**
     * Calculates the total cost of item after bulk prices when 
     * applicable.
     * 
     * @param theQuantity the quantity of an item
     * @return total cost of item(s)
     */
    public BigDecimal calculateItemTotal(final int theQuantity) {
        final BigDecimal quantity = BigDecimal.valueOf(theQuantity);
        BigDecimal result = BigDecimal.ZERO;
        if (this.isBulk()) {
            result = quantity.divide(myBulkQuantity, BigDecimal.ROUND_FLOOR);
            result = result.multiply(myBulkQuantity);
            result = result.multiply(myBulkPrice).setScale(2, BigDecimal.ROUND_FLOOR);
            result = result.add(myPrice.multiply(quantity.remainder(myBulkQuantity)));
        } else {
            result = quantity.multiply(myPrice);
        }
        return result;
    }
    
    /**
     * Checks whether an item has bulk prices.
     * 
     * @return boolean of whether a item has bulk
     */
    public boolean isBulk() {
        boolean result = false;
        if (this.myBulkPrice != BigDecimal.ZERO) {
            result = true;
        }
        return result;
    }

    /**
     * String representation of Item will be formatted as follows:
     * for non-bulk items: "string, $value",
     * for bulk items: "string, $value (value for $value)".
     */
    @Override
    public String toString() {
        final String item = myName + ", $" + myPrice.toString();
        final StringBuilder result = new StringBuilder(item);
        if (this.isBulk()) {
            result.append(" (" + myBulkQuantity.toString() 
                          + " for $" + myBulkPrice.toString() + ")");
        }
        return result.toString();
    }
    
    /**
     * Compares two items for equality based on the name and price
     * for non-bulk items, and name, price, bulk price, and bulk quantity
     * for bulk items.
     * 
     * @param theOther the object that is compared
     * @return boolean whether the objects are equal
     */
    @Override
    public boolean equals(final Object theOther) {
        boolean result = true;
        if (theOther == null) {
            result = false;
        }
        final Item other = (Item) Objects.requireNonNull(theOther);
        if (!myName.equals(other.myName)) {
            result = false;
        }
        if (!myPrice.equals(other.myPrice)) {
            result = false;
        }
        if (!myBulkQuantity.equals(other.myBulkQuantity)) {
            result = false;
        }
        if (!myBulkPrice.equals(other.myBulkPrice)) {
            result = false;
        }
        return result;
    }

    /**
     * Converts item objects to hash code. 
     * 
     * @return the hashcode of item
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.myName, this.myPrice, 
                            this.myBulkQuantity, this.myBulkPrice);
    }
    
}
