package test.data.xml;

import edu.ccri.lesson02.assignment.expense.Expense;
import edu.ccri.lesson04.assignment.xml.ReadXmlStaxData;
import test.data.list.ExpenseList;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class AutomobileExpenseXmlReadStax extends ReadXmlStaxData
{
    /**
     * xml tag for name
     */
    public static final String FUEL = null;

    /**
     * xml tag for name
     */
    public static final String NAME = null;

    /**
     * xml tag for name
     */
    public static final String OIL = null;

    /**
     * xml tag for name
     */
    public static final String PURCHASE = null;

    /**
     * xml tag for name
     */
    public static final String ROW = null;

    /**
     * xml tag for row
     */
    public static final String TIRE = null;

    /**
     * Hashmap to populate and add to the list
     */
    private HashMap<String, String> hashMap = new HashMap<>();

    /**
     * Automobile expense test data
     */
    private ExpenseList testDatalist = new ExpenseList();

    /**
     * Constructor
     */
    public AutomobileExpenseXmlReadStax(ArrayList<Expense> testDataList)
    {
        super();
    }

    /**
     * Returns the child tag name e.g. &gt;child&lt;
     *
     * @return the child name
     */
    @Override
    protected String getChildTagName()
    {
        return null;
    }

    /**
     * Returns the file name to read
     *
     * @return the file name to read
     */
    @Override
    protected String getFileName()
    {
        return null;
    }

    /**
     * Process the end child tag name e.g. &gt;\child&lt;. When this is called all of the fields (e.g. &gt;field&lt;) between the &gt;child&lt; and
     * &gt;\child&lt; tags have been processed.
     */
    @Override
    protected void processEndChildTag()
    {

    }

    /**
     * Process the field tag element name (e.g. &gt;field&lt;) with the corresponding value. For example the field could be be named "number" and the
     * value could be 10. The xml would look like<BR>
     * <BR>
     * &gt;number&lt;10&gt;\number&lt;.
     *
     * @param fieldName - the field name
     * @param value     - the value
     */
    @Override
    protected void processFieldTag(String fieldName, String value)
    {

    }
}
