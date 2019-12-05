package jbolao.entity;

public class VJogoT extends VJogo {
	
	private String strCodigoPaisHome;
	private String strCodigoTimeHome;
	private String strNomeTimeHome;
	
	private String strCodigoPaisAway;
	private String strCodigoTimeAway;
	private String strNomeTimeAway;
	
	public VJogoT() {
	
		this(null, null, null, null, null, null, null, null, null, -1, -1, -1, null, null, null, -1, -1, -1, null, null, null, null, null, null, null, null, null, null, 0, null, null);
		
	}
	
	public VJogoT(String strCodigoPaisCamp, String strNomePaisCamp, String strCodigoCamp, String strNomeCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoPaisHome, String strCodigoTimeHome, String strNomeTimeHome, int intHomeScore, String strCodigoPaisAway, String strCodigoTimeAway, String strNomeTimeAway, int intAwayScore, String strCodigoJogo, String strCodigoFaseJogo, String strDescFaseJogo, String strCodigoTurnoJogo, String strDescTurnoJogo, String strCodigoRodadaJogo, String strDescRodadaJogo, String strCodigoGrupoJogo, String strDescGrupoJogo, String strDataJogo, int intContadorOperacional, String strCodigoOperacionalJogo, String strDescOperacionalJogo) {
	
		this(strCodigoPaisCamp, strNomePaisCamp, strCodigoCamp, strNomeCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoPaisHome, strCodigoTimeHome, strNomeTimeHome, intHomeScore, -1, -1, strCodigoPaisAway, strCodigoTimeAway, strNomeTimeAway, intAwayScore, -1, -1, strCodigoJogo, strCodigoFaseJogo, strDescFaseJogo, strCodigoTurnoJogo, strDescTurnoJogo, strCodigoRodadaJogo, strDescRodadaJogo, strCodigoGrupoJogo, strDescGrupoJogo, strDataJogo, intContadorOperacional, strCodigoOperacionalJogo, strDescOperacionalJogo);
		
	}

	public VJogoT(String strCodigoPaisCamp, String strNomePaisCamp, String strCodigoCamp, String strNomeCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoPaisHome, String strCodigoTimeHome, String strNomeTimeHome, int intHomeScore, int intHomeET, int intHomePK, String strCodigoPaisAway, String strCodigoTimeAway, String strNomeTimeAway, int intAwayScore, int intAwayET, int intAwayPK, String strCodigoJogo, String strCodigoFaseJogo, String strDescFaseJogo, String strCodigoTurnoJogo, String strDescTurnoJogo, String strCodigoRodadaJogo, String strDescRodadaJogo, String strCodigoGrupoJogo, String strDescGrupoJogo, String strDataJogo, int intContadorOperacional, String strCodigoOperacionalJogo, String strDescOperacionalJogo) {
	
		super(strCodigoPaisCamp, strNomePaisCamp, strCodigoCamp, strNomeCamp, strAnoInicioTemp, strAnoFimTemp, intHomeScore, intHomeET, intHomePK, intAwayScore, intAwayET, intAwayPK, strCodigoJogo, strCodigoFaseJogo, strDescFaseJogo, strCodigoTurnoJogo, strDescTurnoJogo, strCodigoRodadaJogo, strDescRodadaJogo, strCodigoGrupoJogo, strDescGrupoJogo, strDataJogo, intContadorOperacional, strCodigoOperacionalJogo, strDescOperacionalJogo);
		
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

