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
import jbolao.entity.Convidado;

public class ConvidadoDAO {

	private static Connection cnctAcesso = null;
	private static Statement stmtAcesso = null;
	private static ResultSet rsltSelect = null;
	private static int countInsert = 0;
	private static int countDelete = 0;
	
	public int insConvidados(Convidado cnvd) {
	
		try {
		
			String strTableMain = new String("FOOTBALL.DBO.CONVIDADOS");
			String[] strFields = new String[3];
			strFields[0] = new String("CODIGO_USUARIO_CNVD");
			strFields[1] = new String("NOME_MESA_CNVD");
			strFields[2] = new String("DATA_CNVD");
			String[] strValues = new String[3];
			strValues[0] = new String("'" + cnvd.getCodigoUsuario() + "'");
			strValues[1] = new String("'" + cnvd.getNomeMesa() + "'");
			strValues[2] = new String("CONVERT(DATE, CURRENT_TIMESTAMP)");
			
			String strQuery = DBInsert.geraQuery(strTableMain, strFields, strValues).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.countInsert = stmtAcesso.executeUpdate(strQuery);
			
			if (this.countInsert != 0) {
			
				Error.setErroAplicacao(new String("CONVITE INSERIDO COM SUCESSO!"));
				Error.setErroInterno(new String("ConvidadoDAO.insConvidados(): OK"));
				
			}
			
			else {
			
				Error.setErroAplicacao(new String("NAO FOI POSSÍVEL INSERIR CONVITE."));
				Error.setErroInterno(new String("ConvidadoDAO.insConvidados(): countInsert zerado"));
				
			}
			
		
		}
		
		catch (Exception e) {
		
			Error.setErroAplicacao(new String("NAO FOI POSSÍVEL INSERIR CONVITE."));
			Error.setErroInterno(new String("ConvidadoDAO.insConvidados(): " + e.toString()));
			
		}
		
		return this.countInsert;
		
	}
	
	public int delConvidados(Convidado cnvd) {
	
		try {
		
			String strNickTableMain = new String("CNVD");
			String strTableMain = new String("FOOTBALL.DBO.CONVIDADOS AS CNVD");
			String[] strTableCompl = null;
			String[] strConditions = new String[2];
			strConditions[0] = new String("CNVD.CODIGO_USUARIO_CNVD = '" + cnvd.getCodigoUsuario() + "'");
			strConditions[1] = new String("CNVD.NOME_MESA_CNVD = '" + cnvd.getNomeMesa() + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			
			String strQuery = DBDelete.geraQuery(strNickTableMain, strTableMain, strTableCompl, strConditions, intRelationshipTypes, strRelationships).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.countDelete = stmtAcesso.executeUpdate(strQuery);
			
			if (this.countDelete != 0) {
			
				Error.setErroAplicacao(new String("CONVITE DELETADO COM SUCESSO!"));
				Error.setErroInterno(new String("ConvidadoDAO.delConvidados(): OK"));
				
			}
			
			else {
			
				Error.setErroAplicacao(new String("NAO FOI POSSÍVEL DELETAR CONVITE."));
				Error.setErroInterno(new String("ConvidadoDAO.delConvidados(): countDelete zerado"));
				
			}
			
		
		}
		
		catch (Exception e) {
		
			Error.setErroAplicacao(new String("NAO FOI POSSÍVEL DELETAR CONVITE."));
			Error.setErroInterno(new String("ConvidadoDAO.delConvidados(): " + e.toString()));
			
		}
		
		return this.countDelete;
		
	}
	
}

