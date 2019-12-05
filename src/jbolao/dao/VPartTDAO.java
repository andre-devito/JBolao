package jbolao.dao;

import java.sql.SQLException;
import devito.db.DBConexoes;
import devito.db.DBQuery;
import devito.db.DBSelect;
import devito.dados.estruturas.DLista;
import jbolao.error.Error;
import jbolao.entity.VPart;
import jbolao.entity.VPartT;

public class VPartTDAO extends VPartDAO {
	
	public DLista selVPartByTemporada(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp) {
	
		DLista DL = new DLista();
		VPartT part;
		
		try {
		
			String strTableMain = new String("V_PARTICIPACOES_T");
			String[] strTableCompl = null;
			String[] strFields = new String[9];
			strFields[0] = new String("CODIGO_PAIS");
			strFields[1] = new String("NOME_PAIS");
			strFields[2] = new String("CODIGO_CAMPEONATO");
			strFields[3] = new String("NOME_CAMPEONATO");
			strFields[4] = new String("ANO_INICIO_TEMPORADA");
			strFields[5] = new String("ANO_FIM_TEMPORADA");
			strFields[6] = new String("CODIGO_PAIS_TIME");
			strFields[7] = new String("CODIGO_TIME");
			strFields[8] = new String("NOME_TIME");
			String[] strConditions = new String[4];
			strConditions[0] = new String("CODIGO_PAIS = '" + strCodigoPaisCamp + "'");
			strConditions[1] = new String("CODIGO_CAMPEONATO = '" + strCodigoCamp + "'");
			strConditions[2] = new String("ANO_INICIO_TEMPORADA = '" + strAnoInicioTemp + "'");
			strConditions[3] = new String("ANO_FIM_TEMPORADA = '" + strAnoFimTemp + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[2];
			strOrder[0] = new String("CODIGO_PAIS_TIME ASC");
			strOrder[1] = new String("CODIGO_TIME ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				part = new VPartT();
				part.setCodigoPaisCamp(rsltSelect.getString("CODIGO_PAIS"));
				part.setNomePaisCamp(rsltSelect.getString("NOME_PAIS"));
				part.setCodigoCamp(rsltSelect.getString("CODIGO_CAMPEONATO"));
				part.setNomeCamp(rsltSelect.getString("NOME_CAMPEONATO"));
				part.setAnoInicioTemp(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				part.setAnoFimTemp(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				part.setCodigoPaisTime(rsltSelect.getString("CODIGO_PAIS_TIME"));
				part.setCodigoTime(rsltSelect.getString("CODIGO_TIME"));
				part.setNomeTime(rsltSelect.getString("NOME_TIME"));
				boolean b = DL.InsereFim(part);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VPartTDAO.selVPartByRodada(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
}

