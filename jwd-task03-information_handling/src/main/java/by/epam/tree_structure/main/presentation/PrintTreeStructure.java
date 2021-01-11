package by.epam.tree_structure.main.presentation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import by.epam.tree_structure.entity.attribute.Attribute;
import by.epam.tree_structure.entity.element.Element;

public class PrintTreeStructure {

	public void print(Element rootElement) {

		if (rootElement != null) {
			printInfo(rootElement);

			if (rootElement.getChildren() != null) {
				List<Element> queueOutputElements = createQueueOutputElements(rootElement);
				Iterator<Element> iteratorElement = queueOutputElements.iterator();

				while (iteratorElement.hasNext()) {
					Element element = iteratorElement.next();
					printInfo(element);

				}
			}
		}
	}

	public void printInfo(Element elementTree) {

		System.out.print(elementTree.getName());

		if (elementTree.getAttribute() != null) {
			Iterator<Attribute> iteratorAttribute = elementTree.getAttribute().iterator();

			while (iteratorAttribute.hasNext()) {
				Attribute attribute = iteratorAttribute.next();
				System.out.print(" " + attribute.getName() + "=" + attribute.getValue());
			}
		}

		if (elementTree.getContent() != null) {
			System.out.print(" " + elementTree.getContent());
		}

		System.out.println();

	}

	public List<Element> createQueueOutputElements(Element rootElement) {

		List<Element> queueOutputElements = new LinkedList<Element>();
		queueOutputElements.addAll(rootElement.getChildren());

		int insertPozition;
		int indexElement = 0;
		Element nextElementQueue;

		while (indexElement < queueOutputElements.size()) {
			insertPozition = indexElement + 1;
			nextElementQueue = queueOutputElements.get(indexElement);

			if (nextElementQueue.getChildren() != null) {
				queueOutputElements.addAll(insertPozition, nextElementQueue.getChildren());
			}

			indexElement = insertPozition;
		}

		return queueOutputElements;
	}
}
