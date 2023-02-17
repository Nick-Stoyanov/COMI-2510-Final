package test.data.xml;

import edu.ccri.lesson02.assignment.sales.SalesTrip;
import edu.ccri.lesson04.assignment.xml.ReadXmlStaxData;
import test.data.helper.SalesTripHelper;
import test.data.list.SalesTripList;
import test.util.TotalExpenseConstants;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Reads sales trip expense via StaX
 * <p>
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class SalesTripXmlReadStax extends ReadXmlStaxData
{
    /**
     * xml tag for name
     */
    public static final String DISTANCE = "distance";
    /**
     * xml tag for name
     */
    public static final String DURATION = "duration";
    /**
     * xml tag for name
     */
    public static final String FROM = "from";
    /**
     * xml tag for name
     */
    public static final String TO = "to";
    /**
     * xml tag for name
     */
    public static final String ROW = "row";
    /**
     * Test data list
     */
    private SalesTripList testDataList = new SalesTripList();
    /**
     * Hashmap to populate and add to the list
     */
    private HashMap<String, String> hashMap = new HashMap<>();

    /**
     * Constructor
     *
     * @param testDataList test data list
     */
    public SalesTripXmlReadStax(ArrayList<SalesTrip> testDataList)
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
        name = TotalExpenseConstants.getPropertyAppend(name, "xml.input.filename.sales.trip");
        return name;
    }

    /**
     * Process the end child tag name e.g. &gt;\child&lt;. When this is called all of the fields (e.g. &gt;field&lt;) between the &gt;child&lt; and
     * &gt;\child&lt; tags have been processed.
     */
    @Override
    protected void processEndChildTag()
    {
        SalesTripHelper.addExpense(this.getTestDataList(), this.getHashMap().get(FROM), this.getHashMap().get(TO), Double.parseDouble(this.getHashMap().get(DURATION)), Double.parseDouble(this.getHashMap().get(DISTANCE)));


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
            case FROM:
            case TO:
            case DISTANCE:
            case DURATION:

            {
                this.getHashMap().put(fieldName, value);
                break;
            }
        }

    }

    /**
     * Get test data list
     *
     * @return test data list
     */
    public ArrayList<SalesTrip> getTestDataList()
    {
        return testDataList.getTestDataList();
    }

    /**
     * Set the test data list
     *
     * @param testDataList the list to set
     */
    public void setTestDataList(SalesTripList testDataList)
    {
        this.testDataList = testDataList;
    }

    /**
     * Get the hashmap
     *
     * @return the hashmap
     */
    public HashMap<String, String> getHashMap()
    {
        return hashMap;
    }

    /**
     * Set the hashmap
     *
     * @param hashMap the hashmap to set
     */
    public void setHashMap(HashMap<String, String> hashMap)
    {
        this.hashMap = hashMap;
    }
}
