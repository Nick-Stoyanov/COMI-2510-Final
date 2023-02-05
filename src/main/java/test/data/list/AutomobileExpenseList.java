package test.data.list;

import edu.ccri.lesson02.assignment.dashboard.Automobile;

import java.util.ArrayList;

/**
 * Automobile expense test data list
 * <p>
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class AutomobileExpenseList
{
    private ArrayList<Automobile> testDataList;

    /**
     * Default Constructor
     */
    public AutomobileExpenseList()
    {
        super();
    }

    /**
     * Constructor
     *
     * @param create create new list if true
     */
    public AutomobileExpenseList(boolean create)
    {
        super();
        if (create)
        {
            this.testDataList = new ArrayList<Automobile>();
        }
    }

    /**
     * Get the test data list
     *
     * @return the test data list
     */
    public ArrayList<Automobile> getTestDataList()
    {
        return testDataList;
    }

    /**
     * Set the test data list
     *
     * @param testDataList list to set
     */
    public void setTestDataList(ArrayList<Automobile> testDataList)
    {
        this.testDataList = testDataList;
    }
}
