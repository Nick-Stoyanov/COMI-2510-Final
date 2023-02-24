package test.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test
 */
class TotalExpenseTestDataTest
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(TotalExpenseTestDataTest.class.getName());

    /**
     * total expense test data object
     */
    TotalExpenseTestData totalExpenseTestData;

    @BeforeEach
    /**
     * set up
     */
    void setUp()
    {
        totalExpenseTestData = new TotalExpenseTestData();
    }

    @AfterEach
    /**
     * tear down
     */
    void tearDown()
    {
        totalExpenseTestData =  null;
    }

    @Test
    /**
     * test for getTotalExpenseWriteDataFilePoi
     */
    void getTotalExpenseWriteDataFilePoi()
    {
        assertTrue(totalExpenseTestData.getTotalExpenseWriteDataFilePoi()instanceof TotalExpenseWriteDataFilePoi);
    }

    @Test
    /**
     * test for setTotalExpenseWriteDataFilePoi
     */
    void setTotalExpenseWriteDataFilePoi()
    {
        TotalExpenseWriteDataFilePoi poi = new TotalExpenseWriteDataFilePoi();
        ArrayList<ArrayList<Object>> outer = new ArrayList<>();
        ArrayList<Object> inner = new ArrayList<>();
        inner.add("test");
        outer.add(inner);
        poi.setDataList(outer);

        totalExpenseTestData.setTotalExpenseWriteDataFilePoi(poi);

        assertTrue(totalExpenseTestData.getTotalExpenseWriteDataFilePoi()!=null);
    }

    @Test
    /**
     * test for getTotalExpenseWriteDataFileXml
     */
    void getTotalExpenseWriteDataFileXml()
    {
        assertTrue(totalExpenseTestData.getTotalExpenseWriteDataFileXml()instanceof TotalExpenseWriteDataFileXml);
    }

    @Test
    /**
     * test for setTotalExpenseWriteDataFileXml
     */
    void setTotalExpenseWriteDataFileXml()
    {
        /*
        TotalExpenseWriteDataFileXml poi = new TotalExpenseWriteDataFileXml();
        ArrayList<ArrayList<Object>> outer = new ArrayList<>();
        ArrayList<Object> inner = new ArrayList<>();
        inner.add("test");
        outer.add(inner);
        poi.setDataList(outer);

        totalExpenseTestData.setTotalExpenseWriteDataFilePoi(poi);

        assertTrue(totalExpenseTestData.getTotalExpenseWriteDataFilePoi()!=null);
        */


    }

    @Test
    /**
     * test for stageData
     */
    void stageData()
    {
        totalExpenseTestData.stageData(TestDataType.FIXED);
        logger.debug("Fixed data\n" + TestDataType.FIXED);

        totalExpenseTestData.stageData(TestDataType.EXCEL);
        logger.debug("Excel data\n" + TestDataType.EXCEL);

        totalExpenseTestData.stageData(TestDataType.XML);
        logger.debug("XML data\n" + TestDataType.XML);



    }

    @Test
    /**
     * test for writeFiles
     */
    void writeFiles()
    {
    }
}