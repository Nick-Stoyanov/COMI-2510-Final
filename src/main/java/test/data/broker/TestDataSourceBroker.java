package test.data.broker;

/**
 * 1/30/2023
 *
 * @author Nick Stoyanov
 * <p>
 * Test data source broker
 * This is a very simple interfact, with no methods.
 * Definition of broker: one who acts as an intermediary: such as. a : an agent who arranges marriages. b : an agent who negotiates contracts of purchase and sale (as of real estate, commodities, or securities)
 */
public interface TestDataSourceBroker
{
    /**
     * Stage the data for testing
     */
    void stageTestData();
}
