package test.data.xml;

import edu.ccri.lesson02.assignment.expense.TravelEntertainmentExpense;
import edu.ccri.lesson02.assignment.sales.SalesTrip;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.data.list.TravelEntertainmentExpenseList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test
 */
class TravelEntertainmentExpenseXmlTest
{
    /**
     * xml object
     */
    TravelEntertainmentExpenseXml xml;

    @BeforeEach
    /**
     * set up
     */
    void setUp()
    {
        xml = new TravelEntertainmentExpenseXml();
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
     * test for stageTestData
     */
    void stageTestData()
    {
        TravelEntertainmentExpenseList list = new TravelEntertainmentExpenseList();
        ArrayList<TravelEntertainmentExpense> tripList = new ArrayList<>();
        tripList.add(new TravelEntertainmentExpense("test",1,1));
        list.setTestDataList(tripList);
        xml.stageTestData();
    }

    @Test
    /**
     * test for getTestDataList
     */
    void getTestDataList()
    {
        assertTrue(xml.getTestDataList() instanceof ArrayList<TravelEntertainmentExpense>);

    }
}