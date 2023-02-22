package test.data.helper;

import edu.ccri.lesson02.assignment.sales.SalesTrip;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class SalesTripHelperTest
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(SalesTripHelper.class.getName());

    /**
     * Helper
     */
    SalesTripHelper helper;

    /**
     * Test data list
     */
    List<SalesTrip> testDataList;

    @BeforeEach
    /**
     *
     */
    void setUp()
    {
        helper = new SalesTripHelper();
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
        helper.addExpense(testDataList, "from", "to", 1, 1 );
        logger.debug("test addExpense: " + testDataList);
        assertTrue(testDataList != null);
    }

    @Test
    /**
     * test for getTotalSalesTripDistance
     */
    void getTotalSalesTripDistance()
    {
        double expected = 1;
        helper.addExpense(testDataList, "from", "to", 1, 1 );
        double actual = helper.getTotalSalesTripDistance(testDataList);
        logger.debug("test GetTotalSalesTripDistance: " + helper.getTotalSalesTripDistance(testDataList) + "\nExpected: " + expected);
        assertEquals(expected,actual);
    }

    @Test
    /**
     * test for getTotalSalesTripDuration
     */
    void getTotalSalesTripDuration()
    {
        double expected = 2;
        helper.addExpense(testDataList, "from", "to", 2, 1 );
        double actual = helper.getTotalSalesTripDuration(testDataList);
        logger.debug("test getTotalSalesTripDuration: " + helper.getTotalSalesTripDuration(testDataList) + "\nExpected: " + expected);
        assertEquals(expected,actual);
    }
}