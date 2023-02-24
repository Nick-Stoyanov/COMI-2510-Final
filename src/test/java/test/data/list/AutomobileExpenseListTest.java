package test.data.list;

import edu.ccri.lesson02.assignment.dashboard.Automobile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class AutomobileExpenseListTest
{

    /**
     * List
     */
    AutomobileExpenseList list;

    @BeforeEach
    /**
     * set up
     */
    void setUp()
    {
        list = new AutomobileExpenseList();
    }

    @AfterEach
    /**
     * tear down
     */
    void tearDown()
    {
        list = null;
    }

    @Test
    /**
     * test for getTestDataList
     */
    void getTestDataList()
    {
        assertTrue(list.getTestDataList() instanceof ArrayList<Automobile>);
    }

    @Test
    /**
     * test for setTestDataList
     */
    void setTestDataList()
    {
        ArrayList<Automobile> testList = new ArrayList<>();
        testList.add(new Automobile("test"));
        list.setTestDataList(testList);
        assertTrue(list.getTestDataList().get(0).getName().contains("test"));
    }
}