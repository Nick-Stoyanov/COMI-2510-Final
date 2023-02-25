package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.util.TotalExpenseTestData;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class TotalExpenseTestTest
{
    /**
     * total expense test object
     */
    TotalExpenseTest test;

    @BeforeEach
    /**
     * set up
     */
    void setUp()
    {
        test = new TotalExpenseTest();
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
     * test for getTotalExpenseTestData
     */
    void getTotalExpenseTestData()
    {
        assertTrue(test.getTotalExpenseTestData()instanceof TotalExpenseTestData);
    }


    @Test
    /**
     * test for main
     */
    void main()
    {
        String[] args = new String[]{"test"};
        test.main(args);

    }
}