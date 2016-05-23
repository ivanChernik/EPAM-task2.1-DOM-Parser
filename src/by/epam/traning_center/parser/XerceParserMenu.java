package by.epam.traning_center.parser;

import java.io.IOException;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XerceParserMenu {
	private static final String COLDAPPETIZERS = "cold-appetizers";
	private static final String COLDAPPETIZER = "cold-appetizer";
	private static final String HOTAPPETIZERS = "hot-appetizers";
	private static final String HOTAPPETIZER = "hot-appetizer";
	private static final String BREAKFASTS = "breakfasts";
	private static final String BREAKFAST = "breakfast";
	private static final String NAME = "name";
	private static final String DESCRIPTION = "description";
	private static final String PORTION = "portion";
	private static final String PRICE = "price";
	private static final String ID = "id";

	public void parseFile(String filename) {
		DOMParser parser = new DOMParser();
		try {
			parser.parse(filename);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document document = parser.getDocument();
		Element root = document.getDocumentElement();
		System.out.println("-----cold-appetizers-------");
		parseParticularDish(parseRootKindDish(root, COLDAPPETIZERS,
				COLDAPPETIZER));
		System.out.println("-----hot-appetizers-------");
		parseParticularDish(parseRootKindDish(root, HOTAPPETIZERS, HOTAPPETIZER));
		System.out.println("-----breakfasts-------");
		parseParticularDish(parseRootKindDish(root, BREAKFASTS, BREAKFAST));
	}

	private NodeList parseRootKindDish(Element root, String nameKindDish,
			String nameParticularDish) {
		NodeList kindDishList = root.getElementsByTagName(nameKindDish);
		Element kindDish = (Element) kindDishList.item(0);
		NodeList particularDishesList = kindDish
				.getElementsByTagName(nameParticularDish);
		return particularDishesList;
	}

	private void parseParticularDish(NodeList inputDishesList) {
		for (int indexDish = 0; indexDish < inputDishesList.getLength(); indexDish++) {
			Element dish = (Element) inputDishesList.item(indexDish);
			System.out.println("id = " + dish.getAttribute(ID));
			printElemet(getSingleChild(dish, NAME));
			printElemet(getSingleChild(dish, DESCRIPTION));
			printElemet(getSingleChild(dish, PORTION));
			printElemet(getSingleChild(dish, PRICE));
			System.out.println("------------");
		}

	}

	private Element getSingleChild(Element element, String childName) {
		NodeList nodesList = element.getElementsByTagName(childName);
		Element child = (Element) nodesList.item(0);
		return child;
	}

	private void printElemet(Element inputElement) {
		if (inputElement != null) {
			System.out.println(inputElement.getTextContent());
		}
	}

}
