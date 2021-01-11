package by.epam.tree_structure.creator;

import java.io.File;
import java.io.IOException;

import by.epam.tree_structure.entity.element.Element;

public interface CreatorTreeStructure {

	public Element createTree(File file) throws IOException;

}
