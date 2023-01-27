/**
 * Static utility to calculate expenses.
 */
package edu.ccri.lesson02.assignment.expense;

/**
 * Static utility to calculate expenses.
 *
 * @author dean grammas
 */
public class ExpenseHelper
{
    /**
     * Calculates the cost of food for the trip.
     *
     * @param tripDataTotal tripDataTotal the total length of the trip in miles
     * @param maxDuration   the maximum duration (time) that can be traveled
     * @param FoodCost      the daily cost of food
     * @return the cost of food for the trip.
     */
    public static double getFoodCosts(double tripDataTotal, double maxDuration, double FoodCost)
    {
	return ((tripDataTotal / maxDuration) * FoodCost);
    }
    
    /**
     * Calculate the fuel costs for the trip.
     *
     * @param tripDataTotal the total length of the trip in miles
     * @param mpg           the miles sper gallon
     * @param gasPerUnit    the cost of a gallon of fuel
     * @return the fuel costs for the trip.
     */
    public static double getFuelCosts(double tripDataTotal, double mpg, double gasPerUnit)
    {
	return ((tripDataTotal / mpg) * gasPerUnit);
    }
    
    /**
     * Calculates the cost of hotel(s) for the trip.
     *
     * @param tripDataTotal the total length of the trip in miles
     * @param maxDuration   the maximum duration (time) that can be traveled
     * @param hotelCost     the cost of a hotel room
     * @return the cost of hotel(s) for the trip.
     */
    public static double getHotelCosts(double tripDataTotal, double maxDuration, double hotelCost)
    {
	return ((tripDataTotal / maxDuration) * hotelCost);
    }
    
    /**
     * Calculates the cost of an oil change for the trip.
     *
     * @param tripDataTotal the total length of the trip in miles
     * @param maxDistance   the maximum distance that can be traveled
     * @param oilChange     the cost of an oil change
     * @return the cost of an oil change for the trip.
     */
    public static double getOilCosts(double tripDataTotal, double maxDistance, double oilChange)
    {
	return ((tripDataTotal / maxDistance) * oilChange);
    }
    
    /**
     * Calculates the cost of wear and tear on the tires for the trip
     *
     * @param tripDataTotal the total length of the trip in miles
     * @param maxDistance   the maximum distance that can be traveled
     * @param fourTires     the cost of four new tires
     * @return the cost of wear and tear on the tires for the trip
     */
    public static double getTireCosts(double tripDataTotal, double maxDistance, double fourTires)
    {
	return ((tripDataTotal / maxDistance) * fourTires);
    }
    
    /**
     * Default constructor.
     */
    public ExpenseHelper()
    {
	super();
    }
}
