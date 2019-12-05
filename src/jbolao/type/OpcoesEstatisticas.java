package jbolao.type;

import devito.dados.objetos.Objeto;

public enum OpcoesEstatisticas implements Objeto {

	PONTOS_GANHOS("PONTOS", "PONTOS_GANHOS"), 
	VITORIAS("VITORIAS", "VITORIAS"), 
	DERROTAS("DERROTAS", "DERROTAS"), 
	EMPATES("EMPATES", "EMPATES"),
	JOGOS_SEM_PERDER("JOGOS SEM PERDER", "VITORIAS+EMPATES"),
	JOGOS_SEM_VENCER("JOGOS SEM VENCER", "DERROTAS+EMPATES"),
	GOLS_MARCADOS("GOLS MARCADOS", "GOLS_PRO"),
	GOLS_SOFRIDOS("GOLS SOFRIDOS", "GOLS_CONTRA");
	
	private final String strDescField;
	private final String strOrderField;
	
	OpcoesEstatisticas(String strDesc, String strOrder) {
		strDescField = strDesc;
		strOrderField = strOrder;
	}
	
	public String getDescField() {
		return strDescField;
	}
	
	public String getOrderField() {
		return strOrderField;
	}
	
}
