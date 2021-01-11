package by.epam.tree_structure.main;

import java.io.File;
import java.io.IOException;

import by.epam.tree_structure.creator.CreatorTreeStructure;
import by.epam.tree_structure.creator.impl.CreatorTreeStructureImpl;
import by.epam.tree_structure.entity.element.Element;
import by.epam.tree_structure.main.presentation.PrintTreeStructure;

public class Main {

	public static void main(String[] args) {

		File file = new File("resources/file.xml");
		Element rootElement;

		CreatorTreeStructure treeCreator = new CreatorTreeStructureImpl();

		try {
			rootElement = treeCreator.createTree(file);
		} catch (IOException e) {
			System.out.println("Exception: " + e);
			rootElement = null;
		}

		PrintTreeStructure treeStructurePrint = new PrintTreeStructure();
		treeStructurePrint.print(rootElement);

	}

}
