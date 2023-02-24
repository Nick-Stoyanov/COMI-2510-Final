package test.data.list;

import edu.ccri.lesson02.assignment.expense.TravelEntertainmentExpense;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class TravelEntertainmentExpenseListTest
{
    /**
     * List
     */
    TravelEntertainmentExpenseList list;

    @BeforeEach
    /**
     * set up
     */
    void setUp()
    {
        list = new TravelEntertainmentExpenseList();
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
        assertTrue(list.getTestDataList() instanceof ArrayList<TravelEntertainmentExpense>);
    }

    @Test
    /**
     * test for setTestDataList
     */
    void setTestDataList()
    {
        ArrayList<TravelEntertainmentExpense> testList = new ArrayList<>();
        testList.add(new TravelEntertainmentExpense("test", 1, 1));
        list.setTestDataList(testList);
        assertTrue(list.getTestDataList().get(0).getFood().getName().contains("test"));
    }
}