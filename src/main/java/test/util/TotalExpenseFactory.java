package test.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import test.data.broker.*;
import test.data.fixed.AutomobileExpenseFixed;
import test.data.fixed.AutomobileFixed;
import test.data.fixed.SalesTripFixed;
import test.data.fixed.TravelEntertainmentExpenseFixed;
import test.data.poi.AutomobileExpensePoi;
import test.data.poi.AutomobilePoi;
import test.data.poi.SalesTripPoi;
import test.data.poi.TravelEntertainmentExpensePoi;
import test.data.xml.AutomobileExpenseXml;
import test.data.xml.AutomobileXml;
import test.data.xml.SalesTripXml;
import test.data.xml.TravelEntertainmentExpenseXml;

/**
 * Total expense factory. This factory will create and return the
 * appropriate concrete broker based on the requested test data type.
 * <p>
 * 2/5/2023
 *
 * @author Nick Stoyanov
 */
public class TotalExpenseFactory
{
    /**
     * Instance of the logger
     */
    private static final Logger logger = LogManager.getLogger(TotalExpenseFactory.class.getName());

    /**
     * Constructor so javaDoc can stfu
     */
    public TotalExpenseFactory()
    {
    }

    /**
     * Returns a new concrete test data broker based on the provided test data type.
     *
     * @param testDataType test data type
     * @return a new concrete test data broker based on the provided test data type.
     */
    public static AutomobileExpenseBroker getAutomobileExpenseTestData(TestDataType testDataType)
    {
        TestDataSourceBroker broker = null;
        if (TestDataType.FIXED == testDataType)
        {
            broker = new AutomobileExpenseFixed();
        } else if (TestDataType.XML == testDataType)
        {

            broker = new AutomobileExpenseXml();
        } else if (TestDataType.EXCEL == testDataType)
        {
            broker = new AutomobileExpensePoi();
        }
        broker.stageTestData();
        return (AutomobileExpenseBroker) broker;
    }

    /**
     * Returns a new concrete test data broker based on the provided test data type.
     *
     * @param testDataType test data type
     * @return a new concrete test data broker based on the provided test data type.
     */
    public static AutomobileBroker getAutomobileTestData(TestDataType testDataType)
    {
        TestDataSourceBroker broker = null;

        if (TestDataType.FIXED == testDataType)
        {
            broker = new AutomobileFixed();
        } else if (TestDataType.XML == testDataType)
        {
            broker = new AutomobileXml();
        } else if (TestDataType.EXCEL == testDataType)
        {
            broker = new AutomobilePoi();
        }

        broker.stageTestData();
        return (AutomobileBroker) broker;
    }

    /**
     * Returns a new concrete test data broker based on the provided test data type.
     *
     * @param testDataType test data type
     * @return a new concrete test data broker based on the provided test data type.
     */
    public static SalesTripBroker getSalesTripTestData(TestDataType testDataType)
    {
        TestDataSourceBroker broker = null;

        if (TestDataType.FIXED == testDataType)
        {
            broker = new SalesTripFixed();

        } else if (TestDataType.XML == testDataType)
        {
            broker = new SalesTripXml();
        } else if (TestDataType.EXCEL == testDataType)
        {
            broker = new SalesTripPoi();
        }
        broker.stageTestData();
        return (SalesTripBroker) broker;
    }

    /**
     * Returns a new concrete test data broker based on the provided test data type.
     *
     * @param testDataType test data type
     * @return a new concrete test data broker based on the provided test data type.
     */
    public static TravelEntertainmentExpenseBroker getTravelEntertainmentExpenseTestData(TestDataType testDataType)
    {
        TestDataSourceBroker broker = null;

        if (TestDataType.FIXED == testDataType)
        {
            broker = new TravelEntertainmentExpenseFixed();
        } else if (TestDataType.XML == testDataType)
        {
            broker = new TravelEntertainmentExpenseXml();
        } else if (TestDataType.EXCEL == testDataType)
        {
            broker = new TravelEntertainmentExpensePoi();
        }
        broker.stageTestData();
        return (TravelEntertainmentExpenseBroker) broker;

    }


}

