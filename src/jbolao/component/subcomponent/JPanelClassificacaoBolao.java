package jbolao.component.subcomponent;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JLabel;
import devito.dados.estruturas.DLista;
import jbolao.type.TipoEquipe;
import jbolao.type.TipoEtapaTorneio;
import jbolao.entity.VClassBolao;
import jbolao.dao.VClassBolaoPDAO;
import jbolao.dao.VClassBolaoTDAO;

public class JPanelClassificacaoBolao extends JPanel {

	//*** Componentes ****************************************************************************************************************************
	//Componentes
	private JLabel lblClassificacao[][];
	
	//Variaveis Globais
	private TipoEquipe tpEquipe;
	private TipoEtapaTorneio tpEtapaTorneio;
	private int qty = 0;
	private int width = 0;
	private int height = 0;
	private DLista classDLista = new DLista();
	//********************************************************************************************************************************************
	
	//*** Construtor *****************************************************************************************************************************
	public JPanelClassificacaoBolao(TipoEquipe tpEquipe, String strCodigoUsuario, String strNomeMesa, String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp) {
		
		this.setLayout(null);
		this.setBackground(new Color(255,255,255));
		
		this.tpEquipe = tpEquipe;
		
		VClassBolaoPDAO classbolaoPDAO;
		VClassBolaoTDAO classbolaoTDAO;
		
		if (this.tpEquipe == TipoEquipe.SELECAO) {
			classbolaoPDAO = new VClassBolaoPDAO();
			this.classDLista = classbolaoPDAO.selVClassBolaoByMesa(strNomeMesa);
		}
		if (this.tpEquipe == TipoEquipe.CLUBE) {
			classbolaoTDAO = new VClassBolaoTDAO();
			this.classDLista = classbolaoTDAO.selVClassBolaoByMesa(strNomeMesa);
		}
		
	}
	//********************************************************************************************************************************************
	
	//*** Carregar SubComponent ******************************************************************************************************************
	public void carregaSubComponent() {
		
		if (this.classDLista != null)
			this.qty = this.classDLista.count();
		
		this.width = 460;
		this.height = 18 * this.qty + 1;
		
		this.lblClassificacao = new JLabel[this.qty][7];
		
		for (int idx=0; idx<this.qty; idx++) {
		
			this.lblClassificacao[idx][0] = new JLabel();
			this.lblClassificacao[idx][0].setBounds(0,18*idx,40,17);
			this.lblClassificacao[idx][0].setHorizontalAlignment(JLabel.LEFT);
			this.lblClassificacao[idx][0].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblClassificacao[idx][0].setForeground(new Color(0, 0, 0));
			this.lblClassificacao[idx][0].setText((new Integer(idx+1)).toString());
			
			this.lblClassificacao[idx][1] = new JLabel();
			this.lblClassificacao[idx][1].setBounds(40,18*idx,70,17);
			this.lblClassificacao[idx][1].setHorizontalAlignment(JLabel.LEFT);
			this.lblClassificacao[idx][1].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblClassificacao[idx][1].setForeground(new Color(0, 0, 0));
			
			this.lblClassificacao[idx][2] = new JLabel();
			this.lblClassificacao[idx][2].setBounds(110,18*idx,70,17);
			this.lblClassificacao[idx][2].setHorizontalAlignment(JLabel.CENTER);
			this.lblClassificacao[idx][2].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblClassificacao[idx][2].setForeground(new Color(0, 0, 0));
			
			this.lblClassificacao[idx][3] = new JLabel();
			this.lblClassificacao[idx][3].setBounds(180,18*idx,70,17);
			this.lblClassificacao[idx][3].setHorizontalAlignment(JLabel.CENTER);
			this.lblClassificacao[idx][3].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblClassificacao[idx][3].setForeground(new Color(0, 0, 0));
			
			this.lblClassificacao[idx][4] = new JLabel();
			this.lblClassificacao[idx][4].setBounds(250,18*idx,70,17);
			this.lblClassificacao[idx][4].setHorizontalAlignment(JLabel.CENTER);
			this.lblClassificacao[idx][4].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblClassificacao[idx][4].setForeground(new Color(0, 0, 0));
			
			this.lblClassificacao[idx][5] = new JLabel();
			this.lblClassificacao[idx][5].setBounds(320,18*idx,70,17);
			this.lblClassificacao[idx][5].setHorizontalAlignment(JLabel.CENTER);
			this.lblClassificacao[idx][5].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblClassificacao[idx][5].setForeground(new Color(0, 0, 0));
			
			this.lblClassificacao[idx][6] = new JLabel();
			this.lblClassificacao[idx][6].setBounds(390,18*idx,70,17);
			this.lblClassificacao[idx][6].setHorizontalAlignment(JLabel.CENTER);
			this.lblClassificacao[idx][6].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblClassificacao[idx][6].setForeground(new Color(0, 0, 0));
			
			VClassBolao classbolao = (VClassBolao) this.classDLista.get(idx);
			this.lblClassificacao[idx][1].setText(classbolao.getCodigoUsuario().trim());
			this.lblClassificacao[idx][2].setText((new Integer(classbolao.getPontos())).toString().trim());
			this.lblClassificacao[idx][3].setText((new Integer(classbolao.getAcertosMosca())).toString().trim());
			this.lblClassificacao[idx][4].setText((new Integer(classbolao.getAcertosColunaGol())).toString().trim());
			this.lblClassificacao[idx][5].setText((new Integer(classbolao.getAcertosColuna())).toString().trim());
			this.lblClassificacao[idx][6].setText((new Integer(classbolao.getAcertosGol())).toString().trim());
			
			for (int idxaux=0; idxaux<7; idxaux++) {
			
				if ((idx % 4) == 0) {
					this.lblClassificacao[idx][idxaux].setOpaque(true);
					this.lblClassificacao[idx][idxaux].setBackground(new Color(185,205,255));
				}
				if ((idx % 4) == 1) { 
					this.lblClassificacao[idx][idxaux].setOpaque(true);
					this.lblClassificacao[idx][idxaux].setBackground(new Color(185,255,185));
				}
				if ((idx % 4) == 2) { 
					this.lblClassificacao[idx][idxaux].setOpaque(true);
					this.lblClassificacao[idx][idxaux].setBackground(new Color(255,255,140));
				}
				if ((idx % 4) == 3) { 
					this.lblClassificacao[idx][idxaux].setOpaque(true);
					this.lblClassificacao[idx][idxaux].setBackground(new Color(255,205,100));
				}
				
				this.add(this.lblClassificacao[idx][idxaux]);
				
			}
			
		}
		
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


