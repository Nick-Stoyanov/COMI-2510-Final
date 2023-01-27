/**
 * Instatiation of an automobile dashboard.
 */
package edu.ccri.lesson02.assignment.dashboard;

import java.util.ArrayList;
import java.util.Iterator;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;
import edu.ccri.lesson02.assignment.gauge.FuelGauge;
import edu.ccri.lesson02.assignment.gauge.Gauge;
import edu.ccri.lesson02.assignment.gauge.OilGauge;
import edu.ccri.lesson02.assignment.gauge.TireGauge;

/**
 * Instatiation of an automobile dashboard.
 *
 * @author dean grammas
 */
public class Automobile extends UniqueKeyCounter implements Dashboard
{
    /**
     * List of gauges for this automobile
     */
    private ArrayList<Gauge> gaugeList;
    
    /**
     * Unique key
     */
    private int key;
    
    /**
     * Average MPG (miles per gallon) for this automobile
     */
    private double mpg;
    
    /**
     * Name of the automobile
     */
    private String name;
    
    /**
     * Constructor <BR>
     * <UL>
     * <LI>The unique key will be set
     * <LI>The name will be set
     * <LI>The gauge list will be created
     * <LI>The gauges will be creted and added to the gauge list *
     * </UL>
     * <BR>
     *
     * @param name the name of this automobile
     */
    public Automobile(String name)
    {
	super();
	this.setKey(UniqueKeyCounter.getInternalCounter());
	
	this.setName(name);
	
	gaugeList = new ArrayList<>();
	gaugeList.add(new FuelGauge());
	gaugeList.add(new OilGauge());
	gaugeList.add(new TireGauge());
	
	this.setGaugeList(gaugeList);
    }
    
    /**
     * Returns the fuel gauge from the list of gauges
     *
     * @return the fuelGauge
     */
    @Override
    public Gauge getFuelGauge()
    {
	Iterator<Gauge> iter = this.getGaugeList().iterator();
	Gauge gauge = null;
	
	while (iter.hasNext())
	{
	    gauge = iter.next();
	    if (gauge instanceof FuelGauge)
	    {
		return gauge;
	    }
	}
	return null;
    }
    
    /**
     * Returns a list of gauges.
     * 
     * @return the gaugeList
     */
    @Override
    public ArrayList<Gauge> getGaugeList()
    {
	return gaugeList;
    }
    
    /**
     * Returns the key
     * 
     * @return the key
     */
    @Override
    public int getKey()
    {
	return key;
    }
    
    /**
     * Get mpg
     *
     * @return the mpg
     */
    public double getMpg()
    {
	return mpg;
    }
    
    /**
     * Get name
     *
     * @return the name
     */
    public String getName()
    {
	return name;
    }
    
    /**
     * Returns the oil gauge from the list of gauges
     *
     * @return the oilGauge
     */
    @Override
    public Gauge getOilGauge()
    {
	Iterator<Gauge> iter = this.getGaugeList().iterator();
	Gauge gauge = null;
	
	while (iter.hasNext())
	{
	    gauge = iter.next();
	    if (gauge instanceof OilGauge)
	    {
		return gauge;
	    }
	}
	return null;
    }
    
    /**
     * Returns the tire gauge from the list of gauges
     *
     * @return the tireGauge
     */
    @Override
    public Gauge getTireGauge()
    {
	Iterator<Gauge> iter = this.getGaugeList().iterator();
	Gauge gauge = null;
	
	while (iter.hasNext())
	{
	    gauge = iter.next();
	    if (gauge instanceof TireGauge)
	    {
		return gauge;
	    }
	}
	return null;
    }
    
    /**
     * Sets the fuel gauge in the list of gauges
     *
     * @param maximumAmount - maximum amount of fuel
     * @param currentAmount - a full tank of fuel is equal to the maximum amount
     */
    @Override
    public void setFuelGauge(double maximumAmount, double currentAmount)
    {
	Iterator<Gauge> iter = this.getGaugeList().iterator();
	Gauge gauge = null;
	
	while (iter.hasNext())
	{
	    gauge = iter.next();
	    if (gauge instanceof FuelGauge)
	    {
		gauge.setMaximumAmount(maximumAmount);
		gauge.setCurrentAmount(currentAmount);
		return;
	    }
	}
    }
    
    /**
     * Set gauge list
     *
     * @param gaugeList the gaugeList to set
     */
    private void setGaugeList(ArrayList<Gauge> gaugeList)
    {
	this.gaugeList = gaugeList;
    }
    
    /**
     * Set key
     *
     * @param key the key to set
     */
    @Override
    protected void setKey(int key)
    {
	this.key = key;
    }
    
    /**
     * Set mpg
     *
     * @param mpg the mpg to set
     */
    public void setMpg(double mpg)
    {
	this.mpg = mpg;
    }
    
    /**
     * Set name
     *
     * @param name the name to set
     */
    private void setName(String name)
    {
	this.name = name;
    }
    
    /**
     * Sets the oil gauge in the list of gauges
     *
     * @param maximumAmount - represents the maximum number of miles before an oil change is required
     * @param currentAmount - represents the number of miles remaining before an oil change is required (e.g. would be set to 0 after an oil change)
     */
    @Override
    public void setOilGauge(double maximumAmount, double currentAmount)
    {
	Iterator<Gauge> iter = this.getGaugeList().iterator();
	Gauge gauge = null;
	
	while (iter.hasNext())
	{
	    gauge = iter.next();
	    if (gauge instanceof OilGauge)
	    {
		gauge.setMaximumAmount(maximumAmount);
		gauge.setCurrentAmount(currentAmount);
		return;
	    }
	}
    }
    
    /**
     * Sets the tire gauge in the list of gauges
     *
     * @param maximumAmount - represents the maximum number of miles before an tire change is required
     * @param currentAmount - represents the number of miles remaining before an tire change is required (e.g. would be set to 0 after an tires changed)
     */
    @Override
    public void setTireGauge(double maximumAmount, double currentAmount)
    {
	Iterator<Gauge> iter = this.getGaugeList().iterator();
	Gauge gauge = null;
	
	while (iter.hasNext())
	{
	    gauge = iter.next();
	    if (gauge instanceof TireGauge)
	    {
		gauge.setMaximumAmount(maximumAmount);
		gauge.setCurrentAmount(currentAmount);
		return;
	    }
	}
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
	
	sb.append(this.getClass()).append("\n");
	sb.append(" this.getKey()=").append(this.getKey()).append("\n");
	sb.append(" this.getName()=").append(this.getName()).append("\n");
	sb.append(" this.getMpg()=").append(this.getMpg()).append("\n");
	sb.append(" this.getGaugeList()=").append(this.getGaugeList()).append("\n");
	
	return sb.toString();
    }
}
