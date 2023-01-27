/**
 * The data list that results from reading an excel file
 */
package edu.ccri.lesson02.assignment.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * The data list that results from reading an excel file. When using POI you will read one cell at a time from the excel worksheet. The result will be
 * a list of lists. With the outer list represeting the rows and the inner list represeting the columns.<BR>
 * <BR>
 * For example, consider the following as representative of the excell sheet. With each letter (e.g. A, B, C) being a single cell. <BR>
 * <UL>
 * <LI>A B
 * <LI>C D
 * <LI>E F
 * </UL>
 * 
 * <BR>
 * Then the list will be something like this... <BR>
 * <UL>
 * <LI>Row 0 which is a list that contains A &amp; B
 * <LI>Row 1 which is a list that contains C &amp; D
 * <LI>Row 2 which is a list that contains E &amp; F
 * </UL>
 * <BR>
 *
 * 
 * @author dean grammas
 */
public class PoiReadDataList
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(PoiReadDataList.class.getName());
    
    /**
     * The maximum number of columns <BR>
     * For the following table <BR>
     * <UL>
     * <LI>A B
     * <LI>C D
     * <LI>E F
     * </UL>
     * <BR>
     * <BR>
     * Then the max coluns would be 2
     *
     */
    private int maxColumns;
    
    /**
     * The maximum number of rows <BR>
     * For the following table <BR>
     * <UL>
     * <LI>A B
     * <LI>C D
     * <LI>E F
     * </UL>
     * <BR>
     * <BR>
     * Then the max rows would be 3
     */
    private int maxRows;
    
    /**
     * The data list. This is a list of lists. The inner list is a list of poi data objects, which represent the cells in each column. The outer list is
     * the list of rows.
     */
    private ArrayList<ArrayList<PoiData>> testDataList;
    
    /**
     * Constructor to read the data from excel <BR>
     * <BR>
     * <UL>
     * <LI>Create the test data list (list of lists)
     * <LI>Get the excel data
     * </UL>
     * <BR>
     *
     * @param fileName  the file name
     * @param worksheet the worksheet number
     */
    public PoiReadDataList(String fileName, int worksheet)
    {
	super();
	this.setTestDataList(new ArrayList<ArrayList<PoiData>>());
	getExcelData(fileName, worksheet);
    }
    
    /**
     * This is an overloaded method that adds the poi data value to the list <BR>
     * <BR>
     * <UL>
     * <LI>Create the populated poi data object
     * <LI>Add the poi data object the row
     * </UL>
     * <BR>
     *
     * @param rowDataList the to add to
     * @param row         the row number
     * @param col         the column number
     * @param cellValue   the cell value
     */
    private void addCellData(ArrayList<PoiData> rowDataList, int row, int col, double cellValue)
    {
	PoiData poiData = new PoiData(row, col, cellValue);
	rowDataList.add(poiData);
    }
    
    /**
     * This is an overloaded method that adds the poi data value to the list <BR>
     * <BR>
     * <UL>
     * <LI>Create the populated poi data object
     * <LI>Add the poi data object the row
     * </UL>
     * <BR>
     *
     * @param rowDataList the to add to
     * @param row         the row number
     * @param col         the column number
     * @param cellValue   the cell value
     */
    private void addCellData(ArrayList<PoiData> rowDataList, int row, int col, String cellValue)
    {
	PoiData poiData = new PoiData(row, col, cellValue);
	rowDataList.add(poiData);
    }
    
    /**
     * Reads the excel file and adds the result to the data list. This arguabley the most complex method in this class. <BR>
     * <BR>
     * <UL>
     * <LI>Get the input file
     * <LI>Open the excel workbook
     * <LI>Get the worksheet using the worksheet number
     * <LI>Loop for the rows (e.g. 3 rows)
     * <LI>Loop for the columns in each row (e.g. 2 cols)
     * <LI>Read each cell in the column for the row, incrementing the column number and adding them to the list of poi data objects in each row (e.g. 2
     * poi data objects)
     * <LI>Once all the columns for the row have been read, add the list of poi data objects to the outer (row) list, increment the row numbers and loop
     * again until all of the rows have been read.
     *
     * </UL>
     * <BR>
     *
     *
     * @param fileName  the file name
     * @param worksheet the worksheet number
     */
    private void getExcelData(String fileName, int worksheet)
    {
	int row = 0;
	int col = 0;
	
	try
	{
	    ArrayList<PoiData> rowDataList = null;
	    
	    FileInputStream excelFile = new FileInputStream(new File(fileName));
	    @SuppressWarnings("resource")
	    Workbook workbook = new XSSFWorkbook(excelFile);
	    
	    // worksheets are numbered starting at 0
	    Sheet datatypeSheet = workbook.getSheetAt(worksheet);
	    
	    // loop for the rows
	    for (Row currentRow : datatypeSheet)
	    {
		rowDataList = new ArrayList<>();
		
		logger.debug("--Row Begin--");
		for (Cell currentCell : currentRow)
		{
		    if (currentCell.getCellType() == CellType.STRING)
		    {
			logger.debug("\tCellType.STRING=" + currentCell.getStringCellValue());
			addCellData(rowDataList, row, col, currentCell.getStringCellValue());
		    } else if (currentCell.getCellType() == CellType.NUMERIC)
		    {
			logger.debug("\tCellType.NUMERIC=" + currentCell.getNumericCellValue());
			addCellData(rowDataList, row, col, currentCell.getNumericCellValue());
			
		    } else
		    {
			logger.error("\tCellType._NONE=");
			throw new Exception("\tCellType._NONE=");
		    }
		    
		    col++;
		    
		} // end while for cols
		logger.debug("--Row End--");
		
		// add the row of data to the list
		this.getTestDataList().add(rowDataList);
		
		// increment the number of rows and save it so that the row zero becomes row one
		row++;
		this.setMaxRows(row);
		
		// save the number of columns then incrment it so that the last column is set as the max then reset to
		// zero for the next loop
		this.setMaxColumns(col);
		col = 0;
		
	    } // end while for rows
	} catch (FileNotFoundException e)
	{
	    e.printStackTrace();
	    logger.error(ExceptionUtils.getStackTrace(e));
	} catch (IOException e)
	{
	    e.printStackTrace();
	    logger.error(ExceptionUtils.getStackTrace(e));
	} catch (Exception e)
	{
	    e.printStackTrace();
	    logger.error(ExceptionUtils.getStackTrace(e));
	}
    }
    
    /**
     * Returns the maximum number of columns <BR>
     * For the following table <BR>
     * <UL>
     * <LI>A B
     * <LI>C D
     * <LI>E F
     * </UL>
     * <BR>
     * <BR>
     * Then the max coluns would be 2
     *
     *
     * @return the maxColumns
     */
    public int getMaxColumns()
    {
	return maxColumns;
    }
    
    /**
     * Returns the maximum number of rows The maximum number of rows <BR>
     * For the following table <BR>
     * <UL>
     * <LI>A B
     * <LI>C D
     * <LI>E F
     * </UL>
     * <BR>
     * <BR>
     * Then the max rows would be 3
     *
     * @return the maxRows
     */
    public int getMaxRows()
    {
	return maxRows;
    }
    
    /**
     * Returns the data list that results from reading an excel file
     *
     * @return the testDataList
     */
    public ArrayList<ArrayList<PoiData>> getTestDataList()
    {
	return testDataList;
    }
    
    /**
     * This method will transpose the in the list so that the rows become the columns and the columns become the rows. For example when transposed: <BR>
     * <BR>
     * A B C <BR>
     * E F G <BR>
     * will become: <BR>
     * A E <BR>
     * B F <BR>
     * C G <BR>
     * <BR>
     * Use what you know about the list (maximum number of rows and columns) and the cell location (row, col) in each poi data object to transpose the
     * list. For example if there are 2 columns and 3 columns when you transpose the data, there will be 3 row and 2 columns. Therefore, all poi data
     * objects in column 0 will be poi data objects in row 0. Likewise, all of the data in column 1 will be poi data objects in row 1.
     *
     *
     * @return the testDataList the transposed data list
     */
    public ArrayList<ArrayList<PoiData>> getTransposedTestDataList()
    {
	ArrayList<ArrayList<PoiData>> transposedTestDataList = new ArrayList<>();
	ArrayList<PoiData> transposedRowDataList = null;
	
	ArrayList<PoiData> rowDataList = null;
	PoiData poiData = null;
	
	// based on the number of columns, add that same number of rows to the transposed list
	for (int k = 0; k < this.getMaxColumns(); k++)
	{
	    transposedTestDataList.add(new ArrayList<PoiData>());
	}
	
	/**
	 * this test data list is a list of lists in order to transpose the data, we need to make the current columns the rows and the rows into the columns
	 */
	int j = 0;
	for (int k = 0; k < this.getMaxColumns(); k++)
	{
	    // get the transposed row
	    transposedRowDataList = transposedTestDataList.get(k);
	    
	    // loop for the original rows
	    for (int i = 0; i < (this.getTestDataList().size()); i++)
	    {
		// get the row data
		rowDataList = this.getTestDataList().get(i);
		
		// get the current ordinal (j) in the row and add it the transposed row.
		poiData = rowDataList.get(j);
		transposedRowDataList.add(poiData);
	    }
	    j++;
	}
	return transposedTestDataList;
    }
    
    /**
     * Sets the maximum number of columns Returns the maximum number of columns <BR>
     * For the following table <BR>
     * <UL>
     * <LI>A B
     * <LI>C D
     * <LI>E F
     * </UL>
     * <BR>
     * <BR>
     * Then the max coluns would be 2
     *
     *
     * @param maxColumns the maxColumns to set
     */
    private void setMaxColumns(int maxColumns)
    {
	this.maxColumns = maxColumns;
    }
    
    /**
     * Sets the maximum number of rows The maximum number of rows <BR>
     * For the following table <BR>
     * <UL>
     * <LI>A B
     * <LI>C D
     * <LI>E F
     * </UL>
     * <BR>
     * <BR>
     * Then the max rows would be 3
     *
     * @param maxRows the maxRows to set
     */
    private void setMaxRows(int maxRows)
    {
	this.maxRows = maxRows;
    }
    
    /**
     * Sets the data list that results from reading an excel file
     *
     * @param testDataList the testDataList to set
     */
    private void setTestDataList(ArrayList<ArrayList<PoiData>> testDataList)
    {
	this.testDataList = testDataList;
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
	sb.append(" this.getMaxRows()= ").append(this.getMaxRows());
	sb.append(" this.getMaxColumns()= ").append(this.getMaxColumns());
	sb.append(" this.getPoiDataList()= ").append(this.getTestDataList().toString());
	return (sb.toString());
    }
}
