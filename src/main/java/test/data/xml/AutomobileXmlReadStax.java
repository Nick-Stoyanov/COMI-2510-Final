package test.data.xml;

import edu.ccri.lesson02.assignment.dashboard.Automobile;
import edu.ccri.lesson04.assignment.xml.ReadXmlStaxData;
import test.data.list.AutomobileExpenseList;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Reads automobile data via xml StaX
 * <p>
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class AutomobileXmlReadStax extends ReadXmlStaxData
{
    /**
     * Constructor
     *
     * @param testDataList test data list
     */
    public AutomobileXmlReadStax(ArrayList<Automobile> testDataList)
    {
        super();
    }

    /**
     * Test Data List
     */
    private AutomobileExpenseList testDataList = new AutomobileExpenseList();

    /**
     * xml tag for name
     */
    public static final String FUEL = null;

    /**
     * xml tag for name
     */
    public static final String MPG = null;

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
    public static final String ROW = null;

    /**
     * xml tag for datatype
     */
    public static final String TABLE = null;

    /**
     * xml tag for name
     */
    public static final String PURCHASE = null;

    /**
     * xml tag for row
     */
    public static final String TIRE = null;

    /**
     * Hashmap to populate and add to the list
     */
    private HashMap<String, String> hashMap = new HashMap<>();


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

    /**
     * Return test data list
     *
     * @return the test data list
     */
    public AutomobileExpenseList getTestDataList()
    {
        return testDataList;
    }

    /**
     * Set the test data list
     *
     * @param testDataList the list to set
     */
    public void setTestDataList(AutomobileExpenseList testDataList)
    {
        this.testDataList = testDataList;
    }

    /**
     * Get hashmap
     *
     * @return the hashmap
     */
    public HashMap<String, String> getHashMap()
    {
        return hashMap;
    }

    /**
     * Set hashmap
     *
     * @param hashMap hashmap to set
     */
    public void setHashMap(HashMap<String, String> hashMap)
    {
        this.hashMap = hashMap;
    }
}
