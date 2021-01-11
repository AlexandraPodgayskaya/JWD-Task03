package by.epam.tree_structure.creator.impl;

import java.io.File;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

import by.epam.tree_structure.creator.CreatorElement;
import by.epam.tree_structure.creator.CreatorTreeStructure;
import by.epam.tree_structure.dao.DAOFactory;
import by.epam.tree_structure.dao.XmlDAO;
import by.epam.tree_structure.entity.element.Element;

public class CreatorTreeStructureImpl implements CreatorTreeStructure {

	@Override
	public Element createTree(File file) throws IOException {

		Element rootElement = null;

		DAOFactory factory = DAOFactory.getInstance();
		XmlDAO xmlDAO = factory.getXmlDAO();

		String[] xmlFileData = xmlDAO.getData(file);

		String elementNameAndAttribute = ".+?=\\s*\".+?\"";
		String elementNameAndContent = ".+?>.+?</.+";
		String elementNameEndCoveringTag = "^/.+";
		String declarationXml = "^\\?.+?\\?";
		String comments = "^!--.+?--";

		Deque<Element> stackElements = new LinkedList<Element>();
		CreatorElement creatorElement;

		for (String data : xmlFileData) {

			if (data.matches(elementNameAndAttribute)) {
				creatorElement = new CreatorElementWithNameAndAttribute();
				stackElements.addLast(creatorElement.create(data));

			} else if (data.matches(elementNameAndContent)) {
				creatorElement = new CreatorElementWithNameAndContent();
				stackElements.peekLast().addChildren(creatorElement.create(data));

			} else if (data.matches(elementNameEndCoveringTag)) {
				Element topElementStack = stackElements.removeLast();

				if (stackElements.peekLast() != null) {
					stackElements.peekLast().addChildren(topElementStack);
				} else {
					rootElement = topElementStack;
				}

			} else if (!data.matches(declarationXml) && !data.matches(comments)) {
				creatorElement = new CreatorElementWithName();
				stackElements.addLast(creatorElement.create(data));

			}
		}

		return rootElement;
	}
}
