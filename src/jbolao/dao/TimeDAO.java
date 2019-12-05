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
import jbolao.entity.Time;

public class TimeDAO {

	private static Connection cnctAcesso = null;
	private static Statement stmtAcesso = null;
	private static ResultSet rsltSelect = null;
	
	public Time selTimeByCodigo(String strCodigoPaisTime, String strCodigoTime) {
	
		Time t;
		
		try {
		
			String strTableMain = new String("FOOTBALL.DBO.TIMES AS T");
			String[] strTableCompl = null;
			String[] strFields = new String[3];
			strFields[0] = new String("T.CODIGO_PAIS_TIME");
			strFields[1] = new String("T.CODIGO_TIME");
			strFields[2] = new String("T.NOME_TIME");
			String[] strConditions = new String[3];
			strConditions[0] = new String("T.CODIGO_PAIS_TIME = '" + strCodigoPaisTime + "'");
			strConditions[1] = new String("T.CODIGO_TIME = '" + strCodigoTime + "'");
			strConditions[2] = new String("T.SITUACAO_TIME = '0'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = null;
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			if (this.rsltSelect.next()) {
			
				t = new Time();
				t.setCodigoPaisTime(rsltSelect.getString("CODIGO_PAIS_TIME"));
				t.setCodigoTime(rsltSelect.getString("CODIGO_TIME"));
				t.setNomeTime(rsltSelect.getString("NOME_TIME"));
				
			}
			
			else {
			
				t = null;
				Error.setErroAplicacao(new String("NAO HA TIME COM ESTE CODIGO!"));
				Error.setErroInterno(new String("TimeDAO.selTimeByCodigo(): rsltSelect nulo"));
				
			}
			
		}
		
		catch (Exception e) {
		
			t = null;
			Error.setErroAplicacao(new String("NAO FOI POSSIVEL EFETUAR ESTA BUSCA."));
			Error.setErroInterno(new String("TimeDAO.selTimeByCodigo(): " + e.toString()));
			
		}
		
		return t;
		
	}
	
	public DLista selTimeListaByPais(String strCodigoPaisTime) {
	
		DLista DL = new DLista();
		Time t;
		
		try {
		
			String strTableMain = new String("FOOTBALL.DBO.TIMES AS T");
			String[] strTableCompl = null;
			String[] strFields = new String[3];
			strFields[0] = new String("T.CODIGO_PAIS_TIME");
			strFields[1] = new String("T.CODIGO_TIME");
			strFields[2] = new String("T.NOME_TIME");
			String[] strConditions = new String[2];
			strConditions[0] = new String("T.CODIGO_PAIS_TIME = '" + strCodigoPaisTime + "'");
			strConditions[1] = new String("T.SITUACAO_TIME = '0'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[1];
			strOrder[0] = new String("T.CODIGO_TIME");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				t = new Time();
				t.setCodigoPaisTime(rsltSelect.getString("CODIGO_PAIS_TIME"));
				t.setCodigoTime(rsltSelect.getString("CODIGO_TIME"));
				t.setNomeTime(rsltSelect.getString("NOME_TIME"));
				boolean b = DL.InsereFim(t);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("TimeDAO.selTimeListaByPais(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selTimeLista() {
	
		DLista DL = new DLista();
		Time t;
		
		try {
		
			String strTableMain = new String("FOOTBALL.DBO.TIMES AS T");
			String[] strTableCompl = null;
			String[] strFields = new String[3];
			strFields[0] = new String("T.CODIGO_PAIS_TIME");
			strFields[1] = new String("T.CODIGO_TIME");
			strFields[2] = new String("T.NOME_TIME");
			String[] strConditions = new String[1];
			strConditions[0] = new String("T.SITUACAO_TIME = '0'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[2];
			strOrder[0] = new String("T.CODIGO_PAIS_TIME");
			strOrder[1] = new String("T.CODIGO_TIME");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				t = new Time();
				t.setCodigoPaisTime(rsltSelect.getString("CODIGO_PAIS_TIME"));
				t.setCodigoTime(rsltSelect.getString("CODIGO_TIME"));
				t.setNomeTime(rsltSelect.getString("NOME_TIME"));
				boolean b = DL.InsereFim(t);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("TimeDAO.selTimeLista(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
}

