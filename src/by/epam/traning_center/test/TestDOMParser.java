package by.epam.traning_center.test;

import by.epam.traning_center.parser.XerceParserMenu;


public class TestDOMParser {
	private static final String PATH="src/by/epam/traning_center/xml/menu.xml";

	public static void main(String[] args) {
		XerceParserMenu parser = new XerceParserMenu();
		parser.parseFile(PATH);
		
	}


}
