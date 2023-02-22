package test.data.fixed;

import edu.ccri.lesson02.assignment.dashboard.Automobile;
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
class AutomobileFixedTest
{

    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(AutomobileFixedTest.class.getName());

    /**
     * Fixed data
     */
    AutomobileFixed fixed;

    @BeforeEach
    /**
     * set up
     */
    void setUp()
    {
        fixed = new AutomobileFixed();
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
        assertTrue(fixed.getTestDataList() instanceof ArrayList<Automobile>);
        logger.debug("getTestDataList test: " + fixed.getTestDataList());
    }

    @Test
    /**
     * test for stageTestData
     */
    void stageTestData()
    {
        logger.debug("test data start: " + fixed.getTestDataList());
        fixed = new AutomobileFixed();
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