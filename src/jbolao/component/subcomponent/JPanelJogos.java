package jbolao.component.subcomponent;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JLabel;
import devito.dados.estruturas.DLista;
import jbolao.type.TipoEquipe;
import jbolao.type.TipoEtapaTorneio;
import jbolao.entity.VJogoP;
import jbolao.entity.VJogoT;
import jbolao.dao.VJogoPDAO;
import jbolao.dao.VJogoTDAO;

public class JPanelJogos extends JPanel {

	//*** Componentes ****************************************************************************************************************************
	//Componentes
	private JLabel lblJogos[][];
	
	//Variaveis Globais
	private TipoEquipe tpEquipe;
	private TipoEtapaTorneio tpEtapaTorneio;
	private int qty = 0;
	private int width = 0;
	private int height = 0;
	private DLista jogoDLista = new DLista();
	//********************************************************************************************************************************************
	
	//*** Construtor *****************************************************************************************************************************
	public JPanelJogos(TipoEquipe tpEquipe, TipoEtapaTorneio tpEtapaTorneio, String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoAgrup) {
		
		this.setLayout(null);
		this.setBackground(new Color(255,255,255));
		
		this.tpEquipe = tpEquipe;
		this.tpEtapaTorneio = tpEtapaTorneio;
		
		VJogoPDAO jogoPDAO;
		VJogoTDAO jogoTDAO;
		
		if (this.tpEquipe == TipoEquipe.SELECAO) {
			jogoPDAO = new VJogoPDAO();
			if (this.tpEtapaTorneio == TipoEtapaTorneio.FASE_COPA) {
				if (strCodigoAgrup == null)
					this.jogoDLista = jogoPDAO.selVJogoByFaseAtual(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp);
				else 
					this.jogoDLista = jogoPDAO.selVJogoByFase(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoAgrup);
			}
			if (this.tpEtapaTorneio == TipoEtapaTorneio.RODADA_LIGA) {
				if (strCodigoAgrup == null)
					this.jogoDLista = jogoPDAO.selVJogoByRodadaAtual(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp);
				else
					this.jogoDLista = jogoPDAO.selVJogoByRodada(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoAgrup);
			}
			if (this.tpEtapaTorneio == TipoEtapaTorneio.FASE_TURNO_COPA) {
				if (strCodigoAgrup != null) 
					this.jogoDLista = jogoPDAO.selVJogoByFaseTurno(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoAgrup);
			}
			if (this.tpEtapaTorneio == TipoEtapaTorneio.FASE_GRUPO_COPA) {
				if (strCodigoAgrup != null)
					this.jogoDLista = jogoPDAO.selVJogoByFaseGrupo(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoAgrup);
			}
		}
		if (this.tpEquipe == TipoEquipe.CLUBE) {
			jogoTDAO = new VJogoTDAO();
			if (this.tpEtapaTorneio == TipoEtapaTorneio.FASE_COPA) {
				if (strCodigoAgrup == null)
					this.jogoDLista = jogoTDAO.selVJogoByFaseAtual(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp);
				else 
					this.jogoDLista = jogoTDAO.selVJogoByFase(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoAgrup);
			}
			if (this.tpEtapaTorneio == TipoEtapaTorneio.RODADA_LIGA) {
				if (strCodigoAgrup == null)
					this.jogoDLista = jogoTDAO.selVJogoByRodadaAtual(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp);
				else
					this.jogoDLista = jogoTDAO.selVJogoByRodada(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoAgrup);
			}
			if (this.tpEtapaTorneio == TipoEtapaTorneio.FASE_TURNO_COPA) {
				if (strCodigoAgrup != null)
					this.jogoDLista = jogoTDAO.selVJogoByFaseTurno(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoAgrup);
			}
			if (this.tpEtapaTorneio == TipoEtapaTorneio.FASE_GRUPO_COPA) {
				if (strCodigoAgrup != null)
					this.jogoDLista = jogoTDAO.selVJogoByFaseGrupo(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoAgrup);
			}
		}
		
	}
	//********************************************************************************************************************************************
	
