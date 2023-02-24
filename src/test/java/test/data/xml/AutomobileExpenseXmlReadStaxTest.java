package test.data.xml;

import edu.ccri.lesson02.assignment.expense.Expense;
import edu.ccri.lesson02.assignment.expense.FuelExpense;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.data.list.ExpenseList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class AutomobileExpenseXmlReadStaxTest
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(AutomobileExpenseXmlReadStax.class.getName());

    /**
     * Stax object
     */
    AutomobileExpenseXmlReadStax stax;

    /**
     * test list
     */
    ArrayList<Expense> testList;

    @BeforeEach
    /**
     * set up
     *
     */
    void setUp()
    {
        testList = new ArrayList<>();
        testList.add(new FuelExpense("test", 1));
        stax = new AutomobileExpenseXmlReadStax(testList);
    }

    @AfterEach
    /**
     * tear down
     *
     */
    void tearDown()
    {
        testList = null;
        stax = null;
    }

    @Test
    /**
     * test for setTestDatalist
     */
    void setTestDatalist()
    {
        ExpenseList test = new ExpenseList();
        ArrayList<Expense> testlist = new ArrayList<>();
        testlist.add(new FuelExpense("set test", 1));
        stax.setTestDatalist(test);
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
}