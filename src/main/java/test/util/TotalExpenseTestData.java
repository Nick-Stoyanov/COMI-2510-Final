package test.util;

import edu.ccri.lesson02.assignment.expense.TotalExpense;
import edu.ccri.lesson02.assignment.poi.PoiWriteDataList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Total expense data
 * <p>
 * 2/5/2023
 *
 * @author Nick Stoyanov
 */
public class TotalExpenseTestData
{
    /**
     * Get instance of the logger
     */
    private static final Logger logger = LogManager.getLogger(TotalExpenseTestData.class.getName());

    /**
     * Excel worksheet name for excel data
     */
    private static final String WORKSHEET_NAME_EXCEL = "excelTestDataResults";

    /**
     * Excel worksheet name for fixed (e.g. hard coded) data
     */
    private static final String WORKSHEET_NAME_FIXED = "fixedTestDataResults";

    /**
     * Excel worksheet name for xml data
     */
    private static final String WORKSHEET_NAME_XML = "xmlTestDataResults";

    /**
     * object to write the total expense excel data file to poi
     */
    private TotalExpenseWriteDataFilePoi totalExpenseWriteDataFilePoi;

    /**
     * object to write the total expense excel data file to xml
     */
    private TotalExpenseWriteDataFileXml totalExpenseWriteDataFileXml;


    /**
     * Constructor
     */
    public TotalExpenseTestData()
    {
        totalExpenseWriteDataFilePoi = new TotalExpenseWriteDataFilePoi();
        totalExpenseWriteDataFileXml = new TotalExpenseWriteDataFileXml();
    }

    /**
     * Formats the expense as a string
     *
     * @param totalExpense the expense to format
     * @return formatted expense
     */
    private String formatString(TotalExpense totalExpense)
    {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + totalExpense.getName() + "\n");
        sb.append("Purchase Price: " + totalExpense.getPurchasePrice() + "\n");
        sb.append("Food Cost: " + totalExpense.getFoodCost() + "\n");
        sb.append("Tires Cost: " + totalExpense.getFourTires() + "\n");
        sb.append("Fuel Cost: " + totalExpense.getFuelCost() + "\n");
        sb.append("Hotel Cost: " + totalExpense.getHotelCost() + "\n");
        sb.append("Oil Change Cost: " + totalExpense.getOilChange() + "\n");
        sb.append("Total Cost: " + totalExpense.getGrandTotalCost() + "\n");

        return sb.toString();

    }

    /**
     * Returns the results to display
     *
     * @param totalExpenseList the list of total expenses
     * @return the results to display
     */
    private String getDisplayResults(ArrayList<TotalExpense> totalExpenseList)
    {
        StringBuilder results = new StringBuilder();

        Iterator<TotalExpense> iterator = totalExpenseList.iterator();
        TotalExpense total = null;
        while (iterator.hasNext())
        {
            total = iterator.next();
            results.append(formatString(total));
            results.append("\n");
            logger.debug("Total =" + total.toString());
        }

        return results.toString();

    }

    /**
     * Get TotalExpenseWriteDataFilePoi
     *
     * @return TotalExpenseWriteDataFilePoi
     */
    public TotalExpenseWriteDataFilePoi getTotalExpenseWriteDataFilePoi()
    {
        return totalExpenseWriteDataFilePoi;
    }

    /**
     * Set TotalExpenseWriteDataFilePoi
     *
     * @param totalExpenseWriteDataFilePoi the data to set
     */
    public void setTotalExpenseWriteDataFilePoi(TotalExpenseWriteDataFilePoi totalExpenseWriteDataFilePoi)
    {
        this.totalExpenseWriteDataFilePoi = totalExpenseWriteDataFilePoi;
    }

    /**
     * Get TotalExpenseWriteDataFileXml
     *
     * @return TotalExpenseWriteDataFileXml
     */
    public TotalExpenseWriteDataFileXml getTotalExpenseWriteDataFileXml()
    {
        return totalExpenseWriteDataFileXml;
    }

    /**
     * Set the TotalExpenseWriteDataFileXml
     *
     * @param totalExpenseWriteDataFileXml the data to set
     */
    public void setTotalExpenseWriteDataFileXml(TotalExpenseWriteDataFileXml totalExpenseWriteDataFileXml)
    {
        this.totalExpenseWriteDataFileXml = totalExpenseWriteDataFileXml;
    }

    /**
     * Returns the worksheet name
     *
     * @param testDataType test data type
     * @return the worksheet name
     */
    private String getWorksheetName(TestDataType testDataType)
    {
        String name = null;
        if (TestDataType.FIXED == testDataType)
        {
            name = WORKSHEET_NAME_FIXED;
        } else if (TestDataType.XML == testDataType)
        {
            name = WORKSHEET_NAME_XML;
        } else if (TestDataType.EXCEL == testDataType)
        {
            name = WORKSHEET_NAME_EXCEL;
        }

        return name;
    }

    /**
     * Initializes the TotalExpenseWriteDataFilePoi and
     * TotalExpenseWriteDataFileXml instances. This must
     * be called after the constructor has been called.
     */


    private void initialize()
    {
    }

    /**
     * Prepares to write the results to excel
     *
     * @param worksheetName  the worksheet name
     * @param totalCostList  the total cost list
     * @param grandTotalCost the grand total cost
     */
    private void prepareToWriteResultsPoi(String worksheetName,
                                          ArrayList<TotalExpense> totalCostList,
                                          TotalExpense grandTotalCost)
    {
        Iterator<TotalExpense> iterator  = null;
        TotalExpense total = null;

        totalExpenseWriteDataFilePoi.setDataList(new ArrayList<ArrayList<Object>>());
        totalExpenseWriteDataFilePoi.addTotalExpenseHeading();
        iterator = totalCostList.iterator();
        while (iterator.hasNext()){
            total = iterator.next();
            totalExpenseWriteDataFilePoi.addTotalExpense(total);
        }
        totalExpenseWriteDataFilePoi.addTotalExpense(grandTotalCost);
        totalExpenseWriteDataFilePoi.addWorksheet(worksheetName);


    }

    /**
     * Prepares to write the results to xml
     *
     * @param worksheetName  the worksheet name
     * @param totalCostList  he total cost list
     * @param grandTotalCost the grand total cost
     */
    private void prepareToWriteResultsXml(String worksheetName,
                                          ArrayList<TotalExpense> totalCostList,
                                          TotalExpense grandTotalCost)
    {

    }

    /**
     * Uses the data staged from excel or fixed (e.g. hard coded)
     * to test logic and write the results to excel.
     *
     * @param testDataType set to true to the data source to use
     * @return the results of the test
     */
    public String stageData(TestDataType testDataType)
    {
        return null;

    }

    /**
     * Writes the the TotalExpenseWriteDataFilePoi
     * and TotalExpenseWriteDataFileXml that was prepared to the poi file and xml file.
     */
    public void writeFiles()
    {

    }

}
