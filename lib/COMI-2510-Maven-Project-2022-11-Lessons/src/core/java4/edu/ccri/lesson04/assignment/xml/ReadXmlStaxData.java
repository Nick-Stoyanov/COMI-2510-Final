/**
 * Read XML via StaX
 */
package edu.ccri.lesson04.assignment.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.swing.text.Document;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Read XML via StaX This class assumes the xml is limited to three levels. <BR>
 * The first level is the parent node <BR>
 * The third level is the child (there could be 1 or more) <BR>
 * The fourth level are the fields (there could be 1 or more) <BR>
 * <BR>
 * The structure would look something like: <BR>
 * &gt;parent&lt; <BR>
 * &gt;child&lt; <BR>
 * &gt;field>&gt;/field&lt; <BR>
 * &gt;field>&gt;/field&lt; <BR>
 * &gt;\child&lt; <BR>
 * &gt;child&lt; <BR>
 * &gt;field&lt;&gt;/field&lt; <BR>
 * &gt;field&lt;&gt;/field&lt; <BR>
 * &gt;/child&lt; <BR>
 * &gt;/parent&lt;
 *
 * @author dean grammas
 */
public abstract class ReadXmlStaxData
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(ReadXmlStaxData.class.getName());
    
    /**
     * XML StaX results object
     */
    private XMLEventReader xmlStaxResults;
    
    /**
     * Constructor
     */
    public ReadXmlStaxData()
    {
    }
    
    /**
     * Returns the child tag name e.g. &gt;child&lt;
     *
     * @return the child name
     */
    protected abstract String getChildTagName();
    
    /**
     * Returns the file name to read
     *
     * @return the file name to read
     */
    protected abstract String getFileName();
    
    /**
     * Returns the value from the xml event reader
     *
     * @param xmlStaxResults - xml event reader
     * @return the value from the xml event reader
     */
    private String getValue(XMLEventReader xmlStaxResults)
    {
	String value = null;
	XMLEvent event = null;
	try
	{
	    event = xmlStaxResults.nextEvent();
	    value = event.asCharacters().getData();
	    
	} catch (Exception e)
	{
	    // ignore this...
	}
	return value;
    }
    
    /**
     * Returns the XML StaX results
     *
     * @return the xmlStaxResults
     */
    protected XMLEventReader getXmlStaxResults()
    {
	return xmlStaxResults;
    }
    
    /**
     * Process the end child tag name e.g. &gt;\child&lt;. When this is called all of the fields (e.g. &gt;field&lt;) between the &gt;child&lt; and
     * &gt;\child&lt; tags have been processed.
     */
    protected abstract void processEndChildTag();
    
    /**
     * Process the field tag element name (e.g. &gt;field&lt;) with the corresponding value. For example the field could be be named "number" and the
     * value could be 10. The xml would look like<BR>
     * <BR>
     * &gt;number&lt;10&gt;\number&lt;.
     *
     * @param fieldName - the field name
     * @param value     - the value
     */
    protected abstract void processFieldTag(String fieldName, String value);
    
    /**
     * This will read the xml file and parse the contents as an XML document and return a new DOM {@link Document} object.
     */
    public void readFile()
    {
	try
	{
	    // First, create a new XMLInputFactory
	    XMLInputFactory inputFactory = XMLInputFactory.newInstance();
	    
	    // Setup a new eventReader
	    InputStream in = new FileInputStream(getFileName());
	    XMLEventReader xmlStaxResults = inputFactory.createXMLEventReader(in);
	    
	    // set the XML StaX results
	    this.setXmlStaxResults(xmlStaxResults);
	    
	} catch (FileNotFoundException | XMLStreamException e)
	{
	    e.printStackTrace();
	    logger.error(ExceptionUtils.getStackTrace(e));
	}
    }
    
    /**
     * Sets the XML Stax results
     *
     * @param xmlStaxResults the xmlStaxResults to set
     */
    private void setXmlStaxResults(XMLEventReader xmlStaxResults)
    {
	this.xmlStaxResults = xmlStaxResults;
    }
    
    /**
     * Parses the XML StaX results into the results object Reads the xml file by element name
     */
    public void staxParser()
    {
	try
	{
	    String value = null;
	    
	    // get the xml event reader
	    XMLEventReader xmlStaxResults = this.getXmlStaxResults();
	    
	    // loop for all of the elements in the result list
	    while (xmlStaxResults.hasNext())
	    {
		XMLEvent event = xmlStaxResults.nextEvent();
		
		if (event.isStartElement())
		{
		    StartElement startElement = event.asStartElement();
		    // If we have an item element, we create a new item
		    String elementName = startElement.getName().getLocalPart();
		    switch (elementName)
		    {
			default:
			{
			    value = this.getValue(xmlStaxResults);
			    logger.debug("elementName=" + elementName + " value=" + value);
			    
			    processFieldTag(elementName, value);
			    break;
			}
		    }
		}
		// If we reach the end of an item element, we add it to the list
		if (event.isEndElement())
		{
		    EndElement endElement = event.asEndElement();
		    if (endElement.getName().getLocalPart().equals(getChildTagName()))
		    {
			processEndChildTag();
			
		    }
		}
	    }
	} catch (XMLStreamException e)
	{
	    e.printStackTrace();
	    logger.error(ExceptionUtils.getStackTrace(e));
	}
    }
}
