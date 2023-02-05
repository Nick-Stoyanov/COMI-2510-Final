package test.data.list;

import edu.ccri.lesson02.assignment.expense.Expense;

import java.util.ArrayList;

/**
 * The Expense list
 * <p>
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class ExpenseList
{
    private ArrayList<Expense> testDataList;

    /**
     * Default constructor
     */
    public ExpenseList()
    {
        super();
    }

    /**
     * Constructor
     *
     * @param create if true will create a new data list object
     */
    public ExpenseList(Boolean create)
    {
        super();

        if (create)
        {
            this.testDataList = new ArrayList<Expense>();
        }
    }

    /**
     * Returns the test data list
     *
     * @return the test data list
     */
    public ArrayList<Expense> getTestDataList()
    {
        return testDataList;
    }

    /**
     * Set the test data list
     *
     * @param testDataList the list to set
     */
    public void setTestDataList(ArrayList<Expense> testDataList)
    {
        this.testDataList = testDataList;
    }


}
