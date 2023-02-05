package test.data.helper;

import edu.ccri.lesson02.assignment.sales.SalesTrip;

import java.util.ArrayList;

/**
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class SalesTripHelper
{

    /**
     * Constructor
     */
    public SalesTripHelper()
    {
        super();
    }

    /**
     * Add Sales Trip Expense to the list
     *
     * @param testDataList    list to add to
     * @param fromCity        from city name
     * @param destinationCity destination city name
     * @param duration        duration
     * @param distance        distance
     */
    public static void addExpenses(ArrayList<SalesTrip> testDataList,
                                   String fromCity,
                                   String destinationCity,
                                   double duration,
                                   double distance)
    {
        SalesTrip trip = new SalesTrip(fromCity, destinationCity, duration, distance);
        testDataList.add(trip);

    }

    /**
     * Returns the total sales trip distance (in miles)
     *
     * @param testDataList test data list
     * @return the total distance
     */
    public static double getTotalSalesTripDistance(ArrayList<SalesTrip> testDataList)
    {
        double total = 0;

        for (SalesTrip trip : testDataList)
        {
            total += trip.getDistance();
        }
        return total;
    }

    /**
     * Returns the total sales trip duration (in hours)
     *
     * @param testDataList test data list
     * @return the total duration
     */
    public static double getTotalSalesTripDuration(ArrayList<SalesTrip> testDataList)
    {
        double total = 0;

        for (SalesTrip trip : testDataList)
        {
            total += trip.getDuration();
        }
        return total;

    }

}
