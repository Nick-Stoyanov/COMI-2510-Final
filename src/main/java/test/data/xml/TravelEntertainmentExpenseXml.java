package test.data.xml;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;
import edu.ccri.lesson02.assignment.expense.TravelEntertainmentExpense;
import test.data.TestDataSourceXml;
import test.data.broker.TestDataSourceBroker;
import test.data.broker.TravelEntertainmentExpenseBroker;
import test.data.list.TravelEntertainmentExpenseList;

import java.util.ArrayList;

/**
 * Travel and entertainment expense xml test data source
 * <p>
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class TravelEntertainmentExpenseXml extends TestDataSourceXml implements TravelEntertainmentExpenseBroker, TestDataSourceBroker
{
    /**
     * Test data list
     */
    private TravelEntertainmentExpenseList testDataList = new TravelEntertainmentExpenseList();

    /**
     * Constructor
     */
    public TravelEntertainmentExpenseXml()
    {
        super();
        this.setKey(UniqueKeyCounter.getInternalCounter());
    }


    /**
     * Stage the data for testing
     */
    @Override
    public void stageTestData()
    {
        TravelEntertainmentExpenseXmlReadStax data = new TravelEntertainmentExpenseXmlReadStax(this.getTestDataList());
        data.readFile();
        data.staxParser();

    }

    /**
     * Return the test data list
     *
     * @return the test data list
     */
    @Override
    public ArrayList<TravelEntertainmentExpense> getTestDataList()
    {
        return this.testDataList.getTestDataList();
    }
}
