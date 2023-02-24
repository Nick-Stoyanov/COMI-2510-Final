package test.data.xml;

import edu.ccri.lesson02.assignment.expense.Expense;
import edu.ccri.lesson02.assignment.expense.FuelExpense;
import edu.ccri.lesson02.assignment.sales.SalesTrip;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.data.list.SalesTripList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test
 */
class SalesTripXmlReadStaxTest
{

    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(SalesTripXmlReadStaxTest.class.getName());

    /**
     * stax object
     */
    SalesTripXmlReadStax stax;

    /**
     * test list
     */
    ArrayList<SalesTrip> testList;

    @BeforeEach
    /**
     *
     * set up
     */
    void setUp()
    {
        testList = new ArrayList<>();
        testList.add(new SalesTrip("from","to",1,1));
        stax = new SalesTripXmlReadStax(testList);
    }

    @AfterEach
    /**
     *
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
        String expected = "C:/Users/Nick/eclipse-workspace/COMI-2510-Final/src/main/resources/resources/lesson04/assignment/in/SalesTripTestData.xml";
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
        assertTrue(stax.getTestDataList()instanceof ArrayList<SalesTrip>);
    }

    @Test
    /**
     * test for setTestDataList
     */
    void setTestDataList()
    {
        SalesTripList stl = new SalesTripList();
        ArrayList<Expense> expense = new ArrayList<>();
        expense.add(new FuelExpense("test",1));

        stax.setTestDataList(stl);
    }
}