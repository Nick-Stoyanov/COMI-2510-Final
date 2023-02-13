package test;

import test.util.AssignmentDetails;
import test.util.TotalExpenseTestData;
import test.util.TotalExpenseTestUtility;

/**
 * Total expense test. This is a very simiple test class.
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
     * @param totalExpenseTestData data to set
     */
    public static void setTotalExpenseTestData(TotalExpenseTestData totalExpenseTestData)
    {
        TotalExpenseTest.totalExpenseTestData = totalExpenseTestData;
    }

    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        TotalExpenseTestUtility totalExpenseTestUtility = new TotalExpenseTestUtility();

        totalExpenseTestUtility.gloriousArgs(args);
        sb.append(args);

        AssignmentDetails assignmentDetails = new AssignmentDetails();
        assignmentDetails.loadProperties(totalExpenseTestUtility.getFullyQualifiedInputPath());
        sb.append("fully qualified path: " + totalExpenseTestUtility.getFullyQualifiedInputPath());

        totalExpenseTestUtility.getAssignmentDetails();
        sb.append(totalExpenseTestUtility.getAssignmentDetails());

        TotalExpenseTestData testData = new TotalExpenseTestData();




    }
}
