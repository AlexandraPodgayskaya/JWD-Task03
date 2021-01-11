package by.epam.tree_structure.dao;

import by.epam.tree_structure.dao.impl.XmlDAOImpl;

public class DAOFactory {
	
	private static final DAOFactory instance = new DAOFactory();

	private final XmlDAO xmlDAO = new XmlDAOImpl();

	private DAOFactory() {
	}

	public XmlDAO getXmlDAO() {
		return xmlDAO;
	}

	public static DAOFactory getInstance() {
		return instance;
	}

}
