/**
 * Abstract class to write the data list to an excel file
 */
package edu.ccri.lesson02.assignment.poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Abstract class to write the data list to an excel file
 *
 * @author dean grammas
 */
public abstract class PoiWriteDataList
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(PoiWriteDataList.class.getName());
    
    /**
     * The workbook<BR>
     * Design decision. You can create the workbook is defined or in the constructor.
     */
    private XSSFWorkbook workbook = new XSSFWorkbook();
    
    /**
     * Default constructor<BR>
     * Design decision. You can create the workbook is defined or in the constructor.
     */
    public PoiWriteDataList()
    {
	super();
    }
    
    /**
     * Adds the data list to the worksheet. <BR>
     * <BR>
     * <UL>
     * <LI>Get the workbook and create the worksheet with the provided worksheet name
     * <LI>Loop over the rows in the data list
     * <LI>Create each worksheet row
     * <LI>Loop over the columns in each row the the data list
     * <LI>Create each cell, get each data list field and set the cell
     * <LI>Keep looping until all of the data has been written
     * </UL>
     * <BR>
     * <BR>
     * Then the max rows would be 3
     *
     *
     * @param worksheetName the name of the worksheet.
     */
    public void addWorksheet(String worksheetName)
    {
	Row row = null;
	Cell cell = null;
	ArrayList<Object> dataListRow = null;
	Object field = null;
	
	XSSFSheet sheet = this.getWorkbook().createSheet(worksheetName);
	ArrayList<ArrayList<Object>> dataList = getDataList();
	
	for (int i = 0; i < dataList.size(); i++)
	{
	    row = sheet.createRow(i);
	    
	    dataListRow = dataList.get(i);
	    for (int j = 0; j < dataListRow.size(); j++)
	    {
		cell = row.createCell(j);
		field = dataListRow.get(j);
		logger.debug("field=" + field.toString());
		
		setCell(cell, field);
	    }
	}
    }
    
    /**
     * Returns the list (rows) of lists (columns) that represent the result to be written to the worksheet<BR>
     * This format is similar to list of lists created when reading the file from excel
     *
     * @return the list (rows) of lists (columns) that represent the result to be written to the worksheet
     */
    public abstract ArrayList<ArrayList<Object>> getDataList();
    
    /**
     * Returns the fully qualified file name prefix (e.g. 'FileName')
     *
     * @return returns the file name prefix
     */
    protected abstract String getFileNamePrefix();
    
    /**
     * Returns the file name suffix (e.g. '.xlsx')
     *
     * @return returns the file name prefix
     */
    protected abstract String getFileNameSuffix();
    
    /**
     * Returns the output path of the file (e.g. 'scr\main\resources\out\')
     *
     * @return the output path of the file
     */
    protected abstract String getOutputFilePath();
    
    /**
     * Returns the workbook
     *
     * @return the workbook
     */
    private XSSFWorkbook getWorkbook()
    {
	return workbook;
    }
    
    /**
     * Initializes the <code>WritePoiData</code> object. This must be called after the constructor has been called.
     */
    public void initialize()
    {
	this.setWorkbook(new XSSFWorkbook());
    }

    /**
     * Sets the field value into the cell <BR>
     * <BR>
     * <UL>
     * <LI>Determine what the instance type is for the field being passed.
     * <LI>Excel has different methods based on what type of data is set to the cell.
     * </UL>
     * <BR>
     *
     * @param cell  the cell to update
     * @param field the field value into the cell
     */
    private void setCell(Cell cell, Object field)
    {
	if (field instanceof String)
	{
	    cell.setCellValue((String) field);
	} else if (field instanceof Integer)
	{
	    cell.setCellValue((Integer) field);
	} else if (field instanceof Double)
	{
	    cell.setCellValue((Double) field);
	} else if (field instanceof Character)
	{
	    String str = String.valueOf(field);
	    cell.setCellValue(str.charAt(0));
	} else
	{
	    logger.error("ERROR. Unable to add cell data to: cell= " + cell.toString() + " field=" + field.toString());
	}
    }
    
    /**
     * Set workbook
     * 
     * @param workbook the workbook to set
     */
    private void setWorkbook(XSSFWorkbook workbook)
    {
	this.workbook = workbook;
    }

    /**
     * True if a unique id should be added to the file name. (Helps prevent incorrectly overwriting a file.)
     *
     * @return True if a unique id should be added to the file name
     */
    protected abstract boolean useNameUnique();
    
    /**
     * Write the worksheet to the excel file. <BR>
     * Excel files are written as a stream of data <BR>
     * <UL>
     * <LI>Create a string builder to add all of the details that will be written as a stream of data
     * <LI>Get the file path, file name prefix, random UUID (optional) and the file name suffix
     * <LI>Create the file output stream
     * <LI>Write the output stream to the workbook
     * <LI>Close the workbook
     * </UL>
     * <BR>
     *
     */
    public void writeFile()
    {
	try
	{
	    StringBuilder sb = new StringBuilder();
	    sb.append(this.getOutputFilePath());
	    sb.append(this.getFileNamePrefix());
	    if (this.useNameUnique())
	    {
		sb.append(".");
		sb.append(UUID.randomUUID());
	    }
	    sb.append(this.getFileNameSuffix());
	    
	    logger.debug(sb.toString());
	    FileOutputStream outputStream = new FileOutputStream(sb.toString());
	    this.getWorkbook().write(outputStream);
	    this.getWorkbook().close();
	} catch (FileNotFoundException e)
	{
	    e.printStackTrace();
	    logger.error(ExceptionUtils.getStackTrace(e));
	} catch (IOException e)
	{
	    e.printStackTrace();
	    logger.error(ExceptionUtils.getStackTrace(e));
	}
	
    }
}
