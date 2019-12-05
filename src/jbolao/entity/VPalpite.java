package jbolao.entity;

import devito.dados.objetos.Objeto;

public abstract class VPalpite implements Objeto {

	private String strCodigoPaisCamp;
	private String strNomePaisCamp;
	private String strCodigoCamp;
	private String strNomeCamp;
	
	private String strAnoInicioTemp;
	private String strAnoFimTemp;
	
	private String strNomeMesa;
	private String strCodigoUsuario;
	
	private int intHomeScore = -1;
	private int intPalpHomeScore = -1;
	private int intHomeET = -1;
	private int intPalpHomeET = -1;
	private int intHomePK = -1;
	private int intPalpHomePK = -1;
	
	private int intAwayScore = -1;
	private int intPalpAwayScore = -1;
	private int intAwayET = -1;
	private int intPalpAwayET = -1;
	private int intAwayPK = -1;
	private int intPalpAwayPK = -1;
	
	private int intPontos;
	
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
	
	public VPalpite() {
	
		this(null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, null, null, null);
		
	}
	
	public VPalpite(String strCodigoPaisCamp, String strNomePaisCamp, String strCodigoCamp, String strNomeCamp, String strAnoInicioTemp, String strAnoFimTemp, String strNomeMesa, String strCodigoUsuario, int intHomeScore, int intPalpHomeScore, int intAwayScore, int intPalpAwayScore, int intPontos, String strCodigoJogo, String strCodigoFaseJogo, String strDescFaseJogo, String strCodigoTurnoJogo, String strDescTurnoJogo, String strCodigoRodadaJogo, String strDescRodadaJogo, String strCodigoGrupoJogo, String strDescGrupoJogo, String strDataJogo) {
	
		this(strCodigoPaisCamp, strNomePaisCamp, strCodigoCamp, strNomeCamp, strAnoInicioTemp, strAnoFimTemp, strNomeMesa, strCodigoUsuario, intHomeScore, intPalpHomeScore, 0, 0, 0, 0, intAwayScore, intPalpAwayScore, 0, 0, 0, 0, intPontos, strCodigoJogo, strCodigoFaseJogo, strDescFaseJogo, strCodigoTurnoJogo, strDescTurnoJogo, strCodigoRodadaJogo, strDescRodadaJogo, strCodigoGrupoJogo, strDescGrupoJogo, strDataJogo);
		
	}
	
	public VPalpite(String strCodigoPaisCamp, String strNomePaisCamp, String strCodigoCamp, String strNomeCamp, String strAnoInicioTemp, String strAnoFimTemp, String strNomeMesa, String strCodigoUsuario, int intHomeScore, int intPalpHomeScore, int intHomeET, int intPalpHomeET, int intHomePK, int intPalpHomePK, int intAwayScore, int intPalpAwayScore, int intAwayET, int intPalpAwayET, int intAwayPK, int intPalpAwayPK, int intPontos, String strCodigoJogo, String strCodigoFaseJogo, String strDescFaseJogo, String strCodigoTurnoJogo, String strDescTurnoJogo, String strCodigoRodadaJogo, String strDescRodadaJogo, String strCodigoGrupoJogo, String strDescGrupoJogo, String strDataJogo) {
		
		this.strCodigoPaisCamp = strCodigoPaisCamp;
		this.strNomePaisCamp = strNomePaisCamp;
		this.strCodigoCamp = strCodigoCamp;
		this.strNomeCamp = strNomeCamp;
		
		this.strAnoInicioTemp = strAnoInicioTemp;
		this.strAnoFimTemp = strAnoFimTemp;
		
		this.strNomeMesa = strNomeMesa;
		this.strCodigoUsuario = strCodigoUsuario;
		
		this.intHomeScore = intHomeScore;
		this.intPalpHomeScore = intPalpHomeScore;
		this.intHomeET = intHomeET;
		this.intPalpHomeET = intPalpHomeET;
		this.intHomePK = intHomePK;
		this.intPalpHomePK = intPalpHomePK;
		
		this.intAwayScore = intAwayScore;
		this.intPalpAwayScore = intPalpAwayScore;
		this.intAwayET = intAwayET;
		this.intPalpAwayET = intPalpAwayET;
		this.intAwayPK = intAwayPK;
		this.intPalpAwayPK = intPalpAwayPK;
		
		this.intPontos = intPontos;
		
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
	
	public int getHomeScore() {
		return this.intHomeScore;
	}
	
	public int getPalpHomeScore() {
		return this.intPalpHomeScore;
	}
	
	public int getHomeET() {
		return this.intHomeET;
	}
	
	public int getPalpHomeET() {
		return this.intPalpHomeET;
	}
	
	public int getHomePK() {
		return this.intHomePK;
	}
	
	public int getPalpHomePK() {
		return this.intPalpHomePK;
	}
	
	public int getAwayScore() {
		return this.intAwayScore;
	}
	
	public int getPalpAwayScore() {
		return this.intPalpAwayScore;
	}
	
	public int getAwayET() {
		return this.intAwayET;
	}
	
	public int getPalpAwayET() {
		return this.intPalpAwayET;
	}
	
	public int getAwayPK() {
		return this.intAwayPK;
	}
	
	public int getPalpAwayPK() {
		return this.intPalpAwayPK;
	}
	
	public int getPontos() {
		return this.intPontos;
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
	
	public void setHomeScore(int intHomeScore) {
		this.intHomeScore = intHomeScore;
	}
	
	public void setPalpHomeScore(int intPalpHomeScore) {
		this.intPalpHomeScore = intPalpHomeScore;
	}
	
	public void setHomeET(int intHomeET) {
		this.intHomeET = intHomeET;
	}
	
	public void setPalpHomeET(int intPalpHomeET) {
		this.intPalpHomeET = intPalpHomeET;
	}
	
	public void setHomePK(int intHomePK) {
		this.intHomePK = intHomePK;
	}
	
	public void setPalpHomePK(int intPalpHomePK) {
		this.intPalpHomePK = intPalpHomePK;
	}
	
	public void setAwayScore(int intAwayScore) {
		this.intAwayScore = intAwayScore;
	}
	
	public void setPalpAwayScore(int intPalpAwayScore) {
		this.intPalpAwayScore = intPalpAwayScore;
	}
	
	public void setAwayET(int intAwayET) {
		this.intAwayET = intAwayET;
	}
	
	public void setPalpAwayET(int intPalpAwayET) {
		this.intPalpAwayET = intPalpAwayET;
	}
	
	public void setAwayPK(int intAwayPK) {
		this.intAwayPK = intAwayPK;
	}
	
	public void setPalpAwayPK(int intPalpAwayPK) {
		this.intPalpAwayPK = intPalpAwayPK;
	}
	
	public void setPontos(int intPontos) {
		this.intPontos = intPontos;
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
	
}

