package bista;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import eredua.FlotaUrperatu;


public class Hasieraketak extends JFrame implements Observer{

	private JPanel contentPane;
	private JPanel center;
	private JPanel right;
	private JPanel north;
	private JLabel label1;
	private JLabel label2;
	private JButton horizontalBotoi;
	private JButton bertikalBotoi;
	private JLabel hutsik1;
	private JComboBox comboBox;
	private ArrayList<JLabel> zerrenda;
	private Kontroladore kontroladore;
	private boolean horizontalean;
	int luzera;
	private static Hasieraketak nHasieraketak;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hasieraketak frame = new Hasieraketak();
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
	private Hasieraketak() {
		initialize();
		FlotaUrperatu.getNireFlotaUrperatu().addObserver(this);
	}
	public static Hasieraketak getNireHasieraketak() {
		if(nHasieraketak==null) {
			nHasieraketak= new Hasieraketak();
		}
		return nHasieraketak;
	}
	private void initialize() {
		horizontalean=true; //Defektuz horizontalean jarriko dira itsasontziak
		luzera=0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getCenter(), BorderLayout.CENTER);
		contentPane.add(getRight(), BorderLayout.EAST);
		contentPane.add(getNorth(), BorderLayout.NORTH);
		this.zerrenda = new ArrayList<JLabel>();
		matrizeaSortu();
		setLocationRelativeTo(null);
	}
	
	private void matrizeaSortu() {
		for(int l = 0;l < 10;l++) {
			for(int z = 0;z < 10;z++) {
				JLabel label = getMatrizeGelaxka(z,l);
				center.add(label);
				zerrenda.add(label);
			}
		}
	}

	private JPanel getCenter() {
		if (center == null) {
			center = new JPanel();
			center.setLayout(new GridLayout(10, 10, 0, 0));
		}
		return center;
	}
	private JPanel getRight() {
		if (right == null) {
			right = new JPanel();
			right.setLayout(new GridLayout(5, 1, 0, 0));
			right.add(getComboBox());
			right.add(getHutsik1());
			right.add(getBertikalBotoi());
			right.add(getHorizontalBotoi());
		}
		return right;
	}
	private JPanel getNorth() {
		if (north == null) {
			north = new JPanel();
			north.setLayout(new GridLayout(2, 1, 0, 0));
			north.add(getLabel1());
			north.add(getLabel2());
		}
		return north;
	}
	private JLabel getLabel1() {
		if (label1 == null) {
			label1 = new JLabel("Hasieraketak\r\n");
			label1.setHorizontalAlignment(SwingConstants.CENTER);
			label1.setFont(new Font("Tahoma", Font.BOLD, 27));
		}
		return label1;
	}
	private JButton getHorizontalBotoi() {
		if (horizontalBotoi == null) {
			horizontalBotoi = new JButton("Horizontalean");
		}
		return horizontalBotoi;
	}
	private JButton getBertikalBotoi() {
		if (bertikalBotoi == null) {
			bertikalBotoi = new JButton("Bertikalean");
		}
		return bertikalBotoi;
	}
	private JLabel getHutsik1() {
		if (hutsik1 == null) {
			hutsik1 = new JLabel("");
		}
		return hutsik1;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addItem("Hegazkin-ontzia");
			comboBox.addItem("Itsaspeko1");
			comboBox.addItem("Itsaspeko2");
			comboBox.addItem("Suntzitzailea1");
			comboBox.addItem("Suntzitzailea2");
			comboBox.addItem("Suntzitzailea3");
			comboBox.addItem("Fragata1");
			comboBox.addItem("Fragata2");
			comboBox.addItem("Fragata3");
			comboBox.addItem("Fragata4");
			
			//TODO beste guztiak gehitu
			comboBox.addActionListener(getKontroladore());
		}
		return comboBox;
	}
	private JLabel getMatrizeGelaxka(int x, int y) {

		JLabel matrizeGelaxka = new JLabel("");
		matrizeGelaxka.setOpaque(true);
		matrizeGelaxka.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		matrizeGelaxka.setBackground(Color.BLUE);
		matrizeGelaxka.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				FlotaUrperatu fu=FlotaUrperatu.getNireFlotaUrperatu();
				if(luzera!=0 && fu.ontziaKokatuAhalDa(x, y, horizontalean, luzera)) {
					fu.ontziaKokatu(x, y, horizontalean, luzera);
					Hasieraketak.getNireHasieraketak().ontziaKokatu(x, y, horizontalean, luzera);
					/*switch(luzera){
						case 1:
							//TODO QUITAR LA OPCION DE ESTE BARCO
						break;
						case 2:
							//TODO QUITAR LA OPCION DE ESTE BARCO
						break;
						case 3:
							//TODO QUITAR LA OPCION DE ESTE BARCO
						break;
						case 4:
							//TODO QUITAR LA OPCION DE ESTE BARCO
						break;
					}*/
					luzera=0;
				}
			}
		});
		return matrizeGelaxka;
	}
	private JLabel getLabel2() {
		if (label2 == null) {
			label2 = new JLabel("Partida hasi baino lehen, zure itsasontzien posizioa zehaztu.");
			label2.setHorizontalAlignment(SwingConstants.CENTER);
			/*+
			"GOGORATU: Adierazi itsasontziaren lehenengo gelaxka. \r\n"+
			"Horizontalean hurrengo gelaxkak eskuinerantz jarriko dira. "+
			 "Bertikalean aldiz, beheruntz joango dira"*/
		}
		return label2;
	}
	
	
	//KONTROLADOREA
	private Kontroladore getKontroladore() {
		if(kontroladore == null) {
			kontroladore = new Kontroladore();
		}
		return kontroladore;
	}
	
	private class Kontroladore implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(horizontalBotoi)) {
				horizontalean=true;
			}
			else if(e.getSource().equals(bertikalBotoi)) {
				horizontalean=false;
			}
			else if(e.getSource().equals("Hegazkin-ontzia")) {
				luzera=4;
				System.out.println("Luzera: "+luzera);
				
			}
			else if(e.getSource().equals("Itsaspeko1")) {
				luzera=3;
				//TODO
			}
			else if(e.getSource().equals("Itsaspeko2")) {
				luzera=3;
				//TODO
			}
			else if(e.getSource().equals("Suntzitzailea1")) {
				luzera=2;
				//TODO
			}
			else if(e.getSource().equals("Suntzitzailea2")) {
				luzera=2;
				//TODO
			}
			else if(e.getSource().equals("Suntzitzailea3")) {
				luzera=2;
				//TODO
			}
			else if(e.getSource().equals("Fragata1")) {
				luzera=1;
				//TODO
			}
			else if(e.getSource().equals("Fragata2")) {
				luzera=1;
				//TODO
			}
			else if(e.getSource().equals("Fragata3")) {
				luzera=1;
				//TODO
			}
			else if(e.getSource().equals("Fragata4")) {
				luzera=1;
				//TODO
			}
			// TODO Auto-generated method stub
		}
		
	}
	private void ontziaKokatu(int pX, int pY, boolean pHorizontal, int pLuz) {
		int kont=pLuz;
		int x=pX;
		int y=pY;
		while(pLuz>0) {
			System.out.println("Koordenatuak:"+x+" "+y);
			center.getComponent(y*10+x).setBackground(Color.BLACK);
			kont--;
			if(pHorizontal) {x++;}
			else {y++;}
		}
	}
	public void update(Observable arg0, Object arg1) {
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		
		// TODO
	}
}
