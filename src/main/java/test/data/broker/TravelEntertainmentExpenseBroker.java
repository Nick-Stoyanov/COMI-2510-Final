package test.data.broker;

import edu.ccri.lesson02.assignment.expense.TravelEntertainmentExpense;

import java.util.ArrayList;

/**
 * 1/30/2023
 *
 * @author Nick Stoyanov
 * <p>
 * Travel entertainment expense broker
 */
public interface TravelEntertainmentExpenseBroker
{
    /**
     * Return the test data list
     *
     * @return the test data list
     */
    ArrayList<TravelEntertainmentExpense> getTestDataList();
}
