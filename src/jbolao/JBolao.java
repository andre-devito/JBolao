package jbolao;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.Box;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import devito.dados.estruturas.DLista;
import jbolao.error.Error;
import jbolao.type.*;
import jbolao.entity.*;
import jbolao.dao.*;
import jbolao.component.*;
import jbolao.component.subcomponent.*;

public class JBolao extends JFrame
					implements ActionListener, ItemListener, WindowListener {

	//*** Componentes ****************************************************************************************************************************
	//Componentes Menu
	private JMenuBar menubarPrincipal;
	
	private JMenu menuArquivo, menuOpcoes;
	
	private JMenuItem menuitemNovo, menuitemSair;
	private JCheckBoxMenuItem checkitemConectar, checkitemAdministrarTorneios;
	
	//Componentes TabbedPane
	private JTabbedPane tbpJBolao;
	
	//Componentes de tbpJBolao - Tab Login
	private JPanel pnlLogin;
	
	private JLabel lblJBolao;
	
	private JLabel lblNick, lblPass, lblErroLogin;
	
	private JPasswordField txtPass;
	
	private JFormattedTextField txtNick;
	
	private MaskFormatter mskfmtNick;
	private MaskFormatter mskfmtPass;
	
	private JButton btnLogin;
	
	//Componenetes de tbpJBolao - Tab Usuario
	private JPanel pnlUsuario;
	
	private JLabel lblUsuario;
	
	private JPanel pnlSelecoes, pnlClubes, pnlUsuarioMain;
	
	private JLabel lblCompeticoes, lblCompeticoesOwner, lblProcurarAdversario, lblErroAdversario, lblConvites;
	
	private JTextField txtProcurarAdversario;
	
	private JComboBox cboCompeticoes, cboCompeticoesOwner, cboAdversarios, cboConvites;
	
	private JButton btnMesaBolao, btnAbandonarBolao, btnProcurarAdversario, btnConvidarAdversario, btnAceitar, btnRecusar;
	
	private JLabel lblSelecoes, lblTorneioSelec;
	
	private JComboBox cboTorneioSelec;
	
	private JButton btnTorneioSelec;
	
	private JLabel lblClubes, lblTorneioNac, lblTorneioInter;
	
	private JComboBox cboTorneioNac, cboTorneioInter;
	
	private JButton btnTorneioClube;
	
	//Componenetes de tbpJBolao - Tab Camp
	private JPanel pnlCamp;
	
	private JLabel lblCampeonato;
	
	private JPanel pnlTempCampMenu, pnlEstatCampMenu, pnlHistCampMenu;
	
	private JPanelTempCamp pnlTempCampMain;
	private JPanelTempCampAlter pnlTempCampAlterMain;
	
	private JPanelEstatCamp pnlEstatCampMain;
	
	private JPanelHistCamp pnlHistCampMain;
	
	private JLabel lblTemp, lblOutrasTemp, lblEstat, lblOpcoes, lblHist, lblListaVenc, lblResumoVenc;
	
	private JComboBox cboOutrasTemp, cboOpcoesTipo, cboOpcoesOperacional;
	
	private JButton btnOutrasTemp, btnListaVenc, btnResumoVenc, btnEstat;
	
	//Componenetes de tbpJBolao - Tab Bolao
	private JPanel pnlBolao;
	
	private JLabel lblMesaBolao;
	
	private JPanel pnlPalpBolaoMenu, pnlClassBolaoMenu;
	
	private JPanelPalpBolao pnlPalpBolaoMain;
	
	private JPanelClassBolao pnlClassBolaoMain;
	
	private JLabel lblPalp, lblOutrasMesas, lblOutrosUsuarios, lblClass, lblClassBolao;
	
	private JComboBox cboOutrasMesas, cboOutrosUsuarios;
	
	private JButton btnOutrasMesas, btnOutrosUsuarios, btnClassBolao;
	
	//Componentes de tbpJBolao - Tab Login e Tab Usuario e Tab Camp e Tab Bolao
	private JButton btnVoltar[] = new JButton[4];
	private JButton btnAvancar[] = new JButton[4];
	
	//Constante Globais
	private static final long serialVersionUID = 1L;
	
	private final int QTD_TELAS = 4;
	private final int TELA_CADASTRO = -1;
	private final int TELA_LOGIN = 0;
	private final int TELA_USUARIO = 1;
	private final int TELA_CAMP = 2;
	private final int TELA_BOLAO = 3;
	
	private final int TELA_TEMP_CAMP_MAIN = 0;
	private final int TELA_TEMP_CAMP_ALTER_MAIN = 1;
	private final int TELA_ESTAT_CAMP_MAIN = 2;
	private final int TELA_HIST_CAMP_MAIN = 3;
	private final int TELA_PALP_BOLAO_MAIN = 0;
	private final int TELA_CLASS_BOLAO_MAIN = 1;
	
	private final String NUMERICOS = "1234567890";
	private final String ALFABETICOS_MINUSCULOS = "abcdefghijklmnopqrstuvxywz";
	private final String ALFABETICOS_MAIUSCULOS = "ABCDEFGHIJKLMNOPQRSTUVXYWZ";
	private final String ALFABETICOS = ALFABETICOS_MINUSCULOS + ALFABETICOS_MAIUSCULOS;
	private final String CARACTERES_ESPECIAIS_PERMITIDOS = "@-._";
	
	//Variaveis Globais
	private int intTela = TELA_LOGIN;
	private int intTelaAux = TELA_TEMP_CAMP_MAIN;
	
	private Usuario user = null;
	private VTemp temp = null;
	private VTemp tempAutoPostBack = null;
	private VMesaBolao mesa = null;
	private VMesaBolao mesaAutoPostBack = null;
	private DLista tempDListaSelec = null;
	private DLista tempDListaNac = null;
	private DLista tempDListaInter = null;
	private DLista outrastempDLista = null;
	private DLista jogostipoDLista = null;
	private DLista jogosoperacionalDLista = null;
	private DLista mesaDListaCompeticoes = null;
	private DLista mesaDListaCompeticoesOwner = null;
	private DLista mesaDListaConvites = null;
	private DLista userDListaAdversarios = null;
	private DLista outrasmesasDLista = null;
	private DLista outrosusuariosDLista = null;
	
	private boolean haMesa = false;
	private boolean haMesaCompet = false;
	private boolean haMesaCompetOwner = false;
	private boolean haMesaConvit = false;
	private boolean haBusca = false;
	private boolean haBuscaSelec = false;
	private boolean haTorneio = false;
	private boolean haTorneioSelec = false;
	private boolean haTorneioNac = false;
	private boolean haTorneioInter = false;
	
	private int intConf[] = {0, 0, 805, 715};
	private String strConf[] = {"UserPositionX=", "UserPositionY=", "UserWidth=", "UserHeight="};
	
	private int portaConexao = 4000;
	private String hostConexao = "omega";
	private static String nomeAplicacao = "JBolao";
	//********************************************************************************************************************************************
	
	//*** Construtor *****************************************************************************************************************************
	public JBolao(String host) {
	
		this.hostConexao = host;
		
		//Instanciar os Componentes
		this.setTitle(nomeAplicacao);
		this.setResizable(false);
		
		this.menubarPrincipal = new JMenuBar();
		
		this.menuArquivo = new JMenu("Arquivo");
		this.menuArquivo.setFont(new Font("Verdana", Font.PLAIN, 10));
		this.menuArquivo.setForeground(new Color(0, 0, 0));
		
		this.menuOpcoes = new JMenu("Opções");
		this.menuOpcoes.setFont(new Font("Verdana", Font.PLAIN, 10));
		this.menuOpcoes.setForeground(new Color(0, 0, 0));
		
		this.menuitemNovo = new JMenuItem("Novo");
		this.menuitemNovo.setFont(new Font("Verdana", Font.PLAIN, 10));
		this.menuitemNovo.setForeground(new Color(0, 0, 0));
		
		this.menuitemSair = new JMenuItem("Sair");
		this.menuitemSair.setFont(new Font("Verdana", Font.PLAIN, 10));
		this.menuitemSair.setForeground(new Color(0, 0, 0));
		
		this.checkitemConectar = new JCheckBoxMenuItem("Conectar");
		this.checkitemConectar.setFont(new Font("Verdana", Font.PLAIN, 10));
		this.checkitemConectar.setForeground(new Color(0, 0, 0));
		
		this.checkitemAdministrarTorneios = new JCheckBoxMenuItem("Administrar Torneios");
		this.checkitemAdministrarTorneios.setFont(new Font("Verdana", Font.PLAIN, 10));
		this.checkitemAdministrarTorneios.setForeground(new Color(0, 0, 0));
		
		this.tbpJBolao = new JTabbedPane();
		this.tbpJBolao.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.tbpJBolao.setForeground(new Color(0, 0, 0));
		
		this.pnlLogin = new JPanel();
		this.pnlLogin.setLayout(null);
		this.pnlLogin.setBounds(0,0,800,650);
		this.pnlLogin.setBackground(new Color(0,0,0));
		
		this.pnlUsuario = new JPanel();
		this.pnlUsuario.setLayout(null);
		this.pnlUsuario.setBounds(0,0,800,650);
		this.pnlUsuario.setBackground(new Color(0,0,0));
		
		this.pnlCamp = new JPanel();
		this.pnlCamp.setLayout(null);
		this.pnlCamp.setBounds(0,0,800,650);
		this.pnlCamp.setBackground(new Color(0,0,0));
		
		this.pnlBolao = new JPanel();
		this.pnlBolao.setLayout(null);
		this.pnlBolao.setBounds(0,0,800,650);
		this.pnlBolao.setBackground(new Color(0,0,0));
		
		try {
		
			this.mskfmtNick = new MaskFormatter("AAAAAAAAAAAA");
			this.mskfmtPass = new MaskFormatter("AA/AA/AAAA");
			
		}
		
		catch (Exception e) {
		
			e.printStackTrace();
			
		}
		
		this.mskfmtNick.setValidCharacters(ALFABETICOS_MAIUSCULOS);
		this.mskfmtPass.setValidCharacters(NUMERICOS);
		
		this.lblJBolao = new JLabel(new ImageIcon("img/Torres.png"));
		this.lblJBolao.setBounds(310,45,480,550);
		this.lblJBolao.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblJBolao.setForeground(new Color(0, 0, 0));
		
		this.lblNick = new JLabel();
		this.lblNick.setBounds(0,45,80,20);
		this.lblNick.setHorizontalAlignment(JLabel.RIGHT);
		this.lblNick.setText("APELIDO: ");
		this.lblNick.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblNick.setForeground(new Color(185,205,255));
		
		this.lblPass = new JLabel();
		this.lblPass.setBounds(0,75,80,20);
		this.lblPass.setHorizontalAlignment(JLabel.RIGHT);
		this.lblPass.setText("SENHA: ");
		this.lblPass.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblPass.setForeground(new Color(185,205,255));
		
		this.lblErroLogin = new JLabel();
		this.lblErroLogin.setBounds(0,105,300,20);
		this.lblErroLogin.setHorizontalAlignment(JLabel.CENTER);
		this.lblErroLogin.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblErroLogin.setForeground(new Color(185,205,255));
		this.lblErroLogin.setVisible(false);
		
		this.txtNick = new JFormattedTextField(mskfmtNick);
		this.txtNick.setBounds(90,45,120,20);
		this.txtNick.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.txtNick.setForeground(new Color(0, 0, 0));
		this.txtNick.setBackground(new Color(225,225,225));
		this.txtNick.setFocusLostBehavior(JFormattedTextField.COMMIT);
		
		this.txtPass = new JPasswordField();
		this.txtPass.setBounds(90,75,120,20);
		this.txtPass.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.txtPass.setForeground(new Color(0, 0, 0));
		this.txtPass.setBackground(new Color(225,225,225));
		
		//this.txtNick.setColumns(6);
		//this.txtPass.setColumns(6);
		
		this.btnLogin = new JButton(">>");
		this.btnLogin.setBounds(220,45,50,50);
		this.btnLogin.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnLogin.setForeground(new Color(0, 0, 0));
		this.btnLogin.setBackground(new Color(225,225,225));
		
		this.lblUsuario = new JLabel();
		this.lblUsuario.setBounds(310,5,480,20);
		this.lblUsuario.setHorizontalAlignment(JLabel.CENTER);
		this.lblUsuario.setOpaque(true);
		this.lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblUsuario.setForeground(new Color(0, 0, 0));
		this.lblUsuario.setBackground(new Color(225,225,225));
		this.lblUsuario.setText("BENVINDO!");
		
		this.pnlUsuarioMain = new JPanel();
		this.pnlUsuarioMain.setLayout(null);
		this.pnlUsuarioMain.setBounds(300,30,500,600);
		this.pnlUsuarioMain.setBackground(new Color(255,255,255));
		
		this.lblCompeticoes = new JLabel();
		this.lblCompeticoes.setBounds(10,5,480,20);
		this.lblCompeticoes.setHorizontalAlignment(JLabel.CENTER);
		this.lblCompeticoes.setOpaque(true);
		this.lblCompeticoes.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblCompeticoes.setForeground(new Color(0, 0, 0));
		this.lblCompeticoes.setBackground(new Color(225,225,225));
		this.lblCompeticoes.setText("VOCÊ ESTÁ PARTICIPANDO DAS SEGUINTES MESAS DE BOLAO: ");
		
		this.cboCompeticoes = new JComboBox();
		this.cboCompeticoes.setMaximumRowCount(4);
		this.cboCompeticoes.setBounds(130,35,240,20);
		this.cboCompeticoes.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.cboCompeticoes.setForeground(new Color(0, 0, 0));
		this.cboCompeticoes.setBackground(new Color(225,225,225));
		
		this.btnMesaBolao = new JButton("SENTAR-SE À MESA");
		this.btnMesaBolao.setBounds(165,65,170,20);
		this.btnMesaBolao.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnMesaBolao.setForeground(new Color(0, 0, 0));
		this.btnMesaBolao.setBackground(new Color(225,225,225));
		
		this.btnAbandonarBolao = new JButton("ABANDONAR MESA");
		this.btnAbandonarBolao.setBounds(165,95,170,20);
		this.btnAbandonarBolao.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnAbandonarBolao.setForeground(new Color(0, 0, 0));
		this.btnAbandonarBolao.setBackground(new Color(225,225,225));
		
		this.lblCompeticoesOwner = new JLabel();
		this.lblCompeticoesOwner.setBounds(10,185,480,20);
		this.lblCompeticoesOwner.setHorizontalAlignment(JLabel.CENTER);
		this.lblCompeticoesOwner.setOpaque(true);
		this.lblCompeticoesOwner.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblCompeticoesOwner.setForeground(new Color(0, 0, 0));
		this.lblCompeticoesOwner.setBackground(new Color(225,225,225));
		this.lblCompeticoesOwner.setText("VOCÊ É OWNER DAS SEGUINTES MESAS DE BOLAO: ");
		
		this.cboCompeticoesOwner = new JComboBox();
		this.cboCompeticoesOwner.setMaximumRowCount(4);
		this.cboCompeticoesOwner.setBounds(130,215,240,20);
		this.cboCompeticoesOwner.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.cboCompeticoesOwner.setForeground(new Color(0, 0, 0));
		this.cboCompeticoesOwner.setBackground(new Color(225,225,225));
		
		this.lblProcurarAdversario = new JLabel();
		this.lblProcurarAdversario.setBounds(35,245,120,45);
		this.lblProcurarAdversario.setHorizontalAlignment(JLabel.CENTER);
		this.lblProcurarAdversario.setOpaque(true);
		this.lblProcurarAdversario.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblProcurarAdversario.setForeground(new Color(0, 0, 0));
		this.lblProcurarAdversario.setBackground(new Color(225,225,225));
		this.lblProcurarAdversario.setText("<HTML> <CENTER> BUSCA </CENTER> <CENTER> DE </CENTER> <CENTER> ADVERSÁRIOS </CENTER> </HTML>");
		
		this.txtProcurarAdversario = new JTextField();
		this.txtProcurarAdversario.setBounds(165,245,150,20);
		this.txtProcurarAdversario.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.txtProcurarAdversario.setForeground(new Color(0, 0, 0));
		this.txtProcurarAdversario.setBackground(new Color(225,225,225));
		
		this.btnProcurarAdversario = new JButton(new ImageIcon("img/lupa.png"));
		this.btnProcurarAdversario.setBounds(315,245,20,20);
		this.btnProcurarAdversario.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnProcurarAdversario.setForeground(new Color(0, 0, 0));
		this.btnProcurarAdversario.setBackground(new Color(225,225,225));
		
		this.cboAdversarios = new JComboBox();
		this.cboAdversarios.setMaximumRowCount(4);
		this.cboAdversarios.setBounds(165,270,170,20);
		this.cboAdversarios.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.cboAdversarios.setForeground(new Color(0, 0, 0));
		this.cboAdversarios.setBackground(new Color(225,225,225));
		
		this.btnConvidarAdversario = new JButton("CONVIDAR");
		this.btnConvidarAdversario.setBounds(345,245,120,45);
		this.btnConvidarAdversario.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnConvidarAdversario.setForeground(new Color(0, 0, 0));
		this.btnConvidarAdversario.setBackground(new Color(225,225,225));
		
		this.lblErroAdversario = new JLabel();
		this.lblErroAdversario.setBounds(10,300,480,20);
		this.lblErroAdversario.setHorizontalAlignment(JLabel.CENTER);
		this.lblErroAdversario.setFont(new Font("Verdana", Font.ITALIC, 9));
		this.lblErroAdversario.setForeground(new Color(0, 0, 0));
		this.lblErroAdversario.setBackground(new Color(255,255,255));
		
		this.lblConvites = new JLabel();
		this.lblConvites.setBounds(10,395,480,20);
		this.lblConvites.setHorizontalAlignment(JLabel.CENTER);
		this.lblConvites.setOpaque(true);
		this.lblConvites.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblConvites.setForeground(new Color(0, 0, 0));
		this.lblConvites.setBackground(new Color(225,225,225));
		this.lblConvites.setText("VOCÊ FOI CONVIDADO ÀS SEGUINTES MESAS DE BOLAO: ");
		
		this.cboConvites = new JComboBox();
		this.cboConvites.setMaximumRowCount(4);
		this.cboConvites.setBounds(130,425,240,20);
		this.cboConvites.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.cboConvites.setForeground(new Color(0, 0, 0));
		this.cboConvites.setBackground(new Color(225,225,225));
		
		this.btnAceitar = new JButton("ACEITAR");
		this.btnAceitar.setBounds(165,455,170,20);
		this.btnAceitar.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnAceitar.setForeground(new Color(0, 0, 0));
		this.btnAceitar.setBackground(new Color(225,225,225));
		
		this.btnRecusar = new JButton("RECUSAR");
		this.btnRecusar.setBounds(165,485,170,20);
		this.btnRecusar.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnRecusar.setForeground(new Color(0, 0, 0));
		this.btnRecusar.setBackground(new Color(225,225,225));
		
		this.pnlSelecoes = new JPanel();
		this.pnlSelecoes.setLayout(null);
		this.pnlSelecoes.setBounds(0,30,300,150);
		this.pnlSelecoes.setBackground(new Color(185,205,255));
		
		this.lblSelecoes = new JLabel();
		this.lblSelecoes.setBounds(5,5,240,20);
		this.lblSelecoes.setHorizontalAlignment(JLabel.LEFT);
		this.lblSelecoes.setOpaque(true);
		this.lblSelecoes.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblSelecoes.setForeground(new Color(0, 0, 0));
		this.lblSelecoes.setBackground(new Color(225,225,225));
		this.lblSelecoes.setText("::SELEÇÕES");
		
		this.lblTorneioSelec = new JLabel();
		this.lblTorneioSelec.setBounds(30,35,240,20);
		this.lblTorneioSelec.setHorizontalAlignment(JLabel.LEFT);
		this.lblTorneioSelec.setOpaque(true);
		this.lblTorneioSelec.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblTorneioSelec.setForeground(new Color(0, 0, 0));
		this.lblTorneioSelec.setBackground(new Color(225,225,225));
		this.lblTorneioSelec.setText("::TORNEIOS");
		
		this.cboTorneioSelec = new JComboBox();
		this.cboTorneioSelec.setMaximumRowCount(4);
		this.cboTorneioSelec.setBounds(55,65,240,20);
		this.cboTorneioSelec.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.cboTorneioSelec.setForeground(new Color(0, 0, 0));
		this.cboTorneioSelec.setBackground(new Color(225,225,225));
		
		this.btnTorneioSelec = new JButton(">>");
		this.btnTorneioSelec.setBounds(125,95,50,20);
		this.btnTorneioSelec.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnTorneioSelec.setForeground(new Color(0, 0, 0));
		this.btnTorneioSelec.setBackground(new Color(225,225,225));
		
		this.pnlClubes = new JPanel();
		this.pnlClubes.setLayout(null);
		this.pnlClubes.setBounds(0,180,300,450);
		this.pnlClubes.setBackground(new Color(185,205,255));
		
		this.lblClubes = new JLabel();
		this.lblClubes.setBounds(5,5,240,20);
		this.lblClubes.setHorizontalAlignment(JLabel.LEFT);
		this.lblClubes.setOpaque(true);
		this.lblClubes.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblClubes.setForeground(new Color(0, 0, 0));
		this.lblClubes.setBackground(new Color(225,225,225));
		this.lblClubes.setText("::CLUBES");
		
		this.lblTorneioNac = new JLabel();
		this.lblTorneioNac.setBounds(30,35,240,20);
		this.lblTorneioNac.setHorizontalAlignment(JLabel.LEFT);
		this.lblTorneioNac.setOpaque(true);
		this.lblTorneioNac.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblTorneioNac.setForeground(new Color(0, 0, 0));
		this.lblTorneioNac.setBackground(new Color(225,225,225));
		this.lblTorneioNac.setText("::TORNEIOS NACIONAIS");
		
		this.cboTorneioNac = new JComboBox();
		this.cboTorneioNac.setMaximumRowCount(4);
		this.cboTorneioNac.setBounds(55,65,240,20);
		this.cboTorneioNac.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.cboTorneioNac.setForeground(new Color(0, 0, 0));
		this.cboTorneioNac.setBackground(new Color(225,225,225));
		
		this.lblTorneioInter = new JLabel();
		this.lblTorneioInter.setBounds(30,95,240,20);
		this.lblTorneioInter.setHorizontalAlignment(JLabel.LEFT);
		this.lblTorneioInter.setOpaque(true);
		this.lblTorneioInter.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblTorneioInter.setForeground(new Color(0, 0, 0));
		this.lblTorneioInter.setBackground(new Color(225,225,225));
		this.lblTorneioInter.setText("::TORNEIOS INTERNACIONAIS");
		
		this.cboTorneioInter = new JComboBox();
		this.cboTorneioInter.setMaximumRowCount(4);
		this.cboTorneioInter.setBounds(55,125,240,20);
		this.cboTorneioInter.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.cboTorneioInter.setForeground(new Color(0, 0, 0));
		this.cboTorneioInter.setBackground(new Color(225,225,225));
		
		this.btnTorneioClube = new JButton(">>");
		this.btnTorneioClube.setBounds(125,155,50,20);
		this.btnTorneioClube.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnTorneioClube.setForeground(new Color(0, 0, 0));
		this.btnTorneioClube.setBackground(new Color(225,225,225));
		
		this.lblCampeonato = new JLabel();
		this.lblCampeonato.setBounds(310,5,480,20);
		this.lblCampeonato.setHorizontalAlignment(JLabel.CENTER);
		this.lblCampeonato.setOpaque(true);
		this.lblCampeonato.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblCampeonato.setForeground(new Color(0, 0, 0));
		this.lblCampeonato.setBackground(new Color(225,225,225));
		this.lblCampeonato.setText("CAMPEONATO");
		
		this.pnlTempCampMain = new JPanelTempCamp(null);
		this.pnlTempCampMain.setBounds(300,30,500,600);
		
		this.pnlTempCampAlterMain = new JPanelTempCampAlter(null);
		this.pnlTempCampAlterMain.setBounds(300,30,500,600);
		
		this.pnlEstatCampMain = new JPanelEstatCamp(null);
		this.pnlEstatCampMain.setBounds(300,30,500,600);
		
		this.pnlHistCampMain = new JPanelHistCamp(null);
		this.pnlHistCampMain.setBounds(300,30,500,600);
		
		this.pnlTempCampMenu = new JPanel();
		this.pnlTempCampMenu.setLayout(null);
		this.pnlTempCampMenu.setBounds(0,30,300,150);
		this.pnlTempCampMenu.setBackground(new Color(185,205,255));

		this.lblTemp = new JLabel();
		this.lblTemp.setBounds(5,5,240,20);
		this.lblTemp.setHorizontalAlignment(JLabel.LEFT);
		this.lblTemp.setOpaque(true);
		this.lblTemp.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblTemp.setForeground(new Color(0, 0, 0));
		this.lblTemp.setBackground(new Color(225,225,225));
		this.lblTemp.setText("::TEMPORADAS");
		
		this.lblOutrasTemp = new JLabel();
		this.lblOutrasTemp.setBounds(30,35,240,20);
		this.lblOutrasTemp.setHorizontalAlignment(JLabel.LEFT);
		this.lblOutrasTemp.setOpaque(true);
		this.lblOutrasTemp.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblOutrasTemp.setForeground(new Color(0, 0, 0));
		this.lblOutrasTemp.setBackground(new Color(225,225,225));
		this.lblOutrasTemp.setText("::OUTRAS TEMPORADAS");
		
		this.cboOutrasTemp = new JComboBox();
		this.cboOutrasTemp.setMaximumRowCount(4);
		this.cboOutrasTemp.setBounds(55,65,240,20);
		this.cboOutrasTemp.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.cboOutrasTemp.setForeground(new Color(0, 0, 0));
		this.cboOutrasTemp.setBackground(new Color(225,225,225));
		
		this.btnOutrasTemp = new JButton(">>");
		this.btnOutrasTemp.setBounds(125,95,50,20);
		this.btnOutrasTemp.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnOutrasTemp.setForeground(new Color(0, 0, 0));
		this.btnOutrasTemp.setBackground(new Color(225,225,225));
		
		this.pnlEstatCampMenu = new JPanel();
		this.pnlEstatCampMenu.setLayout(null);
		this.pnlEstatCampMenu.setBounds(0,180,300,180);
		this.pnlEstatCampMenu.setBackground(new Color(185,205,255));
		
		this.lblEstat = new JLabel();
		this.lblEstat.setBounds(5,5,240,20);
		this.lblEstat.setHorizontalAlignment(JLabel.LEFT);
		this.lblEstat.setOpaque(true);
		this.lblEstat.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblEstat.setForeground(new Color(0, 0, 0));
		this.lblEstat.setBackground(new Color(225,225,225));
		this.lblEstat.setText("::ESTATÍSTICAS");
		
		this.lblOpcoes = new JLabel();
		this.lblOpcoes.setBounds(30,35,240,20);
		this.lblOpcoes.setHorizontalAlignment(JLabel.LEFT);
		this.lblOpcoes.setOpaque(true);
		this.lblOpcoes.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblOpcoes.setForeground(new Color(0, 0, 0));
		this.lblOpcoes.setBackground(new Color(225,225,225));
		this.lblOpcoes.setText("::OPÇÕES");
		
		this.cboOpcoesTipo = new JComboBox();
		this.cboOpcoesTipo.setMaximumRowCount(4);
		this.cboOpcoesTipo.setBounds(55,65,240,20);
		this.cboOpcoesTipo.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.cboOpcoesTipo.setForeground(new Color(0, 0, 0));
		this.cboOpcoesTipo.setBackground(new Color(225,225,225));
		
		this.cboOpcoesOperacional = new JComboBox();
		this.cboOpcoesOperacional.setMaximumRowCount(4);
		this.cboOpcoesOperacional.setBounds(55,95,240,20);
		this.cboOpcoesOperacional.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.cboOpcoesOperacional.setForeground(new Color(0, 0, 0));
		this.cboOpcoesOperacional.setBackground(new Color(225,225,225));
		
		this.btnEstat = new JButton(">>");
		this.btnEstat.setBounds(125,125,50,20);
		this.btnEstat.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnEstat.setForeground(new Color(0, 0, 0));
		this.btnEstat.setBackground(new Color(225,225,225));
		
		this.pnlHistCampMenu = new JPanel();
		this.pnlHistCampMenu.setLayout(null);
		this.pnlHistCampMenu.setBounds(0,360,300,270);
		this.pnlHistCampMenu.setBackground(new Color(185,205,255));
		
		this.lblHist = new JLabel();
		this.lblHist.setBounds(5,5,240,20);
		this.lblHist.setHorizontalAlignment(JLabel.LEFT);
		this.lblHist.setOpaque(true);
		this.lblHist.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblHist.setForeground(new Color(0, 0, 0));
		this.lblHist.setBackground(new Color(225,225,225));
		this.lblHist.setText("::HISTÓRICO");
		
		this.lblListaVenc = new JLabel();
		this.lblListaVenc.setBounds(30,35,240,20);
		this.lblListaVenc.setHorizontalAlignment(JLabel.LEFT);
		this.lblListaVenc.setOpaque(true);
		this.lblListaVenc.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblListaVenc.setForeground(new Color(0, 0, 0));
		this.lblListaVenc.setBackground(new Color(225,225,225));
		this.lblListaVenc.setText("::LISTA DE VENCEDORES");
		
		this.btnListaVenc = new JButton(">>");
		this.btnListaVenc.setBounds(125,65,50,20);
		this.btnListaVenc.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnListaVenc.setForeground(new Color(0, 0, 0));
		this.btnListaVenc.setBackground(new Color(225,225,225));
		
		this.lblResumoVenc = new JLabel();
		this.lblResumoVenc.setBounds(30,95,240,20);
		this.lblResumoVenc.setHorizontalAlignment(JLabel.LEFT);
		this.lblResumoVenc.setOpaque(true);
		this.lblResumoVenc.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblResumoVenc.setForeground(new Color(0, 0, 0));
		this.lblResumoVenc.setBackground(new Color(225,225,225));
		this.lblResumoVenc.setText("::RESUMO DE VENCEDORES");
		
		this.btnResumoVenc = new JButton(">>");
		this.btnResumoVenc.setBounds(125,125,50,20);
		this.btnResumoVenc.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnResumoVenc.setForeground(new Color(0, 0, 0));
		this.btnResumoVenc.setBackground(new Color(225,225,225));
		
		this.lblMesaBolao = new JLabel();
		this.lblMesaBolao.setBounds(310,5,480,20);
		this.lblMesaBolao.setHorizontalAlignment(JLabel.CENTER);
		this.lblMesaBolao.setOpaque(true);
		this.lblMesaBolao.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblMesaBolao.setForeground(new Color(0, 0, 0));
		this.lblMesaBolao.setBackground(new Color(225,225,225));
		this.lblMesaBolao.setText("MESA");
		
		this.pnlPalpBolaoMain = new JPanelPalpBolao();
		this.pnlPalpBolaoMain.setBounds(300,30,500,600);
		
		this.pnlClassBolaoMain = new JPanelClassBolao();
		this.pnlClassBolaoMain.setBounds(300,30,500,600);
		
		this.pnlPalpBolaoMenu = new JPanel();
		this.pnlPalpBolaoMenu.setLayout(null);
		this.pnlPalpBolaoMenu.setBounds(0,30,300,240);
		this.pnlPalpBolaoMenu.setBackground(new Color(185,205,255));
		
		this.lblPalp = new JLabel();
		this.lblPalp.setBounds(5,5,240,20);
		this.lblPalp.setHorizontalAlignment(JLabel.LEFT);
		this.lblPalp.setOpaque(true);
		this.lblPalp.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblPalp.setForeground(new Color(0, 0, 0));
		this.lblPalp.setBackground(new Color(225,225,225));
		this.lblPalp.setText("::PALPITES");
		
		this.lblOutrasMesas = new JLabel();
		this.lblOutrasMesas.setBounds(30,35,240,20);
		this.lblOutrasMesas.setHorizontalAlignment(JLabel.LEFT);
		this.lblOutrasMesas.setOpaque(true);
		this.lblOutrasMesas.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblOutrasMesas.setForeground(new Color(0, 0, 0));
		this.lblOutrasMesas.setBackground(new Color(225,225,225));
		this.lblOutrasMesas.setText("::OUTRAS MESAS");
		
		this.cboOutrasMesas = new JComboBox();
		this.cboOutrasMesas.setMaximumRowCount(4);
		this.cboOutrasMesas.setBounds(55,65,240,20);
		this.cboOutrasMesas.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.cboOutrasMesas.setForeground(new Color(0, 0, 0));
		this.cboOutrasMesas.setBackground(new Color(225,225,225));
		
		this.btnOutrasMesas = new JButton(">>");
		this.btnOutrasMesas.setBounds(125,95,50,20);
		this.btnOutrasMesas.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnOutrasMesas.setForeground(new Color(0, 0, 0));
		this.btnOutrasMesas.setBackground(new Color(225,225,225));
		
		this.lblOutrosUsuarios = new JLabel();
		this.lblOutrosUsuarios.setBounds(30,125,240,20);
		this.lblOutrosUsuarios.setHorizontalAlignment(JLabel.LEFT);
		this.lblOutrosUsuarios.setOpaque(true);
		this.lblOutrosUsuarios.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblOutrosUsuarios.setForeground(new Color(0, 0, 0));
		this.lblOutrosUsuarios.setBackground(new Color(225,225,225));
		this.lblOutrosUsuarios.setText("::OUTROS USUARIOS DA MESA");
		
		this.cboOutrosUsuarios = new JComboBox();
		this.cboOutrosUsuarios.setMaximumRowCount(4);
		this.cboOutrosUsuarios.setBounds(55,155,240,20);
		this.cboOutrosUsuarios.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.cboOutrosUsuarios.setForeground(new Color(0, 0, 0));
		this.cboOutrosUsuarios.setBackground(new Color(225,225,225));
		
		this.btnOutrosUsuarios = new JButton(">>");
		this.btnOutrosUsuarios.setBounds(125,185,50,20);
		this.btnOutrosUsuarios.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnOutrosUsuarios.setForeground(new Color(0, 0, 0));
		this.btnOutrosUsuarios.setBackground(new Color(225,225,225));
		
		this.pnlClassBolaoMenu = new JPanel();
		this.pnlClassBolaoMenu.setLayout(null);
		this.pnlClassBolaoMenu.setBounds(0,270,300,360);
		this.pnlClassBolaoMenu.setBackground(new Color(185,205,255));
		
		this.lblClass = new JLabel();
		this.lblClass.setBounds(5,5,240,20);
		this.lblClass.setHorizontalAlignment(JLabel.LEFT);
		this.lblClass.setOpaque(true);
		this.lblClass.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblClass.setForeground(new Color(0, 0, 0));
		this.lblClass.setBackground(new Color(225,225,225));
		this.lblClass.setText("::CLASSIFICACAO");
		
		this.lblClassBolao = new JLabel();
		this.lblClassBolao.setBounds(30,35,240,20);
		this.lblClassBolao.setHorizontalAlignment(JLabel.LEFT);
		this.lblClassBolao.setOpaque(true);
		this.lblClassBolao.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.lblClassBolao.setForeground(new Color(0, 0, 0));
		this.lblClassBolao.setBackground(new Color(225,225,225));
		this.lblClassBolao.setText("::CLASSIFICACAO DA MESA");
		
		this.btnClassBolao = new JButton(">>");
		this.btnClassBolao.setBounds(125,65,50,20);
		this.btnClassBolao.setFont(new Font("Verdana", Font.PLAIN, 9));
		this.btnClassBolao.setForeground(new Color(0, 0, 0));
		this.btnClassBolao.setBackground(new Color(225,225,225));
		
		for (int idx=0; idx<QTD_TELAS; idx++) {
			this.btnVoltar[idx] = new JButton("<<");
			this.btnVoltar[idx].setBounds(0,5,150,20);
			this.btnVoltar[idx].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.btnVoltar[idx].setForeground(new Color(0, 0, 0));
			this.btnVoltar[idx].setBackground(new Color(225,225,225));
		}
		
		for (int idx=0; idx<QTD_TELAS; idx++) {
			this.btnAvancar[idx] = new JButton(">>");
			this.btnAvancar[idx].setBounds(150,5,150,20);
			this.btnAvancar[idx].setFont(new Font("Verdana", Font.PLAIN, 9));
			this.btnAvancar[idx].setForeground(new Color(0, 0, 0));			
			this.btnAvancar[idx].setBackground(new Color(225,225,225));
		}
		
		//Adicionar Componentes Itens a Cmoponentes Menus
		this.menuArquivo.addSeparator();
		this.menuArquivo.add(this.menuitemNovo);
		this.menuArquivo.addSeparator();
		this.menuArquivo.add(this.menuitemSair);
		this.menuOpcoes.add(this.checkitemConectar);
		this.menuArquivo.addSeparator();
		this.menuOpcoes.add(this.checkitemAdministrarTorneios);
		
		this.menubarPrincipal.add(this.menuArquivo);
		this.menubarPrincipal.add(this.menuOpcoes);
		
		this.setJMenuBar(this.menubarPrincipal);
		
		this.pnlLogin.add(this.lblJBolao);
		this.pnlLogin.add(this.lblNick);
		this.pnlLogin.add(this.lblPass);
		this.pnlLogin.add(this.lblErroLogin);
		this.pnlLogin.add(this.txtNick);
		this.pnlLogin.add(this.txtPass);
		this.pnlLogin.add(this.btnLogin);
		this.pnlUsuarioMain.add(this.lblCompeticoes);
		this.pnlUsuarioMain.add(this.cboCompeticoes);
		this.pnlUsuarioMain.add(this.btnMesaBolao);
		this.pnlUsuarioMain.add(this.btnAbandonarBolao);
		this.pnlUsuarioMain.add(this.lblCompeticoesOwner);
		this.pnlUsuarioMain.add(this.cboCompeticoesOwner);
		this.pnlUsuarioMain.add(this.lblProcurarAdversario);
		this.pnlUsuarioMain.add(this.txtProcurarAdversario);
		this.pnlUsuarioMain.add(this.btnProcurarAdversario);
		this.pnlUsuarioMain.add(this.cboAdversarios);
		this.pnlUsuarioMain.add(this.btnConvidarAdversario);
		this.pnlUsuarioMain.add(this.lblErroAdversario);
		this.pnlUsuarioMain.add(this.lblConvites);
		this.pnlUsuarioMain.add(this.cboConvites);
		this.pnlUsuarioMain.add(this.btnAceitar);
		this.pnlUsuarioMain.add(this.btnRecusar);
		this.pnlSelecoes.add(this.lblSelecoes);
		this.pnlSelecoes.add(this.lblTorneioSelec);
		this.pnlSelecoes.add(this.cboTorneioSelec);
		this.pnlSelecoes.add(this.btnTorneioSelec);
		this.pnlClubes.add(this.lblClubes);
		this.pnlClubes.add(this.lblTorneioNac);
		this.pnlClubes.add(this.cboTorneioNac);
		this.pnlClubes.add(this.lblTorneioInter);
		this.pnlClubes.add(this.cboTorneioInter);
		this.pnlClubes.add(this.btnTorneioClube);
		this.pnlUsuario.add(this.lblUsuario);
		this.pnlUsuario.add(this.pnlUsuarioMain);
		this.pnlUsuario.add(this.pnlSelecoes);
		this.pnlUsuario.add(this.pnlClubes);
		this.pnlTempCampMenu.add(this.lblTemp);
		this.pnlTempCampMenu.add(this.lblOutrasTemp);
		this.pnlTempCampMenu.add(this.cboOutrasTemp);
		this.pnlTempCampMenu.add(this.btnOutrasTemp);
		this.pnlEstatCampMenu.add(this.lblEstat);
		this.pnlEstatCampMenu.add(this.lblOpcoes);
		this.pnlEstatCampMenu.add(this.cboOpcoesTipo);
		this.pnlEstatCampMenu.add(this.cboOpcoesOperacional);
		this.pnlEstatCampMenu.add(this.btnEstat);
		this.pnlHistCampMenu.add(this.lblHist);
		this.pnlHistCampMenu.add(this.lblListaVenc);
		this.pnlHistCampMenu.add(this.btnListaVenc);
		this.pnlHistCampMenu.add(this.lblResumoVenc);
		this.pnlHistCampMenu.add(this.btnResumoVenc);
		this.pnlCamp.add(this.lblCampeonato);
		this.pnlCamp.add(this.pnlTempCampMain);
		this.pnlCamp.add(this.pnlTempCampAlterMain);
		this.pnlCamp.add(this.pnlEstatCampMain);
		this.pnlCamp.add(this.pnlHistCampMain);
		this.pnlCamp.add(this.pnlTempCampMenu);
		this.pnlCamp.add(this.pnlEstatCampMenu);
		this.pnlCamp.add(this.pnlHistCampMenu);
		this.pnlPalpBolaoMenu.add(this.lblPalp);
		this.pnlPalpBolaoMenu.add(this.lblOutrasMesas);
		this.pnlPalpBolaoMenu.add(this.cboOutrasMesas);
		this.pnlPalpBolaoMenu.add(this.btnOutrasMesas);
		this.pnlPalpBolaoMenu.add(this.lblOutrosUsuarios);
		this.pnlPalpBolaoMenu.add(this.cboOutrosUsuarios);
		this.pnlPalpBolaoMenu.add(this.btnOutrosUsuarios);
		this.pnlClassBolaoMenu.add(this.lblClass);
		this.pnlClassBolaoMenu.add(this.lblClassBolao);
		this.pnlClassBolaoMenu.add(this.btnClassBolao);
		this.pnlBolao.add(this.lblMesaBolao);
		this.pnlBolao.add(this.pnlPalpBolaoMain);
		this.pnlBolao.add(this.pnlClassBolaoMain);
		this.pnlBolao.add(this.pnlPalpBolaoMenu);
		this.pnlBolao.add(this.pnlClassBolaoMenu);
		
		this.pnlLogin.add(this.btnVoltar[TELA_LOGIN]);
		this.pnlLogin.add(this.btnAvancar[TELA_LOGIN]);
		this.pnlUsuario.add(this.btnVoltar[TELA_USUARIO]);
		this.pnlUsuario.add(this.btnAvancar[TELA_USUARIO]);
		this.pnlCamp.add(this.btnVoltar[TELA_CAMP]);
		this.pnlCamp.add(this.btnAvancar[TELA_CAMP]);
		this.pnlBolao.add(this.btnVoltar[TELA_BOLAO]);
		this.pnlBolao.add(this.btnAvancar[TELA_BOLAO]);
		
		this.tbpJBolao.addTab("LOGIN", null, this.pnlLogin, null);
		this.tbpJBolao.addTab("USUARIO", null, this.pnlUsuario, null);
		this.tbpJBolao.addTab("CAMP", null, this.pnlCamp, null);
		this.tbpJBolao.addTab("BOLAO", null, this.pnlBolao, null);
		
		this.add(this.tbpJBolao);
		
		//Adicionar Mnemonicos aos Componentes
		this.menuArquivo.setMnemonic('A');
		this.menuOpcoes.setMnemonic('O');
		this.menuitemNovo.setMnemonic('N');
		this.menuitemSair.setMnemonic('r');
		this.checkitemConectar.setMnemonic('C');
		this.checkitemAdministrarTorneios.setMnemonic('T');
		
		//Adicionar Handlers de Eventos
		this.addWindowListener(this);
		
		this.menuitemNovo.addActionListener(this);
		this.menuitemSair.addActionListener(this);
		this.checkitemConectar.addItemListener(this);
		this.checkitemAdministrarTorneios.addItemListener(this);
		this.btnLogin.addActionListener(this);
		this.cboCompeticoes.addItemListener(this);
		this.btnMesaBolao.addActionListener(this);
		this.btnAbandonarBolao.addActionListener(this);
		this.cboCompeticoesOwner.addItemListener(this);
		this.btnProcurarAdversario.addActionListener(this);
		this.cboAdversarios.addItemListener(this);
		this.btnConvidarAdversario.addActionListener(this);
		this.cboConvites.addItemListener(this);
		this.btnAceitar.addActionListener(this);
		this.btnRecusar.addActionListener(this);
		this.cboTorneioSelec.addItemListener(this);
		this.btnTorneioSelec.addActionListener(this);
		this.cboTorneioNac.addItemListener(this);
		this.cboTorneioInter.addItemListener(this);
		this.btnTorneioClube.addActionListener(this);
		this.cboOutrasTemp.addItemListener(this);
		this.btnOutrasTemp.addActionListener(this);
		this.cboOpcoesTipo.addItemListener(this);
		this.cboOpcoesOperacional.addItemListener(this);
		this.btnEstat.addActionListener(this);
		this.btnListaVenc.addActionListener(this);
		this.btnResumoVenc.addActionListener(this);
		this.cboOutrasMesas.addItemListener(this);
		this.btnOutrasMesas.addActionListener(this);
		this.cboOutrosUsuarios.addItemListener(this);
		this.btnOutrosUsuarios.addActionListener(this);
		this.btnClassBolao.addActionListener(this);
		
		for (int idx=0; idx<QTD_TELAS; idx++) {
			this.btnVoltar[idx].addActionListener(this);
			this.btnAvancar[idx].addActionListener(this);
		}
		
		this.carregaINI();
		this.consisteINI();
		
		this.configuraExibicao();
		
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Configuracoes *****************************************************************************************************************
	private void carregaINI() {
	
		try {
			int idxConf = 0;
			BufferedReader BR = new BufferedReader(new FileReader("config/JBolao.ini"));
			String numericos = "0123456789";
			String linhaLida = BR.readLine();
			while (linhaLida != null) {
				for (idxConf=0; idxConf<4; idxConf++) {
					if (linhaLida.indexOf(this.strConf[idxConf]) != -1) {
						char caracterLido = '0';
						String numeroLido = "";
						int idxLinhaLida = linhaLida.indexOf(this.strConf[idxConf]) + this.strConf[idxConf].length();
						while ((idxLinhaLida < linhaLida.length()) && (numericos.indexOf(caracterLido) != -1)) {
							caracterLido = linhaLida.charAt(idxLinhaLida);
							numeroLido = numeroLido + caracterLido;
							idxLinhaLida = idxLinhaLida + 1;
						}
						this.intConf[idxConf] = Integer.parseInt(numeroLido);
					}
				}
				linhaLida = BR.readLine();
			}
			BR.close();
		}
		catch (Exception e) {
			//Nao faz nada
		}
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Salvar Configuracoes  ******************************************************************************************************************
	private void salvaINI() {
	
		try {
			int idxConf = 0;
			
			this.intConf[0] = this.getX();
			this.intConf[1] = this.getY();
			this.intConf[2] = this.getWidth();
			this.intConf[3] = this.getHeight();
			
			BufferedWriter BW = new BufferedWriter(new FileWriter("config/JBolao.ini"));
			for (idxConf=0; idxConf<4; idxConf++) {
				BW.write(String.format("%s%d", this.strConf[idxConf], this.intConf[idxConf]));
				BW.newLine();
			}
			BW.close();
		}
		catch (Exception e) {
			//Nao faz nada
		}
		
		return;
		
	}
	//********************************************************************************************************************************************
	
	//*** Consistir Configuracoes ****************************************************************************************************************
	private void consisteINI() {
	
		if ((this.intConf[0] < 0) || (this.intConf[0] > 800))
			this.intConf[0] = 0;
		
		if ((this.intConf[1] < 0) || (this.intConf[1] > 600))
			this.intConf[1] = 0;
		
		if ((this.intConf[2] < 805) || (this.intConf[2] > 805))
			this.intConf[2] = 805;
		
		if ((this.intConf[3] < 715) || (this.intConf[3] > 715))
			this.intConf[3] = 715;
			
		this.setBounds(this.intConf[0], this.intConf[1], this.intConf[2], this.intConf[3]);	
		this.checkitemConectar.setSelected(false);
		this.checkitemAdministrarTorneios.setSelected(false);
		
		return;
		
	}
	//********************************************************************************************************************************************
	
	//*** Consistir Campos Login *****************************************************************************************************************
	private boolean consisteCamposLogin() {
	
		boolean b = true;
		
		String S1 = new String(this.txtNick.getText().replaceAll(" ", ""));
		String S2 = new String(this.txtPass.getPassword());
		
		this.txtNick.setText(S1);
		
		char c2[] = this.txtPass.getPassword();
		
		if (b) {
			if (S1.trim().equals("")) {
				b = false;
				this.lblErroLogin.setText("APELIDO É DE PREENCHIMENTO OBRIGATÓRIO!");
			}
		}
		
		if (b) {
			if (S1.length() < 4) {
				b = false;
				this.lblErroLogin.setText("APELIDO DEVE TER NO MÍNIMO 4 CARACTERES!");
			}
		}
		
		if (b) {
			if (S1.length() > 12) {
				b = false;
				this.lblErroLogin.setText("APELIDO DEVE TER NO MÁXIMO 12 CARACTERES!");
			}
		}
		
		if (b) {
			if (S2.trim().equals("")) {
				b = false;
				this.lblErroLogin.setText("SENHA É DE PREENCHIMENTO OBRIGATÓRIO!");
			}
		}
		
		if (b) {
			if (S2.length() < 4) {
				b = false;
				this.lblErroLogin.setText("SENHA DEVE TER NO MÍNIMO 4 CARACTERES!");
			}
		}
		
		if (b) {
			if (S2.length() > 12) {
				b = false;
				this.lblErroLogin.setText("SENHA DEVE TER NO MÁXIMO 12 CARACTERES!");
			}
		}
		
		if (b) {
			for (char c: c2) {
				if ((NUMERICOS.indexOf(c) == -1) && (ALFABETICOS.indexOf(c) == -1)) {
					b = false;
					this.lblErroLogin.setText("SENHA SÓ DEVE TER CARACTERES ALFANUMÉRICOS!");
				}
			}
		}
		
		return b;
		
	}
	//********************************************************************************************************************************************
	
	//*** Efetuar Login **************************************************************************************************************************
	private boolean efetuaLogin() {
	
		boolean b = true;
		
		if (b) {
		
			UsuarioDAO userDAO = new UsuarioDAO();
			this.user = userDAO.selUsuarioByLogin(new String(this.txtNick.getText()), new String(this.txtPass.getPassword()));
			
			if (this.user == null) {
			
				b = false;
				this.lblErroLogin.setText(Error.getErroAplicacao());
				System.out.println("JBolao: " + Error.getErroInterno());
				
			}
			
		}
		
		return b;
		
	}
	//********************************************************************************************************************************************
	
	//*** Consistir Campos Busca Adversario *****************************************************************************************************
	private boolean consisteCamposBuscaAdversario() {
	
		boolean b = true;
		
		String S1 = new String(this.txtProcurarAdversario.getText().replaceAll(" ", ""));
		
		this.txtProcurarAdversario.setText(S1);
		
		char c1[] = this.txtProcurarAdversario.getText().toCharArray();
		
		if (b) {
			if (S1.trim().equals("")) {
				b = false;
				this.lblErroAdversario.setText("CAMPO DE BUSCA NÃO INFORMADO!");
			}
		}
		
		if (b) {
			for (char c: c1) {
				if ((NUMERICOS.indexOf(c) == -1) && (ALFABETICOS.indexOf(c) == -1)) {
					b = false;
					this.lblErroAdversario.setText("CAMPO DE BUSCA SÓ DEVE TER CARACTERES ALFANUMÉRICOS!");
				}
			}
		}
		
		return b;
		
	}
	//********************************************************************************************************************************************
	
	//*** Limpar Busca Adversario ****************************************************************************************************************
	private void limpaBuscaAdversario() {
	
		this.userDListaAdversarios = null;
		this.cboAdversarios.removeAllItems();
		
		return;
		
	}
	//********************************************************************************************************************************************
	
	//*** Efetuar Busca Adversario ***************************************************************************************************************
	private boolean efetuaBuscaAdversario() {
	
		boolean b = true;
		
		if (b) {
		
			UsuarioDAO userDAO = new UsuarioDAO();
			DLista userDLista = userDAO.selUsuarioByLike(new String(this.txtProcurarAdversario.getText()));
			
			if ((userDLista != null) && (userDLista.count() > 0)) {
			
				this.userDListaAdversarios = new DLista();
				
				this.cboAdversarios.addItem("::Selecione um Adversário");
				
				for (int idx=0; idx<userDLista.count(); idx++) {
					Usuario user = (Usuario) userDLista.get(idx);
					this.userDListaAdversarios.addLast(user);
					this.cboAdversarios.addItem(user.getCodigo());
				}
				
			}
			
			else {
			
				b = false;
				this.lblErroAdversario.setText("NAO FORAM ENCONTRADOS RESULTADOS.");
				
			}
			
		}
		
		return b;
		
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Tela Usuario ******************************************************************************************************************
	private void carregaTelaUsuario() {
	
		this.haMesa = false;
		this.haMesaCompet = false;
		this.haMesaCompetOwner = false;
		this.haMesaConvit = false;
		this.haBusca = false;
		this.haBuscaSelec = false;
		
		this.haTorneio = false;
		this.haTorneioSelec = false;
		this.haTorneioNac = false;
		this.haTorneioInter = false;
	
		this.limpaComboCompeticoes();
		this.carregaComboCompeticoes();
		
		this.limpaComboCompeticoesOwner();
		this.carregaComboCompeticoesOwner();
		
		this.limpaComboConvites();
		this.carregaComboConvites();
		
		this.limpaComboTorneioSelec();
		this.carregaComboTorneioSelec();
		
		this.limpaComboTorneioNac();
		this.carregaComboTorneioNac();
		
		this.limpaComboTorneioInter();
		this.carregaComboTorneioInter();
		
		this.pnlUsuario.repaint();
		
		return;
	
	}
	//********************************************************************************************************************************************

	//*** Carregar Tela TempCamp *****************************************************************************************************************
	private void carregaTelaTempCamp() {
		
		this.limpaComboOutrasTemp();
		this.carregaComboOutrasTemp();
		boolean tempSelecionada = this.selecionaComboOutrasTemp();
		
		this.cboOutrasTemp.setEnabled((tempSelecionada)? true : false);
		this.btnOutrasTemp.setEnabled((tempSelecionada)? true : false);
		
		this.tempAutoPostBack = this.temp;
		
		this.limpaComboOpcoesTipo();
		this.carregaComboOpcoesTipo();
		boolean opcaotipoSelecionada = this.selecionaComboOpcoesTipo();
		
		this.cboOpcoesTipo.setEnabled((tempSelecionada)? true : false);
		this.btnEstat.setEnabled((tempSelecionada)? true : false);
		
		this.limpaComboOpcoesOperacional();
		this.carregaComboOpcoesOperacional();
		boolean opcaooperacionalSelecionada = this.selecionaComboOpcoesOperacional();
		
		this.cboOpcoesOperacional.setEnabled((opcaooperacionalSelecionada)? true : false);
		
		if (this.intTelaAux == TELA_TEMP_CAMP_MAIN) {
			this.pnlTempCampMain.setTemp(this.temp);
			this.pnlTempCampMain.carregaTelaTempCamp();
		}
		else {
			this.pnlTempCampAlterMain.setTemp(this.temp);
			this.pnlTempCampAlterMain.carregaTelaTempCamp();
		}
		
		return;
		
	}
	//********************************************************************************************************************************************
	
	//*** Alterar Tela TempCamp ******************************************************************************************************************
	private void alteraTelaTempCamp() {
	
		if (this.intTelaAux == TELA_TEMP_CAMP_MAIN) {
			this.pnlTempCampMain.setTemp(this.temp);
			this.pnlTempCampMain.carregaTelaTempCamp();
		}
		else {
			this.pnlTempCampAlterMain.setTemp(this.temp);
			this.pnlTempCampAlterMain.carregaTelaTempCamp();
		}
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Tela EstatCamp ****************************************************************************************************************
	private void carregaTelaEstatCamp() {
		
		this.pnlEstatCampMain.setTemp(this.temp);
		this.pnlEstatCampMain.carregaTelaEstatCamp();
		
		return;
		
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Tela HistCamp *****************************************************************************************************************
	private void carregaTelaHistCamp(TipoBusca tpBusca) {
		
		this.pnlHistCampMain.setTemp(this.temp);
		this.pnlHistCampMain.carregaTelaHistCamp(tpBusca);
		
		return;
		
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Tela PalpBolao ****************************************************************************************************************
	private void carregaTelaPalpBolao() {
		
		this.limpaComboOutrasMesas();
		this.carregaComboOutrasMesas();
		boolean mesaSelecionada = this.selecionaComboOutrasMesas();
		
		this.cboOutrasMesas.setEnabled((mesaSelecionada)? true : false);
		this.btnOutrasMesas.setEnabled((mesaSelecionada)? true : false);
		this.btnClassBolao.setEnabled((mesaSelecionada)? true : false);
		
		this.mesaAutoPostBack = this.mesa;
		
		this.limpaComboOutrosUsuarios();
		this.carregaComboOutrosUsuarios();
		boolean usuarioSelecionado = this.selecionaComboOutrosOutrosUsuarios();
		
		this.cboOutrosUsuarios.setEnabled((usuarioSelecionado)? true : false);
		this.btnOutrosUsuarios.setEnabled((usuarioSelecionado)? true : false);
		
		this.pnlPalpBolaoMain.setMesaBolao(this.mesa);
		this.pnlPalpBolaoMain.setOutroUsuario(null);
		this.pnlPalpBolaoMain.carregaTelaPalpBolao();
		
		return;
		
	}
	//********************************************************************************************************************************************
	
	//*** Alterar Tela PalpBolao *****************************************************************************************************************
	private void alteraTelaPalpBolao() {
		
		this.pnlPalpBolaoMain.setMesaBolao(this.mesa);
		this.pnlPalpBolaoMain.setOutroUsuario(null);
		this.pnlPalpBolaoMain.carregaTelaPalpBolao();
		
		return;
	
	}
	//********************************************************************************************************************************************
		
	//*** Carregar Tela ClassBolao ***************************************************************************************************************
	private void carregaTelaClassBolao() {
		
		this.pnlClassBolaoMain.setMesaBolao(this.mesa);
		this.pnlClassBolaoMain.carregaTelaClassBolao();
		
		return;
		
	}
	//********************************************************************************************************************************************
		
	//*** Limpar Combo Competicoes ***************************************************************************************************************	
	private void limpaComboCompeticoes() {
	
		this.cboCompeticoes.removeAllItems();
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Combo Competicoes *************************************************************************************************************	
	private void carregaComboCompeticoes() {
		
		VMesaBolaoDAO mesaDAO = new VMesaBolaoDAO();
		DLista mesaDLista = mesaDAO.selVCompeticoesByUsuario(this.user.getCodigo().trim());
		
		this.mesaDListaCompeticoes = new DLista();
		
		this.cboCompeticoes.addItem("::Selecione uma Mesa");
		
		if (mesaDLista != null) {
			for (int idx=0; idx<mesaDLista.count(); idx++) {
				VMesaBolao mesa = (VMesaBolao) mesaDLista.get(idx);
				this.mesaDListaCompeticoes.addLast(mesa);
				this.cboCompeticoes.addItem(mesa.getNomeMesa());
			}
		}
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Limpar Combo CompeticoesOwner **********************************************************************************************************	
	private void limpaComboCompeticoesOwner() {
	
		this.cboCompeticoesOwner.removeAllItems();
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Combo CompeticoesOwner ********************************************************************************************************	
	private void carregaComboCompeticoesOwner() {
		
		VMesaBolaoDAO mesaDAO = new VMesaBolaoDAO();
		DLista mesaDLista = mesaDAO.selVCompeticoesByUsuarioOwner(this.user.getCodigo().trim());
		
		this.mesaDListaCompeticoesOwner = new DLista();
		
		this.cboCompeticoesOwner.addItem("::Selecione uma Mesa");
		
		if (mesaDLista != null) {
			for (int idx=0; idx<mesaDLista.count(); idx++) {
				VMesaBolao mesa = (VMesaBolao) mesaDLista.get(idx);
				this.mesaDListaCompeticoesOwner.addLast(mesa);
				this.cboCompeticoesOwner.addItem(mesa.getNomeMesa());
			}
		}
		
		return;
	
	}
	//********************************************************************************************************************************************	
	
	//*** Limpar Combo Convites ******************************************************************************************************************	
	private void limpaComboConvites() {
	
		this.cboConvites.removeAllItems();
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Combo Convites *************************************************************************************************************	
	private void carregaComboConvites() {
		
		VMesaBolaoDAO mesaDAO = new VMesaBolaoDAO();
		DLista mesaDLista = mesaDAO.selVConvitesByUsuario(this.user.getCodigo().trim());
		
		this.mesaDListaConvites = new DLista();
		
		this.cboConvites.addItem("::Selecione uma Mesa");
		
		if (mesaDLista != null) {
			for (int idx=0; idx<mesaDLista.count(); idx++) {
				VMesaBolao mesa = (VMesaBolao) mesaDLista.get(idx);
				this.mesaDListaConvites.addLast(mesa);
				this.cboConvites.addItem(mesa.getNomeMesa());
			}
		}
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Limpar Combo TorneioSelec **************************************************************************************************************	
	private void limpaComboTorneioSelec() {
	
		this.cboTorneioSelec.removeAllItems();
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Combo TorneioSelec ************************************************************************************************************	
	private void carregaComboTorneioSelec() {
		
		VTempDAO tempDAO = new VTempDAO();
		DLista tempDLista = tempDAO.selVTempListaSelecoes();
		
		this.tempDListaSelec = new DLista();
		
		String strCodigoCampeonatoAtu = "AAA";
		String strCodigoCampeonatoAnt = "AAA";
		
		this.cboTorneioSelec.addItem("::Selecione um Torneio");
		
		for (int idx=0; idx<tempDLista.count(); idx++) {
			VTemp temp = (VTemp) tempDLista.get(idx);
			strCodigoCampeonatoAtu = temp.getCodigoCampeonato();
			if (!strCodigoCampeonatoAnt.equals(strCodigoCampeonatoAtu)) {
				this.tempDListaSelec.addLast(temp);
				this.cboTorneioSelec.addItem(temp.getNomeCampeonato());
			}
			strCodigoCampeonatoAnt = strCodigoCampeonatoAtu;
		}
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Limpar Combo TorneioNac ****************************************************************************************************************	
	private void limpaComboTorneioNac() {
	
		this.cboTorneioNac.removeAllItems();
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Combo TorneioNac **************************************************************************************************************	
	private void carregaComboTorneioNac() {
		
		VTempDAO tempDAO = new VTempDAO();
		DLista tempDLista = tempDAO.selVTempListaClubsNac();
		
		this.tempDListaNac = new DLista();
		
		String strCodigoPaisCampeonatoAtu = "AAA";
		String strCodigoPaisCampeonatoAnt = "AAA";
		
		String strCodigoCampeonatoAtu = "AAA";
		String strCodigoCampeonatoAnt = "AAA";
		
		this.cboTorneioNac.addItem("::Selecione um Torneio");
		
		for (int idx=0; idx<tempDLista.count(); idx++) {
			VTemp temp = (VTemp) tempDLista.get(idx);
			strCodigoPaisCampeonatoAtu = temp.getCodigoPaisCampeonato();
			strCodigoCampeonatoAtu = temp.getCodigoCampeonato();
			if (!strCodigoPaisCampeonatoAnt.equals(strCodigoPaisCampeonatoAtu)) {
				this.tempDListaNac.addLast(temp);
				this.cboTorneioNac.addItem(temp.getNomeCampeonato());
			}
			else if (!strCodigoCampeonatoAnt.equals(strCodigoCampeonatoAtu)) {
				this.tempDListaNac.addLast(temp);
				this.cboTorneioNac.addItem(temp.getNomeCampeonato());
			}
			strCodigoPaisCampeonatoAnt = strCodigoPaisCampeonatoAtu;
			strCodigoCampeonatoAnt = strCodigoCampeonatoAtu;
		}
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Limpar Combo TorneioInter **************************************************************************************************************	
	private void limpaComboTorneioInter() {
	
		this.cboTorneioInter.removeAllItems();
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Combo TorneioInter ************************************************************************************************************	
	private void carregaComboTorneioInter() {
		
		VTempDAO tempDAO = new VTempDAO();
		DLista tempDLista = tempDAO.selVTempListaClubsInter();
		
		this.tempDListaInter = new DLista();
		
		String strCodigoPaisCampeonatoAtu = "AAA";
		String strCodigoPaisCampeonatoAnt = "AAA";
		
		String strCodigoCampeonatoAtu = "AAA";
		String strCodigoCampeonatoAnt = "AAA";
		
		this.cboTorneioInter.addItem("::Selecione um Torneio");
		
		for (int idx=0; idx<tempDLista.count(); idx++) {
			VTemp temp = (VTemp) tempDLista.get(idx);
			strCodigoPaisCampeonatoAtu = temp.getCodigoPaisCampeonato();
			strCodigoCampeonatoAtu = temp.getCodigoCampeonato();
			if (!strCodigoPaisCampeonatoAnt.equals(strCodigoPaisCampeonatoAtu)) {
				this.tempDListaInter.addLast(temp);
				this.cboTorneioInter.addItem(temp.getNomeCampeonato());
			}
			else if (!strCodigoCampeonatoAnt.equals(strCodigoCampeonatoAtu)) {
				this.tempDListaInter.addLast(temp);
				this.cboTorneioInter.addItem(temp.getNomeCampeonato());
			}
			strCodigoPaisCampeonatoAnt = strCodigoPaisCampeonatoAtu;
			strCodigoCampeonatoAnt = strCodigoCampeonatoAtu;
		}
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Limpar Combo OutrasTemp ****************************************************************************************************************	
	private void limpaComboOutrasTemp() {
	
		this.cboOutrasTemp.removeAllItems();
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Combo OutrasTemp **************************************************************************************************************	
	private void carregaComboOutrasTemp() {
	
		int intCodigoPaisCampeonato = Integer.parseInt(this.temp.getCodigoPaisCampeonato());
		int intCodigoCampeonato = Integer.parseInt(this.temp.getCodigoCampeonato());
		
		DecimalFormat DF3 = new DecimalFormat("000");
		
		String strCodigoPaisCampeonato = DF3.format(intCodigoPaisCampeonato);
		String strCodigoCampeonato = DF3.format(intCodigoCampeonato);
		
		String strAnoInicioTemporada = "AAAA";
		String strAnoFimTemporada = "AAAA";
		
		VTempDAO tempDAO = new VTempDAO();
		DLista tempDLista = ((this.selecionaTipoEquipe(strCodigoPaisCampeonato, strCodigoCampeonato) == TipoEquipe.SELECAO)? tempDAO.selVTempListaByCampeonato(strCodigoCampeonato) : tempDAO.selVTempListaByPaisCampeonato(strCodigoPaisCampeonato, strCodigoCampeonato));
		
		this.outrastempDLista = new DLista();
		
		//this.cboOutrasTemp.addItem("::Selecione uma Temporada");
		
		for (int idx=0; idx<tempDLista.count(); idx++) {
		
			VTemp temp = (VTemp) tempDLista.get(idx);
			strCodigoPaisCampeonato = temp.getCodigoPaisCampeonato();
			strCodigoCampeonato = temp.getCodigoCampeonato();
			strAnoInicioTemporada = temp.getAnoInicioTemporada();
			strAnoFimTemporada = temp.getAnoFimTemporada();
			
			VJogoPDAO jogoPDAO = new VJogoPDAO();
			VJogoTDAO jogoTDAO = new VJogoTDAO();
			
			DLista jogoDLista = new DLista();
			
			if (this.selecionaTipoEquipe(strCodigoPaisCampeonato, strCodigoCampeonato) == TipoEquipe.SELECAO) {
				if (this.selecionaTipoEtapaTorneio(strCodigoPaisCampeonato, strCodigoCampeonato) == TipoEtapaTorneio.FASE_COPA) {
					jogoDLista = jogoPDAO.selVJogoByFaseAtual(strCodigoPaisCampeonato, strCodigoCampeonato, strAnoInicioTemporada, strAnoFimTemporada);
				}
				if (this.selecionaTipoEtapaTorneio(strCodigoPaisCampeonato, strCodigoCampeonato) == TipoEtapaTorneio.RODADA_LIGA) {
					jogoDLista = jogoPDAO.selVJogoByRodadaAtual(strCodigoPaisCampeonato, strCodigoCampeonato, strAnoInicioTemporada, strAnoFimTemporada);
				}
			}
			if (this.selecionaTipoEquipe(strCodigoPaisCampeonato, strCodigoCampeonato) == TipoEquipe.CLUBE) {
				if (this.selecionaTipoEtapaTorneio(strCodigoPaisCampeonato, strCodigoCampeonato) == TipoEtapaTorneio.FASE_COPA) {
					jogoDLista = jogoTDAO.selVJogoByFaseAtual(strCodigoPaisCampeonato, strCodigoCampeonato, strAnoInicioTemporada, strAnoFimTemporada);
				}
				if (this.selecionaTipoEtapaTorneio(strCodigoPaisCampeonato, strCodigoCampeonato) == TipoEtapaTorneio.RODADA_LIGA) {
					jogoDLista = jogoTDAO.selVJogoByRodadaAtual(strCodigoPaisCampeonato, strCodigoCampeonato, strAnoInicioTemporada, strAnoFimTemporada);
				}
			}
			
			if ((jogoDLista != null) && (jogoDLista.count() > 0)) {
				this.outrastempDLista.addLast(temp);
				this.cboOutrasTemp.addItem(strAnoInicioTemporada + "-" + strAnoFimTemporada);
			}
			
		}
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Selecionar Combo OutrasTemp ************************************************************************************************************
	private boolean selecionaComboOutrasTemp() {
	
		boolean tempSelecionada = false;
		
		for (int idx=0; idx<this.outrastempDLista.count(); idx++) {
			VTemp tempAux = (VTemp) this.outrastempDLista.get(idx);
			if (this.temp.getCodigoPaisCampeonato().equals(tempAux.getCodigoPaisCampeonato())) {
				if (this.temp.getCodigoCampeonato().equals(tempAux.getCodigoCampeonato())) {
					if (this.temp.getAnoInicioTemporada().equals(tempAux.getAnoInicioTemporada())) {
						if (this.temp.getAnoFimTemporada().equals(tempAux.getAnoFimTemporada())) {
							this.cboOutrasTemp.setSelectedIndex(idx);
							tempSelecionada = true;
							break;
						}
					}
				}
			}
		}
		
		return tempSelecionada;
		
	}	
	//********************************************************************************************************************************************
	
	//*** Limpar Combo OpcoesTipo ****************************************************************************************************************	
	private void limpaComboOpcoesTipo() {
	
		this.cboOpcoesTipo.removeAllItems();
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Combo OpcoesTipo **************************************************************************************************************	
	private void carregaComboOpcoesTipo() {
	
		this.jogostipoDLista = new DLista();
		
		for (OpcoesEstatisticas optestat : OpcoesEstatisticas.values()) {
			this.jogostipoDLista.addLast(optestat);
			this.cboOpcoesTipo.addItem(optestat.getDescField());
		}
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Selecionar Combo OpcoesTipo ************************************************************************************************************
	private boolean selecionaComboOpcoesTipo() {
	
		boolean opcaotipoSelecionada = false;
		
		this.cboOpcoesTipo.setSelectedIndex(0);
		opcaotipoSelecionada = true;
		
		return opcaotipoSelecionada;
		
	}
	//********************************************************************************************************************************************
	
	//*** Limpar Combo OpcoesOperacional *********************************************************************************************************	
	private void limpaComboOpcoesOperacional() {
	
		this.cboOpcoesOperacional.removeAllItems();
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Combo OpcoesOperacional *******************************************************************************************************	
	private void carregaComboOpcoesOperacional() {
	
		if (this.selecionaTipoEtapaTorneio(this.tempAutoPostBack.getCodigoPaisCampeonato(), this.tempAutoPostBack.getCodigoCampeonato()) == TipoEtapaTorneio.RODADA_LIGA) {
		
			VJogoPDAO jogoPDAO = new VJogoPDAO();
			VJogoTDAO jogoTDAO = new VJogoTDAO();
			
			DLista jogoDLista = new DLista();
			
			if (this.selecionaTipoEquipe(this.tempAutoPostBack.getCodigoPaisCampeonato(), this.tempAutoPostBack.getCodigoCampeonato()) == TipoEquipe.SELECAO)
				jogoDLista = jogoPDAO.selVJogoByDistinctOperacional(this.tempAutoPostBack.getCodigoPaisCampeonato(), this.tempAutoPostBack.getCodigoCampeonato(), this.tempAutoPostBack.getAnoInicioTemporada(), this.tempAutoPostBack.getAnoFimTemporada(), "RODADA");
				
			if (this.selecionaTipoEquipe(this.tempAutoPostBack.getCodigoPaisCampeonato(), this.tempAutoPostBack.getCodigoCampeonato()) == TipoEquipe.CLUBE)
				jogoDLista = jogoTDAO.selVJogoByDistinctOperacional(this.tempAutoPostBack.getCodigoPaisCampeonato(), this.tempAutoPostBack.getCodigoCampeonato(), this.tempAutoPostBack.getAnoInicioTemporada(), this.tempAutoPostBack.getAnoFimTemporada(), "RODADA");
			
			this.jogosoperacionalDLista = new DLista();
			
			//this.cboOpcoesOperacional.addItem("::Selecione uma Opcao");
			
			if (jogoDLista != null) {
				for (int idx=0; idx<jogoDLista.count(); idx++) {
					if (this.selecionaTipoEquipe(this.tempAutoPostBack.getCodigoPaisCampeonato(), this.tempAutoPostBack.getCodigoCampeonato()) == TipoEquipe.SELECAO) {
						VJogoP jogoP = (VJogoP) jogoDLista.get(idx);
						this.jogosoperacionalDLista.addLast(jogoP);
						this.cboOpcoesOperacional.addItem(jogoP.getDescOperacionalJogo());
					}
					if (this.selecionaTipoEquipe(this.tempAutoPostBack.getCodigoPaisCampeonato(), this.tempAutoPostBack.getCodigoCampeonato()) == TipoEquipe.CLUBE) {
						VJogoT jogoT = (VJogoT) jogoDLista.get(idx);
						this.jogosoperacionalDLista.addLast(jogoT);
						this.cboOpcoesOperacional.addItem(jogoT.getDescOperacionalJogo());
					}
				}
			}
			
		}
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Selecionar Combo OpcoesOperacional *****************************************************************************************************
	private boolean selecionaComboOpcoesOperacional() {
	
		boolean opcaooperacionalSelecionada = false;
		
		if (this.selecionaTipoEtapaTorneio(this.tempAutoPostBack.getCodigoPaisCampeonato(), this.tempAutoPostBack.getCodigoCampeonato()) == TipoEtapaTorneio.RODADA_LIGA) {
		
			VJogoPDAO jogoPDAO = new VJogoPDAO();
			VJogoTDAO jogoTDAO = new VJogoTDAO();
			
			DLista jogoDLista = new DLista();
		
			if (this.selecionaTipoEquipe(this.tempAutoPostBack.getCodigoPaisCampeonato(), this.tempAutoPostBack.getCodigoCampeonato()) == TipoEquipe.SELECAO) {
			
				jogoDLista = jogoPDAO.selVJogoByRodadaAtual(this.tempAutoPostBack.getCodigoPaisCampeonato(), this.tempAutoPostBack.getCodigoCampeonato(), this.tempAutoPostBack.getAnoInicioTemporada(), this.tempAutoPostBack.getAnoFimTemporada());
				VJogoP jogoPAux = (VJogoP) jogoDLista.get(0);
			
				for (int idx=0; idx<this.jogosoperacionalDLista.count(); idx++) {
					VJogoP jogoP = (VJogoP) this.jogosoperacionalDLista.get(idx);
					if (jogoPAux.getCodigoRodadaJogo().equals(jogoP.getCodigoOperacionalJogo())) {
						this.cboOpcoesOperacional.setSelectedIndex(idx);
						opcaooperacionalSelecionada = true;
						break;
					}
				}
				
			}
			
			if (this.selecionaTipoEquipe(this.tempAutoPostBack.getCodigoPaisCampeonato(), this.tempAutoPostBack.getCodigoCampeonato()) == TipoEquipe.CLUBE) {
			
				jogoDLista = jogoTDAO.selVJogoByRodadaAtual(this.tempAutoPostBack.getCodigoPaisCampeonato(), this.tempAutoPostBack.getCodigoCampeonato(), this.tempAutoPostBack.getAnoInicioTemporada(), this.tempAutoPostBack.getAnoFimTemporada());
				VJogoT jogoTAux = (VJogoT) jogoDLista.get(0);
			
				for (int idx=0; idx<this.jogosoperacionalDLista.count(); idx++) {
					VJogoT jogoT = (VJogoT) this.jogosoperacionalDLista.get(idx);
					if (jogoTAux.getCodigoRodadaJogo().equals(jogoT.getCodigoOperacionalJogo())) {
						this.cboOpcoesOperacional.setSelectedIndex(idx);
						opcaooperacionalSelecionada = true;
						break;
					}
				}
				
			}
			
		}
		
		return opcaooperacionalSelecionada;
		
	}	
	//********************************************************************************************************************************************
	
	//*** Limpar Combo OutrasMesas ***************************************************************************************************************	
	private void limpaComboOutrasMesas() {
	
		this.cboOutrasMesas.removeAllItems();
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Combo OutrasMesas *************************************************************************************************************
	private void carregaComboOutrasMesas() {
	
		VMesaBolaoDAO mesaDAO = new VMesaBolaoDAO();
		DLista mesaDLista = mesaDAO.selVCompeticoesByUsuario(this.user.getCodigo().trim());
		
		this.outrasmesasDLista = new DLista();
		
		//this.cboOutrasMesas.addItem("::Selecione uma Mesa");
		
		if (mesaDLista != null) {
			for (int idx=0; idx<mesaDLista.count(); idx++) {
				VMesaBolao mesa = (VMesaBolao) mesaDLista.get(idx);
				this.outrasmesasDLista.addLast(mesa);
				this.cboOutrasMesas.addItem(mesa.getNomeMesa());
			}
		}
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Selecionar Combo OutrasMesas ***********************************************************************************************************
	private boolean selecionaComboOutrasMesas() {
	
		boolean mesaSelecionada = false;
		
		for (int idx=0; idx<this.outrasmesasDLista.count(); idx++) {
			VMesaBolao mesaAux = (VMesaBolao) this.outrasmesasDLista.get(idx);
			if (this.mesa.getNomeMesa().equals(mesaAux.getNomeMesa())) {
				this.cboOutrasMesas.setSelectedIndex(idx);
				mesaSelecionada = true;
				break;
			}
		}
		
		return mesaSelecionada;
		
	}	
	//********************************************************************************************************************************************
	
	//*** Limpar Combo OutrosUsuarios ************************************************************************************************************	
	private void limpaComboOutrosUsuarios() {
	
		this.cboOutrosUsuarios.removeAllItems();
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Carregar Combo OutrosUsuarios **********************************************************************************************************	
	private void carregaComboOutrosUsuarios() {
	
		VMesaBolaoDAO mesaDAO = new VMesaBolaoDAO();
		DLista mesaDLista = mesaDAO.selVCompeticoesByMesa(this.mesaAutoPostBack.getNomeMesa().trim());
		
		this.outrosusuariosDLista = new DLista();
		
		//this.cboOutrosUsuarios.addItem("::Selecione uma Mesa");
		
		if (mesaDLista != null) {
			for (int idx=0; idx<mesaDLista.count(); idx++) {
				VMesaBolao mesa = (VMesaBolao) mesaDLista.get(idx);
				this.outrosusuariosDLista.addLast(mesa);
				this.cboOutrosUsuarios.addItem(mesa.getCodigoUsuario());
			}
		}
		
		return;
	
	}
	//********************************************************************************************************************************************
	
	//*** Selecionar Combo OutrosUsuarios ********************************************************************************************************
	private boolean selecionaComboOutrosOutrosUsuarios() {
	
		boolean usuarioSelecionado = false;
		
		for (int idx=0; idx<this.outrosusuariosDLista.count(); idx++) {
			VMesaBolao mesaAux = (VMesaBolao) this.outrosusuariosDLista.get(idx);
			if (this.user.getCodigo().equals(mesaAux.getCodigoUsuario())) {
				this.cboOutrosUsuarios.setSelectedIndex(idx);
				usuarioSelecionado = true;
				break;
			}
		}
		
		return usuarioSelecionado;
		
	}	
	//********************************************************************************************************************************************
	
	//*** Selecionar TipoEquipe ******************************************************************************************************************
	private TipoEquipe selecionaTipoEquipe(String strCodigoPaisCampeonato, String strCodigoCampeonato) {
	
		TipoEquipe tpEquipe = null;
	
		int intCodigoPaisCampeonato = Integer.parseInt(strCodigoPaisCampeonato);
		int intCodigoCampeonato = Integer.parseInt(strCodigoCampeonato);
		
		if ((intCodigoCampeonato >= 901) && (intCodigoCampeonato <= 999))
			tpEquipe = TipoEquipe.SELECAO;
		else
			tpEquipe = TipoEquipe.CLUBE;
			
		return tpEquipe;
		
	}
	//********************************************************************************************************************************************
	
	//*** Selecionar TipoEtapaTorneio ************************************************************************************************************
	private TipoEtapaTorneio selecionaTipoEtapaTorneio(String strCodigoPaisCampeonato, String strCodigoCampeonato) {
	
		TipoEtapaTorneio tpEtapaTorneio = null;
		
		int intCodigoPaisCampeonato = Integer.parseInt(strCodigoPaisCampeonato);
		int intCodigoCampeonato = Integer.parseInt(strCodigoCampeonato);
	
		if ((intCodigoCampeonato >= 1) && (intCodigoCampeonato <= 100))
			tpEtapaTorneio = TipoEtapaTorneio.RODADA_LIGA;
		else
			tpEtapaTorneio = TipoEtapaTorneio.FASE_COPA;
			
		return tpEtapaTorneio;
		
	}
	//********************************************************************************************************************************************
	
	//*** Configurar Exibicao ********************************************************************************************************************
	private void configuraExibicao() {
	
		this.menuitemNovo.setEnabled(true);
		this.menuitemSair.setEnabled(true);
		this.checkitemConectar.setEnabled(true);
		this.checkitemAdministrarTorneios.setEnabled(((this.user != null) && (this.user.getPerfil().equals("1")))? true : false);
		
		this.tbpJBolao.setSelectedIndex(this.intTela);
		this.tbpJBolao.setEnabledAt(TELA_LOGIN, this.intTela == TELA_LOGIN? true : false);
		this.tbpJBolao.setBackgroundAt(TELA_LOGIN, this.intTela == TELA_LOGIN? new Color(185,205,255) : new Color(225,225,225));
		this.tbpJBolao.setEnabledAt(TELA_USUARIO, this.intTela == TELA_USUARIO? true : false);
		this.tbpJBolao.setTitleAt(TELA_USUARIO, this.intTela == TELA_USUARIO? "USUÁRIO::" + this.user.getCodigo().trim() : "USUÁRIO");
		this.tbpJBolao.setBackgroundAt(TELA_USUARIO, this.intTela == TELA_USUARIO? new Color(185,205,255) : new Color(225,225,225));
		this.tbpJBolao.setEnabledAt(TELA_CAMP, this.intTela == TELA_CAMP? true : false);
		this.tbpJBolao.setTitleAt(TELA_CAMP, this.intTela == TELA_CAMP? "CAMPEONATO::" + this.temp.getNomeCampeonato().trim() : "CAMPEONATO");
		this.tbpJBolao.setBackgroundAt(TELA_CAMP, this.intTela == TELA_CAMP? new Color(185,205,255) : new Color(225,225,225));
		this.tbpJBolao.setEnabledAt(TELA_BOLAO, this.intTela == TELA_BOLAO? true : false);
		this.tbpJBolao.setTitleAt(TELA_BOLAO, this.intTela == TELA_BOLAO? "BOLÃO::MESA " + this.mesa.getNomeMesa().trim() : "BOLÃO");
		this.tbpJBolao.setBackgroundAt(TELA_BOLAO, this.intTela == TELA_BOLAO? new Color(255,255,255) : new Color(225,225,225));
		
		if (this.intTela == TELA_LOGIN) {
		
			this.txtNick.setEditable(true);
			
			this.txtPass.setEditable(true);
			
			this.btnLogin.setEnabled(true);
			
		}
		
		if (this.intTela == TELA_USUARIO) {
		
			this.lblUsuario.setText("BENVINDO, " + this.user.getCodigo().trim() + "!");
			
			if (!this.haMesa) {
			
				this.cboCompeticoes.setEnabled(true);
				this.btnMesaBolao.setEnabled(false);
				this.btnAbandonarBolao.setEnabled(false);
				this.cboCompeticoesOwner.setEnabled(true);
				this.txtProcurarAdversario.setEnabled(false);
				this.txtProcurarAdversario.setText("");
				this.btnProcurarAdversario.setEnabled(false);
				this.cboAdversarios.setEnabled(false);
				this.btnConvidarAdversario.setEnabled(false);
				this.cboConvites.setEnabled(true);
				this.btnAceitar.setEnabled(false);
				this.btnRecusar.setEnabled(false);
				
			}
			
			else {
			
				this.cboCompeticoes.setEnabled(this.haMesaCompet? true : false);
				this.btnMesaBolao.setEnabled(this.haMesaCompet? true : false);
				this.btnAbandonarBolao.setEnabled(this.haMesaCompet? true : false);
				this.cboCompeticoesOwner.setEnabled(this.haMesaCompetOwner? true : false);
				this.txtProcurarAdversario.setEnabled(this.haMesaCompetOwner? true : false);
				this.btnProcurarAdversario.setEnabled(this.haMesaCompetOwner? true : false);
				this.cboAdversarios.setEnabled(((this.haMesaCompetOwner) && (this.haBusca))? true : false);
				this.btnConvidarAdversario.setEnabled(((this.haMesaCompetOwner) && (this.haBusca) && (this.haBuscaSelec))? true : false);
				this.cboConvites.setEnabled(this.haMesaConvit? true : false);
				this.btnAceitar.setEnabled(this.haMesaConvit? true : false);
				this.btnRecusar.setEnabled(this.haMesaConvit? true : false);
				
			}
			
			if (!this.haTorneio) {
			
				this.cboTorneioSelec.setEnabled(true);
				this.btnTorneioSelec.setEnabled(false);
				this.cboTorneioNac.setEnabled(true);
				this.cboTorneioInter.setEnabled(true);
				this.btnTorneioClube.setEnabled(false);
				
			}
			
			else {
			
				this.cboTorneioSelec.setEnabled(this.haTorneioSelec? true : false);
				this.btnTorneioSelec.setEnabled(this.haTorneioSelec? true : false);
				this.cboTorneioNac.setEnabled(this.haTorneioNac? true : false);
				this.cboTorneioInter.setEnabled(this.haTorneioInter? true : false);
				this.btnTorneioClube.setEnabled(((this.haTorneioNac) || (this.haTorneioInter))? true : false);
				
			}
			
		}
		
		if (this.intTela == TELA_CAMP) {
		
			if (this.intTelaAux == TELA_TEMP_CAMP_MAIN) {
		
				this.pnlTempCampMain.setVisible(true);
				this.pnlTempCampAlterMain.setVisible(false);
				this.pnlEstatCampMain.setVisible(false);
				this.pnlHistCampMain.setVisible(false);
				this.lblCampeonato.setText(this.temp.getNomeCampeonato().trim() + "::" + this.temp.getAnoInicioTemporada() + "-" + this.temp.getAnoFimTemporada());
				
			}
			
			if (this.intTelaAux == TELA_TEMP_CAMP_ALTER_MAIN) {
		
				this.pnlTempCampMain.setVisible(false);
				this.pnlTempCampAlterMain.setVisible(true);
				this.pnlEstatCampMain.setVisible(false);
				this.pnlHistCampMain.setVisible(false);
				this.lblCampeonato.setText(this.temp.getNomeCampeonato().trim() + "::" + this.temp.getAnoInicioTemporada() + "-" + this.temp.getAnoFimTemporada());
				
			}
			
			if (this.intTelaAux == TELA_ESTAT_CAMP_MAIN) {
		
				this.pnlTempCampMain.setVisible(false);
				this.pnlTempCampAlterMain.setVisible(false);
				this.pnlEstatCampMain.setVisible(true);
				this.pnlHistCampMain.setVisible(false);
				this.lblCampeonato.setText(this.temp.getNomeCampeonato().trim() + "::ESTATÍSTICAS");
				
			}
			
			if (this.intTelaAux == TELA_HIST_CAMP_MAIN) {
			
				this.pnlTempCampMain.setVisible(false);
				this.pnlTempCampAlterMain.setVisible(false);
				this.pnlEstatCampMain.setVisible(false);
				this.pnlHistCampMain.setVisible(true);
				this.lblCampeonato.setText(this.temp.getNomeCampeonato().trim() + "::HISTÓRICO");
				
			}
			
		}
		
		if (this.intTela == TELA_BOLAO) {
		
			if (this.intTelaAux == TELA_PALP_BOLAO_MAIN) {
			
				this.pnlPalpBolaoMain.setVisible(true);
				this.pnlClassBolaoMain.setVisible(false);
				this.lblMesaBolao.setText("MESA " + this.mesa.getNomeMesa().trim() + "::PALPITES");
				
			}
			
			if (this.intTelaAux == TELA_CLASS_BOLAO_MAIN) {
			
				this.pnlPalpBolaoMain.setVisible(false);
				this.pnlClassBolaoMain.setVisible(true);
				this.lblMesaBolao.setText("MESA: " + this.mesa.getNomeMesa().trim() + "::CLASSIFICAÇÃO");
				
			}
			
		}
		
		this.btnVoltar[this.intTela].setEnabled(this.intTela == TELA_LOGIN? false : true);
		
		this.btnAvancar[this.intTela].setEnabled(((this.intTela == TELA_CAMP) || (this.intTela == TELA_BOLAO))? false : true);
		
		return;
		
	}
	//********************************************************************************************************************************************
	
	//*** Metodos de ActionListener **************************************************************************************************************
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == this.menuitemNovo) {
			
			JBolao JB = new JBolao(this.hostConexao);
			JB.setVisible(true);
			
		}
		
		if (ae.getSource() == this.menuitemSair) {
		
			this.salvaINI();			
			this.dispose();
			
		}
		
		if (ae.getSource() == this.btnLogin) {
		
			this.checkitemConectar.setSelected(true);
		
		}
		
		if (ae.getSource() == this.btnMesaBolao) {
		
			if (this.haMesa) {
		
				this.intTela = TELA_BOLAO;
				this.intTelaAux = TELA_PALP_BOLAO_MAIN;
				
				if (this.haMesaCompet) {
				
					int idxCombo = this.cboCompeticoes.getSelectedIndex() - 1;
					this.mesa = (VMesaBolao) this.mesaDListaCompeticoes.get(idxCombo);
					
				}
				
				this.carregaTelaPalpBolao();
				
			}
			
		}
		
		if (ae.getSource() == this.btnAbandonarBolao) {
		
			if (this.haMesa) {
				
				if (this.haMesaCompet) {
				
					String strMensagemAsk = "TEM CERTEZA QUE DESEJA ABANDONAR ESTA MESA?";
					
					int idxDialog = JOptionPane.showConfirmDialog(this, strMensagemAsk, nomeAplicacao, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					
					if (idxDialog == JOptionPane.YES_OPTION) {
					
						boolean b = true;
						int idxCombo = 0;
						String strMensagemNok = null;
						String strMensagemOk = "COMPETIÇÃO DELETADA COM SUCESSO!";
					
						VMesaBolao mesa = null;
					
						idxCombo = this.cboCompeticoes.getSelectedIndex() - 1;
						mesa = (VMesaBolao) this.mesaDListaCompeticoes.get(idxCombo);
						String strMesa = mesa.getNomeMesa();
						
						String strUsuario = this.user.getCodigo();
						
						if (b) {
							CompetidorDAO cmptDAO = new CompetidorDAO();
							Competidor cmpt = new Competidor();
							cmpt.setNomeMesa(strMesa);
							cmpt.setCodigoUsuario(strUsuario);
							if (cmptDAO.delCompetidores(cmpt) == 0) {
								b = false;
								strMensagemNok = Error.getErroAplicacao();
							}
						}
						
						if (b)
							JOptionPane.showMessageDialog(this, strMensagemOk, nomeAplicacao, JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(this, strMensagemNok, nomeAplicacao, JOptionPane.ERROR_MESSAGE);
						
						this.carregaTelaUsuario();
					
					}
					
				}
				
			}
			
		}
		
		if (ae.getSource() == this.btnProcurarAdversario) {
		
			if (this.haMesa) {
			
				if (this.haMesaCompetOwner) {
			
					this.limpaBuscaAdversario();
					this.lblErroAdversario.setVisible(false);
				
					if (this.consisteCamposBuscaAdversario()) {

						if (this.efetuaBuscaAdversario()) {
						
							this.haBusca = true;
							
						}
						
						else {
						
							this.lblErroAdversario.setVisible(true);
							this.haBusca = false;
							
						}
						
					}
					
					else {
					
						this.lblErroAdversario.setVisible(true);
						this.haBusca = false;
						
					}
					
				}
				
			}
			
		}
		
		if (ae.getSource() == this.btnConvidarAdversario) {
		
			if (this.haMesa) {
			
				if (this.haMesaCompetOwner) {
				
					if (this.haBusca) {
					
						if (this.haBuscaSelec) {
						
							boolean b = true;
							int idxCombo = 0;
							String strMensagemNok = null;
							String strMensagemOk = "CONVITE ENVIADO COM SUCESSO!";
							
							VMesaBolaoDAO mesaDAO = new VMesaBolaoDAO();
							VMesaBolao mesa = null;
							Usuario user = null;
						
							idxCombo = this.cboCompeticoesOwner.getSelectedIndex() - 1;
							mesa = (VMesaBolao) this.mesaDListaCompeticoesOwner.get(idxCombo);
							String strMesa = mesa.getNomeMesa();
							
							idxCombo = this.cboAdversarios.getSelectedIndex() - 1;
							user = (Usuario) this.userDListaAdversarios.get(idxCombo);
							String strUsuario = user.getCodigo();
							
							mesa = mesaDAO.selVConvitesByUsuarioMesa(strUsuario, strMesa);
							if (mesa != null) {
								b = false;
								strMensagemNok = "USUARIO SELECIONADO JÁ FOI CONVIDADO À ESTA MESA!";
							}
							
							mesa = mesaDAO.selVCompeticoesByUsuarioMesa(strUsuario, strMesa);
							if (mesa != null) {
								b = false;
								strMensagemNok = "USUARIO SELECIONADO JÁ ESTÁ PARTICIPANDO DESTA MESA!";
							}
							
							if (b) {
								ConvidadoDAO cnvdDAO = new ConvidadoDAO();
								Convidado cnvd = new Convidado();
								cnvd.setNomeMesa(strMesa);
								cnvd.setCodigoUsuario(strUsuario);
								if (cnvdDAO.insConvidados(cnvd) == 0) {
									b = false;
									strMensagemNok = Error.getErroAplicacao();
								}
							}
							
							if (b)
								JOptionPane.showMessageDialog(this, strMensagemOk, nomeAplicacao, JOptionPane.INFORMATION_MESSAGE);
							else
								JOptionPane.showMessageDialog(this, strMensagemNok, nomeAplicacao, JOptionPane.ERROR_MESSAGE);
							
							this.carregaTelaUsuario();
				
						}
						
					}
					
				}
				
			}
			
		}
		
		if (ae.getSource() == this.btnAceitar) {
		
			if (this.haMesa) {
			
				if (this.haMesaConvit) {
				
					boolean b = true;
					int idxCombo = 0;
					String strMensagemNok = null;
					String strMensagemOk = "CONVITE ACEITO COM SUCESSO!";
					
					VMesaBolao mesa = null;
				
					idxCombo = this.cboConvites.getSelectedIndex() - 1;
					mesa = (VMesaBolao) this.mesaDListaConvites.get(idxCombo);
					String strMesa = mesa.getNomeMesa();
					
					String strUsuario = this.user.getCodigo();
					
					if (b) {
						ConvidadoDAO cnvdDAO = new ConvidadoDAO();
						Convidado cnvd = new Convidado();
						cnvd.setNomeMesa(strMesa);
						cnvd.setCodigoUsuario(strUsuario);
						if (cnvdDAO.delConvidados(cnvd) == 0) {
							b = false;
							strMensagemNok = Error.getErroAplicacao();
						}
					}
					
					if (b) {
						CompetidorDAO cmptDAO = new CompetidorDAO();
						Competidor cmpt = new Competidor();
						cmpt.setNomeMesa(strMesa);
						cmpt.setCodigoUsuario(strUsuario);
						cmpt.setPerfilOper("0");
						if (cmptDAO.insCompetidores(cmpt) == 0) {
							b = false;
							strMensagemNok = Error.getErroAplicacao();
						}
					}
					
					if (b)
						JOptionPane.showMessageDialog(this, strMensagemOk, nomeAplicacao, JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(this, strMensagemNok, nomeAplicacao, JOptionPane.ERROR_MESSAGE);
						
					this.carregaTelaUsuario();
				
				}
				
			}
			
		}
		
		if (ae.getSource() == this.btnRecusar) {
		
			if (this.haMesa) {
			
				if (this.haMesaConvit) {
				
					boolean b = true;
					int idxCombo = 0;
					String strMensagemNok = null;
					String strMensagemOk = "CONVITE RECUSADO COM SUCESSO!";
					
					VMesaBolao mesa = null;
				
					idxCombo = this.cboConvites.getSelectedIndex() - 1;
					mesa = (VMesaBolao) this.mesaDListaConvites.get(idxCombo);
					String strMesa = mesa.getNomeMesa();
					
					String strUsuario = this.user.getCodigo();
					
					if (b) {
						ConvidadoDAO cnvdDAO = new ConvidadoDAO();
						Convidado cnvd = new Convidado();
						cnvd.setNomeMesa(strMesa);
						cnvd.setCodigoUsuario(strUsuario);
						if (cnvdDAO.delConvidados(cnvd) == 0) {
							b = false;
							strMensagemNok = Error.getErroAplicacao();
						}
					}
					
					if (b)
						JOptionPane.showMessageDialog(this, strMensagemOk, nomeAplicacao, JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(this, strMensagemNok, nomeAplicacao, JOptionPane.ERROR_MESSAGE);
						
					this.carregaTelaUsuario();
					
				}
				
			}
			
		}
		
		if (ae.getSource() == this.btnTorneioSelec) {
		
			if (this.haTorneio) {
		
				this.intTela = TELA_CAMP;
				if (this.checkitemAdministrarTorneios.isSelected()) 
					this.intTelaAux = TELA_TEMP_CAMP_ALTER_MAIN;
				else
					this.intTelaAux = TELA_TEMP_CAMP_MAIN;
				
				if (this.haTorneioSelec) {
				
					int idxCombo = this.cboTorneioSelec.getSelectedIndex() - 1;
					this.temp = (VTemp) this.tempDListaSelec.get(idxCombo);
				
				}
				
				this.carregaTelaTempCamp();
				
			}
			
		}
		
		if (ae.getSource() == this.btnTorneioClube) {
		
			if (this.haTorneio) {
		
				this.intTela = TELA_CAMP;
				if (this.checkitemAdministrarTorneios.isSelected()) 
					this.intTelaAux = TELA_TEMP_CAMP_ALTER_MAIN;
				else
					this.intTelaAux = TELA_TEMP_CAMP_MAIN;
				
				if (this.haTorneioNac) {
				
					int idxCombo = this.cboTorneioNac.getSelectedIndex() - 1;
					this.temp = (VTemp) this.tempDListaNac.get(idxCombo);
					
				}
				
				if (this.haTorneioInter) {
				
					int idxCombo = this.cboTorneioInter.getSelectedIndex() - 1;
					this.temp = (VTemp) this.tempDListaInter.get(idxCombo);
					
				}
				
				this.carregaTelaTempCamp();
				
			}
			
		}
		
		if (ae.getSource() == this.btnOutrasTemp) {
		
			if (this.checkitemAdministrarTorneios.isSelected()) 
				this.intTelaAux = TELA_TEMP_CAMP_ALTER_MAIN;
			else
				this.intTelaAux = TELA_TEMP_CAMP_MAIN;
		
			int idxCombo = this.cboOutrasTemp.getSelectedIndex();
			this.temp = (VTemp) this.outrastempDLista.get(idxCombo);
		
			this.alteraTelaTempCamp();
			
		}
		
		if (ae.getSource() == this.btnEstat) {
		
			this.temp = this.tempAutoPostBack;
		
			this.intTelaAux = TELA_ESTAT_CAMP_MAIN;
			
			int idxCombo = 0;
			
			String strCodigoRodada = null;
			
			idxCombo = this.cboOpcoesTipo.getSelectedIndex();
			OpcoesEstatisticas optestat = (OpcoesEstatisticas) this.jogostipoDLista.get(idxCombo);
			
			if (this.selecionaTipoEtapaTorneio(this.temp.getCodigoPaisCampeonato(), this.temp.getCodigoCampeonato()) == TipoEtapaTorneio.RODADA_LIGA) {
				if (this.selecionaTipoEquipe(this.temp.getCodigoPaisCampeonato(), this.temp.getCodigoCampeonato()) == TipoEquipe.SELECAO) {
					idxCombo = this.cboOpcoesOperacional.getSelectedIndex();
					VJogoP jogoP = (VJogoP) this.jogosoperacionalDLista.get(idxCombo);
					strCodigoRodada = jogoP.getCodigoOperacionalJogo();
				}
				if (this.selecionaTipoEquipe(this.temp.getCodigoPaisCampeonato(), this.temp.getCodigoCampeonato()) == TipoEquipe.CLUBE) {
					idxCombo = this.cboOpcoesOperacional.getSelectedIndex();
					VJogoT jogoT = (VJogoT) this.jogosoperacionalDLista.get(idxCombo);
					strCodigoRodada = jogoT.getCodigoOperacionalJogo();
				}
			}
			
			this.pnlEstatCampMain.setTemp(this.temp);
			this.pnlEstatCampMain.setOrderField(optestat);
			this.pnlEstatCampMain.setCodigoRodada(strCodigoRodada);
			this.pnlEstatCampMain.carregaTelaEstatCamp();
			
		}
		
		if (ae.getSource() == this.btnListaVenc) {
			
			this.intTelaAux = TELA_HIST_CAMP_MAIN;
			
			this.carregaTelaHistCamp(TipoBusca.LISTA);
			
		}
		
		if (ae.getSource() == this.btnResumoVenc) {
		
			this.intTelaAux = TELA_HIST_CAMP_MAIN;
			
			this.carregaTelaHistCamp(TipoBusca.RESUMO);
			
		}
		
		if (ae.getSource() == this.btnOutrasMesas) {
		
			this.intTelaAux = TELA_PALP_BOLAO_MAIN;
			
			int idxCombo = this.cboOutrasMesas.getSelectedIndex();
			this.mesa = (VMesaBolao) this.outrasmesasDLista.get(idxCombo);
			
			this.alteraTelaPalpBolao();
			
		}
		
		if (ae.getSource() == this.btnOutrosUsuarios) {
			
			this.mesa = this.mesaAutoPostBack;
			
			this.intTelaAux = TELA_PALP_BOLAO_MAIN;
			
			int idxCombo = this.cboOutrosUsuarios.getSelectedIndex();
			VMesaBolao mesa = (VMesaBolao) this.outrosusuariosDLista.get(idxCombo);
			
			this.pnlPalpBolaoMain.setMesaBolao(this.mesa);
			this.pnlPalpBolaoMain.setOutroUsuario(mesa.getCodigoUsuario());
			this.pnlPalpBolaoMain.carregaTelaPalpBolao();
			
		}
		
		if (ae.getSource() == this.btnClassBolao) {
		
			this.intTelaAux = TELA_CLASS_BOLAO_MAIN;
			
			int idxCombo = this.cboOutrasMesas.getSelectedIndex();
			this.mesa = (VMesaBolao) this.outrasmesasDLista.get(idxCombo);
			
			this.carregaTelaClassBolao();
			
		}
		
		if (ae.getSource() == this.btnVoltar[TELA_LOGIN]) {
		
			//Voltar uma Tab da TabbedPane
		
		}
		
		if (ae.getSource() == this.btnAvancar[TELA_LOGIN]) {
		
			this.checkitemConectar.setSelected(true);
		
		}
		
		if (ae.getSource() == this.btnVoltar[TELA_USUARIO]) {
		
			this.checkitemConectar.setSelected(false);
		
		}
		
		if (ae.getSource() == this.btnAvancar[TELA_USUARIO]) {
		
			if (this.haTorneio) {
			
				this.intTela = TELA_CAMP;
				if (this.checkitemAdministrarTorneios.isSelected()) 
					this.intTelaAux = TELA_TEMP_CAMP_ALTER_MAIN;
				else
					this.intTelaAux = TELA_TEMP_CAMP_MAIN;
				
				if (this.haTorneioSelec) {
				
					int idxCombo = this.cboTorneioSelec.getSelectedIndex() - 1;
					this.temp = (VTemp) this.tempDListaSelec.get(idxCombo);
				
				}
				
				if (this.haTorneioNac) {
				
					int idxCombo = this.cboTorneioNac.getSelectedIndex() - 1;
					this.temp = (VTemp) this.tempDListaNac.get(idxCombo);
					
				}
				
				if (this.haTorneioInter) {
				
					int idxCombo = this.cboTorneioInter.getSelectedIndex() - 1;
					this.temp = (VTemp) this.tempDListaInter.get(idxCombo);
					
				}
				
				this.carregaTelaTempCamp();
				
			}
			
		}
		
		if (ae.getSource() == this.btnVoltar[TELA_CAMP]) {
		
			this.intTela = TELA_USUARIO;
		
		}
		
		if (ae.getSource() == this.btnAvancar[TELA_CAMP]) {
		
			//Avancar uma Tab da TabbedPane
			
		}
		
		if (ae.getSource() == this.btnVoltar[TELA_BOLAO]) {
		
			this.intTela = TELA_USUARIO;
			
		}
		
		if (ae.getSource() == this.btnAvancar[TELA_BOLAO]) {
		
			//Avancar uma Tab da TabbedPane
		
		}
		
		this.configuraExibicao();
		
		return;
		
	}
	//********************************************************************************************************************************************
	
	//*** Metodos de ItemListener **************************************************************************************************************
	public void itemStateChanged(ItemEvent ie) {
	
		if (ie.getSource() == this.checkitemConectar) {
		
			if (this.checkitemConectar.isSelected()) {
				
				if (this.consisteCamposLogin()) {
					
					if (this.efetuaLogin()) {
					
						this.lblErroLogin.setVisible(false);
						
						this.intTela = TELA_USUARIO;
						this.carregaTelaUsuario();
						
					}
					
					else {
					
						this.checkitemConectar.setSelected(false);
						this.lblErroLogin.setVisible(true);
						
						this.intTela = TELA_LOGIN;
						
					}
					
				}
				
				else {
				
					this.checkitemConectar.setSelected(false);
					this.lblErroLogin.setVisible(true);
					
					this.intTela = TELA_LOGIN;
				
				}
				
			}
			
			else {
			
				this.intTela = TELA_LOGIN;
				
				this.user = null;
				this.temp = null;
				this.tempAutoPostBack = null;
				this.mesa = null;
				this.mesaAutoPostBack = null;
				this.checkitemAdministrarTorneios.setSelected(false);
				
			}
			
		}
		
		if (ie.getSource() == this.checkitemAdministrarTorneios) {
		
			if (this.checkitemAdministrarTorneios.isSelected()) {

				//Nao faz nada
			
			}
			
			else {
			
				//Nao faz nada
				
			}
			
		}
		
		if (ie.getSource() == this.cboCompeticoes) {
		
			if (ie.getStateChange() == ItemEvent.SELECTED) {
			
				if (this.cboCompeticoes.getSelectedIndex() > 0) {
				
					this.haMesa = true;
					this.haMesaCompet = true;
					
				}
				
			}
				
			else {
			
				this.haMesa = false;
				this.haMesaCompet = false;
				
			}
			
		}
		
		if (ie.getSource() == this.cboCompeticoesOwner) {
		
			if (ie.getStateChange() == ItemEvent.SELECTED) {
			
				if (this.cboCompeticoesOwner.getSelectedIndex() > 0) {
				
					this.haMesa = true;
					this.haMesaCompetOwner = true;
					
				}
				
			}
				
			else {
			
				this.haMesa = false;
				this.haMesaCompetOwner = false;
				
				this.limpaBuscaAdversario();
				this.lblErroAdversario.setVisible(false);
				this.haBusca = false;
				this.haBuscaSelec = false;
				
			}
			
		}
		
		if (ie.getSource() == this.cboAdversarios) {
		
			if (ie.getStateChange() == ItemEvent.SELECTED) {
				
					if (this.cboAdversarios.getSelectedIndex() > 0) {
					
						this.haBuscaSelec = true;
						
					}
					
			}
				
			else {
			
				this.haBuscaSelec = false;
				
			}
			
		}
		
		if (ie.getSource() == this.cboConvites) {
		
			if (ie.getStateChange() == ItemEvent.SELECTED) {
			
				if (this.cboConvites.getSelectedIndex() > 0) {
				
					this.haMesa = true;
					this.haMesaConvit = true;
					
				}
				
			}
				
			else {
			
				this.haMesa = false;
				this.haMesaConvit = false;
				
			}
			
		}
		
		if (ie.getSource() == this.cboTorneioSelec) {
		
			if (ie.getStateChange() == ItemEvent.SELECTED) {
			
				if (this.cboTorneioSelec.getSelectedIndex() > 0) {
				
					this.haTorneio = true;
					this.haTorneioSelec = true;
					
				}
				
			}
				
			else {
			
				this.haTorneio = false;
				this.haTorneioSelec = false;
				
			}
			
		}
		
		if (ie.getSource() == this.cboTorneioNac) {
		
			if (ie.getStateChange() == ItemEvent.SELECTED) {
			
				if (this.cboTorneioNac.getSelectedIndex() > 0) {
				
					this.haTorneio = true;
					this.haTorneioNac = true;
					
				}
			
			}
			
			else {
			
				this.haTorneio = false;
				this.haTorneioNac = false;
				
			}
			
		}
		
		if (ie.getSource() == this.cboTorneioInter) {
		
			if (ie.getStateChange() == ItemEvent.SELECTED) {
			
				if (this.cboTorneioInter.getSelectedIndex() > 0) {
				
					this.haTorneio = true;
					this.haTorneioInter = true;
					
				}
				
			}
			
			else {
			
				this.haTorneio = false;
				this.haTorneioInter = false;
				
			}
			
		}
		
		if (ie.getSource() == this.cboOutrasTemp) {
		
			if (ie.getStateChange() == ItemEvent.SELECTED) {
			
				int idxCombo = this.cboOutrasTemp.getSelectedIndex();
				this.tempAutoPostBack = (VTemp) this.outrastempDLista.get(idxCombo);
				
				this.limpaComboOpcoesTipo();
				this.carregaComboOpcoesTipo();
				boolean opcaotipoSelecionada = this.selecionaComboOpcoesTipo();
				
				this.limpaComboOpcoesOperacional();
				this.carregaComboOpcoesOperacional();
				boolean opcaooperacionalSelecionada = this.selecionaComboOpcoesOperacional();
				
				this.cboOpcoesOperacional.setEnabled((opcaooperacionalSelecionada)? true : false);
				
			}
			
			else {
			
				this.tempAutoPostBack = null;
				
			}
			
		}
		
		if (ie.getSource() == this.cboOpcoesTipo) {
		
			if (ie.getStateChange() == ItemEvent.SELECTED) {
			
				//Nao faz nada
				
			}
			
			else {
			
				//Nao faz nada
				
			}
			
		}
		
		if (ie.getSource() == this.cboOpcoesOperacional) {
		
			if (ie.getStateChange() == ItemEvent.SELECTED) {
			
				//Nao faz nada
				
			}
			
			else {
			
				//Nao faz nada
				
			}
			
		}
		
		if (ie.getSource() == this.cboOutrasMesas) {
		
			if (ie.getStateChange() == ItemEvent.SELECTED) {
			
				int idxCombo = this.cboOutrasMesas.getSelectedIndex();
				this.mesaAutoPostBack = (VMesaBolao) this.outrasmesasDLista.get(idxCombo);
				
				this.limpaComboOutrosUsuarios();
				this.carregaComboOutrosUsuarios();
				boolean usuarioSelecionado = this.selecionaComboOutrosOutrosUsuarios();
				
				this.cboOutrosUsuarios.setEnabled((usuarioSelecionado)? true : false);
				this.btnOutrosUsuarios.setEnabled((usuarioSelecionado)? true : false);
				
			}
			
			else {
			
				this.mesaAutoPostBack = null;
				
			}
			
		}
		
		if (ie.getSource() == this.cboOutrosUsuarios) {
		
			if (ie.getStateChange() == ItemEvent.SELECTED) {
			
				//Nao faz nada
				
			}
			
			else {
			
				//Nao faz nada
				
			}
			
		}
		
		this.configuraExibicao();
		
		return;
		
	}
	//********************************************************************************************************************************************
	
	//*** Metodos de WindowListener ************************************************************************************************************
	public void windowClosing(WindowEvent we) {
		this.menuitemSair.doClick();
	}	
	public void windowClosed(WindowEvent we) {}
	public void windowOpened(WindowEvent we) {}
	public void windowIconified(WindowEvent we) {}
	public void windowDeiconified(WindowEvent we) {}
	public void windowActivated(WindowEvent we) {}
	public void windowDeactivated(WindowEvent we) {}
	//********************************************************************************************************************************************
	
}


