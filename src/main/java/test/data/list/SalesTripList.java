package test.data.list;

import edu.ccri.lesson02.assignment.sales.SalesTrip;

import java.util.ArrayList;

/**
 * Sales trip test data
 * <p>
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class SalesTripList
{
    private ArrayList<SalesTrip> testDataList;

    /**
     * Defaults constructor
     */
    public SalesTripList()
    {
        this(true);
    }

    /**
     * Constructor
     *
     * @param create if true will create a new data list object
     */
    public SalesTripList(boolean create)
    {
        if (create)
        {
            this.testDataList = new ArrayList<SalesTrip>();
        }
    }

    /**
     * Get the test data list
     *
     * @return test data list
     */
    public ArrayList<SalesTrip> getTestDataList()
    {
        return testDataList;
    }

    /**
     * Set the test data list
     *
     * @param testDataList the list to set
     */
    public void setTestDataList(ArrayList<SalesTrip> testDataList)
    {
        this.testDataList = testDataList;
    }


}
