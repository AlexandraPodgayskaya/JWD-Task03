package by.epam.tree_structure.creator.impl;

import java.util.Arrays;
import java.util.List;

import by.epam.tree_structure.creator.CreatorAttribute;
import by.epam.tree_structure.creator.CreatorElement;
import by.epam.tree_structure.entity.attribute.Attribute;
import by.epam.tree_structure.entity.element.Element;

public class CreatorElementWithNameAndAttribute implements CreatorElement {

	@Override
	public Element create(String data) {

		String attributeWithSpaces = "\\s*=\\s*\"";
		String attributeWithoutSpaces = "=\"";
		data = data.replaceAll(attributeWithSpaces, attributeWithoutSpaces);

		final String ELEMENT_NAME_AND_ATTRIBUTE_SPLIT = " ";
		String[] elementNameAndAttribute = data.split(ELEMENT_NAME_AND_ATTRIBUTE_SPLIT);
		String elementName = elementNameAndAttribute[0];
		Element elementTree = new Element();
		elementTree.setName(elementName);

		int startPositionAttribute = 1;
		int endPositionAttribute = elementNameAndAttribute.length;
		String[] attributesElement = Arrays.copyOfRange(elementNameAndAttribute, startPositionAttribute,
				endPositionAttribute);

		CreatorAttribute creatorAttribute = new CreatorAttributeImpl();
		List<Attribute> attributes = creatorAttribute.create(attributesElement);

		elementTree.setAttribute(attributes);

		return elementTree;
	}

}
