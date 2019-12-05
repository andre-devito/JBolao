package jbolao.entity;

import devito.dados.objetos.Objeto;

public abstract class VPart implements Objeto {

	private String strCodigoPaisCamp;
	private String strNomePaisCamp;
	private String strCodigoCamp;
	private String strNomeCamp;
	
	private String strAnoInicioTemp;
	private String strAnoFimTemp;
	
	public VPart() {
	
		this(null, null, null, null, null, null);
		
	}

	public VPart(String strCodigoPaisCamp, String strNomePaisCamp, String strCodigoCamp, String strNomeCamp, String strAnoInicioTemp, String strAnoFimTemp) {
		
		this.strCodigoPaisCamp = strCodigoPaisCamp;
		this.strNomePaisCamp = strNomePaisCamp;
		this.strCodigoCamp = strCodigoCamp;
		this.strNomeCamp = strNomeCamp;
		
		this.strAnoInicioTemp = strAnoInicioTemp;
		this.strAnoFimTemp = strAnoFimTemp;
		
	}
	
	public String getCodigoPaisCamp() {
		return this.strCodigoPaisCamp;
	}
	
	public String getNomePaisCamp() {
		return this.strNomePaisCamp;
	}
	
	public String getCodigoCamp() {
		return this.strCodigoCamp;
	}
	
	public String getNomeCamp() {
		return this.strNomeCamp;
	}
	
	public String getAnoInicioTemp() {
		return this.strAnoInicioTemp;
	}
	
	public String getAnoFimTemp() {
		return this.strAnoFimTemp;
	}
	
	public void setCodigoPaisCamp(String strCodigoPaisCamp) {
		this.strCodigoPaisCamp = strCodigoPaisCamp;
	}
	
	public void setNomePaisCamp(String strNomePaisCamp) {
		this.strNomePaisCamp = strNomePaisCamp;
	}
	
	public void setCodigoCamp(String strCodigoCamp) {
		this.strCodigoCamp = strCodigoCamp;
	}
	
	public void setNomeCamp(String strNomeCamp) {
		this.strNomeCamp = strNomeCamp;
	}
	
	public void setAnoInicioTemp(String strAnoInicioTemp) {
		this.strAnoInicioTemp = strAnoInicioTemp;
	}
	
	public void setAnoFimTemp(String strAnoFimTemp) {
		this.strAnoFimTemp = strAnoFimTemp;
	}
	
}

