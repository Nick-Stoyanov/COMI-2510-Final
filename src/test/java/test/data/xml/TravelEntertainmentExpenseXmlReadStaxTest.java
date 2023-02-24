package test.data.xml;

import edu.ccri.lesson02.assignment.expense.TravelEntertainmentExpense;
import edu.ccri.lesson02.assignment.sales.SalesTrip;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.data.list.ExpenseList;
import test.data.list.TravelEntertainmentExpenseList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class TravelEntertainmentExpenseXmlReadStaxTest
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(TravelEntertainmentExpenseXmlReadStaxTest.class.getName());

    /**
     * stax object
     */
    TravelEntertainmentExpenseXmlReadStax stax;

    /**
     * test list
     */
    ArrayList<TravelEntertainmentExpense> testList;
    @BeforeEach
    /**
     * set up
     */
    void setUp()
    {
        testList = new ArrayList<>();
        testList.add(new TravelEntertainmentExpense("test",1,1));
        stax = new TravelEntertainmentExpenseXmlReadStax(testList);
    }

    @AfterEach
    /**
     * tear down
     */
    void tearDown()
    {
        testList =null;
        stax = null;
    }

    @Test
    /**
     * test for getChildTagName
     */
    void getChildTagName()
    {
        assertTrue(stax.getChildTagName().contains("row"));
    }

    @Test
    /**
     * test for getFileName
     */
    void getFileName()
    {
        String expected = "C:/Users/Nick/eclipse-workspace/COMI-2510-Final/src/main/resources/resources/lesson04/assignment/in/TravelEntertainmentTestData.xml";
        String actual = stax.getFileName();
        logger.debug("getFileName test\n" + "excepted: " + expected + "\nactual: " + actual);
        assertTrue(actual.contains(expected));
    }

    @Test
    /**
     * test for processEndChildTag
     */
    void processEndChildTag()
    {
    }

    @Test
    /**
     * test for processFieldTag
     */
    void processFieldTag()
    {
    }

    @Test
    /**
     * test for getTestDataList
     */
    void getTestDataList()
    {
        assertTrue(stax.getTestDataList()instanceof ArrayList<TravelEntertainmentExpense>);
    }

    @Test
    /**
     * test for setTestDataList
     */
    void setTestDataList()
    {
        TravelEntertainmentExpenseList teel = new TravelEntertainmentExpenseList();
        stax.setTestDataList(teel);
    }
}