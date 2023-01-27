/**
 * Writes XML StaX (POJO).
 */
package edu.ccri.lesson04.assignment.xml;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.UUID;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Writes the total expense XML StaX data file. This class assumes the xml is limited to four levels. <BR>
 * The first level is the parent node <BR>
 * The second level is the group (there could be 1 or more) <BR>
 * The third level is the child (there could be 1 or more) <BR>
 * The fourth level are the fields (there could be 1 or more) <BR>
 * <BR>
 * The structure would look something like: <BR>
 * &gt;parent&lt; <BR>
 * &gt;group&lt; <BR>
 * &gt;child&lt; <BR>
 * &gt;field>&gt;/field&lt; <BR>
 * &gt;field>&gt;/field&lt; <BR>
 * &gt;\child&lt; <BR>
 * &gt;child&lt; <BR>
 * &gt;field&lt;&gt;/field&lt; <BR>
 * &gt;field&lt;&gt;/field&lt; <BR>
 * &gt;/child&lt; <BR>
 * &gt;/group&lt; <BR>
 * &gt;group&lt; <BR>
 * &gt;child&lt; <BR>
 * &gt;field>&gt;/field&lt; <BR>
 * &gt;field>&gt;/field&lt; <BR>
 * &gt;\child&lt; <BR>
 * &gt;child&lt; <BR>
 * &gt;field&lt;&gt;/field&lt; <BR>
 * &gt;field&lt;&gt;/field&lt; <BR>
 * &gt;/child&lt; <BR>
 * &gt;/group&lt; <BR>
 * &gt;/parent&lt;
 *
 *
 * @author dean grammas
 */
public abstract class WriteXmlStaxData
{
    /**
     * Get an instance of the Logger
     */
    private static final Logger logger = LogManager.getLogger(WriteXmlStaxData.class.getName());
    
    /**
     * byte array output stream
     */
    ByteArrayOutputStream byteArrayOutputStream;
    
    /**
     * xml stax event factory
     */
    private XMLEventFactory eventFactory;
    
    /**
     * xml stax event writer
     */
    private XMLEventWriter eventWriter;
    
    /**
     * Constructor.
     */
    public WriteXmlStaxData()
    {
	super();
    }
    
    /**
     * Adds the xml document and closes the XML StaX factory
     *
     * @throws XMLStreamException - thrown if there is a problem with the xml stram
     */
    private void closeXmlStaxFactory() throws XMLStreamException
    {
	this.getEventWriter().add(this.getEventFactory().createEndDocument());
	this.getEventWriter().flush();
	
	this.getEventWriter().close();
    }
    
    /**
     * Creates the XML children
     */
    private void createChildren()
    {
	try
	{
	    XmlStaxData xmlStaxData = null;
	    
	    ArrayList<XmlStaxData> dataListRow = null;
	    
	    ArrayList<ArrayList<XmlStaxData>> dataList = getDataList();
	    
	    for (ArrayList<XmlStaxData> element : dataList)
	    {
		createStartChildNode(getChildNodeTag());
		
		dataListRow = element;
		for (XmlStaxData element2 : dataListRow)
		{
		    xmlStaxData = element2;
		    logger.debug("field=" + xmlStaxData.toString());
		    createNode(xmlStaxData.getXmlTag(), xmlStaxData.getValue());
		}
		
		createEndChildNode(getChildNodeTag());
		
	    }
	    
	} catch (XMLStreamException e)
	{
	    e.printStackTrace();
	    logger.error(ExceptionUtils.getStackTrace(e));
	}
	
    }
    
    /**
     * Creates the end xml child node
     *
     * @param name the node name
     * @throws XMLStreamException - thrown if there is a problem with the xml stram
     */
    protected void createEndChildNode(String name) throws XMLStreamException
    {
	// create End node
	EndElement endElement = this.getEventFactory().createEndElement("", "", name);
	this.getEventWriter().add(endElement);
    }
    
    /**
     * Creates the end parent xml node
     *
     * @throws XMLStreamException - thrown if there is a problem with the xml stram
     */
    private void createEndParentNode() throws XMLStreamException
    {
	this.getEventWriter().add(this.getEventFactory().createEndElement("", "", this.getXmlParentTag()));
    }
    
    /**
     * Creates an xml node
     *
     * @param name  the name of the node
     * @param value the value of the node
     * @throws XMLStreamException - thrown if there is a problem with the xml stram
     */
    protected void createNode(String name, String value) throws XMLStreamException
    {
	createStartChildNode(name);
	
	// create Content
	Characters characters = this.getEventFactory().createCharacters(value);
	this.getEventWriter().add(characters);
	
	createEndChildNode(name);
    }
    
    /**
     * Creates the start child node
     *
     * @param name the start child node
     * @throws XMLStreamException - thrown if there is a problem with the xml stram
     */
    private void createStartChildNode(String name) throws XMLStreamException
    {
	// create Start node
	StartElement startElement = this.getEventFactory().createStartElement("", "", name);
	this.getEventWriter().add(startElement);
    }
    
    /**
     * Creates the xml start parent node
     *
     * @throws XMLStreamException - thrown if there is a problem with the xml stram
     */
    private void createStartParentNode() throws XMLStreamException
    {
	// create config open tag
	StartElement configStartElement = this.getEventFactory().createStartElement("", "", this.getXmlParentTag());
	this.getEventWriter().add(configStartElement);
    }
    
