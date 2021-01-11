package by.epam.tree_structure.reader.preparation;

public class DataPreprocessing {

	public String preparation(String dataFile) {

		String spacesBetweenTags = ">\\s*<";
		String tagsWithoutSpaces = "><";
		String dataWithoutSpaces = dataFile.trim().replaceAll(spacesBetweenTags, tagsWithoutSpaces);

		int startIndexCopyData = 1;
		int endIndexCopyData;
		endIndexCopyData = dataWithoutSpaces.length() - 1;
		String dataWithoutFirstAndLastCharacter = dataWithoutSpaces.substring(startIndexCopyData, endIndexCopyData);

		return dataWithoutFirstAndLastCharacter;
	}

}
