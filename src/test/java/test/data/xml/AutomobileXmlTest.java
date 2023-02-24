package test.data.xml;

import edu.ccri.lesson02.assignment.dashboard.Automobile;
import edu.ccri.lesson02.assignment.expense.Expense;
import edu.ccri.lesson02.assignment.expense.FuelExpense;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.data.list.AutomobileExpenseList;
import test.data.list.ExpenseList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class AutomobileXmlTest
{


    /**
     * Xml object
     */
    AutomobileXml xml;

    @BeforeEach
    /**
     *
     * set up
     */
    void setUp()
    {
        xml = new AutomobileXml();
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
        assertTrue(xml.getTestDataList() instanceof ArrayList<Automobile>);
    }

    @Test
    /**
     * test for stageTestData
     */
    void stageTestData()
    {
        AutomobileExpenseList list = new AutomobileExpenseList();
        ArrayList<Automobile> carlist = new ArrayList<>();
        carlist.add(new Automobile("test"));
        list.setTestDataList(carlist);
        xml.stageTestData();
    }
}