package jbolao.entity;

import devito.dados.objetos.Objeto;

public class Pais implements Objeto {
	
	private String strCodigoPais;
	private String strNomePais;
	
	public Pais() {
	
		this(null, null);
		
	}

	public Pais(String strCodigoPais, String strNomePais) {
	
		this.strCodigoPais = strCodigoPais;
		this.strNomePais = strNomePais;
		
	}
	
	public String getCodigoPais() {
		return this.strCodigoPais;
	}
	
	public String getNomePais() {
		return this.strNomePais;
	}
	
	public void setCodigoPais(String strCodigoPais) {
		this.strCodigoPais = strCodigoPais;
	}
	
	public void setNomePais(String strNomePais) {
		this.strNomePais = strNomePais;
	}
	
}

