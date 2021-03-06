package bista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import eredua.Bot;
import eredua.FlotaUrperatu;
import eredua.JokNormal;
import eredua.Jokalari;
import eredua.Misil;
import eredua.Bonba;
import eredua.Radarra;
import eredua.Ezkutua;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.*;
import java.util.*;
import bista.Tablero.*;
import java.awt.*;
import java.awt.event.*;

public class Tablero extends JFrame implements Observer{

	private JPanel contentPane;
	private JPanel erdia;
	private JPanel bEzker;
	private JPanel bErdia;
	private JPanel bEskuin;
	private JLabel jok;
	private JLabel bot;
	private JPanel matrizeEzk;
	private JPanel matrizeEsk;
	private JLabel lblDirua;
	private JPanel datuak;
	private Kontroladore kontroladore;
	private ArrayList<JLabel> zerrendaBot;
	private ArrayList<JLabel> zerrendaJok;
	private JLabel lblArmaAukeratu;
	private JRadioButton rdbtnMisil;
	private JRadioButton rdbtnBonba;
	private JRadioButton rdbtnRadar;
	private JRadioButton rdbtnEzkutu;
	private JPanel north;
	private JLabel lblTxanda;
	private JPanel south;
	private JLabel lblArazoa;
	private JLabel lblOntziOsoa; 
	private JRadioButton rdbtnKonponketak;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnDenda;
	
	

	/**
	 * @param: "pZ" hasieraketetan lortu dugun JLabel zerrenda da. 
	 */
	public static void main(ArrayList<JLabel> pZ) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tablero frame = new Tablero(pZ);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tablero(ArrayList<JLabel> pZ) {
		setTitle("Flota Urperatu");
		initialize(pZ);
		FlotaUrperatu.getNireFlotaUrperatu().addObserver(this);
		JokNormal.getNireJok().addObserver(this);
		Bot.getNireBot().addObserver(this);
	}
	
