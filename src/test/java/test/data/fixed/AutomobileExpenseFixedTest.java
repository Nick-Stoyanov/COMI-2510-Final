package test.data.fixed;

import edu.ccri.lesson02.assignment.expense.FuelExpense;
import edu.ccri.lesson02.assignment.expense.OilExpense;
import edu.ccri.lesson02.assignment.expense.PurchasePriceExpense;
import edu.ccri.lesson02.assignment.expense.TireExpense;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class AutomobileExpenseFixedTest
{

    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(AutomobileExpenseFixedTest.class.getName());

    /**
     * Fixed
     */
    AutomobileExpenseFixed fixed;

    @BeforeEach
    /**
     * set up
     */
    void setUp()
    {
        fixed = new AutomobileExpenseFixed();
        fixed.stageTestData();
    }

    @AfterEach
    /**
     * tear down
     */
    void tearDown()
    {
        fixed = null;
    }

    @Test
    /**
     * test for getFuelExpense
     */
    void getFuelExpense()
    {
        assertTrue(fixed.getFuelExpense("Lexus ES") instanceof FuelExpense);
        logger.debug("Fixed fuel expense test: " + fixed.getFuelExpense("Lexus ES").toString() + "\n");
    }

    @Test
    /**
     * test for getOilExpense
     */
    void getOilExpense()
    {
        assertTrue(fixed.getOilExpense("Lexus ES") instanceof OilExpense);
        logger.debug("Fixed oil expense test: " + fixed.getOilExpense("Lexus ES").toString() + "\n");
    }

    @Test
    /**
     * test for getPurchasePriceExpense
     */
    void getPurchasePriceExpense()
    {
        assertTrue(fixed.getPurchasePriceExpense("Lexus ES") instanceof PurchasePriceExpense);
        logger.debug("Fixed purchase price expense test: " + fixed.getPurchasePriceExpense("Lexus ES").toString() + "\n");
    }

    @Test
    /**
     * test for getTireExpense
     */
    void getTireExpense()
    {
        assertTrue(fixed.getTireExpense("Lexus ES") instanceof TireExpense);
        logger.debug("Fixed tire expense test: " + fixed.getTireExpense("Lexus ES").toString() + "\n");
    }

    @Test
    /**
     * test for getTestDataList
     */
    void getTestDataList()
    {
        assertTrue(fixed.getTestDataList() != null);
        logger.debug("getTestDataList test: " + fixed.getTestDataList());
    }

    @Test
    /**
     * test for stageTestData
     */
    void stageTestData()
    {
        logger.debug("test data start: " + fixed.getTestDataList());
        fixed = new AutomobileExpenseFixed();
        fixed.stageTestData();
        logger.debug("test data after staging again: " + fixed.getTestDataList());
        assertTrue("test stageTestData" + fixed.getTestDataList() != null);
    }

    @Test
    /**
     * test for testToString
     */
    void testToString()
    {
        String expected = "Expense";
        logger.debug("toStringTest.\n Expected: " + expected);
        String actual = fixed.toString();
        logger.debug("\nActual : " + actual);
        assertTrue(actual.contains(expected));
    }
}