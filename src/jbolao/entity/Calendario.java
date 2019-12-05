package jbolao.entity;

import devito.dados.objetos.Objeto;

public class Calendario implements Objeto {
	
	private String strTimestamp;
	private String strDate;
	private String strTime;
	
	public Calendario() {
	
		this(null, null, null);
		
	}

	public Calendario(String strTimestamp, String strDate, String strTime) {
	
		this.strTimestamp = strTimestamp;
		this.strDate = strDate;
		this.strTime = strTime;
		
	}
	
	public String getTimestamp() {
		return this.strTimestamp;
	}
	
	public String getDate() {
		return this.strDate;
	}
	
	public String getTime() {
		return this.strTime;
	}
	
	public void setTimestamp(String strTimestamp) {
		this.strTimestamp = strTimestamp;
	}
	
	public void setDate(String strDate) {
		this.strDate = strDate;
	}
	
	public void setTime(String strTime) {
		this.strTime = strTime;
	}
	
}

