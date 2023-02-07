package test.data.poi;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;
import edu.ccri.lesson02.assignment.expense.TravelEntertainmentExpense;
import edu.ccri.lesson02.assignment.poi.PoiData;
import test.data.TestDataSourcePoi;
import test.data.broker.TestDataSourceBroker;
import test.data.broker.TravelEntertainmentExpenseBroker;
import test.data.helper.TravelEntertainmentExpenseHelper;
import test.data.list.TravelEntertainmentExpenseList;
import test.util.TotalExpenseConstants;

import java.util.ArrayList;

/**
 * Travel and entertainment expense poi test data source
 * <p>
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class TravelEntertainmentExpensePoi extends TestDataSourcePoi implements TravelEntertainmentExpenseBroker, TestDataSourceBroker
{

    /**
     * Test data list
     */
    private TravelEntertainmentExpenseList testDataList = new TravelEntertainmentExpenseList();

    /**
     * Constructor
     */
    public TravelEntertainmentExpensePoi()
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
        String name = TotalExpenseConstants.getPropertyConcat("a", "b");
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
        return 3;
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
        double hotelExpense = 0;
        double foodExpense = 0;

        data = rowDataList.get(columnNumber);
        name = poiDataValueToString(columnNumber, data);
        columnNumber++;

        data = rowDataList.get(columnNumber);
        hotelExpense = poiDataValueToDouble(columnNumber, data);
        columnNumber++;

        data = rowDataList.get(columnNumber);
        foodExpense = poiDataValueToDouble(columnNumber, data);

        TravelEntertainmentExpenseHelper.addExpenses(this.getTestDataList(), name, hotelExpense, foodExpense);

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
     * Returns a string representation of the object
     *
     * @return a string representation of the object
     */
    @Override
    public String toString()
    {
        return "TravelEntertainmentExpensePoi{" +
                "testDataList=" + testDataList +
                '}';
    }
}
