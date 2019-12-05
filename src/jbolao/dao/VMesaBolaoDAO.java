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
import jbolao.entity.VMesaBolao;

public class VMesaBolaoDAO {

	private static Connection cnctAcesso = null;
	private static Statement stmtAcesso = null;
	private static ResultSet rsltSelect = null;
	
	public DLista selVConvitesByUsuario(String strCodigoUsuario) {
	
		DLista DL = new DLista();
		VMesaBolao mesa;
		
		try {
		
			String strTableMain = new String("V_CONVITES");
			String[] strTableCompl = null;
			String[] strFields = new String[13];
			strFields[0] = new String("NUMERO_SEQUENCIAL_CNVD");
			strFields[1] = new String("NOME_MESA");
			strFields[2] = new String("NUMERO_SEQUENCIAL_TEMPR");
			strFields[3] = new String("USUARIO_CAMPEAO");
			strFields[4] = new String("USUARIO_VICE");
			strFields[5] = new String("USUARIO_TERCEIRO");
			strFields[6] = new String("USUARIO_QUARTO");
			strFields[7] = new String("CODIGO_USUARIO");
			strFields[8] = new String("NOME_USUARIO");
			strFields[9] = new String("CODIGO_PAIS_CAMPEONATO");
			strFields[10] = new String("CODIGO_CAMPEONATO");
			strFields[11] = new String("ANO_INICIO_TEMPORADA");
			strFields[12] = new String("ANO_FIM_TEMPORADA");
			String[] strConditions = new String[1];
			strConditions[0] = new String("CODIGO_USUARIO = '" + strCodigoUsuario + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[1];
			strOrder[0] = new String("NOME_MESA ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				mesa = new VMesaBolao();
				mesa.setSeqOper(rsltSelect.getInt("NUMERO_SEQUENCIAL_CNVD"));
				mesa.setPerfilOper(null);
				mesa.setNomeMesa(rsltSelect.getString("NOME_MESA"));
				mesa.setSeqTempr(rsltSelect.getInt("NUMERO_SEQUENCIAL_TEMPR"));
				mesa.setUsuarioCampeao(rsltSelect.getString("USUARIO_CAMPEAO"));
				mesa.setUsuarioVice(rsltSelect.getString("USUARIO_VICE"));
				mesa.setUsuarioTerceiro(rsltSelect.getString("USUARIO_TERCEIRO"));
				mesa.setUsuarioQuarto(rsltSelect.getString("USUARIO_QUARTO"));
				mesa.setCodigoUsuario(rsltSelect.getString("CODIGO_USUARIO"));
				mesa.setNomeUsuario(rsltSelect.getString("NOME_USUARIO"));
				mesa.setCodigoPaisCampeonato(rsltSelect.getString("CODIGO_PAIS_CAMPEONATO"));
				mesa.setCodigoCampeonato(rsltSelect.getString("CODIGO_CAMPEONATO"));
				mesa.setAnoInicioTemporada(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				mesa.setAnoFimTemporada(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				boolean b = DL.InsereFim(mesa);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VMesaBolaoDAO.selVConvitesByUsuario(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVCompeticoesByUsuario(String strCodigoUsuario) {
	
		DLista DL = new DLista();
		VMesaBolao mesa;
		
		try {
		
			String strTableMain = new String("V_COMPETICOES");
			String[] strTableCompl = null;
			String[] strFields = new String[14];
			strFields[0] = new String("NUMERO_SEQUENCIAL_CMPT");
			strFields[1] = new String("PERFIL_CMPT");
			strFields[2] = new String("NOME_MESA");
			strFields[3] = new String("NUMERO_SEQUENCIAL_TEMPR");
			strFields[4] = new String("USUARIO_CAMPEAO");
			strFields[5] = new String("USUARIO_VICE");
			strFields[6] = new String("USUARIO_TERCEIRO");
			strFields[7] = new String("USUARIO_QUARTO");
			strFields[8] = new String("CODIGO_USUARIO");
			strFields[9] = new String("NOME_USUARIO");
			strFields[10] = new String("CODIGO_PAIS_CAMPEONATO");
			strFields[11] = new String("CODIGO_CAMPEONATO");
			strFields[12] = new String("ANO_INICIO_TEMPORADA");
			strFields[13] = new String("ANO_FIM_TEMPORADA");
			String[] strConditions = new String[1];
			strConditions[0] = new String("CODIGO_USUARIO = '" + strCodigoUsuario + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[1];
			strOrder[0] = new String("NOME_MESA ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				mesa = new VMesaBolao();
				mesa.setSeqOper(rsltSelect.getInt("NUMERO_SEQUENCIAL_CMPT"));
				mesa.setPerfilOper(rsltSelect.getString("PERFIL_CMPT"));
				mesa.setNomeMesa(rsltSelect.getString("NOME_MESA"));
				mesa.setSeqTempr(rsltSelect.getInt("NUMERO_SEQUENCIAL_TEMPR"));
				mesa.setUsuarioCampeao(rsltSelect.getString("USUARIO_CAMPEAO"));
				mesa.setUsuarioVice(rsltSelect.getString("USUARIO_VICE"));
				mesa.setUsuarioTerceiro(rsltSelect.getString("USUARIO_TERCEIRO"));
				mesa.setUsuarioQuarto(rsltSelect.getString("USUARIO_QUARTO"));
				mesa.setCodigoUsuario(rsltSelect.getString("CODIGO_USUARIO"));
				mesa.setNomeUsuario(rsltSelect.getString("NOME_USUARIO"));
				mesa.setCodigoPaisCampeonato(rsltSelect.getString("CODIGO_PAIS_CAMPEONATO"));
				mesa.setCodigoCampeonato(rsltSelect.getString("CODIGO_CAMPEONATO"));
				mesa.setAnoInicioTemporada(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				mesa.setAnoFimTemporada(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				boolean b = DL.InsereFim(mesa);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VMesaBolaoDAO.selVCompeticoesByUsuario(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVCompeticoesByUsuarioOwner(String strCodigoUsuarioOwner) {
	
		DLista DL = new DLista();
		VMesaBolao mesa;
		
		try {
		
			String strTableMain = new String("V_COMPETICOES");
			String[] strTableCompl = null;
			String[] strFields = new String[14];
			strFields[0] = new String("NUMERO_SEQUENCIAL_CMPT");
			strFields[1] = new String("PERFIL_CMPT");
			strFields[2] = new String("NOME_MESA");
			strFields[3] = new String("NUMERO_SEQUENCIAL_TEMPR");
			strFields[4] = new String("USUARIO_CAMPEAO");
			strFields[5] = new String("USUARIO_VICE");
			strFields[6] = new String("USUARIO_TERCEIRO");
			strFields[7] = new String("USUARIO_QUARTO");
			strFields[8] = new String("CODIGO_USUARIO");
			strFields[9] = new String("NOME_USUARIO");
			strFields[10] = new String("CODIGO_PAIS_CAMPEONATO");
			strFields[11] = new String("CODIGO_CAMPEONATO");
			strFields[12] = new String("ANO_INICIO_TEMPORADA");
			strFields[13] = new String("ANO_FIM_TEMPORADA");
			String[] strConditions = new String[2];
			strConditions[0] = new String("CODIGO_USUARIO = '" + strCodigoUsuarioOwner + "'");
			strConditions[1] = new String("PERFIL_CMPT = '1'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[1];
			strOrder[0] = new String("NOME_MESA ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				mesa = new VMesaBolao();
				mesa.setSeqOper(rsltSelect.getInt("NUMERO_SEQUENCIAL_CMPT"));
				mesa.setPerfilOper(rsltSelect.getString("PERFIL_CMPT"));
				mesa.setNomeMesa(rsltSelect.getString("NOME_MESA"));
				mesa.setSeqTempr(rsltSelect.getInt("NUMERO_SEQUENCIAL_TEMPR"));
				mesa.setUsuarioCampeao(rsltSelect.getString("USUARIO_CAMPEAO"));
				mesa.setUsuarioVice(rsltSelect.getString("USUARIO_VICE"));
				mesa.setUsuarioTerceiro(rsltSelect.getString("USUARIO_TERCEIRO"));
				mesa.setUsuarioQuarto(rsltSelect.getString("USUARIO_QUARTO"));
				mesa.setCodigoUsuario(rsltSelect.getString("CODIGO_USUARIO"));
				mesa.setNomeUsuario(rsltSelect.getString("NOME_USUARIO"));
				mesa.setCodigoPaisCampeonato(rsltSelect.getString("CODIGO_PAIS_CAMPEONATO"));
				mesa.setCodigoCampeonato(rsltSelect.getString("CODIGO_CAMPEONATO"));
				mesa.setAnoInicioTemporada(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				mesa.setAnoFimTemporada(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				boolean b = DL.InsereFim(mesa);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VMesaBolaoDAO.selVCompeticoesByUsuarioOwner(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public DLista selVCompeticoesByMesa(String strNomeMesa) {
	
		DLista DL = new DLista();
		VMesaBolao mesa;
		
		try {
		
			String strTableMain = new String("V_COMPETICOES");
			String[] strTableCompl = null;
			String[] strFields = new String[14];
			strFields[0] = new String("NUMERO_SEQUENCIAL_CMPT");
			strFields[1] = new String("PERFIL_CMPT");
			strFields[2] = new String("NOME_MESA");
			strFields[3] = new String("NUMERO_SEQUENCIAL_TEMPR");
			strFields[4] = new String("USUARIO_CAMPEAO");
			strFields[5] = new String("USUARIO_VICE");
			strFields[6] = new String("USUARIO_TERCEIRO");
			strFields[7] = new String("USUARIO_QUARTO");
			strFields[8] = new String("CODIGO_USUARIO");
			strFields[9] = new String("NOME_USUARIO");
			strFields[10] = new String("CODIGO_PAIS_CAMPEONATO");
			strFields[11] = new String("CODIGO_CAMPEONATO");
			strFields[12] = new String("ANO_INICIO_TEMPORADA");
			strFields[13] = new String("ANO_FIM_TEMPORADA");
			String[] strConditions = new String[1];
			strConditions[0] = new String("NOME_MESA = '" + strNomeMesa + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[1];
			strOrder[0] = new String("CODIGO_USUARIO ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				mesa = new VMesaBolao();
				mesa.setSeqOper(rsltSelect.getInt("NUMERO_SEQUENCIAL_CMPT"));
				mesa.setPerfilOper(rsltSelect.getString("PERFIL_CMPT"));
				mesa.setNomeMesa(rsltSelect.getString("NOME_MESA"));
				mesa.setSeqTempr(rsltSelect.getInt("NUMERO_SEQUENCIAL_TEMPR"));
				mesa.setUsuarioCampeao(rsltSelect.getString("USUARIO_CAMPEAO"));
				mesa.setUsuarioVice(rsltSelect.getString("USUARIO_VICE"));
				mesa.setUsuarioTerceiro(rsltSelect.getString("USUARIO_TERCEIRO"));
				mesa.setUsuarioQuarto(rsltSelect.getString("USUARIO_QUARTO"));
				mesa.setCodigoUsuario(rsltSelect.getString("CODIGO_USUARIO"));
				mesa.setNomeUsuario(rsltSelect.getString("NOME_USUARIO"));
				mesa.setCodigoPaisCampeonato(rsltSelect.getString("CODIGO_PAIS_CAMPEONATO"));
				mesa.setCodigoCampeonato(rsltSelect.getString("CODIGO_CAMPEONATO"));
				mesa.setAnoInicioTemporada(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				mesa.setAnoFimTemporada(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				boolean b = DL.InsereFim(mesa);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VMesaBolaoDAO.selVCompeticoesByMesa(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
	public VMesaBolao selVConvitesByUsuarioMesa(String strCodigoUsuario, String strNomeMesa) {
	
		VMesaBolao mesa;
		
		try {
		
			String strTableMain = new String("V_CONVITES");
			String[] strTableCompl = null;
			String[] strFields = new String[13];
			strFields[0] = new String("NUMERO_SEQUENCIAL_CNVD");
			strFields[1] = new String("NOME_MESA");
			strFields[2] = new String("NUMERO_SEQUENCIAL_TEMPR");
			strFields[3] = new String("USUARIO_CAMPEAO");
			strFields[4] = new String("USUARIO_VICE");
			strFields[5] = new String("USUARIO_TERCEIRO");
			strFields[6] = new String("USUARIO_QUARTO");
			strFields[7] = new String("CODIGO_USUARIO");
			strFields[8] = new String("NOME_USUARIO");
			strFields[9] = new String("CODIGO_PAIS_CAMPEONATO");
			strFields[10] = new String("CODIGO_CAMPEONATO");
			strFields[11] = new String("ANO_INICIO_TEMPORADA");
			strFields[12] = new String("ANO_FIM_TEMPORADA");
			String[] strConditions = new String[2];
			strConditions[0] = new String("CODIGO_USUARIO = '" + strCodigoUsuario + "'");
			strConditions[1] = new String("NOME_MESA = '" + strNomeMesa + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = null;
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			if (this.rsltSelect.next()) {
			
				mesa = new VMesaBolao();
				mesa.setSeqOper(rsltSelect.getInt("NUMERO_SEQUENCIAL_CNVD"));
				mesa.setPerfilOper(null);
				mesa.setNomeMesa(rsltSelect.getString("NOME_MESA"));
				mesa.setSeqTempr(rsltSelect.getInt("NUMERO_SEQUENCIAL_TEMPR"));
				mesa.setUsuarioCampeao(rsltSelect.getString("USUARIO_CAMPEAO"));
				mesa.setUsuarioVice(rsltSelect.getString("USUARIO_VICE"));
				mesa.setUsuarioTerceiro(rsltSelect.getString("USUARIO_TERCEIRO"));
				mesa.setUsuarioQuarto(rsltSelect.getString("USUARIO_QUARTO"));
				mesa.setCodigoUsuario(rsltSelect.getString("CODIGO_USUARIO"));
				mesa.setNomeUsuario(rsltSelect.getString("NOME_USUARIO"));
				mesa.setCodigoPaisCampeonato(rsltSelect.getString("CODIGO_PAIS_CAMPEONATO"));
				mesa.setCodigoCampeonato(rsltSelect.getString("CODIGO_CAMPEONATO"));
				mesa.setAnoInicioTemporada(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				mesa.setAnoFimTemporada(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				
			}
			
			else {
			
				mesa = null;			
				Error.setErroAplicacao(new String("NAO HA MESA COM ESTE INDICE!"));
				Error.setErroInterno(new String("VMesaBolaoDAO.selVConvitesByUsuarioMesa(): rsltSelect nulo"));
				
			}
			
		}
		
		catch (Exception e) {
		
			mesa = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VMesaBolaoDAO.selVConvitesByUsuarioMesa(): " + e.toString()));
			
		}
		
		return mesa;
		
	}
	
	public VMesaBolao selVCompeticoesByUsuarioMesa(String strCodigoUsuario, String strNomeMesa) {
	
		VMesaBolao mesa;
		
		try {
		
			String strTableMain = new String("V_COMPETICOES");
			String[] strTableCompl = null;
			String[] strFields = new String[14];
			strFields[0] = new String("NUMERO_SEQUENCIAL_CMPT");
			strFields[1] = new String("PERFIL_CMPT");
			strFields[2] = new String("NOME_MESA");
			strFields[3] = new String("NUMERO_SEQUENCIAL_TEMPR");
			strFields[4] = new String("USUARIO_CAMPEAO");
			strFields[5] = new String("USUARIO_VICE");
			strFields[6] = new String("USUARIO_TERCEIRO");
			strFields[7] = new String("USUARIO_QUARTO");
			strFields[8] = new String("CODIGO_USUARIO");
			strFields[9] = new String("NOME_USUARIO");
			strFields[10] = new String("CODIGO_PAIS_CAMPEONATO");
			strFields[11] = new String("CODIGO_CAMPEONATO");
			strFields[12] = new String("ANO_INICIO_TEMPORADA");
			strFields[13] = new String("ANO_FIM_TEMPORADA");
			String[] strConditions = new String[2];
			strConditions[0] = new String("CODIGO_USUARIO = '" + strCodigoUsuario + "'");
			strConditions[1] = new String("NOME_MESA = '" + strNomeMesa + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = null;
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			if (this.rsltSelect.next()) {
			
				mesa = new VMesaBolao();
				mesa.setSeqOper(rsltSelect.getInt("NUMERO_SEQUENCIAL_CMPT"));
				mesa.setPerfilOper(rsltSelect.getString("PERFIL_CMPT"));
				mesa.setNomeMesa(rsltSelect.getString("NOME_MESA"));
				mesa.setSeqTempr(rsltSelect.getInt("NUMERO_SEQUENCIAL_TEMPR"));
				mesa.setUsuarioCampeao(rsltSelect.getString("USUARIO_CAMPEAO"));
				mesa.setUsuarioVice(rsltSelect.getString("USUARIO_VICE"));
				mesa.setUsuarioTerceiro(rsltSelect.getString("USUARIO_TERCEIRO"));
				mesa.setUsuarioQuarto(rsltSelect.getString("USUARIO_QUARTO"));
				mesa.setCodigoUsuario(rsltSelect.getString("CODIGO_USUARIO"));
				mesa.setNomeUsuario(rsltSelect.getString("NOME_USUARIO"));
				mesa.setCodigoPaisCampeonato(rsltSelect.getString("CODIGO_PAIS_CAMPEONATO"));
				mesa.setCodigoCampeonato(rsltSelect.getString("CODIGO_CAMPEONATO"));
				mesa.setAnoInicioTemporada(rsltSelect.getString("ANO_INICIO_TEMPORADA"));
				mesa.setAnoFimTemporada(rsltSelect.getString("ANO_FIM_TEMPORADA"));
				
			}
			
			else {
			
				mesa = null;			
				Error.setErroAplicacao(new String("NAO HA MESA COM ESTE INDICE!"));
				Error.setErroInterno(new String("VMesaBolaoDAO.selVCompeticoesByUsuarioMesa(): rsltSelect nulo"));
				
			}
			
		}
		
		catch (Exception e) {
		
			mesa = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("VMesaBolaoDAO.selVCompeticoesByUsuarioMesa(): " + e.toString()));
			
		}
		
		return mesa;
		
	}
	
}

