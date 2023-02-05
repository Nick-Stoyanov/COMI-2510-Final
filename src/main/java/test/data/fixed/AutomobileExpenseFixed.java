package test.data.fixed;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;
import edu.ccri.lesson02.assignment.expense.Expense;
import test.data.TestDataSourceFixed;
import test.data.broker.AutomobileExpenseBroker;
import test.data.broker.TestDataSourceBroker;
import test.data.helper.AutomobileExpenseHelper;
import test.data.list.ExpenseList;

import java.util.ArrayList;

/**
 * Automobile fixed test data source
 * <p>
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
        this.setKey(UniqueKeyCounter.getInternalCounter());
    }

    /**
     * Returns the fuel expense
     *
     * @param name the name of the expense
     * @return the fuel expense
     */
    public Expense getFuelExpense(String name)
    {
        return AutomobileExpenseHelper.getFuelExpense(this.getTestDataList(), name);
    }

    /**
     * Returns the oil expense
     *
     * @param name the name of the expense
     * @return the oil expense
     */
    public Expense getOilExpense(String name)
    {
        return AutomobileExpenseHelper.getOilExpense(this.getTestDataList(), name);
    }

    /**
     * Returns the purchase price
     *
     * @param name name of the expense
     * @return the purchase price
     */
    public Expense getPurchasePriceExpense(String name)
    {
        return AutomobileExpenseHelper.getPurchasePriceExpense(this.getTestDataList(), name);
    }

    /**
     * Returns the tire expense
     *
     * @param name the name of the expense
     * @return the tire expense
     */
    public Expense getTireExpense(String name)
    {
        return AutomobileExpenseHelper.getTireExpense(this.getTestDataList(), name);
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
        AutomobileExpenseHelper.addExpense(this.getTestDataList(), "Honda Accord", 28355, 75, 4, 400);
        AutomobileExpenseHelper.addExpense(this.getTestDataList(), "Jeep Cherokee", 37460, 75, 4, 600);
        AutomobileExpenseHelper.addExpense(this.getTestDataList(), "Lexus ES", 41875, 100, 4, 1000);
        AutomobileExpenseHelper.addExpense(this.getTestDataList(), "Lincoln Aviator", 52560, 75, 4, 750);
        AutomobileExpenseHelper.addExpense(this.getTestDataList(), "Mercedes S-Class", 112150, 250, 4, 2000);
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
        for (Expense ex : getTestDataList())
        {
            sb.append("\nExpense: " + ex.toString());

        }
        return sb.toString();
    }


}
