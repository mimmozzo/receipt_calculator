/**
 * This package contains the implementation of a receipt calculator
 * according to the specifications sent via e-mail.
 * ReceiptCalculator class is the entry point. TestReceiptCalculator contains the 
 * 3 test cases presented in the specifications.
 * The entire implementation took about 5 hours, including Travis CI setup.
 * 
 * Possible improvements:
 *  1) Add an underlying database to store tax rates per product/product category
 *  2) Use Spring to manage dependency injection instead of instantiating beans inside
 *     ReceiptCalculator constructor
 *  3) Use BigDecimal to implement Money class
 *  4) Extract the Money formatter logic from toString
 * Notes:
 *  - according to the specifications, the third test case was wrong, I corrected it.
 *    please have a look at the TestReceiptCalculator class.
 *  - I used JUnit version 3 because it was available out-of-the-box on Travis
 */
package me.drdo.altan;