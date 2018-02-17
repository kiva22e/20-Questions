package stackutils;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.xml.parsers.*;

import org.xml.sax.SAXException;
import org.w3c.dom.*;

import java.io.*;

import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTree;
import datastructures.DefaultBinaryTreeNode;

public class DerbyFileReader extends JComponent {
	private static DefaultBinaryTree<String> tree;
	
	public DerbyFileReader(java.lang.String[] args){
		try {

			// Setup XML Document
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File xmlFile = new File(args[0]);
			Document document = builder.parse(xmlFile);
			tree = parseDerbyFile(document);
		} catch (ParserConfigurationException pce) {
			// what to do if this exception happens
		} catch (SAXException saxe) {
			// what to do if this exception happens
		} catch (IOException ioe) {
			// what to do if this exception happens
		}
	}

	public static DefaultBinaryTree<String> getTree(){
		return tree;
	}

	/**
	 * parses the derby document and puts that data into a BinaryTree
	 * 
	 * @param document
	 * @return
	 */
	private static DefaultBinaryTree<String> parseDerbyFile(Document document) {
		Node docRoot = document.getDocumentElement();
		DefaultBinaryTree<String> tree = new DefaultBinaryTree<String>();
		tree.setRoot(parseNode(docRoot));
		return tree;
	}

	private static BinaryTreeNode<String> parseNode(Node n) {
		// create new node
		DefaultBinaryTreeNode<String> newNode = new DefaultBinaryTreeNode<String>();
		String data = "";
		if (n.getNodeName().equals("question")) {
			Element Elt = (Element) n;
			data = Elt.getAttribute("text");
		} else {
			data = n.getTextContent();
		}
		newNode.setData(data);
		// check that nodes children
		if (n.hasChildNodes()) {
			NodeList list = n.getChildNodes();
			for (int i = 0; i < list.getLength(); i++)
				// if the child is an element check if it's attribute is yes or
				// no
				if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element currentElt = (Element) list.item(i);
					// if yes call parse node on it's child and add that to the
					// left
					if (currentElt.getAttribute("userAnswer").equals("yes")) {
						NodeList children = currentElt.getChildNodes();
						for (int j = 0; j < children.getLength(); j++) {
							if (children.item(j).getNodeType() == Node.ELEMENT_NODE) {
								newNode.setLeftChild(parseNode(children.item(j)));
							}
						}

					} else if (currentElt.getAttribute("userAnswer").equals(
							"no")) {
						NodeList children = currentElt.getChildNodes();
						for (int j = 0; j < children.getLength(); j++) {
							if (children.item(j).getNodeType() == Node.ELEMENT_NODE) {
								newNode.setRightChild(parseNode(children
										.item(j)));
							}
						}
					}
				}

		}
		return newNode;

	}
}
