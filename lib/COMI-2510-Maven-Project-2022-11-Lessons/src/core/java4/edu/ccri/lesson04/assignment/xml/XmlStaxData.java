/**
 * XML Stax Data object (PODO).
 */
package edu.ccri.lesson04.assignment.xml;

/**
 * XML Stax Data object (PODO).
 *
 * @author dean grammas
 */
public class XmlStaxData
{
    /**
     * value
     */
    private String value;
    
    /**
     * xml tag
     */
    private String xmlTag;
    
    /**
     * Constructor
     *
     * @param xmlTag - xml tag
     * @param value  - value
     */
    public XmlStaxData(String xmlTag, double value)
    {
	super();
	this.xmlTag = xmlTag;
	this.value = String.valueOf(value);
    }
    
    /**
     * Constructor
     *
     * @param xmlTag - xml tag
     * @param value  - value
     */
    public XmlStaxData(String xmlTag, String value)
    {
	super();
	this.xmlTag = xmlTag;
	this.value = value;
    }
    
    /**
     * Return the value
     *
     * @return the value
     */
    public String getValue()
    {
	return this.value;
    }
    
    /**
     * Return xml tag
     *
     * @return the xmlTag
     */
    public String getXmlTag()
    {
	return this.xmlTag;
    }
    
    /**
     * Sets the value
     *
     * @param value the value to set
     */
    public void setValue(String value)
    {
	this.value = value;
    }
    
    /**
     * Sets the xml tag
     *
     * @param xmlTag the xmlTag to set
     */
    public void setXmlTag(String xmlTag)
    {
	this.xmlTag = xmlTag;
    }
    
    /**
     * toString method
     *
     * @return The object's string representation.
     */
    
    @Override
    public String toString()
    {
	StringBuilder sb = new StringBuilder();
	
	sb.append(this.getClass());
	sb.append(" this.getXmlTag()=").append(this.getXmlTag());
	sb.append("\t this.getValue()=").append(this.getValue());
	
	return sb.toString();
    }
}
