package test.data.poi;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;
import edu.ccri.lesson02.assignment.expense.Expense;
import edu.ccri.lesson02.assignment.poi.PoiData;
import test.data.TestDataSourcePoi;
import test.data.broker.AutomobileExpenseBroker;
import test.data.broker.TestDataSourceBroker;
import test.data.list.ExpenseList;

import java.util.ArrayList;

/**
 * Automobile expense poi test data
 * <p>
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class AutomobileExpensePoi extends TestDataSourcePoi implements AutomobileExpenseBroker, TestDataSourceBroker
{
    /**
     * Test data list
     */
    private ExpenseList testDataList;

    /**
     * Constructor
     */
    public AutomobileExpensePoi()
    {
        super();
        this.setKey(UniqueKeyCounter.getInternalCounter());
    }


    /**
     * Returns the Excel file name to read
     *
     * @return the Excel file name to read
     */
    @Override
    protected String getFileName()
    {
        return null;
    }

    /**
     * Returns the worksheet number to read. Worksheets are 0 based (e.g. 0, 1, 2...).
     *
     * @return the worksheet number to read. Worksheets are 0 based (e.g. 0, 1, 2...).
     */
    @Override
    protected int getWorksheetNumber()
    {
        return 0;
    }

    /**
     * Handles the data row results to convert it from a map of objects
     * e.g. String, int, double, etc) into an object (e.g. POJO, PODO).
     *
     * @param rowDataList the data row result to convert it from a map of objects into an object
     */
    @Override
    protected void handlePoiDataRowResults(ArrayList<PoiData> rowDataList)
    {

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
}
