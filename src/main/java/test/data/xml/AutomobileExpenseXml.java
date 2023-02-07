package test.data.xml;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;
import edu.ccri.lesson02.assignment.expense.Expense;
import test.data.TestDataSourceXml;
import test.data.broker.AutomobileExpenseBroker;
import test.data.broker.TestDataSourceBroker;
import test.data.list.ExpenseList;

import java.util.ArrayList;

/**
 * Automobile expense xml test data source
 * <p>
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class AutomobileExpenseXml extends TestDataSourceXml implements AutomobileExpenseBroker, TestDataSourceBroker
{
    private ExpenseList testDataList = new ExpenseList();

    /**
     * Constructor
     */
    public AutomobileExpenseXml()
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
    public ArrayList<Expense> getTestDataList()
    {
        return this.testDataList.getTestDataList();
    }

    /**
     * Stage the data for testing
     */
    @Override
    public void stageTestData()
    {
        AutomobileExpenseXmlReadStax data = new AutomobileExpenseXmlReadStax(this.getTestDataList());
        data.readFile();
        data.staxParser();
    }
}
