package test.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import test.data.broker.AutomobileBroker;
import test.data.broker.AutomobileExpenseBroker;
import test.data.broker.SalesTripBroker;
import test.data.broker.TravelEntertainmentExpenseBroker;
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
     * Returns a new concrete test data broker based on the provided test data type.
     *
     * @param testDataType test data type
     * @return a new concrete test data broker based on the provided test data type.
     */
    public static AutomobileExpenseBroker getAutomobileExpenseTestData(TestDataType testDataType)
    {
        AutomobileExpenseBroker broker = null;
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

        return broker;
    }

    /**
     * Returns a new concrete test data broker based on the provided test data type.
     *
     * @param testDataType test data type
     * @return a new concrete test data broker based on the provided test data type.
     */
    public static AutomobileBroker getAutomobileTestData(TestDataType testDataType)
    {
        AutomobileBroker broker = null;

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

        return broker;
    }

    /**
     * Returns a new concrete test data broker based on the provided test data type.
     *
     * @param testDataType test data type
     * @return a new concrete test data broker based on the provided test data type.
     */
    public static SalesTripBroker getSalesTripTestData(TestDataType testDataType)
    {
        SalesTripBroker broker = null;

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
        return broker;
    }

    /**
     * Returns a new concrete test data broker based on the provided test data type.
     *
     * @param testDataType test data type
     * @return a new concrete test data broker based on the provided test data type.
     */
    public static TravelEntertainmentExpenseBroker getTravelEntertainmentExpenseTestData(TestDataType testDataType)
    {
        TravelEntertainmentExpenseBroker broker = null;

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
        return broker;

    }


}

