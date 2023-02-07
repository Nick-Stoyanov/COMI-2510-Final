package test.util;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Assignment details from the assignment.xml file
 * Note the paths must exist, otherwise you will get a java.io.FileNotFoundException when it is run.
 * This  object will use the singleton design pattern
 * This object will read assignment.xml.
 * The property values will be output with the test calculation results.
 * <p>
 * 2/5/2023
 *
 * @author Nick Stoyanov
 */
public class AssignmentDetails
{
    /**
     * This is the primary input file name
     */
    private static String INPUT_FILE_NAME = "src/main/resources/resources/lesson.04.assignment/assignment.xml";

    /**
     * Get instance of the logger
     */
    private static final Logger logger = LogManager.getLogger(AssignmentDetails.class.getName());

    /**
     * Properties file
     */
    private static Properties properties = null;

    /**
     * Constructor
     */
    public AssignmentDetails()
    {
        super();
    }

    /**
     * Get properties
     *
     * @return the properties
     */
    private static Properties getProperties()
    {
        return AssignmentDetails.properties;
    }

    /**
     * Returns the value for the named property
     *
     * @param name the name of the property
     * @return the value of the property
     */
    public static String getProperty(String name)
    {
        AssignmentDetails.loadProperties(INPUT_FILE_NAME);
        String propValue = AssignmentDetails.getProperties().getProperty(name);
        logger.debug("Property name: " + name + "\nProperty value: " + propValue);
        return propValue;
    }

    /**
     * Returns the value for the named property appended to the provided prefixValue
     *
     * @param prefixValue the prefix value
     * @param nameSuffix  the name of the suffix property
     * @return the value for the named property appended ot the prefix value
     */
    public static String getPropertyAppend(String prefixValue,
                                           String nameSuffix)
    {
        String str = TotalExpenseConstants.getProperty(nameSuffix);
        StringBuilder prop = new StringBuilder();
        prop.append(prefixValue);
        prop.append(str);
        logger.debug("getPropertyAppend()" + "\nvalue= " + prefixValue + "\nname= " + nameSuffix + "\nprop= " + prop.toString());
        return prop.toString();

    }

    /**
     * Returns the value for the two named property appended to each other
     *
     * @param namePrefix the name of the prefix property
     * @param nameSuffix the name of the suffix property
     * @return the value for the named property appended to the prefixValue
     */
    public static String getPropertyConcat(String namePrefix,
                                           String nameSuffix)
    {
        StringBuilder prop = new StringBuilder();
        prop.append(TotalExpenseConstants.getProperty(namePrefix));
        prop.append(TotalExpenseConstants.getProperty(nameSuffix));
        logger.debug("getPropertyConcat()" + "\nnamePrefix" + namePrefix + "\nnameSuffix" + nameSuffix + "prop= " + prop.toString());
        return prop.toString();
    }

    /**
     * NOT NEEDED, hence the null return value
     * <p>
     * Returns the value for the named property appended to the provided prefixValue
     *
     * @param suffixValue the suffix value
     * @param namePrefix  the name of the prefix property
     * @return the value for the named property appended to the prefixValue
     */
    public static String getPropertyPrepend(String suffixValue,
                                            String namePrefix)
    {
        return null;
    }

    /**
     * Loads the properties from the text file. This must be called to initialize the properties!
     *
     * @param fullyQualifiedInputPath input path
     */
    public static synchronized void loadProperties(String fullyQualifiedInputPath)
    {
        if (AssignmentDetails.getProperties() == null)
        {
            try (InputStream input = new FileInputStream(INPUT_FILE_NAME))
            {
                AssignmentDetails.getProperties().loadFromXML(input);

            } catch (IOException e)
            {
                e.printStackTrace();
                logger.debug(fullyQualifiedInputPath + " is not a valid path.");
                logger.debug(ExceptionUtils.getStackTrace(e));
            }
        }
    }


}

