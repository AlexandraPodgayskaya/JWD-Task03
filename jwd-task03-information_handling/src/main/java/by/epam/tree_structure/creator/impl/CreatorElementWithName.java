package by.epam.tree_structure.creator.impl;

import by.epam.tree_structure.creator.CreatorElement;
import by.epam.tree_structure.entity.element.Element;

public class CreatorElementWithName implements CreatorElement {

	@Override
	public Element create(String data) {

		Element elementTree = new Element();
		elementTree.setName(data);

		return elementTree;
	}

}
