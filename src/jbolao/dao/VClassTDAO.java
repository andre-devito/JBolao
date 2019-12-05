package jbolao.dao;

import java.sql.SQLException;
import devito.db.DBConexoes;
import devito.db.DBQuery;
import devito.db.DBSelect;
import devito.dados.estruturas.DLista;
import jbolao.error.Error;
import jbolao.entity.VClass;
import jbolao.entity.VClassT;

public class VClassTDAO extends VClassDAO {
	
	public DLista selVClassByTemporada(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp) {
	
		DLista DL = new DLista();
		VClassT classf;
		
		try {
		
			String strTableMain = new String("V_CLASSIFICACAO_T");
			String[] strTableCompl = null;
			String[] strFields = new String[19];
			strFields[0] = new String("CODIGO_PAIS");
			strFields[1] = new String("NOME_PAIS");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_FASE_JOGO");
			strFields[7] = new String("CODIGO_GRUPO_JOGO");
			strFields[8] = new String("CODIGO_PAIS_TIME");
			strFields[9] = new String("CODIGO_TIME");
			strFields[10] = new String("NOME_TIME");
			strFields[11] = new String("PONTOS_GANHOS");
			strFields[12] = new String("JOGOS");
			strFields[13] = new String("VITORIAS");
			strFields[14] = new String("EMPATES");
			strFields[15] = new String("DERROTAS");
			strFields[16] = new String("GOLS_PRO");
			strFields[17] = new String("GOLS_CONTRA");
			strFields[18] = new String("SALDO_GOLS");
			String[] strConditions = new String[4];
			strConditions[0] = new String("CODIGO_PAIS = '" + strCodigoPaisCamp + "'");
			strConditions[1] = new String("CODIGO_CAMPEONATO = '" + strCodigoCamp + "'");
			strConditions[2] = new String("ANO_INICIO_TEMPORADA = '" + strAnoInicioTemp + "'");
			strConditions[3] = new String("ANO_FIM_TEMPORADA = '" + strAnoFimTemp + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[5];
			strOrder[0] = new String("PONTOS_GANHOS DESC");
			strOrder[1] = new String("SALDO_GOLS DESC");
			strOrder[2] = new String("VITORIAS DESC");
			strOrder[3] = new String("GOLS_PRO DESC");
			strOrder[4] = new String("NOME_TIME ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				classf = new VClassT();
				classf.setCodigoPaisCamp(rsltSelect.getString("CODIGO_PAIS"));
				classf.setNomePaisCamp(rsltSelect.getString("NOME_PAIS"));
				classf.setCodigoCamp(rsltSelect.getString("CODIGO_CAMPEONATO"));
				classf.setNomeCamp(rsltSelect.getString("NOME_CAMPEONATO"));
				classf.setAnoInicioTemp(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				classf.setAnoFimTemp(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				classf.setCodigoFaseJogo(rsltSelect.getString("CODIGO_FASE_JOGO"));
				classf.setCodigoGrupoJogo(rsltSelect.getString("CODIGO_GRUPO_JOGO"));
				classf.setCodigoPaisTime(rsltSelect.getString("CODIGO_PAIS_TIME"));
				classf.setCodigoTime(rsltSelect.getString("CODIGO_TIME"));
				classf.setNomeTime(rsltSelect.getString("NOME_TIME"));
				classf.setPontosGanhos(rsltSelect.getInt("PONTOS_GANHOS"));
				classf.setJogos(rsltSelect.getInt("JOGOS"));
				classf.setVitorias(rsltSelect.getInt("VITORIAS"));
				classf.setEmpates(rsltSelect.getInt("EMPATES"));
				classf.setDerrotas(rsltSelect.getInt("DERROTAS"));
				classf.setGolsPro(rsltSelect.getInt("GOLS_PRO"));
				classf.setGolsContra(rsltSelect.getInt("GOLS_CONTRA"));
				classf.setSaldoGols(rsltSelect.getInt("SALDO_GOLS"));
				boolean b = DL.InsereFim(classf);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VClassTDAO.selVClassByTemporada(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVClassByTemporadaRodada(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoRodadaJogo) {
	
		DLista DL = new DLista();
		VClassT classf;
		
		try {
		
			String strTableMain = new String("FN_CLASSIFICACAO_T('" + strCodigoRodadaJogo + "')");
			String[] strTableCompl = null;
			String[] strFields = new String[19];
			strFields[0] = new String("CODIGO_PAIS");
			strFields[1] = new String("NOME_PAIS");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_FASE_JOGO");
			strFields[7] = new String("CODIGO_GRUPO_JOGO");
			strFields[8] = new String("CODIGO_PAIS_TIME");
			strFields[9] = new String("CODIGO_TIME");
			strFields[10] = new String("NOME_TIME");
			strFields[11] = new String("PONTOS_GANHOS");
			strFields[12] = new String("JOGOS");
			strFields[13] = new String("VITORIAS");
			strFields[14] = new String("EMPATES");
			strFields[15] = new String("DERROTAS");
			strFields[16] = new String("GOLS_PRO");
			strFields[17] = new String("GOLS_CONTRA");
			strFields[18] = new String("SALDO_GOLS");
			String[] strConditions = new String[4];
			strConditions[0] = new String("CODIGO_PAIS = '" + strCodigoPaisCamp + "'");
			strConditions[1] = new String("CODIGO_CAMPEONATO = '" + strCodigoCamp + "'");
			strConditions[2] = new String("ANO_INICIO_TEMPORADA = '" + strAnoInicioTemp + "'");
			strConditions[3] = new String("ANO_FIM_TEMPORADA = '" + strAnoFimTemp + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[7];
			strOrder[0] = new String("CODIGO_FASE_JOGO ASC");
			strOrder[1] = new String("CODIGO_GRUPO_JOGO ASC");
			strOrder[2] = new String("PONTOS_GANHOS DESC");
			strOrder[3] = new String("SALDO_GOLS DESC");
			strOrder[4] = new String("VITORIAS DESC");
			strOrder[5] = new String("GOLS_PRO DESC");
			strOrder[6] = new String("NOME_TIME ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				classf = new VClassT();
				classf.setCodigoPaisCamp(rsltSelect.getString("CODIGO_PAIS"));
				classf.setNomePaisCamp(rsltSelect.getString("NOME_PAIS"));
				classf.setCodigoCamp(rsltSelect.getString("CODIGO_CAMPEONATO"));
				classf.setNomeCamp(rsltSelect.getString("NOME_CAMPEONATO"));
				classf.setAnoInicioTemp(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				classf.setAnoFimTemp(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				classf.setCodigoFaseJogo(rsltSelect.getString("CODIGO_FASE_JOGO"));
				classf.setCodigoGrupoJogo(rsltSelect.getString("CODIGO_GRUPO_JOGO"));
				classf.setCodigoPaisTime(rsltSelect.getString("CODIGO_PAIS_TIME"));
				classf.setCodigoTime(rsltSelect.getString("CODIGO_TIME"));
				classf.setNomeTime(rsltSelect.getString("NOME_TIME"));
				classf.setPontosGanhos(rsltSelect.getInt("PONTOS_GANHOS"));
				classf.setJogos(rsltSelect.getInt("JOGOS"));
				classf.setVitorias(rsltSelect.getInt("VITORIAS"));
				classf.setEmpates(rsltSelect.getInt("EMPATES"));
				classf.setDerrotas(rsltSelect.getInt("DERROTAS"));
				classf.setGolsPro(rsltSelect.getInt("GOLS_PRO"));
				classf.setGolsContra(rsltSelect.getInt("GOLS_CONTRA"));
				classf.setSaldoGols(rsltSelect.getInt("SALDO_GOLS"));
				boolean b = DL.InsereFim(classf);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VClassTDAO.selVClassByTemporadaRodada(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVClassByTemporadaGrupo(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoGrupoJogo) {
	
		DLista DL = new DLista();
		VClassT classf;
		
		try {
		
			String strTableMain = new String("V_CLASSIFICACAO_T");
			String[] strTableCompl = null;
			String[] strFields = new String[19];
			strFields[0] = new String("CODIGO_PAIS");
			strFields[1] = new String("NOME_PAIS");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_FASE_JOGO");
			strFields[7] = new String("CODIGO_GRUPO_JOGO");
			strFields[8] = new String("CODIGO_PAIS_TIME");
			strFields[9] = new String("CODIGO_TIME");
			strFields[10] = new String("NOME_TIME");
			strFields[11] = new String("PONTOS_GANHOS");
			strFields[12] = new String("JOGOS");
			strFields[13] = new String("VITORIAS");
			strFields[14] = new String("EMPATES");
			strFields[15] = new String("DERROTAS");
			strFields[16] = new String("GOLS_PRO");
			strFields[17] = new String("GOLS_CONTRA");
			strFields[18] = new String("SALDO_GOLS");
			String[] strConditions = new String[5];
			strConditions[0] = new String("CODIGO_PAIS = '" + strCodigoPaisCamp + "'");
			strConditions[1] = new String("CODIGO_CAMPEONATO = '" + strCodigoCamp + "'");
			strConditions[2] = new String("ANO_INICIO_TEMPORADA = '" + strAnoInicioTemp + "'");
			strConditions[3] = new String("ANO_FIM_TEMPORADA = '" + strAnoFimTemp + "'");
			strConditions[4] = new String("CODIGO_GRUPO_JOGO = '" + strCodigoGrupoJogo + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[7];
			strOrder[0] = new String("CODIGO_FASE_JOGO ASC");
			strOrder[1] = new String("CODIGO_GRUPO_JOGO ASC");
			strOrder[2] = new String("PONTOS_GANHOS DESC");
			strOrder[3] = new String("SALDO_GOLS DESC");
			strOrder[4] = new String("VITORIAS DESC");
			strOrder[5] = new String("GOLS_PRO DESC");
			strOrder[6] = new String("NOME_TIME ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				classf = new VClassT();
				classf.setCodigoPaisCamp(rsltSelect.getString("CODIGO_PAIS"));
				classf.setNomePaisCamp(rsltSelect.getString("NOME_PAIS"));
				classf.setCodigoCamp(rsltSelect.getString("CODIGO_CAMPEONATO"));
				classf.setNomeCamp(rsltSelect.getString("NOME_CAMPEONATO"));
				classf.setAnoInicioTemp(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				classf.setAnoFimTemp(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				classf.setCodigoFaseJogo(rsltSelect.getString("CODIGO_FASE_JOGO"));
				classf.setCodigoGrupoJogo(rsltSelect.getString("CODIGO_GRUPO_JOGO"));
				classf.setCodigoPaisTime(rsltSelect.getString("CODIGO_PAIS_TIME"));
				classf.setCodigoTime(rsltSelect.getString("CODIGO_TIME"));
				classf.setNomeTime(rsltSelect.getString("NOME_TIME"));
				classf.setPontosGanhos(rsltSelect.getInt("PONTOS_GANHOS"));
				classf.setJogos(rsltSelect.getInt("JOGOS"));
				classf.setVitorias(rsltSelect.getInt("VITORIAS"));
				classf.setEmpates(rsltSelect.getInt("EMPATES"));
				classf.setDerrotas(rsltSelect.getInt("DERROTAS"));
				classf.setGolsPro(rsltSelect.getInt("GOLS_PRO"));
				classf.setGolsContra(rsltSelect.getInt("GOLS_CONTRA"));
				classf.setSaldoGols(rsltSelect.getInt("SALDO_GOLS"));
				boolean b = DL.InsereFim(classf);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VClassTDAO.selVClassByTemporadaGrupo(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVClassByEstat(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strOrderField) {
	
		DLista DL = new DLista();
		VClassT classf;
		
		try {
		
			String strTableMain = new String("V_CLASSIFICACAO_T");
			String[] strTableCompl = null;
			String[] strFields = new String[12];
			strFields[0] = new String("CODIGO_PAIS");
			strFields[1] = new String("NOME_PAIS");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_PAIS_TIME");
			strFields[7] = new String("CODIGO_TIME");
			strFields[8] = new String("NOME_TIME");
			strFields[9] = new String("SUM(" + strOrderField + ") AS ESTAT");
			strFields[10] = new String("SUM(JOGOS) AS JOGOS");
			strFields[11] = new String("MEDIA = CASE WHEN (SUM(JOGOS) = 0) THEN 0 ELSE CONVERT(FLOAT, SUM(" + strOrderField + ")) / CONVERT(FLOAT, SUM(JOGOS)) END");
			String[] strConditions = new String[4];
			strConditions[0] = new String("CODIGO_PAIS = '" + strCodigoPaisCamp + "'");
			strConditions[1] = new String("CODIGO_CAMPEONATO = '" + strCodigoCamp + "'");
			strConditions[2] = new String("ANO_INICIO_TEMPORADA = '" + strAnoInicioTemp + "'");
			strConditions[3] = new String("ANO_FIM_TEMPORADA = '" + strAnoFimTemp + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = new String[9];
			strGroup[0] = new String("CODIGO_PAIS");
			strGroup[1] = new String("NOME_PAIS");
			strGroup[2] = new String("CODIGO_CAMPEONATO");
			strGroup[3] = new String("NOME_CAMPEONATO");
			strGroup[4] = new String("ANO_INICIO_TEMPORADA");
			strGroup[5] = new String("ANO_FIM_TEMPORADA");
			strGroup[6] = new String("CODIGO_PAIS_TIME");
			strGroup[7] = new String("CODIGO_TIME");
			strGroup[8] = new String("NOME_TIME");
			String[] strOrder = new String[3];
			strOrder[0] = new String("MEDIA DESC");
			strOrder[1] = new String("ESTAT DESC");
			strOrder[2] = new String("NOME_TIME ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				classf = new VClassT();
				classf.setCodigoPaisCamp(rsltSelect.getString("CODIGO_PAIS"));
				classf.setNomePaisCamp(rsltSelect.getString("NOME_PAIS"));
				classf.setCodigoCamp(rsltSelect.getString("CODIGO_CAMPEONATO"));
				classf.setNomeCamp(rsltSelect.getString("NOME_CAMPEONATO"));
				classf.setAnoInicioTemp(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				classf.setAnoFimTemp(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				classf.setCodigoPaisTime(rsltSelect.getString("CODIGO_PAIS_TIME"));
				classf.setCodigoTime(rsltSelect.getString("CODIGO_TIME"));
				classf.setNomeTime(rsltSelect.getString("NOME_TIME"));
				classf.setEstat(rsltSelect.getInt("ESTAT"));
				classf.setJogos(rsltSelect.getInt("JOGOS"));
				classf.setMedia(rsltSelect.getFloat("MEDIA"));
				boolean b = DL.InsereFim(classf);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VClassTDAO.selVClassByEstat(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVClassByEstatRodada(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strOrderField, String strCodigoRodadaJogo) {
	
		DLista DL = new DLista();
		VClassT classf;
		
		try {
		
			String strTableMain = new String("FN_CLASSIFICACAO_T('" + strCodigoRodadaJogo + "')");
			String[] strTableCompl = null;
			String[] strFields = new String[12];
			strFields[0] = new String("CODIGO_PAIS");
			strFields[1] = new String("NOME_PAIS");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_PAIS_TIME");
			strFields[7] = new String("CODIGO_TIME");
			strFields[8] = new String("NOME_TIME");
			strFields[9] = new String("SUM(" + strOrderField + ") AS ESTAT");
			strFields[10] = new String("SUM(JOGOS) AS JOGOS");
			strFields[11] = new String("MEDIA = CASE WHEN (SUM(JOGOS) = 0) THEN 0 ELSE CONVERT(FLOAT, SUM(" + strOrderField + ")) / CONVERT(FLOAT, SUM(JOGOS)) END");
			String[] strConditions = new String[4];
			strConditions[0] = new String("CODIGO_PAIS = '" + strCodigoPaisCamp + "'");
			strConditions[1] = new String("CODIGO_CAMPEONATO = '" + strCodigoCamp + "'");
			strConditions[2] = new String("ANO_INICIO_TEMPORADA = '" + strAnoInicioTemp + "'");
			strConditions[3] = new String("ANO_FIM_TEMPORADA = '" + strAnoFimTemp + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = new String[9];
			strGroup[0] = new String("CODIGO_PAIS");
			strGroup[1] = new String("NOME_PAIS");
			strGroup[2] = new String("CODIGO_CAMPEONATO");
			strGroup[3] = new String("NOME_CAMPEONATO");
			strGroup[4] = new String("ANO_INICIO_TEMPORADA");
			strGroup[5] = new String("ANO_FIM_TEMPORADA");
			strGroup[6] = new String("CODIGO_PAIS_TIME");
			strGroup[7] = new String("CODIGO_TIME");
			strGroup[8] = new String("NOME_TIME");
			String[] strOrder = new String[3];
			strOrder[0] = new String("MEDIA DESC");
			strOrder[1] = new String("ESTAT DESC");
			strOrder[2] = new String("NOME_TIME ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				classf = new VClassT();
				classf.setCodigoPaisCamp(rsltSelect.getString("CODIGO_PAIS"));
				classf.setNomePaisCamp(rsltSelect.getString("NOME_PAIS"));
				classf.setCodigoCamp(rsltSelect.getString("CODIGO_CAMPEONATO"));
				classf.setNomeCamp(rsltSelect.getString("NOME_CAMPEONATO"));
				classf.setAnoInicioTemp(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				classf.setAnoFimTemp(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				classf.setCodigoPaisTime(rsltSelect.getString("CODIGO_PAIS_TIME"));
				classf.setCodigoTime(rsltSelect.getString("CODIGO_TIME"));
				classf.setNomeTime(rsltSelect.getString("NOME_TIME"));
				classf.setEstat(rsltSelect.getInt("ESTAT"));
				classf.setJogos(rsltSelect.getInt("JOGOS"));
				classf.setMedia(rsltSelect.getFloat("MEDIA"));
				boolean b = DL.InsereFim(classf);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VClassTDAO.selVClassByEstatRodada(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
}

