package bista;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class Hasieraketak extends JFrame implements Observer{

	private JPanel contentPane;
	private JPanel center;
	private JPanel right;
	private JPanel north;
	private JLabel label1;
	private JLabel label2;
	private JButton horizontalBotoi;
	private JButton bertikalBotoi;
	private JComboBox comboBox;
	private JPanel south;
	private JLabel labelInstrukzio1;
	private JLabel labelInstrukzio2;
	private JLabel labelInstrukzio3;
	private ArrayList<JLabel> zerrenda;
	private Kontroladore kontroladore;
	private boolean horizontalean;
	private int luzera;
	private JPanel panel1;
	private JLabel aukeratutakoa;
	private JLabel mezuaComboBox;

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
	public Hasieraketak() {
		initialize();
		FlotaUrperatu.getNireFlotaUrperatu().addObserver(this);
		FlotaUrperatu.getNireFlotaUrperatu().hasieratu();
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
		contentPane.add(getSouth(), BorderLayout.SOUTH);
		this.zerrenda = new ArrayList<JLabel>();
		matrizeaSortu();
		setLocationRelativeTo(null);
	}
	
	private void matrizeaSortu() {
		for(int l = 0;l < 10;l++) {
			for(int z = 0;z < 10;z++) {
				JLabel label = getMatrizeGelaxka();
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
			right.add(getPanel1());
			right.add(getAukeratutakoa());
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
	private JPanel getSouth() {
		if (south == null) {
			south = new JPanel();
			south.setLayout(new GridLayout(3, 1, 0, 0));
			south.add(getLabelInstrukzio1());
			south.add(getLabelInstrukzio2());
			south.add(getLabelInstrukzio3());
		}
		return south;
	}
	private JLabel getLabelInstrukzio1() {
		if (labelInstrukzio1 == null) {
			labelInstrukzio1 = new JLabel("GOGORATU: Adierazi itsasontziaren lehenengo gelaxka.");
			labelInstrukzio1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return labelInstrukzio1;
	}
	private JLabel getLabelInstrukzio2() {
		if (labelInstrukzio2 == null) {
			labelInstrukzio2 = new JLabel("Horizontalean hurrengo gelaxkak eskuinerantz jarriko dira.");
			labelInstrukzio2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return labelInstrukzio2;
	}
	private JLabel getLabelInstrukzio3() {
		if (labelInstrukzio3 == null) {
			labelInstrukzio3 = new JLabel("Bertikalean aldiz, beheruntz joango dira.");
			labelInstrukzio3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return labelInstrukzio3;
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
			horizontalBotoi.setBackground(Color.GREEN);
			horizontalBotoi.addActionListener(getKontroladore());
		}
		return horizontalBotoi;
	}
	private JButton getBertikalBotoi() {
		if (bertikalBotoi == null) {
			bertikalBotoi = new JButton("Bertikalean");
			bertikalBotoi.setBackground(Color.GRAY);
			bertikalBotoi.addActionListener(getKontroladore());
		}
		return bertikalBotoi;
	}
	private void mezuaEguneratu() {
		if(horizontalean) aukeratutakoa.setText("Horizontalean jarriko da");
		else aukeratutakoa.setText("Bertikalean jarriko da");
	}
	private JLabel getAukeratutakoa() {
		if (aukeratutakoa == null) {
			aukeratutakoa = new JLabel();
			aukeratutakoa.setHorizontalAlignment(SwingConstants.CENTER);
			mezuaEguneratu();
		}
		return aukeratutakoa;
	}
	private JPanel getPanel1() {
		if (panel1 == null) {
			panel1 = new JPanel();
			panel1.setLayout(new GridLayout(4, 1, 0, 0));
			panel1.add(getMezuaComboBox());
			panel1.add(getComboBox());
		}
		return panel1;
	}
	private JLabel getMezuaComboBox() {
		if (mezuaComboBox == null) {
			mezuaComboBox = new JLabel("Aukeratu itsasontzi bat:");
			mezuaComboBox.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return mezuaComboBox;
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
	private JLabel getMatrizeGelaxka() {
		JLabel matrizeGelaxka = new JLabel("");
		matrizeGelaxka.setOpaque(true);
		matrizeGelaxka.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		matrizeGelaxka.setBackground(Color.BLUE);
		matrizeGelaxka.addMouseListener(getKontroladore());
		return matrizeGelaxka;
	}
	private JLabel getLabel2() {
		if (label2 == null) {
			label2 = new JLabel("Partida hasi baino lehen, zure itsasontzien posizioa zehaztu.");
			label2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return label2;
	}


	
	/********************** KONTROLADOREA ****************************************/
	private Kontroladore getKontroladore() {
		if(kontroladore == null) {
			kontroladore = new Kontroladore();
		}
		return kontroladore;
	}
	
	private class Kontroladore extends MouseAdapter implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String ontzi = comboBox.getSelectedItem().toString();
			if(e.getSource().equals(horizontalBotoi)) {
				horizontalBotoi.setBackground(Color.GREEN);
				bertikalBotoi.setBackground(Color.GRAY);
				horizontalean=true;
			}
			else if(e.getSource().equals(bertikalBotoi)) {
				horizontalBotoi.setBackground(Color.GRAY);
				bertikalBotoi.setBackground(Color.GREEN);
				horizontalean=false;
			}
			else if(ontzi.equals("Hegazkin-ontzia")) {
				luzera=4;
				System.out.println("Luzera: "+luzera);
			}
			else if(ontzi.equals("Itsaspeko1")) {
				luzera=3;
				//TODO
			}
			else if(ontzi.equals("Itsaspeko2")) {
				luzera=3;
				//TODO
			}
			else if(ontzi.equals("Suntzitzailea1")) {
				luzera=2;
				//TODO
			}
			else if(ontzi.equals("Suntzitzailea2")) {
				luzera=2;
				//TODO
			}
			else if(ontzi.equals("Suntzitzailea3")) {
				luzera=2;
				//TODO
			}
			else if(ontzi.equals("Fragata1")) {
				luzera=1;
				//TODO
			}
			else if(ontzi.equals("Fragata2")) {
				luzera=1;
				//TODO
			}
			else if(ontzi.equals("Fragata3")) {
				luzera=1;
				//TODO
			}
			else if(ontzi.equals("Fragata4")) {
				luzera=1;
				//TODO
			}
			mezuaEguneratu();
			// TODO Auto-generated method stub
		}
		
		public void mouseClicked(MouseEvent e) {
			JLabel jl = (JLabel) e.getComponent();
			int index = zerrenda.indexOf(jl);
			int x = index%10;
			int y = index/10;
			FlotaUrperatu fu=FlotaUrperatu.getNireFlotaUrperatu();
			if(luzera!=0 && fu.ontziaKokatuAhalDa(x, y, horizontalean, luzera)) {
				fu.ontziaKokatu(x, y, horizontalean, luzera);
				int kont=luzera;
				int pX=x;
				int pY=y;
				while(kont>0) {
					center.getComponent(pY*10+pX).setBackground(Color.BLACK);
					kont--;
					if(horizontalean) pX++;
					else pY++;
				}
				getComboBox().remove(getComboBox().getSelectedIndex()); //TODO esto hace cosas raras
			}
		}
		
	}
	/*private void ontziaKokatu(int pX, int pY, boolean pHorizontal, int pLuz) {
		System.out.println("Ontzia kokatuko dugu: luzera "+ pLuz+" horizontal "+pHorizontal);
		int kont=pLuz;
		int x=pX;
		int y=pY;
		while(kont>0) {
			System.out.println("Koordenatuak:"+x+" "+y);
			center.getComponent(y*10+x).setBackground(Color.BLACK);
			zerrenda.get(y*10+x).setBackground(Color.BLACK);
			//matrizeGelaxka.setBackground(Color.BLUE);
			kont--;
			if(pHorizontal) {x++;}
			else {y++;}
		}
	}*/
	public void update(Observable arg0, Object arg1) {
		FlotaUrperatu fu = FlotaUrperatu.getNireFlotaUrperatu();
		
		// TODO
	}
}
