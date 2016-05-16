package core;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParsingXML_DOM {

	public static void main(String[] args) throws Throwable, Exception,
			ParserConfigurationException {

		String myXML = "http://learn2test.net/sdc.xml";

		String node = "kadu-response";

		String element_01 = "orig-kw";
		String element_02 = "engine";
		String element_03 = "kadu-version";
		String element_04 = "response-time";
		String element_05 = "deals";
		String attribute_01 = "count";

		// Get the DOM Builder Factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// Get the DOM Builder
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Load and Parse the XML document contains the complete XML as a Tree.
		Document document = builder.parse(myXML);

		// Optional
		document.getDocumentElement().normalize();

		// Parsing elements
		NodeList nList = document.getElementsByTagName(node);

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("Key Word: "
					+ eElement.getElementsByTagName(element_01).item(i)
						.getChildNodes().item(i).getNodeValue());
				System.out.println("Engine: "
					+ eElement.getElementsByTagName(element_02).item(i)
						.getChildNodes().item(i).getNodeValue());
				System.out.println("Version: "
					+ eElement.getElementsByTagName(element_03).item(i)
						.getChildNodes().item(i).getNodeValue().trim());
				System.out.println("Response time: "
					+ eElement.getElementsByTagName(element_04).item(i)
						.getChildNodes().item(i).getNodeValue().trim());
			}
		}

		// Parsing attribute
		NodeList nList2 = document.getElementsByTagName(element_05);

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList2.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("Number of deals: "
						+ eElement.getAttribute(attribute_01).trim());

			}
		}
	}
}