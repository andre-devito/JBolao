package jbolao.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import devito.db.DBConexoes;
import devito.db.DBQuery;
import devito.db.DBInsert;
import devito.db.DBDelete;
import devito.dados.estruturas.DLista;
import jbolao.error.Error;
import jbolao.entity.Competidor;

public class CompetidorDAO {

	private static Connection cnctAcesso = null;
	private static Statement stmtAcesso = null;
	private static ResultSet rsltSelect = null;
	private static int countInsert = 0;
	private static int countDelete = 0;
	
	public int insCompetidores(Competidor cmpt) {
	
		try {
		
			String strTableMain = new String("FOOTBALL.DBO.COMPETIDORES");
			String[] strFields = new String[4];
			strFields[0] = new String("CODIGO_USUARIO_CMPT");
			strFields[1] = new String("NOME_MESA_CMPT");
			strFields[2] = new String("PERFIL_CMPT");
			strFields[3] = new String("DATA_CMPT");
			String[] strValues = new String[4];
			strValues[0] = new String("'" + cmpt.getCodigoUsuario() + "'");
			strValues[1] = new String("'" + cmpt.getNomeMesa() + "'");
			strValues[2] = new String("'" + cmpt.getPerfilOper() + "'");
			strValues[3] = new String("CONVERT(DATE, CURRENT_TIMESTAMP)");
			
			String strQuery = DBInsert.geraQuery(strTableMain, strFields, strValues).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.countInsert = stmtAcesso.executeUpdate(strQuery);
			
			if (this.countInsert != 0) {
			
				Error.setErroAplicacao(new String("COMPETIÇÃO INSERIDO COM SUCESSO!"));
				Error.setErroInterno(new String("CompetidorDAO.insCompetidores(): OK"));
				
			}
			
			else {
			
				Error.setErroAplicacao(new String("NAO FOI POSSÍVEL INSERIR COMPETIÇÃO."));
				Error.setErroInterno(new String("CompetidorDAO.insCompetidores(): countInsert zerado"));
				
			}
			
		
		}
		
		catch (Exception e) {
		
			Error.setErroAplicacao(new String("NAO FOI POSSÍVEL INSERIR COMPETIÇÃO."));
			Error.setErroInterno(new String("CompetidorDAO.insCompetidores(): " + e.toString()));
			
		}
		
		return this.countInsert;
		
	}
	
	public int delCompetidores(Competidor cmpt) {
	
		try {
		
			String strNickTableMain = new String("CMPT");
			String strTableMain = new String("FOOTBALL.DBO.COMPETIDORES AS CMPT");
			String[] strTableCompl = null;
			String[] strConditions = new String[2];
			strConditions[0] = new String("CMPT.CODIGO_USUARIO_CMPT = '" + cmpt.getCodigoUsuario() + "'");
			strConditions[1] = new String("CMPT.NOME_MESA_CMPT = '" + cmpt.getNomeMesa() + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			
			String strQuery = DBDelete.geraQuery(strNickTableMain, strTableMain, strTableCompl, strConditions, intRelationshipTypes, strRelationships).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.countDelete = stmtAcesso.executeUpdate(strQuery);
			
			if (this.countDelete != 0) {
			
				Error.setErroAplicacao(new String("COMPETIÇÂO DELETADA COM SUCESSO!"));
				Error.setErroInterno(new String("CompetidorDAO.delCompetidores(): OK"));
				
			}
			
			else {
			
				Error.setErroAplicacao(new String("NAO FOI POSSÍVEL DELETAR COMPETIÇÂO."));
				Error.setErroInterno(new String("CompetidorDAO.delCompetidores(): countDelete zerado"));
				
			}
			
		
		}
		
		catch (Exception e) {
		
			Error.setErroAplicacao(new String("NAO FOI POSSÍVEL DELETAR COMPETIÇÂO."));
			Error.setErroInterno(new String("CompetidorDAO.delCompetidores(): " + e.toString()));
			
		}
		
		return this.countDelete;
		
	}
	
}

