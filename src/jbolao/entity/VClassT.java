package jbolao.entity;

public class VClassT extends VClass {
	
	private String strCodigoPaisTime;
	private String strCodigoTime;
	private String strNomeTime;
	
	public VClassT() {
	
		this(null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
	}

	public VClassT(String strCodigoPaisCamp, String strNomePaisCamp, String strCodigoCamp, String strNomeCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoFaseJogo, String strCodigoGrupoJogo, String strCodigoPaisTime, String strCodigoTime, String strNomeTime, float fltMedia, int intEstat, int intPontosGanhos, int intJogos, int intVitorias, int intEmpates, int intDerrotas, int intGolsPro, int intGolsContra, int intSaldoGols) {
	
		super(strCodigoPaisCamp, strNomePaisCamp, strCodigoCamp, strNomeCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoFaseJogo, strCodigoGrupoJogo, fltMedia, intEstat, intPontosGanhos, intJogos, intVitorias, intEmpates, intDerrotas, intGolsPro, intGolsContra, intSaldoGols);
		
		this.strCodigoPaisTime = strCodigoPaisTime;
		this.strCodigoTime = strCodigoTime;
		this.strNomeTime = strNomeTime;
		
	}
	
	public String getCodigoPaisTime() {
		return this.strCodigoPaisTime;
	}
	
	public String getCodigoTime() {
		return this.strCodigoTime;
	}
	
	public String getNomeTime() {
		return this.strNomeTime;
	}
	
	public void setCodigoPaisTime(String strCodigoPaisTime) {
		this.strCodigoPaisTime = strCodigoPaisTime;
	}
	
	public void setCodigoTime(String strCodigoTime) {
		this.strCodigoTime = strCodigoTime;
	}
	
	public void setNomeTime(String strNomeTime) {
		this.strNomeTime = strNomeTime;
	}
	
}

