package jbolao.component.subcomponent;

import java.text.DecimalFormat;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
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
import jbolao.entity.VPalpiteP;
import jbolao.entity.VPalpiteT;
import jbolao.dao.CalendarioDAO;
import jbolao.dao.VJogoPDAO;
import jbolao.dao.VJogoTDAO;
import jbolao.dao.VPalpitePDAO;
import jbolao.dao.VPalpiteTDAO;

public class JPanelPalpites extends JPanel
							implements ActionListener {

	//*** Componentes ****************************************************************************************************************************
	//Componentes
	private JPanel pnlPalpites[];
	private JLabel lblPalpites[][];
	private MaskFormatter mskfmtPalpites;
	private JFormattedTextField txtPalpites[][];
	private JButton btnPalpites[], btnAlterarPalpites, btnSalvarPalpites;
	
	//Variaveis Globais
	private TipoEquipe tpEquipe;
	private TipoEtapaTorneio tpEtapaTorneio;
	private String strCodigoUsuario = null;
	private String strCodigoOutroUsuario = null;
	private int qty = 0;
	private int width = 0;
	private int height = 0;
	private DLista jogoDLista = new DLista();
	private DLista palpiteDLista = new DLista();
	//********************************************************************************************************************************************
	
	//*** Construtor *****************************************************************************************************************************
	public JPanelPalpites(TipoEquipe tpEquipe, TipoEtapaTorneio tpEtapaTorneio, String strCodigoUsuario, String strCodigoOutroUsuario, String strNomeMesa, String strCodigoPaisCamp, String strCodigoCamp, String strAnoInicioTemp, String strAnoFimTemp, String strCodigoAgrup) {
		
		this.setLayout(null);
		this.setBackground(new Color(255,255,255));
		
		this.tpEquipe = tpEquipe;
		this.tpEtapaTorneio = tpEtapaTorneio;
		
		this.strCodigoUsuario = strCodigoUsuario;
		this.strCodigoOutroUsuario = strCodigoOutroUsuario;
		
		VJogoPDAO jogoPDAO;
		VJogoTDAO jogoTDAO;
		
		VPalpitePDAO palpitePDAO;
		VPalpiteTDAO palpiteTDAO;
		
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
		
		if (this.jogoDLista != null) {
		
			for (int idx=0; idx<this.jogoDLista.count(); idx++) {
			
				String strCodigoPaisCampeonato = ((tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(idx)).getCodigoPaisCamp() : ((VJogoT) this.jogoDLista.get(idx)).getCodigoPaisCamp());
				String strCodigoCampeonato = ((tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(idx)).getCodigoCamp() : ((VJogoT) this.jogoDLista.get(idx)).getCodigoCamp());
				String strAnoInicioTemporada = ((tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(idx)).getAnoInicioTemp() : ((VJogoT) this.jogoDLista.get(idx)).getAnoInicioTemp());
				String strAnoFimTemporada = ((tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(idx)).getAnoFimTemp() : ((VJogoT) this.jogoDLista.get(idx)).getAnoFimTemp());
				String strCodigoJogo = ((tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(idx)).getCodigoJogo() : ((VJogoT) this.jogoDLista.get(idx)).getCodigoJogo());
				String strCodigoFaseJogo = ((tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(idx)).getCodigoFaseJogo() : ((VJogoT) this.jogoDLista.get(idx)).getCodigoFaseJogo());
				String strCodigoTurnoJogo = ((tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(idx)).getCodigoTurnoJogo() : ((VJogoT) this.jogoDLista.get(idx)).getCodigoTurnoJogo());
				String strCodigoRodadaJogo = ((tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(idx)).getCodigoRodadaJogo() : ((VJogoT) this.jogoDLista.get(idx)).getCodigoRodadaJogo());
				String strCodigoGrupoJogo = ((tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(idx)).getCodigoGrupoJogo() : ((VJogoT) this.jogoDLista.get(idx)).getCodigoGrupoJogo());
				String strUsuario = strCodigoUsuario;
				
				if (strCodigoOutroUsuario != null) {
					if (!strCodigoOutroUsuario.equals(strCodigoUsuario)) {
						strUsuario = strCodigoOutroUsuario;
					}
				}
				
				if (tpEquipe == TipoEquipe.SELECAO) {
					palpitePDAO = new VPalpitePDAO();
					VPalpiteP palpiteP = palpitePDAO.selVPalpiteByIdx(strUsuario, strNomeMesa, strCodigoPaisCampeonato, strCodigoCampeonato, strAnoInicioTemporada, strAnoFimTemporada, strCodigoJogo, strCodigoFaseJogo, strCodigoTurnoJogo, strCodigoRodadaJogo, strCodigoGrupoJogo);
					boolean b = this.palpiteDLista.InsereFim(palpiteP);
				}
				if (tpEquipe == TipoEquipe.CLUBE) {
					palpiteTDAO = new VPalpiteTDAO();
					VPalpiteT palpiteT = palpiteTDAO.selVPalpiteByIdx(strUsuario, strNomeMesa, strCodigoPaisCampeonato, strCodigoCampeonato, strAnoInicioTemporada, strAnoFimTemporada, strCodigoJogo, strCodigoFaseJogo, strCodigoTurnoJogo, strCodigoRodadaJogo, strCodigoGrupoJogo);
					boolean b = this.palpiteDLista.InsereFim(palpiteT);
				}
				
			}
			
		}
		
	}
	//********************************************************************************************************************************************
	
	//*** Carregar SubComponent ******************************************************************************************************************
	public void carregaSubComponent() {
		
		try {
			this.mskfmtPalpites = new MaskFormatter("#");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		this.qty = this.palpiteDLista.count();
		
		this.pnlPalpites = new JPanel[this.qty];
		this.lblPalpites = new JLabel[this.qty][6];
		this.txtPalpites = new JFormattedTextField[this.qty][2];
		this.btnPalpites = new JButton[this.qty];
		
		this.width = 480;
		this.height = 40 * this.qty + 28;
		
		DecimalFormat DF2 = new DecimalFormat("00");
		
		for (int idx=0; idx<this.qty; idx++) {
		
			this.pnlPalpites[idx] = new JPanel();
			this.pnlPalpites[idx].setLayout(null);
			this.pnlPalpites[idx].setBounds(0,40*idx,480,38);
			
			this.lblPalpites[idx][0] = new JLabel();
			this.lblPalpites[idx][0].setBounds(0,1,80,17);
			this.lblPalpites[idx][0].setHorizontalAlignment(JLabel.LEFT);
			this.lblPalpites[idx][0].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblPalpites[idx][0].setForeground(new Color(0, 0, 0));
			
			this.lblPalpites[idx][1] = new JLabel();
			this.lblPalpites[idx][1].setBounds(80,1,180,17);
			this.lblPalpites[idx][1].setHorizontalAlignment(JLabel.LEFT);
			this.lblPalpites[idx][1].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblPalpites[idx][1].setForeground(new Color(0, 0, 0));
			
			this.txtPalpites[idx][0] = new JFormattedTextField(this.mskfmtPalpites);
			this.txtPalpites[idx][0].setBounds(260,1,20,17);
			this.txtPalpites[idx][0].setHorizontalAlignment(JLabel.CENTER);
			this.txtPalpites[idx][0].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.txtPalpites[idx][0].setForeground(new Color(0, 0, 0));
			this.txtPalpites[idx][0].setBackground(new Color(255,255,255));
			this.txtPalpites[idx][0].setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
			this.txtPalpites[idx][0].setEditable(false);
			
			this.lblPalpites[idx][2] = new JLabel();
			this.lblPalpites[idx][2].setBounds(280,1,20,17);
			this.lblPalpites[idx][2].setHorizontalAlignment(JLabel.CENTER);
			this.lblPalpites[idx][2].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblPalpites[idx][2].setForeground(new Color(0, 0, 0));
			this.lblPalpites[idx][2].setText("X");
			
			this.txtPalpites[idx][1] = new JFormattedTextField(this.mskfmtPalpites);
			this.txtPalpites[idx][1].setBounds(300,1,20,17);
			this.txtPalpites[idx][1].setHorizontalAlignment(JLabel.CENTER);
			this.txtPalpites[idx][1].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.txtPalpites[idx][1].setForeground(new Color(0, 0, 0));
			this.txtPalpites[idx][1].setBackground(new Color(255,255,255));
			this.txtPalpites[idx][1].setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
			this.txtPalpites[idx][1].setEditable(false);
			
			this.lblPalpites[idx][3] = new JLabel();
			this.lblPalpites[idx][3].setBounds(320,1,160,17);
			this.lblPalpites[idx][3].setHorizontalAlignment(JLabel.RIGHT);
			this.lblPalpites[idx][3].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.lblPalpites[idx][3].setForeground(new Color(0, 0, 0));
			
			this.btnPalpites[idx] = new JButton("HABILITAR PALPITE");
			this.btnPalpites[idx].setBounds(0,20,120,17);
			this.btnPalpites[idx].setFont(new Font("Verdana", Font.ITALIC, 8));
			this.btnPalpites[idx].setForeground(new Color(255, 0, 0));
			this.btnPalpites[idx].setBackground(new Color(225,225,225));
			
			this.lblPalpites[idx][5] = new JLabel();
			this.lblPalpites[idx][5].setBounds(120,20,280,17);
			this.lblPalpites[idx][5].setHorizontalAlignment(JLabel.CENTER);
			this.lblPalpites[idx][5].setFont(new Font("Verdana", Font.ITALIC, 8));
			this.lblPalpites[idx][5].setForeground(new Color(255, 0, 0));
			
			this.lblPalpites[idx][4] = new JLabel();
			this.lblPalpites[idx][4].setBounds(400,20,80,17);
			this.lblPalpites[idx][4].setHorizontalAlignment(JLabel.RIGHT);
			this.lblPalpites[idx][4].setFont(new Font("Verdana", Font.ITALIC, 8));
			this.lblPalpites[idx][4].setForeground(new Color(255, 0, 0));
			
			int pontos = 0;
			
			CalendarioDAO calendarioDAO = new CalendarioDAO();
			Calendario calendario = calendarioDAO.selDateTime();
			String dtHoje = calendario.getDate().trim().replace('-', '/');
			String dtJogo = calendario.getDate().trim().replace('-', '/');
			
			if (this.tpEquipe == TipoEquipe.SELECAO) {
			
				VPalpiteP palpiteP = (VPalpiteP) this.palpiteDLista.get(idx);
				pontos = palpiteP.getPontos();
				dtJogo = palpiteP.getDataJogo().trim().replace('-', '/');
				this.lblPalpites[idx][0].setText(palpiteP.getDataJogo().trim());
				this.lblPalpites[idx][1].setText(palpiteP.getNomePaisHome().trim());
				this.txtPalpites[idx][0].setText((palpiteP.getPalpHomeScore() == -1)? " " : (new Integer(palpiteP.getPalpHomeScore())).toString());
				this.txtPalpites[idx][1].setText((palpiteP.getPalpAwayScore() == -1)? " " : (new Integer(palpiteP.getPalpAwayScore())).toString());
				this.lblPalpites[idx][3].setText(palpiteP.getNomePaisAway().trim());
				this.btnPalpites[idx].setEnabled((Date.compareDate(dtHoje, dtJogo) > 0)? true : false);
				this.lblPalpites[idx][4].setText("PONTOS: " + DF2.format(palpiteP.getPontos()));
				this.lblPalpites[idx][4].setVisible((Date.compareDate(dtHoje, dtJogo) <= 0)? true : false);
				this.lblPalpites[idx][5].setText(((palpiteP.getHomeScore() == -1) || (palpiteP.getAwayScore() == -1))? " " : "RESULTADO: " + palpiteP.getNomePaisHome().trim() + " " + palpiteP.getHomeScore() + "X" + palpiteP.getAwayScore() + " " + palpiteP.getNomePaisAway().trim());
				this.lblPalpites[idx][5].setVisible((Date.compareDate(dtHoje, dtJogo) <= 0)? true : false);
				
			}
			
			if (this.tpEquipe == TipoEquipe.CLUBE) {
			
				VPalpiteT palpiteT = (VPalpiteT) this.palpiteDLista.get(idx);
				pontos = palpiteT.getPontos();
				dtJogo = palpiteT.getDataJogo().trim().replace('-', '/');
				this.lblPalpites[idx][0].setText(palpiteT.getDataJogo().trim());
				this.lblPalpites[idx][1].setText(palpiteT.getNomeTimeHome().trim());
				this.txtPalpites[idx][0].setText((palpiteT.getPalpHomeScore() == -1)? " " : (new Integer(palpiteT.getPalpHomeScore())).toString());
				this.txtPalpites[idx][1].setText((palpiteT.getPalpAwayScore() == -1)? " " : (new Integer(palpiteT.getPalpAwayScore())).toString());
				this.lblPalpites[idx][3].setText(palpiteT.getNomeTimeAway().trim());
				this.btnPalpites[idx].setEnabled((Date.compareDate(dtHoje, dtJogo) > 0)? true : false);
				this.lblPalpites[idx][4].setText("PONTOS: " + DF2.format(palpiteT.getPontos()));
				this.lblPalpites[idx][4].setVisible((Date.compareDate(dtHoje, dtJogo) <= 0)? true : false);
				this.lblPalpites[idx][5].setText(((palpiteT.getHomeScore() == -1) || (palpiteT.getAwayScore() == -1))? " " : "RESULTADO: " + palpiteT.getNomeTimeHome().trim() + " " + palpiteT.getHomeScore() + "X" + palpiteT.getAwayScore() + " " + palpiteT.getNomeTimeAway().trim());
				this.lblPalpites[idx][5].setVisible((Date.compareDate(dtHoje, dtJogo) <= 0)? true : false);
				
			}
			
			if (pontos == 5)
				this.pnlPalpites[idx].setBackground(new Color(185,205,255));
			if (pontos == 4)
				this.pnlPalpites[idx].setBackground(new Color(185,255,185));
			if (pontos == 3)
				this.pnlPalpites[idx].setBackground(new Color(255,255,140));
			if (pontos == 1)
				this.pnlPalpites[idx].setBackground(new Color(255,205,100));
			if (pontos == 0)
				this.pnlPalpites[idx].setBackground(new Color(255,255,255));
			
			if (this.strCodigoOutroUsuario != null) {
				if (!this.strCodigoOutroUsuario.equals(this.strCodigoUsuario)) {
					this.txtPalpites[idx][0].setVisible((Date.compareDate(dtHoje, dtJogo) > 0)? false : true);
					this.txtPalpites[idx][1].setVisible((Date.compareDate(dtHoje, dtJogo) > 0)? false : true);
					this.btnPalpites[idx].setVisible(false);
				}
			}
			
			for (int idxaux=0; idxaux<6; idxaux++)
				this.pnlPalpites[idx].add(this.lblPalpites[idx][idxaux]);
				
			for (int idxaux=0; idxaux<2; idxaux++)
				this.pnlPalpites[idx].add(this.txtPalpites[idx][idxaux]);
				
			this.pnlPalpites[idx].add(this.btnPalpites[idx]);
			
			this.btnPalpites[idx].addActionListener(this);
			
			this.add(this.pnlPalpites[idx]);	
			
		}
		
		this.btnAlterarPalpites = new JButton("HABILITAR TODOS PALPITES");
		this.btnAlterarPalpites.setBounds(45,10+40*this.qty,200,17);
		this.btnAlterarPalpites.setFont(new Font("Verdana", Font.ITALIC, 8));
		this.btnAlterarPalpites.setForeground(new Color(255, 0, 0));
		this.btnAlterarPalpites.setBackground(new Color(225,225,225));
		this.btnAlterarPalpites.setEnabled(true);
		
		this.btnSalvarPalpites = new JButton("SALVAR TODOS PALPITES");
		this.btnSalvarPalpites.setBounds(255,10+40*this.qty,200,17);
		this.btnSalvarPalpites.setFont(new Font("Verdana", Font.ITALIC, 8));
		this.btnSalvarPalpites.setForeground(new Color(255, 0, 0));
		this.btnSalvarPalpites.setBackground(new Color(225,225,225));
		this.btnSalvarPalpites.setEnabled(false);
		
		if (this.strCodigoOutroUsuario != null) {
			if (!this.strCodigoOutroUsuario.equals(this.strCodigoUsuario)) {			
				this.btnAlterarPalpites.setVisible(false);
				this.btnSalvarPalpites.setVisible(false);
			}
		}
		
		this.btnAlterarPalpites.addActionListener(this);
		this.btnSalvarPalpites.addActionListener(this);
		
		this.add(this.btnAlterarPalpites);
		this.add(this.btnSalvarPalpites);
		
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
	
	public DLista getPalpiteDLista() {
		return this.palpiteDLista;
	}
	//********************************************************************************************************************************************
	
	//*** Habilitar Palpite **********************************************************************************************************************
	private void habilitaPalpite(int idx) {
	
		this.pnlPalpites[idx].remove(this.txtPalpites[idx][0]);
		this.pnlPalpites[idx].remove(this.txtPalpites[idx][1]);
		
		this.txtPalpites[idx][0] = new JFormattedTextField(mskfmtPalpites);
		this.txtPalpites[idx][0].setBounds(260,1,20,17);
		this.txtPalpites[idx][0].setHorizontalAlignment(JLabel.CENTER);
		this.txtPalpites[idx][0].setFont(new Font("Verdana", Font.PLAIN, 9));
		this.txtPalpites[idx][0].setForeground(new Color(0, 0, 0));
		this.txtPalpites[idx][0].setBackground(new Color(255,255,255));
		this.txtPalpites[idx][0].setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		this.txtPalpites[idx][0].setEditable(true);
		
		this.txtPalpites[idx][1] = new JFormattedTextField(mskfmtPalpites);
		this.txtPalpites[idx][1].setBounds(300,1,20,17);
		this.txtPalpites[idx][1].setHorizontalAlignment(JLabel.CENTER);
		this.txtPalpites[idx][1].setFont(new Font("Verdana", Font.PLAIN, 9));
		this.txtPalpites[idx][1].setForeground(new Color(0, 0, 0));
		this.txtPalpites[idx][1].setBackground(new Color(255,255,255));
		this.txtPalpites[idx][1].setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		this.txtPalpites[idx][1].setEditable(true);
		
		this.pnlPalpites[idx].add(this.txtPalpites[idx][0]);
		this.pnlPalpites[idx].add(this.txtPalpites[idx][1]);
		
		return;
		
	}
	//********************************************************************************************************************************************
	
	//*** Atualizar Palpite **********************************************************************************************************************	
	private void atualizaPalpite(int idx) {
	
		int palpHomeScore = -1;
		int palpAwayScore = -1;
		int count = 0;
		
		try {
			palpHomeScore = Integer.parseInt(this.txtPalpites[idx][0].getText().trim());
			palpAwayScore = Integer.parseInt(this.txtPalpites[idx][1].getText().trim());
		}
		catch (Exception e) {
			palpHomeScore = -1;
			palpAwayScore = -1;
		}
		
		try {
			VPalpitePDAO palpitePDAO = new VPalpitePDAO();
			VPalpiteP palpiteP = (VPalpiteP) this.palpiteDLista.get(idx);
			palpiteP.setPalpHomeScore(palpHomeScore);
			palpiteP.setPalpAwayScore(palpAwayScore);
			count = palpitePDAO.updVPalpite(palpiteP);
		}
		catch (Exception e) {
			VPalpiteTDAO palpiteTDAO = new VPalpiteTDAO();
			VPalpiteT palpiteT = (VPalpiteT) this.palpiteDLista.get(idx);
			palpiteT.setPalpHomeScore(palpHomeScore);
			palpiteT.setPalpAwayScore(palpAwayScore);
			count = palpiteTDAO.updVPalpite(palpiteT);
		}
		
		this.pnlPalpites[idx].remove(this.txtPalpites[idx][0]);
		this.pnlPalpites[idx].remove(this.txtPalpites[idx][1]);
		
		this.txtPalpites[idx][0] = new JFormattedTextField(mskfmtPalpites);
		this.txtPalpites[idx][0].setBounds(260,1,20,17);
		this.txtPalpites[idx][0].setHorizontalAlignment(JLabel.CENTER);
		this.txtPalpites[idx][0].setFont(new Font("Verdana", Font.PLAIN, 9));
		this.txtPalpites[idx][0].setForeground(new Color(0, 0, 0));
		this.txtPalpites[idx][0].setBackground(new Color(255,255,255));
		this.txtPalpites[idx][0].setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		
		this.txtPalpites[idx][1] = new JFormattedTextField(mskfmtPalpites);
		this.txtPalpites[idx][1].setBounds(300,1,20,17);
		this.txtPalpites[idx][1].setHorizontalAlignment(JLabel.CENTER);
		this.txtPalpites[idx][1].setFont(new Font("Verdana", Font.PLAIN, 9));
		this.txtPalpites[idx][1].setForeground(new Color(0, 0, 0));
		this.txtPalpites[idx][1].setBackground(new Color(255,255,255));
		this.txtPalpites[idx][1].setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		
		if ((count > 0) && (palpHomeScore != -1) && (palpAwayScore != -1)) {
			this.txtPalpites[idx][0].setText((new Integer(palpHomeScore)).toString());
			this.txtPalpites[idx][1].setText((new Integer(palpAwayScore)).toString());
		}
		else {
			this.txtPalpites[idx][0].setText(" ");
			this.txtPalpites[idx][1].setText(" ");
		}
		
		this.txtPalpites[idx][0].setEditable(false);
		this.txtPalpites[idx][1].setEditable(false);
		
		this.pnlPalpites[idx].add(this.txtPalpites[idx][0]);
		this.pnlPalpites[idx].add(this.txtPalpites[idx][1]);

		return;
		
	}
	//********************************************************************************************************************************************
	
	//********************************************************************************************************************************************
	public void paintComponent(Graphics g) {
	
		super.paintComponent(g);
	
		g.setColor(new Color(225, 225, 225));
		
		for (int idx=0; idx<this.qty; idx++) {
			g.drawLine(0, 39 + 40*idx, 480, 39 + 40*idx);
		}
		
		return;
		
	}
	
	public void actionPerformed(ActionEvent ae) {
	
		for (int idx=0; idx<this.qty; idx++) {
		
			if (ae.getSource() == this.btnPalpites[idx]) {
				
				this.habilitaPalpite(idx);
				this.btnPalpites[idx].setEnabled(false);
				this.btnSalvarPalpites.setEnabled(true);
				
				break;
				
			}
			
		}
		
		if (ae.getSource() == this.btnAlterarPalpites) {
		
			boolean b = false;
			String dtHoje = Date.calcDate();
			String dtJogo = Date.calcDate();
		
			for (int idx=0; idx<this.qty; idx++) {
			
				try {
					VPalpiteP palpiteP = (VPalpiteP) this.palpiteDLista.get(idx);
					dtJogo = palpiteP.getDataJogo().trim().replace('-', '/');
				}
				catch (Exception e) {
					VPalpiteT palpiteT = (VPalpiteT) this.palpiteDLista.get(idx);
					dtJogo = palpiteT.getDataJogo().trim().replace('-', '/');
				}
				
				if (Date.compareDate(dtHoje, dtJogo) > 0) {
					b = true;
					this.habilitaPalpite(idx);
					this.btnPalpites[idx].setEnabled(false);
				}
				
			}
			
			if (b) {
			
				this.btnAlterarPalpites.setEnabled(false);
				this.btnSalvarPalpites.setEnabled(true);
				
			}
			
		}
		
		if (ae.getSource() == this.btnSalvarPalpites) {
		
			String dtHoje = Date.calcDate();
			String dtJogo = Date.calcDate();
		
			for (int idx=0; idx<this.qty; idx++) {
			
				try {
					VPalpiteP palpiteP = (VPalpiteP) this.palpiteDLista.get(idx);
					dtJogo = palpiteP.getDataJogo().trim().replace('-', '/');
				}
				catch (Exception e) {
					VPalpiteT palpiteT = (VPalpiteT) this.palpiteDLista.get(idx);
					dtJogo = palpiteT.getDataJogo().trim().replace('-', '/');
				}
				
				if (Date.compareDate(dtHoje, dtJogo) > 0) {
					this.atualizaPalpite(idx);
					this.btnPalpites[idx].setEnabled(true);
				}
				
			}
			
			this.btnAlterarPalpites.setEnabled(true);
			this.btnSalvarPalpites.setEnabled(false);
		
		}
		
		return;
		
	}
	//********************************************************************************************************************************************
	
}


