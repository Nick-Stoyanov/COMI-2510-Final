/**
 * Travel and entertainment expense
 */
package edu.ccri.lesson02.assignment.expense;

/**
 * Travel and entertainment expense
 *
 * @author dean grammas
 */
public class TravelEntertainmentExpense
{
    /**
     * Food expense
     */
    private FoodExpense foodExpense;
    
    /**
     * Hotel expense
     */
    private HotelExpense hotelExpense;
    
    /**
     * Constructor <BR>
     * <UL>
     * <LI>Creates the hotel expense, populates it and adds it to the list
     * <LI>Creates the food expense, populates it and adds it to the list
     * </UL>
     * <BR>
     *
     * @param name         the name of the expense
     * @param hotelExpense the amount of the hotel expense
     * @param foodExpense  the amount of the food expense
     */
    public TravelEntertainmentExpense(String name, double hotelExpense, double foodExpense)
    {
	super();
	this.setHotel(new HotelExpense(name, hotelExpense));
	this.setFood(new FoodExpense(name, foodExpense));
    }
    
    /**
     * Returns the <code>FoodExpense</code>
     *
     * @return the foodExpense
     */
    public FoodExpense getFood()
    {
	return foodExpense;
    }
    
    /**
     * The amount of the food expense
     *
     * @return the amount of the food expense
     */
    public double getFoodExpense()
    {
	return this.getFood().getExpense();
    }
    
    /**
     * Returns the <code>HotelExpense</code>
     *
     * @return the hotelExpense
     */
    public HotelExpense getHotel()
    {
	return this.hotelExpense;
    }
    
    /**
     * The amount of the hotel expense
     *
     * @return the amount of the hotel expense
     */
    public double getHotelExpense()
    {
	return this.getHotel().getExpense();
    }
    
    /**
     * Sets the <code>FoodExpense</code>
     *
     * @param foodExpense the <code>FoodExpense</code> to set
     */
    public void setFood(FoodExpense foodExpense)
    {
	this.foodExpense = foodExpense;
    }
    
    /**
     * Sets the <code>HotelExpense</code>
     *
     * @param hotelExpense the <code>HotelExpense</code> to set
     */
    public void setHotel(HotelExpense hotelExpense)
    {
	this.hotelExpense = hotelExpense;
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
	sb.append(" this.getHotel()=").append(this.getHotel().toString()).append("\n");
	sb.append(" this.getFood()=").append(this.getFood().toString()).append("\n");
	
	return sb.toString();
    }
}
