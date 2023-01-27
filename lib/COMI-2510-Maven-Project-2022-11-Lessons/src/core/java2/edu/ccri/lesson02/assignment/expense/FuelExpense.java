package edu.ccri.lesson02.assignment.expense;

/**
 * Fuel expense
 *
 * @author dean grammas
 */
public class FuelExpense extends Expense
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
    public FuelExpense(String name, double expense)
    {
	super(name, expense);
    }
}
