package test.util;

import edu.ccri.lesson02.assignment.expense.TotalExpense;
import edu.ccri.lesson04.assignment.xml.XmlStaxData;

import java.util.ArrayList;

/**
 * 2/5/2023
 *
 * @author Nick Stoyanov
 */
public class TotalExpenseWriteDataFileXml
{
    /**
     * Constructor
     */
    public TotalExpenseWriteDataFileXml()
    {
        super();
    }

    /**
     * Get test data list
     *
     * @return test data list
     */
    public ArrayList<ArrayList<XmlStaxData>> getDataList()
    {
        return dataList;
    }

    /**
     * Set test data list
     *
     * @param dataList list to set
     */
    public void setDataList(ArrayList<ArrayList<XmlStaxData>> dataList)
    {
        this.dataList = dataList;
    }

    /**
     * data list
     */
    protected ArrayList<ArrayList<XmlStaxData>> dataList = new ArrayList<>();

    /**
     * Add the total expense to the data list
     *
     * @param totalExpense total expense to add to the data list
     */
    public void addTotalExpense(TotalExpense totalExpense)
    {

    }

    /**
     * Returns the xml child tag
     *
     * @return the xml child tag
     */
    protected String getChildNodeTag()
    {
        return null;
    }

    /**
     * Returns the file name prefix (e.g. 'FileName')
     *
     * @return file name prefix
     */
    protected String getFileNamePrefix()
    {
        return null;
    }

    /**
     * Returns the xml output file name suffix (e.g. '.xlsx') property
     *
     * @return returns the file name prefix
     */
    protected String getFileNameSuffix()
    {
        return null;
    }

    /**
     * Returns the xml parent tag
     *
     * @return the xml parent tag
     */
    protected String getXmlParentTag()
    {
        return null;
    }

    /**
     * True if a unique id should be added to the file name. (Helps prevent incorrectly overwriting a file.)
     *
     * @return True if a unique id should be added to the file name
     */
    protected boolean useNameUnique()
    {
        return true;
    }

}
