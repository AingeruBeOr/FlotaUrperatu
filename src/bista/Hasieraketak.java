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
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Hasieraketak extends JFrame {

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
	}
	private void initialize() {
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
			comboBox.addItem("Suntzitzailea");
			comboBox.addItem("Itsasontzi2");
			//TODO beste guztiak gehitu
			comboBox.addActionListener(getKontroladore());
		}
		return comboBox;
	}
	private JLabel getMatrizeGelaxka() {
		JLabel matrizeGelaxka = new JLabel("");
		matrizeGelaxka.setOpaque(true);
		matrizeGelaxka.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		matrizeGelaxka.setBackground(Color.LIGHT_GRAY);
		return matrizeGelaxka;
	}
	private JLabel getLabel2() {
		if (label2 == null) {
			label2 = new JLabel("Partida hasi baino lehen, zure itsasontzien posizioa zehaztu.");
			label2.setHorizontalAlignment(SwingConstants.CENTER);
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
				//TODO
			}
			else if(e.getSource().equals(bertikalBotoi)) {
				//TODO
			}
			else if(e.getSource().equals("Suntzitzailea")) {
				//TODO
			}
			// TODO Auto-generated method stub
		}
		
	}
}
