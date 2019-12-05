package jbolao.component;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import devito.dados.estruturas.DLista;
import jbolao.type.IndicadorPaginacao;
import jbolao.type.OpcoesEstatisticas;
import jbolao.type.TipoEquipe;
import jbolao.type.TipoEtapaTorneio;
import jbolao.entity.VTemp;
import jbolao.component.subcomponent.JPanelEstats;

public class JPanelEstatCamp extends JPanel
						implements ActionListener {
							
	//*** Componentes ****************************************************************************************************************************
	//Componentes
	private JLabel lblCabecEstats[], lblCabecEstatsAux;
	
	private JButton btnPrev, btnNext;
	
	private JPanelEstats pnlEstats;
	
	//Constantes Globais
	private final int MAX_REG = 28;
	
	//Variaveis Globais
	private TipoEquipe tpEquipe;
	private TipoEtapaTorneio tpEtapaTorneio;
	private OpcoesEstatisticas oeOrderField;
	private String strCodigoRodada;
	private int width = 500;
	private int height = 600;
	private VTemp temp = null;
	//********************************************************************************************************************************************

	//*** Construtores ***************************************************************************************************************************
	public JPanelEstatCamp() {
	
		this(null);
		
	}
	
	public JPanelEstatCamp(VTemp temp) {
		
		this.setLayout(null);
		this.setBackground(new Color(255,255,255));
		
		this.temp = temp;
		
		this.lblCabecEstatsAux = new JLabel();
		this.lblCabecEstatsAux.setOpaque(true);
		this.lblCabecEstatsAux.setBackground(new Color(225,225,225));
		
		this.lblCabecEstats = new JLabel[5];
		
		for (int idx=0; idx<5; idx++) {
		
			this.lblCabecEstats[idx] = new JLabel();
			this.lblCabecEstats[idx].setOpaque(true);
			this.lblCabecEstats[idx].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblCabecEstats[idx].setForeground(new Color(0, 0, 0));
			this.lblCabecEstats[idx].setBackground(new Color(225,225,225));
			
		}
		
		this.btnPrev = new JButton("<< PÁGINA ANTERIOR");
		this.btnPrev.setFont(new Font("Verdana", Font.ITALIC, 8));
		this.btnPrev.setForeground(new Color(255, 0, 0));
		this.btnPrev.setBackground(new Color(225,225,225));
		
		this.btnNext = new JButton("PRÓXIMA PÁGINA >>");
		this.btnNext.setFont(new Font("Verdana", Font.ITALIC, 8));
		this.btnNext.setForeground(new Color(255, 0, 0));
		this.btnNext.setBackground(new Color(225,225,225));
		
		for (int idx=0; idx<5; idx++) {
			this.add(this.lblCabecEstats[idx]);
		}
		this.add(this.lblCabecEstatsAux);
		
		this.add(this.btnPrev);
		this.add(this.btnNext);
		
		this.btnPrev.addActionListener(this);
		this.btnNext.addActionListener(this);
		
	}
	//********************************************************************************************************************************************
	
	//*** Getters e Setters **********************************************************************************************************************	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void setTemp(VTemp temp) {
		this.temp = temp;
	}
	
	public void setOrderField(OpcoesEstatisticas oeOrderField) {
		this.oeOrderField = oeOrderField;
	}
	
	public void setCodigoRodada(String strCodigoRodada) {
		this.strCodigoRodada = strCodigoRodada;
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Tela EstatCamp ****************************************************************************************************************
	public void carregaTelaEstatCamp() {
		
		if (this.pnlEstats != null)
			this.remove(this.pnlEstats);
		
		int intCodigoPaisCampeonato = Integer.parseInt(this.temp.getCodigoPaisCampeonato());
		int intCodigoCampeonato = Integer.parseInt(this.temp.getCodigoCampeonato());
		
		if ((intCodigoCampeonato >= 901) && (intCodigoCampeonato <= 999))
			this.tpEquipe = TipoEquipe.SELECAO;
		else
			this.tpEquipe = TipoEquipe.CLUBE;
			
		this.pnlEstats = new JPanelEstats(this.tpEquipe, this.temp.getCodigoPaisCampeonato(), this.temp.getCodigoCampeonato(), this.temp.getAnoInicioTemporada(), this.temp.getAnoFimTemporada(), this.oeOrderField.getOrderField(), strCodigoRodada);
		this.pnlEstats.carregaSubComponent(IndicadorPaginacao.INITIAL, MAX_REG);
		this.pnlEstats.setBounds(20,25,this.pnlEstats.getWidth(),this.pnlEstats.getHeight());
		this.add(this.pnlEstats);
		
		if ((this.pnlEstats.getClassDLista() != null) && (this.pnlEstats.getClassDLista().count() > 0)) {
		
			this.lblCabecEstatsAux.setBounds(10,5,480,20);
			this.lblCabecEstats[0].setBounds(20,5,40,20);
			this.lblCabecEstats[0].setHorizontalAlignment(JLabel.LEFT);
			this.lblCabecEstats[0].setText("POS");
			this.lblCabecEstats[1].setBounds(60,5,160,20);
			this.lblCabecEstats[1].setHorizontalAlignment(JLabel.LEFT);
			this.lblCabecEstats[1].setText("EQUIPE");
			this.lblCabecEstats[2].setBounds(220,5,120,20);
			this.lblCabecEstats[2].setHorizontalAlignment(JLabel.CENTER);
			this.lblCabecEstats[2].setText(this.oeOrderField.getDescField());
			this.lblCabecEstats[3].setBounds(340,5,70,20);
			this.lblCabecEstats[3].setHorizontalAlignment(JLabel.CENTER);
			this.lblCabecEstats[3].setText("JOGOS");
			this.lblCabecEstats[4].setBounds(410,5,70,20);
			this.lblCabecEstats[4].setHorizontalAlignment(JLabel.CENTER);
			this.lblCabecEstats[4].setText("MÉDIA");
			
			this.btnPrev.setBounds(45,25+10+this.pnlEstats.getHeight(),200,17);
			this.btnPrev.setEnabled((this.pnlEstats.getFirst() == 0)? false : true);
			this.btnPrev.setVisible(true);
			
			this.btnNext.setBounds(255,25+10+this.pnlEstats.getHeight(),200,17);
			this.btnNext.setEnabled((this.pnlEstats.getLast() == (this.pnlEstats.getClassDLista().count() - 1))? false : true);
			this.btnNext.setVisible(true);
			
		}
		
		else {
			
			this.lblCabecEstatsAux.setBounds(10,5,480,20);
			this.lblCabecEstats[0].setBounds(20,5,40,20);
			this.lblCabecEstats[0].setHorizontalAlignment(JLabel.LEFT);
			this.lblCabecEstats[1].setBounds(60,5,160,20);
			this.lblCabecEstats[1].setHorizontalAlignment(JLabel.LEFT);
			this.lblCabecEstats[2].setBounds(220,5,120,20);
			this.lblCabecEstats[2].setHorizontalAlignment(JLabel.CENTER);
			this.lblCabecEstats[3].setBounds(340,5,70,20);
			this.lblCabecEstats[3].setHorizontalAlignment(JLabel.CENTER);
			this.lblCabecEstats[4].setBounds(410,5,70,20);
			this.lblCabecEstats[4].setHorizontalAlignment(JLabel.CENTER);
			for (int idx=0; idx<5; idx++)
				this.lblCabecEstats[idx].setText("");
				
			this.btnPrev.setVisible(false);
			
			this.btnNext.setVisible(false);
				
		}
		
		this.repaint();
		
		return;
		
	}
	//********************************************************************************************************************************************
	
	//*** Atualizar Tela EstatCamp ***************************************************************************************************************
	public void atualizaTelaEstatCamp(IndicadorPaginacao indpag) {
	
		this.pnlEstats.carregaSubComponent(indpag, MAX_REG);
		this.pnlEstats.setBounds(20,25,this.pnlEstats.getWidth(),this.pnlEstats.getHeight());
		
		if ((this.pnlEstats.getClassDLista() != null) && (this.pnlEstats.getClassDLista().count() > 0)) {
		
			this.lblCabecEstatsAux.setBounds(10,5,480,20);
			this.lblCabecEstats[0].setBounds(20,5,40,20);
			this.lblCabecEstats[0].setHorizontalAlignment(JLabel.LEFT);
			this.lblCabecEstats[0].setText("POS");
			this.lblCabecEstats[1].setBounds(60,5,160,20);
			this.lblCabecEstats[1].setHorizontalAlignment(JLabel.LEFT);
			this.lblCabecEstats[1].setText("EQUIPE");
			this.lblCabecEstats[2].setBounds(220,5,120,20);
			this.lblCabecEstats[2].setHorizontalAlignment(JLabel.CENTER);
			this.lblCabecEstats[2].setText(this.oeOrderField.getDescField());
			this.lblCabecEstats[3].setBounds(340,5,70,20);
			this.lblCabecEstats[3].setHorizontalAlignment(JLabel.CENTER);
			this.lblCabecEstats[3].setText("JOGOS");
			this.lblCabecEstats[4].setBounds(410,5,70,20);
			this.lblCabecEstats[4].setHorizontalAlignment(JLabel.CENTER);
			this.lblCabecEstats[4].setText("MÉDIA");
				
			this.btnPrev.setBounds(45,25+10+this.pnlEstats.getHeight(),200,17);
			this.btnPrev.setEnabled((this.pnlEstats.getFirst() == 0)? false : true);
			this.btnPrev.setVisible(true);
			
			this.btnNext.setBounds(255,25+10+this.pnlEstats.getHeight(),200,17);
			this.btnNext.setEnabled((this.pnlEstats.getLast() == (this.pnlEstats.getClassDLista().count() - 1))? false : true);
			this.btnNext.setVisible(true);
			
		}
		
		else {
			
			this.lblCabecEstatsAux.setBounds(10,5,480,20);
			this.lblCabecEstats[0].setBounds(20,5,40,20);
			this.lblCabecEstats[0].setHorizontalAlignment(JLabel.LEFT);
			this.lblCabecEstats[1].setBounds(60,5,160,20);
			this.lblCabecEstats[1].setHorizontalAlignment(JLabel.LEFT);
			this.lblCabecEstats[2].setBounds(220,5,120,20);
			this.lblCabecEstats[2].setHorizontalAlignment(JLabel.CENTER);
			this.lblCabecEstats[3].setBounds(340,5,70,20);
			this.lblCabecEstats[3].setHorizontalAlignment(JLabel.CENTER);
			this.lblCabecEstats[4].setBounds(410,5,70,20);
			this.lblCabecEstats[4].setHorizontalAlignment(JLabel.CENTER);
			for (int idx=0; idx<5; idx++)
				this.lblCabecEstats[idx].setText("");
				
			this.btnPrev.setVisible(false);
			
			this.btnNext.setVisible(false);
				
		}
		
		this.repaint();
		
		return;
		
	}
	//********************************************************************************************************************************************
	
	//********************************************************************************************************************************************
	public void actionPerformed(ActionEvent ae) {
	
		if (ae.getSource() == this.btnPrev) {
		
			this.atualizaTelaEstatCamp(IndicadorPaginacao.PREV);
			
		}
		
		if (ae.getSource() == this.btnNext) {
		
			this.atualizaTelaEstatCamp(IndicadorPaginacao.NEXT);
			
		}
		
		return;
		
	}
	//********************************************************************************************************************************************
	
}


