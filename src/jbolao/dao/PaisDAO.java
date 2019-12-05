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
import jbolao.entity.Pais;

public class PaisDAO {

	private static Connection cnctAcesso = null;
	private static Statement stmtAcesso = null;
	private static ResultSet rsltSelect = null;
	
	public Pais selPaisByCodigo(String strCodigoPais) {
	
		Pais p;
		
		try {
		
			String strTableMain = new String("FOOTBALL.DBO.PAISES AS P");
			String[] strTableCompl = null;
			String[] strFields = new String[2];
			strFields[0] = new String("P.CODIGO_PAIS");
			strFields[1] = new String("P.NOME_PAIS");
			String[] strConditions = new String[2];
			strConditions[0] = new String("P.CODIGO_PAIS = '" + strCodigoPais + "'");
			strConditions[1] = new String("P.SITUACAO_PAIS = '0'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = null;
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			if (this.rsltSelect.next()) {
			
				p = new Pais();
				p.setCodigoPais(rsltSelect.getString("CODIGO_PAIS"));
				p.setNomePais(rsltSelect.getString("NOME_PAIS"));
				
			}
			
			else {
			
				p = null;			
				Error.setErroAplicacao(new String("NAO HA PAIS COM ESTE CODIGO!"));
				Error.setErroInterno(new String("PaisDAO.selPaisByCodigo(): rsltSelect nulo"));
				
			}
			
		}
		
		catch (Exception e) {
		
			p = null;
			Error.setErroAplicacao(new String("NAO FOI POSSIVEL EFETUAR ESTA BUSCA."));
			Error.setErroInterno(new String("PaisDAO.selPaisByCodigo(): " + e.toString()));
			
		}
		
		return p;
		
	}
	
	public DLista selPaisLista() {
	
		DLista DL = new DLista();
		Pais p;
		
		try {
		
			String strTableMain = new String("FOOTBALL.DBO.PAISES AS P");
			String[] strTableCompl = null;
			String[] strFields = new String[2];
			strFields[0] = new String("P.CODIGO_PAIS");
			strFields[1] = new String("P.NOME_PAIS");
			String[] strConditions = new String[1];
			strConditions[0] = new String("P.SITUACAO_PAIS = '0'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[1];
			strOrder[0] = new String("P.CODIGO_PAIS");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				p = new Pais();
				p.setCodigoPais(rsltSelect.getString("CODIGO_PAIS"));
				p.setNomePais(rsltSelect.getString("NOME_PAIS"));
				boolean b = DL.InsereFim(p);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("PaisDAO.selPaisLista(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
}

