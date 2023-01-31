package test.data;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;
import test.data.broker.TestDataSourceBroker;

/**
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public abstract class TestDataSource extends UniqueKeyCounter implements TestDataSourceBroker
{

    /**
     * @return Returns the unique key
     */
    @Override
    public int getKey()
    {
        return key;
    }

    /**
     * @param key the key for the object
     */
    @Override
    public void setKey(int key)
    {
        this.key = key;
    }

    /**
     * Key value
     */
    private int key;


    /**
     * Constructor
     */
    public TestDataSource()
    {
        super();
    }


}
