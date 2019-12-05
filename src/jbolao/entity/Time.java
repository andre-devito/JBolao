package jbolao.entity;

import devito.dados.objetos.Objeto;

public class Time implements Objeto {
	
	private String strCodigoPaisTime;
	private String strCodigoTime;
	private String strNomeTime;
	
	public Time() {
	
		this(null, null, null);
		
	}

	public Time(String strCodigoPaisTime, String strCodigoTime, String strNomeTime) {
	
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

