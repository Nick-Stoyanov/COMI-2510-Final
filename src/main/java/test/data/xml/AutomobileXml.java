package test.data.xml;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;
import edu.ccri.lesson02.assignment.dashboard.Automobile;
import test.data.TestDataSourceXml;
import test.data.broker.AutomobileBroker;
import test.data.broker.TestDataSourceBroker;
import test.data.list.AutomobileExpenseList;

import java.util.ArrayList;

/**
 * Automobile xml test data source
 * <p>
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class AutomobileXml extends TestDataSourceXml implements AutomobileBroker, TestDataSourceBroker
{
    /**
     * Test data list
     */
    private AutomobileExpenseList testDatalist = new AutomobileExpenseList();

    /**
     * Constructor
     */
    public AutomobileXml()
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
    public ArrayList<Automobile> getTestDataList()
    {
        return null;
    }

    /**
     * Stage the data for testing
     */
    @Override
    public void stageTestData()
    {

    }
}
