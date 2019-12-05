package jbolao.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import devito.dados.estruturas.DLista;
import jbolao.entity.VClass;

public abstract class VClassDAO {

	protected static Connection cnctAcesso = null;
	protected static Statement stmtAcesso = null;
	protected static ResultSet rsltSelect = null;
	
	public abstract DLista selVClassByTemporada(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp);
	
	public abstract DLista selVClassByTemporadaRodada(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoRodadaJogo);
	
	public abstract DLista selVClassByTemporadaGrupo(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoGrupoJogo);
	
	public abstract DLista selVClassByEstat(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strOrderField);
	
	public abstract DLista selVClassByEstatRodada(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strOrderField, String strCodigoRodadaJogo);
	
}

