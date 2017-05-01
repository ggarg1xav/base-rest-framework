package com.neustar.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlRead {
	private static final String FILENAME = "src\\test\\resources\\testdata\\SampleXml.xml";
	static HashMap<String, String> hMap = new HashMap<String, String>();

	public static void main(String[] args){
		XmlRead xmlRead = new XmlRead();
		xmlRead.readXML("QA");
		for (Map.Entry<String, String> m : hMap.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		hMap.clear();
		System.out.println("-----------------------");
		xmlRead.readXML("Prod");
		for (Map.Entry<String, String> m : hMap.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}

	public HashMap<String, String> readXML(String tag) {

		File fXmlFile = new File(FILENAME);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		Document doc = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName(tag);

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			NodeList childNodes = nNode.getChildNodes();

			for (int index = 0; index < childNodes.getLength(); index++) {
				Node tempNode = childNodes.item(index);
				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
					hMap.put(tempNode.getNodeName(), tempNode.getTextContent());
				}
			}
		}
		return hMap;
	}
}
