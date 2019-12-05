package jbolao.entity;

import devito.dados.objetos.Objeto;

public class VTemp implements Objeto {

	private String strCodigoPaisCampeonato;
	private String strNomePaisCampeonato;
	private String strCodigoCampeonato;
	private String strNomeCampeonato;
	
	private String strAnoInicioTemporada;
	private String strAnoFimTemporada;
	
	private int intContadorTemp;
	
	private String strCodigoPaisCampeao;
	private String strNomePaisCampeao;
	private String strCodigoTimeCampeao;
	private String strNomeTimeCampeao;
	
	private String strCodigoPaisVice;
	private String strNomePaisVice;
	private String strCodigoTimeVice;
	private String strNomeTimeVice;
	
	private String strCodigoPaisTerceiro;
	private String strNomePaisTerceiro;
	private String strCodigoTimeTerceiro;
	private String strNomeTimeTerceiro;
	
	private String strCodigoPaisQuarto;
	private String strNomePaisQuarto;
	private String strCodigoTimeQuarto;
	private String strNomeTimeQuarto;
	
	public VTemp() {
	
		this(null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
	}

	public VTemp(String strCodigoPaisCampeonato, String strNomePaisCampeonato, String strCodigoCampeonato, String strNomeCampeonato, String strAnoInicioTemporada, String strAnoFimTemporada, int intContadorTemp, String strCodigoPaisCampeao, String strNomePaisCampeao, String strCodigoTimeCampeao, String strNomeTimeCampeao, String strCodigoPaisVice, String strNomePaisVice, String strCodigoTimeVice, String strNomeTimeVice, String strCodigoPaisTerceiro, String strNomePaisTerceiro, String strCodigoTimeTerceiro, String strNomeTimeTerceiro, String strCodigoPaisQuarto, String strNomePaisQuarto, String strCodigoTimeQuarto, String strNomeTimeQuarto) {
	
		this.strCodigoPaisCampeonato = strCodigoPaisCampeonato;
		this.strNomePaisCampeonato = strNomePaisCampeonato;
		this.strCodigoCampeonato = strCodigoCampeonato;
		this.strNomeCampeonato = strNomeCampeonato;
		
		this.strAnoInicioTemporada = strAnoInicioTemporada;
		this.strAnoFimTemporada = strAnoFimTemporada;
		
		this.intContadorTemp = intContadorTemp;
		
		this.strCodigoPaisCampeao = strCodigoPaisCampeao;
		this.strNomePaisCampeao = strNomePaisCampeao;
		this.strCodigoTimeCampeao = strCodigoTimeCampeao;
		this.strNomeTimeCampeao = strNomeTimeCampeao;
		
		this.strCodigoPaisVice = strCodigoPaisVice;
		this.strNomePaisVice = strNomePaisVice;
		this.strCodigoTimeVice = strCodigoTimeVice;
		this.strNomeTimeVice = strNomeTimeVice;
		
		this.strCodigoPaisTerceiro = strCodigoPaisTerceiro;
		this.strNomePaisTerceiro = strNomePaisTerceiro;
		this.strCodigoTimeTerceiro = strCodigoTimeTerceiro;
		this.strNomeTimeTerceiro = strNomeTimeTerceiro;
		
		this.strCodigoPaisQuarto = strCodigoPaisQuarto;
		this.strNomePaisQuarto = strNomePaisQuarto;
		this.strCodigoTimeQuarto = strCodigoTimeQuarto;
		this.strNomeTimeQuarto = strNomeTimeQuarto;
		
	}
	
	public String getCodigoPaisCampeonato() {
		return this.strCodigoPaisCampeonato;
	}
	
	public String getNomePaisCampeonato() {
		return this.strNomePaisCampeonato;
	}
	
	public String getCodigoCampeonato() {
		return this.strCodigoCampeonato;
	}
	
	public String getNomeCampeonato() {
		return this.strNomeCampeonato;
	}
	
	public String getAnoInicioTemporada() {
		return this.strAnoInicioTemporada;
	}
	
	public String getAnoFimTemporada() {
		return this.strAnoFimTemporada;
	}
	
	public int getContadorTemp() {
		return this.intContadorTemp;
	}
	
	public String getCodigoPaisCampeao() {
		return this.strCodigoPaisCampeao;
	}
	
	public String getNomePaisCampeao() {
		return this.strNomePaisCampeao;
	}
	
	public String getCodigoTimeCampeao() {
		return this.strCodigoTimeCampeao;
	}
	
	public String getNomeTimeCampeao() {
		return this.strNomeTimeCampeao;
	}
	
	public String getCodigoPaisVice() {
		return this.strCodigoPaisVice;
	}
	
	public String getNomePaisVice() {
		return this.strNomePaisVice;
	}
	
	public String getCodigoTimeVice() {
		return this.strCodigoTimeVice;
	}
	
	public String getNomeTimeVice() {
		return this.strNomeTimeVice;
	}
	
	public String getCodigoPaisTerceiro() {
		return this.strCodigoPaisTerceiro;
	}
	
	public String getNomePaisTerceiro() {
		return this.strNomePaisTerceiro;
	}
	
	public String getCodigoTimeTerceiro() {
		return this.strCodigoTimeTerceiro;
	}
	
	public String getNomeTimeTerceiro() {
		return this.strNomeTimeTerceiro;
	}
	
	public String getCodigoPaisQuarto() {
		return this.strCodigoPaisQuarto;
	}
	
	public String getNomePaisQuarto() {
		return this.strNomePaisQuarto;
	}
	
	public String getCodigoTimeQuarto() {
		return this.strCodigoTimeQuarto;
	}
	
	public String getNomeTimeQuarto() {
		return this.strNomeTimeQuarto;
	}
	
	public void setCodigoPaisCampeonato(String strCodigoPaisCampeonato) {
		this.strCodigoPaisCampeonato = strCodigoPaisCampeonato;
	}
	
	public void setNomePaisCampeonato(String strNomePaisCampeonato) {
		this.strNomePaisCampeonato = strNomePaisCampeonato;
	}
	
	public void setCodigoCampeonato(String strCodigoCampeonato) {
		this.strCodigoCampeonato = strCodigoCampeonato;
	}
	
	public void setNomeCampeonato(String strNomeCampeonato) {
		this.strNomeCampeonato = strNomeCampeonato;
	}
	
	public void setAnoInicioTemporada(String strAnoInicioTemporada) {
		this.strAnoInicioTemporada = strAnoInicioTemporada;
	}
	
	public void setAnoFimTemporada(String strAnoFimTemporada) {
		this.strAnoFimTemporada = strAnoFimTemporada;
	}
	
	public void setContadorTemp(int intContadorTemp) {
		this.intContadorTemp = intContadorTemp;
	}
	
	public void setCodigoPaisCampeao(String strCodigoPaisCampeao) {
		this.strCodigoPaisCampeao = strCodigoPaisCampeao;
	}
	
	public void setNomePaisCampeao(String strNomePaisCampeao) {
		this.strNomePaisCampeao = strNomePaisCampeao;
	}
	
	public void setCodigoTimeCampeao(String strCodigoTimeCampeao) {
		this.strCodigoTimeCampeao = strCodigoTimeCampeao;
	}
	
	public void setNomeTimeCampeao(String strNomeTimeCampeao) {
		this.strNomeTimeCampeao = strNomeTimeCampeao;
	}
	
	public void setCodigoPaisVice(String strCodigoPaisVice) {
		this.strCodigoPaisVice = strCodigoPaisVice;
	}
	
	public void setNomePaisVice(String strNomePaisVice) {
		this.strNomePaisVice = strNomePaisVice;
	}
	
	public void setCodigoTimeVice(String strCodigoTimeVice) {
		this.strCodigoTimeVice = strCodigoTimeVice;
	}
	
	public void setNomeTimeVice(String strNomeTimeVice) {
		this.strNomeTimeVice = strNomeTimeVice;
	}
	
	public void setCodigoPaisTerceiro(String strCodigoPaisTerceiro) {
		this.strCodigoPaisTerceiro = strCodigoPaisTerceiro;
	}
	
	public void setNomePaisTerceiro(String strNomePaisTerceiro) {
		this.strNomePaisTerceiro = strNomePaisTerceiro;
	}
	
	public void setCodigoTimeTerceiro(String strCodigoTimeTerceiro) {
		this.strCodigoTimeTerceiro = strCodigoTimeTerceiro;
	}
	
	public void setNomeTimeTerceiro(String strNomeTimeTerceiro) {
		this.strNomeTimeTerceiro = strNomeTimeTerceiro;
	}
	
	public void setCodigoPaisQuarto(String strCodigoPaisQuarto) {
		this.strCodigoPaisQuarto = strCodigoPaisQuarto;
	}
	
	public void setNomePaisQuarto(String strNomePaisQuarto) {
		this.strNomePaisQuarto = strNomePaisQuarto;
	}
	
	public void setCodigoTimeQuarto(String strCodigoTimeQuarto) {
		this.strCodigoTimeQuarto = strCodigoTimeQuarto;
	}
	
	public void setNomeTimeQuarto(String strNomeTimeQuarto) {
		this.strNomeTimeQuarto = strNomeTimeQuarto;
	}
	
}

