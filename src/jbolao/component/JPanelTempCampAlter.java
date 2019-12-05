package jbolao.component;

import java.text.DecimalFormat;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import devito.dados.estruturas.DLista;
import jbolao.type.TipoEquipe;
import jbolao.type.TipoEtapaTorneio;
import jbolao.entity.VTemp;
import jbolao.entity.VJogoP;
import jbolao.entity.VJogoT;
import jbolao.entity.Operacional;
import jbolao.dao.OperacionalDAO;
import jbolao.component.subcomponent.JPanelJogosAlter;

public class JPanelTempCampAlter extends JPanel
						implements ActionListener {
							
	//*** Componentes ****************************************************************************************************************************
	//Componentes
	private JLabel lblCabecJogos01, lblCabecJogos01Aux, lblCabecJogos02, lblCabecJogos02Aux;
	
	private JButton btnCabecJogos01Ant, btnCabecJogos01Pos, btnCabecJogos02Ant, btnCabecJogos02Pos;
	
	private JPanelJogosAlter pnlJogosAlter;
	
	//Constantes Globais
	private final int ANT = -1;
	private final int ATU = 0;
	private final int POS = 1;
	
	//Variaveis Globais
	private TipoEquipe tpEquipe;
	private TipoEtapaTorneio tpEtapaTorneio;
	private int width = 500;
	private int height = 600;	
	private VTemp temp = null;
	private DLista jogoDLista = null;
	//********************************************************************************************************************************************

	//*** Construtores ***************************************************************************************************************************
	public JPanelTempCampAlter() {
	
		this(null);
		
	}
	
	public JPanelTempCampAlter(VTemp temp) {
		
		this.setLayout(null);
		this.setBackground(new Color(255,255,255));
		
		this.temp = temp;
		
		this.lblCabecJogos01Aux = new JLabel();
		this.lblCabecJogos01Aux.setBounds(10,5,480,20);
		this.lblCabecJogos01Aux.setOpaque(true);
		this.lblCabecJogos01Aux.setBackground(new Color(225,225,225));
		
		this.lblCabecJogos01 = new JLabel();
		this.lblCabecJogos01.setBounds(70,5,360,20);
		this.lblCabecJogos01.setHorizontalAlignment(JLabel.LEFT);
		this.lblCabecJogos01.setOpaque(true);
		this.lblCabecJogos01.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblCabecJogos01.setForeground(new Color(0, 0, 0));
		this.lblCabecJogos01.setBackground(new Color(225,225,225));
		
		this.lblCabecJogos02Aux = new JLabel();
		this.lblCabecJogos02Aux.setBounds(10,35,480,20);
		this.lblCabecJogos02Aux.setOpaque(true);
		this.lblCabecJogos02Aux.setBackground(new Color(225,225,225));
		
		this.lblCabecJogos02 = new JLabel();
		this.lblCabecJogos02.setBounds(70,35,360,20);
		this.lblCabecJogos02.setHorizontalAlignment(JLabel.LEFT);
		this.lblCabecJogos02.setOpaque(true);
		this.lblCabecJogos02.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblCabecJogos02.setForeground(new Color(0, 0, 0));
		this.lblCabecJogos02.setBackground(new Color(225,225,225));
		
		this.btnCabecJogos01Ant = new JButton("<<");
		this.btnCabecJogos01Ant.setBounds(10,5,50,20);
		this.btnCabecJogos01Ant.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnCabecJogos01Ant.setForeground(new Color(0, 0, 0));
		this.btnCabecJogos01Ant.setBackground(new Color(225,225,225));
		
		this.btnCabecJogos01Pos = new JButton(">>");
		this.btnCabecJogos01Pos.setBounds(440,5,50,20);
		this.btnCabecJogos01Pos.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnCabecJogos01Pos.setForeground(new Color(0, 0, 0));
		this.btnCabecJogos01Pos.setBackground(new Color(225,225,225));
		
		this.btnCabecJogos02Ant = new JButton("<<");
		this.btnCabecJogos02Ant.setBounds(10,35,50,20);
		this.btnCabecJogos02Ant.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnCabecJogos02Ant.setForeground(new Color(0, 0, 0));
		this.btnCabecJogos02Ant.setBackground(new Color(225,225,225));
		
		this.btnCabecJogos02Pos = new JButton(">>");
		this.btnCabecJogos02Pos.setBounds(440,35,50,20);
		this.btnCabecJogos02Pos.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnCabecJogos02Pos.setForeground(new Color(0, 0, 0));
		this.btnCabecJogos02Pos.setBackground(new Color(225,225,225));
		
		this.add(this.btnCabecJogos01Ant);
		this.add(this.btnCabecJogos01Pos);
		this.add(this.lblCabecJogos01);
		this.add(this.lblCabecJogos01Aux);
		this.add(this.btnCabecJogos02Ant);
		this.add(this.btnCabecJogos02Pos);
		this.add(this.lblCabecJogos02);
		this.add(this.lblCabecJogos02Aux);
		
		this.btnCabecJogos01Ant.addActionListener(this);
		this.btnCabecJogos01Pos.addActionListener(this);
		this.btnCabecJogos02Ant.addActionListener(this);
		this.btnCabecJogos02Pos.addActionListener(this);
		
	}
	//********************************************************************************************************************************************
	
	//*** Getters e Setters **********************************************************************************************************************		
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public VTemp getTemp() {
		return this.temp;
	}
	
	public DLista getJogoDLista() {
		return this.jogoDLista;
	}
	
	public void setTemp(VTemp temp) {
		this.temp = temp;
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Tela TempCamp *****************************************************************************************************************
	public void carregaTelaTempCamp() {
	
		if (this.pnlJogosAlter != null)
			this.remove(this.pnlJogosAlter);
			
		this.jogoDLista = null;
		
		int intCodigoPaisCampeonato = Integer.parseInt(this.temp.getCodigoPaisCampeonato());
		int intCodigoCampeonato = Integer.parseInt(this.temp.getCodigoCampeonato());
		
		if ((intCodigoCampeonato >= 901) && (intCodigoCampeonato <= 999))
			this.tpEquipe = TipoEquipe.SELECAO;
		else
			this.tpEquipe = TipoEquipe.CLUBE;
			
		if ((intCodigoCampeonato >= 1) && (intCodigoCampeonato <= 100))
			this.tpEtapaTorneio = TipoEtapaTorneio.RODADA_LIGA;
		else
			this.tpEtapaTorneio = TipoEtapaTorneio.FASE_COPA;
			
		JPanelJogosAlter pnlJogosAlterAux = new JPanelJogosAlter(this.tpEquipe, this.tpEtapaTorneio, this.temp.getCodigoPaisCampeonato(), this.temp.getCodigoCampeonato(), this.temp.getAnoInicioTemporada(), this.temp.getAnoFimTemporada(), null);
		
		if ((pnlJogosAlterAux.getJogoDLista() != null) && (pnlJogosAlterAux.getJogoDLista().count() > 0)) {
		
			this.jogoDLista = pnlJogosAlterAux.getJogoDLista();
			
			int intCodigoFase = Integer.parseInt((this.tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(0)).getCodigoFaseJogo() : ((VJogoT) this.jogoDLista.get(0)).getCodigoFaseJogo());
		
			if (this.tpEtapaTorneio == TipoEtapaTorneio.FASE_COPA) {
				
				this.pnlJogosAlter = new JPanelJogosAlter(this.tpEquipe, this.tpEtapaTorneio, this.temp.getCodigoPaisCampeonato(), this.temp.getCodigoCampeonato(), this.temp.getAnoInicioTemporada(), this.temp.getAnoFimTemporada(), null);
				this.pnlJogosAlter.carregaSubComponent();
				this.pnlJogosAlter.setBounds(10,55,this.pnlJogosAlter.getWidth(),this.pnlJogosAlter.getHeight());
				this.add(this.pnlJogosAlter);
				
				this.lblCabecJogos02.setVisible(true);
				this.lblCabecJogos02Aux.setVisible(true);
				
				this.btnCabecJogos02Ant.setVisible(true);
				this.btnCabecJogos02Pos.setVisible(true);
				
				this.lblCabecJogos01.setText((this.tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(0)).getDescFaseJogo().trim() : ((VJogoT) this.jogoDLista.get(0)).getDescFaseJogo().trim());
				if (intCodigoFase == 34)
					this.lblCabecJogos02.setText((this.tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(0)).getDescGrupoJogo().trim() : ((VJogoT) this.jogoDLista.get(0)).getDescGrupoJogo().trim());
				else
					this.lblCabecJogos02.setText((this.tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(0)).getDescTurnoJogo().trim() : ((VJogoT) this.jogoDLista.get(0)).getDescTurnoJogo().trim());
					
			}
			
			if (this.tpEtapaTorneio == TipoEtapaTorneio.RODADA_LIGA) {
		
				this.pnlJogosAlter = new JPanelJogosAlter(this.tpEquipe, this.tpEtapaTorneio, this.temp.getCodigoPaisCampeonato(), this.temp.getCodigoCampeonato(), this.temp.getAnoInicioTemporada(), this.temp.getAnoFimTemporada(), null);
				this.pnlJogosAlter.carregaSubComponent();
				this.pnlJogosAlter.setBounds(10,25,this.pnlJogosAlter.getWidth(),this.pnlJogosAlter.getHeight());
				this.add(this.pnlJogosAlter);
				
				this.lblCabecJogos02.setVisible(false);
				this.lblCabecJogos02Aux.setVisible(false);
				
				this.btnCabecJogos02Ant.setVisible(false);
				this.btnCabecJogos02Pos.setVisible(false);
				
				this.lblCabecJogos01.setText((this.tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(0)).getDescRodadaJogo().trim() : ((VJogoT) this.jogoDLista.get(0)).getDescRodadaJogo().trim());
				
			}
			
		}
		
		else {
		
			if (this.tpEtapaTorneio == TipoEtapaTorneio.FASE_COPA) {
				
				this.lblCabecJogos02.setVisible(true);
				this.lblCabecJogos02Aux.setVisible(true);
				
				this.btnCabecJogos02Ant.setVisible(true);
				this.btnCabecJogos02Pos.setVisible(true);
				
				this.lblCabecJogos01.setText("SEM INFORMAÇÃO DISPONÍVEL");
				this.lblCabecJogos02.setText("SEM INFORMAÇÃO DISPONÍVEL");
						
			}
			
			if (this.tpEtapaTorneio == TipoEtapaTorneio.RODADA_LIGA) {
				
				this.lblCabecJogos02.setVisible(false);
				this.lblCabecJogos02Aux.setVisible(false);
				
				this.btnCabecJogos02Ant.setVisible(false);
				this.btnCabecJogos02Pos.setVisible(false);
				
				this.lblCabecJogos01.setText("SEM INFORMAÇÃO DISPONÍVEL");
			
			}
			
		}
		
		this.repaint();
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Atualizar Tela TempCamp ****************************************************************************************************************
	private void atualizaTelaTempCamp(int intJogos01, int intJogos02) {
	
		if (this.pnlJogosAlter != null)
			this.remove(this.pnlJogosAlter);
			
		if ((this.jogoDLista != null) && (this.jogoDLista.count() > 0)) {
		
			JPanelJogosAlter pnlJogosAlterAux = null;
		
			int intCodigoFase = Integer.parseInt((this.tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(0)).getCodigoFaseJogo() : ((VJogoT) this.jogoDLista.get(0)).getCodigoFaseJogo());	
			int intCodigoRodada = Integer.parseInt((this.tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(0)).getCodigoRodadaJogo() : ((VJogoT) this.jogoDLista.get(0)).getCodigoRodadaJogo());
			int intCodigoTurno = Integer.parseInt((this.tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(0)).getCodigoTurnoJogo() : ((VJogoT) this.jogoDLista.get(0)).getCodigoTurnoJogo());	
			int intCodigoGrupo = Integer.parseInt((this.tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(0)).getCodigoGrupoJogo() : ((VJogoT) this.jogoDLista.get(0)).getCodigoGrupoJogo());
			
			DecimalFormat DF3 = new DecimalFormat("000");
			
			String strCodigoFase = DF3.format(intCodigoFase);
			String strCodigoTurno = DF3.format(intCodigoTurno);
			String strCodigoRodada = DF3.format(intCodigoRodada);
			String strCodigoGrupo = DF3.format(intCodigoGrupo);
			String strCodigoAgrup = strCodigoFase + strCodigoTurno + strCodigoRodada + strCodigoGrupo;
			
			if (this.tpEtapaTorneio == TipoEtapaTorneio.FASE_COPA) {
			
				if (intJogos02 != 0) {
			
					if (intCodigoFase == 34) {
						this.tpEtapaTorneio = TipoEtapaTorneio.FASE_GRUPO_COPA;
						intCodigoGrupo = intCodigoGrupo + intJogos02;
					}
					else {
						this.tpEtapaTorneio = TipoEtapaTorneio.FASE_TURNO_COPA;
						intCodigoTurno = intCodigoTurno + intJogos02;	
					}
					
					strCodigoGrupo = DF3.format(intCodigoGrupo);
					strCodigoTurno = DF3.format(intCodigoTurno);
					strCodigoAgrup = strCodigoFase + ((this.tpEtapaTorneio == TipoEtapaTorneio.FASE_GRUPO_COPA)? strCodigoGrupo : strCodigoTurno);
					pnlJogosAlterAux = new JPanelJogosAlter(this.tpEquipe, this.tpEtapaTorneio, this.temp.getCodigoPaisCampeonato(), this.temp.getCodigoCampeonato(), this.temp.getAnoInicioTemporada(), this.temp.getAnoFimTemporada(), strCodigoAgrup);
					this.tpEtapaTorneio = TipoEtapaTorneio.FASE_COPA;
					
				}
				
				else {
				
					int intCodigoFaseTentv[] = new int[0];
					
					if (intJogos01 > 0) {
					
						if ((intCodigoFase <= 10) || (intCodigoFase == 34)) {
							intCodigoFaseTentv = new int[6];
							intCodigoFaseTentv[0] = intCodigoFase + 1;
							intCodigoFaseTentv[1] = 26;
							intCodigoFaseTentv[2] = 25;
							intCodigoFaseTentv[3] = 24;
							intCodigoFaseTentv[4] = 23;
							intCodigoFaseTentv[5] = 22;
						}
						else if (intCodigoFase <= 30) {
							intCodigoFaseTentv = new int[2];
							intCodigoFaseTentv[0] = intCodigoFase - 1;
							intCodigoFaseTentv[1] = 11;
						}
						else if (intCodigoFase <= 50) {
							intCodigoFaseTentv = new int[2];
							intCodigoFaseTentv[0] = intCodigoFase + 1;
							intCodigoFaseTentv[1] = 34;
						}
						
					}
					
					else {
					
						if (intCodigoFase <= 10) {
							intCodigoFaseTentv = new int[1];
							intCodigoFaseTentv[0] = intCodigoFase - 1;
						}
						else if (intCodigoFase == 11) {
							intCodigoFaseTentv = new int[8];
							intCodigoFaseTentv[0] = 12;
							intCodigoFaseTentv[1] = 13;
							intCodigoFaseTentv[2] = 14;
							intCodigoFaseTentv[3] = 15;
							intCodigoFaseTentv[4] = 16;
							intCodigoFaseTentv[5] = 17;
							intCodigoFaseTentv[6] = 18;
							intCodigoFaseTentv[7] = 21;
						}
						else if (intCodigoFase <= 30) {
							intCodigoFaseTentv = new int[7];
							intCodigoFaseTentv[0] = intCodigoFase + 1;
							intCodigoFaseTentv[1] = 5;
							intCodigoFaseTentv[2] = 4;
							intCodigoFaseTentv[3] = 3;
							intCodigoFaseTentv[4] = 2;
							intCodigoFaseTentv[5] = 1;
							intCodigoFaseTentv[6] = 34;
						}
						else if (intCodigoFase <= 50) {
							intCodigoFaseTentv = new int[2];
							intCodigoFaseTentv[0] = intCodigoFase - 1;
							intCodigoFaseTentv[1] = 34;
						}
						
					}
				
					for (int idx=0; idx<intCodigoFaseTentv.length; idx++) {
						strCodigoFase = DF3.format(intCodigoFaseTentv[idx]);
						pnlJogosAlterAux = new JPanelJogosAlter(this.tpEquipe, this.tpEtapaTorneio, this.temp.getCodigoPaisCampeonato(), this.temp.getCodigoCampeonato(), this.temp.getAnoInicioTemporada(), this.temp.getAnoFimTemporada(), strCodigoFase);
						if ((pnlJogosAlterAux.getJogoDLista() != null) && (pnlJogosAlterAux.getJogoDLista().count() > 0)) {
							intCodigoFase = intCodigoFaseTentv[idx];
							strCodigoFase = DF3.format(intCodigoFase);
							break;
						}
					}
					
					DLista operacaoDLista = new DLista();
					
					if ((pnlJogosAlterAux != null) && (pnlJogosAlterAux.getJogoDLista() != null) && (pnlJogosAlterAux.getJogoDLista().count() > 0)) {
						if (intCodigoFase == 34) {
							OperacionalDAO operacaoDAO = new OperacionalDAO();
							operacaoDLista = operacaoDAO.selOperacaoListaByTabela("GRUPOS", "GRUPO");
							this.tpEtapaTorneio = TipoEtapaTorneio.FASE_GRUPO_COPA;
						}
						else {
							OperacionalDAO operacaoDAO = new OperacionalDAO();
							operacaoDLista = operacaoDAO.selOperacaoListaByTabela("TURNOS", "TURNO");
							this.tpEtapaTorneio = TipoEtapaTorneio.FASE_TURNO_COPA;
						}
					}
					
					for (int idx=0; idx<operacaoDLista.count(); idx++) {
						intCodigoTurno = Integer.parseInt(((Operacional) operacaoDLista.get(idx)).getCodigo());
						strCodigoTurno = DF3.format(intCodigoTurno);
						intCodigoGrupo = Integer.parseInt(((Operacional) operacaoDLista.get(idx)).getCodigo());
						strCodigoGrupo = DF3.format(intCodigoGrupo);
						strCodigoAgrup = strCodigoFase + ((this.tpEtapaTorneio == TipoEtapaTorneio.FASE_GRUPO_COPA)? strCodigoGrupo : strCodigoTurno);
						pnlJogosAlterAux = new JPanelJogosAlter(this.tpEquipe, this.tpEtapaTorneio, this.temp.getCodigoPaisCampeonato(), this.temp.getCodigoCampeonato(), this.temp.getAnoInicioTemporada(), this.temp.getAnoFimTemporada(), strCodigoAgrup);
						if ((pnlJogosAlterAux.getJogoDLista() != null) && (pnlJogosAlterAux.getJogoDLista().count() > 0)) {
							this.tpEtapaTorneio = TipoEtapaTorneio.FASE_COPA;
							break;
						}
					}
					
				}
				
			}
			
			if (this.tpEtapaTorneio == TipoEtapaTorneio.RODADA_LIGA) {
			
				intCodigoRodada = intCodigoRodada + intJogos01;
				strCodigoRodada = DF3.format(intCodigoRodada);
				pnlJogosAlterAux = new JPanelJogosAlter(this.tpEquipe, this.tpEtapaTorneio, this.temp.getCodigoPaisCampeonato(), this.temp.getCodigoCampeonato(), this.temp.getAnoInicioTemporada(), this.temp.getAnoFimTemporada(), strCodigoRodada);
				
			}
			
			if ((pnlJogosAlterAux != null) && (pnlJogosAlterAux.getJogoDLista() != null) && (pnlJogosAlterAux.getJogoDLista().count() > 0)) {
		
				this.jogoDLista = pnlJogosAlterAux.getJogoDLista();
				this.pnlJogosAlter = pnlJogosAlterAux;
				
				if (this.tpEtapaTorneio == TipoEtapaTorneio.FASE_COPA) {
					
					this.pnlJogosAlter.carregaSubComponent();
					this.pnlJogosAlter.setBounds(10,55,this.pnlJogosAlter.getWidth(),this.pnlJogosAlter.getHeight());
					this.add(this.pnlJogosAlter);
					
					this.lblCabecJogos02.setVisible(true);
					this.lblCabecJogos02Aux.setVisible(true);
					
					this.btnCabecJogos02Ant.setVisible(true);
					this.btnCabecJogos02Pos.setVisible(true);
					
					this.lblCabecJogos01.setText((this.tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(0)).getDescFaseJogo().trim() : ((VJogoT) this.jogoDLista.get(0)).getDescFaseJogo().trim());
					if (intCodigoFase == 34)
						this.lblCabecJogos02.setText((this.tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(0)).getDescGrupoJogo().trim() : ((VJogoT) this.jogoDLista.get(0)).getDescGrupoJogo().trim());
					else
						this.lblCabecJogos02.setText((this.tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(0)).getDescTurnoJogo().trim() : ((VJogoT) this.jogoDLista.get(0)).getDescTurnoJogo().trim());
						
				}
				
				if (this.tpEtapaTorneio == TipoEtapaTorneio.RODADA_LIGA) {
			
					this.pnlJogosAlter.carregaSubComponent();
					this.pnlJogosAlter.setBounds(10,25,this.pnlJogosAlter.getWidth(),this.pnlJogosAlter.getHeight());
					this.add(this.pnlJogosAlter);
					
					this.lblCabecJogos02.setVisible(false);
					this.lblCabecJogos02Aux.setVisible(false);
					
					this.btnCabecJogos02Ant.setVisible(false);
					this.btnCabecJogos02Pos.setVisible(false);
					
					this.lblCabecJogos01.setText((this.tpEquipe == TipoEquipe.SELECAO)? ((VJogoP) this.jogoDLista.get(0)).getDescRodadaJogo().trim() : ((VJogoT) this.jogoDLista.get(0)).getDescRodadaJogo().trim());
					
				}
				
			}
			
			else {
			
				this.add(this.pnlJogosAlter);
				
			}
			
		}	
		
		this.repaint();
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//********************************************************************************************************************************************
	public void actionPerformed(ActionEvent ae) {
	
		if (ae.getSource() == this.btnCabecJogos01Ant) {
		
			this.atualizaTelaTempCamp(ANT, ATU);
			
		}
		
		if (ae.getSource() == this.btnCabecJogos01Pos) {
		
			this.atualizaTelaTempCamp(POS, ATU);
			
		}
		
		if (ae.getSource() == this.btnCabecJogos02Ant) {
		
			this.atualizaTelaTempCamp(ATU, ANT);
			
		}
		
		if (ae.getSource() == this.btnCabecJogos02Pos) {
		
			this.atualizaTelaTempCamp(ATU, POS);
			
		}
		
		return;
		
	}
	//********************************************************************************************************************************************
	
}


