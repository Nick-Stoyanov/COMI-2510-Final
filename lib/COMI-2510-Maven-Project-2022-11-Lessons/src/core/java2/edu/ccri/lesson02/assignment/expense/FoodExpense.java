/**
 * Food expense
 */
package edu.ccri.lesson02.assignment.expense;

/**
 * Food expense
 *
 * @author dean grammas
 */
public class FoodExpense extends Expense
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
    public FoodExpense(String name, double expense)
    {
	super(name, expense);
    }
}
