package test.data.list;

import edu.ccri.lesson02.assignment.expense.TravelEntertainmentExpense;

import java.util.ArrayList;

/**
 * Travel and entertainment test data list
 * <p>
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class TravelEntertainmentExpenseList
{
    private ArrayList<TravelEntertainmentExpense> testDataList;

    /**
     * Constructor
     */
    public TravelEntertainmentExpenseList()
    {
        this(true);
    }

    /**
     * Constructor
     *
     * @param create if true will create a new data list object
     */
    public TravelEntertainmentExpenseList(boolean create)
    {
        if (create)
        {
            this.testDataList = new ArrayList<TravelEntertainmentExpense>();
        }
    }

    /**
     * Get the test data list
     *
     * @return the test data list
     */
    public ArrayList<TravelEntertainmentExpense> getTestDataList()
    {
        return this.testDataList;
    }

    /**
     * Set the test data list
     *
     * @param testDataList the list to set
     */
    public void setTestDataList(ArrayList<TravelEntertainmentExpense> testDataList)
    {
        this.testDataList = testDataList;
    }
}
