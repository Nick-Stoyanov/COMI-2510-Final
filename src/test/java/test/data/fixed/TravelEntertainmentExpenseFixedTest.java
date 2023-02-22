package test.data.fixed;

import edu.ccri.lesson02.assignment.expense.TravelEntertainmentExpense;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class TravelEntertainmentExpenseFixedTest
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(TravelEntertainmentExpenseFixed.class.getName());

    /**
     * Fixed data
     */
    TravelEntertainmentExpenseFixed fixed;

    @BeforeEach
    /**
     * Set up
     */
    void setUp()
    {
        fixed = new TravelEntertainmentExpenseFixed();
        fixed.stageTestData();
    }

    @AfterEach
    /**
     * Tear down
     *
     */
    void tearDown()
    {
        fixed = null;
    }

    @Test
    /**
     * test for getTestDataList
     */
    void getTestDataList()
    {
        assertTrue(fixed.getTestDataList() != null);
        assertTrue(fixed.getTestDataList() instanceof ArrayList<TravelEntertainmentExpense>);
        logger.debug("getTestDataList test: " + fixed.getTestDataList());
    }

    @Test
    /**
     * test for stageTestData
     */
    void stageTestData()
    {
        logger.debug("test data start: " + fixed.getTestDataList());
        fixed = new TravelEntertainmentExpenseFixed();
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
        String expected = "Mercedes S-Class";
        logger.debug("toStringTest.\n Expected: " + expected);
        String actual = fixed.toString();
        logger.debug("\nActual : " + actual);
        assertTrue(actual.contains(expected));
    }
}