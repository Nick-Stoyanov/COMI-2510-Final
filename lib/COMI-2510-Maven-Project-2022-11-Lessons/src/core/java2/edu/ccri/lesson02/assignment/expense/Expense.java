/**
 * Abstract reepresentation of an expense
 */
package edu.ccri.lesson02.assignment.expense;

import edu.ccri.lesson02.assignment.common.UniqueKeyCounter;

/**
 * Abstract reepresentation of an expense
 *
 * @author dean grammas
 */
public abstract class Expense extends UniqueKeyCounter
{
    /**
     * The expense amount
     */
    private double expense;
    
    /**
     * Unique object key
     */
    private int key;
    
    /**
     * Name of the expense
     */
    private String name;
    
    /**
     * Constructor <BR>
     * <UL>
     * <LI>The unique key will be set
     * <LI>The name will be set
     * <LI>The expense will be set
     * </UL>
     * <BR>
     *
     * @param name    the name of the expense
     * @param expense the expense
     */
    public Expense(String name, double expense)
    {
	super();
	this.setKey(UniqueKeyCounter.getInternalCounter());
	
	this.setName(name);
	this.setExpense(expense);
    }
    
    /**
     * Returns the expense
     *
     * @return the expense
     */
    public double getExpense()
    {
	return this.expense;
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
     * Returns the name of the expense
     *
     * @return the name of the expense
     */
    public String getName()
    {
	return name;
    }
    
    /**
     * Sets the expense
     *
     * @param expense the expense to set
     */
    public void setExpense(double expense)
    {
	this.expense = expense;
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
     * Sets the name of the expense
     *
     * @param name of the expense
     */
    public void setName(String name)
    {
	this.name = name;
    }
    
    /**
     * Returns the object as a string
     *
     * @return the object as a string
     */
    @Override
    public String toString()
    {
	StringBuilder sb = new StringBuilder();
	
	sb.append(this.getClass());
	sb.append(" this.getKey()=").append(this.getKey()).append("\n");
	sb.append(" this.getName()=").append(this.getName()).append("\n");
	sb.append(" this.getExpense()=").append(this.getExpense()).append("\n");
	sb.append(super.toString());
	
	return sb.toString();
    }
    
}
