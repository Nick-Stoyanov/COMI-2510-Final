package test.data.helper;

import edu.ccri.lesson02.assignment.expense.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class AutomobileExpenseHelperTest
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(AutomobileExpenseHelper.class.getName());

    /**
     * helper
     */
    AutomobileExpenseHelper helper;
    /**
     * Test data list
     */
    List<Expense> testDataList;

    @BeforeEach
    /**
     *
     */
    void setUp()
    {
        helper = new AutomobileExpenseHelper();
        testDataList = new ArrayList<>();

    }

    @AfterEach
    /**
     *
     */
    void tearDown()
    {
        helper = null;
        testDataList = null;
    }

    @Test
    /**
     * test for addExpense
     */
    void addExpense()
    {
        helper.addExpense(testDataList, "test", 1, 1, 1, 1);
        logger.debug("test addExpense: " + testDataList);
        assertTrue(testDataList != null);
    }

    @Test
    /**
     * test for getFuelExpense
     */
    void getFuelExpense()
    {

        helper.addExpense(testDataList, "test", 1, 1, 1, 1);
        logger.debug("test getFuelExpense: " + testDataList);
        assertTrue(helper.getFuelExpense(testDataList, "test") instanceof FuelExpense);
    }

    @Test
    /**
     * test for getOilExpense
     */
    void getOilExpense()
    {
        helper.addExpense(testDataList, "test", 1, 1, 1, 1);
        logger.debug("test getOilExpense: " + testDataList);
        assertTrue(helper.getOilExpense(testDataList, "test") instanceof OilExpense);
    }

    @Test
    /**
     * test for getPurchasePriceExpense
     */
    void getPurchasePriceExpense()
    {
        helper.addExpense(testDataList, "test", 1, 1, 1, 1);
        logger.debug("test getPurchasePriceExpense: " + testDataList);
        assertTrue(helper.getPurchasePriceExpense(testDataList, "test") instanceof PurchasePriceExpense);
    }

    @Test
    /**
     * test for getTireExpense
     */
    void getTireExpense()
    {
        helper.addExpense(testDataList, "test", 1, 1, 1, 1);
        logger.debug("test getTireExpense: " + testDataList);
        assertTrue(helper.getTireExpense(testDataList, "test") instanceof TireExpense);
    }
}