	//*** Carregar SubComponent ******************************************************************************************************************
	public void carregaSubComponent() {
		
		if (this.jogoDLista != null)
			this.qty = this.jogoDLista.count();
		
		this.width = 480;
		this.height = 18 * this.qty + 1;
		
		this.lblJogos = new JLabel[this.qty][6];
		
		for (int idx=0; idx<this.qty; idx++) {
		
			this.lblJogos[idx][0] = new JLabel();
			this.lblJogos[idx][0].setBounds(0,18*idx,80,17);
			this.lblJogos[idx][0].setHorizontalAlignment(JLabel.LEFT);
			this.lblJogos[idx][0].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblJogos[idx][0].setForeground(new Color(0, 0, 0));
			
			this.lblJogos[idx][1] = new JLabel();
			this.lblJogos[idx][1].setBounds(80,18*idx,170,17);
			this.lblJogos[idx][1].setHorizontalAlignment(JLabel.LEFT);
			this.lblJogos[idx][1].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblJogos[idx][1].setForeground(new Color(0, 0, 0));

			this.lblJogos[idx][2] = new JLabel();
			this.lblJogos[idx][2].setBounds(250,18*idx,20,17);
			this.lblJogos[idx][2].setHorizontalAlignment(JLabel.CENTER);
			this.lblJogos[idx][2].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblJogos[idx][2].setForeground(new Color(0, 0, 0));

			this.lblJogos[idx][3] = new JLabel();
			this.lblJogos[idx][3].setBounds(270,18*idx,20,17);
			this.lblJogos[idx][3].setHorizontalAlignment(JLabel.CENTER);
			this.lblJogos[idx][3].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblJogos[idx][3].setForeground(new Color(0, 0, 0));
			this.lblJogos[idx][3].setText("X");

			this.lblJogos[idx][4] = new JLabel();
			this.lblJogos[idx][4].setBounds(290,18*idx,20,17);
			this.lblJogos[idx][4].setHorizontalAlignment(JLabel.CENTER);
			this.lblJogos[idx][4].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblJogos[idx][4].setForeground(new Color(0, 0, 0));

			this.lblJogos[idx][5] = new JLabel();
			this.lblJogos[idx][5].setBounds(310,18*idx,170,17);
			this.lblJogos[idx][5].setHorizontalAlignment(JLabel.RIGHT);
			this.lblJogos[idx][5].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblJogos[idx][5].setForeground(new Color(0, 0, 0));
			
			if (this.tpEquipe == TipoEquipe.SELECAO) {
			
				VJogoP jogoP = (VJogoP) this.jogoDLista.get(idx);
				this.lblJogos[idx][0].setText(jogoP.getDataJogo().trim());
				this.lblJogos[idx][1].setText(jogoP.getNomePaisHome().trim());
				this.lblJogos[idx][2].setText((jogoP.getHomeScore() == -1)? " " : (new Integer(jogoP.getHomeScore())).toString());
				this.lblJogos[idx][4].setText((jogoP.getAwayScore() == -1)? " " : (new Integer(jogoP.getAwayScore())).toString());
				this.lblJogos[idx][5].setText(jogoP.getNomePaisAway().trim());
				
			}
			
			if (this.tpEquipe == TipoEquipe.CLUBE) {
			
				VJogoT jogoT = (VJogoT) this.jogoDLista.get(idx);
				this.lblJogos[idx][0].setText(jogoT.getDataJogo().trim());
				this.lblJogos[idx][1].setText(jogoT.getNomeTimeHome().trim());
				this.lblJogos[idx][2].setText((jogoT.getHomeScore() == -1)? " " : (new Integer(jogoT.getHomeScore())).toString());
				this.lblJogos[idx][4].setText((jogoT.getAwayScore() == -1)? " " : (new Integer(jogoT.getAwayScore())).toString());
				this.lblJogos[idx][5].setText(jogoT.getNomeTimeAway().trim());
				
			}

				
			for (int idxaux=0; idxaux<6; idxaux++) {
				this.add(this.lblJogos[idx][idxaux]);
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
	
	public DLista getJogoDLista() {
		return this.jogoDLista;
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


