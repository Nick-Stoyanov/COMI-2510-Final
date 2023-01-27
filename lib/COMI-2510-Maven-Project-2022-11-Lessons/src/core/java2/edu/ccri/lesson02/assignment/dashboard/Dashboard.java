/**
 * Dashboard interface for all types of vehicles.
 */
package edu.ccri.lesson02.assignment.dashboard;

import java.util.ArrayList;

import edu.ccri.lesson02.assignment.gauge.Gauge;

/**
 * Dashboard interface for all types of vehicles.
 *
 * @author dean grammas
 */
public interface Dashboard
{
    /**
     * Returns the fuel gauge.
     *
     * @return the fuel gauge.
     */
    public Gauge getFuelGauge();
    
    /**
     * Returns a list of gauges.
     *
     * @return a list of gauges.
     */
    public ArrayList<Gauge> getGaugeList();
    
    /**
     * Returns the oil gauge.
     *
     * @return the oil gauge.
     */
    public Gauge getOilGauge();
    
    /**
     * Returns the tire gauge.
     *
     * @return the tire gauge.
     */
    public Gauge getTireGauge();
    
    /**
     * Sets the fuel gauge
     *
     * @param maximumAmount - maximum amount of fuel
     * @param currentAmount - a full tank of fuel is equal to the maximum amount
     */
    public void setFuelGauge(double maximumAmount, double currentAmount);
    
    /**
     * Sets the oil gauge
     *
     * @param maximumAmount - represents the maximum number of miles before an oil change is required
     * @param currentAmount - represents the number of miles remaining before an oil change is required (e.g. would be set to 0 after an oil change)
     */
    public void setOilGauge(double maximumAmount, double currentAmount);
    
    /**
     * Sets the tire gauge
     *
     * @param maximumAmount - represents the maximum number of miles before an tire change is required
     * @param currentAmount - represents the number of miles remaining before an tire change is required (e.g. would be set to 0 after an tires changed)
     */
    public void setTireGauge(double maximumAmount, double currentAmount);
}
