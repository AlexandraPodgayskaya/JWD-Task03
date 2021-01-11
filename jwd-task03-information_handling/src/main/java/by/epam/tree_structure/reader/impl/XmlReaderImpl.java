package by.epam.tree_structure.reader.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import by.epam.tree_structure.reader.CommonReader;

public class XmlReaderImpl implements CommonReader {

	public String take(File file) throws IOException {

		if (file == null) {
			throw new FileNotFoundException();
		}

		BufferedReader reader = new BufferedReader(new FileReader(file));
		StringBuilder dataFile = new StringBuilder();
		String lineDataXml = null;

		while ((lineDataXml = reader.readLine()) != null) {
			if (!lineDataXml.isEmpty()) {
				dataFile.append(lineDataXml);
			}
		}

		reader.close();
		return dataFile.toString();

	}
}
