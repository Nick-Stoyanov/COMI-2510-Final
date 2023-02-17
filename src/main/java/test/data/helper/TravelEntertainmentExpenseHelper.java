package test.data.helper;

import edu.ccri.lesson02.assignment.expense.FoodExpense;
import edu.ccri.lesson02.assignment.expense.HotelExpense;
import edu.ccri.lesson02.assignment.expense.TravelEntertainmentExpense;

import java.util.List;

/**
 * 1/30/2023
 *
 * @author Nick Stoyanov
 */
public class TravelEntertainmentExpenseHelper
{

    /**
     * Constructor
     */
    public TravelEntertainmentExpenseHelper()
    {
        super();
    }

    /**
     * Adds the expenses to the test data list
     *
     * @param testDataList test data source
     * @param name         the name of the expense
     * @param hotelExpense the hotel cost
     * @param foodExpense  the food cost
     */
    public static void addExpense(List<TravelEntertainmentExpense> testDataList,
                                  String name,
                                  double hotelExpense,
                                  double foodExpense)
    {
        TravelEntertainmentExpense expense = new TravelEntertainmentExpense(name, hotelExpense, foodExpense);
        testDataList.add(expense);
    }

    /**
     * Loop through the list of expenses and return the expense which matches the type and name requested
     *
     * @param testDataList test data source
     * @param name         the name of the expense
     * @return the food expense
     */
    public static FoodExpense getFoodExpense(List<TravelEntertainmentExpense> testDataList,
                                             String name)
    {
        TravelEntertainmentExpense travel;
        FoodExpense expense;

        for (TravelEntertainmentExpense travelEntertainmentExpense : testDataList)
        {
            travel = travelEntertainmentExpense;
            expense = travel.getFood();
            if (expense.getName().equals(name))
            {
                return expense;
            }
        }
        return null;
    }

    /**
     * Loop through the list of expenses and return the expense which matches the type and name requested
     *
     * @param testDataList the test data source
     * @param name         the name of the expense
     * @return the hotel expense
     */
    public static HotelExpense getHotelExpense(List<TravelEntertainmentExpense> testDataList,
                                               String name)
    {
        TravelEntertainmentExpense travel;
        HotelExpense expense;

        for (TravelEntertainmentExpense travelEntertainmentExpense : testDataList)
        {
            travel = travelEntertainmentExpense;
            expense = travel.getHotel();

            if (expense.getName().equals(name))
            {
                return expense;
            }
        }
        return null;
    }


}
