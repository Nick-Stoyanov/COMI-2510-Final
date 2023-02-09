package test.util;

import edu.ccri.lesson02.assignment.expense.TotalExpense;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.NumberFormat;

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
}
