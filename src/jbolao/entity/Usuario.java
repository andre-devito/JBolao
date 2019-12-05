package jbolao.entity;

import devito.dados.objetos.Objeto;

public class Usuario implements Objeto {
	
	private String strCodigo;
	private String strSenha;
	private String strNome;
	private String strMail;
	private String strIP;
	private String strSituacao;
	private String strPerfil;
	private String strNascimento;
	
	public Usuario() {
	
		this(null, null, null, null, null, null, null, null);
		
	}

	public Usuario(String strCodigo, String strSenha, String strNome, String strMail, String strIP, String strSituacao, String strPerfil, String strNascimento) {
	
		this.strCodigo = strCodigo;
		this.strSenha = strSenha;
		this.strNome = strNome;
		this.strMail = strMail;
		this.strIP = strIP;
		this.strSituacao = strSituacao;
		this.strPerfil = strPerfil;
		this.strNascimento = strNascimento;
		
	}
	
	public String getCodigo() {
		return this.strCodigo;
	}
	
	public String getSenha() {
		return this.strSenha;
	}
	
	public String getNome() {
		return this.strNome;
	}
	
	public String getMail() {
		return this.strMail;
	}
	
	public String getIP() {
		return this.strIP;
	}
	
	public String getSituacao() {
		return this.strSituacao;
	}
	
	public String getPerfil() {
		return this.strPerfil;
	}
	
	public String getNascimento() {
		return this.strNascimento;
	}
	
	public void setCodigo(String strCodigo) {
		this.strCodigo = strCodigo;
	}
	
	public void setSenha(String strSenha) {
		this.strSenha = strSenha;
	}
	
	public void setNome(String strNome) {
		this.strNome = strNome;
	}
	
	public void setMail(String strMail) {
		this.strMail = strMail;
	}
	
	public void setIP(String strIP) {
		this.strIP = strIP;
	}
	
	public void setSituacao(String strSituacao) {
		this.strSituacao = strSituacao;
	}
	
	public void setPerfil(String strPerfil) {
		this.strPerfil = strPerfil;
	}
	
	public void setNascimento(String strNascimento) {
		this.strNascimento = strNascimento;
	}
	
}

