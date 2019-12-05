package jbolao.entity;

import devito.dados.objetos.Objeto;

public class VClassBolao implements Objeto {

	private String strCodigoPaisCamp;
	private String strNomePaisCamp;
	private String strCodigoCamp;
	private String strNomeCamp;
	
	private String strAnoInicioTemp;
	private String strAnoFimTemp;
	
	private String strNomeMesa;
	private String strCodigoUsuario;
	
	private int intPontos;
	private int intAcertosMosca;
	private int intAcertosColunaGol;
	private int intAcertosColuna;
	private int intAcertosGol;
	
	public VClassBolao() {
	
		this(null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0);
		
	}

	public VClassBolao(String strCodigoPaisCamp, String strNomePaisCamp, String strCodigoCamp, String strNomeCamp, String strAnoInicioTemp, String strAnoFimTemp, String strNomeMesa, String strCodigoUsuario, int intPontos, int intAcertosMosca, int intAcertosColunaGol, int intAcertosColuna, int intAcertosGol) {
		
		this.strCodigoPaisCamp = strCodigoPaisCamp;
		this.strNomePaisCamp = strNomePaisCamp;
		this.strCodigoCamp = strCodigoCamp;
		this.strNomeCamp = strNomeCamp;
		
		this.strAnoInicioTemp = strAnoInicioTemp;
		this.strAnoFimTemp = strAnoFimTemp;
		
		this.strNomeMesa = strNomeMesa;
		this.strCodigoUsuario = strCodigoUsuario;
		
		this.intPontos = intPontos;
		this.intAcertosMosca = intAcertosMosca;
		this.intAcertosColunaGol = intAcertosColunaGol;
		this.intAcertosColuna = intAcertosColuna;
		this.intAcertosGol = intAcertosGol;
		
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
	
	public String getNomeMesa() {
		return this.strNomeMesa;
	}
	
	public String getCodigoUsuario() {
		return this.strCodigoUsuario;
	}
	
	public int getPontos() {
		return this.intPontos;
	}
	
	public int getAcertosMosca() {
		return this.intAcertosMosca;
	}
	
	public int getAcertosColunaGol() {
		return this.intAcertosColunaGol;
	}
	
	public int getAcertosColuna() {
		return this.intAcertosColuna;
	}
	
	public int getAcertosGol() {
		return this.intAcertosGol;
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
	
	public void setNomeMesa(String strNomeMesa) {
		this.strNomeMesa = strNomeMesa;
	}
	
	public void setCodigoUsuario(String strCodigoUsuario) {
		this.strCodigoUsuario = strCodigoUsuario;
	}
	
	public void setPontos(int intPontos) {
		this.intPontos = intPontos;
	}
	
	public void setAcertosMosca(int intAcertosMosca) {
		this.intAcertosMosca = intAcertosMosca;
	}
	
	public void setAcertosColunaGol(int intAcertosColunaGol) {
		this.intAcertosColunaGol = intAcertosColunaGol;
	}
	
	public void setAcertosColuna(int intAcertosColuna) {
		this.intAcertosColuna = intAcertosColuna;
	}
	
	public void setAcertosGol(int intAcertosGol) {
		this.intAcertosGol = intAcertosGol;
	}
	
}

