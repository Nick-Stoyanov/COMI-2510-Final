package test.data.fixed;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;
import edu.ccri.lesson02.assignment.sales.SalesTrip;
import test.data.TestDataSourceFixed;
import test.data.broker.SalesTripBroker;
import test.data.broker.TestDataSourceBroker;
import test.data.helper.SalesTripHelper;
import test.data.list.SalesTripList;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Sales trip fixed test data source
 * <p>
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class SalesTripFixed extends TestDataSourceFixed implements SalesTripBroker, TestDataSourceBroker
{
    private SalesTripList testDataList = new SalesTripList();

    /**
     * Constructor
     */
    public SalesTripFixed()
    {
        super();
        this.setKey(UniqueKeyCounter.getInternalCounter());
    }


    /**
     * Returns the test data list
     *
     * @return the test data list
     */
    @Override
    public ArrayList<SalesTrip> getTestDataList()
    {
        return this.testDataList.getTestDataList();
    }

    /**
     * Stage the data for testing
     */
    @Override
    public void stageTestData()
    {
        SalesTripHelper.addExpense(this.getTestDataList(), "Providence", "Miami", 22.5, 1462.7);
        SalesTripHelper.addExpense(this.getTestDataList(), "Miami", "Dallas", 19.75, 1309.1);
        SalesTripHelper.addExpense(this.getTestDataList(), "Dallas", "Los Angeles", 21.5, 1435.7);
        SalesTripHelper.addExpense(this.getTestDataList(), "Los Angeles", "Seattle", 17.9, 1135.1);
        SalesTripHelper.addExpense(this.getTestDataList(), "Seattle", "Chicago", 31, 2042.8);
        SalesTripHelper.addExpense(this.getTestDataList(), "Chicago", "New York", 12.2, 788.9);
        SalesTripHelper.addExpense(this.getTestDataList(), "New York", "Providence", 3.5, 180.9);

    }

    /**
     * Returns a string representation of the object
     *
     * @return a string representation of the object
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(this.getClass());
        Iterator<SalesTrip> i = this.getTestDataList().iterator();
        SalesTrip salesTrip = null;

        while (i.hasNext())
        {
            salesTrip = i.next();
            sb.append("\n").append(salesTrip.toString());
        }

        return sb.toString();
    }
}
