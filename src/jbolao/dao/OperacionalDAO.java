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
import jbolao.entity.Operacional;

public class OperacionalDAO {

	private static Connection cnctAcesso = null;
	private static Statement stmtAcesso = null;
	private static ResultSet rsltSelect = null;
	
	public Operacional selOperacaoByTabelaCodigo(String strNomeTabela, String strNomeCampo, String strCodigo) {
	
		Operacional o;
		
		try {
		
			String strTableMain = new String("FOOTBALL.DBO." + strNomeTabela + " AS O");
			String[] strTableCompl = null;
			String[] strFields = new String[2];
			strFields[0] = new String("O.CODIGO_" + strNomeCampo);
			strFields[1] = new String("O.DESC_" + strNomeCampo);
			String[] strConditions = new String[1];
			strConditions[0] = new String("O.CODIGO_" + strNomeCampo + " = '" + strCodigo + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = null;
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			if (this.rsltSelect.next()) {
			
				o = new Operacional();
				o.setCodigo(rsltSelect.getString("CODIGO_" + strNomeCampo));
				o.setDesc(rsltSelect.getString("DESC_"  + strNomeCampo));
				
			}
			
			else {
			
				o = null;
				Error.setErroAplicacao(new String("NAO HA OPERACAO COM ESTE CODIGO!"));
				Error.setErroInterno(new String("OperacionalDAO.selOperacaoByTabelaCodigo(): rsltSelect nulo"));
				
			}
			
		}
		
		catch (Exception e) {
		
			o = null;
			Error.setErroAplicacao(new String("NAO FOI POSSIVEL EFETUAR ESTA BUSCA."));
			Error.setErroInterno(new String("OperacionalDAO.selOperacaoByTabelaCodigo(): " + e.toString()));
			
		}
		
		return o;
		
	}
	
	public DLista selOperacaoListaByTabela(String strNomeTabela, String strNomeCampo) {
	
		DLista DL = new DLista();
		Operacional o;
		
		try {
		
			String strTableMain = new String("FOOTBALL.DBO." + strNomeTabela + " AS O");
			String[] strTableCompl = null;
			String[] strFields = new String[2];
			strFields[0] = new String("O.CODIGO_" + strNomeCampo);
			strFields[1] = new String("O.DESC_" + strNomeCampo);
			String[] strConditions = null;
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[1];
			strOrder[0] = new String("O.CODIGO_" + strNomeCampo);
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				o = new Operacional();
				o.setCodigo(rsltSelect.getString("CODIGO_" + strNomeCampo));
				o.setDesc(rsltSelect.getString("DESC_"  + strNomeCampo));
				boolean b = DL.InsereFim(o);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("OperacionalDAO.selOperacaoListaByTabela(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
}