    /**
     * This will create the xml results.
     *
     * @param group - the group name tag
     */
    public void createXml(String group)
    {
	try
	{
	    createStartChildNode(group);
	    
	    createChildren();
	    
	    createEndChildNode(group);
	} catch (XMLStreamException e)
	{
	    e.printStackTrace();
	    logger.error(ExceptionUtils.getStackTrace(e));
	}
    }
    
    /**
     * "Pretty" format of the xml
     *
     * @param xml - the xml
     * @return - "Pretty" format of the xml
     * @throws TransformerException - thrown if there is a problem with the transformer
     */
    private String formatXML(String xml) throws TransformerException
    {
	
	// write data to xml file
	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	Transformer transformer = transformerFactory.newTransformer();
	
	// pretty print by indentation
	transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	
	// add standalone="yes", add line break before the root element
	transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
	
	StreamSource source = new StreamSource(new StringReader(xml));
	StringWriter output = new StringWriter();
	transformer.transform(source, new StreamResult(output));
	
	return output.toString();
    }
    
    /**
     * getByteArrayOutputStream
     * 
     * @return the byteArrayOutputStream
     */
    private ByteArrayOutputStream getByteArrayOutputStream()
    {
	return byteArrayOutputStream;
    }
    
    /**
     * Returns the child node tag
     *
     * @return the child node tag
     */
    protected abstract String getChildNodeTag();
    
    /**
     * Returns the list (rows) of lists (columns) that represent the result to be written to the worksheet
     *
     * @return the list (rows) of lists (columns) that represent the result to be written to the worksheet
     */
    protected abstract ArrayList<ArrayList<XmlStaxData>> getDataList();
    
    /**
     * getEventFactory
     * 
     * @return the eventFactory
     */
    private XMLEventFactory getEventFactory()
    {
	return eventFactory;
    }
    
    /**
     * getEventWriter
     * 
     * @return the eventWriter
     */
    private XMLEventWriter getEventWriter()
    {
	return eventWriter;
    }
    
    /**
     * Returns the file name
     *
     * @return the file name
     */
    private String getFileName()
    {
	StringBuilder sb = new StringBuilder();
	sb.append(this.getFileNamePrefix());
	if (this.useNameUnique())
	{
	    sb.append(".");
	    sb.append(UUID.randomUUID());
	}
	sb.append(this.getFileNameSuffix());
	return sb.toString();
    }
    
    /**
     * Returns the file name prefix (e.g. 'FileName')
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
     * Returns the xml parent tag
     *
     * @return the xml parent tag
     */
    protected abstract String getXmlParentTag();
    
    /**
     * Initializes the <code>WriteXmlStaxData</code> object. This must be called after the constructor has been called.
     */
    public void initialize()
    {
	try
	{
	    openXmlStaxFactory();
	    createStartParentNode();
	} catch (FileNotFoundException | XMLStreamException e)
	{
	    e.printStackTrace();
	    logger.error(ExceptionUtils.getStackTrace(e));
	}
    }
    
    /**
     * Opens the XML StaX Factory for business.
     *
     * @throws FileNotFoundException - thrown if the file is not found
     * @throws XMLStreamException    - thrown if there is a problem with the xml stram
     */
    private void openXmlStaxFactory() throws FileNotFoundException, XMLStreamException
    {
	// create an XMLOutputFactory
	XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
	
	this.setByteArrayOutputStream(new ByteArrayOutputStream());
	
	XMLEventWriter writer = outputFactory.createXMLEventWriter(this.getByteArrayOutputStream());
	
	// create XMLEventWriter
	this.setEventWriter(writer);
	
	// create an EventFactory
	this.setEventFactory(XMLEventFactory.newInstance());
	
	// create and write Start Tag
	StartDocument startDocument = this.getEventFactory().createStartDocument();
	
	this.getEventWriter().add(startDocument);
    }
    
    /**
     * Sets the byte array output stream
     *
     * @param byteArrayOutputStream the byteArrayOutputStream to set
     */
    private void setByteArrayOutputStream(ByteArrayOutputStream byteArrayOutputStream)
    {
	this.byteArrayOutputStream = byteArrayOutputStream;
    }
    
    /**
     * Sets the event factory
     *
     * @param eventFactory the eventFactory to set
     */
    private void setEventFactory(XMLEventFactory eventFactory)
    {
	this.eventFactory = eventFactory;
    }
    
    /**
     * Sets the event writer
     *
     * @param eventWriter the eventWriter to set
     */
    private void setEventWriter(XMLEventWriter eventWriter)
    {
	this.eventWriter = eventWriter;
    }
    
    /**
     * True if a unique id should be added to the file name. (Helps prevent incorrectly overwriting a file.)
     *
     * @return True if a unique id should be added to the file name
     */
    protected abstract boolean useNameUnique();
    
    /**
     * Writes the xml to a file
     */
    public void writeFile()
    {
	try
	{
	    createEndParentNode();
	    closeXmlStaxFactory();
	    
	    String xml = new String(this.getByteArrayOutputStream().toByteArray(), StandardCharsets.UTF_8);
	    
	    String prettyPrintXML = formatXML(xml);
	    logger.debug(prettyPrintXML);
	    
	    String fileName = this.getFileName();
	    logger.debug("fileName=" + fileName);
	    
	    // Java 11 - write to file
	    Files.writeString(Paths.get(fileName), prettyPrintXML, StandardCharsets.UTF_8);
	} catch (TransformerException | XMLStreamException | IOException e)
	{
	    e.printStackTrace();
	    logger.error(ExceptionUtils.getStackTrace(e));
	}
    }
}
