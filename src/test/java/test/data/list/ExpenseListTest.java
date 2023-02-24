package test.data.list;

import edu.ccri.lesson02.assignment.expense.Expense;
import edu.ccri.lesson02.assignment.expense.FuelExpense;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class ExpenseListTest
{
    /**
     * List
     */
    ExpenseList list;

    @BeforeEach
    /**
     * set up
     */
    void setUp()
    {
        list = new ExpenseList();
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
        assertTrue(list.getTestDataList() instanceof ArrayList<Expense>);
    }

    @Test
    /**
     * test for setTestDataList
     */
    void setTestDataList()
    {
        ArrayList<Expense> testList = new ArrayList<>();
        testList.add(new FuelExpense("test", 1));
        list.setTestDataList(testList);
        assertTrue(list.getTestDataList().get(0).getName().contains("test"));
    }
}