package com.controller;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dao.DaoException;
import com.dao.VilleDAO;
import com.dao.VilleDAOImpl;
import com.dto.Ville;

@RestController
public class VilleControleur {
	
	@Autowired
	VilleBLO villeBLOService;
	
	
	
	
	// Methode GET
		@RequestMapping(value = "/villes", method = RequestMethod.GET)
		@ResponseBody
		public ArrayList<Ville> ListVille() {
			System.out.println("Appel GET");
			
			villeBLOService.getInfoAllVille("");
			
			return villeBLOService.getInfoAllVille("");
		}
		
		
	// Methode GET
		@RequestMapping(value = "/ville/{name}", method = RequestMethod.GET)
		@ResponseBody
		public Ville AfficherVille(@PathVariable String name) {
			System.out.println("Appel GET");
			
			villeBLOService.getInfoVille(name);
			
			return villeBLOService.getInfoVille(name);
		}
		
		
	// Methode POST
		@PostMapping(value = "/addville")
		public void CreateVille(@RequestBody Ville ville) {
			System.out.println("Appel POST");
			villeBLOService.addVille(ville);
		}
		
	
	// Methode PUT	
		@PutMapping(value = "/updateville/{codePostal}")
		public void UpdateVille(@RequestBody Ville ville, @PathVariable("codePostal") String codePostal) {
			System.out.println("Appel PUT");
			villeBLOService.updateVille(ville, codePostal);
		}	
		
		
	// Methode DELETE
		@DeleteMapping(value = "/deleteville/{codePostal}")
		public void DeleteVille(@PathVariable("codePostal") String codePostal) {
			System.out.println("Appel DELETE");
			villeBLOService.deleteVille(codePostal);
		}


}