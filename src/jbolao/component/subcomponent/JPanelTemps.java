package jbolao.component.subcomponent;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JLabel;
import devito.dados.estruturas.DLista;
import jbolao.type.IndicadorPaginacao;
import jbolao.type.TipoEquipe;
import jbolao.type.TipoEtapaTorneio;
import jbolao.type.TipoBusca;
import jbolao.entity.VTemp;
import jbolao.dao.VTempDAO;

public class JPanelTemps extends JPanel {

	//*** Componentes ****************************************************************************************************************************
	//Componentes
	private JLabel lblTemps[][];
	
	//Variaveis Globais
	private TipoEquipe tpEquipe;
	private TipoEtapaTorneio tpEtapaTorneio;
	private TipoBusca tpBusca;
	private int first = -1;
	private int last = -1;
	private int qty = 0;
	private int width = 0;
	private int height = 0;
	private DLista tempDLista = new DLista();
	//********************************************************************************************************************************************
	
	//*** Construtor *****************************************************************************************************************************
	public JPanelTemps(TipoEquipe tpEquipe, String strCodigoPaisCamp, String strCodigoCamp, TipoBusca tpBusca) {
		
		this.setLayout(null);
		this.setBackground(new Color(255,255,255));
		
		this.tpEquipe = tpEquipe;
		this.tpBusca = tpBusca;
		
		VTempDAO tempDAO = new VTempDAO();
		
		if (tpBusca == TipoBusca.LISTA) {
			if (tpEquipe == TipoEquipe.SELECAO) {
				this.tempDLista = tempDAO.selVTempNotNullListaByCampeonato(strCodigoCamp);
			}
			if (tpEquipe == TipoEquipe.CLUBE) {
				this.tempDLista = tempDAO.selVTempNotNullListaByPaisCampeonato(strCodigoPaisCamp, strCodigoCamp);
			}
		}
		if (tpBusca == TipoBusca.RESUMO) {
			if (tpEquipe == TipoEquipe.SELECAO) {
				this.tempDLista = tempDAO.selVTempNotNullListaResumidaByCampeonato(strCodigoCamp);
			}
			if (tpEquipe == TipoEquipe.CLUBE) {
				this.tempDLista = tempDAO.selVTempNotNullListaResumidaByPaisCampeonato(strCodigoPaisCamp, strCodigoCamp);
			}
		}
		
	}	
	//********************************************************************************************************************************************
	
	//*** Carregar SubComponent ******************************************************************************************************************
	public void carregaSubComponent(IndicadorPaginacao indpag, int maxreg) {
	
		for (int i=0; i<this.qty; i++) {		
			for (int j=0; j<3; j++) {
				this.remove(this.lblTemps[i][j]);
				this.lblTemps[i][j] = null;
			}
		}
		
		boolean b = false;
		
		if (this.tempDLista != null) {
			
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
				
				if (fim >= this.tempDLista.count())
					fim = this.tempDLista.count() - 1;
					
				if (inicio <= fim) {
				
					b = true;
				
					this.first = inicio;
					this.last = fim;
					this.qty = fim - inicio + 1;
					
					this.width = 480;
					this.height = 18 * (this.qty) + 1;
					
					this.lblTemps = new JLabel[this.qty][3];
					
					int idx = inicio;
					
					for (int i=0; i<this.qty; i++) {
					
						VTemp temp = (VTemp) this.tempDLista.get(idx);
						idx = idx + 1;
					
						for (int j=0; j<3; j++) {
						
							this.lblTemps[i][j] = new JLabel();
							this.lblTemps[i][j].setFont(new Font("Verdana", Font.PLAIN, 9));
							this.lblTemps[i][j].setForeground(new Color(0, 0, 0));
							
						}
						
						if (this.tpBusca == TipoBusca.LISTA) { 
						
							this.lblTemps[i][0].setBounds(0,18*i,120,17);
							this.lblTemps[i][0].setHorizontalAlignment(JLabel.CENTER);
							this.lblTemps[i][0].setText(temp.getAnoInicioTemporada() + "-" + temp.getAnoFimTemporada());
							
							this.lblTemps[i][1].setBounds(120,18*i,180,17);
							this.lblTemps[i][1].setHorizontalAlignment(JLabel.CENTER);
							
							this.lblTemps[i][2].setBounds(300,18*i,180,17);
							this.lblTemps[i][2].setHorizontalAlignment(JLabel.CENTER);
							
							if (this.tpEquipe == TipoEquipe.SELECAO) {
							
								this.lblTemps[i][1].setText(temp.getNomePaisCampeao().trim());
								this.lblTemps[i][2].setText((temp.getNomePaisVice() != null)? temp.getNomePaisVice().trim() : "");
								
							}
							
							if (this.tpEquipe == TipoEquipe.CLUBE) {
							
								this.lblTemps[i][1].setText(temp.getNomeTimeCampeao().trim());
								this.lblTemps[i][2].setText((temp.getNomeTimeVice() != null)? temp.getNomeTimeVice().trim() : "");
								
							}
							
						}
						
						if (this.tpBusca == TipoBusca.RESUMO) { 
						
							this.lblTemps[i][0].setBounds(20,18*i,180,17);
							this.lblTemps[i][0].setHorizontalAlignment(JLabel.CENTER);
							
							this.lblTemps[i][1].setBounds(200,18*i,180,17);
							this.lblTemps[i][1].setHorizontalAlignment(JLabel.CENTER);
							this.lblTemps[i][1].setText("");
							
							this.lblTemps[i][2].setBounds(380,18*i,80,17);
							this.lblTemps[i][2].setHorizontalAlignment(JLabel.CENTER);
							this.lblTemps[i][2].setText((new Integer(temp.getContadorTemp())).toString());
							
							if (this.tpEquipe == TipoEquipe.SELECAO) {
							
								this.lblTemps[i][0].setText(temp.getNomePaisCampeao().trim());
								
							}
							
							if (this.tpEquipe == TipoEquipe.CLUBE) {
							
								this.lblTemps[i][0].setText(temp.getNomeTimeCampeao().trim());
								
							}
							
						}
						
						for (int j=0; j<3; j++) {
						
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
	
	public DLista getTempDLista() {
		return this.tempDLista;
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


