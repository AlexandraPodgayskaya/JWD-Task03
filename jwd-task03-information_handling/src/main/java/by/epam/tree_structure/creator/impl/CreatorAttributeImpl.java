package by.epam.tree_structure.creator.impl;

import java.util.ArrayList;
import java.util.List;

import by.epam.tree_structure.creator.CreatorAttribute;
import by.epam.tree_structure.entity.attribute.Attribute;

public class CreatorAttributeImpl implements CreatorAttribute {

	@Override
	public List<Attribute> create(String[] attributesElement) {

		List<Attribute> attributes = new ArrayList<Attribute>();

		int startPositionAttribute = 0;
		int endPositionAttribute = attributesElement.length;

		for (int numberAttribute = startPositionAttribute; numberAttribute < endPositionAttribute; numberAttribute++) {

			final String ATTRIBUTE_NAME_AND_VALUE_SPLIT = "=";
			String[] attributeNameAndValue = attributesElement[numberAttribute].split(ATTRIBUTE_NAME_AND_VALUE_SPLIT);
			String attributeName = attributeNameAndValue[0];
			String attributeValue = attributeNameAndValue[1];

			Attribute attribute = new Attribute();
			attribute.setName(attributeName.trim());

			String attributeValueInQuotes = "\"";
			String attributeValueWithoutQuotes = "";
			attributeValue = attributeValue.trim().replaceAll(attributeValueInQuotes,
					attributeValueWithoutQuotes);
			attribute.setValue(attributeValue);

			attributes.add(attribute);
		}

		return attributes;
	}

}
