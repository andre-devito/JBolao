package jbolao.component.subcomponent;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JLabel;
import devito.dados.estruturas.DLista;
import jbolao.type.TipoEquipe;
import jbolao.type.TipoEtapaTorneio;
import jbolao.entity.VClassP;
import jbolao.entity.VClassT;
import jbolao.dao.VClassPDAO;
import jbolao.dao.VClassTDAO;

public class JPanelClassificacao extends JPanel {

	//*** Componentes ****************************************************************************************************************************
	//Componentes
	private JLabel lblClassificacao[][];
	
	//Variaveis Globais
	private TipoEquipe tpEquipe;
	private TipoEtapaTorneio tpEtapaTorneio;
	private int classf = 0;
	private int classf2 = 0;
	private int rebaix = 0;
	private int rebaix2 = 0;
	private int qty = 0;
	private int width = 0;
	private int height = 0;
	private DLista classDLista = new DLista();
	//********************************************************************************************************************************************
	
	//*** Construtor *****************************************************************************************************************************
	public JPanelClassificacao(TipoEquipe tpEquipe, String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoRodadaJogo, String strCodigoGrupoJogo) {
		
		this.setLayout(null);
		this.setBackground(new Color(255,255,255));
		
		this.tpEquipe = tpEquipe;
		
		VClassPDAO classPDAO;
		VClassTDAO classTDAO;
		
		if (tpEquipe == TipoEquipe.SELECAO) {
			classPDAO = new VClassPDAO();
			if ((strCodigoRodadaJogo == null) && (strCodigoGrupoJogo == null)) {
				this.classDLista = classPDAO.selVClassByTemporada(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp);
			}
			if ((strCodigoRodadaJogo != null) && (strCodigoGrupoJogo == null)) {
				this.classDLista = classPDAO.selVClassByTemporadaRodada(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoRodadaJogo);
			}
			if ((strCodigoRodadaJogo == null) && (strCodigoGrupoJogo != null)) {
				this.classDLista = classPDAO.selVClassByTemporadaGrupo(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoGrupoJogo);
			}
		}
		if (tpEquipe == TipoEquipe.CLUBE) {
			classTDAO = new VClassTDAO();
			if ((strCodigoRodadaJogo == null) && (strCodigoGrupoJogo == null)) {
				this.classDLista = classTDAO.selVClassByTemporada(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp);
			}
			if ((strCodigoRodadaJogo != null) && (strCodigoGrupoJogo == null)) {
				this.classDLista = classTDAO.selVClassByTemporadaRodada(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoRodadaJogo);
			}
			if ((strCodigoRodadaJogo == null) && (strCodigoGrupoJogo != null)) {
				this.classDLista = classTDAO.selVClassByTemporadaGrupo(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoGrupoJogo);
			}
		}
		
		int intCodigoPaisCampeonato = Integer.parseInt(strCodigoPaisCamp);
		int intCodigoCampeonato = Integer.parseInt(strCodigoCamp);
		
		if ((intCodigoCampeonato >= 901) && (intCodigoCampeonato <= 999)) {
			this.classf = 2;
		}
		if ((intCodigoCampeonato >= 1) && (intCodigoCampeonato <= 100)) {
			if (intCodigoPaisCampeonato == 3) {
				this.classf = 4;
				this.rebaix = 4;
			}
			if ((intCodigoPaisCampeonato == 101) || (intCodigoPaisCampeonato == 110) || (intCodigoPaisCampeonato == 117)) {
				this.classf = 4;
				this.classf2 = 5;
				this.rebaix = 3;
			}
		}
		if ((intCodigoCampeonato >= 101) && (intCodigoCampeonato <= 200)) {
			if (intCodigoPaisCampeonato == 0) {
				this.classf = 2;
			}
		}
		
	}
	//********************************************************************************************************************************************
	
