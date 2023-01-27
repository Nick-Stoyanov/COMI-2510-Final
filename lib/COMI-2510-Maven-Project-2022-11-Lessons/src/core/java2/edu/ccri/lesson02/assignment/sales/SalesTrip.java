/**
 * Sales trip
 */
package edu.ccri.lesson02.assignment.sales;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;

/**
 * Sales trip
 *
 * @author dean grammas
 */
public class SalesTrip extends UniqueKeyCounter
{
    /**
     * To city
     */
    private String destinationCity;
    
    /**
     * The distance between the two cities
     */
    private double distance;
    
    /**
     * The duration (time) of travel between the two cities
     */
    private double duration;
    
    /**
     * From city
     */
    private String fromCity;
    
    /**
     * Unique object key
     */
    private int key;
    
    /**
     * Constructor <BR>
     * <UL>
     * <LI>The unique key will be set
     * <LI>The data will be set
     * </UL>
     * <BR>
     *
     * @param fromCity        - from city
     * @param destinationCity - to city
     * @param distance        - the distance between the two cities
     * @param duration        - the duration (time) of travel between the two cities
     */
    public SalesTrip(String fromCity, String destinationCity, double duration, double distance)
    {
	super();
	this.setKey(UniqueKeyCounter.getInternalCounter());
	
	this.fromCity = fromCity;
	this.destinationCity = destinationCity;
	this.distance = distance;
	this.duration = duration;
    }
    
    /**
     * Returns the destination (to) city
     *
     * @return the destinationCity
     */
    public String getDestinationCity()
    {
	return destinationCity;
    }
    
    /**
     * Returns the distance between the cities
     *
     * @return the distance
     */
    public double getDistance()
    {
	return distance;
    }
    
    /**
     * Returns the duration (time) of travel between the two cities
     *
     * @return the duration (time) of travel between the two cities
     */
    public double getDuration()
    {
	return duration;
    }
    
    /**
     * Returns the from city
     *
     * @return the fromCity
     */
    public String getFromCity()
    {
	return fromCity;
    }
    
    /**
     * Returns the unique object key
     *
     * @return the unique object key
     */
    @Override
    public int getKey()
    {
	return this.key;
    }
    
    /**
     * Sets the destination (to) city
     *
     * @param destinationCity the destinationCity to set
     */
    public void setDestinationCity(String destinationCity)
    {
	this.destinationCity = destinationCity;
    }
    
    /**
     * Sets the distance
     *
     * @param distance the distance to set
     */
    public void setDistance(double distance)
    {
	this.distance = distance;
    }
    
    /**
     * Sets the duration
     *
     * @param duration the duration to set
     */
    public void setDuration(double duration)
    {
	this.duration = duration;
    }
    
    /**
     * Sets the from city
     *
     * @param fromCity the fromCity to set
     */
    public void setFromCity(String fromCity)
    {
	this.fromCity = fromCity;
    }
    
    /**
     * Sets the unique object key
     *
     * @param key the unique object key
     */
    @Override
    protected void setKey(int key)
    {
	this.key = key;
    }
    
    /**
     * String representation of the object
     *
     * @return string representation of the object
     */
    @Override
    public String toString()
    {
	StringBuilder sb = new StringBuilder();
	
	sb.append(this.getClass());
	sb.append(" this.getFromCity()=").append(this.getFromCity());
	sb.append(" this.getDestinationCity()=").append(this.getDestinationCity());
	sb.append(" this.getDistance()=").append(this.getDistance());
	sb.append(" this.getDuration()=").append(this.getDuration());
	
	return sb.toString();
    }
}
