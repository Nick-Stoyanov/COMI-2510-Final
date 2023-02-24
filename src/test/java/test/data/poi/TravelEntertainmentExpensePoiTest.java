package test.data.poi;

import edu.ccri.lesson02.assignment.expense.TravelEntertainmentExpense;
import edu.ccri.lesson02.assignment.poi.PoiData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Test
 */
class TravelEntertainmentExpensePoiTest
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(TravelEntertainmentExpensePoi.class.getName());

    /**
     * Poi object
     */
    TravelEntertainmentExpensePoi poi;

    @BeforeEach
    /**
     * set up
     */
    void setUp()
    {
        poi = new TravelEntertainmentExpensePoi();
    }

    @AfterEach
    /**
     * Tear down
     */
    void tearDown()
    {
        poi = null;
    }

    @Test
    /**
     * test for getFileName
     */
    void getFileName()
    {
        String expected = "C:/Users/Nick/eclipse-workspace/COMI-2510-Final/src/main/resources/resources/lesson04/assignment/in/TravelExpenses.xlsx";
        String actual = poi.getFileName();
        logger.debug("getFileName test\n" + "excepted: " + expected + "\nactual: " + actual);
        assertTrue(actual.contains(expected));
    }

    @Test
    /**
     * test for getWorksheetNumber
     */
    void getWorksheetNumber()
    {
        assertEquals(3, poi.getWorksheetNumber());

    }

    @Test
    /**
     * test for handlePoiDataRowResults
     */
    void handlePoiDataRowResults()
    {
        ArrayList<PoiData> rowDataList = new ArrayList<>();
        rowDataList.add(new PoiData(0, 0, 1));
        rowDataList.add(new PoiData(0, 1, 1));
        rowDataList.add(new PoiData(0, 2, 1));

        poi.handlePoiDataRowResults(rowDataList);
    }

    @Test
    /**
     * test for getTestDataList
     */
    void getTestDataList()
    {
        assertTrue(poi.getTestDataList() instanceof ArrayList<TravelEntertainmentExpense>);
    }

    @Test
    /**
     * test for testToString
     */
    void testToString()
    {
        String expected = "TravelEntertainmentExpensePoi";
        logger.debug("\nExpected: " + expected);
        String actual = poi.toString();
        logger.debug("\nActual : " + actual);

        assertTrue(actual.contains(expected));
    }
}