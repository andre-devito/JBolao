package jbolao.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import devito.db.DBConexoes;
import devito.db.DBQuery;
import devito.db.DBSelect;
import devito.dados.estruturas.DLista;
import jbolao.error.Error;
import jbolao.entity.VTemp;

public class VTempDAO {

	private static Connection cnctAcesso = null;
	private static Statement stmtAcesso = null;
	private static ResultSet rsltSelect = null;
	
	public VTemp selVTempByTemporada(String strCodigoPaisCampeonato, String strCodigoCampeonato, String strAnoInicioTemporada, String strAnoFimTemporada) {
	
		VTemp temp;
		
		try {
		
			String strTableMain = new String("V_TEMPORADAS");
			String[] strTableCompl = null;
			String[] strFields = new String[22];
			strFields[0] = new String("CODIGO_PAIS_CAMPEONATO");
			strFields[1] = new String("NOME_PAIS_CAMPEONATO");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_PAIS_CAMPEAO");
			strFields[7] = new String("NOME_PAIS_CAMPEAO");
			strFields[8] = new String("CODIGO_TIME_CAMPEAO");
			strFields[9] = new String("NOME_TIME_CAMPEAO");
			strFields[10] = new String("CODIGO_PAIS_VICE");
			strFields[11] = new String("NOME_PAIS_VICE");
			strFields[12] = new String("CODIGO_TIME_VICE");
			strFields[13] = new String("NOME_TIME_VICE");
			strFields[14] = new String("CODIGO_PAIS_TERCEIRO");
			strFields[15] = new String("NOME_PAIS_TERCEIRO");
			strFields[16] = new String("CODIGO_TIME_TERCEIRO");
			strFields[17] = new String("NOME_TIME_TERCEIRO");
			strFields[18] = new String("CODIGO_PAIS_QUARTO");
			strFields[19] = new String("NOME_PAIS_QUARTO");
			strFields[20] = new String("CODIGO_TIME_QUARTO");
			strFields[21] = new String("NOME_TIME_QUARTO");
			String[] strConditions = new String[4];
			strConditions[0] = new String("CODIGO_PAIS_CAMPEONATO = '" + strCodigoPaisCampeonato + "'");
			strConditions[1] = new String("CODIGO_CAMPEONATO = '" + strCodigoCampeonato + "'");
			strConditions[2] = new String("ANO_INICIO_TEMPORADA = '" + strAnoInicioTemporada + "'");
			strConditions[3] = new String("ANO_FIM_TEMPORADA = '" + strAnoFimTemporada + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = null;
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			if (this.rsltSelect.next()) {
			
				temp = new VTemp();
				temp.setCodigoPaisCampeonato(rsltSelect.getString("CODIGO_PAIS_CAMPEONATO"));
				temp.setNomePaisCampeonato(rsltSelect.getString("NOME_PAIS_CAMPEONATO"));
				temp.setCodigoCampeonato(rsltSelect.getString("CODIGO_CAMPEONATO"));
				temp.setNomeCampeonato(rsltSelect.getString("NOME_CAMPEONATO"));
				temp.setAnoInicioTemporada(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				temp.setAnoFimTemporada(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				temp.setCodigoPaisCampeao(rsltSelect.getString("CODIGO_PAIS_CAMPEAO"));
				temp.setNomePaisCampeao(rsltSelect.getString("NOME_PAIS_CAMPEAO"));
				temp.setCodigoTimeCampeao(rsltSelect.getString("CODIGO_TIME_CAMPEAO"));
				temp.setNomeTimeCampeao(rsltSelect.getString("NOME_TIME_CAMPEAO"));
				temp.setCodigoPaisVice(rsltSelect.getString("CODIGO_PAIS_VICE"));
				temp.setNomePaisVice(rsltSelect.getString("NOME_PAIS_VICE"));
				temp.setCodigoTimeVice(rsltSelect.getString("CODIGO_TIME_VICE"));
				temp.setNomeTimeVice(rsltSelect.getString("NOME_TIME_VICE"));
				temp.setCodigoPaisTerceiro(rsltSelect.getString("CODIGO_PAIS_TERCEIRO"));
				temp.setNomePaisTerceiro(rsltSelect.getString("NOME_PAIS_TERCEIRO"));
				temp.setCodigoTimeTerceiro(rsltSelect.getString("CODIGO_TIME_TERCEIRO"));
				temp.setNomeTimeTerceiro(rsltSelect.getString("NOME_TIME_TERCEIRO"));
				temp.setCodigoPaisQuarto(rsltSelect.getString("CODIGO_PAIS_QUARTO"));
				temp.setNomePaisQuarto(rsltSelect.getString("NOME_PAIS_QUARTO"));
				temp.setCodigoTimeQuarto(rsltSelect.getString("CODIGO_TIME_QUARTO"));
				temp.setNomeTimeQuarto(rsltSelect.getString("NOME_TIME_QUARTO"));
				
			}
			
			else {
			
				temp = null;
				Error.setErroAplicacao(new String("NAO HA TEMPORADA COM ESTE CODIGO!"));
				Error.setErroInterno(new String("VTempDAO.selVTempByTemporada(): rsltSelect nulo"));
				
			}
			
		}
		
		catch (Exception e) {
		
			temp = null;
			Error.setErroAplicacao(new String("NAO FOI POSSIVEL EFETUAR ESTA BUSCA."));
			Error.setErroInterno(new String("VTempDAO.selVTempByTemporada(): " + e.toString()));
			
		}
		
		return temp;
		
	}
		
	public DLista selVTempListaByPaisCampeonato(String strCodigoPaisCampeonato, String strCodigoCampeonato) {
	
		DLista DL = new DLista();
		VTemp temp;
		
		try {
		
			String strTableMain = new String("V_TEMPORADAS");
			String[] strTableCompl = null;
			String[] strFields = new String[22];
			strFields[0] = new String("CODIGO_PAIS_CAMPEONATO");
			strFields[1] = new String("NOME_PAIS_CAMPEONATO");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_PAIS_CAMPEAO");
			strFields[7] = new String("NOME_PAIS_CAMPEAO");
			strFields[8] = new String("CODIGO_TIME_CAMPEAO");
			strFields[9] = new String("NOME_TIME_CAMPEAO");
			strFields[10] = new String("CODIGO_PAIS_VICE");
			strFields[11] = new String("NOME_PAIS_VICE");
			strFields[12] = new String("CODIGO_TIME_VICE");
			strFields[13] = new String("NOME_TIME_VICE");
			strFields[14] = new String("CODIGO_PAIS_TERCEIRO");
			strFields[15] = new String("NOME_PAIS_TERCEIRO");
			strFields[16] = new String("CODIGO_TIME_TERCEIRO");
			strFields[17] = new String("NOME_TIME_TERCEIRO");
			strFields[18] = new String("CODIGO_PAIS_QUARTO");
			strFields[19] = new String("NOME_PAIS_QUARTO");
			strFields[20] = new String("CODIGO_TIME_QUARTO");
			strFields[21] = new String("NOME_TIME_QUARTO");
			String[] strConditions = new String[2];
			strConditions[0] = new String("CODIGO_PAIS_CAMPEONATO = '" + strCodigoPaisCampeonato + "'");
			strConditions[1] = new String("CODIGO_CAMPEONATO = '" + strCodigoCampeonato + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[2];
			strOrder[0] = new String("ANO_FIM_TEMPORADA DESC");
			strOrder[1] = new String("ANO_INICIO_TEMPORADA DESC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				temp = new VTemp();
				temp.setCodigoPaisCampeonato(rsltSelect.getString("CODIGO_PAIS_CAMPEONATO"));
				temp.setNomePaisCampeonato(rsltSelect.getString("NOME_PAIS_CAMPEONATO"));
				temp.setCodigoCampeonato(rsltSelect.getString("CODIGO_CAMPEONATO"));
				temp.setNomeCampeonato(rsltSelect.getString("NOME_CAMPEONATO"));
				temp.setAnoInicioTemporada(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				temp.setAnoFimTemporada(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				temp.setCodigoPaisCampeao(rsltSelect.getString("CODIGO_PAIS_CAMPEAO"));
				temp.setNomePaisCampeao(rsltSelect.getString("NOME_PAIS_CAMPEAO"));
				temp.setCodigoTimeCampeao(rsltSelect.getString("CODIGO_TIME_CAMPEAO"));
				temp.setNomeTimeCampeao(rsltSelect.getString("NOME_TIME_CAMPEAO"));
				temp.setCodigoPaisVice(rsltSelect.getString("CODIGO_PAIS_VICE"));
				temp.setNomePaisVice(rsltSelect.getString("NOME_PAIS_VICE"));
				temp.setCodigoTimeVice(rsltSelect.getString("CODIGO_TIME_VICE"));
				temp.setNomeTimeVice(rsltSelect.getString("NOME_TIME_VICE"));
				temp.setCodigoPaisTerceiro(rsltSelect.getString("CODIGO_PAIS_TERCEIRO"));
				temp.setNomePaisTerceiro(rsltSelect.getString("NOME_PAIS_TERCEIRO"));
				temp.setCodigoTimeTerceiro(rsltSelect.getString("CODIGO_TIME_TERCEIRO"));
				temp.setNomeTimeTerceiro(rsltSelect.getString("NOME_TIME_TERCEIRO"));
				temp.setCodigoPaisQuarto(rsltSelect.getString("CODIGO_PAIS_QUARTO"));
				temp.setNomePaisQuarto(rsltSelect.getString("NOME_PAIS_QUARTO"));
				temp.setCodigoTimeQuarto(rsltSelect.getString("CODIGO_TIME_QUARTO"));
				temp.setNomeTimeQuarto(rsltSelect.getString("NOME_TIME_QUARTO"));
				boolean b = DL.InsereFim(temp);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VTempDAO.selVTempListaByPaisCampeonato(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVTempListaByCampeonato(String strCodigoCampeonato) {
	
		DLista DL = new DLista();
		VTemp temp;
		
		try {
		
			String strTableMain = new String("V_TEMPORADAS");
			String[] strTableCompl = null;
			String[] strFields = new String[22];
			strFields[0] = new String("CODIGO_PAIS_CAMPEONATO");
			strFields[1] = new String("NOME_PAIS_CAMPEONATO");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_PAIS_CAMPEAO");
			strFields[7] = new String("NOME_PAIS_CAMPEAO");
			strFields[8] = new String("CODIGO_TIME_CAMPEAO");
			strFields[9] = new String("NOME_TIME_CAMPEAO");
			strFields[10] = new String("CODIGO_PAIS_VICE");
			strFields[11] = new String("NOME_PAIS_VICE");
			strFields[12] = new String("CODIGO_TIME_VICE");
			strFields[13] = new String("NOME_TIME_VICE");
			strFields[14] = new String("CODIGO_PAIS_TERCEIRO");
			strFields[15] = new String("NOME_PAIS_TERCEIRO");
			strFields[16] = new String("CODIGO_TIME_TERCEIRO");
			strFields[17] = new String("NOME_TIME_TERCEIRO");
			strFields[18] = new String("CODIGO_PAIS_QUARTO");
			strFields[19] = new String("NOME_PAIS_QUARTO");
			strFields[20] = new String("CODIGO_TIME_QUARTO");
			strFields[21] = new String("NOME_TIME_QUARTO");
			String[] strConditions = new String[1];
			strConditions[0] = new String("CODIGO_CAMPEONATO = '" + strCodigoCampeonato + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[2];
			strOrder[0] = new String("ANO_FIM_TEMPORADA DESC");
			strOrder[1] = new String("ANO_INICIO_TEMPORADA DESC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				temp = new VTemp();
				temp.setCodigoPaisCampeonato(rsltSelect.getString("CODIGO_PAIS_CAMPEONATO"));
				temp.setNomePaisCampeonato(rsltSelect.getString("NOME_PAIS_CAMPEONATO"));
				temp.setCodigoCampeonato(rsltSelect.getString("CODIGO_CAMPEONATO"));
				temp.setNomeCampeonato(rsltSelect.getString("NOME_CAMPEONATO"));
				temp.setAnoInicioTemporada(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				temp.setAnoFimTemporada(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				temp.setCodigoPaisCampeao(rsltSelect.getString("CODIGO_PAIS_CAMPEAO"));
				temp.setNomePaisCampeao(rsltSelect.getString("NOME_PAIS_CAMPEAO"));
				temp.setCodigoTimeCampeao(rsltSelect.getString("CODIGO_TIME_CAMPEAO"));
				temp.setNomeTimeCampeao(rsltSelect.getString("NOME_TIME_CAMPEAO"));
				temp.setCodigoPaisVice(rsltSelect.getString("CODIGO_PAIS_VICE"));
				temp.setNomePaisVice(rsltSelect.getString("NOME_PAIS_VICE"));
				temp.setCodigoTimeVice(rsltSelect.getString("CODIGO_TIME_VICE"));
				temp.setNomeTimeVice(rsltSelect.getString("NOME_TIME_VICE"));
				temp.setCodigoPaisTerceiro(rsltSelect.getString("CODIGO_PAIS_TERCEIRO"));
				temp.setNomePaisTerceiro(rsltSelect.getString("NOME_PAIS_TERCEIRO"));
				temp.setCodigoTimeTerceiro(rsltSelect.getString("CODIGO_TIME_TERCEIRO"));
				temp.setNomeTimeTerceiro(rsltSelect.getString("NOME_TIME_TERCEIRO"));
				temp.setCodigoPaisQuarto(rsltSelect.getString("CODIGO_PAIS_QUARTO"));
				temp.setNomePaisQuarto(rsltSelect.getString("NOME_PAIS_QUARTO"));
				temp.setCodigoTimeQuarto(rsltSelect.getString("CODIGO_TIME_QUARTO"));
				temp.setNomeTimeQuarto(rsltSelect.getString("NOME_TIME_QUARTO"));
				boolean b = DL.InsereFim(temp);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VTempDAO.selVTempListaByCampeonato(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVTempNotNullListaByPaisCampeonato(String strCodigoPaisCampeonato, String strCodigoCampeonato) {
	
		DLista DL = new DLista();
		VTemp temp;
		
		try {
		
			String strTableMain = new String("V_TEMPORADAS");
			String[] strTableCompl = null;
			String[] strFields = new String[22];
			strFields[0] = new String("CODIGO_PAIS_CAMPEONATO");
			strFields[1] = new String("NOME_PAIS_CAMPEONATO");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_PAIS_CAMPEAO");
			strFields[7] = new String("NOME_PAIS_CAMPEAO");
			strFields[8] = new String("CODIGO_TIME_CAMPEAO");
			strFields[9] = new String("NOME_TIME_CAMPEAO");
			strFields[10] = new String("CODIGO_PAIS_VICE");
			strFields[11] = new String("NOME_PAIS_VICE");
			strFields[12] = new String("CODIGO_TIME_VICE");
			strFields[13] = new String("NOME_TIME_VICE");
			strFields[14] = new String("CODIGO_PAIS_TERCEIRO");
			strFields[15] = new String("NOME_PAIS_TERCEIRO");
			strFields[16] = new String("CODIGO_TIME_TERCEIRO");
			strFields[17] = new String("NOME_TIME_TERCEIRO");
			strFields[18] = new String("CODIGO_PAIS_QUARTO");
			strFields[19] = new String("NOME_PAIS_QUARTO");
			strFields[20] = new String("CODIGO_TIME_QUARTO");
			strFields[21] = new String("NOME_TIME_QUARTO");
			String[] strConditions = new String[4];
			strConditions[0] = new String("CODIGO_PAIS_CAMPEONATO = '" + strCodigoPaisCampeonato + "'");
			strConditions[1] = new String("CODIGO_CAMPEONATO = '" + strCodigoCampeonato + "'");
			strConditions[2] = new String("CODIGO_PAIS_CAMPEAO IS NOT NULL");
			strConditions[3] = new String("CODIGO_TIME_CAMPEAO IS NOT NULL");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[2];
			strOrder[0] = new String("ANO_FIM_TEMPORADA DESC");
			strOrder[1] = new String("ANO_INICIO_TEMPORADA DESC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				temp = new VTemp();
				temp.setCodigoPaisCampeonato(rsltSelect.getString("CODIGO_PAIS_CAMPEONATO"));
				temp.setNomePaisCampeonato(rsltSelect.getString("NOME_PAIS_CAMPEONATO"));
				temp.setCodigoCampeonato(rsltSelect.getString("CODIGO_CAMPEONATO"));
				temp.setNomeCampeonato(rsltSelect.getString("NOME_CAMPEONATO"));
				temp.setAnoInicioTemporada(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				temp.setAnoFimTemporada(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				temp.setCodigoPaisCampeao(rsltSelect.getString("CODIGO_PAIS_CAMPEAO"));
				temp.setNomePaisCampeao(rsltSelect.getString("NOME_PAIS_CAMPEAO"));
				temp.setCodigoTimeCampeao(rsltSelect.getString("CODIGO_TIME_CAMPEAO"));
				temp.setNomeTimeCampeao(rsltSelect.getString("NOME_TIME_CAMPEAO"));
				temp.setCodigoPaisVice(rsltSelect.getString("CODIGO_PAIS_VICE"));
				temp.setNomePaisVice(rsltSelect.getString("NOME_PAIS_VICE"));
				temp.setCodigoTimeVice(rsltSelect.getString("CODIGO_TIME_VICE"));
				temp.setNomeTimeVice(rsltSelect.getString("NOME_TIME_VICE"));
				temp.setCodigoPaisTerceiro(rsltSelect.getString("CODIGO_PAIS_TERCEIRO"));
				temp.setNomePaisTerceiro(rsltSelect.getString("NOME_PAIS_TERCEIRO"));
				temp.setCodigoTimeTerceiro(rsltSelect.getString("CODIGO_TIME_TERCEIRO"));
				temp.setNomeTimeTerceiro(rsltSelect.getString("NOME_TIME_TERCEIRO"));
				temp.setCodigoPaisQuarto(rsltSelect.getString("CODIGO_PAIS_QUARTO"));
				temp.setNomePaisQuarto(rsltSelect.getString("NOME_PAIS_QUARTO"));
				temp.setCodigoTimeQuarto(rsltSelect.getString("CODIGO_TIME_QUARTO"));
				temp.setNomeTimeQuarto(rsltSelect.getString("NOME_TIME_QUARTO"));
				boolean b = DL.InsereFim(temp);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VTempDAO.selVTempNotNullListaByPaisCampeonato(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVTempNotNullListaByCampeonato(String strCodigoCampeonato) {
	
		DLista DL = new DLista();
		VTemp temp;
		
		try {
		
			String strTableMain = new String("V_TEMPORADAS");
			String[] strTableCompl = null;
			String[] strFields = new String[22];
			strFields[0] = new String("CODIGO_PAIS_CAMPEONATO");
			strFields[1] = new String("NOME_PAIS_CAMPEONATO");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_PAIS_CAMPEAO");
			strFields[7] = new String("NOME_PAIS_CAMPEAO");
			strFields[8] = new String("CODIGO_TIME_CAMPEAO");
			strFields[9] = new String("NOME_TIME_CAMPEAO");
			strFields[10] = new String("CODIGO_PAIS_VICE");
			strFields[11] = new String("NOME_PAIS_VICE");
			strFields[12] = new String("CODIGO_TIME_VICE");
			strFields[13] = new String("NOME_TIME_VICE");
			strFields[14] = new String("CODIGO_PAIS_TERCEIRO");
			strFields[15] = new String("NOME_PAIS_TERCEIRO");
			strFields[16] = new String("CODIGO_TIME_TERCEIRO");
			strFields[17] = new String("NOME_TIME_TERCEIRO");
			strFields[18] = new String("CODIGO_PAIS_QUARTO");
			strFields[19] = new String("NOME_PAIS_QUARTO");
			strFields[20] = new String("CODIGO_TIME_QUARTO");
			strFields[21] = new String("NOME_TIME_QUARTO");
			String[] strConditions = new String[2];
			strConditions[0] = new String("CODIGO_CAMPEONATO = '" + strCodigoCampeonato + "'");
			strConditions[1] = new String("CODIGO_PAIS_CAMPEAO IS NOT NULL");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[2];
			strOrder[0] = new String("ANO_FIM_TEMPORADA DESC");
			strOrder[1] = new String("ANO_INICIO_TEMPORADA DESC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				temp = new VTemp();
				temp.setCodigoPaisCampeonato(rsltSelect.getString("CODIGO_PAIS_CAMPEONATO"));
				temp.setNomePaisCampeonato(rsltSelect.getString("NOME_PAIS_CAMPEONATO"));
				temp.setCodigoCampeonato(rsltSelect.getString("CODIGO_CAMPEONATO"));
				temp.setNomeCampeonato(rsltSelect.getString("NOME_CAMPEONATO"));
				temp.setAnoInicioTemporada(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				temp.setAnoFimTemporada(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				temp.setCodigoPaisCampeao(rsltSelect.getString("CODIGO_PAIS_CAMPEAO"));
				temp.setNomePaisCampeao(rsltSelect.getString("NOME_PAIS_CAMPEAO"));
				temp.setCodigoTimeCampeao(rsltSelect.getString("CODIGO_TIME_CAMPEAO"));
				temp.setNomeTimeCampeao(rsltSelect.getString("NOME_TIME_CAMPEAO"));
				temp.setCodigoPaisVice(rsltSelect.getString("CODIGO_PAIS_VICE"));
				temp.setNomePaisVice(rsltSelect.getString("NOME_PAIS_VICE"));
				temp.setCodigoTimeVice(rsltSelect.getString("CODIGO_TIME_VICE"));
				temp.setNomeTimeVice(rsltSelect.getString("NOME_TIME_VICE"));
				temp.setCodigoPaisTerceiro(rsltSelect.getString("CODIGO_PAIS_TERCEIRO"));
				temp.setNomePaisTerceiro(rsltSelect.getString("NOME_PAIS_TERCEIRO"));
				temp.setCodigoTimeTerceiro(rsltSelect.getString("CODIGO_TIME_TERCEIRO"));
				temp.setNomeTimeTerceiro(rsltSelect.getString("NOME_TIME_TERCEIRO"));
				temp.setCodigoPaisQuarto(rsltSelect.getString("CODIGO_PAIS_QUARTO"));
				temp.setNomePaisQuarto(rsltSelect.getString("NOME_PAIS_QUARTO"));
				temp.setCodigoTimeQuarto(rsltSelect.getString("CODIGO_TIME_QUARTO"));
				temp.setNomeTimeQuarto(rsltSelect.getString("NOME_TIME_QUARTO"));
				boolean b = DL.InsereFim(temp);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VTempDAO.selVTempNotNullListaByCampeonato(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVTempNotNullListaResumidaByPaisCampeonato(String strCodigoPaisCampeonato, String strCodigoCampeonato) {
	
		DLista DL = new DLista();
		VTemp temp;
		
		try {
		
			String strTableMain = new String("V_TEMPORADAS");
			String[] strTableCompl = null;
			String[] strFields = new String[9];
			strFields[0] = new String("CODIGO_PAIS_CAMPEONATO");
			strFields[1] = new String("NOME_PAIS_CAMPEONATO");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("CODIGO_PAIS_CAMPEAO");
			strFields[5] = new String("NOME_PAIS_CAMPEAO");
			strFields[6] = new String("CODIGO_TIME_CAMPEAO");
			strFields[7] = new String("NOME_TIME_CAMPEAO");
			strFields[8] = new String("COUNT(*) AS NUMERO_TITULOS");
			String[] strConditions = new String[4];
			strConditions[0] = new String("CODIGO_PAIS_CAMPEONATO = '" + strCodigoPaisCampeonato + "'");
			strConditions[1] = new String("CODIGO_CAMPEONATO = '" + strCodigoCampeonato + "'");
			strConditions[2] = new String("CODIGO_PAIS_CAMPEAO IS NOT NULL");
			strConditions[3] = new String("CODIGO_TIME_CAMPEAO IS NOT NULL");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = new String[8];
			strGroup[0] = new String("CODIGO_PAIS_CAMPEONATO");
			strGroup[1] = new String("NOME_PAIS_CAMPEONATO");
			strGroup[2] = new String("CODIGO_CAMPEONATO");
			strGroup[3] = new String("NOME_CAMPEONATO");
			strGroup[4] = new String("CODIGO_PAIS_CAMPEAO");
			strGroup[5] = new String("NOME_PAIS_CAMPEAO");
			strGroup[6] = new String("CODIGO_TIME_CAMPEAO");
			strGroup[7] = new String("NOME_TIME_CAMPEAO");
			String[] strOrder = new String[2];
			strOrder[0] = new String("NUMERO_TITULOS DESC");
			strOrder[1] = new String("NOME_TIME_CAMPEAO ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				temp = new VTemp();
				temp.setCodigoPaisCampeonato(rsltSelect.getString("CODIGO_PAIS_CAMPEONATO"));
				temp.setNomePaisCampeonato(rsltSelect.getString("NOME_PAIS_CAMPEONATO"));
				temp.setCodigoCampeonato(rsltSelect.getString("CODIGO_CAMPEONATO"));
				temp.setNomeCampeonato(rsltSelect.getString("NOME_CAMPEONATO"));
				temp.setCodigoPaisCampeao(rsltSelect.getString("CODIGO_PAIS_CAMPEAO"));
				temp.setNomePaisCampeao(rsltSelect.getString("NOME_PAIS_CAMPEAO"));
				temp.setCodigoTimeCampeao(rsltSelect.getString("CODIGO_TIME_CAMPEAO"));
				temp.setNomeTimeCampeao(rsltSelect.getString("NOME_TIME_CAMPEAO"));
				temp.setContadorTemp(rsltSelect.getInt("NUMERO_TITULOS"));
				boolean b = DL.InsereFim(temp);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VTempDAO.selVTempNotNullListaResumidaByPaisCampeonato(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVTempNotNullListaResumidaByCampeonato(String strCodigoCampeonato) {
	
		DLista DL = new DLista();
		VTemp temp;
		
		try {
		
			String strTableMain = new String("V_TEMPORADAS");
			String[] strTableCompl = null;
			String[] strFields = new String[5];
			strFields[0] = new String("CODIGO_CAMPEONATO");
			strFields[1] = new String("NOME_CAMPEONATO");
			strFields[2] = new String("CODIGO_PAIS_CAMPEAO");
			strFields[3] = new String("NOME_PAIS_CAMPEAO");
			strFields[4] = new String("COUNT(*) AS NUMERO_TITULOS");
			String[] strConditions = new String[2];
			strConditions[0] = new String("CODIGO_CAMPEONATO = '" + strCodigoCampeonato + "'");
			strConditions[1] = new String("CODIGO_PAIS_CAMPEAO IS NOT NULL");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = new String[4];
			strGroup[0] = new String("CODIGO_CAMPEONATO");
			strGroup[1] = new String("NOME_CAMPEONATO");
			strGroup[2] = new String("CODIGO_PAIS_CAMPEAO");
			strGroup[3] = new String("NOME_PAIS_CAMPEAO");
			String[] strOrder = new String[2];
			strOrder[0] = new String("NUMERO_TITULOS DESC");
			strOrder[1] = new String("NOME_PAIS_CAMPEAO ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				temp = new VTemp();
				temp.setCodigoCampeonato(rsltSelect.getString("CODIGO_CAMPEONATO"));
				temp.setNomeCampeonato(rsltSelect.getString("NOME_CAMPEONATO"));
				temp.setCodigoPaisCampeao(rsltSelect.getString("CODIGO_PAIS_CAMPEAO"));
				temp.setNomePaisCampeao(rsltSelect.getString("NOME_PAIS_CAMPEAO"));
				temp.setContadorTemp(rsltSelect.getInt("NUMERO_TITULOS"));
				boolean b = DL.InsereFim(temp);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VTempDAO.selVTempNotNullListaResumidaByCampeonato(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVTempListaClubsNac() {
	
		DLista DL = new DLista();
		VTemp temp;
		
		try {
		
			String strTableMain = new String("V_TEMPORADAS");
			String[] strTableCompl = null;
			String[] strFields = new String[22];
			strFields[0] = new String("CODIGO_PAIS_CAMPEONATO");
			strFields[1] = new String("NOME_PAIS_CAMPEONATO");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_PAIS_CAMPEAO");
			strFields[7] = new String("NOME_PAIS_CAMPEAO");
			strFields[8] = new String("CODIGO_TIME_CAMPEAO");
			strFields[9] = new String("NOME_TIME_CAMPEAO");
			strFields[10] = new String("CODIGO_PAIS_VICE");
			strFields[11] = new String("NOME_PAIS_VICE");
			strFields[12] = new String("CODIGO_TIME_VICE");
			strFields[13] = new String("NOME_TIME_VICE");
			strFields[14] = new String("CODIGO_PAIS_TERCEIRO");
			strFields[15] = new String("NOME_PAIS_TERCEIRO");
			strFields[16] = new String("CODIGO_TIME_TERCEIRO");
			strFields[17] = new String("NOME_TIME_TERCEIRO");
			strFields[18] = new String("CODIGO_PAIS_QUARTO");
			strFields[19] = new String("NOME_PAIS_QUARTO");
			strFields[20] = new String("CODIGO_TIME_QUARTO");
			strFields[21] = new String("NOME_TIME_QUARTO");
			String[] strConditions = new String[3];
			strConditions[0] = new String("CODIGO_PAIS_CAMPEONATO >= '001'");
			strConditions[1] = new String("CODIGO_CAMPEONATO >= '001'");
			strConditions[2] = new String("CODIGO_CAMPEONATO <= '199'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[4];
			strOrder[0] = new String("CODIGO_PAIS_CAMPEONATO ASC");
			strOrder[1] = new String("CODIGO_CAMPEONATO ASC");
			strOrder[2] = new String("ANO_FIM_TEMPORADA DESC");
			strOrder[3] = new String("ANO_INICIO_TEMPORADA DESC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				temp = new VTemp();
				temp.setCodigoPaisCampeonato(rsltSelect.getString("CODIGO_PAIS_CAMPEONATO"));
				temp.setNomePaisCampeonato(rsltSelect.getString("NOME_PAIS_CAMPEONATO"));
				temp.setCodigoCampeonato(rsltSelect.getString("CODIGO_CAMPEONATO"));
				temp.setNomeCampeonato(rsltSelect.getString("NOME_CAMPEONATO"));
				temp.setAnoInicioTemporada(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				temp.setAnoFimTemporada(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				temp.setCodigoPaisCampeao(rsltSelect.getString("CODIGO_PAIS_CAMPEAO"));
				temp.setNomePaisCampeao(rsltSelect.getString("NOME_PAIS_CAMPEAO"));
				temp.setCodigoTimeCampeao(rsltSelect.getString("CODIGO_TIME_CAMPEAO"));
				temp.setNomeTimeCampeao(rsltSelect.getString("NOME_TIME_CAMPEAO"));
				temp.setCodigoPaisVice(rsltSelect.getString("CODIGO_PAIS_VICE"));
				temp.setNomePaisVice(rsltSelect.getString("NOME_PAIS_VICE"));
				temp.setCodigoTimeVice(rsltSelect.getString("CODIGO_TIME_VICE"));
				temp.setNomeTimeVice(rsltSelect.getString("NOME_TIME_VICE"));
				temp.setCodigoPaisTerceiro(rsltSelect.getString("CODIGO_PAIS_TERCEIRO"));
				temp.setNomePaisTerceiro(rsltSelect.getString("NOME_PAIS_TERCEIRO"));
				temp.setCodigoTimeTerceiro(rsltSelect.getString("CODIGO_TIME_TERCEIRO"));
				temp.setNomeTimeTerceiro(rsltSelect.getString("NOME_TIME_TERCEIRO"));
				temp.setCodigoPaisQuarto(rsltSelect.getString("CODIGO_PAIS_QUARTO"));
				temp.setNomePaisQuarto(rsltSelect.getString("NOME_PAIS_QUARTO"));
				temp.setCodigoTimeQuarto(rsltSelect.getString("CODIGO_TIME_QUARTO"));
				temp.setNomeTimeQuarto(rsltSelect.getString("NOME_TIME_QUARTO"));
				boolean b = DL.InsereFim(temp);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VTempDAO.selVTempListaClubsNac(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVTempListaClubsInter() {
	
		DLista DL = new DLista();
		VTemp temp;
		
		try {
		
			String strTableMain = new String("V_TEMPORADAS");
			String[] strTableCompl = null;
			String[] strFields = new String[22];
			strFields[0] = new String("CODIGO_PAIS_CAMPEONATO");
			strFields[1] = new String("NOME_PAIS_CAMPEONATO");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_PAIS_CAMPEAO");
			strFields[7] = new String("NOME_PAIS_CAMPEAO");
			strFields[8] = new String("CODIGO_TIME_CAMPEAO");
			strFields[9] = new String("NOME_TIME_CAMPEAO");
			strFields[10] = new String("CODIGO_PAIS_VICE");
			strFields[11] = new String("NOME_PAIS_VICE");
			strFields[12] = new String("CODIGO_TIME_VICE");
			strFields[13] = new String("NOME_TIME_VICE");
			strFields[14] = new String("CODIGO_PAIS_TERCEIRO");
			strFields[15] = new String("NOME_PAIS_TERCEIRO");
			strFields[16] = new String("CODIGO_TIME_TERCEIRO");
			strFields[17] = new String("NOME_TIME_TERCEIRO");
			strFields[18] = new String("CODIGO_PAIS_QUARTO");
			strFields[19] = new String("NOME_PAIS_QUARTO");
			strFields[20] = new String("CODIGO_TIME_QUARTO");
			strFields[21] = new String("NOME_TIME_QUARTO");
			String[] strConditions = new String[3];
			strConditions[0] = new String("CODIGO_PAIS_CAMPEONATO = '000'");
			strConditions[1] = new String("CODIGO_CAMPEONATO >= '001'");
			strConditions[2] = new String("CODIGO_CAMPEONATO <= '199'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[3];
			strOrder[0] = new String("CODIGO_CAMPEONATO ASC");
			strOrder[1] = new String("ANO_FIM_TEMPORADA DESC");
			strOrder[2] = new String("ANO_INICIO_TEMPORADA DESC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				temp = new VTemp();
				temp.setCodigoPaisCampeonato(rsltSelect.getString("CODIGO_PAIS_CAMPEONATO"));
				temp.setNomePaisCampeonato(rsltSelect.getString("NOME_PAIS_CAMPEONATO"));
				temp.setCodigoCampeonato(rsltSelect.getString("CODIGO_CAMPEONATO"));
				temp.setNomeCampeonato(rsltSelect.getString("NOME_CAMPEONATO"));
				temp.setAnoInicioTemporada(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				temp.setAnoFimTemporada(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				temp.setCodigoPaisCampeao(rsltSelect.getString("CODIGO_PAIS_CAMPEAO"));
				temp.setNomePaisCampeao(rsltSelect.getString("NOME_PAIS_CAMPEAO"));
				temp.setCodigoTimeCampeao(rsltSelect.getString("CODIGO_TIME_CAMPEAO"));
				temp.setNomeTimeCampeao(rsltSelect.getString("NOME_TIME_CAMPEAO"));
				temp.setCodigoPaisVice(rsltSelect.getString("CODIGO_PAIS_VICE"));
				temp.setNomePaisVice(rsltSelect.getString("NOME_PAIS_VICE"));
				temp.setCodigoTimeVice(rsltSelect.getString("CODIGO_TIME_VICE"));
				temp.setNomeTimeVice(rsltSelect.getString("NOME_TIME_VICE"));
				temp.setCodigoPaisTerceiro(rsltSelect.getString("CODIGO_PAIS_TERCEIRO"));
				temp.setNomePaisTerceiro(rsltSelect.getString("NOME_PAIS_TERCEIRO"));
				temp.setCodigoTimeTerceiro(rsltSelect.getString("CODIGO_TIME_TERCEIRO"));
				temp.setNomeTimeTerceiro(rsltSelect.getString("NOME_TIME_TERCEIRO"));
				temp.setCodigoPaisQuarto(rsltSelect.getString("CODIGO_PAIS_QUARTO"));
				temp.setNomePaisQuarto(rsltSelect.getString("NOME_PAIS_QUARTO"));
				temp.setCodigoTimeQuarto(rsltSelect.getString("CODIGO_TIME_QUARTO"));
				temp.setNomeTimeQuarto(rsltSelect.getString("NOME_TIME_QUARTO"));
				boolean b = DL.InsereFim(temp);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VTempDAO.selVTempListaClubsInter(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVTempListaSelecoes() {
	
		DLista DL = new DLista();
		VTemp temp;
		
		try {
		
			String strTableMain = new String("V_TEMPORADAS");
			String[] strTableCompl = null;
			String[] strFields = new String[22];
			strFields[0] = new String("CODIGO_PAIS_CAMPEONATO");
			strFields[1] = new String("NOME_PAIS_CAMPEONATO");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_PAIS_CAMPEAO");
			strFields[7] = new String("NOME_PAIS_CAMPEAO");
			strFields[8] = new String("CODIGO_TIME_CAMPEAO");
			strFields[9] = new String("NOME_TIME_CAMPEAO");
			strFields[10] = new String("CODIGO_PAIS_VICE");
			strFields[11] = new String("NOME_PAIS_VICE");
			strFields[12] = new String("CODIGO_TIME_VICE");
			strFields[13] = new String("NOME_TIME_VICE");
			strFields[14] = new String("CODIGO_PAIS_TERCEIRO");
			strFields[15] = new String("NOME_PAIS_TERCEIRO");
			strFields[16] = new String("CODIGO_TIME_TERCEIRO");
			strFields[17] = new String("NOME_TIME_TERCEIRO");
			strFields[18] = new String("CODIGO_PAIS_QUARTO");
			strFields[19] = new String("NOME_PAIS_QUARTO");
			strFields[20] = new String("CODIGO_TIME_QUARTO");
			strFields[21] = new String("NOME_TIME_QUARTO");
			String[] strConditions = new String[2];
			strConditions[0] = new String("CODIGO_CAMPEONATO >= '901'");
			strConditions[1] = new String("CODIGO_CAMPEONATO <= '999'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[3];
			strOrder[0] = new String("CODIGO_CAMPEONATO ASC");
			strOrder[1] = new String("ANO_FIM_TEMPORADA DESC");
			strOrder[2] = new String("ANO_INICIO_TEMPORADA DESC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				temp = new VTemp();
				temp.setCodigoPaisCampeonato(rsltSelect.getString("CODIGO_PAIS_CAMPEONATO"));
				temp.setNomePaisCampeonato(rsltSelect.getString("NOME_PAIS_CAMPEONATO"));
				temp.setCodigoCampeonato(rsltSelect.getString("CODIGO_CAMPEONATO"));
				temp.setNomeCampeonato(rsltSelect.getString("NOME_CAMPEONATO"));
				temp.setAnoInicioTemporada(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				temp.setAnoFimTemporada(rsltSelect.getString("ANO_FIM_TEMPORADA"));				
				temp.setCodigoPaisCampeao(rsltSelect.getString("CODIGO_PAIS_CAMPEAO"));
				temp.setNomePaisCampeao(rsltSelect.getString("NOME_PAIS_CAMPEAO"));
				temp.setCodigoTimeCampeao(rsltSelect.getString("CODIGO_TIME_CAMPEAO"));
				temp.setNomeTimeCampeao(rsltSelect.getString("NOME_TIME_CAMPEAO"));
				temp.setCodigoPaisVice(rsltSelect.getString("CODIGO_PAIS_VICE"));
				temp.setNomePaisVice(rsltSelect.getString("NOME_PAIS_VICE"));
				temp.setCodigoTimeVice(rsltSelect.getString("CODIGO_TIME_VICE"));
				temp.setNomeTimeVice(rsltSelect.getString("NOME_TIME_VICE"));
				temp.setCodigoPaisTerceiro(rsltSelect.getString("CODIGO_PAIS_TERCEIRO"));
				temp.setNomePaisTerceiro(rsltSelect.getString("NOME_PAIS_TERCEIRO"));
				temp.setCodigoTimeTerceiro(rsltSelect.getString("CODIGO_TIME_TERCEIRO"));
				temp.setNomeTimeTerceiro(rsltSelect.getString("NOME_TIME_TERCEIRO"));
				temp.setCodigoPaisQuarto(rsltSelect.getString("CODIGO_PAIS_QUARTO"));
				temp.setNomePaisQuarto(rsltSelect.getString("NOME_PAIS_QUARTO"));
				temp.setCodigoTimeQuarto(rsltSelect.getString("CODIGO_TIME_QUARTO"));
				temp.setNomeTimeQuarto(rsltSelect.getString("NOME_TIME_QUARTO"));
				boolean b = DL.InsereFim(temp);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VTempDAO.selVTempListaSelecoes(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
}

