/**
 * POI Data
 */
package edu.ccri.lesson02.assignment.poi;

/**
 * POI Data object. This represents one cell in the excel worksheet. If there are 2 columsn and 3 rows, then there will be 6 POI data objects in the
 * list. <BR>
 * For example, consider the following as representative of the excell sheet. With each letter (e.g. A, B, C) being a single cell. <BR>
 * <UL>
 * <LI>A B
 * <LI>C D
 * <LI>E F
 * </UL>
 * <BR>
 * Then the POI data objects would look something like... <BR>
 * <UL>
 * <LI>value=A, row=0, col=0
 * <LI>value=B, row=0, col=1
 * <LI>value=C, row=1, col=0
 * <LI>value=D, row=1, col=1
 * </UL>
 *
 *
 * @author dean grammas
 */
public class PoiData
{
    /**
     * The column number
     */
    private int columnNumber;
    
    /**
     * The row number
     */
    private int rowNumber;
    /**
     * The object value
     */
    private Object value;

    /**
     * Constructor
     *
     * @param cellDouble - cell as a double
     */
    public PoiData(double cellDouble)
    {
	this.setValue(cellDouble);
    }
   
    /**
     * Constructor <BR>
     * <UL>
     * <LI>sets the row number
     * <LI>sets the column number
     * <LI>sets the value
     * </UL>
     * <BR>
     *
     * @param RowNumber    - row number
     * @param columnNumber - column number
     * @param cellDouble   - cell as a int
     */
    public PoiData(int RowNumber, int columnNumber, double cellDouble)
    {
	this.setRowNumber(RowNumber);
	this.setColumnNumber(columnNumber);
	this.setValue(cellDouble);
    }
    
    /**
     * Constructor <BR>
     * <UL>
     * <LI>sets the row number
     * <LI>sets the column number
     * <LI>sets the value
     * </UL>
     * <BR>
     *
     * @param RowNumber    - row number
     * @param columnNumber - column number
     * @param cellString   - cell as a string
     */
    public PoiData(int RowNumber, int columnNumber, String cellString)
    {
	this.setRowNumber(RowNumber);
	this.setColumnNumber(columnNumber);
	this.setValue(cellString);
    }
    
    /**
     * Constructor
     *
     * @param cellString - cell as a string
     */
    public PoiData(String cellString)
    {
	this.setValue(cellString);
    }
    
    /**
     * Gets the column number
     *
     * @return the columnNumber
     */
    public int getColumnNumber()
    {
	return this.columnNumber;
    }
    
    /**
     * Gets the row number
     *
     * @return the rowNumber
     */
    public int getRowNumber()
    {
	return this.rowNumber;
    }
    
    /**
     * Get value
     *
     * @return the value
     */
    public Object getValue()
    {
	return value;
    }
    
    /**
     * Sets the column number
     *
     * @param columnNumber the columnNumber to set
     */
    public void setColumnNumber(int columnNumber)
    {
	this.columnNumber = columnNumber;
    }
    
    /**
     * Sets the row number
     *
     * @param rowNumber the rowNumber to set
     */
    public void setRowNumber(int rowNumber)
    {
	this.rowNumber = rowNumber;
    }
    
    /**
     * Set value
     *
     * @param value the value to set
     */
    protected void setValue(Object value)
    {
	this.value = value;
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
	sb.append(" this.getRowNumber()= ").append(this.getRowNumber());
	sb.append(" this.getColumnNumber()= ").append(this.getColumnNumber());
	sb.append(" this.getValue()= ").append(this.getValue());
	return (sb.toString());
    }
}
