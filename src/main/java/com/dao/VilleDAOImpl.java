package com.dao;

import java.security.NoSuchAlgorithmException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

//@Repository
public class VilleDAOImpl implements VilleDAO {
	private JDBCConfiguration JDBCConf;
	private Connection connexion;

	public VilleDAOImpl(Connection connexion) {
		this.connexion = connexion;
	}

	public VilleDAOImpl(JDBCConfiguration JDBCConf) {
		this.JDBCConf = JDBCConf;
	}


	
	@Override
	public ArrayList<Ville> findAllVille(String param) {
		ArrayList<Ville> listVille = new ArrayList<Ville>();

		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		try {
			connexion = JDBCConf.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM ville_france ;");
			
			while (resultat.next()) {
				Ville ville = new Ville();
				ville.setNomCommune(resultat.getString("Nom_Commune"));
				ville.setCode_commune_INSEE(resultat.getString("Code_commune_INSEE"));
				ville.setCode_postal(resultat.getString("Code_postal"));
				ville.setLibelle_acheminement(resultat.getString("Libelle_acheminement"));;
				ville.setLigne_5(resultat.getString("Ligne_5"));
				ville.setLatitude(resultat.getString("Latitude"));
				ville.setLongitude(resultat.getString("Longitude"));

				listVille.add(ville);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listVille;
	}
	
	
	public Ville findVille(String name) {
		Ville ville = null;
		
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		
		
		try {
			connexion = JDBCConf.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM ville_france where Nom_Commune="
			+ name);

			
			while (resultat.next()) {
				ville = new Ville();
				ville.setNomCommune(resultat.getString("Nom_Commune"));
				ville.setCode_commune_INSEE(resultat.getString("Code_commune_INSEE"));
				ville.setCode_postal(resultat.getString("Code_postal"));
				ville.setLibelle_acheminement(resultat.getString("Libelle_acheminement"));;
				ville.setLigne_5(resultat.getString("Ligne_5"));
				ville.setLatitude(resultat.getString("Latitude"));
				ville.setLongitude(resultat.getString("Longitude"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ville;
	}
	
	
	
	public void addVille(Ville ville){
		
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try {

			connexion = JDBCConf.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO ville_france VALUES(?,?,?,?,?,?,?)");


			
			preparedStatement.setString(1, ville.getCode_commune_INSEE());
			preparedStatement.setString(2, ville.getNomCommune());
			preparedStatement.setString(3, ville.getCode_postal());
			preparedStatement.setString(4, ville.getLibelle_acheminement());
			preparedStatement.setString(5, ville.getLigne_5());
			preparedStatement.setString(6, ville.getLatitude());
			preparedStatement.setString(7, ville.getLongitude());
			preparedStatement.executeUpdate();
			
			

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	

	
	
	public void updateVille(Ville ville, String codePostal) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = JDBCConf.getConnection();
			preparedStatement = connexion.prepareStatement("UPDATE ville_france SET code_commune_INSEE= ?, nom_commune= ?, libelle_acheminement= ?, ligne_5= ?, latitude= ?, longitude= ? WHERE code_postal= ?");

			
			preparedStatement.setString(1, ville.getCode_commune_INSEE());
			preparedStatement.setString(2, ville.getNomCommune());
			preparedStatement.setString(3, ville.getLibelle_acheminement());
			preparedStatement.setString(4, ville.getLigne_5());
			preparedStatement.setString(5, ville.getLatitude());
			preparedStatement.setString(6, ville.getLongitude());
			preparedStatement.setString(7, codePostal);
			preparedStatement.executeUpdate();
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void deleteVille(String codePostal) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try {
			
			connexion = JDBCConf.getConnection();
			preparedStatement = connexion.prepareStatement("DELETE FROM ville_france WHERE code_postal= ?");

			
			preparedStatement.setString(1, codePostal);
			preparedStatement.executeUpdate();
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}