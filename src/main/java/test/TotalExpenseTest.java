package test;

import test.util.AssignmentDetails;
import test.util.TestDataType;
import test.util.TotalExpenseTestData;
import test.util.TotalExpenseTestUtility;

import javax.swing.*;

/**
 * Total expense test. This is a very simple test class.
 * It is possible (and very easy) to test all of this code via Junit without this test class.
 * <p>
 * 2/7/2023
 *
 * @author Nick Stoyanov
 */
public class TotalExpenseTest
{
    /**
     * Total expense test data
     */
    private static TotalExpenseTestData totalExpenseTestData;

    /**
     * Constructor
     */
    public TotalExpenseTest()
    {
        super();
    }

    /**
     * Get the total expense test data
     *
     * @return the total expense test data
     */
    public static TotalExpenseTestData getTotalExpenseTestData()
    {
        return totalExpenseTestData;
    }

    /**
     * Set total expense test data
     *
     * @param totalExpenseTestData data to set
     */
    public static void setTotalExpenseTestData(TotalExpenseTestData totalExpenseTestData)
    {
        TotalExpenseTest.totalExpenseTestData = totalExpenseTestData;
    }

    /**
     * Main method
     *
     * @param args arguments
     */
    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        TotalExpenseTestUtility totalExpenseTestUtility = new TotalExpenseTestUtility();

        totalExpenseTestUtility.gloriousArgs(args);
        sb.append("Args passed:" + totalExpenseTestUtility.gloriousArgs(args));

        AssignmentDetails assignmentDetails = new AssignmentDetails();
        assignmentDetails.loadProperties(totalExpenseTestUtility.getFullyQualifiedInputPath());
        sb.append("fully qualified path: " + totalExpenseTestUtility.getFullyQualifiedInputPath());

        totalExpenseTestUtility.getAssignmentDetails();
        sb.append(totalExpenseTestUtility.getAssignmentDetails());

        TotalExpenseTestData testData = new TotalExpenseTestData();

        testData.stageData(TestDataType.FIXED);
        setTotalExpenseTestData(testData);
        sb.append("Fixed data: \n" + testData.stageData(TestDataType.FIXED));
        //totalExpenseTestData.writeFiles();
        JOptionPane.showMessageDialog(null, "Fixed data\n" + testData.stageData(TestDataType.FIXED));
        //sb.setLength(0);

        testData.stageData(TestDataType.EXCEL);
        setTotalExpenseTestData(testData);
        sb.append("Excel data: \n" + testData.stageData(TestDataType.EXCEL));
        //totalExpenseTestData.writeFiles();

        JOptionPane.showMessageDialog(null, "Excel data\n" + testData.stageData(TestDataType.EXCEL));

        testData.stageData(TestDataType.XML);
        setTotalExpenseTestData(testData);
        sb.append("XML data: \n" + testData.stageData(TestDataType.XML));

        JOptionPane.showMessageDialog(null, "XML data: \n" + testData.stageData(TestDataType.XML));


    }
}