	//*** Carregar SubComponent ******************************************************************************************************************
	public void carregaSubComponent() {
		
		if (this.classDLista != null)
			this.qty = this.classDLista.count();
		
		this.width = 460;
		this.height = 18 * this.qty + 1;
		
		this.lblClassificacao = new JLabel[this.qty][10];
		
		for (int idx=0; idx<this.qty; idx++) {
		
			this.lblClassificacao[idx][0] = new JLabel();
			this.lblClassificacao[idx][0].setBounds(0,18*idx,40,17);
			this.lblClassificacao[idx][0].setHorizontalAlignment(JLabel.LEFT);
			this.lblClassificacao[idx][0].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblClassificacao[idx][0].setForeground(new Color(0, 0, 0));
			this.lblClassificacao[idx][0].setText((new Integer(idx+1)).toString());
			
			this.lblClassificacao[idx][1] = new JLabel();
			this.lblClassificacao[idx][1].setBounds(40,18*idx,180,17);
			this.lblClassificacao[idx][1].setHorizontalAlignment(JLabel.LEFT);
			this.lblClassificacao[idx][1].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblClassificacao[idx][1].setForeground(new Color(0, 0, 0));
			
			this.lblClassificacao[idx][2] = new JLabel();
			this.lblClassificacao[idx][2].setBounds(220,18*idx,30,17);
			this.lblClassificacao[idx][2].setHorizontalAlignment(JLabel.CENTER);
			this.lblClassificacao[idx][2].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblClassificacao[idx][2].setForeground(new Color(0, 0, 0));
			
			this.lblClassificacao[idx][3] = new JLabel();
			this.lblClassificacao[idx][3].setBounds(250,18*idx,30,17);
			this.lblClassificacao[idx][3].setHorizontalAlignment(JLabel.CENTER);
			this.lblClassificacao[idx][3].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblClassificacao[idx][3].setForeground(new Color(0, 0, 0));
			
			this.lblClassificacao[idx][4] = new JLabel();
			this.lblClassificacao[idx][4].setBounds(280,18*idx,30,17);
			this.lblClassificacao[idx][4].setHorizontalAlignment(JLabel.CENTER);
			this.lblClassificacao[idx][4].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblClassificacao[idx][4].setForeground(new Color(0, 0, 0));
			
			this.lblClassificacao[idx][5] = new JLabel();
			this.lblClassificacao[idx][5].setBounds(310,18*idx,30,17);
			this.lblClassificacao[idx][5].setHorizontalAlignment(JLabel.CENTER);
			this.lblClassificacao[idx][5].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblClassificacao[idx][5].setForeground(new Color(0, 0, 0));
			
			this.lblClassificacao[idx][6] = new JLabel();
			this.lblClassificacao[idx][6].setBounds(340,18*idx,30,17);
			this.lblClassificacao[idx][6].setHorizontalAlignment(JLabel.CENTER);
			this.lblClassificacao[idx][6].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblClassificacao[idx][6].setForeground(new Color(0, 0, 0));
			
			this.lblClassificacao[idx][7] = new JLabel();
			this.lblClassificacao[idx][7].setBounds(370,18*idx,30,17);
			this.lblClassificacao[idx][7].setHorizontalAlignment(JLabel.CENTER);
			this.lblClassificacao[idx][7].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblClassificacao[idx][7].setForeground(new Color(0, 0, 0));
			
			this.lblClassificacao[idx][8] = new JLabel();
			this.lblClassificacao[idx][8].setBounds(400,18*idx,30,17);
			this.lblClassificacao[idx][8].setHorizontalAlignment(JLabel.CENTER);
			this.lblClassificacao[idx][8].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblClassificacao[idx][8].setForeground(new Color(0, 0, 0));
			
			this.lblClassificacao[idx][9] = new JLabel();
			this.lblClassificacao[idx][9].setBounds(430,18*idx,30,17);
			this.lblClassificacao[idx][9].setHorizontalAlignment(JLabel.CENTER);
			this.lblClassificacao[idx][9].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblClassificacao[idx][9].setForeground(new Color(0, 0, 0));
			
			if (tpEquipe == TipoEquipe.SELECAO) {
			
				VClassP classP = (VClassP) this.classDLista.get(idx);
				this.lblClassificacao[idx][1].setText(classP.getNomePaisP().trim());
				this.lblClassificacao[idx][2].setText((new Integer(classP.getPontosGanhos())).toString().trim());
				this.lblClassificacao[idx][3].setText((new Integer(classP.getJogos())).toString().trim());
				this.lblClassificacao[idx][4].setText((new Integer(classP.getVitorias())).toString().trim());
				this.lblClassificacao[idx][5].setText((new Integer(classP.getEmpates())).toString().trim());
				this.lblClassificacao[idx][6].setText((new Integer(classP.getDerrotas())).toString().trim());
				this.lblClassificacao[idx][7].setText((new Integer(classP.getGolsPro())).toString().trim());
				this.lblClassificacao[idx][8].setText((new Integer(classP.getGolsContra())).toString().trim());
				this.lblClassificacao[idx][9].setText((new Integer(classP.getSaldoGols())).toString().trim());
				
			}
			
			if (tpEquipe == TipoEquipe.CLUBE) {
			
				VClassT classT = (VClassT) this.classDLista.get(idx);
				this.lblClassificacao[idx][1].setText(classT.getNomeTime().trim());
				this.lblClassificacao[idx][2].setText((new Integer(classT.getPontosGanhos())).toString().trim());
				this.lblClassificacao[idx][3].setText((new Integer(classT.getJogos())).toString().trim());
				this.lblClassificacao[idx][4].setText((new Integer(classT.getVitorias())).toString().trim());
				this.lblClassificacao[idx][5].setText((new Integer(classT.getEmpates())).toString().trim());
				this.lblClassificacao[idx][6].setText((new Integer(classT.getDerrotas())).toString().trim());
				this.lblClassificacao[idx][7].setText((new Integer(classT.getGolsPro())).toString().trim());
				this.lblClassificacao[idx][8].setText((new Integer(classT.getGolsContra())).toString().trim());
				this.lblClassificacao[idx][9].setText((new Integer(classT.getSaldoGols())).toString().trim());
				
			}
			
			for (int idxaux=0; idxaux<10; idxaux++) {
			
				if (idx < this.classf2) {
					this.lblClassificacao[idx][idxaux].setOpaque(true);
					this.lblClassificacao[idx][idxaux].setBackground(new Color(185,255,185));
				}
				if (idx < this.classf) { 
					this.lblClassificacao[idx][idxaux].setOpaque(true);
					this.lblClassificacao[idx][idxaux].setBackground(new Color(185,205,255));
				}
				if (idx > (this.qty - this.rebaix - 1)) {
					this.lblClassificacao[idx][idxaux].setOpaque(true);
					this.lblClassificacao[idx][idxaux].setBackground(new Color(255,205,100));
				}
				
				this.add(this.lblClassificacao[idx][idxaux]);
				
			}
			
		}
		
		this.repaint();
		
		return;
		
	}
	//********************************************************************************************************************************************
	
	//*** Getters e Setters **********************************************************************************************************************	
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
	
	public void setClassf(int classd) {
		this.classf = classf;
	}
	
	public void setRebaix(int rebaix) {
		this.rebaix = rebaix;
	}
	//********************************************************************************************************************************************
	
	//********************************************************************************************************************************************
	public void paintComponent(Graphics g) {
	
		super.paintComponent(g);
	
		g.setColor(new Color(225, 225, 225));
		
		for (int idx=1; idx<=this.qty; idx++) {
			g.drawLine(0, 18*idx, 460, 18*idx);
		}
		
		return;
		
	}
	//********************************************************************************************************************************************
	
}


