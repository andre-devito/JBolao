package jbolao.entity;

import devito.dados.objetos.Objeto;

public abstract class VJogo implements Objeto {

	private String strCodigoPaisCamp;
	private String strNomePaisCamp;
	private String strCodigoCamp;
	private String strNomeCamp;
	
	private String strAnoInicioTemp;
	private String strAnoFimTemp;
	
	private int intHomeScore = -1;
	private int intHomeET = -1;
	private int intHomePK = -1;
	
	private int intAwayScore = -1;
	private int intAwayET = -1;
	private int intAwayPK = -1;
	
	private String strCodigoJogo;
	private String strCodigoFaseJogo;
	private String strDescFaseJogo;
	private String strCodigoTurnoJogo;
	private String strDescTurnoJogo;
	private String strCodigoRodadaJogo;
	private String strDescRodadaJogo;
	private String strCodigoGrupoJogo;
	private String strDescGrupoJogo;
	private String strDataJogo;
	
	private int intContadorOperacional;
	private String strCodigoOperacionalJogo;
	private String strDescOperacionalJogo;
	
	public VJogo() {
	
		this(null, null, null, null, null, null, -1, -1, -1, -1, -1, -1, null, null, null, null, null, null, null, null, null, null, 0, null, null);
		
	}
	
	public VJogo(String strCodigoPaisCamp, String strNomePaisCamp, String strCodigoCamp, String strNomeCamp, String strAnoInicioTemp, String strAnoFimTemp, int intHomeScore, int intAwayScore, String strCodigoJogo, String strCodigoFaseJogo, String strDescFaseJogo, String strCodigoTurnoJogo, String strDescTurnoJogo, String strCodigoRodadaJogo, String strDescRodadaJogo, String strCodigoGrupoJogo, String strDescGrupoJogo, String strDataJogo, int intContadorOperacional, String strCodigoOperacionalJogo, String strDescOperacionalJogo) {
	
		this(strCodigoPaisCamp, strNomePaisCamp, strCodigoCamp, strNomeCamp, strAnoInicioTemp, strAnoFimTemp, intHomeScore, -1, -1, intAwayScore, -1, -1, strCodigoJogo, strCodigoFaseJogo, strDescFaseJogo, strCodigoTurnoJogo, strDescTurnoJogo, strCodigoRodadaJogo, strDescRodadaJogo, strCodigoGrupoJogo, strDescGrupoJogo, strDataJogo, intContadorOperacional, strCodigoOperacionalJogo, strDescOperacionalJogo);
		
	}

