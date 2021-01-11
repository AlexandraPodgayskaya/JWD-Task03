package by.epam.tree_structure.creator.impl;

import by.epam.tree_structure.creator.CreatorElement;
import by.epam.tree_structure.entity.element.Element;

public class CreatorElementWithNameAndContent implements CreatorElement {

	@Override
	public Element create(String data) {

		final String ELEMENT_NAME_AND_CONTENT_SPLIT = ">";
		String[] elementNameAndContent = data.split(ELEMENT_NAME_AND_CONTENT_SPLIT);
		String elementName = elementNameAndContent[0];

		Element elementTree;
		String elementNameAndAttribute = ".+?=\\s*\".+?\"";

		if (elementName.matches(elementNameAndAttribute)) {
			CreatorElement creatorElement = new CreatorElementWithNameAndAttribute();
			elementTree = creatorElement.create(elementName);
		} else {
			elementTree = new Element();
			elementTree.setName(elementName);
		}

		final String ELEMENT_CONTENT_SPLIT = "<";
		String[] elementContent = elementNameAndContent[1].split(ELEMENT_CONTENT_SPLIT);
		String content = elementContent[0];
		elementTree.setContent(content.trim());

		return elementTree;
	}

}
