package de.htwb.lc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Implements the documented Java Execute Hacks, see http://www.adobe.com/devnet/livecycle/articles/building-xml.html
 */
public class XMLBuilder {

    public Document append(Document document, Document element) throws Exception {
        Element docRoot = document.getDocumentElement();
        Element elemRoot = element.getDocumentElement();
        Node elemNode = document.importNode(elemRoot, true);
        docRoot.appendChild(elemNode);
        return document;
    }

    public Document prepend(Document document, Document element) throws Exception {
        Element docRoot = document.getDocumentElement();
        Element elemRoot = element.getDocumentElement();
        Node elemNode = document.importNode(elemRoot, true);
        docRoot.insertBefore(elemNode, docRoot.getFirstChild());
        return document;
    }
}
