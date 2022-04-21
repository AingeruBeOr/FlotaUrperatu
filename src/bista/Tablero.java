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
	private JLabel info;
	private JPanel datuak;
	private Kontroladore kontroladore;
	private ArrayList<JLabel> zerrendaBot;
	private ArrayList<JLabel> zerrendaJok;
	private JLabel lblArmaAukeratu;
	private JRadioButton rdbtnMisil;
	private JRadioButton rdbtnBonba;
	private JRadioButton rdbtnRadar;
	private JRadioButton rdbtnEzkutu;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel north;
	private JLabel lblTxanda;
	private JPanel south;
	private JLabel lblArazoa;
	private JLabel lblOntziOsoa; 
	private int bonbaKop;
	private int misilKop;
	private int radarKop;
	private int ezkutuKop;
	
	

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
				jokLauki.setBackground(pZ.get(l*10+z).getBackground());
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
			gbl_bErdia.rowHeights = new int[] {40, 460, 0};
			gbl_bErdia.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_bErdia.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			bErdia.setLayout(gbl_bErdia);
			GridBagConstraints gbc_info = new GridBagConstraints();
			gbc_info.fill = GridBagConstraints.BOTH;
			gbc_info.insets = new Insets(0, 0, 5, 0);
			gbc_info.gridx = 0;
			gbc_info.gridy = 0;
			bErdia.add(getInfo(), gbc_info);
			GridBagConstraints gbc_datuak = new GridBagConstraints();
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
	
	private JLabel getInfo() {
		if (info == null) {
			info = new JLabel("INFO");
			info.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return info;
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
			buttonGroup.add(rdbtnBonba);
			rdbtnBonba.setSelected(true); //pantaila kargatzen denean Bonba aukeratu aukeratuta agertuko da.
		}
		return rdbtnBonba;
	}
	private JRadioButton getRdbtnMisil() {
		if (rdbtnMisil == null) {
			rdbtnMisil = new JRadioButton("Misil X" + JokNormal.getNireJok().getArmaKop(new Misil()));
			buttonGroup.add(rdbtnMisil);
		}
		return rdbtnMisil;
	}
	private JRadioButton getRdbtnRadar() {
		if (rdbtnRadar == null) {
			rdbtnRadar = new JRadioButton("Radarra X" + JokNormal.getNireJok().getArmaKop(new Radarra()));
			buttonGroup.add(rdbtnRadar);
		}
		return rdbtnRadar;
	}
	private JRadioButton getRdbtnEzkutu() {
		if (rdbtnEzkutu == null) {
			rdbtnEzkutu = new JRadioButton("Ezkutua X" + JokNormal.getNireJok().getArmaKop(new Ezkutua()));
			buttonGroup.add(rdbtnEzkutu);
		}
		return rdbtnEzkutu;
	}
	private void txandaAldatu(boolean txanda) {
		if(txanda) getLblTxanda().setText("Zure txanda da.");
		else getLblTxanda().setText("Botaren txanda da.");
	}
	private void xJarri(int index) {
		JLabel jl = zerrendaJok.get(index);
		ImageIcon cross = new ImageIcon(this.getClass().getResource("RedCross.png"));
		ImageIcon crossAdj = new ImageIcon(cross.getImage().getScaledInstance(37, 43,Image.SCALE_DEFAULT));
		jl.setIcon(crossAdj);
	}
	private void ezkutuaJarri(int index) {
		JLabel jl = zerrendaJok.get(index);
		ImageIcon ezkutu = new ImageIcon(this.getClass().getResource("Ezkutu1.png"));
		ImageIcon ezkutuAdj = new ImageIcon(ezkutu.getImage().getScaledInstance(37, 43,Image.SCALE_DEFAULT));
		jl.setIcon(ezkutuAdj);
	}
	private void ezkutuBakarraJarri(int index) {
		JLabel jl = zerrendaJok.get(index);
		ImageIcon ezkutu = new ImageIcon(this.getClass().getResource("Ezkutu2.png"));
		ImageIcon ezkutuAdj = new ImageIcon(ezkutu.getImage().getScaledInstance(37, 43,Image.SCALE_DEFAULT));
		jl.setIcon(ezkutuAdj);
	}
	private void nireTableroariIrudiaKendu(int x, int y) {
		String sx = String.valueOf(x);
		String sy = String.valueOf(y);
		String sindex = sy + sx;
		int index = Integer.parseInt(sindex);
		zerrendaJok.get(index).setIcon(null);
		
	}
	private void koordenatuBatenLaukiariKoloreAldaketa(Color c, int x, int y) {
		String sx = String.valueOf(x);
		String sy = String.valueOf(y);
		String sindex = sy + sx;
		int index = Integer.parseInt(sindex);
		zerrendaBot.get(index).setBackground(c);
	}
	
	
	//********************** KONTROLADOREA ****************************************
	private Kontroladore getKontroladore() {
		if(kontroladore == null) {
			kontroladore = new Kontroladore();
		}
		return kontroladore;
	}
	
	
	private class Kontroladore extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			getLblArazoa().setText("");
			getLblOntzia().setText("");
			FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
			JokNormal jokNormal = JokNormal.getNireJok();
			JLabel jl = (JLabel) e.getComponent();
			
			if(rdbtnEzkutu.isSelected()) {
				int index = zerrendaJok.indexOf(jl);
				if(index != -1) {
					int x = index%10;
					int y = index/10;
					jokNormal.ezkutuaJarri(x,y);
				}
				else {
					getLblArazoa().setText("Ezkutua erabiltzeko, zure tableroan klik egin behar duzu.");
				}
			}
			else {
				int index = zerrendaBot.indexOf(jl);
				if(index != -1) {
					int x = index%10;
					int y = index/10;
					if(!jokNormal.ukitutaZegoen(x, y)) { //jadanik puntu horretan tiro egin ez badu
						int arma = 0;
						if(rdbtnMisil.isSelected()) arma=1;
						else if(rdbtnRadar.isSelected()) arma = 2;
						jokNormal.tiroEgin(x, y, arma);
					}
					else {
						getLblArazoa().setText("Puntu hori jadanik ukitu duzu. Mesedez, click egin ukitu ez duzun beste puntu batean.");
					}
				}
				else {
					getLblArazoa().setText("Klik egin botaren tableroaren lauki batean, mesedez.");
				}
			}
			fu.aldatuTxanda();
			if(fu.jokoaAmaituDa()) {
				Irabazlea.main(null);
				setVisible(false);
			}
			else {
				Bot.getNireBot().tiroEgin();
				fu.aldatuTxanda();
				if(fu.jokoaAmaituDa()) {
					Irabazlea.main(null);
					setVisible(false);
				}
			}
		}
	}
	
	
	

	
	
	// ************************************** OBSERVER ************************************************************
	
	/**
	 * Observer-ak jasotzen duena:
	 * Hurrengoak konprobatuko dira:
	 * 		� Txanda aldatu da --> mezua eguneratu
	 * 		� Jokalariak misil gabe --> misil aukeara desgaitu
	 */
	@Override
	public void update(Observable o, Object arg) {
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		if(arg != null) {
			int[] array = (int[]) arg;
			if(array.length == 3 || array.length==4) {
				/*ARRAY-AREN 2. POSIZIOA JARRI BEHARKO ZAION KOLOREA ADIERAZIKO DU:
				 * 0 -> URA ZEN (URDINA)
				 * 1 -> UKITU DU(GORRIA)
				 * 2 -> URPERATU DU (GORRIA+MEZUA)
				 * 3 -> EZKUTU BAT UKITU DU (BERDEA)
				 * 4 -> RADARRAREKIN ITSASONTZIREN BAT UKITU DU (HORIA)
				 * 5 ->
				 * 6 -> 
				 * 7 -> EZKUTUA JARTZEA ERABAKI DU POSIZIO BATEAN ETA ITSASONTZIA BAT DU POSIZIO HORRETAN
				 * 8 -> EZKUTUA JARTZEA ERABAKI DU POSIZIO BATEAN ETA EZ DU ITSASONTZIRIK POSIZIO HORRETAN
				 * */
				switch (array[2]){
				case 0:
					if(fu.getTxanda()) {
						this.koordenatuBatenLaukiariKoloreAldaketa(Color.BLUE, array[0], array[1]);
					}else {
						xJarri(array[0]+ array[1]*10);
					}
					break;
				case 1:
					if(fu.getTxanda()) {
						this.koordenatuBatenLaukiariKoloreAldaketa(Color.RED, array[0], array[1]);
					}else {
						xJarri(array[0]+ array[1]*10);
					}
					break;
				case 2:
					if(fu.getTxanda()) {
						this.koordenatuBatenLaukiariKoloreAldaketa(Color.RED, array[0], array[1]);
						getLblOntzia().setText("Ontzi osoa urperatu duzu!");
					}else {
						xJarri(array[0]+ array[1]*10);
						getLblOntzia().setText("Ontzi osoa urperatu du aurkariak!");
					}
					break;
				case 3:
					if(fu.getTxanda()) {
						this.koordenatuBatenLaukiariKoloreAldaketa(Color.GREEN, array[0], array[1]);
					}else {
						if (array[3]==1) {ezkutuBakarraJarri(array[0]+ array[1]*10);}
						else if(array[3]==0) {nireTableroariIrudiaKendu(array[0], array[1]);}
					}
					break;
				case 4: //radarra erabiliz ontzia aurkitu du
					if(fu.getTxanda()) {
						this.koordenatuBatenLaukiariKoloreAldaketa(Color.YELLOW, array[0], array[1]);
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
					if (fu.getTxanda()) {
						ezkutuaJarri(array[0]+ array[1]*10);
					}
					break;
				case 8:
					getLblArazoa().setText("Klik egin ezazu itsasontzi bat duzun posizioan");
					break;
				case 9:
					getLblArazoa().setText("Jadanik badago ezkutu bat bertan.");
					break;
				case 10:
					getLblArazoa().setText("Ondoratuta dagoen itsasontzi bat aukeratu duzu. Mesedez, aukeratu beste bat.");
					break;
				}
			}
			else if(array.length == 2) { 
				/*
				 * Arrayaren lehenengo posizioa eguneratu beharreko arma mota adierazten du:
				 * 		0 --> Misila
				 * 		1 --> Radarra
				 * 		2 --> Ezkutua
				 * */
				switch(array[0]) {
				case 0:
					getRdbtnMisil().setText("Misil X" + array[1]);
					if(array[1] == 0) {
						getRdbtnMisil().setEnabled(false);
						getRdbtnBonba().setSelected(true);
					}
					break;
				case 1:
					getRdbtnRadar().setText("Radarra X" + array[1]);
					if(array[1] == 0) {
						getRdbtnRadar().setEnabled(false);
						getRdbtnBonba().setSelected(true);
					}
					break;
				case 2:
					getRdbtnEzkutu().setText("Ezkutua X" + array[1]);
					if(array[1] == 0) {
						getRdbtnEzkutu().setEnabled(false);
						getRdbtnBonba().setSelected(true);
					}
					break;
				}
			}
		}
		else if(arg == null) {
			if(fu.getTxanda()) this.txandaAldatu(true);
			else this.txandaAldatu(false);
		}	
	}
}
