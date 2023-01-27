/**
 * Total expense
 */
package edu.ccri.lesson02.assignment.expense;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;

/**
 * Total expense
 *
 * @author dean grammas
 */
public class TotalExpense extends UniqueKeyCounter
{
    /**
     * Total cost of food
     */
    private double foodCost;
    
    /**
     * Total wear and tear on the four tires
     */
    private double fourTires;
    
    /**
     * Total cost of fuel
     */
    private double fuelCost;
    
    /**
     * Total cost of hotel(s)
     */
    private double hotelCost;
    
    /**
     * Unique object key
     */
    private int key;
    
    /**
     * Name of the total expense
     */
    private String name;
    
    /**
     * Total cost of oil change(s)
     */
    private double oilChange;
    
    /**
     * The purchase price of the automobile
     */
    private double purchasePrice;
    
    /**
     * Constructor <BR>
     * <UL>
     * <LI>The unique key will be set
     * <LI>The name will be set
     * </UL>
     * <BR>
     *
     * @param name name of the expense
     */
    public TotalExpense(String name)
    {
	super();
	this.setKey(UniqueKeyCounter.getInternalCounter());
	this.setName(name);
    }
    
    /**
     * Add the food cost to the current total. This is an incremental add.
     *
     * @param foodCost the foodCost to add
     */
    public void addFoodCost(double foodCost)
    {
	this.setFoodCost(this.getFoodCost() + foodCost);
    }
    
    /**
     * Add the cost of four tires to the current total. This is an incremental add.
     *
     * @param fourTires the fourTires to add
     */
    public void addFourTires(double fourTires)
    {
	this.setFourTires(this.getFourTires() + fourTires);
    }
    
    /**
     * Add the cost of fuel to the current total. This is an incremental add.
     *
     * @param fuelCost the fuelCost to add
     */
    public void addFuelCost(double fuelCost)
    {
	this.setFuelCost(this.getFuelCost() + fuelCost);
    }
    
    /**
     * Add the hotel cost to the current total. This is an incremental add.
     *
     * @param hotelCost the hotelCost to add
     */
    public void addHotelCost(double hotelCost)
    {
	this.setHotelCost(this.getHotelCost() + hotelCost);
    }
    
    /**
     * Add the cost of an oil change to the current total. This is an incremental add.
     *
     * @param oilChange the oilChange to add
     */
    public void addOilChange(double oilChange)
    {
	this.setOilChange(this.getOilChange() + oilChange);
    }
    
    /**
     * Add the purchase price to the current total. This is an incremental add.
     *
     * @param purchasePrice the purchasePrice to add
     */
    public void addPurchasePrice(double purchasePrice)
    {
	this.setPurchasePrice(this.getPurchasePrice() + purchasePrice);
    }
    
    /**
     * Returns the food cost
     *
     * @return the foodCost
     */
    public double getFoodCost()
    {
	return foodCost;
    }
    
    /**
     * Returns the four tire cost
     *
     * @return the fourTires
     */
    public double getFourTires()
    {
	return fourTires;
    }
    
    /**
     * Returns the fuel cost
     *
     * @return the fuelCost
     */
    public double getFuelCost()
    {
	return fuelCost;
    }
    
    /**
     * The grand total cost of all expenses
     *
     * @return the grand total cost of all expenses
     */
    public double getGrandTotalCost()
    {
	return this.getPurchasePrice() + this.getFourTires() + this.getOilChange() + this.getFuelCost()
		+ this.getHotelCost() + this.getFoodCost();
    }
    
    /**
     * Returns the hotel cost
     *
     * @return the hotelCost
     */
    public double getHotelCost()
    {
	return hotelCost;
    }
    
    /**
     * Returns the object key
     *
     * @return the object key
     */
    @Override
    public int getKey()
    {
	return this.key;
    }
    
    /**
     * Returns the name
     *
     * @return the name
     */
    public String getName()
    {
	return name;
    }
    
    /**
     * The cost of an oil change
     *
     * @return the oilChange
     */
    public double getOilChange()
    {
	return oilChange;
    }
    
    /**
     * Returns the purchase price of an automobile
     *
     * @return the purchasePrice
     */
    public double getPurchasePrice()
    {
	return purchasePrice;
    }
    
    /**
     * Sets the food cost
     *
     * @param foodCost the foodCost to set
     */
    public void setFoodCost(double foodCost)
    {
	this.foodCost = foodCost;
    }
    
    /**
     * Sets the cost of four tires
     *
     * @param fourTires the fourTires to set
     */
    private void setFourTires(double fourTires)
    {
	this.fourTires = fourTires;
    }
    
    /**
     * Sets the fuel cost
     *
     * @param fuelCost the fuelCost to set
     */
    private void setFuelCost(double fuelCost)
    {
	this.fuelCost = fuelCost;
    }
    
    /**
     * Sets the hotel cost
     *
     * @param hotelCost the hotelCost to set
     */
    public void setHotelCost(double hotelCost)
    {
	this.hotelCost = hotelCost;
    }
    
    /**
     * Sets the object key
     */
    @Override
    protected void setKey(int key)
    {
	this.key = key;
    }
    
    /**
     * Set the name
     *
     * @param name the name to set
     */
    public void setName(String name)
    {
	this.name = name;
    }
    
    /**
     * Sets the cost of an oil change
     *
     * @param oilChange the oilChange to set
     */
    private void setOilChange(double oilChange)
    {
	this.oilChange = oilChange;
    }
    
    /**
     * Sets the purchase price of an automobile
     *
     * @param purchasePrice the purchasePrice to set
     */
    public void setPurchasePrice(double purchasePrice)
    {
	this.purchasePrice = purchasePrice;
    }
    
    /**
     * Returns a string representation of the object
     *
     * @return string representation of the object
     */
    @Override
    public String toString()
    {
	StringBuilder sb = new StringBuilder();
	
	sb.append(this.getClass());
	sb.append(" this.getName()=").append(this.getName()).append("\n");
	sb.append(" this.getPurchasePrice()=").append(this.getPurchasePrice()).append("\n");
	sb.append(" this.getFourTires()=").append(this.getFourTires()).append("\n");
	sb.append(" this.getOilChange()=").append(this.getOilChange()).append("\n");
	sb.append(" this.getFuelCost()=").append(this.getFuelCost()).append("\n");
	sb.append(" this.getHotelCost()=").append(this.getHotelCost()).append("\n");
	sb.append(" this.getFoodCost()=").append(this.getFoodCost()).append("\n");
	sb.append(" this.getGrandTotalCost()=").append(this.getGrandTotalCost()).append("\n");
	
	return sb.toString();
    }
}
