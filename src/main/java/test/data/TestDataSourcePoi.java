package test.data;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;
import edu.ccri.lesson02.assignment.poi.PoiData;
import edu.ccri.lesson02.assignment.poi.PoiReadDataList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public abstract class TestDataSourcePoi extends TestDataSource
{
    /**
     * Get instance of the logger
     */
    private static final Logger logger = LogManager.getLogger(TestDataSourcePoi.class.getName());


    /**
     * Constructor
     */
    public TestDataSourcePoi()
    {
        super();
        this.setKey(UniqueKeyCounter.getInternalCounter());
    }

    /**
     * Returns the Excel file name to read
     *
     * @return the Excel file name to read
     */
    protected abstract String getFileName();

    /**
     * Returns the worksheet number to read. Worksheets are 0 based (e.g. 0, 1, 2...).
     *
     * @return the worksheet number to read. Worksheets are 0 based (e.g. 0, 1, 2...).
     */
    protected abstract int getWorksheetNumber();

    /**
     * Handles the data row results to convert it from a map of objects
     * e.g. String, int, double, etc) into an object (e.g. POJO, PODO).
     *
     * @param rowDataList the data row result to convert it from a map of objects into an object
     */
    protected abstract void handlePoiDataRowResults(ArrayList<PoiData> rowDataList);

    /**
     * Return true to skip the first row when processing the data
     * list result, override this method to include the first row of data
     *
     * @return true to skip the first row when processing the data list result,
     * override this method to include the first row of data
     */
    protected boolean skipFirstRow()
    {
        return true;
    }

    /**
     * Override this method to return true to transpose the result data, so the columns become
     * the rows and the rows become the columns For example, when transposed:
     *
     * @return true to transpose the result data, so the columns become the rows and the rows
     * become the columns
     */
    protected boolean needToTransposeExcelData()
    {
        return true;
    }

    /**
     * Handles the data row results to convert it from a map of objects
     * (e.g. String, int, double, etc) into an object (e.g. POJO, PODO).
     *
     * @param testDataList the data row results to convert it from a map of objects
     *                     (e.g. String, int, double, etc) into an object (e.g. POJO, PODO).
     */
    private void handlePoiDataResults(ArrayList<ArrayList<PoiData>> testDataList)
    {
        ArrayList<PoiData> rowDataList = null;
        int start = 0;

        if (skipFirstRow())
        {
            start = 1;
        }

        for (int i = start; i < (testDataList.size()); i++)
        {
            rowDataList = testDataList.get(i);
            handlePoiDataRowResults(rowDataList);
        }

    }

    /**
     * Returns the POI data value as a double
     *
     * @param columnNumber the column number
     * @param poiData      the poi data value
     * @return the POI data value as a double
     */
    protected double poiDataValueToDouble(int columnNumber,
                                          PoiData poiData)
    {
        double value = -666;
        if (null != poiData.getValue() && poiData.getValue() instanceof Double)
        {
            value = (double) poiData.getValue();
        } else
        {
            logger.error("column=" + columnNumber + "Invalid Data Type. Please enter Double.");
        }
        return value;
    }

    /**
     * Returns the POI data value as a string
     *
     * @param columnNumber the column number
     * @param poiData      the poi data value
     * @return the POI data value as a string
     */
    protected String poiDataValueToString(int columnNumber,
                                          PoiData poiData)
    {
        String value = null;
        if (null != poiData.getValue() && poiData.getValue() instanceof String)
        {
            value = (String) poiData.getValue();
        } else
        {
            logger.error("column=" + columnNumber + "Invalid Data Type. Please enter String.");
        }
        return value;
    }

    /**
     * Method to stage the test data with data that is from an Excel file.
     */
    public void stageTestData()
    {
        PoiReadDataList poiReadDataList = new PoiReadDataList(this.getFileName(), getWorksheetNumber());

        if (needToTransposeExcelData())
        {
            handlePoiDataResults(poiReadDataList.getTransposedTestDataList());
        } else
        {
            handlePoiDataResults(poiReadDataList.getTestDataList());
        }
    }

}
