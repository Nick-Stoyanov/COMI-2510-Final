package test.util;

import edu.ccri.lesson02.assignment.expense.TotalExpense;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import test.data.broker.AutomobileBroker;
import test.data.broker.AutomobileExpenseBroker;
import test.data.broker.SalesTripBroker;
import test.data.broker.TravelEntertainmentExpenseBroker;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

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
        sb.append("Purchase Price: ").append(numberFormat.format(totalExpense.getPurchasePrice()) + "\n");
        sb.append("Food Cost: ").append(numberFormat.format(totalExpense.getFoodCost()) + "\n");
        sb.append("Tires Cost: ").append(numberFormat.format(totalExpense.getFourTires()) + "\n");
        sb.append("Fuel Cost: ").append(numberFormat.format(totalExpense.getFuelCost()) + "\n");
        sb.append("Hotel Cost: ").append(numberFormat.format(totalExpense.getHotelCost()) + "\n");
        sb.append("Oil Change Cost: ").append(numberFormat.format(totalExpense.getOilChange()) + "\n");
        sb.append("Total Cost: ").append(numberFormat.format(totalExpense.getGrandTotalCost()) + "\n");

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
        totalExpenseWriteDataFilePoi.initialize();

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
        Iterator<TotalExpense> iterator = null;
        TotalExpense total = null;

        totalExpenseWriteDataFilePoi.setDataList(new ArrayList<ArrayList<Object>>());
        totalExpenseWriteDataFilePoi.addTotalExpenseHeading();
        iterator = totalCostList.iterator();
        while (iterator.hasNext())
        {
            total = iterator.next();
            totalExpenseWriteDataFilePoi.addTotalExpense(total);
        }
        totalExpenseWriteDataFilePoi.addTotalExpense(grandTotalCost);
        //totalExpenseWriteDataFilePoi.addWorksheet(worksheetName);


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
         StringBuilder sb = new StringBuilder();
        sb.append("Test data type: " + testDataType);
        sb.append("\n");

        AutomobileBroker automobileTestData = TotalExpenseFactory.getAutomobileTestData(testDataType);
        TotalExpenseTestCalculations totalExpenseTestCalculations = new TotalExpenseTestCalculations();

        TravelEntertainmentExpenseBroker travelEntertainmentExpenseTestData = TotalExpenseFactory.getTravelEntertainmentExpenseTestData(testDataType);

        logger.debug("Automobile Test Data: " + automobileTestData.toString());
        logger.debug("Travel & Entertainment Test Data: " + travelEntertainmentExpenseTestData);

        SalesTripBroker salesTripTestData = TotalExpenseFactory.getSalesTripTestData(testDataType);
        logger.debug("Sales Trip Test Data: " + salesTripTestData.toString());

        AutomobileExpenseBroker automobileExpenseTestData = TotalExpenseFactory.getAutomobileExpenseTestData(testDataType);
        logger.debug("Automobile Expense Test Data: " + automobileExpenseTestData);

        totalExpenseTestCalculations.setAutomobileTestData(automobileTestData);
        totalExpenseTestCalculations.setSalesTripTestData(salesTripTestData);
        totalExpenseTestCalculations.setAutomobileExpenseTestData(automobileExpenseTestData);
        totalExpenseTestCalculations.setTravelEntertainmentExpenseTestData(travelEntertainmentExpenseTestData);

        ArrayList<TotalExpense> totalCostList = totalExpenseTestCalculations.calculateTotals();
        totalExpenseTestCalculations.setTotalCostList(totalCostList);

        sb.append(getDisplayResults(totalCostList));

        TotalExpense grandTotal = totalExpenseTestCalculations.calculateGrandTotals();
        logger.debug("Grand Total: " + grandTotal.toString());

        sb.append(formatString(grandTotal));
        sb.append("\n");


        prepareToWriteResultsPoi(getWorksheetName(testDataType), totalCostList, grandTotal);
        prepareToWriteResultsXml(getWorksheetName(testDataType), totalCostList, grandTotal);

        return sb.toString();


    }

    /**
     * Writes the TotalExpenseWriteDataFilePoi
     * and TotalExpenseWriteDataFileXml that was prepared to the poi file and xml file.
     */
    public void writeFiles()
    {


    }




}
