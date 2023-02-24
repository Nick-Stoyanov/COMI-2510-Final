package test.data.xml;

import edu.ccri.lesson02.assignment.sales.SalesTrip;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.data.list.SalesTripList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class SalesTripXmlTest
{
    /**
     * xml object
     */
    SalesTripXml xml;

    @BeforeEach
    /**
     *
     * set up
     */
    void setUp()
    {
        xml = new SalesTripXml();
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
        assertTrue(xml.getTestDataList() instanceof ArrayList<SalesTrip>);
    }

    @Test
    /**
     * test for stageTestData
     */
    void stageTestData()
    {
        SalesTripList list = new SalesTripList();
        ArrayList<SalesTrip> tripList = new ArrayList<>();
        tripList.add(new SalesTrip("from", "to", 1, 1));
        list.setTestDataList(tripList);
        xml.stageTestData();
    }
}