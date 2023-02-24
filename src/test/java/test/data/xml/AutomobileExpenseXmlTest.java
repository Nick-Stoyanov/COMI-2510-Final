package test.data.xml;

import edu.ccri.lesson02.assignment.expense.Expense;
import edu.ccri.lesson02.assignment.expense.FuelExpense;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.data.list.ExpenseList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class AutomobileExpenseXmlTest
{
    /**
     * xml object
     */
    AutomobileExpenseXml xml;

    @BeforeEach
    /**
     * set up
     */
    void setUp()
    {
        xml = new AutomobileExpenseXml();
    }

    @AfterEach
    /**
     * tear down
     */
    void tearDown()
    {
        xml = null;
    }

    @Test
    /**
     * test for getTestDataList
     */
    void getTestDataList()
    {
        assertTrue(xml.getTestDataList() instanceof ArrayList<Expense>);
    }

    @Test
    /**
     * test for stageTestData
     */
    void stageTestData()
    {
        ExpenseList list = new ExpenseList();
        ArrayList<Expense> expenseList = new ArrayList<>();
        expenseList.add(new FuelExpense("test",1));
        list.setTestDataList(expenseList);
        xml.stageTestData();
    }
}