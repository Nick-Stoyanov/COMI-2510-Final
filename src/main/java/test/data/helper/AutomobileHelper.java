package test.data.helper;

import edu.ccri.lesson02.assignment.dashboard.Automobile;

import java.util.List;

/**
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class AutomobileHelper
{
    /**
     * Constructor
     */
    public AutomobileHelper()
    {
        super();
    }

    /**
     * Add the expenses to the test data list
     *
     * @param testDataList the data list
     * @param name         the name of the expense
     * @param mpg          the mpg
     * @param fuelCapacity fuel capacity
     * @param oilChange    miles for an oil change
     * @param tireLife     miles for tire change
     */
    public static void addExpenses(List<Automobile> testDataList,
                                   String name,
                                   double mpg,
                                   double fuelCapacity,
                                   double oilChange,
                                   double tireLife)
    {
        Automobile car = new Automobile(name);
        car.setMpg(mpg);
        car.setFuelGauge(fuelCapacity, fuelCapacity);
        car.setOilGauge(oilChange, 0);
        car.setTireGauge(tireLife, 0);
        testDataList.add(car);
    }

    /**
     * Loop through the list of expenses and return the expense which matches the type and name requested
     *
     * @param testDataList the list to search
     * @param name         the name of the car
     * @return Automobile object
     */
    public Automobile getAutomobile(List<Automobile> testDataList,
                                    String name)
    {
        Automobile car = null;

        for (Automobile auto : testDataList)
        {
            if (auto.getName().equals(name))
            {
                car = auto;
            }

        }
        return car;
    }
}
