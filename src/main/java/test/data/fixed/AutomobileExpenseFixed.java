package test.data.fixed;

import edu.ccri.lesson02.assignment.expense.Expense;
import test.data.TestDataSourceFixed;
import test.data.broker.AutomobileExpenseBroker;
import test.data.broker.TestDataSourceBroker;
import test.data.helper.AutomobileHelper;
import test.data.list.ExpenseList;

import java.util.ArrayList;

/**
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class AutomobileExpenseFixed extends TestDataSourceFixed implements AutomobileExpenseBroker, TestDataSourceBroker
{
    /**
     * Test Data list
     */
    private ExpenseList testDataList = new ExpenseList();

    /**
     * Constructor
     */
    public AutomobileExpenseFixed()
    {
        super();
    }

    public Expense getFuelExpense(String name){
        return null;
    }


    /**
     * Returns the test data list
     *
     * @return the test data list
     */
    @Override
    public ArrayList<Expense> getTestDataList()
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
