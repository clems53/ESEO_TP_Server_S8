package com.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Ville {


	private String nomCommune;
	private String code_commune_INSEE;
	private String code_postal;
	private String libelle_acheminement;
	private String ligne_5;
	private String latitude;
	private String longitude;
	

	
	
}
