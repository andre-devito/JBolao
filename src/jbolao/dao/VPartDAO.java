package jbolao.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import devito.dados.estruturas.DLista;
import jbolao.entity.VPart;

public abstract class VPartDAO {

	protected static Connection cnctAcesso = null;
	protected static Statement stmtAcesso = null;
	protected static ResultSet rsltSelect = null;
	
	public abstract DLista selVPartByTemporada(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp);
	
}

