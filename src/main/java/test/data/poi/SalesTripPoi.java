package test.data.poi;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;
import edu.ccri.lesson02.assignment.poi.PoiData;
import edu.ccri.lesson02.assignment.sales.SalesTrip;
import test.data.TestDataSourcePoi;
import test.data.broker.SalesTripBroker;
import test.data.broker.TestDataSourceBroker;
import test.data.helper.SalesTripHelper;
import test.data.list.SalesTripList;
import test.util.TotalExpenseConstants;

import java.util.ArrayList;

/**
 * Sales trip poi test data source
 * <p>
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class SalesTripPoi extends TestDataSourcePoi implements SalesTripBroker, TestDataSourceBroker
{
    /**
     * Test data list
     */
    private SalesTripList testDataList = new SalesTripList();

    /**
     * Constructor
     */
    public SalesTripPoi()
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
        String name = TotalExpenseConstants.getPropertyConcat("resource.path", "resource.path.input");
        name = TotalExpenseConstants.getPropertyAppend(name, "excel.input.filename");
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
        return 2;
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

        String fromCity = null;
        String toCity = null;
        double duration = 0;
        double distance = 0;

        data = rowDataList.get(columnNumber);
        fromCity = poiDataValueToString(columnNumber, data);
        columnNumber++;

        data = rowDataList.get(columnNumber);
        toCity = poiDataValueToString(columnNumber, data);
        columnNumber++;

        data = rowDataList.get(columnNumber);
        duration = poiDataValueToDouble(columnNumber, data);
        columnNumber++;

        data = rowDataList.get(columnNumber);
        distance = poiDataValueToDouble(columnNumber, data);


        SalesTripHelper.addExpense(this.getTestDataList(), fromCity, toCity, duration, distance);


    }

    /**
     * Returns the test data list
     *
     * @return the test data list
     */
    @Override
    public ArrayList<SalesTrip> getTestDataList()
    {
        return this.testDataList.getTestDataList();
    }
}
