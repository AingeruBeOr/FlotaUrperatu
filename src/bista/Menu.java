package bista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JPanel center;
	private JPanel north;
	private JLabel JokoIzen;
	private JButton botoi1;
	private JButton botoi2;
	private JButton botoi3;
	private JButton botoi4;
	private JButton botoi5;
	private Kontroladore kontroladore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getCenter(), BorderLayout.CENTER);
		contentPane.add(getNorth(), BorderLayout.NORTH);
		setLocationRelativeTo(null);
	}

	private JPanel getCenter() {
		if (center == null) {
			center = new JPanel();
			center.setLayout(new GridLayout(5, 1, 0, 0));
			center.add(getBotoi1());
			center.add(getBotoi2());
			center.add(getBotoi3());
			center.add(getBotoi4());
			center.add(getBotoi5());
		}
		return center;
	}
	private JPanel getNorth() {
		if (north == null) {
			north = new JPanel();
			north.add(getJokoIzen());
		}
		return north;
	}
	private JLabel getJokoIzen() {
		if (JokoIzen == null) {
			JokoIzen = new JLabel("FLOTA URPERATU");
			JokoIzen.setFont(new Font("Brush Script MT", Font.PLAIN, 40));
		}
		return JokoIzen;
	}
	private JButton getBotoi1() {
		if (botoi1 == null) {
			botoi1 = new JButton("Joko berria");
			botoi1.setFont(new Font("Tahoma", Font.PLAIN, 25));
			botoi1.addActionListener(getKontroladore());
		}
		return botoi1;
	}
	private JButton getBotoi2() {
		if (botoi2 == null) {
			botoi2 = new JButton("Partida kargatu");
			botoi2.setFont(new Font("Tahoma", Font.PLAIN, 25));
			botoi2.addActionListener(getKontroladore());
			botoi2.setEnabled(false); //TODO kendu behar de funtzioa inplementatzerakoan
		}
		return botoi2;
	}
	private JButton getBotoi3() {
		if (botoi3 == null) {
			botoi3 = new JButton("Ranking ikusi");
			botoi3.setFont(new Font("Tahoma", Font.PLAIN, 25));
			botoi3.addActionListener(getKontroladore());
			botoi3.setEnabled(false); //TODO kendu behar de funtzioa inplementatzerakoan
		}
		return botoi3;
	}
	private JButton getBotoi4() {
		if (botoi4 == null) {
			botoi4 = new JButton("Arauak ikusi");
			botoi4.setFont(new Font("Tahoma", Font.PLAIN, 25));
			botoi4.addActionListener(getKontroladore());
			botoi4.setEnabled(false); //TODO kendu behar de funtzioa inplementatzerakoan
		}
		return botoi4;
	}
	private JButton getBotoi5() {
		if (botoi5 == null) {
			botoi5 = new JButton("Atera");
			botoi5.setFont(new Font("Tahoma", Font.PLAIN, 25));
			botoi5.addActionListener(getKontroladore());
		}
		return botoi5;
	}
	
	//Kontroladore//
	private Kontroladore getKontroladore() {
		if(kontroladore == null) {
			kontroladore = new Kontroladore();
		}
		return kontroladore;
	}
	
	private class Kontroladore implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(botoi1)) {
				Hasieraketak.main(null);
				setVisible(false);
			}
			else if(e.getSource().equals(botoi2)) {
				//TODO
			}
			else if(e.getSource().equals(botoi3)) {
				//TODO
			}
			else if(e.getSource().equals(botoi4)) {
				//TODO
			}
			else {
				System.exit(0);
			}			
		}
	}
}