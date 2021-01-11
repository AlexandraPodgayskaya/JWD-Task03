package by.epam.tree_structure.entity.element;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import by.epam.tree_structure.entity.attribute.Attribute;

public class Element implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private List<Attribute> attributes;
	private List<Element> children;
	private String content;

	public Element() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Attribute> getAttribute() {
		return attributes;
	}

	public void setAttribute(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public List<Element> getChildren() {
		return children;
	}

	public void addChildren(Element element) {

		if (children == null) {
			children = new ArrayList<Element>();
		}
		children.add(element);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ElementImpl [name=" + name + ", attributes=" + attributes + ", children=" + children
				+ ", content=" + content + "]";
	}

}
