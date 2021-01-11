package by.epam.tree_structure.reader.parser;

public class XmlParser {

	public String[] parse(String data) {

		final String TAGS_SPLIT = "><";
		String[] xmlFileData = data.split(TAGS_SPLIT);

		return xmlFileData;
	}

}
