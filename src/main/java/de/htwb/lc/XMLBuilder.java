package de.htwb.lc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLBuilder {

    /**
     * Implements the documented Java Execute Hack, see http://www.adobe.com/devnet/livecycle/articles/building-xml.html
     */
    public Document append(Document document, Document element) throws Exception {
        Element docRoot = document.getDocumentElement();
        Element elemRoot = element.getDocumentElement();
        Node elemNode = document.importNode(elemRoot, true);
        docRoot.appendChild(elemNode);
        return document;
    }

}
