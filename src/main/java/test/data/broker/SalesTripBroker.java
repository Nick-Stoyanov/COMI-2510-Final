package test.data.broker;

import edu.ccri.lesson02.assignment.sales.SalesTrip;

import java.util.ArrayList;

/**
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public interface SalesTripBroker
{

    /**
     * Returns the test data list
     *
     * @return the test data list
     */
    ArrayList<SalesTrip> getTestDataList();
}
