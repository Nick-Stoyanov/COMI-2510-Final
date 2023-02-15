package test.util;

/**
 * Total expense test utility
 * <p>
 * 2/5/2023
 *
 * @author Nick Stoyanov
 */
public class TotalExpenseTestUtility
{
    /**
     * This is the fully qualified input file name (e.g. src/main/resources/resources/lesson04.assignment/in).
     * It will not be hard coded. It will be passed as one of the command
     * line arguments to the main program. This is being done, so that there are no hard
     * coded paths in the program!
     */
    private String fullyQualifiedInputPath = "src/main/resources/resources/lesson04/assignment/in";

    /**
     * Constructor
     */
    public TotalExpenseTestUtility()
    {
        super();
        TotalExpenseTestData totalExpenseTestData = new TotalExpenseTestData();
    }

    /**
     * Get the fully input qualified path (e.g. src/main/resources/lesson04/assignment/in/)
     *
     * @return the fully qualified path
     */
    public String getFullyQualifiedInputPath()
    {
        return fullyQualifiedInputPath;
    }

    /**
     * Set the fully input qualified path (e.g. src/main/resources/lesson04/assignment/in/)
     *
     * @param fullyQualifiedInputPath the fullyInputQualifiedPath to set
     */
    public void setFullyQualifiedInputPath(String fullyQualifiedInputPath)
    {
        this.fullyQualifiedInputPath = fullyQualifiedInputPath;
    }

    /**
     * Gets the assignment details from the property file
     *
     * @return the assignment details
     */
    public String getAssignmentDetails()
    {
        StringBuilder assDeets = new StringBuilder();

        assDeets.append(AssignmentDetails.getProperty("path"));
        assDeets.append("\n");

        assDeets.append(AssignmentDetails.getProperty("assignment"));
        assDeets.append("\n");

        assDeets.append(AssignmentDetails.getProperty("name"));
        assDeets.append("\n");

        assDeets.append(AssignmentDetails.getProperty("student.id"));
        assDeets.append("\n");

        assDeets.append(AssignmentDetails.getProperty("email"));
        assDeets.append("\n");

        assDeets.append(AssignmentDetails.getProperty("date"));
        assDeets.append("\n");

        return assDeets.toString();




        /*
        assDeets.append(AssignmentDetails.getProperty("resource.path"));
        assDeets.append("\n");

        assDeets.append(AssignmentDetails.getProperty("resource.path.input"));
        assDeets.append("\n");

        assDeets.append(AssignmentDetails.getProperty("resource.path.output"));
        assDeets.append("\n");

        assDeets.append(AssignmentDetails.getProperty("excel.input.filename"));
        assDeets.append("\n");

        assDeets.append(AssignmentDetails.getProperty("excel.output.filename.prefix"));
        assDeets.append("\n");

        assDeets.append(AssignmentDetails.getProperty("excel.output.filename.suffix"));
        assDeets.append("\n");

        assDeets.append(AssignmentDetails.getProperty("xml.output.filename.prefix"));
        assDeets.append("\n");

        assDeets.append(AssignmentDetails.getProperty("xml.output.filename.suffix"));
        assDeets.append("\n");

        assDeets.append(AssignmentDetails.getProperty("xml.input.filename.automobile.expenses"));
        assDeets.append("\n");

        assDeets.append(AssignmentDetails.getProperty("xml.input.filename.automobile"));
        assDeets.append("\n");

        assDeets.append(AssignmentDetails.getProperty("xml.input.filename.sales.trip"));
        assDeets.append("\n");

        assDeets.append(AssignmentDetails.getProperty("xml.input.filename.travel.entertainment"));
        assDeets.append("\n");

        assDeets.append(AssignmentDetails.getProperty("worksheet.name.excel"));
        assDeets.append("\n");

        assDeets.append(AssignmentDetails.getProperty("worksheet.name.xml="));
        assDeets.append("\n");

        assDeets.append(AssignmentDetails.getProperty("worksheet.name.fixed"));
        assDeets.append("\n");
        */

    }

    /**
     * Glorious handling the command line arguments
     *
     * @param args the command line arguments
     * @return the command line arguments handled gloriously
     */
    public String gloriousArgs(String[] args)
    {
        StringBuilder sb = new StringBuilder();

        if (args.length == 0)
        {
            sb.append("Whomp,whomp. No Args.");
        } else
        {
            sb.append("All hail our Glorious leader ");
            for (String str : args)
            {
                sb.append(str);
                sb.append(" ");
            }
        }
        sb.append(".");
        return sb.toString();

    }
}
