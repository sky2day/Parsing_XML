package core;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;

public class ParsingXML_DOMXPath {

	public static void main(String[] args) throws Throwable, Exception,
			ParserConfigurationException {

		String myXML = "http://learn2test.net/sdc.xml";

		String xpath_element_01 = "//server/orig-kw";
		String xpath_element_02 = "//server/engine";
		String xpath_element_03 = "//server/kadu-version";
		String xpath_element_04 = "//response-time";

		String xpath_attribute_01 = "//deals/@count";   
		//deals/[@count=”40”] - Java throws exception.
		
		// Get the DOM Builder Factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// Get the DOM Builder
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Load and Parse the XML document contains the complete XML as a Tree.
		Document d = builder.parse(myXML);

		// Optional
		d.getDocumentElement().normalize();

		// xPath
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();

		String element_01 = xpath.compile(xpath_element_01).evaluate(d);
		String element_02 = xpath.compile(xpath_element_02).evaluate(d);
		String element_03 = xpath.compile(xpath_element_03).evaluate(d);
		String element_04 = xpath.compile(xpath_element_04).evaluate(d);
		String attribute_01 = xpath.compile(xpath_attribute_01).evaluate(d);

		System.out.println("Key Word: " + element_01);
		System.out.println("Engine: " + element_02);
		System.out.println("Version: " + element_03);
		System.out.println("Response time: " + element_04);
		System.out.println("Number of deals: " + attribute_01);
	}
}