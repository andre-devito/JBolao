package jbolao.entity;

public class VClassP extends VClass {
	
	private String strCodigoPaisP;
	private String strNomePaisP;
	
	public VClassP() {
	
		this(null, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
	}

	public VClassP(String strCodigoPaisCamp, String strNomePaisCamp, String strCodigoCamp, String strNomeCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoFaseJogo, String strCodigoGrupoJogo, String strCodigoPaisP, String strNomePaisP, float fltMedia, int intEstat, int intPontosGanhos, int intJogos, int intVitorias, int intEmpates, int intDerrotas, int intGolsPro, int intGolsContra, int intSaldoGols) {
	
		super(strCodigoPaisCamp, strNomePaisCamp, strCodigoCamp, strNomeCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoFaseJogo, strCodigoGrupoJogo, fltMedia, intEstat, intPontosGanhos, intJogos, intVitorias, intEmpates, intDerrotas, intGolsPro, intGolsContra, intSaldoGols);
		
		this.strCodigoPaisP = strCodigoPaisP;
		this.strNomePaisP = strNomePaisP;
		
	}
	
	public String getCodigoPaisP() {
		return this.strCodigoPaisP;
	}
	
	public String getNomePaisP() {
		return this.strNomePaisP;
	}
	
	public void setCodigoPaisP(String strCodigoPaisP) {
		this.strCodigoPaisP = strCodigoPaisP;
	}
	
	public void setNomePaisP(String strNomePaisP) {
		this.strNomePaisP = strNomePaisP;
	}
	
}

