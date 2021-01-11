package by.epam.tree_structure.dao.impl;

import java.io.File;
import java.io.IOException;

import by.epam.tree_structure.dao.XmlDAO;
import by.epam.tree_structure.reader.CommonReader;
import by.epam.tree_structure.reader.impl.XmlReaderImpl;
import by.epam.tree_structure.reader.parser.XmlParser;
import by.epam.tree_structure.reader.preparation.DataPreprocessing;

public class XmlDAOImpl implements XmlDAO {

	public String[] getData(File file) throws IOException {

		CommonReader readerFile = new XmlReaderImpl();
		String dataFile = readerFile.take(file);

		DataPreprocessing preprocessingData = new DataPreprocessing();
		String preparedData = preprocessingData.preparation(dataFile);
		
		XmlParser parserElements = new XmlParser();
		String[] xmlFileTags = parserElements.parse(preparedData);

		return xmlFileTags;
	}

}
