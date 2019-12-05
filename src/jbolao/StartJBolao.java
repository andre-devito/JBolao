package jbolao;

public class StartJBolao {

	public static void main(String Args[]) {
	
		String host = new String("omega");
		
		try {
		
			host = Args[0];
			
		}
		
		catch (Exception e) {
		
			host = "omega";
			
		}
		
		JBolao JB = new JBolao(host);
		JB.setVisible(true);
	
	}
	
}
