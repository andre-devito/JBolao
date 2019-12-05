package jbolao.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import devito.dados.estruturas.DLista;
import jbolao.entity.VPalpite;

public abstract class VPalpiteDAO {

	protected static Connection cnctAcesso = null;
	protected static Statement stmtAcesso = null;
	protected static ResultSet rsltSelect = null;
	protected static int countUpdate = 0;
	
	public abstract VPalpite selVPalpiteByIdx(String strCodigoUsuario, String strNomeMesa, String strCodigoPaisCampeonato, String strCodigoCampeonato, String strAnoInicioTemporada, String strAnoFimTemporada, String strCodigoJogo, String strCodigoFaseJogo, String strCodigoTurnoJogo, String strCodigoRodadaJogo, String strCodigoGrupoJogo);
	
	public abstract int updVPalpite(VPalpite palp);
	
}

