/**
 * Unique key counter that all objects will implment.
*/
package edu.ccri.lesson02.assignment.common;

/**
 * Unique key counter that all objects will implment. Intellectual property and the number of objects created are critical to the implementation.
 * Therfore, all objects will implement this class and generate an unique object id. An object id is not the same as a class id. For example if there
 * are 3 object instatiations of class then there will be 3 unique object ids.
 *
 * @author dean grammas
 */
public abstract class UniqueKeyCounter
{
    /**
     * Internal counter
     */
    private static int internalCounter = 0;
    
    /**
     * Returns the internal counter
     *
     * @return the internalCounter
     */
    protected static int getInternalCounter()
    {
	return internalCounter;
    }
    
    /**
     * Sets the internal counter
     *
     * @param internalCounter the internalCounter to set
     */
    private static void setInternalCounter(int internalCounter)
    {
	UniqueKeyCounter.internalCounter = internalCounter;
    }
    
    /**
     * Constructor
     */
    protected UniqueKeyCounter()
    {
	UniqueKeyCounter.setInternalCounter(UniqueKeyCounter.getInternalCounter() + 1);
    }
    
    /**
     * Returns the key for the object
     *
     * @return the key for the object
     */
    public abstract int getKey();
    
    /**
     * Returns the key for the object
     *
     * @param key the key for the object
     */
    protected abstract void setKey(int key);
    
}
