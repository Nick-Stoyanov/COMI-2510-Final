package test.data.helper;

import edu.ccri.lesson02.assignment.expense.FoodExpense;
import edu.ccri.lesson02.assignment.expense.HotelExpense;
import edu.ccri.lesson02.assignment.expense.TravelEntertainmentExpense;
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
class TravelEntertainmentExpenseHelperTest
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(TravelEntertainmentExpenseHelper.class.getName());

    /**
     * Helper
     */
    TravelEntertainmentExpenseHelper helper;

    /**
     * Test data list
     */
    List<TravelEntertainmentExpense> testDataList;

    @BeforeEach
    /**
     * Set up
     */
    void setUp()
    {
        helper = new TravelEntertainmentExpenseHelper();
        testDataList = new ArrayList<>();
    }

    @AfterEach
    /**
     * Tear down
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
        helper.addExpense(testDataList, "test", 1, 1);
        logger.debug("test addExpense: " + testDataList);
        assertTrue(testDataList != null);
    }

    @Test
    /**
     * test for getFoodExpense
     */
    void getFoodExpense()
    {

        helper.addExpense(testDataList, "test", 1, 1);
        logger.debug("test getFoodExpense: " + helper.getFoodExpense(testDataList, "test"));
        assertTrue(helper.getFoodExpense(testDataList, "test") instanceof FoodExpense);
    }

    @Test
    /**
     * test for getHotelExpense
     */
    void getHotelExpense()
    {
        helper.addExpense(testDataList, "test", 1, 1);
        logger.debug("test getHotelExpense: " + helper.getHotelExpense(testDataList, "test"));
        assertTrue(helper.getHotelExpense(testDataList, "test") instanceof HotelExpense);
    }
}