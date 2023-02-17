package test.data.xml;

import edu.ccri.lesson02.assignment.expense.Expense;
import edu.ccri.lesson04.assignment.xml.ReadXmlStaxData;
import test.data.helper.AutomobileExpenseHelper;
import test.data.list.ExpenseList;
import test.util.TotalExpenseConstants;

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
    public static final String FUEL = "fuel";

    /**
     * xml tag for name
     */
    public static final String NAME = "name";

    /**
     * xml tag for name
     */
    public static final String OIL = "oilChange";

    /**
     * xml tag for name
     */
    public static final String PURCHASE = "purchasePrice";

    /**
     * xml tag for name
     */
    public static final String ROW = "row";

    /**
     * xml tag for row
     */
    public static final String TIRE = "fourNewTires";
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
     *
     * @param testDataList test data list
     */
    public AutomobileExpenseXmlReadStax(ArrayList<Expense> testDataList)
    {
        super();
    }

    /**
     * Get the hashmap
     *
     * @return the hashmap
     */
    private HashMap<String, String> getHashMap()
    {
        return hashMap;
    }

    /**
     * Set hashmap
     *
     * @param hashMap map to set
     */
    private void setHashMap(HashMap<String, String> hashMap)
    {
        this.hashMap = hashMap;
    }

    /**
     * Get test data list
     *
     * @return test data list
     */
    private ArrayList<Expense> getTestDataList()
    {
        return testDatalist.getTestDataList();
    }

    /**
     * Set test data list
     *
     * @param testDatalist list to set
     */
    public void setTestDatalist(ExpenseList testDatalist)
    {
        this.testDatalist = testDatalist;
    }

    /**
     * Returns the child tag name e.g. &gt;child&lt;
     *
     * @return the child name
     */
    @Override
    protected String getChildTagName()
    {
        return ROW;
    }

    /**
     * Returns the file name to read
     *
     * @return the file name to read
     */
    @Override
    protected String getFileName()
    {
        String name = TotalExpenseConstants.getPropertyConcat("resource.path", "resource.path.input");
        name = TotalExpenseConstants.getPropertyAppend(name, "xml.input.filename.automobile.expenses");
        return name;
    }

    /**
     * Process the end child tag name e.g. &gt;\child&lt;. When this is called all the fields (e.g. &gt;field&lt;) between the &gt;child&lt; and
     * &gt;\child&lt; tags have been processed.
     */
    @Override
    protected void processEndChildTag()
    {
        AutomobileExpenseHelper.addExpense(this.getTestDataList(), this.getHashMap().get(NAME), Double.parseDouble(this.getHashMap().get(PURCHASE)), Double.parseDouble(this.getHashMap().get(OIL)), Double
                .parseDouble(this.getHashMap().get(FUEL)), Double.parseDouble(this.hashMap.get(TIRE)));

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
        if (this.hashMap == null)
        {
            this.setHashMap(new HashMap<>());

        }
        switch (fieldName)
        {
            case NAME:
            case PURCHASE:
            case FUEL:
            case TIRE:
            case OIL:
            {
                this.getHashMap().put(fieldName, value);
                break;
            }
        }

    }
}
