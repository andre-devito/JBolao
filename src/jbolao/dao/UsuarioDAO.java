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
import jbolao.entity.Usuario;

public class UsuarioDAO {

	private static Connection cnctAcesso = null;
	private static Statement stmtAcesso = null;
	private static ResultSet rsltSelect = null;
	
	public Usuario selUsuarioByLogin(String strCodigo, String strSenha) {
	
		Usuario user;
		
		try {
		
			String strTableMain = new String("FOOTBALL.DBO.USUARIOS AS U");
			String[] strTableCompl = null;
			String[] strFields = new String[8];
			strFields[0] = new String("U.CODIGO_USUARIO");
			strFields[1] = new String("U.SENHA_USUARIO");
			strFields[2] = new String("U.NOME_USUARIO");
			strFields[3] = new String("U.MAIL_USUARIO");
			strFields[4] = new String("U.IP_USUARIO");
			strFields[5] = new String("U.SITUACAO_USUARIO");
			strFields[6] = new String("U.PERFIL_USUARIO");
			strFields[7] = new String("U.NASCIMENTO_USUARIO");
			String[] strConditions = new String[2];
			strConditions[0] = new String("U.CODIGO_USUARIO = '" + strCodigo + "'");
			strConditions[1] = new String("U.SENHA_USUARIO = '" + strSenha + "'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = null;
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();			
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			if (this.rsltSelect.next()) {
			
				user = new Usuario();
				user.setCodigo(rsltSelect.getString("CODIGO_USUARIO"));
				user.setSenha(rsltSelect.getString("SENHA_USUARIO"));
				user.setNome(rsltSelect.getString("NOME_USUARIO"));
				user.setMail(rsltSelect.getString("MAIL_USUARIO"));
				user.setIP(rsltSelect.getString("IP_USUARIO"));
				user.setSituacao(rsltSelect.getString("SITUACAO_USUARIO"));
				user.setPerfil(rsltSelect.getString("PERFIL_USUARIO"));
				user.setNascimento(rsltSelect.getString("NASCIMENTO_USUARIO"));
				
			}
			
			else {
			
				user = null;			
				Error.setErroAplicacao(new String("APELIDO E/OU SENHA INVALIDO(S)!"));
				Error.setErroInterno(new String("UsuarioDAO.selUsuarioByLogin(): rsltSelect nulo"));
				
			}
			
		}
		
		catch (Exception e) {
		
			user = null;
			Error.setErroAplicacao(new String("NAO FOI POSSIVEL EFETUAR LOGIN."));
			Error.setErroInterno(new String("UsuarioDAO.selUsuarioByLogin(): " + e.toString()));
			
		}
		
		return user;
		
	}
	
	public DLista selUsuarioByLike(String strLike) {
	
		DLista DL = new DLista();
		Usuario user;
		
		try {
		
			String strTableMain = new String("FOOTBALL.DBO.USUARIOS AS U");
			String[] strTableCompl = null;
			String[] strFields = new String[8];
			strFields[0] = new String("U.CODIGO_USUARIO");
			strFields[1] = new String("U.SENHA_USUARIO");
			strFields[2] = new String("U.NOME_USUARIO");
			strFields[3] = new String("U.MAIL_USUARIO");
			strFields[4] = new String("U.IP_USUARIO");
			strFields[5] = new String("U.SITUACAO_USUARIO");
			strFields[6] = new String("U.PERFIL_USUARIO");
			strFields[7] = new String("U.NASCIMENTO_USUARIO");
			String[] strConditions = new String[1];
			strConditions[0] = new String("U.CODIGO_USUARIO LIKE '%" + strLike + "%'");
			int[] intRelationshipTypes = null;
			String[] strRelationships = null;
			String[] strGroup = null;
			String[] strOrder = new String[1];
			strOrder[0] = new String("U.CODIGO_USUARIO ASC");
			
			String strQuery = DBSelect.geraQuery(strTableMain, strTableCompl, strFields, strConditions, intRelationshipTypes, strRelationships, strGroup, strOrder).toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			while (this.rsltSelect.next()) {
			
				user = new Usuario();
				user.setCodigo(rsltSelect.getString("CODIGO_USUARIO"));
				user.setSenha(rsltSelect.getString("SENHA_USUARIO"));
				user.setNome(rsltSelect.getString("NOME_USUARIO"));
				user.setMail(rsltSelect.getString("MAIL_USUARIO"));
				user.setIP(rsltSelect.getString("IP_USUARIO"));
				user.setSituacao(rsltSelect.getString("SITUACAO_USUARIO"));
				user.setPerfil(rsltSelect.getString("PERFIL_USUARIO"));
				user.setNascimento(rsltSelect.getString("NASCIMENTO_USUARIO"));
				boolean b = DL.InsereFim(user);
				
			}
			
		}
		
		catch (Exception e) {
		
			DL = null;
			Error.setErroAplicacao(new String("NAO FORAM ENCONTRADOS RESULTADOS."));
			Error.setErroInterno(new String("UsuarioDAO.selUsuarioByLike(): " + e.toString()));
			
		}
		
		return DL;
		
	}
	
}

