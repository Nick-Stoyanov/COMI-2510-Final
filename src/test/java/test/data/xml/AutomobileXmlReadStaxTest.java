package test.data.xml;

import edu.ccri.lesson02.assignment.expense.Expense;
import edu.ccri.lesson02.assignment.expense.FuelExpense;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.data.list.AutomobileExpenseList;
import test.data.list.ExpenseList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class AutomobileXmlReadStaxTest
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(AutomobileXmlReadStaxTest.class.getName());

    /**
     * test list
     */
    ArrayList<Expense> testList;
    /**
     * stax object
     */
    AutomobileExpenseXmlReadStax stax;
    @BeforeEach
    /**
     * set up
     */
    void setUp()
    {
        testList = new ArrayList<>();
        testList.add(new FuelExpense("test", 1));
        stax = new AutomobileExpenseXmlReadStax(testList);
    }

    @AfterEach
    /**
     *
     */
    void tearDown()
    {
        testList = null;
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
        String expected = "C:/Users/Nick/eclipse-workspace/COMI-2510-Final/src/main/resources/resources/lesson04/assignment/in/AutomobileExpensesTestData.xml";
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
        assertTrue(stax.getTestDataList()instanceof ArrayList<Expense>);
    }

    @Test
    /**
     * test for setTestDataList
     */
    void setTestDataList()
    {
        ExpenseList test = new ExpenseList();
        ArrayList<Expense> testlist = new ArrayList<>();
        testlist.add(new FuelExpense("set test", 1));
        stax.setTestDatalist(test);
    }


}