package test.data;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;

/**
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public abstract class TestDataSourceXml extends TestDataSource
{

    /**
     * Constructor
     */
    public TestDataSourceXml()
    {
        super();
        this.setKey(UniqueKeyCounter.getInternalCounter());
    }
}
