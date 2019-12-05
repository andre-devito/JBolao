package jbolao.component.subcomponent;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import devito.dados.estruturas.DLista;
import devito.calendario.Hour;
import devito.calendario.Date;
import jbolao.type.TipoEquipe;
import jbolao.type.TipoEtapaTorneio;
import jbolao.entity.Calendario;
import jbolao.entity.VJogoP;
import jbolao.entity.VJogoT;
import jbolao.dao.CalendarioDAO;
import jbolao.dao.VJogoPDAO;
import jbolao.dao.VJogoTDAO;

public class JPanelJogosAlter extends JPanel
							implements ActionListener {

	//*** Componentes ****************************************************************************************************************************
	//Componentes
	private MyPanel pnlJogosAlter;
	
	private JPanel pnlJogos[];
	private JLabel lblJogos[][];
	private MaskFormatter mskfmtJogos;
	private JFormattedTextField txtJogos[][];
	private JButton btnJogos[][], btnAlterarJogos, btnSalvarJogos;
	
	//Variaveis Globais
	private TipoEquipe tpEquipe;
	private TipoEtapaTorneio tpEtapaTorneio;
	private int qty = 0;
	private int width = 0;
	private int height = 0;
	private DLista jogoDLista = new DLista();
	//********************************************************************************************************************************************
	
	//*** Construtor *****************************************************************************************************************************
	public JPanelJogosAlter(TipoEquipe tpEquipe, TipoEtapaTorneio tpEtapaTorneio, String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoAgrup) {
		
		this.setLayout(null);
		this.setBackground(new Color(255,255,255));
		
		this.tpEquipe = tpEquipe;
		this.tpEtapaTorneio = tpEtapaTorneio;
		
		VJogoPDAO jogoPDAO;
		VJogoTDAO jogoTDAO;
		
		if (tpEquipe == TipoEquipe.SELECAO) {
			jogoPDAO = new VJogoPDAO();
			if (tpEtapaTorneio == TipoEtapaTorneio.FASE_COPA) {
				if (strCodigoAgrup == null)
					this.jogoDLista = jogoPDAO.selVJogoByFaseAtual(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp);
				else
					this.jogoDLista = jogoPDAO.selVJogoByFase(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoAgrup);
			}
			if (tpEtapaTorneio == TipoEtapaTorneio.RODADA_LIGA) {
				if (strCodigoAgrup == null)
					this.jogoDLista = jogoPDAO.selVJogoByRodadaAtual(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp);
				else
					this.jogoDLista = jogoPDAO.selVJogoByRodada(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoAgrup);
			}
			if (tpEtapaTorneio == TipoEtapaTorneio.FASE_TURNO_COPA) {
				if (strCodigoAgrup != null)
					this.jogoDLista = jogoPDAO.selVJogoByFaseTurno(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoAgrup);
			}
			if (tpEtapaTorneio == TipoEtapaTorneio.FASE_GRUPO_COPA) {
				if (strCodigoAgrup != null)
					this.jogoDLista = jogoPDAO.selVJogoByFaseGrupo(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoAgrup);
			}
		}
		if (tpEquipe == TipoEquipe.CLUBE) {
			jogoTDAO = new VJogoTDAO();
			if (tpEtapaTorneio == TipoEtapaTorneio.FASE_COPA) {
				if (strCodigoAgrup == null) 
					this.jogoDLista = jogoTDAO.selVJogoByFaseAtual(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp);
				else
					this.jogoDLista = jogoTDAO.selVJogoByFase(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoAgrup);
			}
			if (tpEtapaTorneio == TipoEtapaTorneio.RODADA_LIGA) {
				if (strCodigoAgrup == null)
					this.jogoDLista = jogoTDAO.selVJogoByRodadaAtual(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp);
				else 
					this.jogoDLista = jogoTDAO.selVJogoByRodada(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoAgrup);
			}
			if (tpEtapaTorneio == TipoEtapaTorneio.FASE_TURNO_COPA) {
				if (strCodigoAgrup != null)
					this.jogoDLista = jogoTDAO.selVJogoByFaseTurno(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoAgrup);
			}
			if (tpEtapaTorneio == TipoEtapaTorneio.FASE_GRUPO_COPA) {
				if (strCodigoAgrup != null) 
					this.jogoDLista = jogoTDAO.selVJogoByFaseGrupo(strCodigoPaisCamp, strCodigoCamp, strAnoInicioTemp, strAnoFimTemp, strCodigoAgrup);
			}
		}
		
	}
	//********************************************************************************************************************************************

	//*** Limpar SubComponent ********************************************************************************************************************
	public void limpaSubComponent() {
	
		this.btnSalvarJogos.setVisible(false);
		
		this.repaint();
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Carregar SubComponent ******************************************************************************************************************
	public void carregaSubComponent() {
		
		try {
			this.mskfmtJogos = new MaskFormatter("#");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		if (this.jogoDLista != null)
			this.qty = this.jogoDLista.count();
		
		this.pnlJogos = new JPanel[this.qty];
		this.lblJogos = new JLabel[this.qty][4];
		this.txtJogos = new JFormattedTextField[this.qty][2];
		this.btnJogos = new JButton[this.qty][3];
		
		this.width = 480;
		this.height = 40 * this.qty + 28;
		
		this.pnlJogosAlter = new MyPanel();
		this.pnlJogosAlter.setLayout(null);
		this.pnlJogosAlter.setBounds(0, 0, this.width, this.height);
		this.pnlJogosAlter.setBackground(new Color(255,255,255));
		
		for (int idx=0; idx<this.qty; idx++) {
		
			this.pnlJogos[idx] = new JPanel();
			this.pnlJogos[idx].setLayout(null);
			this.pnlJogos[idx].setBounds(0,40*idx,480,38);
			this.pnlJogos[idx].setBackground(new Color(255,255,255));
			
			this.lblJogos[idx][0] = new JLabel();
			this.lblJogos[idx][0].setBounds(0,1,80,17);
			this.lblJogos[idx][0].setHorizontalAlignment(JLabel.LEFT);
			this.lblJogos[idx][0].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblJogos[idx][0].setForeground(new Color(0, 0, 0));
			
			this.lblJogos[idx][1] = new JLabel();
			this.lblJogos[idx][1].setBounds(80,1,180,17);
			this.lblJogos[idx][1].setHorizontalAlignment(JLabel.LEFT);
			this.lblJogos[idx][1].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblJogos[idx][1].setForeground(new Color(0, 0, 0));
			
			this.txtJogos[idx][0] = new JFormattedTextField(this.mskfmtJogos);
			this.txtJogos[idx][0].setBounds(260,1,20,17);
			this.txtJogos[idx][0].setHorizontalAlignment(JLabel.CENTER);
			this.txtJogos[idx][0].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.txtJogos[idx][0].setForeground(new Color(0, 0, 0));
			this.txtJogos[idx][0].setBackground(new Color(255,255,255));
			this.txtJogos[idx][0].setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
			this.txtJogos[idx][0].setEditable(false);
			
			this.lblJogos[idx][2] = new JLabel();
			this.lblJogos[idx][2].setBounds(280,1,20,17);
			this.lblJogos[idx][2].setHorizontalAlignment(JLabel.CENTER);
			this.lblJogos[idx][2].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblJogos[idx][2].setForeground(new Color(0, 0, 0));
			this.lblJogos[idx][2].setText("X");
			
			this.txtJogos[idx][1] = new JFormattedTextField(this.mskfmtJogos);
			this.txtJogos[idx][1].setBounds(300,1,20,17);
			this.txtJogos[idx][1].setHorizontalAlignment(JLabel.CENTER);
			this.txtJogos[idx][1].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.txtJogos[idx][1].setForeground(new Color(0, 0, 0));
			this.txtJogos[idx][1].setBackground(new Color(255,255,255));
			this.txtJogos[idx][1].setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
			this.txtJogos[idx][1].setEditable(false);
			
			this.lblJogos[idx][3] = new JLabel();
			this.lblJogos[idx][3].setBounds(320,1,160,17);
			this.lblJogos[idx][3].setHorizontalAlignment(JLabel.RIGHT);
			this.lblJogos[idx][3].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblJogos[idx][3].setForeground(new Color(0, 0, 0));
			
			this.btnJogos[idx][0] = new JButton("ALTERAR DATA");
			this.btnJogos[idx][0].setBounds(0,20,180,17);
			this.btnJogos[idx][0].setFont(new Font("Verdana", Font.ITALIC, 8));
			this.btnJogos[idx][0].setForeground(new Color(255, 0, 0));
			this.btnJogos[idx][0].setBackground(new Color(225,225,225));
			
			this.btnJogos[idx][1] = new JButton("ALTERAR RESULTADO");
			this.btnJogos[idx][1].setBounds(190,20,160,17);
			this.btnJogos[idx][1].setFont(new Font("Verdana", Font.ITALIC, 8));
			this.btnJogos[idx][1].setForeground(new Color(255, 0, 0));
			this.btnJogos[idx][1].setBackground(new Color(225,225,225));
			
			this.btnJogos[idx][2] = new JButton("ALTERAR EQUIPES");
			this.btnJogos[idx][2].setBounds(360,20,120,17);
			this.btnJogos[idx][2].setFont(new Font("Verdana", Font.ITALIC, 8));
			this.btnJogos[idx][2].setForeground(new Color(255, 0, 0));
			this.btnJogos[idx][2].setBackground(new Color(225,225,225));
			
			CalendarioDAO calendarioDAO = new CalendarioDAO();
			Calendario calendario = calendarioDAO.selDateTime();
			String dtHoje = calendario.getDate().trim().replace('-', '/');
			String dtJogo = calendario.getDate().trim().replace('-', '/');
			
			if (this.tpEquipe == TipoEquipe.SELECAO) {
				
				VJogoP jogoP = (VJogoP) this.jogoDLista.get(idx);
				dtJogo = jogoP.getDataJogo().trim().replace('-', '/');
				this.lblJogos[idx][0].setText(jogoP.getDataJogo().trim());
				this.lblJogos[idx][1].setText(jogoP.getNomePaisHome().trim());
				this.txtJogos[idx][0].setText((jogoP.getHomeScore() == -1)? " " : (new Integer(jogoP.getHomeScore())).toString());
				this.txtJogos[idx][1].setText((jogoP.getAwayScore() == -1)? " " : (new Integer(jogoP.getAwayScore())).toString());
				this.lblJogos[idx][3].setText(jogoP.getNomePaisAway().trim());
				this.btnJogos[idx][0].setEnabled(true);
				this.btnJogos[idx][1].setEnabled(true);
				this.btnJogos[idx][2].setEnabled(true);
				
			}
			
			if (this.tpEquipe == TipoEquipe.CLUBE) {
			
				VJogoT jogoT = (VJogoT) this.jogoDLista.get(idx);
				dtJogo = jogoT.getDataJogo().trim().replace('-', '/');
				this.lblJogos[idx][0].setText(jogoT.getDataJogo().trim());
				this.lblJogos[idx][1].setText(jogoT.getNomeTimeHome().trim());
				this.txtJogos[idx][0].setText((jogoT.getHomeScore() == -1)? " " : (new Integer(jogoT.getHomeScore())).toString());
				this.txtJogos[idx][1].setText((jogoT.getAwayScore() == -1)? " " : (new Integer(jogoT.getAwayScore())).toString());
				this.lblJogos[idx][3].setText(jogoT.getNomeTimeAway().trim());
				this.btnJogos[idx][0].setEnabled(true);
				this.btnJogos[idx][1].setEnabled(true);
				this.btnJogos[idx][2].setEnabled(true);
				
			}
			
			for (int idxaux=0; idxaux<4; idxaux++)
				this.pnlJogos[idx].add(this.lblJogos[idx][idxaux]);
				
			for (int idxaux=0; idxaux<2; idxaux++)
				this.pnlJogos[idx].add(this.txtJogos[idx][idxaux]);
				
			for (int idxaux=0; idxaux<3; idxaux++)	
				this.pnlJogos[idx].add(this.btnJogos[idx][idxaux]);
				
			for (int idxaux=0; idxaux<2; idxaux++)	
				this.btnJogos[idx][idxaux].addActionListener(this);
			
			this.pnlJogosAlter.add(this.pnlJogos[idx]);
			
		}
		
		this.btnAlterarJogos = new JButton("ALTERAR TODOS RESULTADOS");
		this.btnAlterarJogos.setBounds(45,10+40*this.qty,200,17);
		this.btnAlterarJogos.setFont(new Font("Verdana", Font.ITALIC, 8));
		this.btnAlterarJogos.setForeground(new Color(255, 0, 0));
		this.btnAlterarJogos.setBackground(new Color(225,225,225));
		this.btnAlterarJogos.setEnabled(true);
		
		this.btnSalvarJogos = new JButton("SALVAR TODOS RESULTADOS");
		this.btnSalvarJogos.setBounds(255,10+40*this.qty,200,17);
		this.btnSalvarJogos.setFont(new Font("Verdana", Font.ITALIC, 8));
		this.btnSalvarJogos.setForeground(new Color(255, 0, 0));
		this.btnSalvarJogos.setBackground(new Color(225,225,225));
		this.btnSalvarJogos.setEnabled(false);
		
		this.btnAlterarJogos.addActionListener(this);
		this.btnSalvarJogos.addActionListener(this);
		
		this.pnlJogosAlter.add(this.btnAlterarJogos);
		this.pnlJogosAlter.add(this.btnSalvarJogos);
		
		this.add(this.pnlJogosAlter);
		
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
	
	//*** Habilitar Resultado ********************************************************************************************************************
	private void habilitaResultado(int idx) {
	
		this.pnlJogos[idx].remove(this.txtJogos[idx][0]);
		this.pnlJogos[idx].remove(this.txtJogos[idx][1]);
		
		this.txtJogos[idx][0] = new JFormattedTextField(mskfmtJogos);
		this.txtJogos[idx][0].setBounds(260,1,20,17);
		this.txtJogos[idx][0].setHorizontalAlignment(JLabel.CENTER);
		this.txtJogos[idx][0].setFont(new Font("Verdana", Font.PLAIN, 9));
		this.txtJogos[idx][0].setForeground(new Color(0, 0, 0));
		this.txtJogos[idx][0].setBackground(new Color(255,255,255));
		this.txtJogos[idx][0].setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		this.txtJogos[idx][0].setEditable(true);
		
		this.txtJogos[idx][1] = new JFormattedTextField(mskfmtJogos);
		this.txtJogos[idx][1].setBounds(300,1,20,17);
		this.txtJogos[idx][1].setHorizontalAlignment(JLabel.CENTER);
		this.txtJogos[idx][1].setFont(new Font("Verdana", Font.PLAIN, 9));
		this.txtJogos[idx][1].setForeground(new Color(0, 0, 0));
		this.txtJogos[idx][1].setBackground(new Color(255,255,255));
		this.txtJogos[idx][1].setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		this.txtJogos[idx][1].setEditable(true);
		
		this.pnlJogos[idx].add(this.txtJogos[idx][0]);
		this.pnlJogos[idx].add(this.txtJogos[idx][1]);
		
		return;
		
	}
	//********************************************************************************************************************************************
	
	//*** Atualizar Resultado ********************************************************************************************************************	
	private void atualizaResultado(int idx) {
	
		int homeScore = -1;
		int awayScore = -1;
		int count = 0;
		
		try {
			homeScore = Integer.parseInt(this.txtJogos[idx][0].getText().trim());
			awayScore = Integer.parseInt(this.txtJogos[idx][1].getText().trim());
		}
		catch (Exception e) {
			homeScore = -1;
			awayScore = -1;
		}
		
		try {
			VJogoPDAO jogoPDAO = new VJogoPDAO();
			VJogoP jogoP = (VJogoP) this.jogoDLista.get(idx);
			jogoP.setHomeScore(homeScore);
			jogoP.setAwayScore(awayScore);
			count = jogoPDAO.updVJogo(jogoP);
		}
		catch (Exception e) {
			VJogoTDAO jogoTDAO = new VJogoTDAO();
			VJogoT jogoT = (VJogoT) this.jogoDLista.get(idx);
			jogoT.setHomeScore(homeScore);
			jogoT.setAwayScore(awayScore);
			count = jogoTDAO.updVJogo(jogoT);
		}
		
		this.pnlJogos[idx].remove(this.txtJogos[idx][0]);
		this.pnlJogos[idx].remove(this.txtJogos[idx][1]);
		
		this.txtJogos[idx][0] = new JFormattedTextField(mskfmtJogos);
		this.txtJogos[idx][0].setBounds(260,1,20,17);
		this.txtJogos[idx][0].setHorizontalAlignment(JLabel.CENTER);
		this.txtJogos[idx][0].setFont(new Font("Verdana", Font.PLAIN, 9));
		this.txtJogos[idx][0].setForeground(new Color(0, 0, 0));
		this.txtJogos[idx][0].setBackground(new Color(255,255,255));
		this.txtJogos[idx][0].setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		
		this.txtJogos[idx][1] = new JFormattedTextField(mskfmtJogos);
		this.txtJogos[idx][1].setBounds(300,1,20,17);
		this.txtJogos[idx][1].setHorizontalAlignment(JLabel.CENTER);
		this.txtJogos[idx][1].setFont(new Font("Verdana", Font.PLAIN, 9));
		this.txtJogos[idx][1].setForeground(new Color(0, 0, 0));
		this.txtJogos[idx][1].setBackground(new Color(255,255,255));
		this.txtJogos[idx][1].setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		
		if ((count > 0) && (homeScore != -1) && (awayScore != -1)) {
			this.txtJogos[idx][0].setText((new Integer(homeScore)).toString());
			this.txtJogos[idx][1].setText((new Integer(awayScore)).toString());
		}
		else {
			this.txtJogos[idx][0].setText(" ");
			this.txtJogos[idx][1].setText(" ");
		}
		
		this.txtJogos[idx][0].setEditable(false);
		this.txtJogos[idx][1].setEditable(false);
		
		this.pnlJogos[idx].add(this.txtJogos[idx][0]);
		this.pnlJogos[idx].add(this.txtJogos[idx][1]);

		return;
		
	}
	//********************************************************************************************************************************************
	
	//********************************************************************************************************************************************	
	public void actionPerformed(ActionEvent ae) {
	
		for (int idx=0; idx<this.qty; idx++) {
		
			if (ae.getSource() == this.btnJogos[idx][0]) {
				
				this.habilitaResultado(idx);
				this.btnJogos[idx][0].setEnabled(false);
				this.btnJogos[idx][1].setEnabled(false);
				this.btnJogos[idx][2].setEnabled(false);
				this.btnSalvarJogos.setEnabled(true);
				
				break;
				
			}
			
		}
		
		for (int idx=0; idx<this.qty; idx++) {
		
			if (ae.getSource() == this.btnJogos[idx][1]) {
				
				this.habilitaResultado(idx);
				this.btnJogos[idx][0].setEnabled(false);
				this.btnJogos[idx][1].setEnabled(false);
				this.btnJogos[idx][2].setEnabled(false);
				this.btnSalvarJogos.setEnabled(true);
				
				break;
				
			}
			
		}
		
		for (int idx=0; idx<this.qty; idx++) {
		
			if (ae.getSource() == this.btnJogos[idx][2]) {
				
				this.habilitaResultado(idx);
				this.btnJogos[idx][0].setEnabled(false);
				this.btnJogos[idx][1].setEnabled(false);
				this.btnJogos[idx][2].setEnabled(false);
				this.btnSalvarJogos.setEnabled(true);
				
				break;
				
			}
			
		}
		
		if (ae.getSource() == this.btnAlterarJogos) {
		
			String dtHoje = Date.calcDate();
			String dtJogo = Date.calcDate();
		
			for (int idx=0; idx<this.qty; idx++) {
			
				try {
					VJogoP jogoP = (VJogoP) this.jogoDLista.get(idx);
					dtJogo = jogoP.getDataJogo().trim().replace('-', '/');
				}
				catch (Exception e) {
					VJogoT jogoT = (VJogoT) this.jogoDLista.get(idx);
					dtJogo = jogoT.getDataJogo().trim().replace('-', '/');
				}
				
				this.habilitaResultado(idx);
				this.btnJogos[idx][0].setEnabled(false);
				this.btnJogos[idx][1].setEnabled(false);
				this.btnJogos[idx][2].setEnabled(false);
				
			}
			
			this.btnAlterarJogos.setEnabled(false);
			this.btnSalvarJogos.setEnabled(true);
			
		}
		
		if (ae.getSource() == this.btnSalvarJogos) {
		
			String dtHoje = Date.calcDate();
			String dtJogo = Date.calcDate();
		
			for (int idx=0; idx<this.qty; idx++) {
			
				try {
					VJogoP jogoP = (VJogoP) this.jogoDLista.get(idx);
					dtJogo = jogoP.getDataJogo().trim().replace('-', '/');
				}
				catch (Exception e) {
					VJogoT jogoT = (VJogoT) this.jogoDLista.get(idx);
					dtJogo = jogoT.getDataJogo().trim().replace('-', '/');
				}
				
				this.atualizaResultado(idx);
				this.btnJogos[idx][0].setEnabled(true);
				this.btnJogos[idx][1].setEnabled(true);
				this.btnJogos[idx][2].setEnabled(true);
				
			}
			
			this.btnAlterarJogos.setEnabled(true);
			this.btnSalvarJogos.setEnabled(false);
		
		}
		
		return;
		
	}
	//********************************************************************************************************************************************
	
	//********************************************************************************************************************************************
	private class MyPanel extends JPanel {
	
		private MyPanel() {}
	
		public void paintComponent(Graphics g) {
		
			super.paintComponent(g);
		
			g.setColor(new Color(225, 225, 225));
			
			for (int idx=0; idx<qty; idx++) {
				g.drawLine(0, 39 + 40*idx, 480, 39 + 40*idx);
			}
			
			return;
			
		}
		
	}
	//********************************************************************************************************************************************
	
}