	public VJogo(String strCodigoPaisCamp, String strNomePaisCamp, String strCodigoCamp, String strNomeCamp, String strAnoInicioTemp, String strAnoFimTemp, int intHomeScore, int intHomeET, int intHomePK, int intAwayScore, int intAwayET, int intAwayPK, String strCodigoJogo, String strCodigoFaseJogo, String strDescFaseJogo, String strCodigoTurnoJogo, String strDescTurnoJogo, String strCodigoRodadaJogo, String strDescRodadaJogo, String strCodigoGrupoJogo, String strDescGrupoJogo, String strDataJogo, int intContadorOperacional, String strCodigoOperacionalJogo, String strDescOperacionalJogo) {
		
		this.strCodigoPaisCamp = strCodigoPaisCamp;
		this.strNomePaisCamp = strNomePaisCamp;
		this.strCodigoCamp = strCodigoCamp;
		this.strNomeCamp = strNomeCamp;
		
		this.strAnoInicioTemp = strAnoInicioTemp;
		this.strAnoFimTemp = strAnoFimTemp;
		
		this.intHomeScore = intHomeScore;
		this.intHomeET = intHomeET;
		this.intHomePK = intHomePK;
		
		this.intAwayScore = intAwayScore;
		this.intAwayET = intAwayET;
		this.intAwayPK = intAwayPK;
		
		this.strCodigoJogo = strCodigoJogo;
		this.strCodigoFaseJogo = strCodigoFaseJogo;
		this.strDescFaseJogo = strDescFaseJogo;
		this.strCodigoTurnoJogo = strCodigoTurnoJogo;
		this.strDescTurnoJogo = strDescTurnoJogo;
		this.strCodigoRodadaJogo = strCodigoRodadaJogo;
		this.strDescRodadaJogo = strDescRodadaJogo;
		this.strCodigoGrupoJogo = strCodigoGrupoJogo;
		this.strDescGrupoJogo = strDescGrupoJogo;
		this.strDataJogo = strDataJogo;
		
		this.intContadorOperacional = intContadorOperacional;
		this.strCodigoOperacionalJogo = strCodigoOperacionalJogo;
		this.strDescOperacionalJogo = strDescOperacionalJogo;
		
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
	
	public int getHomeScore() {
		return this.intHomeScore;
	}
	
	public int getHomeET() {
		return this.intHomeET;
	}
	
	public int getHomePK() {
		return this.intHomePK;
	}
		
	public int getAwayScore() {
		return this.intAwayScore;
	}
	
	public int getAwayET() {
		return this.intAwayET;
	}
	
	public int getAwayPK() {
		return this.intAwayPK;
	}
	
	public String getCodigoJogo() {
		return this.strCodigoJogo;
	}
	
	public String getCodigoFaseJogo() {
		return this.strCodigoFaseJogo;
	}
	
	public String getDescFaseJogo() {
		return this.strDescFaseJogo;
	}
	
	public String getCodigoTurnoJogo() {
		return this.strCodigoTurnoJogo;
	}
	
	public String getDescTurnoJogo() {
		return this.strDescTurnoJogo;
	}
	
	public String getCodigoRodadaJogo() {
		return this.strCodigoRodadaJogo;
	}
	
	public String getDescRodadaJogo() {
		return this.strDescRodadaJogo;
	}
	
	public String getCodigoGrupoJogo() {
		return this.strCodigoGrupoJogo;
	}
	
	public String getDescGrupoJogo() {
		return this.strDescGrupoJogo;
	}
	
	public String getDataJogo() {
		return this.strDataJogo;
	}
	
	public int getContadorOperacional() {
		return this.intContadorOperacional;
	}
	
	public String getCodigoOperacionalJogo() {
		return this.strCodigoOperacionalJogo;
	}
	
	public String getDescOperacionalJogo() {
		return this.strDescOperacionalJogo;
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
	
	public void setHomeScore(int intHomeScore) {
		this.intHomeScore = intHomeScore;
	}
	
	public void setHomeET(int intHomeET) {
		this.intHomeET = intHomeET;
	}
	
	public void setHomePK(int intHomePK) {
		this.intHomePK = intHomePK;
	}
	
	public void setAwayScore(int intAwayScore) {
		this.intAwayScore = intAwayScore;
	}
	
	public void setAwayET(int intAwayET) {
		this.intAwayET = intAwayET;
	}
	
	public void setAwayPK(int intAwayPK) {
		this.intAwayPK = intAwayPK;
	}
	
	public void setCodigoJogo(String strCodigoJogo) {
		this.strCodigoJogo = strCodigoJogo;
	}
	
	public void setCodigoFaseJogo(String strCodigoFaseJogo) {
		this.strCodigoFaseJogo = strCodigoFaseJogo;
	}
	
	public void setDescFaseJogo(String strDescFaseJogo) {
		this.strDescFaseJogo = strDescFaseJogo;
	}
	
	public void setCodigoTurnoJogo(String strCodigoTurnoJogo) {
		this.strCodigoTurnoJogo = strCodigoTurnoJogo;
	}
	
	public void setDescTurnoJogo(String strDescTurnoJogo) {
		this.strDescTurnoJogo = strDescTurnoJogo;
	}
	
	public void setCodigoRodadaJogo(String strCodigoRodadaJogo) {
		this.strCodigoRodadaJogo = strCodigoRodadaJogo;
	}
	
	public void setDescRodadaJogo(String strDescRodadaJogo) {
		this.strDescRodadaJogo = strDescRodadaJogo;
	}
	
	public void setCodigoGrupoJogo(String strCodigoGrupoJogo) {
		this.strCodigoGrupoJogo = strCodigoGrupoJogo;
	}
	
	public void setDescGrupoJogo(String strDescGrupoJogo) {
		this.strDescGrupoJogo = strDescGrupoJogo;
	}
	
	public void setDataJogo(String strDataJogo) {
		this.strDataJogo = strDataJogo;
	}
	
	public void setContadorOperacional(int intContadorOperacional) {
		this.intContadorOperacional = intContadorOperacional;
	}
	
	public void setCodigoOperacionalJogo(String strCodigoOperacionalJogo) {
		this.strCodigoOperacionalJogo = strCodigoOperacionalJogo;
	}
	
	public void setDescOperacionalJogo(String strDescOperacionalJogo) {
		this.strDescOperacionalJogo = strDescOperacionalJogo;
	}
	
}

