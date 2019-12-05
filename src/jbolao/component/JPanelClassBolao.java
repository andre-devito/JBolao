package jbolao.component;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import devito.dados.estruturas.DLista;
import jbolao.type.TipoEquipe;
import jbolao.type.TipoEtapaTorneio;
import jbolao.entity.VMesaBolao;
import jbolao.component.subcomponent.JPanelClassificacaoBolao;

public class JPanelClassBolao extends JPanel {

	//*** Componentes ****************************************************************************************************************************
	//Componentes
	private JLabel lblCabecPalpClass[], lblCabecPalpClassAux;
	
	private JPanelClassificacaoBolao pnlClassificacaoBolao;
	
	//Variaveis Globais
	private TipoEquipe tpEquipe;
	private TipoEtapaTorneio tpEtapaTorneio;
	private int width = 500;
	private int height = 600;	
	private VMesaBolao mesa = null;
	//********************************************************************************************************************************************

	//*** Construtores ***************************************************************************************************************************
	public JPanelClassBolao() {
	
		this(null);
		
	}
	
	public JPanelClassBolao(VMesaBolao mesa) {
		
		this.setLayout(null);
		this.setBackground(new Color(255,255,255));
		
		this.mesa = mesa;
		
		this.lblCabecPalpClassAux = new JLabel();
		this.lblCabecPalpClassAux.setOpaque(true);
		this.lblCabecPalpClassAux.setBackground(new Color(225,225,225));
		
		this.lblCabecPalpClass = new JLabel[7];
		for (int idx=0; idx<7; idx++) {
			this.lblCabecPalpClass[idx] = new JLabel();
			this.lblCabecPalpClass[idx].setOpaque(true);
			this.lblCabecPalpClass[idx].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblCabecPalpClass[idx].setForeground(new Color(0, 0, 0));
			this.lblCabecPalpClass[idx].setBackground(new Color(225,225,225));
		}
		
		for (int idx=0; idx<7; idx++)
			this.add(this.lblCabecPalpClass[idx]);
		this.add(this.lblCabecPalpClassAux);
		
	}
	//********************************************************************************************************************************************
	
	//*** Getters e Setters **********************************************************************************************************************
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public VMesaBolao getMesaBolao() {
		return this.mesa;
	}
	
	public void setMesaBolao(VMesaBolao mesa) {
		this.mesa = mesa;
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Tela ClassBolao ***************************************************************************************************************
	public void carregaTelaClassBolao() {
	
		if (this.pnlClassificacaoBolao != null)
			this.remove(this.pnlClassificacaoBolao);
			
		int intCodigoPaisCampeonato = Integer.parseInt(this.mesa.getCodigoPaisCampeonato());
		int intCodigoCampeonato = Integer.parseInt(this.mesa.getCodigoCampeonato());
		
		if ((intCodigoCampeonato >= 901) && (intCodigoCampeonato <= 999))
			this.tpEquipe = TipoEquipe.SELECAO;
		else
			this.tpEquipe = TipoEquipe.CLUBE;
			
		if ((intCodigoCampeonato >= 1) && (intCodigoCampeonato <= 100))
			this.tpEtapaTorneio = TipoEtapaTorneio.RODADA_LIGA;
		else
			this.tpEtapaTorneio = TipoEtapaTorneio.FASE_COPA;
			
		this.pnlClassificacaoBolao = new JPanelClassificacaoBolao(this.tpEquipe, this.mesa.getCodigoUsuario(), this.mesa.getNomeMesa(), this.mesa.getCodigoPaisCampeonato(), this.mesa.getCodigoCampeonato(), this.mesa.getAnoInicioTemporada(), this.mesa.getAnoFimTemporada());
		this.pnlClassificacaoBolao.carregaSubComponent();
		this.pnlClassificacaoBolao.setBounds(20,65,this.pnlClassificacaoBolao.getWidth(),this.pnlClassificacaoBolao.getHeight());
		this.add(this.pnlClassificacaoBolao);
		
		if ((this.pnlClassificacaoBolao.getClassDLista() != null) && (this.pnlClassificacaoBolao.getClassDLista().count() > 0)) {
		
			this.lblCabecPalpClassAux.setBounds(10,5,480,60);
			this.lblCabecPalpClass[0].setBounds(20,5,40,60);
			this.lblCabecPalpClass[0].setHorizontalAlignment(JLabel.LEFT);
			this.lblCabecPalpClass[0].setText("POS");
			this.lblCabecPalpClass[1].setBounds(60,5,70,60);
			this.lblCabecPalpClass[1].setHorizontalAlignment(JLabel.LEFT);
			this.lblCabecPalpClass[1].setText("USUÁRIO");
			for (int idx=2; idx<7; idx++) {
				this.lblCabecPalpClass[idx].setBounds(130+70*(idx-2),5,70,60);
				this.lblCabecPalpClass[idx].setHorizontalAlignment(JLabel.CENTER);
			}
			this.lblCabecPalpClass[2].setText("PONTOS");
			this.lblCabecPalpClass[3].setText("<HTML> <CENTER> ACERTOS </CENTER> <CENTER> NA </CENTER> <CENTER> MOSCA </CENTER> </HTML>");
			this.lblCabecPalpClass[4].setText("<HTML> <CENTER> ACERTOS </CENTER> <CENTER> DE COLUNA </CENTER> <CENTER> COM GOL </CENTER> </HTML>");
			this.lblCabecPalpClass[5].setText("<HTML> <CENTER> ACERTOS </CENTER> <CENTER> DE </CENTER> <CENTER> COLUNA </CENTER> </HTML>");
			this.lblCabecPalpClass[6].setText("<HTML> <CENTER> ACERTOS </CENTER> <CENTER> DE </CENTER> <CENTER> GOL </CENTER> </HTML>");
			
		}
		
		else {
			
			this.lblCabecPalpClassAux.setBounds(10,5,480,60);
			this.lblCabecPalpClass[0].setBounds(20,5,40,60);
			this.lblCabecPalpClass[0].setHorizontalAlignment(JLabel.LEFT);
			this.lblCabecPalpClass[1].setBounds(60,5,120,60);
			this.lblCabecPalpClass[1].setHorizontalAlignment(JLabel.LEFT);
			for (int idx=2; idx<7; idx++) {
				this.lblCabecPalpClass[idx].setBounds(180+60*(idx-2),5,60,60);
				this.lblCabecPalpClass[idx].setHorizontalAlignment(JLabel.CENTER);
			}
			for (int idx=0; idx<7; idx++)
				this.lblCabecPalpClass[idx].setText("");
			
		}
		
		this.repaint();
		
		return;
		
	}
	//********************************************************************************************************************************************
	
}


