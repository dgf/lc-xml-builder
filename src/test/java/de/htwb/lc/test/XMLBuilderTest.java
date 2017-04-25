package de.htwb.lc.test;

import de.htwb.lc.XMLBuilder;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import static org.junit.Assert.assertEquals;

public class XMLBuilderTest {

    @Test
    public void testAppend() throws Exception {

        // create builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // build document
        Document document = builder.newDocument();
        document.setXmlStandalone(true);

        Element root = document.createElement("list");
        document.appendChild(root);

        Element first = document.createElement("entry");
        first.setTextContent("first");
        root.appendChild(first);

        Element second = document.createElement("entry");
        second.setTextContent("second");
        root.appendChild(second);

        // create element to append
        Document element = builder.newDocument();
        element.setXmlStandalone(true);

        Element third = element.createElement("entry");
        third.setTextContent("third");
        element.appendChild(third);

        // call appender
        Document actual = new XMLBuilder().append(document, element);

        // assert entries
        NodeList nodes = actual.getDocumentElement().getChildNodes();
        assertEquals(3, nodes.getLength());
        assertEquals(first.getTextContent(), nodes.item(0).getTextContent());
        assertEquals(third.getTextContent(), nodes.item(2).getTextContent());
    }

    @Test
    public void testPrepend() throws Exception {

        // create builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // build document
        Document document = builder.newDocument();
        document.setXmlStandalone(true);

        Element root = document.createElement("list");
        document.appendChild(root);

        Element second = document.createElement("entry");
        second.setTextContent("second");
        root.appendChild(second);

        Element third = document.createElement("entry");
        third.setTextContent("third");
        root.appendChild(third);

        // create element to prepend
        Document element = builder.newDocument();
        element.setXmlStandalone(true);

        Element first = element.createElement("entry");
        first.setTextContent("first");
        element.appendChild(first);

        // call prepend
        Document actual = new XMLBuilder().prepend(document, element);

        // assert entries
        NodeList nodes = actual.getDocumentElement().getChildNodes();
        assertEquals(3, nodes.getLength());
        assertEquals(first.getTextContent(), nodes.item(0).getTextContent());
        assertEquals(third.getTextContent(), nodes.item(2).getTextContent());
    }

}
