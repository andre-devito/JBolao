package jbolao.entity;

import devito.dados.objetos.Objeto;

public class Operacional implements Objeto {
	
	private String strCodigo;
	private String strDesc;
	
	public Operacional() {
	
		this(null, null);
		
	}

	public Operacional(String strCodigo, String strDesc) {
	
		this.strCodigo = strCodigo;
		this.strDesc = strDesc;
		
	}
	
	public String getCodigo() {
		return this.strCodigo;
	}
	
	public String getDesc() {
		return this.strDesc;
	}
	
	public void setCodigo(String strCodigo) {
		this.strCodigo = strCodigo;
	}
	
	public void setDesc(String strDesc) {
		this.strDesc = strDesc;
	}
	
}

