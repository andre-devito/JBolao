package jbolao.entity;

public class VPartT extends VPart {
	
	private String strCodigoPaisTime;
	private String strCodigoTime;
	private String strNomeTime;
	
	public VPartT() {
	
		this(null, null, null, null, null, null, null, null, null);
		
	}

	public VPartT(String strCodigoPaisCamp, String strNomePaisCamp, String strCodigoCamp, String strNomeCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoPaisTime, String strCodigoTime, String strNomeTime) {
	
		super(strCodigoPaisCamp, strNomePaisCamp, strCodigoCamp, strNomeCamp, strAnoInicioTemp, strAnoFimTemp);
		
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

