package by.epam.tree_structure.creator;

import java.util.List;

import by.epam.tree_structure.entity.attribute.Attribute;

public interface CreatorAttribute {

	public List<Attribute> create(String[] attributesElement);

}
