package test.data.broker;

import edu.ccri.lesson02.assignment.dashboard.Automobile;

import java.util.ArrayList;

/**
 * 1/30/2023
 *
 * @author Nick Stoyanov
 * <p>
 * Automobile broker
 * <p>
 * Definition of broker: one who acts as an intermediary: such as. a : an agent who arranges marriages. b : an agent who negotiates contracts of purchase and sale (as of real estate, commodities, or securities)
 */
public interface AutomobileBroker
{
    /**
     * Returns the test data list
     *
     * @return the test data list
     */
    ArrayList<Automobile> getTestDataList();
}
