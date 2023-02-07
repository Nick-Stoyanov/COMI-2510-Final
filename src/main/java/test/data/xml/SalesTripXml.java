package test.data.xml;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;
import edu.ccri.lesson02.assignment.sales.SalesTrip;
import test.data.TestDataSourceXml;
import test.data.broker.SalesTripBroker;
import test.data.broker.TestDataSourceBroker;
import test.data.fixed.SalesTripFixed;
import test.data.helper.SalesTripHelper;
import test.data.list.SalesTripList;

import java.util.ArrayList;

/**
 * Sales trip expense xml test data source
 * <p>
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class SalesTripXml extends TestDataSourceXml implements SalesTripBroker, TestDataSourceBroker
{
    /**
     * Test data list
     */
    private SalesTripList testDataList = new SalesTripList();

    /**
     * Constructor
     */
    public SalesTripXml()
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


    }
}
