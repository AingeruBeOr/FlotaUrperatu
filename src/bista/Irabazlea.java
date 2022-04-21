package bista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eredua.FlotaUrperatu;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Irabazlea extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel ZORIONAK;
	private JLabel irabazlea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Irabazlea frame = new Irabazlea();
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
	public Irabazlea() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
		setLocationRelativeTo(null);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(3, 1, 0, 0));
			panel.add(getZORIONAK());
			panel.add(getIrabazlea());

		}
		return panel;
	}
	private JLabel getZORIONAK() {
		FlotaUrperatu fu=FlotaUrperatu.getNireFlotaUrperatu();
		if (ZORIONAK == null) {
			if(!fu.getTxanda()) {ZORIONAK = new JLabel("ZORIONAK!!!");}
			else {ZORIONAK = new JLabel("OOOOOOH....");}
			ZORIONAK.setFont(new Font("Wide Latin", Font.BOLD, 40));
			ZORIONAK.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return ZORIONAK;
	}
	private JLabel getIrabazlea() {
		FlotaUrperatu fu=FlotaUrperatu.getNireFlotaUrperatu();
		if (irabazlea == null) {
			if(!fu.getTxanda()) {irabazlea = new JLabel("IRABAZLEA ZARA!!!");}
			else{irabazlea = new JLabel("GALDU DUZU...");}
			irabazlea.setFont(new Font("Wide Latin", Font.PLAIN, 35));
			irabazlea.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return irabazlea;
	}
	
}
