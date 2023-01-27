/**
 * Purchase Price expense
 */
package edu.ccri.lesson02.assignment.expense;

/**
 * Purchase Price expense
 *
 * @author dean grammas
 */
public class PurchasePriceExpense extends Expense
{
    /**
     * Constructor <BR>
     * <UL>
     * <LI>Calls super class constructor
     * </UL>
     * <BR>
     *
     * @param name    the name of the expense
     * @param expense the expense amount
     */
    public PurchasePriceExpense(String name, double expense)
    {
	super(name, expense);
    }
}
