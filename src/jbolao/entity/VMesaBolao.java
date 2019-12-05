package jbolao.entity;

import devito.dados.objetos.Objeto;

public class VMesaBolao implements Objeto {

	private int intSeqOper;
	private String strPerfilOper;
	
	private String strNomeMesa;
	private int intSeqTempr;
	private String strUsuarioCampeao;
	private String strUsuarioVice;
	private String strUsuarioTerceiro;
	private String strUsuarioQuarto;
	
	private String strCodigoUsuario;
	private String strNomeUsuario;
	
	private String strCodigoPaisCampeonato;
	private String strCodigoCampeonato;
	private String strAnoInicioTemporada;
	private String strAnoFimTemporada;
	
	public VMesaBolao() {
	
		this(0, null, null, 0, null, null, null, null, null, null, null, null, null, null);
		
	}

	public VMesaBolao(int intSeqOper, String strPerfilOper, String strNomeMesa, int intSeqTempr, String strUsuarioCampeao, String strUsuarioVice, String strUsuarioTerceiro, String strUsuarioQuarto, String strCodigoUsuario, String strNomeUsuario, String strCodigoPaisCampeonato, String strCodigoCampeonato, String strAnoInicioTemporada, String strAnoFimTemporada) {
	
		this.intSeqOper = intSeqOper;
		this.strPerfilOper = strPerfilOper;
		
		this.strNomeMesa = strNomeMesa;
		this.intSeqTempr = intSeqTempr;
		this.strUsuarioCampeao = strUsuarioCampeao;
		this.strUsuarioVice = strUsuarioVice;
		this.strUsuarioTerceiro = strUsuarioTerceiro;
		this.strUsuarioQuarto = strUsuarioQuarto;
		
		this.strCodigoUsuario = strCodigoUsuario;
		this.strNomeUsuario = strNomeUsuario;
		
		this.strCodigoPaisCampeonato = strCodigoPaisCampeonato;
		this.strCodigoCampeonato = strCodigoCampeonato;
		this.strAnoInicioTemporada = strAnoInicioTemporada;
		this.strAnoFimTemporada = strAnoFimTemporada;
		
	}
	
	public int getSeqOper() {
		return this.intSeqOper;
	}
	
	public String getPerfilOper() {
		return this.strPerfilOper;
	}
	
	public String getNomeMesa() {
		return this.strNomeMesa;
	}
	
	public int getSeqTempr() {
		return this.intSeqTempr;
	}
	
	public String getUsuarioCampeao() {
		return this.strUsuarioCampeao;
	}
	
	public String getUsuarioVice() {
		return this.strUsuarioVice;
	}
	
	public String getUsuarioTerceiro() {
		return this.strUsuarioTerceiro;
	}
	
	public String getUsuarioQuarto() {
		return this.strUsuarioQuarto;
	}
	
	public String getCodigoUsuario() {
		return this.strCodigoUsuario;
	}
	
	public String getNomeUsuario() {
		return this.strNomeUsuario;
	}
	
	public String getCodigoPaisCampeonato() {
		return this.strCodigoPaisCampeonato;
	}
	
	public String getCodigoCampeonato() {
		return this.strCodigoCampeonato;
	}
	
	public String getAnoInicioTemporada() {
		return this.strAnoInicioTemporada;
	}
	
	public String getAnoFimTemporada() {
		return this.strAnoFimTemporada;
	}
	
	public void setSeqOper(int intSeqOper) {
		this.intSeqOper = intSeqOper;
	}
	
	public void setPerfilOper(String strPerfilOper) {
		this.strPerfilOper = strPerfilOper;
	}
	
	public void setNomeMesa(String strNomeMesa) {
		this.strNomeMesa = strNomeMesa;
	}
	
	public void setSeqTempr(int intSeqTempr) {
		this.intSeqTempr = intSeqTempr;
	}
	
	public void setUsuarioCampeao(String strUsuarioCampeao) {
		this.strUsuarioCampeao = strUsuarioCampeao;
	}
	
	public void setUsuarioVice(String strUsuarioVice) {
		this.strUsuarioVice = strUsuarioVice;
	}
	
	public void setUsuarioTerceiro(String strUsuarioTerceiro) {
		this.strUsuarioTerceiro = strUsuarioTerceiro;
	}
	
	public void setUsuarioQuarto(String strUsuarioQuarto) {
		this.strUsuarioQuarto = strUsuarioQuarto;
	}
	
	public void setCodigoUsuario(String strCodigoUsuario) {
		this.strCodigoUsuario = strCodigoUsuario;
	}
	
	public void setNomeUsuario(String strNomeUsuario) {
		this.strNomeUsuario = strNomeUsuario;
	}
	
	public void setCodigoPaisCampeonato(String strCodigoPaisCampeonato) {
		this.strCodigoPaisCampeonato = strCodigoPaisCampeonato;
	}
	
	public void setCodigoCampeonato(String strCodigoCampeonato) {
		this.strCodigoCampeonato = strCodigoCampeonato;
	}
	
	public void setAnoInicioTemporada(String strAnoInicioTemporada) {
		this.strAnoInicioTemporada = strAnoInicioTemporada;
	}
	
	public void setAnoFimTemporada(String strAnoFimTemporada) {
		this.strAnoFimTemporada = strAnoFimTemporada;
	}
	
}

