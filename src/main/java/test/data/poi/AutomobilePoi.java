package test.data.poi;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;
import edu.ccri.lesson02.assignment.dashboard.Automobile;
import edu.ccri.lesson02.assignment.poi.PoiData;
import test.data.TestDataSourcePoi;
import test.data.broker.AutomobileBroker;
import test.data.broker.TestDataSourceBroker;
import test.data.helper.AutomobileHelper;
import test.data.list.AutomobileExpenseList;
import test.util.TotalExpenseConstants;

import java.util.ArrayList;

/**
 * Sales trip poi test data source
 * <p>
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class AutomobilePoi extends TestDataSourcePoi implements AutomobileBroker, TestDataSourceBroker
{

    /**
     * Automobile expense test data
     */
    private AutomobileExpenseList testDataList = new AutomobileExpenseList();

    /**
     * Constructor
     */
    public AutomobilePoi()
    {
        super();
        this.setKey(UniqueKeyCounter.getInternalCounter());
    }

    /**
     * Returns the Excel file name to read
     *
     * @return the Excel file name to read
     */
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
        PoiData data = null;
        int columnNumber = 0;

        String name = null;
        double mpg = 0.0;
        double fuelCapacity = 0.0;
        double oilChange = 0.0;
        double tireLife = 0.0;

        data = rowDataList.get(columnNumber);
        name = poiDataValueToString(columnNumber, data);
        columnNumber++;

        data = rowDataList.get(columnNumber);
        mpg = poiDataValueToDouble(columnNumber, data);
        columnNumber++;

        data = rowDataList.get(columnNumber);
        fuelCapacity = poiDataValueToDouble(columnNumber, data);
        columnNumber++;

        data = rowDataList.get(columnNumber);
        oilChange = poiDataValueToDouble(columnNumber, data);
        columnNumber++;

        data = rowDataList.get(columnNumber);
        tireLife = poiDataValueToDouble(columnNumber, data);

        AutomobileHelper.addExpenses(this.getTestDataList(),name, mpg, fuelCapacity, oilChange, tireLife);


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
     * Return true to transpose the result data, so the columns become the rows and the rows become the columns
     *
     * @return true to transpose the result data, so the columns become the rows and the rows become the columns
     */
    protected boolean needToTransposeExcelData()
    {
        return true;
    }


    /**
     * Returns a string representation of the object
     *
     * @return a string representation of the object
     */
    @Override
    public String toString()
    {
        return "AutomobilePoi{" +
                "testDataList=" + testDataList +
                '}';
    }
}
