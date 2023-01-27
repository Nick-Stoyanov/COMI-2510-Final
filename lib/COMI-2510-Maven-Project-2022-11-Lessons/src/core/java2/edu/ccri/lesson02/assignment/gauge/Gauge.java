/**
 * This is an abstract implementation of a gauge amount.
 *
 * @author costa
 */
package edu.ccri.lesson02.assignment.gauge;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;

/**
 * This is an abstract implementation of a gauge amount.
 *
 * @author costa
 */
public abstract class Gauge extends UniqueKeyCounter implements GaugeAmounts
{
    /**
     * The current amount
     */
    private double currentAmount;
    
    /**
     * Object instance key
     */
    private int key;
    
    /**
     * The maximum amount
     */
    private double maximumAmount;
    
    /**
     * Constructor <BR>
     * <UL>
     * <LI>The unique key will be set
     * </UL>
     * <BR>
     *
     */
    public Gauge()
    {
	super();
	this.setKey(UniqueKeyCounter.getInternalCounter());
    }
    
    /**
     * Returns the current amount. Gauges have a "maximum" amount and "current" amount. The current amount is never more than the maximum. The current can
     * start at 0 and reach the maximum, or start at the maximum and go to 0.
     *
     * @return the current amount
     */
    @Override
    public double getCurrentAmount()
    {
	return currentAmount;
    }
    
    /**
     * Returns the key for the object
     *
     * @return the key for the object
     */
    @Override
    public int getKey()
    {
	return this.key;
    }
    
    /**
     * Returns the maximum amount
     *
     * @return the maximum amount
     */
    @Override
    public double getMaximumAmount()
    {
	return maximumAmount;
    }
    
    /**
     * Sets the current amount. Gauges have a "maximum" amount and "current" amount. The current amount is never more than the maximum. The current can
     * start at 0 and reach the maximum, or start at the maximum and go to 0.
     */
    @Override
    public void setCurrentAmount(double currentAmount)
    {
	this.currentAmount = currentAmount;
    }
    
    /**
     * Returns the key for the object
     *
     * @param key the key for the object
     */
    @Override
    protected void setKey(int key)
    {
	this.key = key;
    }
    
    /**
     * Sets the maximum amount
     *
     * @param maximumAmount the maximum amount
     */
    @Override
    public void setMaximumAmount(double maximumAmount)
    {
	this.maximumAmount = maximumAmount;
    }
    
    /**
     * Returns a string representation
     *
     * @return string representation
     */
    @Override
    public String toString()
    {
	StringBuilder sb = new StringBuilder();
	
	sb.append(this.getClass());
	sb.append(" this.getKey()=").append(this.getKey()).append("\n");
	sb.append(" this.getMaximumAmount()=").append(this.getMaximumAmount()).append("\n");
	sb.append(" this.getCurrentAmount()=").append(this.getCurrentAmount()).append("\n");
	
	return sb.toString();
    }
}
