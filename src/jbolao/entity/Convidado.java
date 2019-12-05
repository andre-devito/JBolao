package jbolao.entity;

import devito.dados.objetos.Objeto;

public class Convidado implements Objeto {
	
	private int intSeqOper;
	
	private String strCodigoUsuario;
	private String strNomeMesa;
	
	private String strDataConvidado;
	
	public Convidado() {
	
		this(0, null, null, null);
		
	}

	public Convidado(int intSeqOper, String strCodigoUsuario, String strNomeMesa, String strDataConvidado) {
	
		this.intSeqOper = intSeqOper;
		
		this.strCodigoUsuario = strCodigoUsuario;
		this.strNomeMesa = strNomeMesa;
		
		this.strDataConvidado  = strDataConvidado;
		
	}
	
	public int getSeqOper() {
		return this.intSeqOper;
	}
	
	public String getCodigoUsuario() {
		return this.strCodigoUsuario;
	}
	
	public String getNomeMesa() {
		return this.strNomeMesa;
	}
	
	public String getDataConvidado() {
		return this.strDataConvidado;
	}
	
	public void setSeqOper(int intSeqOper) {
		this.intSeqOper = intSeqOper;
	}
	
	public void setCodigoUsuario(String strCodigoUsuario) {
		this.strCodigoUsuario = strCodigoUsuario;
	}
	
	public void setNomeMesa(String strNomeMesa) {
		this.strNomeMesa = strNomeMesa;
	}
	
	public void setDataConvidado(String strDataConvidado) {
		this.strDataConvidado = strDataConvidado;
	}
	
}

