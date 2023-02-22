package test.data.fixed;

import edu.ccri.lesson02.assignment.dashboard.Automobile;
import edu.ccri.lesson02.assignment.sales.SalesTrip;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test
 */
class SalesTripFixedTest
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(SalesTripFixed.class.getName());

    /**
     * fixed Data
     */
    SalesTripFixed fixed;

    @BeforeEach
    /**
     * Set up
     */
    void setUp()
    {
        fixed = new SalesTripFixed();
        fixed.stageTestData();
    }

    @AfterEach
    /**
     * Tear down
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
        assertTrue(fixed.getTestDataList() instanceof ArrayList<SalesTrip>);
        logger.debug("getTestDataList test: " + fixed.getTestDataList());
    }

    @Test
    /**
     * test for stageTestData
     */
    void stageTestData()
    {
        logger.debug("test data start: " + fixed.getTestDataList());
        fixed = new SalesTripFixed();
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
        String expected = "New York";
        logger.debug("toStringTest.\n Expected: " + expected);
        String actual = fixed.toString();
        logger.debug("\nActual : " + actual);
        assertTrue(actual.contains(expected));
    }
}