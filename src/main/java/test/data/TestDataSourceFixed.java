package test.data;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;

/**
 * Test data source from fixed
 * <p>
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public abstract class TestDataSourceFixed extends TestDataSource
{
    /**
     * Constructor
     */
    public TestDataSourceFixed()
    {
        super();
        this.setKey(UniqueKeyCounter.getInternalCounter());
    }
}
