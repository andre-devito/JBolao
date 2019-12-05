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
import jbolao.type.TipoEquipe;
import jbolao.type.TipoEtapaTorneio;
import jbolao.type.TipoBusca;
import jbolao.entity.VTemp;
import jbolao.component.subcomponent.JPanelTemps;

public class JPanelHistCamp extends JPanel
						implements ActionListener {
							
	//*** Componentes ****************************************************************************************************************************
	//Componentes
	private JLabel lblCabecTemps[], lblCabecTempsAux;
	
	private JButton btnPrev, btnNext;
	
	private JPanelTemps pnlTemps;
	
	//Constantes Globais
	private final int MAX_REG = 28;
	
	//Variaveis Globais
	private TipoEquipe tpEquipe;
	private TipoEtapaTorneio tpEtapaTorneio;
	private TipoBusca tpBusca;
	private int width = 500;
	private int height = 600;
	private VTemp temp = null;
	//********************************************************************************************************************************************

	//*** Construtores ***************************************************************************************************************************
	public JPanelHistCamp() {
	
		this(null);
		
	}
	
	public JPanelHistCamp(VTemp temp) {
		
		this.setLayout(null);
		this.setBackground(new Color(255,255,255));
		
		this.temp = temp;
		
		this.lblCabecTempsAux = new JLabel();
		this.lblCabecTempsAux.setOpaque(true);
		this.lblCabecTempsAux.setBackground(new Color(225,225,225));
		
		this.lblCabecTemps = new JLabel[3];
		
		for (int idx=0; idx<3; idx++) {
		
			this.lblCabecTemps[idx] = new JLabel();
			this.lblCabecTemps[idx].setOpaque(true);
			this.lblCabecTemps[idx].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblCabecTemps[idx].setForeground(new Color(0, 0, 0));
			this.lblCabecTemps[idx].setBackground(new Color(225,225,225));
			
		}
		
		this.btnPrev = new JButton("<< PÁGINA ANTERIOR");
		this.btnPrev.setFont(new Font("Verdana", Font.ITALIC, 8));
		this.btnPrev.setForeground(new Color(255, 0, 0));
		this.btnPrev.setBackground(new Color(225,225,225));
		
		this.btnNext = new JButton("PRÓXIMA PÁGINA >>");
		this.btnNext.setFont(new Font("Verdana", Font.ITALIC, 8));
		this.btnNext.setForeground(new Color(255, 0, 0));
		this.btnNext.setBackground(new Color(225,225,225));
		
		for (int idx=0; idx<3; idx++) {
			this.add(this.lblCabecTemps[idx]);
		}
		this.add(this.lblCabecTempsAux);
		
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
	//********************************************************************************************************************************************
	
	//*** Carregar Tela HistCamp *****************************************************************************************************************
	public void carregaTelaHistCamp(TipoBusca tpBusca) {
		
		if (this.pnlTemps != null)
			this.remove(this.pnlTemps);
		
		int intCodigoPaisCampeonato = Integer.parseInt(this.temp.getCodigoPaisCampeonato());
		int intCodigoCampeonato = Integer.parseInt(this.temp.getCodigoCampeonato());
		
		if ((intCodigoCampeonato >= 901) && (intCodigoCampeonato <= 999))
			this.tpEquipe = TipoEquipe.SELECAO;
		else
			this.tpEquipe = TipoEquipe.CLUBE;
			
		this.tpBusca = tpBusca;
			
		this.pnlTemps = new JPanelTemps(this.tpEquipe, this.temp.getCodigoPaisCampeonato(), this.temp.getCodigoCampeonato(), this.tpBusca);
		this.pnlTemps.carregaSubComponent(IndicadorPaginacao.INITIAL, MAX_REG);
		this.pnlTemps.setBounds(10,25,this.pnlTemps.getWidth(),this.pnlTemps.getHeight());
		this.add(this.pnlTemps);
		
		if ((this.pnlTemps.getTempDLista() != null) && (this.pnlTemps.getTempDLista().count() > 0)) {
		
			if (tpBusca == TipoBusca.LISTA) {
		
				this.lblCabecTempsAux.setBounds(10,5,480,20);
				this.lblCabecTemps[0].setBounds(10,5,120,20);
				this.lblCabecTemps[0].setHorizontalAlignment(JLabel.CENTER);
				this.lblCabecTemps[0].setText("TEMPORADA");
				this.lblCabecTemps[1].setBounds(130,5,180,20);
				this.lblCabecTemps[1].setHorizontalAlignment(JLabel.CENTER);
				this.lblCabecTemps[1].setText("CAMPEÃO");
				this.lblCabecTemps[2].setBounds(310,5,180,20);
				this.lblCabecTemps[2].setHorizontalAlignment(JLabel.CENTER);
				this.lblCabecTemps[2].setText("VICE");
				
			}
			
			if (tpBusca == TipoBusca.RESUMO) {
		
				this.lblCabecTempsAux.setBounds(10,5,480,20);
				this.lblCabecTemps[0].setBounds(30,5,180,20);
				this.lblCabecTemps[0].setHorizontalAlignment(JLabel.CENTER);
				this.lblCabecTemps[0].setText("EQUIPE");
				this.lblCabecTemps[1].setBounds(210,5,180,20);
				this.lblCabecTemps[1].setHorizontalAlignment(JLabel.CENTER);
				this.lblCabecTemps[1].setText("");
				this.lblCabecTemps[2].setBounds(390,5,80,20);
				this.lblCabecTemps[2].setHorizontalAlignment(JLabel.CENTER);
				this.lblCabecTemps[2].setText("TÍTULOS");
				
			}
			
			this.btnPrev.setBounds(45,25+10+this.pnlTemps.getHeight(),200,17);
			this.btnPrev.setEnabled((this.pnlTemps.getFirst() == 0)? false : true);
			this.btnPrev.setVisible(true);
			
			this.btnNext.setBounds(255,25+10+this.pnlTemps.getHeight(),200,17);
			this.btnNext.setEnabled((this.pnlTemps.getLast() == (this.pnlTemps.getTempDLista().count() - 1))? false : true);
			this.btnNext.setVisible(true);
			
		}
		
		else {
			
			this.lblCabecTempsAux.setBounds(10,5,480,20);
			this.lblCabecTemps[0].setBounds(10,5,120,20);
			this.lblCabecTemps[0].setHorizontalAlignment(JLabel.CENTER);
			this.lblCabecTemps[1].setBounds(130,5,180,20);
			this.lblCabecTemps[1].setHorizontalAlignment(JLabel.CENTER);
			this.lblCabecTemps[2].setBounds(310,5,180,20);
			this.lblCabecTemps[2].setHorizontalAlignment(JLabel.CENTER);
			for (int idx=0; idx<3; idx++)
				this.lblCabecTemps[idx].setText("");
				
			this.btnPrev.setVisible(false);
			
			this.btnNext.setVisible(false);
				
		}
		
		this.repaint();
		
		return;
		
	}
	//********************************************************************************************************************************************
	
	//*** Atualizar Tela HistCamp ****************************************************************************************************************
	public void atualizaTelaHistCamp(IndicadorPaginacao indpag) {
	
		this.pnlTemps.carregaSubComponent(indpag, MAX_REG);
		this.pnlTemps.setBounds(10,25,this.pnlTemps.getWidth(),this.pnlTemps.getHeight());
		
		if ((this.pnlTemps.getTempDLista() != null) && (this.pnlTemps.getTempDLista().count() > 0)) {
		
			if (this.tpBusca == TipoBusca.LISTA) {
		
				this.lblCabecTempsAux.setBounds(10,5,480,20);
				this.lblCabecTemps[0].setBounds(10,5,120,20);
				this.lblCabecTemps[0].setHorizontalAlignment(JLabel.CENTER);
				this.lblCabecTemps[0].setText("TEMPORADA");
				this.lblCabecTemps[1].setBounds(130,5,180,20);
				this.lblCabecTemps[1].setHorizontalAlignment(JLabel.CENTER);
				this.lblCabecTemps[1].setText("CAMPEÃO");
				this.lblCabecTemps[2].setBounds(310,5,180,20);
				this.lblCabecTemps[2].setHorizontalAlignment(JLabel.CENTER);
				this.lblCabecTemps[2].setText("VICE");
				
			}
			
			if (this.tpBusca == TipoBusca.RESUMO) {
		
				this.lblCabecTempsAux.setBounds(10,5,480,20);
				this.lblCabecTemps[0].setBounds(30,5,180,20);
				this.lblCabecTemps[0].setHorizontalAlignment(JLabel.CENTER);
				this.lblCabecTemps[0].setText("EQUIPE");
				this.lblCabecTemps[1].setBounds(210,5,180,20);
				this.lblCabecTemps[1].setHorizontalAlignment(JLabel.CENTER);
				this.lblCabecTemps[1].setText("");
				this.lblCabecTemps[2].setBounds(390,5,80,20);
				this.lblCabecTemps[2].setHorizontalAlignment(JLabel.CENTER);
				this.lblCabecTemps[2].setText("TÍTULOS");
				
			}
			
			this.btnPrev.setBounds(45,25+10+this.pnlTemps.getHeight(),200,17);
			this.btnPrev.setEnabled((this.pnlTemps.getFirst() == 0)? false : true);
			this.btnPrev.setVisible(true);
			
			this.btnNext.setBounds(255,25+10+this.pnlTemps.getHeight(),200,17);
			this.btnNext.setEnabled((this.pnlTemps.getLast() == (this.pnlTemps.getTempDLista().count() - 1))? false : true);
			this.btnNext.setVisible(true);
			
		}
		
		else {
			
			this.lblCabecTempsAux.setBounds(10,5,480,20);
			this.lblCabecTemps[0].setBounds(10,5,120,20);
			this.lblCabecTemps[0].setHorizontalAlignment(JLabel.CENTER);
			this.lblCabecTemps[1].setBounds(130,5,180,20);
			this.lblCabecTemps[1].setHorizontalAlignment(JLabel.CENTER);
			this.lblCabecTemps[2].setBounds(310,5,180,20);
			this.lblCabecTemps[2].setHorizontalAlignment(JLabel.CENTER);
			for (int idx=0; idx<3; idx++)
				this.lblCabecTemps[idx].setText("");
				
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
		
			this.atualizaTelaHistCamp(IndicadorPaginacao.PREV);
			
		}
		
		if (ae.getSource() == this.btnNext) {
		
			this.atualizaTelaHistCamp(IndicadorPaginacao.NEXT);
			
		}
		
		return;
		
	}
	//********************************************************************************************************************************************
	
}


