package jbolao.entity;

public class VPalpiteT extends VPalpite {
	
	private String strCodigoPaisHome;
	private String strCodigoTimeHome;
	private String strNomeTimeHome;
	
	private String strCodigoPaisAway;
	private String strCodigoTimeAway;
	private String strNomeTimeAway;
	
	public VPalpiteT() {
	
		this(null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, null, null, null, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, null, null, null);
		
	}
	
	public VPalpiteT(String strCodigoPaisCamp, String strNomePaisCamp, String strCodigoCamp, String strNomeCamp, String strAnoInicioTemp, String strAnoFimTemp, String strNomeMesa, String strCodigoUsuario, String strCodigoPaisHome, String strCodigoTimeHome, String strNomeTimeHome, int intHomeScore, int intPalpHomeScore, String strCodigoPaisAway, String strCodigoTimeAway, String strNomeTimeAway, int intAwayScore, int intPalpAwayScore, int intPontos, String strCodigoJogo, String strCodigoFaseJogo, String strDescFaseJogo, String strCodigoTurnoJogo, String strDescTurnoJogo, String strCodigoRodadaJogo, String strDescRodadaJogo, String strCodigoGrupoJogo, String strDescGrupoJogo, String strDataJogo) {
	
		this(strCodigoPaisCamp, strNomePaisCamp, strCodigoCamp, strNomeCamp, strAnoInicioTemp, strAnoFimTemp, strNomeMesa, strCodigoUsuario, strCodigoPaisHome, strCodigoTimeHome, strNomeTimeHome, intHomeScore, intPalpHomeScore, 0, 0, 0, 0, strCodigoPaisAway, strCodigoTimeAway, strNomeTimeAway, intAwayScore, intPalpAwayScore, 0, 0, 0, 0, intPontos, strCodigoJogo, strCodigoFaseJogo, strDescFaseJogo, strCodigoTurnoJogo, strDescTurnoJogo, strCodigoRodadaJogo, strDescRodadaJogo, strCodigoGrupoJogo, strDescGrupoJogo, strDataJogo);
		
	}
	
	public VPalpiteT(String strCodigoPaisCamp, String strNomePaisCamp, String strCodigoCamp, String strNomeCamp, String strAnoInicioTemp, String strAnoFimTemp, String strNomeMesa, String strCodigoUsuario, String strCodigoPaisHome, String strCodigoTimeHome, String strNomeTimeHome, int intHomeScore, int intPalpHomeScore, int intHomeET, int intPalpHomeET, int intHomePK, int intPalpHomePK, String strCodigoPaisAway, String strCodigoTimeAway, String strNomeTimeAway, int intAwayScore, int intPalpAwayScore, int intAwayET, int intPalpAwayET, int intAwayPK, int intPalpAwayPK, int intPontos, String strCodigoJogo, String strCodigoFaseJogo, String strDescFaseJogo, String strCodigoTurnoJogo, String strDescTurnoJogo, String strCodigoRodadaJogo, String strDescRodadaJogo, String strCodigoGrupoJogo, String strDescGrupoJogo, String strDataJogo) {
	
		super(strCodigoPaisCamp, strNomePaisCamp, strCodigoCamp, strNomeCamp, strAnoInicioTemp, strAnoFimTemp, strNomeMesa, strCodigoUsuario, intHomeScore, intPalpHomeScore, intHomeET, intPalpHomeET, intHomePK, intPalpHomePK, intAwayScore, intPalpAwayScore, intAwayET, intPalpAwayET, intAwayPK, intPalpAwayPK, intPontos, strCodigoJogo, strCodigoFaseJogo, strDescFaseJogo, strCodigoTurnoJogo, strDescTurnoJogo, strCodigoRodadaJogo, strDescRodadaJogo, strCodigoGrupoJogo, strDescGrupoJogo, strDataJogo);
	
		this.strCodigoPaisHome = strCodigoPaisHome;
		this.strCodigoTimeHome = strCodigoTimeHome;
		this.strNomeTimeHome = strNomeTimeHome;
		
		this.strCodigoPaisAway = strCodigoPaisAway;
		this.strCodigoTimeAway = strCodigoTimeAway;
		this.strNomeTimeAway = strNomeTimeAway;
		
	}
	
	public String getCodigoPaisHome() {
		return this.strCodigoPaisHome;
	}
	
	public String getCodigoTimeHome() {
		return this.strCodigoTimeHome;
	}
	
	public String getNomeTimeHome() {
		return this.strNomeTimeHome;
	}
	
	public String getCodigoPaisAway() {
		return this.strCodigoPaisAway;
	}
	
	public String getCodigoTimeAway() {
		return this.strCodigoTimeAway;
	}
	
	public String getNomeTimeAway() {
		return this.strNomeTimeAway;
	}
	
	public void setCodigoPaisHome(String strCodigoPaisHome) {
		this.strCodigoPaisHome = strCodigoPaisHome;
	}
	
	public void setCodigoTimeHome(String strCodigoTimeHome) {
		this.strCodigoTimeHome = strCodigoTimeHome;
	}
	
	public void setNomeTimeHome(String strNomeTimeHome) {
		this.strNomeTimeHome = strNomeTimeHome;
	}
	
	public void setCodigoPaisAway(String strCodigoPaisAway) {
		this.strCodigoPaisAway = strCodigoPaisAway;
	}
	
	public void setCodigoTimeAway(String strCodigoTimeAway) {
		this.strCodigoTimeAway = strCodigoTimeAway;
	}
	
	public void setNomeTimeAway(String strNomeTimeAway) {
		this.strNomeTimeAway = strNomeTimeAway;
	}
	
}

