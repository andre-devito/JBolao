package jbolao.component.subcomponent;

import java.text.DecimalFormat;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JLabel;
import devito.dados.estruturas.DLista;
import jbolao.type.IndicadorPaginacao;
import jbolao.type.TipoEquipe;
import jbolao.type.TipoEtapaTorneio;
import jbolao.entity.VClassP;
import jbolao.entity.VClassT;
import jbolao.dao.VClassPDAO;
import jbolao.dao.VClassTDAO;

public class JPanelEstats extends JPanel {

	//*** Componentes ****************************************************************************************************************************
	//Componentes
	private JLabel lblTemps[][];
	
	//Variaveis Globais
	private TipoEquipe tpEquipe;
	private TipoEtapaTorneio tpEtapaTorneio;
	private String strOrderField;
	private int first = -1;
	private int last = -1;
	private int qty = 0;
	private int width = 0;
	private int height = 0;
	private DLista classDLista = new DLista();
	//********************************************************************************************************************************************
	
	//*** Construtor *****************************************************************************************************************************
	public JPanelEstats(TipoEquipe tpEquipe, String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strOrderField, String strCodigoRodadaJogo) {
		
		this.setLayout(null);
		this.setBackground(new Color(255,255,255));
		
		this.tpEquipe = tpEquipe;
		this.strOrderField = strOrderField;
		
		VClassPDAO classPDAO;
		VClassTDAO classTDAO;
		
		if (tpEquipe == TipoEquipe.SELECAO) {
			classPDAO = new VClassPDAO();
			if (strCodigoRodadaJogo == null) {
				this.classDLista = classPDAO.selVClassByEstat(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strOrderField);
			}
			else {
				this.classDLista = classPDAO.selVClassByEstatRodada(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strOrderField, strCodigoRodadaJogo);
			}
		}
		if (tpEquipe == TipoEquipe.CLUBE) {
			classTDAO = new VClassTDAO();
			if (strCodigoRodadaJogo == null) {
				this.classDLista = classTDAO.selVClassByEstat(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strOrderField);
			}
			else {
				this.classDLista = classTDAO.selVClassByEstatRodada(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strOrderField, strCodigoRodadaJogo);
			}
		}
		
	}	
	//********************************************************************************************************************************************
	
	//*** Carregar SubComponent ******************************************************************************************************************
	public void carregaSubComponent(IndicadorPaginacao indpag, int maxreg) {
	
		for (int i=0; i<this.qty; i++) {		
			for (int j=0; j<5; j++) {
				this.remove(this.lblTemps[i][j]);
				this.lblTemps[i][j] = null;
			}
		}
		
		boolean b = false;
		
		if (this.classDLista != null) {
			
			if (maxreg > 0) {
			
				int inicio = 0;
				int fim = 0;
				
				switch (indpag) {
						
					case NEXT:
						inicio = this.last + 1;
						fim = this.last + maxreg;
						break;
						
					case PREV:
						inicio = this.first - maxreg;
						fim = this.first - 1;
						break;
						
					default:
						inicio = 0;
						fim = maxreg - 1;
						break;
						
				}
				
				if (inicio < 0)
					inicio = 0;
				
				if (fim >= this.classDLista.count())
					fim = this.classDLista.count() - 1;
					
				if (inicio <= fim) {
				
					b = true;
				
					this.first = inicio;
					this.last = fim;
					this.qty = fim - inicio + 1;
					
					this.width = 460;
					this.height = 18 * (this.qty) + 1;
					
					this.lblTemps = new JLabel[this.qty][5];
					
					int idx = inicio;
					
					for (int i=0; i<this.qty; i++) {
					
						for (int j=0; j<5; j++) {
						
							this.lblTemps[i][j] = new JLabel();
							this.lblTemps[i][j].setFont(new Font("Verdana", Font.PLAIN, 9));
							this.lblTemps[i][j].setForeground(new Color(0, 0, 0));
							
						}
						
						this.lblTemps[i][0].setBounds(0,18*i,40,17);
						this.lblTemps[i][0].setHorizontalAlignment(JLabel.LEFT);
						this.lblTemps[i][0].setText((new Integer(idx+1)).toString());
						
						this.lblTemps[i][1].setBounds(40,18*i,160,17);
						this.lblTemps[i][1].setHorizontalAlignment(JLabel.LEFT);
						
						this.lblTemps[i][2].setBounds(200,18*i,120,17);
						this.lblTemps[i][2].setHorizontalAlignment(JLabel.CENTER);
						
						this.lblTemps[i][3].setBounds(320,18*i,70,17);
						this.lblTemps[i][3].setHorizontalAlignment(JLabel.CENTER);
						
						this.lblTemps[i][4].setBounds(390,18*i,70,17);
						this.lblTemps[i][4].setHorizontalAlignment(JLabel.CENTER);
						
						DecimalFormat DF1V2 = new DecimalFormat("0.00");
						
						if (this.tpEquipe == TipoEquipe.SELECAO) {
						
							VClassP classP = (VClassP) this.classDLista.get(idx);
							this.lblTemps[i][1].setText(classP.getNomePaisP().trim());
							this.lblTemps[i][2].setText((new Integer(classP.getEstat())).toString().trim());
							this.lblTemps[i][3].setText((new Integer(classP.getJogos())).toString().trim());
							this.lblTemps[i][4].setText((DF1V2.format(new Float(classP.getMedia()))).toString().trim());
							
						}
						
						if (this.tpEquipe == TipoEquipe.CLUBE) {
						
							VClassT classT = (VClassT) this.classDLista.get(idx);
							this.lblTemps[i][1].setText(classT.getNomeTime().trim());
							this.lblTemps[i][2].setText((new Integer(classT.getEstat())).toString().trim());
							this.lblTemps[i][3].setText((new Integer(classT.getJogos())).toString().trim());
							this.lblTemps[i][4].setText((DF1V2.format(new Float(classT.getMedia()))).toString().trim());
							
						}
						
						idx = idx + 1;
						
						for (int j=0; j<5; j++) {
						
							this.add(this.lblTemps[i][j]);
							
						}
						
					}
					
				}
				
			}
			
		}
		
		if (!b) {
		
			this.first = -1;
			this.last = -1;
			this.qty = 0;
			
			this.width = 0;
			this.height = 0;
			
		}
		
		this.repaint();
		
		return;
		
	}
	//********************************************************************************************************************************************
	
	//*** Getters e Setters **********************************************************************************************************************	
	public int getFirst() {
		return this.first;
	}
	
	public int getLast() {
		return this.last;
	}
	
	public int getQty() {
		return this.qty;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public DLista getClassDLista() {
		return this.classDLista;
	}
	//********************************************************************************************************************************************
	
	//********************************************************************************************************************************************
	public void paintComponent(Graphics g) {
	
		super.paintComponent(g);
	
		g.setColor(new Color(225, 225, 225));
		
		for (int idx=1; idx<=this.qty; idx++) {
			g.drawLine(0, 18*idx, 480, 18*idx);
		}
		
		return;
		
	}
	//********************************************************************************************************************************************
	
}


