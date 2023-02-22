package test.data.helper;

import edu.ccri.lesson02.assignment.dashboard.Automobile;
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
class AutomobileHelperTest
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(AutomobileHelper.class.getName());

    /**
     * Helper
     */
    AutomobileHelper helper;

    /**
     * Test data list
     */
    List<Automobile> testDataList;

    @BeforeEach
    /**
     *
     */
    void setUp()
    {
        helper = new AutomobileHelper();
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
     * test for getAutomobile
     */
    void getAutomobile()
    {
        helper.addExpense(testDataList, "test", 1, 1, 1, 1);
        logger.debug("test getAutomobile: " + testDataList);
        assertTrue(helper.getAutomobile(testDataList, "test") instanceof Automobile);
    }
}