package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VilleDAO {
	/**
	 * Implémentation fichiers
	 * @return
	 */
	
	/**
	 * Implémentation BD localhost
	 * @return
	 * @throws DaoException 
	 */
	public static VilleDAOImpl getImpl() throws DaoException {
		
		// connexion BD
		Connection connexion = null;
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/maven", "root", "");
			//connexion.setAutoCommit(false);
		} catch (SQLException e1) {
			throw new DaoException("Impossible de se connected à la base de données");
			//e1.printStackTrace();
		}
		
		return new VilleDAOImpl(connexion);
	}

}

