package com.blo;


import java.util.ArrayList;


import com.dto.Ville;



public interface VilleBLO {
	
	

	public ArrayList<Ville> getInfoAllVille(String param) throws VilleException;

	public Ville getInfoVille(String param) throws VilleException;
	
	public void addVille(Ville ville);
	
	public void updateVille(Ville ville, String codePostal);
	
	public void deleteVille(String codePostal);
	
	
	



	
}
