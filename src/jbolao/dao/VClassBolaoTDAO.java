package jbolao.dao;

import java.sql.SQLException;
import devito.db.DBConexoes;
import devito.db.DBQuery;
import devito.db.DBSelect;
import devito.dados.estruturas.DLista;
import jbolao.error.Error;
import jbolao.entity.VClassBolao;

public class VClassBolaoTDAO extends VClassBolaoDAO {
	
	public DLista selVClassBolaoByMesa(String strNomeMesa) {
	
		DLista DL = new DLista();
		VClassBolao classf;
		
		try {
		
			String strTableMain = new String("V_CLASSIFICACAO_BOLAO_T");
			String[] strTableCompl = null;
			String[] strFields = new String[13];
			strFields[0] = new String("CODIGO_PAIS");
			strFields[1] = new String("NOME_PAIS");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("NOME_MESA");
			strFields[7] = new String("CODIGO_USUARIO");
			strFields[8] = new String("PONTOS");
			strFields[9] = new String("ACERTOS_NA_MOSCA");
			strFields[10] = new String("ACERTOS_DE_COLUNA_COM_GOL");
			strFields[11] = new String("ACERTOS_DE_COLUNA");
			strFields[12] = new String("ACERTOS_DE_GOL");
			String[] strConditions = new String[1];
			strConditions[0] = new String("NOME_MESA = '" + strNomeMesa + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[5];
			strOrder[0] = new String("PONTOS DESC");
			strOrder[1] = new String("ACERTOS_NA_MOSCA DESC");
			strOrder[2] = new String("ACERTOS_DE_COLUNA_COM_GOL DESC");
			strOrder[3] = new String("ACERTOS_DE_COLUNA DESC");
			strOrder[4] = new String("CODIGO_USUARIO ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				classf = new VClassBolao();
				classf.setCodigoPaisCamp(rsltSelect.getString("CODIGO_PAIS"));
				classf.setNomePaisCamp(rsltSelect.getString("NOME_PAIS"));
				classf.setCodigoCamp(rsltSelect.getString("CODIGO_CAMPEONATO"));
				classf.setNomeCamp(rsltSelect.getString("NOME_CAMPEONATO"));
				classf.setAnoInicioTemp(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				classf.setAnoFimTemp(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				classf.setNomeMesa(rsltSelect.getString("NOME_MESA"));
				classf.setCodigoUsuario(rsltSelect.getString("CODIGO_USUARIO"));
				classf.setPontos(rsltSelect.getInt("PONTOS"));
				classf.setAcertosMosca(rsltSelect.getInt("ACERTOS_NA_MOSCA"));
				classf.setAcertosColunaGol(rsltSelect.getInt("ACERTOS_DE_COLUNA_COM_GOL"));
				classf.setAcertosColuna(rsltSelect.getInt("ACERTOS_DE_COLUNA"));
				classf.setAcertosGol(rsltSelect.getInt("ACERTOS_DE_GOL"));
				boolean b = DL.InsereFim(classf);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VClassBolaoTDAO.selVClassBolaoByRodada(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
}

