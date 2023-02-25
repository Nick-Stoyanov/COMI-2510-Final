package test.util;

import edu.ccri.lesson02.assignment.dashboard.Automobile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class TotalExpenseWriteDataFilePoiTest
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(TotalExpenseWriteDataFilePoiTest.class.getName());

    /**
     * poi object
     */
    TotalExpenseWriteDataFilePoi poi;

    @BeforeEach
    /**
     * set up
     */
    void setUp()
    {
        poi = new TotalExpenseWriteDataFilePoi();
    }

    @AfterEach
    /**
     * tear down
     */
    void tearDown()
    {
        poi = null;
    }

    @Test
    /**
     * test for getDataList
     */
    void getDataList()
    {
        ArrayList<ArrayList<Object>> dataList = new ArrayList<>();
        ArrayList<Object> object = new ArrayList<>();
        object.add(new Automobile("test"));
        dataList.add(object);
        poi.setDataList(dataList);

        assertTrue(poi.getDataList() != null);
    }

    @Test
    /**
     * test for setDataList
     */
    void setDataList()
    {
        ArrayList<ArrayList<Object>> dataList = new ArrayList<>();
        ArrayList<Object> object = new ArrayList<>();
        object.add(new Automobile("test"));
        dataList.add(object);
        poi.setDataList(dataList);

        assertTrue(poi.getDataList() != null);
    }

    @Test
    /**
     * test for getFileNamePrefix
     */
    void getFileNamePrefix()
    {
        String expected = "TravelExpenses_";
        assertTrue(poi.getFileNamePrefix().contains(expected));
    }

    @Test
    /**
     * test for getFileNameSuffix
     */
    void getFileNameSuffix()
    {
        String expected = ".xlsx";
        assertTrue(poi.getFileNameSuffix().contains(expected));
    }

    @Test
    /**
     * test for useNameUnique
     */
    void useNameUnique()
    {
        assertTrue(poi.useNameUnique());
    }

    @Test
    /**
     * test for getOutputFilePath
     */
    void getOutputFilePath()
    {
        String expected = "out/";
        String actual = poi.getOutputFilePath();
        logger.debug("test getOutputFilePath()" + "\nExpected:" + expected);
        logger.debug("\nActual: " + actual);
        assertTrue(poi.getOutputFilePath().contains(expected));
    }

    @Test
    /**
     * test for testToString
     */
    void testToString()
    {
        String expected = "TotalExpenseWriteDataFilePoi()";
        assertTrue(poi.toString().contains(expected));
    }
}