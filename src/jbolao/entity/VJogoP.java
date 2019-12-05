package jbolao.entity;

public class VJogoP extends VJogo {

	private String strCodigoPaisHome;
	private String strNomePaisHome;
	
	private String strCodigoPaisAway;
	private String strNomePaisAway;
	
	public VJogoP() {
	
		this(null, null, null, null, null, null, null, null, -1, -1, -1, null, null, -1, -1, -1, null, null, null, null, null, null, null, null, null, null, 0, null, null);
		
	}
	
	public VJogoP(String strCodigoPaisCamp, String strNomePaisCamp, String strCodigoCamp, String strNomeCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoPaisHome, String strNomePaisHome, int intHomeScore, String strCodigoPaisAway, String strNomePaisAway, int intAwayScore, String strCodigoJogo, String strCodigoFaseJogo, String strDescFaseJogo, String strCodigoTurnoJogo, String strDescTurnoJogo, String strCodigoRodadaJogo, String strDescRodadaJogo, String strCodigoGrupoJogo, String strDescGrupoJogo, String strDataJogo, int intContadorOperacional, String strCodigoOperacionalJogo, String strDescOperacionalJogo) {
	
		this(strCodigoPaisCamp, strNomePaisCamp, strCodigoCamp, strNomeCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoPaisHome, strNomePaisHome, intHomeScore, -1, -1, strCodigoPaisAway, strNomePaisAway, intAwayScore, -1, -1, strCodigoJogo, strCodigoFaseJogo, strDescFaseJogo, strCodigoTurnoJogo, strDescTurnoJogo, strCodigoRodadaJogo, strDescRodadaJogo, strCodigoGrupoJogo, strDescGrupoJogo, strDataJogo, intContadorOperacional, strCodigoOperacionalJogo, strDescOperacionalJogo);
		
	}

	public VJogoP(String strCodigoPaisCamp, String strNomePaisCamp, String strCodigoCamp, String strNomeCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoPaisHome, String strNomePaisHome, int intHomeScore, int intHomeET, int intHomePK, String strCodigoPaisAway, String strNomePaisAway, int intAwayScore, int intAwayET, int intAwayPK, String strCodigoJogo, String strCodigoFaseJogo, String strDescFaseJogo, String strCodigoTurnoJogo, String strDescTurnoJogo, String strCodigoRodadaJogo, String strDescRodadaJogo, String strCodigoGrupoJogo, String strDescGrupoJogo, String strDataJogo, int intContadorOperacional, String strCodigoOperacionalJogo, String strDescOperacionalJogo) {
	
		super(strCodigoPaisCamp, strNomePaisCamp, strCodigoCamp, strNomeCamp, strAnoInicioTemp, strAnoFimTemp, intHomeScore, intHomeET, intHomePK, intAwayScore, intAwayET, intAwayPK, strCodigoJogo, strCodigoFaseJogo, strDescFaseJogo, strCodigoTurnoJogo, strDescTurnoJogo, strCodigoRodadaJogo, strDescRodadaJogo, strCodigoGrupoJogo, strDescGrupoJogo, strDataJogo, intContadorOperacional, strCodigoOperacionalJogo, strDescOperacionalJogo);
		
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

