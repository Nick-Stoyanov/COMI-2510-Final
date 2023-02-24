package test.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class TotalExpenseConstantsTest
{

    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(TotalExpenseConstantsTest.class.getName());
    /**
     * constants object
     */
    TotalExpenseConstants constants;

    @BeforeEach
    /**
     * set up
     */
    void setUp()
    {
        constants = new TotalExpenseConstants();
    }

    @AfterEach
    /**
     * tear down
     */
    void tearDown()
    {
        constants = null;
    }

    @Test
    /**
     * test for setProperties
     */
    void setProperties()
    {
    }

    @Test
    /**
     * test for getProperty
     */
    void getProperty()
    {
    }

    @Test
    /**
     * test for getPropertyAppend
     */
    void getPropertyAppend()
    {
        String prefix = "test";
        String suffix = "resource.path.input";
        String expected = "in/";
        logger.debug("test getPropertyAppend()" + "\nExpected: " + expected);

        String result = constants.getPropertyAppend(prefix, suffix);
        logger.debug("\nActual:" + result);

        assertTrue(result.contains(expected));
    }

    @Test
    /**
     * test for getPropertyConcat
     */
    void getPropertyConcat()
    {
        String prefix = "excel.output.filename.prefix";
        String suffix = "excel.output.filename.suffix";

        String expected = "TravelExpenses_.xlsx";
        logger.debug("test getPropertyConcat()" + "\nExpected: " + expected);
        String result = constants.getPropertyConcat(prefix, suffix);
        logger.debug("\nActual: " + result);

        assertTrue(result.contains(expected));
    }

    @Test
    /**
     * test for getPropertyPrepend
     */
    void getPropertyPrepend()
    {
        String actual = constants.getPropertyPrepend("a", "a");
        assertTrue(actual == null);
    }


}