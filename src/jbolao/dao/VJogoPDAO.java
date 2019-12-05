package jbolao.dao;

import java.sql.SQLException;
import devito.db.DBConexoes;
import devito.db.DBQuery;
import devito.db.DBSelect;
import devito.db.DBUpdate;
import devito.dados.estruturas.DLista;
import jbolao.error.Error;
import jbolao.entity.VJogo;
import jbolao.entity.VJogoP;

public class VJogoPDAO extends VJogoDAO {
	
	public DLista selVJogoByRodadaAtual(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp) {
	
		DLista DL = new DLista();
		VJogoP jogo;
		
		try {
		
			String strTableMain = new String("FN_ROD_ATU_JOGOS_P('" + strCodigoPaisCamp + "','" + strCodigoCamp + "','" + strAnoInicioTemp + "','" + strAnoFimTemp + "')");
			String strTableCompl[] = null;
			String[] strFields = new String[22];
			strFields[0] = new String("CODIGO_PAIS");
			strFields[1] = new String("NOME_PAIS");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_PAIS_HOME");
			strFields[7] = new String("NOME_PAIS_HOME");
			strFields[8] = new String("HOME_SCORE");
			strFields[9] = new String("CODIGO_PAIS_AWAY");
			strFields[10] = new String("NOME_PAIS_AWAY");
			strFields[11] = new String("AWAY_SCORE");
			strFields[12] = new String("CODIGO_JOGO");
			strFields[13] = new String("CODIGO_FASE_JOGO");
			strFields[14] = new String("DESC_FASE");
			strFields[15] = new String("CODIGO_TURNO_JOGO");
			strFields[16] = new String("DESC_TURNO");
			strFields[17] = new String("CODIGO_RODADA_JOGO");
			strFields[18] = new String("DESC_RODADA");
			strFields[19] = new String("CODIGO_GRUPO_JOGO");
			strFields[20] = new String("DESC_GRUPO");
			strFields[21] = new String("DATA_JOGO");
			String[] strConditions = null;
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[5];
			strOrder[0] = new String("CODIGO_FASE_JOGO ASC");
			strOrder[1] = new String("CODIGO_TURNO_JOGO ASC");
			strOrder[2] = new String("CODIGO_RODADA_JOGO ASC");
			strOrder[3] = new String("CODIGO_GRUPO_JOGO ASC");
			strOrder[4] = new String("DATA_JOGO ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				jogo = new VJogoP();
				jogo.setCodigoPaisCamp(rsltSelect.getString("CODIGO_PAIS"));
				jogo.setNomePaisCamp(rsltSelect.getString("NOME_PAIS"));
				jogo.setCodigoCamp(rsltSelect.getString("CODIGO_CAMPEONATO"));
				jogo.setNomeCamp(rsltSelect.getString("NOME_CAMPEONATO"));
				jogo.setAnoInicioTemp(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				jogo.setAnoFimTemp(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				jogo.setCodigoPaisHome(rsltSelect.getString("CODIGO_PAIS_HOME"));
				jogo.setNomePaisHome(rsltSelect.getString("NOME_PAIS_HOME"));
				jogo.setHomeScore(rsltSelect.getInt("HOME_SCORE"));
				if (rsltSelect.wasNull())
					jogo.setHomeScore(-1);
				jogo.setCodigoPaisAway(rsltSelect.getString("CODIGO_PAIS_AWAY"));
				jogo.setNomePaisAway(rsltSelect.getString("NOME_PAIS_AWAY"));
				jogo.setAwayScore(rsltSelect.getInt("AWAY_SCORE"));
				if (rsltSelect.wasNull())
					jogo.setAwayScore(-1);
				jogo.setCodigoJogo(rsltSelect.getString("CODIGO_JOGO"));
				jogo.setCodigoFaseJogo(rsltSelect.getString("CODIGO_FASE_JOGO"));
				jogo.setDescFaseJogo(rsltSelect.getString("DESC_FASE"));
				jogo.setCodigoTurnoJogo(rsltSelect.getString("CODIGO_TURNO_JOGO"));
				jogo.setDescTurnoJogo(rsltSelect.getString("DESC_TURNO"));
				jogo.setCodigoRodadaJogo(rsltSelect.getString("CODIGO_RODADA_JOGO"));
				jogo.setDescRodadaJogo(rsltSelect.getString("DESC_RODADA"));
				jogo.setCodigoGrupoJogo(rsltSelect.getString("CODIGO_GRUPO_JOGO"));
				jogo.setDescGrupoJogo(rsltSelect.getString("DESC_GRUPO"));
				jogo.setDataJogo(rsltSelect.getString("DATA_JOGO"));
				boolean b = DL.InsereFim(jogo);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VJogoPDAO.selVJogoByRodadaAtual(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVJogoByFaseAtual(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp) {
		
		DLista DL = new DLista();
		VJogoP jogo;
		
		try {
		
			String strTableMain = new String("FN_FAS_ATU_JOGOS_P('" + strCodigoPaisCamp + "','" + strCodigoCamp + "','" + strAnoInicioTemp + "','" + strAnoFimTemp + "')");
			String strTableCompl[] = null;
			String[] strFields = new String[22];
			strFields[0] = new String("CODIGO_PAIS");
			strFields[1] = new String("NOME_PAIS");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_PAIS_HOME");
			strFields[7] = new String("NOME_PAIS_HOME");
			strFields[8] = new String("HOME_SCORE");
			strFields[9] = new String("CODIGO_PAIS_AWAY");
			strFields[10] = new String("NOME_PAIS_AWAY");
			strFields[11] = new String("AWAY_SCORE");
			strFields[12] = new String("CODIGO_JOGO");
			strFields[13] = new String("CODIGO_FASE_JOGO");
			strFields[14] = new String("DESC_FASE");
			strFields[15] = new String("CODIGO_TURNO_JOGO");
			strFields[16] = new String("DESC_TURNO");
			strFields[17] = new String("CODIGO_RODADA_JOGO");
			strFields[18] = new String("DESC_RODADA");
			strFields[19] = new String("CODIGO_GRUPO_JOGO");
			strFields[20] = new String("DESC_GRUPO");
			strFields[21] = new String("DATA_JOGO");
			String[] strConditions = null;
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[5];
			strOrder[0] = new String("CODIGO_FASE_JOGO ASC");
			strOrder[1] = new String("CODIGO_TURNO_JOGO ASC");
			strOrder[2] = new String("CODIGO_RODADA_JOGO ASC");
			strOrder[3] = new String("CODIGO_GRUPO_JOGO ASC");
			strOrder[4] = new String("DATA_JOGO ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				jogo = new VJogoP();
				jogo.setCodigoPaisCamp(rsltSelect.getString("CODIGO_PAIS"));
				jogo.setNomePaisCamp(rsltSelect.getString("NOME_PAIS"));
				jogo.setCodigoCamp(rsltSelect.getString("CODIGO_CAMPEONATO"));
				jogo.setNomeCamp(rsltSelect.getString("NOME_CAMPEONATO"));
				jogo.setAnoInicioTemp(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				jogo.setAnoFimTemp(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				jogo.setCodigoPaisHome(rsltSelect.getString("CODIGO_PAIS_HOME"));
				jogo.setNomePaisHome(rsltSelect.getString("NOME_PAIS_HOME"));
				jogo.setHomeScore(rsltSelect.getInt("HOME_SCORE"));
				if (rsltSelect.wasNull())
					jogo.setHomeScore(-1);
				jogo.setCodigoPaisAway(rsltSelect.getString("CODIGO_PAIS_AWAY"));
				jogo.setNomePaisAway(rsltSelect.getString("NOME_PAIS_AWAY"));
				jogo.setAwayScore(rsltSelect.getInt("AWAY_SCORE"));
				if (rsltSelect.wasNull())
					jogo.setAwayScore(-1);
				jogo.setCodigoJogo(rsltSelect.getString("CODIGO_JOGO"));
				jogo.setCodigoFaseJogo(rsltSelect.getString("CODIGO_FASE_JOGO"));
				jogo.setDescFaseJogo(rsltSelect.getString("DESC_FASE"));
				jogo.setCodigoTurnoJogo(rsltSelect.getString("CODIGO_TURNO_JOGO"));
				jogo.setDescTurnoJogo(rsltSelect.getString("DESC_TURNO"));
				jogo.setCodigoRodadaJogo(rsltSelect.getString("CODIGO_RODADA_JOGO"));
				jogo.setDescRodadaJogo(rsltSelect.getString("DESC_RODADA"));
				jogo.setCodigoGrupoJogo(rsltSelect.getString("CODIGO_GRUPO_JOGO"));
				jogo.setDescGrupoJogo(rsltSelect.getString("DESC_GRUPO"));
				jogo.setDataJogo(rsltSelect.getString("DATA_JOGO"));
				boolean b = DL.InsereFim(jogo);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VJogoPDAO.selVJogoByFaseAtual(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVJogoByRodada(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoRodadaJogo) {
	
		DLista DL = new DLista();
		VJogoP jogo;
		
		try {
		
			String strTableMain = new String("V_JOGOS_P");
			String[] strTableCompl = null;
			String[] strFields = new String[22];
			strFields[0] = new String("CODIGO_PAIS");
			strFields[1] = new String("NOME_PAIS");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_PAIS_HOME");
			strFields[7] = new String("NOME_PAIS_HOME");
			strFields[8] = new String("HOME_SCORE");
			strFields[9] = new String("CODIGO_PAIS_AWAY");
			strFields[10] = new String("NOME_PAIS_AWAY");
			strFields[11] = new String("AWAY_SCORE");
			strFields[12] = new String("CODIGO_JOGO");
			strFields[13] = new String("CODIGO_FASE_JOGO");
			strFields[14] = new String("DESC_FASE");
			strFields[15] = new String("CODIGO_TURNO_JOGO");
			strFields[16] = new String("DESC_TURNO");
			strFields[17] = new String("CODIGO_RODADA_JOGO");
			strFields[18] = new String("DESC_RODADA");
			strFields[19] = new String("CODIGO_GRUPO_JOGO");
			strFields[20] = new String("DESC_GRUPO");
			strFields[21] = new String("DATA_JOGO");
			String[] strConditions = new String[5];
			strConditions[0] = new String("CODIGO_PAIS = '" + strCodigoPaisCamp + "'");
			strConditions[1] = new String("CODIGO_CAMPEONATO = '" + strCodigoCamp + "'");
			strConditions[2] = new String("ANO_INICIO_TEMPORADA = '" + strAnoInicioTemp + "'");
			strConditions[3] = new String("ANO_FIM_TEMPORADA = '" + strAnoFimTemp + "'");
			strConditions[4] = new String("CODIGO_RODADA_JOGO = '" + strCodigoRodadaJogo + "'");				
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[5];
			strOrder[0] = new String("CODIGO_FASE_JOGO ASC");
			strOrder[1] = new String("CODIGO_TURNO_JOGO ASC");
			strOrder[2] = new String("CODIGO_RODADA_JOGO ASC");
			strOrder[3] = new String("CODIGO_GRUPO_JOGO ASC");
			strOrder[4] = new String("DATA_JOGO ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				jogo = new VJogoP();
				jogo.setCodigoPaisCamp(rsltSelect.getString("CODIGO_PAIS"));
				jogo.setNomePaisCamp(rsltSelect.getString("NOME_PAIS"));
				jogo.setCodigoCamp(rsltSelect.getString("CODIGO_CAMPEONATO"));
				jogo.setNomeCamp(rsltSelect.getString("NOME_CAMPEONATO"));
				jogo.setAnoInicioTemp(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				jogo.setAnoFimTemp(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				jogo.setCodigoPaisHome(rsltSelect.getString("CODIGO_PAIS_HOME"));
				jogo.setNomePaisHome(rsltSelect.getString("NOME_PAIS_HOME"));
				jogo.setHomeScore(rsltSelect.getInt("HOME_SCORE"));
				if (rsltSelect.wasNull())
					jogo.setHomeScore(-1);
				jogo.setCodigoPaisAway(rsltSelect.getString("CODIGO_PAIS_AWAY"));
				jogo.setNomePaisAway(rsltSelect.getString("NOME_PAIS_AWAY"));
				jogo.setAwayScore(rsltSelect.getInt("AWAY_SCORE"));
				if (rsltSelect.wasNull())
					jogo.setAwayScore(-1);
				jogo.setCodigoJogo(rsltSelect.getString("CODIGO_JOGO"));
				jogo.setCodigoFaseJogo(rsltSelect.getString("CODIGO_FASE_JOGO"));
				jogo.setDescFaseJogo(rsltSelect.getString("DESC_FASE"));
				jogo.setCodigoTurnoJogo(rsltSelect.getString("CODIGO_TURNO_JOGO"));
				jogo.setDescTurnoJogo(rsltSelect.getString("DESC_TURNO"));
				jogo.setCodigoRodadaJogo(rsltSelect.getString("CODIGO_RODADA_JOGO"));
				jogo.setDescRodadaJogo(rsltSelect.getString("DESC_RODADA"));
				jogo.setCodigoGrupoJogo(rsltSelect.getString("CODIGO_GRUPO_JOGO"));
				jogo.setDescGrupoJogo(rsltSelect.getString("DESC_GRUPO"));
				jogo.setDataJogo(rsltSelect.getString("DATA_JOGO"));
				boolean b = DL.InsereFim(jogo);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VJogoPDAO.selVJogoByRodada(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVJogoByFase(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoFaseJogo) {
	
		DLista DL = new DLista();
		VJogoP jogo;
		
		try {
		
			String strTableMain = new String("V_JOGOS_P");
			String[] strTableCompl = null;
			String[] strFields = new String[22];
			strFields[0] = new String("CODIGO_PAIS");
			strFields[1] = new String("NOME_PAIS");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_PAIS_HOME");
			strFields[7] = new String("NOME_PAIS_HOME");
			strFields[8] = new String("HOME_SCORE");
			strFields[9] = new String("CODIGO_PAIS_AWAY");
			strFields[10] = new String("NOME_PAIS_AWAY");
			strFields[11] = new String("AWAY_SCORE");
			strFields[12] = new String("CODIGO_JOGO");
			strFields[13] = new String("CODIGO_FASE_JOGO");
			strFields[14] = new String("DESC_FASE");
			strFields[15] = new String("CODIGO_TURNO_JOGO");
			strFields[16] = new String("DESC_TURNO");
			strFields[17] = new String("CODIGO_RODADA_JOGO");
			strFields[18] = new String("DESC_RODADA");
			strFields[19] = new String("CODIGO_GRUPO_JOGO");
			strFields[20] = new String("DESC_GRUPO");
			strFields[21] = new String("DATA_JOGO");
			String[] strConditions = new String[5];
			strConditions[0] = new String("CODIGO_PAIS = '" + strCodigoPaisCamp + "'");
			strConditions[1] = new String("CODIGO_CAMPEONATO = '" + strCodigoCamp + "'");
			strConditions[2] = new String("ANO_INICIO_TEMPORADA = '" + strAnoInicioTemp + "'");
			strConditions[3] = new String("ANO_FIM_TEMPORADA = '" + strAnoFimTemp + "'");
			strConditions[4] = new String("CODIGO_FASE_JOGO = '" + strCodigoFaseJogo + "'");				
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[5];
			strOrder[0] = new String("CODIGO_FASE_JOGO ASC");
			strOrder[1] = new String("CODIGO_TURNO_JOGO ASC");
			strOrder[2] = new String("CODIGO_RODADA_JOGO ASC");
			strOrder[3] = new String("CODIGO_GRUPO_JOGO ASC");
			strOrder[4] = new String("DATA_JOGO ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				jogo = new VJogoP();
				jogo.setCodigoPaisCamp(rsltSelect.getString("CODIGO_PAIS"));
				jogo.setNomePaisCamp(rsltSelect.getString("NOME_PAIS"));
				jogo.setCodigoCamp(rsltSelect.getString("CODIGO_CAMPEONATO"));
				jogo.setNomeCamp(rsltSelect.getString("NOME_CAMPEONATO"));
				jogo.setAnoInicioTemp(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				jogo.setAnoFimTemp(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				jogo.setCodigoPaisHome(rsltSelect.getString("CODIGO_PAIS_HOME"));
				jogo.setNomePaisHome(rsltSelect.getString("NOME_PAIS_HOME"));
				jogo.setHomeScore(rsltSelect.getInt("HOME_SCORE"));
				if (rsltSelect.wasNull())
					jogo.setHomeScore(-1);
				jogo.setCodigoPaisAway(rsltSelect.getString("CODIGO_PAIS_AWAY"));
				jogo.setNomePaisAway(rsltSelect.getString("NOME_PAIS_AWAY"));
				jogo.setAwayScore(rsltSelect.getInt("AWAY_SCORE"));
				if (rsltSelect.wasNull())
					jogo.setAwayScore(-1);
				jogo.setCodigoJogo(rsltSelect.getString("CODIGO_JOGO"));
				jogo.setCodigoFaseJogo(rsltSelect.getString("CODIGO_FASE_JOGO"));
				jogo.setDescFaseJogo(rsltSelect.getString("DESC_FASE"));
				jogo.setCodigoTurnoJogo(rsltSelect.getString("CODIGO_TURNO_JOGO"));
				jogo.setDescTurnoJogo(rsltSelect.getString("DESC_TURNO"));
				jogo.setCodigoRodadaJogo(rsltSelect.getString("CODIGO_RODADA_JOGO"));
				jogo.setDescRodadaJogo(rsltSelect.getString("DESC_RODADA"));
				jogo.setCodigoGrupoJogo(rsltSelect.getString("CODIGO_GRUPO_JOGO"));
				jogo.setDescGrupoJogo(rsltSelect.getString("DESC_GRUPO"));
				jogo.setDataJogo(rsltSelect.getString("DATA_JOGO"));
				boolean b = DL.InsereFim(jogo);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VJogoPDAO.selVJogoByFase(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVJogoByFaseTurno(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoAgrupJogo) {
	
		DLista DL = new DLista();
		VJogoP jogo;
		
		try {
		
			String strTableMain = new String("V_JOGOS_P");
			String[] strTableCompl = null;
			String[] strFields = new String[22];
			strFields[0] = new String("CODIGO_PAIS");
			strFields[1] = new String("NOME_PAIS");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_PAIS_HOME");
			strFields[7] = new String("NOME_PAIS_HOME");
			strFields[8] = new String("HOME_SCORE");
			strFields[9] = new String("CODIGO_PAIS_AWAY");
			strFields[10] = new String("NOME_PAIS_AWAY");
			strFields[11] = new String("AWAY_SCORE");
			strFields[12] = new String("CODIGO_JOGO");
			strFields[13] = new String("CODIGO_FASE_JOGO");
			strFields[14] = new String("DESC_FASE");
			strFields[15] = new String("CODIGO_TURNO_JOGO");
			strFields[16] = new String("DESC_TURNO");
			strFields[17] = new String("CODIGO_RODADA_JOGO");
			strFields[18] = new String("DESC_RODADA");
			strFields[19] = new String("CODIGO_GRUPO_JOGO");
			strFields[20] = new String("DESC_GRUPO");
			strFields[21] = new String("DATA_JOGO");
			String[] strConditions = new String[5];
			strConditions[0] = new String("CODIGO_PAIS = '" + strCodigoPaisCamp + "'");
			strConditions[1] = new String("CODIGO_CAMPEONATO = '" + strCodigoCamp + "'");
			strConditions[2] = new String("ANO_INICIO_TEMPORADA = '" + strAnoInicioTemp + "'");
			strConditions[3] = new String("ANO_FIM_TEMPORADA = '" + strAnoFimTemp + "'");
			strConditions[4] = new String("CODIGO_FASE_JOGO + CODIGO_TURNO_JOGO = '" + strCodigoAgrupJogo + "'");				
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[5];
			strOrder[0] = new String("CODIGO_FASE_JOGO ASC");
			strOrder[1] = new String("CODIGO_TURNO_JOGO ASC");
			strOrder[2] = new String("CODIGO_RODADA_JOGO ASC");
			strOrder[3] = new String("CODIGO_GRUPO_JOGO ASC");
			strOrder[4] = new String("DATA_JOGO ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				jogo = new VJogoP();
				jogo.setCodigoPaisCamp(rsltSelect.getString("CODIGO_PAIS"));
				jogo.setNomePaisCamp(rsltSelect.getString("NOME_PAIS"));
				jogo.setCodigoCamp(rsltSelect.getString("CODIGO_CAMPEONATO"));
				jogo.setNomeCamp(rsltSelect.getString("NOME_CAMPEONATO"));
				jogo.setAnoInicioTemp(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				jogo.setAnoFimTemp(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				jogo.setCodigoPaisHome(rsltSelect.getString("CODIGO_PAIS_HOME"));
				jogo.setNomePaisHome(rsltSelect.getString("NOME_PAIS_HOME"));
				jogo.setHomeScore(rsltSelect.getInt("HOME_SCORE"));
				if (rsltSelect.wasNull())
					jogo.setHomeScore(-1);
				jogo.setCodigoPaisAway(rsltSelect.getString("CODIGO_PAIS_AWAY"));
				jogo.setNomePaisAway(rsltSelect.getString("NOME_PAIS_AWAY"));
				jogo.setAwayScore(rsltSelect.getInt("AWAY_SCORE"));
				if (rsltSelect.wasNull())
					jogo.setAwayScore(-1);
				jogo.setCodigoJogo(rsltSelect.getString("CODIGO_JOGO"));
				jogo.setCodigoFaseJogo(rsltSelect.getString("CODIGO_FASE_JOGO"));
				jogo.setDescFaseJogo(rsltSelect.getString("DESC_FASE"));
				jogo.setCodigoTurnoJogo(rsltSelect.getString("CODIGO_TURNO_JOGO"));
				jogo.setDescTurnoJogo(rsltSelect.getString("DESC_TURNO"));
				jogo.setCodigoRodadaJogo(rsltSelect.getString("CODIGO_RODADA_JOGO"));
				jogo.setDescRodadaJogo(rsltSelect.getString("DESC_RODADA"));
				jogo.setCodigoGrupoJogo(rsltSelect.getString("CODIGO_GRUPO_JOGO"));
				jogo.setDescGrupoJogo(rsltSelect.getString("DESC_GRUPO"));
				jogo.setDataJogo(rsltSelect.getString("DATA_JOGO"));
				boolean b = DL.InsereFim(jogo);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VJogoPDAO.selVJogoByFaseTurno(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVJogoByFaseGrupo(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoAgrupJogo) {
	
		DLista DL = new DLista();
		VJogoP jogo;
		
		try {
		
			String strTableMain = new String("V_JOGOS_P");
			String[] strTableCompl = null;
			String[] strFields = new String[22];
			strFields[0] = new String("CODIGO_PAIS");
			strFields[1] = new String("NOME_PAIS");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_PAIS_HOME");
			strFields[7] = new String("NOME_PAIS_HOME");
			strFields[8] = new String("HOME_SCORE");
			strFields[9] = new String("CODIGO_PAIS_AWAY");
			strFields[10] = new String("NOME_PAIS_AWAY");
			strFields[11] = new String("AWAY_SCORE");
			strFields[12] = new String("CODIGO_JOGO");
			strFields[13] = new String("CODIGO_FASE_JOGO");
			strFields[14] = new String("DESC_FASE");
			strFields[15] = new String("CODIGO_TURNO_JOGO");
			strFields[16] = new String("DESC_TURNO");
			strFields[17] = new String("CODIGO_RODADA_JOGO");
			strFields[18] = new String("DESC_RODADA");
			strFields[19] = new String("CODIGO_GRUPO_JOGO");
			strFields[20] = new String("DESC_GRUPO");
			strFields[21] = new String("DATA_JOGO");
			String[] strConditions = new String[5];
			strConditions[0] = new String("CODIGO_PAIS = '" + strCodigoPaisCamp + "'");
			strConditions[1] = new String("CODIGO_CAMPEONATO = '" + strCodigoCamp + "'");
			strConditions[2] = new String("ANO_INICIO_TEMPORADA = '" + strAnoInicioTemp + "'");
			strConditions[3] = new String("ANO_FIM_TEMPORADA = '" + strAnoFimTemp + "'");
			strConditions[4] = new String("CODIGO_FASE_JOGO + CODIGO_GRUPO_JOGO = '" + strCodigoAgrupJogo + "'");				
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[5];
			strOrder[0] = new String("CODIGO_FASE_JOGO ASC");
			strOrder[1] = new String("CODIGO_TURNO_JOGO ASC");
			strOrder[2] = new String("CODIGO_RODADA_JOGO ASC");
			strOrder[3] = new String("CODIGO_GRUPO_JOGO ASC");
			strOrder[4] = new String("DATA_JOGO ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				jogo = new VJogoP();
				jogo.setCodigoPaisCamp(rsltSelect.getString("CODIGO_PAIS"));
				jogo.setNomePaisCamp(rsltSelect.getString("NOME_PAIS"));
				jogo.setCodigoCamp(rsltSelect.getString("CODIGO_CAMPEONATO"));
				jogo.setNomeCamp(rsltSelect.getString("NOME_CAMPEONATO"));
				jogo.setAnoInicioTemp(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				jogo.setAnoFimTemp(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				jogo.setCodigoPaisHome(rsltSelect.getString("CODIGO_PAIS_HOME"));
				jogo.setNomePaisHome(rsltSelect.getString("NOME_PAIS_HOME"));
				jogo.setHomeScore(rsltSelect.getInt("HOME_SCORE"));
				if (rsltSelect.wasNull())
					jogo.setHomeScore(-1);
				jogo.setCodigoPaisAway(rsltSelect.getString("CODIGO_PAIS_AWAY"));
				jogo.setNomePaisAway(rsltSelect.getString("NOME_PAIS_AWAY"));
				jogo.setAwayScore(rsltSelect.getInt("AWAY_SCORE"));
				if (rsltSelect.wasNull())
					jogo.setAwayScore(-1);
				jogo.setCodigoJogo(rsltSelect.getString("CODIGO_JOGO"));
				jogo.setCodigoFaseJogo(rsltSelect.getString("CODIGO_FASE_JOGO"));
				jogo.setDescFaseJogo(rsltSelect.getString("DESC_FASE"));
				jogo.setCodigoTurnoJogo(rsltSelect.getString("CODIGO_TURNO_JOGO"));
				jogo.setDescTurnoJogo(rsltSelect.getString("DESC_TURNO"));
				jogo.setCodigoRodadaJogo(rsltSelect.getString("CODIGO_RODADA_JOGO"));
				jogo.setDescRodadaJogo(rsltSelect.getString("DESC_RODADA"));
				jogo.setCodigoGrupoJogo(rsltSelect.getString("CODIGO_GRUPO_JOGO"));
				jogo.setDescGrupoJogo(rsltSelect.getString("DESC_GRUPO"));
				jogo.setDataJogo(rsltSelect.getString("DATA_JOGO"));
				boolean b = DL.InsereFim(jogo);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VJogoPDAO.selVJogoByFaseGrupo(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVJogoByDistinctOperacional(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strDescOperacional) {
	
		DLista DL = new DLista();
		VJogoP jogo;
		
		try {
		
			String strTableMain = new String("V_JOGOS_P");
			String[] strTableCompl = null;
			String[] strFields = new String[3];
			strFields[0] = new String("CODIGO_" + strDescOperacional + "_JOGO");
			strFields[1] = new String("DESC_" + strDescOperacional);
			strFields[2] = new String("COUNT(*) AS QTD_JOGOS");
			String[] strConditions = new String[4];
			strConditions[0] = new String("CODIGO_PAIS = '" + strCodigoPaisCamp + "'");
			strConditions[1] = new String("CODIGO_CAMPEONATO = '" + strCodigoCamp + "'");
			strConditions[2] = new String("ANO_INICIO_TEMPORADA = '" + strAnoInicioTemp + "'");
			strConditions[3] = new String("ANO_FIM_TEMPORADA = '" + strAnoFimTemp + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = new String[2];
			strGroup[0] = new String("CODIGO_" + strDescOperacional + "_JOGO");
			strGroup[1] = new String("DESC_" + strDescOperacional);
			String[] strOrder = new String[2];
			strOrder[0] = new String("CODIGO_" + strDescOperacional + "_JOGO ASC");
			strOrder[1] = new String("DESC_" + strDescOperacional + " ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				jogo = new VJogoP();
				jogo.setContadorOperacional(rsltSelect.getInt("QTD_JOGOS"));
				jogo.setCodigoOperacionalJogo(rsltSelect.getString("CODIGO_" + strDescOperacional + "_JOGO"));
				jogo.setDescOperacionalJogo(rsltSelect.getString("DESC_" + strDescOperacional));
				boolean b = DL.InsereFim(jogo);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VJogoPDAO.selVJogoByDistinctOperacional(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public int updVJogo(VJogo jogo) {
		
		try {
		
			VJogoP jogoP = (VJogoP) jogo;
		
			String strNickTableMain = new String("J_P");
			String strTableMain = new String("FOOTBALL.DBO.JOGOS_P AS J_P");
			String[] strTableCompl = new String[10];
			strTableCompl[0] = new String("FOOTBALL.DBO.PARTICIPACOES_P AS PART_P");
			strTableCompl[1] = new String("FOOTBALL.DBO.TEMPORADAS AS TEMP");
			strTableCompl[2] = new String("FOOTBALL.DBO.CAMPEONATOS AS C");
			strTableCompl[3] = new String("FOOTBALL.DBO.PAISES AS P");
			strTableCompl[4] = new String("FOOTBALL.DBO.PAISES AS P1");
			strTableCompl[5] = new String("FOOTBALL.DBO.PAISES AS P2");
			strTableCompl[6] = new String("FOOTBALL.DBO.FASES AS F");
			strTableCompl[7] = new String("FOOTBALL.DBO.TURNOS AS T");
			strTableCompl[8] = new String("FOOTBALL.DBO.RODADAS AS R");
			strTableCompl[9] = new String("FOOTBALL.DBO.GRUPOS AS G");
			String[] strAssigns = new String[3];
			strAssigns[0] = new String("J_P.HOME_SCORE = " + ((jogoP.getHomeScore() == -1)? "NULL" : jogoP.getHomeScore()));
			strAssigns[1] = new String("J_P.AWAY_SCORE = " + ((jogoP.getAwayScore() == -1)? "NULL" : jogoP.getAwayScore()));
			strAssigns[2] = new String("J_P.DATA_JOGO = '" + jogoP.getDataJogo() + "'");
			String[] strConditions = new String[9];
			strConditions[0] = new String("C.CODIGO_PAIS_CAMPEONATO = '" + jogoP.getCodigoPaisCamp() + "'");
			strConditions[1] = new String("C.CODIGO_CAMPEONATO = '" + jogoP.getCodigoCamp() + "'");
			strConditions[2] = new String("TEMP.ANO_INICIO_TEMPORADA = '" + jogoP.getAnoInicioTemp() + "'");
			strConditions[3] = new String("TEMP.ANO_FIM_TEMPORADA = '" + jogoP.getAnoFimTemp() + "'");
			strConditions[4] = new String("J_P.CODIGO_FASE_JOGO = '" + jogoP.getCodigoFaseJogo() + "'");
			strConditions[5] = new String("J_P.CODIGO_TURNO_JOGO = '" + jogoP.getCodigoTurnoJogo() + "'");
			strConditions[6] = new String("J_P.CODIGO_RODADA_JOGO = '" + jogoP.getCodigoRodadaJogo() + "'");
			strConditions[7] = new String("J_P.CODIGO_GRUPO_JOGO = '" + jogoP.getCodigoGrupoJogo() + "'");
			strConditions[8] = new String("J_P.CODIGO_JOGO = '" + jogoP.getCodigoJogo() + "'");
			int[] intRelationshipTypes = new int[10];
			intRelationshipTypes[0] = 1;
			intRelationshipTypes[1] = 1;
			intRelationshipTypes[2] = 1;
			intRelationshipTypes[3] = 1;
			intRelationshipTypes[4] = 1;
			intRelationshipTypes[5] = 1;
			intRelationshipTypes[6] = 1;
			intRelationshipTypes[7] = 1;
			intRelationshipTypes[8] = 1;
			intRelationshipTypes[9] = 1;
			String[] strRelationships = new String[10];
			strRelationships[0] = new String("J_P.NUMERO_SEQUENCIAL_TEMPR = PART_P.NUMERO_SEQUENCIAL_TEMPR AND J_P.HOME_CODIGO_PAIS = PART_P.CODIGO_PAIS_PARTP");
			strRelationships[1] = new String("PART_P.NUMERO_SEQUENCIAL_TEMPR = TEMP.NUMERO_SEQUENCIAL_TEMPR");
			strRelationships[2] = new String("TEMP.CODIGO_PAIS_CAMPEONATO_TEMPR = C.CODIGO_PAIS_CAMPEONATO AND TEMP.CODIGO_CAMPEONATO_TEMPR = C.CODIGO_CAMPEONATO");
			strRelationships[3] = new String("C.CODIGO_PAIS_CAMPEONATO = P.CODIGO_PAIS");
			strRelationships[4] = new String("J_P.HOME_CODIGO_PAIS = P1.CODIGO_PAIS");
			strRelationships[5] = new String("J_P.AWAY_CODIGO_PAIS = P2.CODIGO_PAIS");
			strRelationships[6] = new String("J_P.CODIGO_FASE_JOGO = F.CODIGO_FASE");
			strRelationships[7] = new String("J_P.CODIGO_TURNO_JOGO = T.CODIGO_TURNO");
			strRelationships[8] = new String("J_P.CODIGO_RODADA_JOGO = R.CODIGO_RODADA");
			strRelationships[9] = new String("J_P.CODIGO_GRUPO_JOGO = G.CODIGO_GRUPO");
			
			String strQuery = DBUpdate.geraQuery(strNickTableMain, strTableMain, strTableCompl, strAssigns, strConditions, intRelationshipTypes, strRelationships).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.countUpdate = stmtAcesso.executeUpdate(strQuery);
			
			if (this.countUpdate != 0) {
			
				Error.setErroAplicacao(new String("RESULTADO ATUALIZADO COM SUCESSO!"));
				Error.setErroInterno(new String("VJogoPDAO.updVJogo(): OK"));
				
			}
			
			else {
			
				Error.setErroAplicacao(new String("NAO HA RESULTADO COM ESTE INDICE!"));
				Error.setErroInterno(new String("VJogoPDAO.updVJogo(): countUpdate zerado"));
				
			}
			
		}
		
		catch (Exception e) {
		
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VJogoPDAO.updVJogo(): " + e.toString()));
			
		}
		
		return this.countUpdate;
		
	}
	
}

