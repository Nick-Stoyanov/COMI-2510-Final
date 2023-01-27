/**
 * Hotel expense
 */
package edu.ccri.lesson02.assignment.expense;

/**
 * Hotel expense
 *
 * @author dean grammas
 */
public class HotelExpense extends Expense
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
    public HotelExpense(String name, double expense)
    {
	super(name, expense);
    }
}
