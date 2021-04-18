package com.blo;


import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.JDBCConfiguration;
import com.dao.VilleDAO;
import com.dto.Ville;


@Service
public class VilleBLOImpl implements VilleBLO {

	
	private VilleDAO villeDAO;

	public void init(){
		JDBCConfiguration JDBCConf = JDBCConfiguration.getInstance();
		this.villeDAO = JDBCConf.getVilleDao();
	}
	


	@Override
	public ArrayList<Ville> getInfoAllVille(String param) throws VilleException {
		init();
		ArrayList<Ville> listVille;

		listVille = villeDAO.findAllVille(param);
		System.out.println("Nombre de ville récupérée(s) : " + listVille.size());

		return listVille;
	}
	
	@Override
	public Ville getInfoVille(String param) throws VilleException {
		init();
		Ville ville;

		ville = villeDAO.findVille(param);
		//System.out.println("Nombre de ville récupérée(s) : " + ville.size());

		return ville;
	}
	
	@Override
	public void addVille(Ville ville) {
		init();
		villeDAO.addVille(ville);
		System.out.println("Ville insérée");
	}
	
	@Override
	public void updateVille(Ville ville, String codePostal) {
		init();
		villeDAO.updateVille(ville, codePostal);
		System.out.println("Ville modifiée");
	}
	
	@Override
	public void deleteVille(String codePostal) {
		init();
		villeDAO.deleteVille(codePostal);
		System.out.println("Ville supprimée");
	}
	


}
