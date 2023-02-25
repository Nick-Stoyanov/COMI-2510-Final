package test.util;

import edu.ccri.lesson02.assignment.expense.TotalExpense;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.data.broker.TravelEntertainmentExpenseBroker;
import test.data.poi.SalesTripPoi;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class TotalExpenseTestCalculationsTest
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(TotalExpenseTestCalculationsTest.class.getName());

    /**
     * test calculation object
     */
    TotalExpenseTestCalculations testCalc;

    @BeforeEach
    /**
     * set up
     */
    void setUp()
    {
        testCalc = new TotalExpenseTestCalculations();
    }

    @AfterEach
    /**
     * tear down
     */
    void tearDown()
    {
        testCalc = null;
    }

    @Test
    /**
     * test for getKey
     */
    void getKey()
    {
        double expected = testCalc.getKey();
        assertTrue(expected > -1);
    }

    @Test
    /**
     * test for setKey
     */
    void setKey()
    {
        testCalc.setKey(123456);
        assertEquals(123456, testCalc.getKey());
    }

    @Test
    /**
     * test for getSalesTripTestData
     */
    void getSalesTripTestData()
    {
        testCalc.getSalesTripTestData();
    }

    @Test
    /**
     * test for getTotalCostList
     */
    void getTotalCostList()
    {
        testCalc.getTotalCostList();
    }

    @Test
    /**
     * test for getTravelEntertainmentExpenseTestData
     */
    void getTravelEntertainmentExpenseTestData()
    {
        testCalc.getTravelEntertainmentExpenseTestData();
    }

    @Test
    /**
     * test for testToString
     */
    void testToString()
    {
        String expected = "TotalExpenseTestCalculations";
        String actual = testCalc.toString();
        logger.debug("test toString" + "\nExpected: " + expected + "\nActual: " + actual);
        assertTrue(actual.contains(expected));
    }
}