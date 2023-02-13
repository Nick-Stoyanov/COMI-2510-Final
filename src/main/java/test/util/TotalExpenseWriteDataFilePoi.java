package test.util;

import edu.ccri.lesson02.assignment.expense.TotalExpense;
import edu.ccri.lesson02.assignment.poi.PoiWriteDataList;

import java.util.ArrayList;

/**
 * 2/5/2023
 *
 * @author Nick Stoyanov
 */
public class TotalExpenseWriteDataFilePoi extends PoiWriteDataList
{

    /**
     * data list
     */
    protected ArrayList<ArrayList<Object>> dataList;


    /**
     * Constructor
     */
    public TotalExpenseWriteDataFilePoi()
    {
        super();
    }

    /**
     * Add the total expense to the data list
     *
     * @param totalExpense total expense to add to the data list
     */
    public void addTotalExpense(TotalExpense totalExpense)
    {
        ArrayList<Object> total = new ArrayList<>();
        total.add(totalExpense.getName());
        total.add(totalExpense.getPurchasePrice());
        total.add(totalExpense.getFoodCost());
        total.add(totalExpense.getFuelCost());
        total.add(totalExpense.getFourTires());
        total.add(totalExpense.getOilChange());
        total.add(totalExpense.getHotelCost());
        total.add(totalExpense.getGrandTotalCost());
    }

    /**
     * Add the total expense heading to the data list
     */
    public void addTotalExpenseHeading()
    {
        this.setDataList(new ArrayList<ArrayList<Object>>());
        ArrayList<Object> expenseHeading = new ArrayList<>();

        expenseHeading.add("Name: ");
        expenseHeading.add("Purchase price: ");
        expenseHeading.add("Food: ");
        expenseHeading.add("Fuel: ");
        expenseHeading.add("Tires: ");
        expenseHeading.add("Oil: ");
        expenseHeading.add("Hotel: ");
        expenseHeading.add("Total Cost: ");

    }

    /**
     * Returns the list (rows) of lists (columns) that represent the
     * result to be written to the worksheet
     *
     * @return the list (rows) of lists (columns) that represent the
     * result to be written to the worksheet
     */
    public ArrayList<ArrayList<Object>> getDataList()
    {
        return dataList;
    }

    /**
     * Sets the data list of lists
     *
     * @param dataList the list to set
     */
    public void setDataList(ArrayList<ArrayList<Object>> dataList)
    {
        this.dataList = dataList;
    }

    /**
     * Returns the file name prefix (e.g. 'FileName')
     *
     * @return file name prefix
     */
    protected String getFileNamePrefix()
    {
        return TotalExpenseConstants.getProperty("excel.output.filename.prefix");
    }

    /**
     * Returns the file excel output file name suffix (e.g. '.xlsx') property
     *
     * @return returns the file name prefix
     */
    protected String getFileNameSuffix()
    {
        return TotalExpenseConstants.getProperty("excel.output.filename.suffix");
    }

    /**
     * True if a unique id should be added to the file name.
     * (Helps prevent incorrectly overwriting a file.)
     *
     * @return True if a unique id should be added to the file name
     */
    protected boolean useNameUnique()
    {
        return true;
    }

    /**
     * Returns the output path of the file (e.g. 'scr\main\resources\out\')
     *
     * @return the output path of the file
     */
    protected String getOutputFilePath()
    {
        return TotalExpenseConstants.getProperty("resource.path.output");
    }

    /**
     * Returns a string representation of the object
     *
     * @return string representation of the object
     */
    @Override
    public String toString()
    {
        return "TotalExpenseWriteDataFilePoi{" +
                "dataList=" + dataList +
                '}';
    }
}


