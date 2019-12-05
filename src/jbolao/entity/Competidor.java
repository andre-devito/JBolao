package jbolao.entity;

import devito.dados.objetos.Objeto;

public class Competidor implements Objeto {
	
	private int intSeqOper;
	private String strPerfilOper;
	
	private String strCodigoUsuario;
	private String strNomeMesa;
	
	private String strDataCompetidor;
	
	public Competidor() {
	
		this(0, null, null, null, null);
		
	}

	public Competidor(int intSeqOper, String strPerfilOper, String strCodigoUsuario, String strNomeMesa, String strDataCompetidor) {
	
		this.intSeqOper = intSeqOper;
		this.strPerfilOper = strPerfilOper;
		
		this.strCodigoUsuario = strCodigoUsuario;
		this.strNomeMesa = strNomeMesa;
		
		this.strDataCompetidor  = strDataCompetidor;
		
	}
	
	public int getSeqOper() {
		return this.intSeqOper;
	}
	
	public String getPerfilOper() {
		return this.strPerfilOper;
	}
	
	public String getCodigoUsuario() {
		return this.strCodigoUsuario;
	}
	
	public String getNomeMesa() {
		return this.strNomeMesa;
	}
	
	public String getDataCompetidor() {
		return this.strDataCompetidor;
	}
	
	public void setSeqOper(int intSeqOper) {
		this.intSeqOper = intSeqOper;
	}
	
	public void setPerfilOper(String strPerfilOper) {
		this.strPerfilOper = strPerfilOper;
	}
	
	public void setCodigoUsuario(String strCodigoUsuario) {
		this.strCodigoUsuario = strCodigoUsuario;
	}
	
	public void setNomeMesa(String strNomeMesa) {
		this.strNomeMesa = strNomeMesa;
	}
	
	public void setDataCompetidor(String strDataCompetidor) {
		this.strDataCompetidor = strDataCompetidor;
	}
	
}

