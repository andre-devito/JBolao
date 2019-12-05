package jbolao.entity;

import devito.dados.objetos.Objeto;

public abstract class VClass implements Objeto {

	private String strCodigoPaisCamp;
	private String strNomePaisCamp;
	private String strCodigoCamp;
	private String strNomeCamp;
	
	private String strAnoInicioTemp;
	private String strAnoFimTemp;
	
	private String strCodigoFaseJogo;
	private String strCodigoGrupoJogo;
	
	private float fltMedia;
	private int intEstat;
	
	private int intPontosGanhos;
	private int intJogos;
	private int intVitorias;
	private int intEmpates;
	private int intDerrotas;
	private int intGolsPro;
	private int intGolsContra;
	private int intSaldoGols;
	
	public VClass() {
	
		this(null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
	}

	public VClass(String strCodigoPaisCamp, String strNomePaisCamp, String strCodigoCamp, String strNomeCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoFaseJogo, String strCodigoGrupoJogo, float fltMedia, int intEstat, int intPontosGanhos, int intJogos, int intVitorias, int intEmpates, int intDerrotas, int intGolsPro, int intGolsContra, int intSaldoGols) {
		
		this.strCodigoPaisCamp = strCodigoPaisCamp;
		this.strNomePaisCamp = strNomePaisCamp;
		this.strCodigoCamp = strCodigoCamp;
		this.strNomeCamp = strNomeCamp;
		
		this.strAnoInicioTemp = strAnoInicioTemp;
		this.strAnoFimTemp = strAnoFimTemp;
		
		this.strCodigoFaseJogo = strCodigoFaseJogo;
		this.strCodigoGrupoJogo = strCodigoGrupoJogo;
		
		this.fltMedia = fltMedia;
		this.intEstat = intEstat;
		
		this.intPontosGanhos = intPontosGanhos;
		this.intJogos = intJogos;
		this.intVitorias = intVitorias;
		this.intEmpates = intEmpates;
		this.intDerrotas = intDerrotas;
		this.intGolsPro = intGolsPro;
		this.intGolsContra = intGolsContra;
		this.intSaldoGols = intSaldoGols;
		
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
	
	public String getCodigoFaseJogo() {
		return this.strCodigoFaseJogo;
	}
	
	public String getCodigoGrupoJogo() {
		return this.strCodigoGrupoJogo;
	}
	
	public float getMedia() {
		return this.fltMedia;
	}
	
	public int getEstat() {
		return this.intEstat;
	}
	
	public int getPontosGanhos() {
		return this.intPontosGanhos;
	}
	
	public int getJogos() {
		return this.intJogos;
	}
	
	public int getVitorias() {
		return this.intVitorias;
	}
	
	public int getEmpates() {
		return this.intEmpates;
	}
	
	public int getDerrotas() {
		return this.intDerrotas;
	}
	
	public int getGolsPro() {
		return this.intGolsPro;
	}
	
	public int getGolsContra() {
		return this.intGolsContra;
	}
	
	public int getSaldoGols() {
		return this.intSaldoGols;
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
	
	public void setCodigoFaseJogo(String strCodigoFaseJogo) {
		this.strCodigoFaseJogo = strCodigoFaseJogo;
	}
	
	public void setCodigoGrupoJogo(String strCodigoGrupoJogo) {
		this.strCodigoGrupoJogo = strCodigoGrupoJogo;
	}
	
	public void setMedia(float fltMedia) {
		this.fltMedia = fltMedia;
	}
	
	public void setEstat(int intEstat) {
		this.intEstat = intEstat;
	}
	
	public void setPontosGanhos(int intPontosGanhos) {
		this.intPontosGanhos = intPontosGanhos;
	}
	
	public void setJogos(int intJogos) {
		this.intJogos = intJogos;
	}
	
	public void setVitorias(int intVitorias) {
		this.intVitorias = intVitorias;
	}
	
	public void setEmpates(int intEmpates) {
		this.intEmpates = intEmpates;
	}
	
	public void setDerrotas(int intDerrotas) {
		this.intDerrotas = intDerrotas;
	}
	
	public void setGolsPro(int intGolsPro) {
		this.intGolsPro = intGolsPro;
	}
	
	public void setGolsContra(int intGolsContra) {
		this.intGolsContra = intGolsContra;
	}
	
	public void setSaldoGols(int intSaldoGols) {
		this.intSaldoGols = intSaldoGols;
	}
	
}

