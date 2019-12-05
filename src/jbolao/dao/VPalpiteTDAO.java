package jbolao.dao;

import java.sql.SQLException;
import devito.db.DBConexoes;
import devito.db.DBQuery;
import devito.db.DBSelect;
import devito.db.DBUpdate;
import devito.dados.estruturas.DLista;
import jbolao.error.Error;
import jbolao.entity.VPalpite;
import jbolao.entity.VPalpiteT;

public class VPalpiteTDAO extends VPalpiteDAO {

	public VPalpiteT selVPalpiteByIdx(String strCodigoUsuario, String strNomeMesa, String strCodigoPaisCampeonato, String strCodigoCampeonato, String strAnoInicioTemporada, String strAnoFimTemporada, String strCodigoJogo, String strCodigoFaseJogo, String strCodigoTurnoJogo, String strCodigoRodadaJogo, String strCodigoGrupoJogo) {
	
		VPalpiteT palp;
		
		try {
		
			String strTableMain = new String("V_PALPITES_T");
			String[] strTableCompl = null;
			String[] strFields = new String[29];
			strFields[0] = new String("CODIGO_PAIS");
			strFields[1] = new String("NOME_PAIS");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("NOME_MESA");
			strFields[7] = new String("CODIGO_USUARIO");
			strFields[8] = new String("CODIGO_PAIS_HOME");
			strFields[9] = new String("CODIGO_TIME_HOME");
			strFields[10] = new String("NOME_TIME_HOME");
			strFields[11] = new String("HOME_SCORE");
			strFields[12] = new String("PALP_HOME_SCORE");
			strFields[13] = new String("CODIGO_PAIS_AWAY");
			strFields[14] = new String("CODIGO_TIME_AWAY");
			strFields[15] = new String("NOME_TIME_AWAY");
			strFields[16] = new String("AWAY_SCORE");
			strFields[17] = new String("PALP_AWAY_SCORE");
			strFields[18] = new String("PONTOS");
			strFields[19] = new String("CODIGO_JOGO");
			strFields[20] = new String("CODIGO_FASE_JOGO");
			strFields[21] = new String("DESC_FASE");
			strFields[22] = new String("CODIGO_TURNO_JOGO");
			strFields[23] = new String("DESC_TURNO");
			strFields[24] = new String("CODIGO_RODADA_JOGO");
			strFields[25] = new String("DESC_RODADA");
			strFields[26] = new String("CODIGO_GRUPO_JOGO");
			strFields[27] = new String("DESC_GRUPO");
			strFields[28] = new String("DATA_JOGO");
			String[] strConditions = new String[11];
			strConditions[0] = new String("CODIGO_USUARIO = '" + strCodigoUsuario + "'");
			strConditions[1] = new String("NOME_MESA = '" + strNomeMesa + "'");
			strConditions[2] = new String("CODIGO_PAIS = '" + strCodigoPaisCampeonato + "'");
			strConditions[3] = new String("CODIGO_CAMPEONATO = '" + strCodigoCampeonato + "'");
			strConditions[4] = new String("ANO_INICIO_TEMPORADA = '" + strAnoInicioTemporada + "'");
			strConditions[5] = new String("ANO_FIM_TEMPORADA = '" + strAnoFimTemporada + "'");
			strConditions[6] = new String("CODIGO_JOGO = '" + strCodigoJogo + "'");
			strConditions[7] = new String("CODIGO_FASE_JOGO = '" + strCodigoFaseJogo + "'");
			strConditions[8] = new String("CODIGO_TURNO_JOGO = '" + strCodigoTurnoJogo + "'");
			strConditions[9] = new String("CODIGO_RODADA_JOGO = '" + strCodigoRodadaJogo + "'");
			strConditions[10] = new String("CODIGO_GRUPO_JOGO = '" + strCodigoGrupoJogo + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = null;
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			if (this.rsltSelect.next()) {
			
				palp = new VPalpiteT();
				palp.setCodigoPaisCamp(rsltSelect.getString("CODIGO_PAIS"));
				palp.setNomePaisCamp(rsltSelect.getString("NOME_PAIS"));
				palp.setCodigoCamp(rsltSelect.getString("CODIGO_CAMPEONATO"));
				palp.setNomeCamp(rsltSelect.getString("NOME_CAMPEONATO"));
				palp.setAnoInicioTemp(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				palp.setAnoFimTemp(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				palp.setNomeMesa(rsltSelect.getString("NOME_MESA"));
				palp.setCodigoUsuario(rsltSelect.getString("CODIGO_USUARIO"));
				palp.setCodigoPaisHome(rsltSelect.getString("CODIGO_PAIS_HOME"));
				palp.setCodigoTimeHome(rsltSelect.getString("CODIGO_TIME_HOME"));
				palp.setNomeTimeHome(rsltSelect.getString("NOME_TIME_HOME"));
				palp.setHomeScore(rsltSelect.getInt("HOME_SCORE"));
				if (rsltSelect.wasNull())
					palp.setHomeScore(-1);
				palp.setPalpHomeScore(rsltSelect.getInt("PALP_HOME_SCORE"));
				if (rsltSelect.wasNull())
					palp.setPalpHomeScore(-1);
				palp.setCodigoPaisAway(rsltSelect.getString("CODIGO_PAIS_AWAY"));
				palp.setCodigoTimeAway(rsltSelect.getString("CODIGO_TIME_AWAY"));
				palp.setNomeTimeAway(rsltSelect.getString("NOME_TIME_AWAY"));
				palp.setAwayScore(rsltSelect.getInt("AWAY_SCORE"));
				if (rsltSelect.wasNull())
					palp.setAwayScore(-1);
				palp.setPalpAwayScore(rsltSelect.getInt("PALP_AWAY_SCORE"));
				if (rsltSelect.wasNull())
					palp.setPalpAwayScore(-1);
				palp.setPontos(rsltSelect.getInt("PONTOS"));
				palp.setCodigoJogo(rsltSelect.getString("CODIGO_JOGO"));
				palp.setCodigoFaseJogo(rsltSelect.getString("CODIGO_FASE_JOGO"));
				palp.setDescFaseJogo(rsltSelect.getString("DESC_FASE"));
				palp.setCodigoTurnoJogo(rsltSelect.getString("CODIGO_TURNO_JOGO"));
				palp.setDescTurnoJogo(rsltSelect.getString("DESC_TURNO"));
				palp.setCodigoRodadaJogo(rsltSelect.getString("CODIGO_RODADA_JOGO"));
				palp.setDescRodadaJogo(rsltSelect.getString("DESC_RODADA"));
				palp.setCodigoGrupoJogo(rsltSelect.getString("CODIGO_GRUPO_JOGO"));
				palp.setDescGrupoJogo(rsltSelect.getString("DESC_GRUPO"));
				palp.setDataJogo(rsltSelect.getString("DATA_JOGO"));
				
			}
			
			else {
			
				palp = null;			
				Error.setErroAplicacao(new String("NAO HA PALPITE COM ESTE INDICE!"));
				Error.setErroInterno(new String("VPalpiteTDAO.selVPalpiteByIdx(): rsltSelect nulo"));
				
			}
			
		}
		
		catch (Exception e) {
		
			palp = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VPalpiteTDAO.selVPalpiteByRodada(): " + e.toString()));
			
		}
		
		return palp;
		
	}
	
	public int updVPalpite(VPalpite palp) {
		
		try {
		
			VPalpiteT palpT = (VPalpiteT) palp;
		
			String strNickTableMain = new String("P_T");
			String strTableMain = new String("FOOTBALL.DBO.PALPITES_T AS P_T");
			String[] strTableCompl = new String[14];
			strTableCompl[0] = new String("FOOTBALL.DBO.JOGOS_T AS J_T");
			strTableCompl[1] = new String("FOOTBALL.DBO.PARTICIPACOES_T AS PART_T");
			strTableCompl[2] = new String("FOOTBALL.DBO.TEMPORADAS AS TEMP");
			strTableCompl[3] = new String("FOOTBALL.DBO.CAMPEONATOS AS C");
			strTableCompl[4] = new String("FOOTBALL.DBO.PAISES AS P");
			strTableCompl[5] = new String("FOOTBALL.DBO.TIMES AS T1");
			strTableCompl[6] = new String("FOOTBALL.DBO.TIMES AS T2");
			strTableCompl[7] = new String("FOOTBALL.DBO.FASES AS F");
			strTableCompl[8] = new String("FOOTBALL.DBO.TURNOS AS T");
			strTableCompl[9] = new String("FOOTBALL.DBO.RODADAS AS R");
			strTableCompl[10] = new String("FOOTBALL.DBO.GRUPOS AS G");
			strTableCompl[11] = new String("FOOTBALL.DBO.COMPETIDORES AS CMPT");
			strTableCompl[12] = new String("FOOTBALL.DBO.USUARIOS AS U");
			strTableCompl[13] = new String("FOOTBALL.DBO.MESA_BOLAO AS MB");
			String[] strAssigns = new String[2];
			strAssigns[0] = new String("P_T.HOME_SCORE = " + ((palpT.getPalpHomeScore() == -1)? "NULL" : palpT.getPalpHomeScore()));
			strAssigns[1] = new String("P_T.AWAY_SCORE = " + ((palpT.getPalpAwayScore() == -1)? "NULL" : palpT.getPalpAwayScore()));
			String[] strConditions = new String[11];
			strConditions[0] = new String("U.CODIGO_USUARIO = '" + palpT.getCodigoUsuario() + "'");
			strConditions[1] = new String("MB.NOME_MESA = '" + palpT.getNomeMesa() + "'");
			strConditions[2] = new String("C.CODIGO_PAIS_CAMPEONATO = '" + palpT.getCodigoPaisCamp() + "'");
			strConditions[3] = new String("C.CODIGO_CAMPEONATO = '" + palpT.getCodigoCamp() + "'");
			strConditions[4] = new String("TEMP.ANO_INICIO_TEMPORADA = '" + palpT.getAnoInicioTemp() + "'");
			strConditions[5] = new String("TEMP.ANO_FIM_TEMPORADA = '" + palpT.getAnoFimTemp() + "'");
			strConditions[6] = new String("J_T.CODIGO_FASE_JOGO = '" + palpT.getCodigoFaseJogo() + "'");
			strConditions[7] = new String("J_T.CODIGO_TURNO_JOGO = '" + palpT.getCodigoTurnoJogo() + "'");
			strConditions[8] = new String("J_T.CODIGO_RODADA_JOGO = '" + palpT.getCodigoRodadaJogo() + "'");
			strConditions[9] = new String("J_T.CODIGO_GRUPO_JOGO = '" + palpT.getCodigoGrupoJogo() + "'");
			strConditions[10] = new String("J_T.CODIGO_JOGO = '" + palpT.getCodigoJogo() + "'");
			int[] intRelationshipTypes = new int[14];
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
			intRelationshipTypes[10] = 1;
			intRelationshipTypes[11] = 1;
			intRelationshipTypes[12] = 1;
			intRelationshipTypes[13] = 1;			
			String[] strRelationships = new String[14];
			strRelationships[0] = new String("P_T.NUMERO_SEQUENCIAL_JOGR = J_T.NUMERO_SEQUENCIAL_JOGR");
			strRelationships[1] = new String("J_T.NUMERO_SEQUENCIAL_TEMPR = PART_T.NUMERO_SEQUENCIAL_TEMPR AND J_T.HOME_CODIGO_PAIS = PART_T.CODIGO_PAIS_PARTT AND J_T.HOME_CODIGO_TIME = PART_T.CODIGO_TIME_PARTT");
			strRelationships[2] = new String("PART_T.NUMERO_SEQUENCIAL_TEMPR = TEMP.NUMERO_SEQUENCIAL_TEMPR");
			strRelationships[3] = new String("TEMP.CODIGO_PAIS_CAMPEONATO_TEMPR = C.CODIGO_PAIS_CAMPEONATO AND TEMP.CODIGO_CAMPEONATO_TEMPR = C.CODIGO_CAMPEONATO");
			strRelationships[4] = new String("C.CODIGO_PAIS_CAMPEONATO = P.CODIGO_PAIS");
			strRelationships[5] = new String("J_T.HOME_CODIGO_PAIS = T1.CODIGO_PAIS_TIME AND J_T.HOME_CODIGO_TIME = T1.CODIGO_TIME");
			strRelationships[6] = new String("J_T.AWAY_CODIGO_PAIS = T2.CODIGO_PAIS_TIME AND J_T.AWAY_CODIGO_TIME = T2.CODIGO_TIME");
			strRelationships[7] = new String("J_T.CODIGO_FASE_JOGO = F.CODIGO_FASE");
			strRelationships[8] = new String("J_T.CODIGO_TURNO_JOGO = T.CODIGO_TURNO");
			strRelationships[9] = new String("J_T.CODIGO_RODADA_JOGO = R.CODIGO_RODADA");
			strRelationships[10] = new String("J_T.CODIGO_GRUPO_JOGO = G.CODIGO_GRUPO");
			strRelationships[11] = new String("P_T.NUMERO_SEQUENCIAL_CMPT = CMPT.NUMERO_SEQUENCIAL_CMPT");
			strRelationships[12] = new String("CMPT.CODIGO_USUARIO_CMPT = U.CODIGO_USUARIO");
			strRelationships[13] = new String("CMPT.NOME_MESA_CMPT = MB.NOME_MESA");
			
			String strQuery = DBUpdate.geraQuery(strNickTableMain, strTableMain, strTableCompl, strAssigns, strConditions, intRelationshipTypes, strRelationships).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.countUpdate = stmtAcesso.executeUpdate(strQuery);
			
			if (this.countUpdate != 0) {
			
				Error.setErroAplicacao(new String("PALPITE ATUALIZADO COM SUCESSO!"));
				Error.setErroInterno(new String("VPalpiteTDAO.updVPalpite(): OK"));
				
			}
			
			else {
			
				Error.setErroAplicacao(new String("NAO HA PALPITE COM ESTE INDICE!"));
				Error.setErroInterno(new String("VPalpiteTDAO.updVPalpite(): countUpdate zerado"));
				
			}
			
		}
		
		catch (Exception e) {
		
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VPalpiteTDAO.updVPalpite(): " + e.toString()));
			
		}
		
		return this.countUpdate;
		
	}
	
}

