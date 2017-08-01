/**
 * TCSS 305 - SPRING 2016
 * Assignment 2 - Shopping Cart
 */

package model;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for Item class.
 * 
 * @author John
 * @version 15 April 2016
 */
public class TestItem {

    /** A tolerance for comparing doubles. */
    private static final double TOLERANCE = .000001;
    
    /** The Item object that will be tested. */
    private Item myItem1;
    
    /** Second Item object that will be tested. */
    private Item myItem2;
    
    /**
     * This method prepares the Item object before every test.
     */
    @Before
    public void prepItem() {
        final BigDecimal price = new BigDecimal("0.5");
        final BigDecimal price2 = new BigDecimal("1.0");
        final int bulkQuantity = 5;
        final BigDecimal bulkPrice = new BigDecimal("0.2");
        myItem1 = new Item("pen", price);
        myItem2 = new Item("paper", price2, bulkQuantity, bulkPrice);
    }
    
    /**
     * This method tests for IllegalArgumentException in 
     * Item(String, BigDecimal) from thePrice.
     */
    @Test(expected = IllegalArgumentException.class) 
    public void testPriceException() {
        new Item("ink", new BigDecimal("-1"));
    }
    
    /**
     * This method tests for IllegalArgumentException in 
     * Item(String, BigDecimal, integer, BigDecimal) from thePrice.
     */
    @Test(expected = IllegalArgumentException.class) 
    public void testSecondPriceException() {
        final int test = 5;
        new Item("lead", new BigDecimal("-2"), test, BigDecimal.TEN);
    }
    
    /**
     * This method tests for IllegalArgumentException in 
     * Item(String, BigDecimal, integer, BigDecimal) 
     * from theBulkQuantity.
     */
    @Test(expected = IllegalArgumentException.class) 
    public void testBulkQuantityException() {
        new Item("rock", BigDecimal.TEN, 0, BigDecimal.TEN);
    }
    
    /**
     * This method tests for IllegalArgumentException in 
     * Item(String, BigDecimal, integer, BigDecimal) 
     * from theBulkPrice.
     */
    @Test(expected = IllegalArgumentException.class) 
    public void testBulkPriceException() {
        final int test = 9;
        new Item("glue", BigDecimal.TEN, test, BigDecimal.ZERO);
    }
    
    /**
     * This method tests for NullPointerException in 
     * isBulk().
     */
    @Test(expected = NullPointerException.class) 
    public void testIsBulkException() {
        final int test = 11;
        final Item testItem = new Item("shoe", null, test, BigDecimal.TEN);
        testItem.isBulk();
    }
    
    /**
     * This method tests for NullPointerException in 
     * equals().
     */
    @Test(expected = NullPointerException.class) 
    public void testEqualsException() {
        final Item test = null;
        myItem1.equals(test);
    }
    
    /**
     * Test method for {@link Item#Item(String, BigDecimal)}.
     */
    @Test
    public void testItem() {
        final String actual = "pen, $0.5";
        assertEquals("First constructor did not work", actual,
                     myItem1.toString());
    }
    
    /**
     * Test method for {@link Item#Item(String, BigDecimal, integer, BigDecimal)}.
     */
    @Test
    public void testItem2() {
        final String actual = "paper, $1.0 (5 for $0.2)";
        assertEquals("Second constructor did not work", actual,
                     myItem2.toString());
    }
    
    /**
     * Test method for {@link Item#calculateItemTotal(integer)}.
     */
    @Test
    public void testCalculateItemTotal() {
        final int test = 2;
        BigDecimal actual =  new BigDecimal("0.5");
        actual = actual.multiply(BigDecimal.valueOf(test));
        assertEquals("calculateItemTotal failed to get total!", 
                     actual,
                     myItem1.calculateItemTotal(test));
    }
    
    /**
     * Test method for {@link Item#calculateItemTotal(integer)}.
     */
    @Test
    public void testBulkCalculateItemTotal() {
        final int test = 6;
        final double num = 5.0;
        final double num1 = 0.2;
        final double num2 = 1.0;
        BigDecimal actual = BigDecimal.valueOf(num);
        actual = actual.multiply(BigDecimal.valueOf(num1));
        actual = actual.add(BigDecimal.valueOf(num2));
        assertEquals("calculateItemTotal failed to get bulk total!", actual,
                     myItem2.calculateItemTotal(test));
    }
    
    /**
     * Test method for {@link Item#isBulk()}.
     */
    @Test
    public void testNotIsBulk() {
        assertEquals("isBulk test 1 failed to produce correct boolean!", false,
                     myItem1.isBulk());
    }
    
    /**
     * Test method for {@link Item#isBulk()}.
     */
    @Test
    public void testIsBulk() {
        assertEquals("isBulk test 2 failed to produce correct boolean!", true,
                     myItem2.isBulk());
    }
    
    /**
     * Test method for {@link Item#equals(Object)}.
     */
    @Test
    public void testIsEquals() {
        final Item test = myItem1;
        assertEquals("equals failed to produce correct boolean!", true,
                     test.equals(myItem1));
    }
    /**
     * Test method for {@link Item#equals(Object)}.
     */
    @Test
    public void testIsNotEquals() {
        assertFalse("not equals failed to produce correct boolean!",
                     myItem2.equals(myItem1));
    }
    /**
     * Test method for {@link Item#hashCode()}.
     */
    @Test
    public void testHashCode() {
        final int actual = myItem1.hashCode();
        assertEquals("hashCode failed to produce correct hashcode!", actual,
                     myItem1.hashCode());
    }
}






