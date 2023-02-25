package test.util;

import edu.ccri.lesson02.assignment.dashboard.Automobile;
import edu.ccri.lesson02.assignment.expense.Expense;
import edu.ccri.lesson02.assignment.expense.ExpenseHelper;
import edu.ccri.lesson02.assignment.expense.TotalExpense;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import test.data.broker.AutomobileBroker;
import test.data.broker.AutomobileExpenseBroker;
import test.data.broker.SalesTripBroker;
import test.data.broker.TravelEntertainmentExpenseBroker;
import test.data.helper.AutomobileExpenseHelper;
import test.data.helper.SalesTripHelper;
import test.data.helper.TravelEntertainmentExpenseHelper;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Total expense test calculations
 * <p>
 * 2/5/2023
 *
 * @author Nick Stoyanov
 */
public class TotalExpenseTestCalculations
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(TotalExpenseTestCalculations.class.getName());

    /**
     * Automobile expense test data
     */
    private AutomobileExpenseBroker automobileExpenseTestData;

    /**
     * Automobile test data
     */
    private AutomobileBroker automobileTestData;

    /**
     * Unique key object
     */
    private int key;

    /**
     * Sales trip test data
     */
    private SalesTripBroker salesTripTestData;

    /**
     * total cost list
     */
    private ArrayList<TotalExpense> totalCostList;

    /**
     * Travel and entertainment expense test data
     */
    private TravelEntertainmentExpenseBroker travelEntertainmentExpenseTestData;


    /**
     * Constructor
     */
    public TotalExpenseTestCalculations()
    {
        super();
    }

    /**
     * Calculates the grand totals of the expenses
     *
     * @return the grand totals of the expenses
     */
    public TotalExpense calculateGrandTotals()
    {
        TotalExpense total = null;
        TotalExpense grandTotal = new TotalExpense("Grand total");
        Iterator<TotalExpense> iterator = totalCostList.iterator();

        while (iterator.hasNext())
        {
            total = iterator.next();

            grandTotal.addPurchasePrice(total.getPurchasePrice());
            grandTotal.addFoodCost(total.getFoodCost());
            grandTotal.addFourTires(total.getFourTires());
            grandTotal.addFuelCost(total.getFuelCost());
            grandTotal.addHotelCost(total.getHotelCost());
            grandTotal.addOilChange(total.getOilChange());
        }
        return grandTotal;
    }

    /**
     * Calculate the expense totals
     *
     * @return the expense totals
     */
    public ArrayList<TotalExpense> calculateTotals()
    {
        double price = 0;
        TotalExpense total = null;
        Expense expense = null;

        ArrayList<TotalExpense> totalExpenseList = new ArrayList<>();
        Iterator<Automobile> iterator = this.getAutomobileTestData().getTestDataList().iterator();

        Automobile car = null;
        double totalTripDistance = SalesTripHelper.getTotalSalesTripDistance(this.salesTripTestData.getTestDataList());
        double totalTripDuration = SalesTripHelper.getTotalSalesTripDuration(this.salesTripTestData.getTestDataList());

        logger.debug("totalTripDistance = " + totalTripDistance + "\ntotalTripDuration = " + totalTripDuration);

        while (iterator.hasNext())
        {
            final int maxTravelHours = 8;
            double cost = 0;
            car = iterator.next();
            total = new TotalExpense(car.getName());


            expense = AutomobileExpenseHelper.getPurchasePriceExpense(this.getAutomobileExpenseTestData().getTestDataList(), car.getName());
            total.addPurchasePrice(expense.getExpense());

            expense = AutomobileExpenseHelper.getFuelExpense(this.getAutomobileExpenseTestData().getTestDataList(), car.getName());
            price = ExpenseHelper.getFuelCosts(totalTripDistance, car.getMpg(), expense.getExpense());
            total.addFuelCost(price);

            expense = AutomobileExpenseHelper.getOilExpense(this.getAutomobileExpenseTestData().getTestDataList(), car.getName());
            price = ExpenseHelper.getOilCosts(totalTripDistance, car.getOilGauge().getMaximumAmount(), expense.getExpense());
            total.addOilChange(price);

            expense = AutomobileExpenseHelper.getTireExpense(this.getAutomobileExpenseTestData().getTestDataList(), car.getName());
            price = ExpenseHelper.getTireCosts(totalTripDistance, car.getTireGauge().getMaximumAmount(), expense.getExpense());
            total.addFourTires(price);

            expense = TravelEntertainmentExpenseHelper.getFoodExpense(travelEntertainmentExpenseTestData.getTestDataList(), car.getName());
            price = ExpenseHelper.getFoodCosts(totalTripDuration, maxTravelHours, expense.getExpense());
            total.addFoodCost(price);

            expense = TravelEntertainmentExpenseHelper.getHotelExpense(travelEntertainmentExpenseTestData.getTestDataList(), car.getName());
            price = ExpenseHelper.getHotelCosts(totalTripDuration, maxTravelHours, expense.getExpense());
            total.addHotelCost(price);

            totalExpenseList.add(total);

        }

        return totalExpenseList;
    }


    /**
     * Get automobile expense test data
     *
     * @return automobile expense test data
     */
    public AutomobileExpenseBroker getAutomobileExpenseTestData()
    {
        return automobileExpenseTestData;
    }

    /**
     * Set Automobile expense test data
     *
     * @param automobileExpenseTestData the data to set
     */
    public void setAutomobileExpenseTestData(AutomobileExpenseBroker automobileExpenseTestData)
    {
        this.automobileExpenseTestData = automobileExpenseTestData;
    }

    /**
     * Get Automobile test data
     *
     * @return Automobile test data
     */
    public AutomobileBroker getAutomobileTestData()
    {
        return automobileTestData;
    }

    /**
     * Set Automobile test data
     *
     * @param automobileTestData the data to set
     */
    public void setAutomobileTestData(AutomobileBroker automobileTestData)
    {
        this.automobileTestData = automobileTestData;
    }

    /**
     * Get key
     *
     * @return key
     */
    public int getKey()
    {
        return key;
    }

    /**
     * Set ket
     *
     * @param key key to set
     */
    public void setKey(int key)
    {
        this.key = key;
    }

    /**
     * Get Sales trip test data
     *
     * @return Sales trip test data
     */
    public SalesTripBroker getSalesTripTestData()
    {
        return salesTripTestData;
    }

    /**
     * Set sales trip test data
     *
     * @param salesTripTestData the data to set
     */
    public void setSalesTripTestData(SalesTripBroker salesTripTestData)
    {
        this.salesTripTestData = salesTripTestData;
    }

    /**
     * Get total cost list
     *
     * @return total cost list
     */
    public ArrayList<TotalExpense> getTotalCostList()
    {
        return totalCostList;
    }

    /**
     * Set the total cost list
     *
     * @param totalCostList the list to set
     */
    public void setTotalCostList(ArrayList<TotalExpense> totalCostList)
    {
        this.totalCostList = totalCostList;
    }

    /**
     * Get travel and entertainment expense test data
     *
     * @return travel and entertainment expense test data
     */
    public TravelEntertainmentExpenseBroker getTravelEntertainmentExpenseTestData()
    {
        return travelEntertainmentExpenseTestData;
    }

    /**
     * set travel and entertainment expense test data
     *
     * @param travelEntertainmentExpenseTestData the data to set
     */
    public void setTravelEntertainmentExpenseTestData(TravelEntertainmentExpenseBroker travelEntertainmentExpenseTestData)
    {
        this.travelEntertainmentExpenseTestData = travelEntertainmentExpenseTestData;
    }

    /**
     * Returns a string representation of the object
     *
     * @return a string representation of the object
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("TotalExpenseTestCalculations");
        sb.append("\nautomobileExpenseTestData=" + automobileExpenseTestData);
        sb.append("\nautomobileTestData=" + automobileTestData);
        sb.append("\nkey=" + key);
        sb.append("\nsalesTripTestData=" + salesTripTestData);
        sb.append("\ntotalCostList=" + totalCostList);
        sb.append("\ntravelEntertainmentExpenseTestData=" + travelEntertainmentExpenseTestData);
        return sb.toString();
    }
}
