package test.data.fixed;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;
import edu.ccri.lesson02.assignment.dashboard.Automobile;
import test.data.TestDataSourceFixed;
import test.data.broker.AutomobileBroker;
import test.data.broker.TestDataSourceBroker;
import test.data.helper.AutomobileHelper;
import test.data.list.AutomobileExpenseList;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Automobile fixed test data source
 * <p>
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class AutomobileFixed extends TestDataSourceFixed implements AutomobileBroker, TestDataSourceBroker
{
    private AutomobileExpenseList testDataList = new AutomobileExpenseList();

    /**
     * Constructor
     */
    public AutomobileFixed()
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
        return this.testDataList.getTestDataList();
    }

    /**
     * Stage the data for testing
     */
    @Override
    public void stageTestData()
    {
        AutomobileHelper.addExpenses(this.getTestDataList(), "Mercedes S-Class", 24, 22, 10000, 50000);
        AutomobileHelper.addExpenses(this.getTestDataList(), "Lexus ES", 28, 15.9, 8000, 40000);
        AutomobileHelper.addExpenses(this.getTestDataList(), "Honda Accord", 47, 12, 3000, 35000);
    }

    /**
     * Returns a string representation of the object
     *
     * @return string representation of the object
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass());
        Iterator<Automobile> i = this.getTestDataList().iterator();
        Automobile automobile = null;

        while (i.hasNext())
        {
            automobile = i.next();
            sb.append("\n").append(automobile.toString());
        }
        return sb.toString();

    }
}
