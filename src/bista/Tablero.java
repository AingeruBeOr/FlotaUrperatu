package bista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class Tablero extends JFrame {

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
	//Matrize hauek true balioa badute jada bertan misil bat erori da (eta ez da konponketarik egon)
	private boolean[][] jokMatrizeUkitu;
	private boolean[][] botMatrizeUkitu;
	//Matrize hauek true balioa badute ontzia dute barnean
	private boolean[][] jokMatrizeOntzi;
	private boolean[][] botMatrizeOntzi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tablero frame = new Tablero();
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
	public Tablero() {
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getErdia(), BorderLayout.CENTER);
		matrizeaSortu();
		hasieratuMatrizeak();
	}
	private void hasieratuMatrizeak(){
		jokMatrizeUkitu= new boolean[10][10];
		botMatrizeUkitu= new boolean[10][10];
		jokMatrizeOntzi= new boolean[10][10];
		botMatrizeOntzi= new boolean[10][10];
		for(int l = 0;l < 10;l++) {
			for(int z = 0;z < 10;z++) {
				jokMatrizeOntzi[l][z]=false;
				botMatrizeOntzi[l][z]=false;
				jokMatrizeUkitu[l][z]=false;
				botMatrizeUkitu[l][z]=false;
			}
		}
	}
	private void matrizeaSortu() {
		
		for(int l = 0;l < 10;l++) {
			for(int z = 0;z < 10;z++) {
				matrizeEzk.add(getJokLaukia("", z, l));
				matrizeEsk.add(getBotLaukia("", z, l));
			}
		}
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
	private JLabel getJokLaukia(String pMezua, int x, int y) {
		JLabel lauki = new JLabel(pMezua);
		lauki.setOpaque(true);
		lauki.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lauki.setBackground(Color.LIGHT_GRAY);
		lauki.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//Ontzi tamaina aukeratu
				//Posizioa aukeratu
				//Konprobatu ahal den
			}
		});
		return lauki;
	}
	private JLabel getBotLaukia(String pMezua, int x, int y) {
		JLabel lauki = new JLabel(pMezua);
		lauki.setOpaque(true);
		lauki.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lauki.setBackground(Color.LIGHT_GRAY);
		lauki.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				
				//TODO HAY ALGUNA FORMA DE BLOQUEAR LAS CASILLAS?
				//konprobatu arma
					//Misila bada:
						//Aukeratu dezakezu? bot matrizean==false balioa du?
				if(!botMatrizeUkitu[x][y]) {
					botMatrizeUkitu[x][y] = true;
					if(botMatrizeOntzi[x][y]) {
						System.out.println("UKITUA");
						matrizeEsk.getComponent(y*10+x).setBackground(Color.BLACK);
						botMatrizeOntzi[x][y] = false;
						boolean hondoratua=true;
						for(int i = x - 1; i <= x + 1; i++) {
							for(int j = y - 1; j <= y + 1; j++) {
								if(i >= 0 && i < 5 && j >= 0 && j < 5) {
									if(botMatrizeOntzi[x][y]) {hondoratua=false;}
								}
							}
						}
						if (hondoratua) {
							System.out.println("HONDORATUA");
							//Dirua gehitu
						}
						
					}else {
						System.out.println("URA");
						matrizeEsk.getComponent(y*10+x).setBackground(Color.BLUE);
					}
					//Segun zer zegoen mezu bat jarri eta kolorea aldatu + botMatrizea balorean==true
				}else {
					System.out.println("Aukeratu beste lauki bat");
					//Que aparezca otra ventana emergente para que elija otra opcion
					//Beste bat aukeratu
				}
							
					//Misila ez bada:
						//TODO

				
			}
		});
		return lauki;
	}
	
	private JLabel getJok() {
		if (jok == null) {
			jok = new JLabel("JOKALARI FLOTA");
			jok.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jok;
	}
	private JLabel getBot() {
		if (bot == null) {
			bot = new JLabel("BOTAREN FLOTA");
			bot.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return bot;
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
			datuak.setLayout(new GridLayout(15, 2, 0, 0));
		}
		return datuak;
	}
}
