package test.data.broker;

import edu.ccri.lesson02.assignment.expense.Expense;

import java.util.ArrayList;

/**
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public interface AutomobileExpenseBroker
{

    /**
     * Returns the test data list
     *
     * @return the test data list
     */
    ArrayList<Expense> getTestDataList();
}
