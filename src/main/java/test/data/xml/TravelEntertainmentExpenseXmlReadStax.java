package test.data.xml;

import edu.ccri.lesson02.assignment.expense.TravelEntertainmentExpense;
import edu.ccri.lesson04.assignment.xml.ReadXmlStaxData;
import test.data.helper.TravelEntertainmentExpenseHelper;
import test.data.list.TravelEntertainmentExpenseList;
import test.util.TotalExpenseConstants;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Reads travel and entertainment expense via StaX
 * <p>
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class TravelEntertainmentExpenseXmlReadStax extends ReadXmlStaxData
{

    /**
     * xml tag for name
     */
    public static final String FOOD = "food";
    /**
     * xml tag for name
     */
    public static final String HOTEL = "hotel";
    /**
     * xml tag for name
     */
    public static final String NAME = "name";
    /**
     * xml tag for name
     */
    public static final String ROW = "row";
    /**
     * Test data list
     */
    private TravelEntertainmentExpenseList testDataList = new TravelEntertainmentExpenseList();
    /**
     * Hashmap to populate and add to the list
     */
    private HashMap<String, String> hashMap = new HashMap<>();

    /**
     * Constructor
     */
    public TravelEntertainmentExpenseXmlReadStax(ArrayList<TravelEntertainmentExpense> testDataList)
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
        name = TotalExpenseConstants.getPropertyAppend(name, "xml.input.filename.travel.entertainment");
        return name;
    }

    /**
     * Process the end child tag name e.g. &gt;\child&lt;. When this is called all of the fields (e.g. &gt;field&lt;) between the &gt;child&lt; and
     * &gt;\child&lt; tags have been processed.
     */
    @Override
    protected void processEndChildTag()
    {
        TravelEntertainmentExpenseHelper.addExpense(this.getTestDataList(), this.getHashMap().
                get(NAME), Double.parseDouble(this.getHashMap().get(HOTEL)), Double.parseDouble(this.getHashMap().get(FOOD)));

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
            case HOTEL:
            case FOOD:

            {
                this.getHashMap().put(fieldName, value);
                break;
            }
        }


    }

    /**
     * get test data list
     *
     * @return test data list
     */
    public ArrayList<TravelEntertainmentExpense> getTestDataList()
    {
        return testDataList.getTestDataList();
    }

    /**
     * set test data list
     *
     * @param testDataList the list to set
     */
    public void setTestDataList(TravelEntertainmentExpenseList testDataList)
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
     * set hashmap
     *
     * @param hashMap the hashmap to set
     */
    public void setHashMap(HashMap<String, String> hashMap)
    {
        this.hashMap = hashMap;
    }
}
