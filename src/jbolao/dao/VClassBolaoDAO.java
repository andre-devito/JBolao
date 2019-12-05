package jbolao.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import devito.dados.estruturas.DLista;
import jbolao.entity.VClassBolao;

public abstract class VClassBolaoDAO {

	protected static Connection cnctAcesso = null;
	protected static Statement stmtAcesso = null;
	protected static ResultSet rsltSelect = null;
	
	public abstract DLista selVClassBolaoByMesa(String strNomeMesa);
	
}

