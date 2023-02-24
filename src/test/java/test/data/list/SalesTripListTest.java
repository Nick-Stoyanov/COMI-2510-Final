package test.data.list;

import edu.ccri.lesson02.assignment.sales.SalesTrip;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class SalesTripListTest
{
    /**
     * List
     */
    SalesTripList list;

    @BeforeEach
    /**
     * set up
     */
    void setUp()
    {
        list = new SalesTripList();
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
        assertTrue(list.getTestDataList() instanceof ArrayList<SalesTrip>);
    }

    @Test
    /**
     * test for setTestDataList
     */
    void setTestDataList()
    {
        ArrayList<SalesTrip> testList = new ArrayList<>();
        testList.add(new SalesTrip("from", "to", 1, 1));
        list.setTestDataList(testList);
        assertTrue(list.getTestDataList().get(0).getFromCity().contains("from"));
    }
}