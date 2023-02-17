package test.data.fixed;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;
import edu.ccri.lesson02.assignment.expense.TravelEntertainmentExpense;
import test.data.TestDataSourceFixed;
import test.data.broker.TestDataSourceBroker;
import test.data.broker.TravelEntertainmentExpenseBroker;
import test.data.helper.TravelEntertainmentExpenseHelper;
import test.data.list.TravelEntertainmentExpenseList;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Travel and entertainment expense fixed data source
 * <p>
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class TravelEntertainmentExpenseFixed extends TestDataSourceFixed implements TravelEntertainmentExpenseBroker, TestDataSourceBroker
{
    private TravelEntertainmentExpenseList testDataList = new TravelEntertainmentExpenseList();

    /**
     * Constructor
     */
    public TravelEntertainmentExpenseFixed()
    {
        super();
        this.setKey(UniqueKeyCounter.getInternalCounter());
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

    /**
     * Stage the data for testing
     */
    @Override
    public void stageTestData()
    {
        TravelEntertainmentExpenseHelper.addExpense(this.getTestDataList(), "Honda Accord", 283.35, 75.50);
        TravelEntertainmentExpenseHelper.addExpense(this.getTestDataList(), "Jeep Cherokee", 374.60, 75.01);
        TravelEntertainmentExpenseHelper.addExpense(this.getTestDataList(), "Lexus ES", 418.75, 100.75);
        TravelEntertainmentExpenseHelper.addExpense(this.getTestDataList(), "Lincoln Navigator", 525.60, 75.75);
        TravelEntertainmentExpenseHelper.addExpense(this.getTestDataList(), "Mercedes S-Class", 1121.50, 250.99);

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
        Iterator<TravelEntertainmentExpense> i = this.getTestDataList().iterator();
        TravelEntertainmentExpense expense = null;

        while (i.hasNext())
        {
            expense = i.next();
            sb.append("\n").append(expense.toString());
        }
        return sb.toString();
    }


}
