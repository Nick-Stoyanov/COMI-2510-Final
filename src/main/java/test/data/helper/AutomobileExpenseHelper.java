package test.data.helper;

import edu.ccri.lesson02.assignment.expense.*;

import java.util.List;

/**
 * 1/30/2023
 *
 * @author Nick Stoyanov
 * <p>
 * Automobile expense helper
 */
public class AutomobileExpenseHelper
{
    /**
     * Constructor
     */
    public AutomobileExpenseHelper()
    {
        super();
    }

    /**
     * Adds the expenses to the test data list
     *
     * @param testDataList  list
     * @param name          name of expense
     * @param purchasePrice cost of purchase
     * @param oilChange     cost of oil change
     * @param gasPerUnit    cost of gas per gallon
     * @param fourTires     cost for tire change
     */
    public static void addExpense(List<Expense> testDataList, String name, double purchasePrice, double oilChange, double gasPerUnit, double fourTires)
    {
        Expense expense;

        expense = new PurchasePriceExpense(name, purchasePrice);
        testDataList.add(expense);

        expense = new OilExpense(name, oilChange);
        testDataList.add(expense);

        expense = new FuelExpense(name, gasPerUnit);
        testDataList.add(expense);

        expense = new TireExpense(name, fourTires);
        testDataList.add(expense);

    }

    /**
     * Loop through the list of expenses and return the expense which matches the type and name requested
     *
     * @param testDataList the list to search
     * @param name         the expense name
     * @return the fuel expense
     */
    public static Expense getFuelExpense(List<Expense> testDataList, String name)
    {
        Expense expense = null;

        for (Expense value : testDataList)
        {
            if (value instanceof FuelExpense && value.getName().equals(name))
            {
                expense = value;
            }
        }
        return expense;
    }

    /**
     * Loop through the list of expenses and return the expense which matches the type and name requested
     *
     * @param testDataList the list ot search
     * @param name         the name of the expense
     * @return the oil Expense
     */
    public static Expense getOilExpense(List<Expense> testDataList, String name)
    {
        Expense expense = null;

        for (Expense value : testDataList)
        {
            if (value instanceof OilExpense && value.getName().equals(name))
            {
                expense = value;
            }
        }
        return expense;
    }

    /**
     * Loop through the list of expenses and return the expense which matches the type and name requested
     *
     * @param testDataList the list to search
     * @param name         the name of the expense
     * @return the Purchase Price Expense
     */
    public static Expense getPurchasePriceExpense(List<Expense> testDataList,
                                                  String name)
    {
        Expense expense = null;

        for (Expense value : testDataList)
        {
            if (value instanceof PurchasePriceExpense && value.getName().equals(name))
            {
                expense = value;
            }
        }
        return expense;
    }

    /**
     * Loop through the list of expenses and return the expense which matches the type and name requested
     *
     * @param testDataList the list to search
     * @param name         the name of the expense
     * @return the Tire Expense
     */
    public static Expense getTireExpense(List<Expense> testDataList,
                                         String name)
    {

        Expense expense = null;

        for (Expense value : testDataList)
        {
            if (value instanceof TireExpense && value.getName().equals(name))
            {
                expense = value;
            }
        }
        return expense;

    }


}