	private void initialize(ArrayList<JLabel> pZ) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getErdia(), BorderLayout.CENTER);
		contentPane.add(getNorth(), BorderLayout.NORTH);
		contentPane.add(getSouth(), BorderLayout.SOUTH);
		this.zerrendaJok = new ArrayList<>();
		this.zerrendaBot = new ArrayList<>();
		matrizeaSortu(pZ);
		setLocationRelativeTo(null);
	}

	private void matrizeaSortu(ArrayList<JLabel> pZ) {
		for(int l = 0;l < 10;l++) {
			for(int z = 0;z < 10;z++) {
				JLabel jokLauki = getJokLaukia();
				if(pZ.get(l*10+z).getBackground().equals(Color.BLUE)) {
					ImageIcon ura = new ImageIcon(this.getClass().getResource("Ura.jpg"));
					ImageIcon uraAdj = new ImageIcon(ura.getImage().getScaledInstance(37, 43,Image.SCALE_DEFAULT));
					jokLauki.setIcon(uraAdj);
				}
				else {
					ImageIcon ura_itsas = new ImageIcon(this.getClass().getResource("Ura_itsasontzi.png"));
					ImageIcon ura_itsasAdj = new ImageIcon(ura_itsas.getImage().getScaledInstance(37, 43,Image.SCALE_DEFAULT));
					jokLauki.setIcon(ura_itsasAdj);
				}
				matrizeEzk.add(jokLauki);
				zerrendaJok.add(jokLauki);
				
				JLabel botlauki = getBotLaukia(); 
				matrizeEsk.add(botlauki);
				zerrendaBot.add(botlauki);
			}
		}
	}
	private JPanel getNorth() {
		if (north == null) {
			north = new JPanel();
			north.add(getLblTxanda());
		}
		return north;
	}
	private JPanel getSouth() {
		if (south == null) {
			south = new JPanel();
			south.add(getLblArazoa());
			south.add(getLblOntzia());   
		}
		return south;
	}
	private JPanel getErdia() {
		if (erdia == null) {
			erdia = new JPanel();
			GridBagLayout gbl_erdia = new GridBagLayout();
			gbl_erdia.columnWidths = new int[] {400, 100, 400, 0};
			gbl_erdia.rowHeights = new int[]{501, 0};
			gbl_erdia.columnWeights = new double[]{0.0, 0.0, 0.0};
			gbl_erdia.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			erdia.setLayout(gbl_erdia);
			GridBagConstraints gbc_bEzker = new GridBagConstraints();
			gbc_bEzker.fill = GridBagConstraints.BOTH;
			gbc_bEzker.insets = new Insets(0, 0, 0, 5);
			gbc_bEzker.gridx = 0;
			gbc_bEzker.gridy = 0;
			erdia.add(getBEzker(), gbc_bEzker);
			GridBagConstraints gbc_bErdia = new GridBagConstraints();
			gbc_bErdia.fill = GridBagConstraints.BOTH;
			gbc_bErdia.insets = new Insets(0, 0, 0, 5);
			gbc_bErdia.gridx = 1;
			gbc_bErdia.gridy = 0;
			erdia.add(getBErdia(), gbc_bErdia);
			GridBagConstraints gbc_bEskuin = new GridBagConstraints();
			gbc_bEskuin.insets = new Insets(0, 0, 0, 5);
			gbc_bEskuin.fill = GridBagConstraints.BOTH;
			gbc_bEskuin.gridx = 2;
			gbc_bEskuin.gridy = 0;
			erdia.add(getBEskuin(), gbc_bEskuin);
		}
		return erdia;
	}
	private JPanel getBEzker() {
		if (bEzker == null) {
			bEzker = new JPanel();
			GridBagLayout gbl_bEzker = new GridBagLayout();
			gbl_bEzker.columnWidths = new int[]{395, 0};
			gbl_bEzker.rowHeights = new int[] {40, 454, 0};
			gbl_bEzker.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_bEzker.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			bEzker.setLayout(gbl_bEzker);
			GridBagConstraints gbc_jok = new GridBagConstraints();
			gbc_jok.fill = GridBagConstraints.BOTH;
			gbc_jok.insets = new Insets(0, 0, 5, 0);
			gbc_jok.gridx = 0;
			gbc_jok.gridy = 0;
			bEzker.add(getJok(), gbc_jok);
			GridBagConstraints gbc_matrizeEzk = new GridBagConstraints();
			gbc_matrizeEzk.fill = GridBagConstraints.BOTH;
			gbc_matrizeEzk.gridx = 0;
			gbc_matrizeEzk.gridy = 1;
			bEzker.add(getMatrizeEzk(), gbc_matrizeEzk);
		}
		return bEzker;
	}
	private JPanel getBErdia() {
		if (bErdia == null) {
			bErdia = new JPanel();
			GridBagLayout gbl_bErdia = new GridBagLayout();
			gbl_bErdia.columnWidths = new int[]{95, 0};
			gbl_bErdia.rowHeights = new int[] {40, 460, 0, 0};
			gbl_bErdia.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_bErdia.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			bErdia.setLayout(gbl_bErdia);
			GridBagConstraints gbc_lblDirua = new GridBagConstraints();
			gbc_lblDirua.fill = GridBagConstraints.BOTH;
			gbc_lblDirua.insets = new Insets(0, 0, 5, 0);
			gbc_lblDirua.gridx = 0;
			gbc_lblDirua.gridy = 0;
			bErdia.add(getLblDirua(), gbc_lblDirua);
			GridBagConstraints gbc_datuak = new GridBagConstraints();
			gbc_datuak.insets = new Insets(0, 0, 5, 0);
			gbc_datuak.fill = GridBagConstraints.BOTH;
			gbc_datuak.gridx = 0;
			gbc_datuak.gridy = 1;
			bErdia.add(getDatuak(), gbc_datuak);
		}
		return bErdia;
	}
	private JPanel getBEskuin() {
		if (bEskuin == null) {
			bEskuin = new JPanel();
			GridBagLayout gbl_bEskuin = new GridBagLayout();
			gbl_bEskuin.columnWidths = new int[]{395, 0};
			gbl_bEskuin.rowHeights = new int[] {40, 454, 0};
			gbl_bEskuin.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_bEskuin.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			bEskuin.setLayout(gbl_bEskuin);
			GridBagConstraints gbc_bot = new GridBagConstraints();
			gbc_bot.fill = GridBagConstraints.BOTH;
			gbc_bot.insets = new Insets(0, 0, 5, 0);
			gbc_bot.gridx = 0;
			gbc_bot.gridy = 0;
			bEskuin.add(getBot(), gbc_bot);
			GridBagConstraints gbc_matrizeEsk = new GridBagConstraints();
			gbc_matrizeEsk.fill = GridBagConstraints.BOTH;
			gbc_matrizeEsk.gridx = 0;
			gbc_matrizeEsk.gridy = 1;
			bEskuin.add(getMatrizeEsk(), gbc_matrizeEsk);
		}
		return bEskuin;
	}
	private JPanel getMatrizeEzk() {
		if (matrizeEzk == null) {
			matrizeEzk = new JPanel();
			matrizeEzk.setLayout(new GridLayout(10, 10, 0, 0));
		}
		return matrizeEzk;
	}
	private JPanel getMatrizeEsk() {
		if (matrizeEsk == null) {
			matrizeEsk = new JPanel();
			matrizeEsk.setLayout(new GridLayout(10, 10, 0, 0));
		}
		return matrizeEsk;
	}
	private JLabel getJokLaukia() {
		JLabel lauki = new JLabel("");
		lauki.setOpaque(true);
		lauki.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lauki.setBackground(Color.LIGHT_GRAY);
		lauki.addMouseListener(getKontroladore());
		return lauki;
	}
	private JLabel getBotLaukia() {
		JLabel lauki = new JLabel("");
		lauki.setOpaque(true);
		lauki.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lauki.setBackground(Color.LIGHT_GRAY);
		lauki.addMouseListener(getKontroladore());
		return lauki;
	}
	
	private JLabel getJok() {
		if (jok == null) {
			jok = new JLabel("JOKALARI FLOTA");
			jok.setFont(new Font("Tahoma", Font.BOLD, 20));
			jok.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jok;
	}
	private JLabel getBot() {
		if (bot == null) {
			bot = new JLabel("BOTAREN FLOTA");
			bot.setFont(new Font("Tahoma", Font.BOLD, 20));
			bot.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return bot;
	}
	private JLabel getLblTxanda() {
		if (lblTxanda == null) {
			lblTxanda = new JLabel("Zure txanda da.");
		}
		return lblTxanda;
	}
	private JLabel getLblArazoa() {
		if (lblArazoa == null) {
			lblArazoa = new JLabel("");
			lblArazoa.setForeground(Color.RED);
		}
		return lblArazoa;
	}
	
	private JLabel getLblOntzia() {		
		if (lblOntziOsoa == null) {
			lblOntziOsoa = new JLabel("");
			lblOntziOsoa.setForeground(Color.GREEN);
		}
		return lblOntziOsoa;
	}
	
	private JLabel getLblDirua() {
		if (lblDirua == null) {
			lblDirua = new JLabel("Dirua: " + JokNormal.getNireJok().getDirua());
			lblDirua.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblDirua;
	}
	private JPanel getDatuak() {
		if (datuak == null) {
			datuak = new JPanel();
			datuak.setLayout(new GridLayout(10, 1, 0, 0));
			datuak.add(getLblArmaAukeratu());
			datuak.add(getRdbtnBonba());
			datuak.add(getRdbtnMisil());
			datuak.add(getRdbtnRadar());
			datuak.add(getRdbtnEzkutu());
			datuak.add(getRdbtnKonponketak());
			datuak.add(getLblNewLabel());
			datuak.add(getLblNewLabel_1());
			datuak.add(getbtnDenda());
		}
		return datuak;
	}
	private JLabel getLblArmaAukeratu() {
		if (lblArmaAukeratu == null) {
			lblArmaAukeratu = new JLabel("Arma mota aukeratu:");
		}
		return lblArmaAukeratu;
	}
	private JRadioButton getRdbtnBonba() {
		if (rdbtnBonba == null) {
			rdbtnBonba = new JRadioButton("Bonba");
			buttonGroup_1.add(rdbtnBonba);
			rdbtnBonba.setSelected(true); //pantaila kargatzen denean Bonba aukeratu aukeratuta agertuko da.
		}
		return rdbtnBonba;
	}
	private JRadioButton getRdbtnMisil() {
		if (rdbtnMisil == null) {
			rdbtnMisil = new JRadioButton();
			updateBtnMisil();
			buttonGroup_1.add(rdbtnMisil);
		}
		return rdbtnMisil;
	}
	private void updateBtnMisil() {
		int kop = JokNormal.getNireJok().getArmaKop(new Misil());
		getRdbtnMisil().setText("Misil X" + kop);
		if(kop == 0) {
			getRdbtnMisil().setEnabled(false);
			getRdbtnBonba().setSelected(true);
		}else getRdbtnMisil().setEnabled(true);
	}
	private JRadioButton getRdbtnRadar() {
		if (rdbtnRadar == null) {
			rdbtnRadar = new JRadioButton();
			updateBtnRadar();
			buttonGroup_1.add(rdbtnRadar);
		}
		return rdbtnRadar;
	}
	private void updateBtnRadar() {
		int kop = JokNormal.getNireJok().getArmaKop(new Radarra());
		getRdbtnRadar().setText("Radarra X" + kop);
		if(kop == 0) {
			getRdbtnRadar().setEnabled(false);
			getRdbtnBonba().setSelected(true);
		}else getRdbtnRadar().setEnabled(true);
	}
	private JRadioButton getRdbtnEzkutu() {
		if (rdbtnEzkutu == null) {
			rdbtnEzkutu = new JRadioButton();
			updateBtnEzkutu();
			buttonGroup_1.add(rdbtnEzkutu);
		}
		return rdbtnEzkutu;
	}
	private void updateBtnEzkutu() {
		int kop = JokNormal.getNireJok().getArmaKop(new Ezkutua());
		getRdbtnEzkutu().setText("Ezkutua X" + kop);
		if(kop == 0) {
			getRdbtnEzkutu().setEnabled(false);
			getRdbtnBonba().setSelected(true);
		}else getRdbtnEzkutu().setEnabled(true);
	}
	private JRadioButton getRdbtnKonponketak() {
		if (rdbtnKonponketak == null) {
			rdbtnKonponketak = new JRadioButton("Konpondu");
			buttonGroup_1.add(rdbtnKonponketak);
		}
		return rdbtnKonponketak;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
		}
		return lblNewLabel_1;
	}
	private JButton getbtnDenda() {
		if (btnDenda == null) {
			btnDenda = new JButton("DENDA");
			btnDenda.setBackground(Color.CYAN);
			btnDenda.addActionListener(getKontroladore());
		}
		return btnDenda;
	}
	private void txandaAldatu(boolean txanda) {
		if(txanda) getLblTxanda().setText("Zure txanda da.");
		else getLblTxanda().setText("Botaren txanda da.");
	}
	private void bistaEzkutatu() {setVisible(false);}
	
	
	
	
	//********************************************IRUDIAK**********************************************************
	
	private void uraJarri(int index) {
		JLabel jl = zerrendaBot.get(index);
		ImageIcon cross = new ImageIcon(this.getClass().getResource("Ura.jpg"));
		ImageIcon crossAdj = new ImageIcon(cross.getImage().getScaledInstance(37, 43,Image.SCALE_DEFAULT));
		jl.setIcon(crossAdj);
	}
	private void uraUkituaJarri(int index, boolean jokTablero) {
		JLabel jl;
		ImageIcon cross = new ImageIcon(this.getClass().getResource("ura_cross.png"));
		ImageIcon crossAdj = new ImageIcon(cross.getImage().getScaledInstance(37, 43,Image.SCALE_DEFAULT));
		if(jokTablero) {
			jl = zerrendaJok.get(index);
			jl.setIcon(crossAdj);
		}else {
			jl = zerrendaBot.get(index);
			jl.setIcon(crossAdj);
		}
	}
	private void itsasontziaIpini(int index, boolean jokTablero) {
		JLabel jl;
		ImageIcon ura_itsas = new ImageIcon(this.getClass().getResource("Ura_itsasontzi.png"));
		ImageIcon ura_itsasAdj = new ImageIcon(ura_itsas.getImage().getScaledInstance(37, 43,Image.SCALE_DEFAULT));
		if(jokTablero) {
			jl = zerrendaJok.get(index);
			jl.setIcon(ura_itsasAdj);
		}else {
			jl = zerrendaBot.get(index);
			jl.setIcon(ura_itsasAdj);
		}
	}
	private void itsasontziariXIpini(int index, boolean jokTablero) {
		JLabel jl;
		ImageIcon x_itsas = new ImageIcon(this.getClass().getResource("Ura_itsasontzi_cross.png"));
		ImageIcon x_itsasAdj = new ImageIcon(x_itsas.getImage().getScaledInstance(37, 43,Image.SCALE_DEFAULT));
		if(jokTablero) {
			jl = zerrendaJok.get(index);
			jl.setIcon(x_itsasAdj);
		}else {
			jl = zerrendaBot.get(index);
			jl.setIcon(x_itsasAdj);
		}
	}
	private void ezkutuBikoitzaJarri(int index) {
		JLabel jl = zerrendaJok.get(index);
		ImageIcon ezk2 = new ImageIcon(this.getClass().getResource("Ura_itsasontzi_ezkutu2.png"));
		ImageIcon ezk2Adj = new ImageIcon(ezk2.getImage().getScaledInstance(37, 43,Image.SCALE_DEFAULT));
		jl.setIcon(ezk2Adj);
	}
	private void ezkutuBakarJarri(int index, boolean jokTablero) {
		JLabel jl;
		ImageIcon ezk1 = new ImageIcon(this.getClass().getResource("Ura_itsasontzi_ezkutu1.png"));
		ImageIcon ezk1Adj = new ImageIcon(ezk1.getImage().getScaledInstance(37, 43,Image.SCALE_DEFAULT));
		if(jokTablero) {
			jl = zerrendaJok.get(index);
			jl.setIcon(ezk1Adj);
		}else {
			jl = zerrendaBot.get(index);
			jl.setIcon(ezk1Adj);
		}
	}
	private void radarraJarri(int index) {
		JLabel jl = zerrendaBot.get(index);
		ImageIcon radar = new ImageIcon(this.getClass().getResource("Ura_radar.jpg"));
		ImageIcon radarAdj = new ImageIcon(radar.getImage().getScaledInstance(37, 43,Image.SCALE_DEFAULT));
		jl.setIcon(radarAdj);
	}
	
	private void urperatutaJarri(int index, boolean jokTablero) {
		JLabel jl;
		ImageIcon boom = new ImageIcon(this.getClass().getResource("Ura_itsasontzi_boom.png"));
		ImageIcon boomAdj = new ImageIcon(boom.getImage().getScaledInstance(37, 43,Image.SCALE_DEFAULT));
		if(jokTablero) {
			jl = zerrendaJok.get(index);
			jl.setIcon(boomAdj);
		}else {
			jl = zerrendaBot.get(index);
			jl.setIcon(boomAdj);
		}
	}
	
	public void dendaIrekiItxi(boolean pIrekiItxi) {
		if(pIrekiItxi) {
			Denda.main(this);
			setEnabled(false);
		}
		else {
			setEnabled(true);
			setVisible(true);
		}
	}
	//********************************************IRUDIEN AMAIERA**********************************************************
	private void diruaEguneratu() {
		getLblDirua().setText("Dirua: " + JokNormal.getNireJok().getDirua());
		//Konponketen botoia bakarrik aukeragarri egongo da dira 75 edo handiagoa bada.
		if(JokNormal.getNireJok().getDirua() < 75) {
			getRdbtnKonponketak().setEnabled(false);
			getRdbtnBonba().setSelected(true);
		}
		else getRdbtnKonponketak().setEnabled(true);
	}
	
	//********************** KONTROLADOREA ****************************************
	private Kontroladore getKontroladore() {
		if(kontroladore == null) {
			kontroladore = new Kontroladore();
		}
		return kontroladore;
	}
	
	
	private class Kontroladore extends MouseAdapter implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btnDenda)) dendaIrekiItxi(true);
		}

		public void mouseClicked(MouseEvent e) {
			getLblArazoa().setText("");
			getLblOntzia().setText("");
			FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
			JokNormal jokNormal = JokNormal.getNireJok();
			JLabel jl = (JLabel) e.getComponent();
			if(rdbtnEzkutu.isSelected() || rdbtnKonponketak.isSelected()) { //true bada, jokalariaren matrizean klik egin behar da
				int index = zerrendaJok.indexOf(jl);
				if(index != -1) {
					int x = index%10;
					int y = index/10;
					if (rdbtnEzkutu.isSelected()) jokNormal.txandaJokatu(x, y, new Ezkutua());
					else if (rdbtnKonponketak.isSelected()) jokNormal.ontziaKonpondu(x, y);
				}
				else getLblArazoa().setText("Klik egin botaren tableroaren lauki batean, mesedez.");
			}
			else { //bestela, bot-aren matrizean klik egin behar du
				int index = zerrendaBot.indexOf(jl);
				if(index != -1) {
					int x = index%10;
					int y = index/10;
					if(!jokNormal.ukitutaZegoen(x, y)) { //jadanik puntu horretan tiro egin ez badu
						if(rdbtnMisil.isSelected()) jokNormal.txandaJokatu(x, y, new Misil());
						else if(rdbtnRadar.isSelected()) jokNormal.txandaJokatu(x, y, new Radarra());
						else jokNormal.txandaJokatu(x, y, new Bonba());
					}
					else getLblArazoa().setText("Puntu hori jadanik ukitu duzu. Mesedez, click egin ukitu ez duzun beste puntu batean.");
				}
				else getLblArazoa().setText("Klik egin botaren tableroaren lauki batean, mesedez.");
			}
			diruaEguneratu();
		}
	}
	
	
	

	
	
	// ************************************** OBSERVER ************************************************************
	
	/**
	 * Hiru parametro mota jaso dezake:
	 * <ol>
	 * 		<li> int[] motako objektua 3 edo 4 posiziekin --> laukiren bat eguneratu behar da. </li>
	 * 		<li> int[] motako objektua 2 posizioekin --> Jokalariaren arma kantitatea eguneratu behar da. </li>
	 * 		<li> null parametro bezala --> txandaren mezua aldatu behar da. </li>
	 * </ol> 
	 */
	@Override
	public void update(Observable o, Object arg) {
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(arg == null) {
			if(fu.getTxanda()) this.txandaAldatu(true);
			else this.txandaAldatu(false);
		}
		else if(arg != null) {
			int[] array = (int[]) arg; //parametro bezala jasotzen den elementua, int motako array bat da.
			if(array.length == 1) bistaEzkutatu();
			else if(array.length == 2) { 
				/*
				 * Arrayaren lehenengo posizioa, eguneratu beharreko arma mota adierazten du:
				 * 		0 --> Misila
				 * 		1 --> Radarra
				 * 		2 --> Ezkutua
				 * Hirugarren aukera, dirua eguneratzeko balio du:
				 * 		3 --> Dirua eguneratu behar da
				 * */
				switch(array[0]) {
				case 0:
					updateBtnMisil();
					break;
				case 1:
					updateBtnRadar();
					break;
				case 2:
					updateBtnEzkutu();
					break;
				case 3:
					diruaEguneratu();
					break;
				}
			}
			if(array.length == 3 || array.length==4|| array.length==5) {
				/*ARRAY-AREN 2. POSIZIOA JARRI BEHARKO ZAION KOLOREA ADIERAZIKO DU:
				 * 0 -> URA UKITU DU (URDINA)
				 * 1 -> ITSASONTZIA UKITU DU (GORRIA)
				 * 2 -> URPERATU DU (GORRIA + MEZUA)
				 * 3 -> EZKUTU BAT UKITU DU (BERDEA)
				 * 4 -> RADARRAREKIN ITSASONTZIREN BAT UKITU DU (HORIA)
				 * 5 ->
				 * 6 -> 
				 * 7 -> EZKUTUA JARTZEA ERABAKI DU POSIZIO BATEAN ETA ITSASONTZIA BAT DU POSIZIO HORRETAN
				 * 8 -> EZKUTUA JARTZEA ERABAKI DU POSIZIO BATEAN ETA EZ DU ITSASONTZIRIK POSIZIO HORRETAN
				 * 9 ->	EZKUTUA JARTZEA ERABAKI DU POSIZIO BATEAN ETA POSIZIO HORRETAN BADAGO ITSASONTZI BAT EZKUTUAREKIN
				 * 10 -> EZKUTUA JARTZEA ERABAKI DU POSIZIO BATEAN ETA POSIZIO HORRETAN URPERATUTA DAGOEN ITSASONTZI BAT DAGO
				 * 11 -> ITSASONTZIA KONPONTZEN DU (jokalari/bot)
				 * 12->	EZIN DU GELAXKA HORI KONPONDU 
				 * */
				String sx = String.valueOf(array[0]);
				String sy = String.valueOf(array[1]);
				String sindex = sy + sx;
				int index = Integer.parseInt(sindex);
				switch (array[2]){
				case 0:
					if(fu.getTxanda()) this.uraJarri(index);
					else this.uraUkituaJarri(index, true);
					break;
				case 1:
					this.itsasontziariXIpini(index, !fu.getTxanda());
					break;
				case 2:
					if(fu.getTxanda()) getLblOntzia().setText("Ontzi osoa urperatu duzu!");
					else getLblOntzia().setText("Ontzi osoa urperatu du aurkariak!");
					this.urperatutaJarri(index, !fu.getTxanda());
					break;
				case 3: //jokalariren bat ezkutua jotzen badu
					if(fu.getTxanda()) {
						//baldin 1 bizitzako ezkutua geratzen bazaio klik egin eta gero:
						if(array[3]==1) { 
							if(array[4]==0)this.ezkutuBakarJarri(index, false);
							getLblOntzia().setText("Ezkutua duen ontzi bat jo duzu.");
						}
						//bizitzarik gabe geratu bada itsaontzia:
						else if(array[3] == 0) {
							if(array[4]==0)this.itsasontziaIpini(index, false);
							//posizioak jadanik irudia badu, lehenen ikutu delako izan da eta posizio hori radarra jarri behar diogu, bakarrik horri
							if (zerrendaBot.get(index).getIcon() != null) this.itsasontziaIpini(index, false);
							getLblOntzia().setText("Itsasontziari ezkutua kendu diozu.");
						}
						else if(array[3] == 2) this.itsasontziaIpini(index,false); 
					}else {
						if (array[3]==1) this.ezkutuBakarJarri(index, true);
						else if(array[3]==0) this.itsasontziaIpini(index, true); 
					}
					break;
				case 4: //radarra erabiliz ontzia aurkitu du
					if(fu.getTxanda()) {
						this.radarraJarri(index);
						getLblOntzia().setText("Ontzia aurkitu duzu!");
					}else {
						//TODO
					}
					break;
				case 5: //ontzi osoa urperatzea bonbak erabiliz (lo dejo??)
					if (fu.getTxanda()) {
						getLblOntzia().setText("Ontzi osoa urperatu duzu!");
						
					}
					else {
						//TODO
					}
					break;
				case 6: //radarra erabiliz EZ du ontzia aurkitu 
					if (fu.getTxanda()) {
						getLblOntzia().setText("Ez duzu ontzirik aurkitu!");
						
					}
					else {
						//TODO
					}
					break;
				case 7:
					if (fu.getTxanda()) this.ezkutuBikoitzaJarri(index);
					break;
				case 8:
					getLblArazoa().setText("Klik egin ezazu itsasontzi bat duzun posizioan");
					break;
				case 9:
					getLblArazoa().setText("Jadanik badago ezkutu bat bertan.");
					break;
				case 10:
					getLblArazoa().setText("Osoa ez dagoen itsasontzi bat aukeratu duzu. Mesedez, aukeratu beste bat.");
					break;
				
				case 11:
				 if (array[3]==0){ //jokalaria
				  	this.itsasontziaIpini(index,true);
				  	getLblOntzia().setText("Konponketa bat egin duzu!");
				  	
				  }
				  else if (array[3]==1){ //bot
				  	this.itsasontziaIpini(index,false);
				  	getLblOntzia().setText("Bot-ak konponketa bat egin du!");
				  }
				  break;
			 
				case 12:
				  getLblArazoa().setText("Ezin duzu gelaxka hori konpondu");
				  break;
				}
				
			}
		}
	}
}
