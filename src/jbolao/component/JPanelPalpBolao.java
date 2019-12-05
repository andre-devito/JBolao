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
import jbolao.entity.VMesaBolao;
import jbolao.entity.VPalpiteP;
import jbolao.entity.VPalpiteT;
import jbolao.entity.Operacional;
import jbolao.dao.OperacionalDAO;
import jbolao.component.subcomponent.JPanelPalpites;

public class JPanelPalpBolao extends JPanel
						implements ActionListener {
							
	//*** Componentes ****************************************************************************************************************************
	//Componentes
	private JLabel lblCabecPalpites01, lblCabecPalpites01Aux, lblCabecPalpites02, lblCabecPalpites02Aux;
	
	private JButton btnCabecPalpites01Ant, btnCabecPalpites01Pos, btnCabecPalpites02Ant, btnCabecPalpites02Pos;
	
	private JPanelPalpites pnlPalpites;
	
	//Constantes Globais
	private final int ANT = -1;
	private final int ATU = 0;
	private final int POS = 1;
	
	//Variaveis Globais
	private TipoEquipe tpEquipe;
	private TipoEtapaTorneio tpEtapaTorneio;
	private int width = 500;
	private int height = 600;	
	private VMesaBolao mesa = null;
	private String codigoOutroUsuario = null;
	private DLista palpiteDLista = null;
	//********************************************************************************************************************************************

	//*** Construtores ***************************************************************************************************************************
	public JPanelPalpBolao() {
	
		this(null, null);
		
	}
	
	public JPanelPalpBolao(VMesaBolao mesa, String codigoOutroUsuario) {
		
		this.setLayout(null);
		this.setBackground(new Color(255,255,255));
		
		this.mesa = mesa;
		this.codigoOutroUsuario = codigoOutroUsuario;
		
		this.lblCabecPalpites01Aux = new JLabel();
		this.lblCabecPalpites01Aux.setBounds(10,5,480,20);
		this.lblCabecPalpites01Aux.setOpaque(true);
		this.lblCabecPalpites01Aux.setBackground(new Color(225,225,225));
		
		this.lblCabecPalpites01 = new JLabel();
		this.lblCabecPalpites01.setBounds(70,5,360,20);
		this.lblCabecPalpites01.setHorizontalAlignment(JLabel.LEFT);
		this.lblCabecPalpites01.setOpaque(true);
		this.lblCabecPalpites01.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblCabecPalpites01.setForeground(new Color(0, 0, 0));
		this.lblCabecPalpites01.setBackground(new Color(225,225,225));
		
		this.lblCabecPalpites02Aux = new JLabel();
		this.lblCabecPalpites02Aux.setBounds(10,35,480,20);
		this.lblCabecPalpites02Aux.setOpaque(true);
		this.lblCabecPalpites02Aux.setBackground(new Color(225,225,225));
		
		this.lblCabecPalpites02 = new JLabel();
		this.lblCabecPalpites02.setBounds(70,35,360,20);
		this.lblCabecPalpites02.setHorizontalAlignment(JLabel.LEFT);
		this.lblCabecPalpites02.setOpaque(true);
		this.lblCabecPalpites02.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblCabecPalpites02.setForeground(new Color(0, 0, 0));
		this.lblCabecPalpites02.setBackground(new Color(225,225,225));
		
		this.btnCabecPalpites01Ant = new JButton("<<");
		this.btnCabecPalpites01Ant.setBounds(10,5,50,20);
		this.btnCabecPalpites01Ant.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnCabecPalpites01Ant.setForeground(new Color(0, 0, 0));
		this.btnCabecPalpites01Ant.setBackground(new Color(225,225,225));
		
		this.btnCabecPalpites01Pos = new JButton(">>");
		this.btnCabecPalpites01Pos.setBounds(440,5,50,20);
		this.btnCabecPalpites01Pos.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnCabecPalpites01Pos.setForeground(new Color(0, 0, 0));
		this.btnCabecPalpites01Pos.setBackground(new Color(225,225,225));
		
		this.btnCabecPalpites02Ant = new JButton("<<");
		this.btnCabecPalpites02Ant.setBounds(10,35,50,20);
		this.btnCabecPalpites02Ant.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnCabecPalpites02Ant.setForeground(new Color(0, 0, 0));
		this.btnCabecPalpites02Ant.setBackground(new Color(225,225,225));
		
		this.btnCabecPalpites02Pos = new JButton(">>");
		this.btnCabecPalpites02Pos.setBounds(440,35,50,20);
		this.btnCabecPalpites02Pos.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnCabecPalpites02Pos.setForeground(new Color(0, 0, 0));
		this.btnCabecPalpites02Pos.setBackground(new Color(225,225,225));
		
		this.add(this.btnCabecPalpites01Ant);
		this.add(this.btnCabecPalpites01Pos);
		this.add(this.lblCabecPalpites01);
		this.add(this.lblCabecPalpites01Aux);
		this.add(this.btnCabecPalpites02Ant);
		this.add(this.btnCabecPalpites02Pos);
		this.add(this.lblCabecPalpites02);
		this.add(this.lblCabecPalpites02Aux);
		
		this.btnCabecPalpites01Ant.addActionListener(this);
		this.btnCabecPalpites01Pos.addActionListener(this);
		this.btnCabecPalpites02Ant.addActionListener(this);
		this.btnCabecPalpites02Pos.addActionListener(this);
		
	}
	//********************************************************************************************************************************************
	
	//*** Getters e Setters **********************************************************************************************************************		
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public VMesaBolao getMesaBolao() {
		return this.mesa;
	}
	
	public String getOutroUsuario() {
		return this.codigoOutroUsuario;
	}
	
	public DLista getPalpiteDLista() {
		return this.palpiteDLista;
	}
	
	public void setMesaBolao(VMesaBolao mesa) {
		this.mesa = mesa;
	}
	
	public void setOutroUsuario(String codigoOutroUsuario) {
		this.codigoOutroUsuario = codigoOutroUsuario;
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Tela PalpBolao ****************************************************************************************************************
	public void carregaTelaPalpBolao() {
	
		if (this.pnlPalpites != null)
			this.remove(this.pnlPalpites);
			
		this.palpiteDLista = null;
		
		int intCodigoPaisCampeonato = Integer.parseInt(this.mesa.getCodigoPaisCampeonato());
		int intCodigoCampeonato = Integer.parseInt(this.mesa.getCodigoCampeonato());
		
		if ((intCodigoCampeonato >= 901) && (intCodigoCampeonato <= 999))
			this.tpEquipe = TipoEquipe.SELECAO;
		else
			this.tpEquipe = TipoEquipe.CLUBE;
			
		if ((intCodigoCampeonato >= 1) && (intCodigoCampeonato <= 100))
			this.tpEtapaTorneio = TipoEtapaTorneio.RODADA_LIGA;
		else
			this.tpEtapaTorneio = TipoEtapaTorneio.FASE_COPA;
			
		JPanelPalpites pnlPalpitesAux = new JPanelPalpites(this.tpEquipe, this.tpEtapaTorneio, this.mesa.getCodigoUsuario(), this.codigoOutroUsuario, this.mesa.getNomeMesa(), this.mesa.getCodigoPaisCampeonato(), this.mesa.getCodigoCampeonato(), this.mesa.getAnoInicioTemporada(), this.mesa.getAnoFimTemporada(), null);
		
		if ((pnlPalpitesAux.getPalpiteDLista() != null) && (pnlPalpitesAux.getPalpiteDLista().count() > 0)) {
		
			this.palpiteDLista = pnlPalpitesAux.getPalpiteDLista();
			
			int intCodigoFase = Integer.parseInt((this.tpEquipe == TipoEquipe.SELECAO)? ((VPalpiteP) this.palpiteDLista.get(0)).getCodigoFaseJogo() : ((VPalpiteT) this.palpiteDLista.get(0)).getCodigoFaseJogo());
		
			if (this.tpEtapaTorneio == TipoEtapaTorneio.FASE_COPA) {
				
				this.pnlPalpites = new JPanelPalpites(this.tpEquipe, this.tpEtapaTorneio, this.mesa.getCodigoUsuario(), this.codigoOutroUsuario, this.mesa.getNomeMesa(), this.mesa.getCodigoPaisCampeonato(), this.mesa.getCodigoCampeonato(), this.mesa.getAnoInicioTemporada(), this.mesa.getAnoFimTemporada(), null);
				this.pnlPalpites.carregaSubComponent();
				this.pnlPalpites.setBounds(10,55,this.pnlPalpites.getWidth(),this.pnlPalpites.getHeight());
				this.add(this.pnlPalpites);
				
				this.lblCabecPalpites02.setVisible(true);
				this.lblCabecPalpites02Aux.setVisible(true);
				
				this.btnCabecPalpites02Ant.setVisible(true);
				this.btnCabecPalpites02Pos.setVisible(true);
				
				this.lblCabecPalpites01.setText((this.tpEquipe == TipoEquipe.SELECAO)? ((VPalpiteP) this.palpiteDLista.get(0)).getDescFaseJogo().trim() : ((VPalpiteT) this.palpiteDLista.get(0)).getDescFaseJogo().trim());
				if (intCodigoFase == 34)
					this.lblCabecPalpites02.setText((this.tpEquipe == TipoEquipe.SELECAO)? ((VPalpiteP) this.palpiteDLista.get(0)).getDescGrupoJogo().trim() : ((VPalpiteT) this.palpiteDLista.get(0)).getDescGrupoJogo().trim());
				else
					this.lblCabecPalpites02.setText((this.tpEquipe == TipoEquipe.SELECAO)? ((VPalpiteP) this.palpiteDLista.get(0)).getDescTurnoJogo().trim() : ((VPalpiteT) this.palpiteDLista.get(0)).getDescTurnoJogo().trim());
					
			}
			
			if (this.tpEtapaTorneio == TipoEtapaTorneio.RODADA_LIGA) {
		
				this.pnlPalpites = new JPanelPalpites(this.tpEquipe, this.tpEtapaTorneio, this.mesa.getCodigoUsuario(), this.codigoOutroUsuario, this.mesa.getNomeMesa(), this.mesa.getCodigoPaisCampeonato(), this.mesa.getCodigoCampeonato(), this.mesa.getAnoInicioTemporada(), this.mesa.getAnoFimTemporada(), null);
				this.pnlPalpites.carregaSubComponent();
				this.pnlPalpites.setBounds(10,25,this.pnlPalpites.getWidth(),this.pnlPalpites.getHeight());
				this.add(this.pnlPalpites);
				
				this.lblCabecPalpites02.setVisible(false);
				this.lblCabecPalpites02Aux.setVisible(false);
				
				this.btnCabecPalpites02Ant.setVisible(false);
				this.btnCabecPalpites02Pos.setVisible(false);
				
				this.lblCabecPalpites01.setText((this.tpEquipe == TipoEquipe.SELECAO)? ((VPalpiteP) this.palpiteDLista.get(0)).getDescRodadaJogo().trim() : ((VPalpiteT) this.palpiteDLista.get(0)).getDescRodadaJogo().trim());
				
			}
			
		}
		
		else {
		
			if (this.tpEtapaTorneio == TipoEtapaTorneio.FASE_COPA) {
				
				this.lblCabecPalpites02.setVisible(true);
				this.lblCabecPalpites02Aux.setVisible(true);
				
				this.btnCabecPalpites02Ant.setVisible(true);
				this.btnCabecPalpites02Pos.setVisible(true);
				
				this.lblCabecPalpites01.setText("SEM INFORMAÇÃO DISPONÍVEL");
				this.lblCabecPalpites02.setText("SEM INFORMAÇÃO DISPONÍVEL");
						
			}
			
			if (this.tpEtapaTorneio == TipoEtapaTorneio.RODADA_LIGA) {
				
				this.lblCabecPalpites02.setVisible(false);
				this.lblCabecPalpites02Aux.setVisible(false);
				
				this.btnCabecPalpites02Ant.setVisible(false);
				this.btnCabecPalpites02Pos.setVisible(false);
				
				this.lblCabecPalpites01.setText("SEM INFORMAÇÃO DISPONÍVEL");
			
			}
			
		}
		
		this.repaint();
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Atualizar Tela PalpBolao ***************************************************************************************************************
	private void atualizaTelaPalpBolao(int intJogos01, int intJogos02) {
	
		if (this.pnlPalpites != null)
			this.remove(this.pnlPalpites);
			
		if ((this.palpiteDLista != null) && (this.palpiteDLista.count() > 0)) {
		
			JPanelPalpites pnlPalpitesAux = null;
		
			int intCodigoFase = Integer.parseInt((this.tpEquipe == TipoEquipe.SELECAO)? ((VPalpiteP) this.palpiteDLista.get(0)).getCodigoFaseJogo() : ((VPalpiteT) this.palpiteDLista.get(0)).getCodigoFaseJogo());	
			int intCodigoRodada = Integer.parseInt((this.tpEquipe == TipoEquipe.SELECAO)? ((VPalpiteP) this.palpiteDLista.get(0)).getCodigoRodadaJogo() : ((VPalpiteT) this.palpiteDLista.get(0)).getCodigoRodadaJogo());
			int intCodigoTurno = Integer.parseInt((this.tpEquipe == TipoEquipe.SELECAO)? ((VPalpiteP) this.palpiteDLista.get(0)).getCodigoTurnoJogo() : ((VPalpiteT) this.palpiteDLista.get(0)).getCodigoTurnoJogo());	
			int intCodigoGrupo = Integer.parseInt((this.tpEquipe == TipoEquipe.SELECAO)? ((VPalpiteP) this.palpiteDLista.get(0)).getCodigoGrupoJogo() : ((VPalpiteT) this.palpiteDLista.get(0)).getCodigoGrupoJogo());
			
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
					pnlPalpitesAux = new JPanelPalpites(this.tpEquipe, this.tpEtapaTorneio, this.mesa.getCodigoUsuario(), this.codigoOutroUsuario, this.mesa.getNomeMesa(), this.mesa.getCodigoPaisCampeonato(), this.mesa.getCodigoCampeonato(), this.mesa.getAnoInicioTemporada(), this.mesa.getAnoFimTemporada(), strCodigoAgrup);
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
						pnlPalpitesAux = new JPanelPalpites(this.tpEquipe, this.tpEtapaTorneio, this.mesa.getCodigoUsuario(), this.codigoOutroUsuario, this.mesa.getNomeMesa(), this.mesa.getCodigoPaisCampeonato(), this.mesa.getCodigoCampeonato(), this.mesa.getAnoInicioTemporada(), this.mesa.getAnoFimTemporada(), strCodigoFase);
						if ((pnlPalpitesAux.getPalpiteDLista() != null) && (pnlPalpitesAux.getPalpiteDLista().count() > 0)) {
							intCodigoFase = intCodigoFaseTentv[idx];
							strCodigoFase = DF3.format(intCodigoFase);
							break;
						}
					}
					
					DLista operacaoDLista = new DLista();
					
					if ((pnlPalpitesAux != null) && (pnlPalpitesAux.getPalpiteDLista() != null) && (pnlPalpitesAux.getPalpiteDLista().count() > 0)) {
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
						pnlPalpitesAux = new JPanelPalpites(this.tpEquipe, this.tpEtapaTorneio, this.mesa.getCodigoUsuario(), this.codigoOutroUsuario, this.mesa.getNomeMesa(), this.mesa.getCodigoPaisCampeonato(), this.mesa.getCodigoCampeonato(), this.mesa.getAnoInicioTemporada(), this.mesa.getAnoFimTemporada(), strCodigoAgrup);
						if ((pnlPalpitesAux.getPalpiteDLista() != null) && (pnlPalpitesAux.getPalpiteDLista().count() > 0)) {
							this.tpEtapaTorneio = TipoEtapaTorneio.FASE_COPA;
							break;
						}
					}
					
				}
				
			}
			
			if (this.tpEtapaTorneio == TipoEtapaTorneio.RODADA_LIGA) {
			
				intCodigoRodada = intCodigoRodada + intJogos01;
				strCodigoRodada = DF3.format(intCodigoRodada);
				pnlPalpitesAux = new JPanelPalpites(this.tpEquipe, this.tpEtapaTorneio, this.mesa.getCodigoUsuario(), this.codigoOutroUsuario, this.mesa.getNomeMesa(), this.mesa.getCodigoPaisCampeonato(), this.mesa.getCodigoCampeonato(), this.mesa.getAnoInicioTemporada(), this.mesa.getAnoFimTemporada(), strCodigoRodada);
				
			}
			
			if ((pnlPalpitesAux != null) && (pnlPalpitesAux.getPalpiteDLista() != null) && (pnlPalpitesAux.getPalpiteDLista().count() > 0)) {
		
				this.palpiteDLista = pnlPalpitesAux.getPalpiteDLista();
				this.pnlPalpites = pnlPalpitesAux;
				
				if (this.tpEtapaTorneio == TipoEtapaTorneio.FASE_COPA) {
					
					this.pnlPalpites.carregaSubComponent();
					this.pnlPalpites.setBounds(10,55,this.pnlPalpites.getWidth(),this.pnlPalpites.getHeight());
					this.add(this.pnlPalpites);
					
					this.lblCabecPalpites02.setVisible(true);
					this.lblCabecPalpites02Aux.setVisible(true);
					
					this.btnCabecPalpites02Ant.setVisible(true);
					this.btnCabecPalpites02Pos.setVisible(true);
					
					this.lblCabecPalpites01.setText((this.tpEquipe == TipoEquipe.SELECAO)? ((VPalpiteP) this.palpiteDLista.get(0)).getDescFaseJogo().trim() : ((VPalpiteT) this.palpiteDLista.get(0)).getDescFaseJogo().trim());
					if (intCodigoFase == 34)
						this.lblCabecPalpites02.setText((this.tpEquipe == TipoEquipe.SELECAO)? ((VPalpiteP) this.palpiteDLista.get(0)).getDescGrupoJogo().trim() : ((VPalpiteT) this.palpiteDLista.get(0)).getDescGrupoJogo().trim());
					else
						this.lblCabecPalpites02.setText((this.tpEquipe == TipoEquipe.SELECAO)? ((VPalpiteP) this.palpiteDLista.get(0)).getDescTurnoJogo().trim() : ((VPalpiteT) this.palpiteDLista.get(0)).getDescTurnoJogo().trim());
						
				}
				
				if (this.tpEtapaTorneio == TipoEtapaTorneio.RODADA_LIGA) {
			
					this.pnlPalpites.carregaSubComponent();
					this.pnlPalpites.setBounds(10,25,this.pnlPalpites.getWidth(),this.pnlPalpites.getHeight());
					this.add(this.pnlPalpites);
					
					this.lblCabecPalpites02.setVisible(false);
					this.lblCabecPalpites02Aux.setVisible(false);
					
					this.btnCabecPalpites02Ant.setVisible(false);
					this.btnCabecPalpites02Pos.setVisible(false);
					
					this.lblCabecPalpites01.setText((this.tpEquipe == TipoEquipe.SELECAO)? ((VPalpiteP) this.palpiteDLista.get(0)).getDescRodadaJogo().trim() : ((VPalpiteT) this.palpiteDLista.get(0)).getDescRodadaJogo().trim());
					
				}
				
			}
			
			else {
			
				this.add(this.pnlPalpites);
				
			}
			
		}	
		
		this.repaint();
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//********************************************************************************************************************************************
	public void actionPerformed(ActionEvent ae) {
	
		if (ae.getSource() == this.btnCabecPalpites01Ant) {
		
			this.atualizaTelaPalpBolao(ANT, ATU);
			
		}
		
		if (ae.getSource() == this.btnCabecPalpites01Pos) {
		
			this.atualizaTelaPalpBolao(POS, ATU);
			
		}
		
		if (ae.getSource() == this.btnCabecPalpites02Ant) {
		
			this.atualizaTelaPalpBolao(ATU, ANT);
			
		}
		
		if (ae.getSource() == this.btnCabecPalpites02Pos) {
		
			this.atualizaTelaPalpBolao(ATU, POS);
			
		}
		
		return;
		
	}
	//********************************************************************************************************************************************
	
}


