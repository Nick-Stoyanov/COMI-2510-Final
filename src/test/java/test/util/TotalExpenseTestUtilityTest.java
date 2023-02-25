package test.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class TotalExpenseTestUtilityTest
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(TotalExpenseTestUtilityTest.class.getName());

    /**
     * Total expense utility object
     */
    TotalExpenseTestUtility test;

    @BeforeEach
    /**
     *
     * set up
     */
    void setUp()
    {
        test = new TotalExpenseTestUtility();
    }

    @AfterEach
    /**
     * tear down
     */
    void tearDown()
    {
        test = null;
    }

    @Test
    /**
     * test for getFullyQualifiedInputPath
     */
    void getFullyQualifiedInputPath()
    {
        String expected = "rc/main/resources/resources/lesson04/assignment/in";
        logger.debug("test getFullyQualifiedInputPath()" + "\nExpected: " + expected);
        String actual = test.getFullyQualifiedInputPath();
        logger.debug("\nActual: " + actual);
        assertTrue(actual.contains(expected));
    }

    @Test
    /**
     * test for setFullyQualifiedInputPath
     */
    void setFullyQualifiedInputPath()
    {
        test.setFullyQualifiedInputPath("test");
        assertTrue(test.getFullyQualifiedInputPath().contains("test"));
    }

    @Test
    /**
     * test for getAssignmentDetails
     */
    void getAssignmentDetails()
    {
        String expected = "xxx";
        assertTrue(test.getAssignmentDetails().contains(expected));
    }

    @Test
    /**
     * test for gloriousArgs
     */
    void gloriousArgs()
    {

        String[] args = new String[]{"hi"};

        assertTrue(test.gloriousArgs(args).contains("hi"));
    }
}