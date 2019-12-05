package jbolao.entity;

public class VPartP extends VPart {
	
	private String strCodigoPaisP;
	private String strNomePaisP;
	
	public VPartP() {
	
		this(null, null, null, null, null, null, null, null);
		
	}

	public VPartP(String strCodigoPaisCamp, String strNomePaisCamp, String strCodigoCamp, String strNomeCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoPaisP, String strNomePaisP) {
	
		super(strCodigoPaisCamp, strNomePaisCamp, strCodigoCamp, strNomeCamp, strAnoInicioTemp, strAnoFimTemp);
		
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

