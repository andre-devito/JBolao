package jbolao.entity;

public class VPalpiteP extends VPalpite {
	
	private String strCodigoPaisHome;
	private String strNomePaisHome;
	
	private String strCodigoPaisAway;
	private String strNomePaisAway;
	
	public VPalpiteP() {
	
		this(null, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, null, null, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, null, null, null);
		
	}
	
	public VPalpiteP(String strCodigoPaisCamp, String strNomePaisCamp, String strCodigoCamp, String strNomeCamp, String strAnoInicioTemp, String strAnoFimTemp, String strNomeMesa, String strCodigoUsuario, String strCodigoPaisHome, String strNomePaisHome, int intHomeScore, int intPalpHomeScore, String strCodigoPaisAway, String strNomePaisAway, int intAwayScore, int intPalpAwayScore, int intPontos, String strCodigoJogo, String strCodigoFaseJogo, String strDescFaseJogo, String strCodigoTurnoJogo, String strDescTurnoJogo, String strCodigoRodadaJogo, String strDescRodadaJogo, String strCodigoGrupoJogo, String strDescGrupoJogo, String strDataJogo) {
	
		this(strCodigoPaisCamp, strNomePaisCamp, strCodigoCamp, strNomeCamp, strAnoInicioTemp, strAnoFimTemp, strNomeMesa, strCodigoUsuario, strCodigoPaisHome, strNomePaisHome, intHomeScore, intPalpHomeScore, 0, 0, 0, 0, strCodigoPaisAway, strNomePaisAway, intAwayScore, intPalpAwayScore, 0, 0, 0, 0, intPontos, strCodigoJogo, strCodigoFaseJogo, strDescFaseJogo, strCodigoTurnoJogo, strDescTurnoJogo, strCodigoRodadaJogo, strDescRodadaJogo, strCodigoGrupoJogo, strDescGrupoJogo, strDataJogo);
		
	}
	
	public VPalpiteP(String strCodigoPaisCamp, String strNomePaisCamp, String strCodigoCamp, String strNomeCamp, String strAnoInicioTemp, String strAnoFimTemp, String strNomeMesa, String strCodigoUsuario, String strCodigoPaisHome, String strNomePaisHome, int intHomeScore, int intPalpHomeScore, int intHomeET, int intPalpHomeET, int intHomePK, int intPalpHomePK, String strCodigoPaisAway, String strNomePaisAway, int intAwayScore, int intPalpAwayScore, int intAwayET, int intPalpAwayET, int intAwayPK, int intPalpAwayPK, int intPontos, String strCodigoJogo, String strCodigoFaseJogo, String strDescFaseJogo, String strCodigoTurnoJogo, String strDescTurnoJogo, String strCodigoRodadaJogo, String strDescRodadaJogo, String strCodigoGrupoJogo, String strDescGrupoJogo, String strDataJogo) {
	
		super(strCodigoPaisCamp, strNomePaisCamp, strCodigoCamp, strNomeCamp, strAnoInicioTemp, strAnoFimTemp, strNomeMesa, strCodigoUsuario, intHomeScore, intPalpHomeScore, intHomeET, intPalpHomeET, intHomePK, intPalpHomePK, intAwayScore, intPalpAwayScore, intAwayET, intPalpAwayET, intAwayPK, intPalpAwayPK, intPontos, strCodigoJogo, strCodigoFaseJogo, strDescFaseJogo, strCodigoTurnoJogo, strDescTurnoJogo, strCodigoRodadaJogo, strDescRodadaJogo, strCodigoGrupoJogo, strDescGrupoJogo, strDataJogo);
		
		this.strCodigoPaisHome = strCodigoPaisHome;
		this.strNomePaisHome = strNomePaisHome;
		
		this.strCodigoPaisAway = strCodigoPaisAway;
		this.strNomePaisAway = strNomePaisAway;
		
	}
	
	public String getCodigoPaisHome() {
		return this.strCodigoPaisHome;
	}
	
	public String getNomePaisHome() {
		return this.strNomePaisHome;
	}
	
	public String getCodigoPaisAway() {
		return this.strCodigoPaisAway;
	}
	
	public String getNomePaisAway() {
		return this.strNomePaisAway;
	}
	
	public void setCodigoPaisHome(String strCodigoPaisHome) {
		this.strCodigoPaisHome = strCodigoPaisHome;
	}
	
	public void setNomePaisHome(String strNomePaisHome) {
		this.strNomePaisHome = strNomePaisHome;
	}
	
	public void setCodigoPaisAway(String strCodigoPaisAway) {
		this.strCodigoPaisAway = strCodigoPaisAway;
	}
	
	public void setNomePaisAway(String strNomePaisAway) {
		this.strNomePaisAway = strNomePaisAway;
	}
	
}

