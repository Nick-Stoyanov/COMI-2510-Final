package test.data.poi;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;
import edu.ccri.lesson02.assignment.expense.Expense;
import edu.ccri.lesson02.assignment.poi.PoiData;
import test.data.TestDataSourcePoi;
import test.data.broker.AutomobileExpenseBroker;
import test.data.broker.TestDataSourceBroker;
import test.data.helper.AutomobileExpenseHelper;
import test.data.list.ExpenseList;
import test.util.TotalExpenseConstants;

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
    private ExpenseList testDataList = new ExpenseList();

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
        String name = TotalExpenseConstants.getPropertyConcat("a", "a");
        return name;
    }

    /**
     * Returns the worksheet number to read. Worksheets are 0 based (e.g. 0, 1, 2...).
     *
     * @return the worksheet number to read. Worksheets are 0 based (e.g. 0, 1, 2...).
     */
    @Override
    protected int getWorksheetNumber()
    {
        return 1;
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
        PoiData data = null;
        int columnNumber = 0;

        String name = null;
        double purchasePrice = 0;
        double oilChange = 0;
        double gasPerUnit = 0;
        double fourTires = 0;

        data = rowDataList.get(columnNumber);
        name = poiDataValueToString(columnNumber, data);
        columnNumber++;

        data = rowDataList.get(columnNumber);
        purchasePrice = poiDataValueToDouble(columnNumber, data);
        columnNumber++;

        data = rowDataList.get(columnNumber);
        oilChange = poiDataValueToDouble(columnNumber, data);
        columnNumber++;

        data = rowDataList.get(columnNumber);
        gasPerUnit = poiDataValueToDouble(columnNumber, data);
        columnNumber++;

        data = rowDataList.get(columnNumber);
        fourTires = poiDataValueToDouble(columnNumber, data);


        AutomobileExpenseHelper.addExpense(this.getTestDataList(), name, purchasePrice, oilChange, gasPerUnit, fourTires);

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
     * Returns a string representation of the object
     *
     * @return a string representation of the object
     */
    @Override
    public String toString()
    {
        return "AutomobileExpensePoi{" +
                "testDataList=" + testDataList +
                '}';
    }
}
