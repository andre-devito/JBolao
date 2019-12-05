package jbolao.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import devito.dados.estruturas.DLista;
import jbolao.entity.VJogo;

public abstract class VJogoDAO {

	protected static Connection cnctAcesso = null;
	protected static Statement stmtAcesso = null;
	protected static ResultSet rsltSelect = null;
	protected static int countUpdate = 0;
	
	public abstract DLista selVJogoByRodadaAtual(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp);
	
	public abstract DLista selVJogoByFaseAtual(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp);
	
	public abstract DLista selVJogoByRodada(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoRodadaJogo);
	
	public abstract DLista selVJogoByFase(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoFaseJogo);
	
	public abstract DLista selVJogoByFaseTurno(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoAgrupJogo);
	
	public abstract DLista selVJogoByFaseGrupo(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoAgrupJogo);
	
	public abstract DLista selVJogoByDistinctOperacional(String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strDescOperacional);
	
	public abstract int updVJogo(VJogo jogo);
	
}

