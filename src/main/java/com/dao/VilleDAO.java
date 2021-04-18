package com.dao;


import java.util.ArrayList;
import java.util.List;

import com.dto.Ville;


public interface VilleDAO {
	
	public ArrayList<Ville> findAllVille(String param);
	public Ville findVille(String param);
	public void addVille(Ville ville);	
	public void updateVille(Ville ville, String codePostal);
    public void deleteVille(String codePostal);

	
	


}

