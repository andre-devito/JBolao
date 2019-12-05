package jbolao.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import devito.db.DBConexoes;
import devito.db.DBQuery;
import jbolao.error.Error;
import jbolao.entity.Calendario;

public class CalendarioDAO extends DBQuery {

	private static Connection cnctAcesso = null;
	private static Statement stmtAcesso = null;
	private static ResultSet rsltSelect = null;
	
	public Calendario selDateTime() {
	
		Calendario c;
		
		try {
		
			String[] strFields = new String[3];
			strFields[0] = new String("CURRENT_TIMESTAMP AS 'TIMESTAMP'");
			strFields[1] = new String("CONVERT(DATE, CURRENT_TIMESTAMP) AS 'DATE'");
			strFields[2] = new String("CONVERT(TIME, CURRENT_TIMESTAMP) AS 'TIME'");
			
			strbldSQL = new StringBuilder();
			
			strbldSQL.append(SELECT);
			strbldSQL.append(SPACE);
			
			for (int idx=0; idx<strFields.length; idx++) {
				strbldSQL.append(strFields[idx]);
				if (idx < strFields.length-1) {
					strbldSQL.append(COMMA);
					strbldSQL.append(SPACE);
				}
			}
			
			String strQuery = strbldSQL.toString();
			
			this.cnctAcesso = DBConexoes.getConexao("DBProperties");
			this.stmtAcesso = cnctAcesso.createStatement();
			this.rsltSelect = stmtAcesso.executeQuery(strQuery);
			
			if (this.rsltSelect.next()) {
			
				c = new Calendario();
				c.setTimestamp(rsltSelect.getString("TIMESTAMP"));
				c.setDate(rsltSelect.getString("DATE"));
				c.setTime(rsltSelect.getString("TIME"));
				
			}
			
			else {
			
				c = null;
				Error.setErroAplicacao(new String("NAO FOI POSSIVEL OBTER DATA / HORA!"));
				Error.setErroInterno(new String("CalendarioDAO.selDateTime(): rsltSelect nulo"));
				
			}
			
		}
		
		catch (Exception e) {
		
			c = null;
			Error.setErroAplicacao(new String("NAO FOI POSSIVEL EFETUAR ESTA BUSCA."));
			Error.setErroInterno(new String("CalendarioDAO.selDateTime(): " + e.toString()));
			
		}
		
		return c;
		
	}
	
}

