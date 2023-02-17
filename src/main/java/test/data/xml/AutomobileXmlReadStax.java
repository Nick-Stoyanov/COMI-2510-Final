package test.data.xml;

import edu.ccri.lesson02.assignment.dashboard.Automobile;
import edu.ccri.lesson04.assignment.xml.ReadXmlStaxData;
import test.data.helper.AutomobileHelper;
import test.data.list.AutomobileExpenseList;
import test.util.TotalExpenseConstants;

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
    public static final String FUEL = "fuelCapacity";

    /**
     * xml tag for name
     */
    public static final String MPG = "mpg";

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
    public static final String ROW = "row";

    /**
     * xml tag for datatype
     */
    public static final String TABLE = "table";


    /**
     * xml tag for row
     */
    public static final String TIRE = "tireLife";

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
        name = TotalExpenseConstants.getPropertyAppend(name, "xml.input.filename.automobile");
        return name;
    }

    /**
     * Process the end child tag name e.g. &gt;\child&lt;. When this is called all of the fields (e.g. &gt;field&lt;) between the &gt;child&lt; and
     * &gt;\child&lt; tags have been processed.
     */
    @Override
    protected void processEndChildTag()
    {
        AutomobileHelper.addExpense(this.getTestDataList(), this.getHashMap().get(NAME), Double.parseDouble(this.getHashMap().get(MPG)), Double.parseDouble(this.getHashMap().get(FUEL)), Double
                .parseDouble(this.getHashMap().get(OIL)), Double.parseDouble(this.hashMap.get(TIRE)));

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
            case MPG:
            case FUEL:
            case OIL:
            case TIRE:

            {
                this.getHashMap().put(fieldName, value);
                break;
            }
        }

    }

    /**
     * Return test data list
     *
     * @return the test data list
     */
    public ArrayList<Automobile> getTestDataList()
    {
        return testDataList.getTestDataList();
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
