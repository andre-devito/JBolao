package jbolao.error;

public class Error {

	private static String strErroAplicacao = null;
	private static String strErroInterno = null;
	
	public static void setErroAplicacao(String strNovoErroAplicacao) {
		strErroAplicacao = strNovoErroAplicacao;
	}
	
	public static void setErroInterno(String strNovoErroInterno) {
		strErroInterno = strNovoErroInterno;
	}
	
	public static String getErroAplicacao() {
		return strErroAplicacao;
	}
	
	public static String getErroInterno() {
		return strErroInterno;
	}
	
}

