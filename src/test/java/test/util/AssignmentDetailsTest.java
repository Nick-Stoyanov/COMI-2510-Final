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
class AssignmentDetailsTest
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(AssignmentDetailsTest.class.getName());
    /**
     * Assignment details
     */
    AssignmentDetails assDeets;

    @BeforeEach
    /**
     * set up
     */
    void setUp()
    {
        assDeets = new AssignmentDetails();
    }

    @AfterEach
    /**
     * tear down
     */
    void tearDown()
    {
        assDeets = null;
    }

    @Test
    /**
     * test for getProperty
     */
    void getProperty()
    {
        String expected = "Nick Stoyanov";
        logger.debug("test getProperty()" + "\nExpected: " + expected);
        String actual = assDeets.getProperty("name");
        logger.debug("\nActual: " + actual);

        assertTrue(actual.contains(expected));
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

        String result = assDeets.getPropertyAppend(prefix, suffix);
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
        String result = assDeets.getPropertyConcat(prefix, suffix);
        logger.debug("\nActual: " + result);

        assertTrue(result.contains(expected));
    }

    @Test
    /**
     * test for getPropertyPrepend
     */
    void getPropertyPrepend()
    {
        String actual = assDeets.getPropertyPrepend("a", "a");
        assertTrue(actual == null);
    }


}