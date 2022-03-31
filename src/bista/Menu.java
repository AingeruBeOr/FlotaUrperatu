package bista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class Menu extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 405, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	
		JPanel north = new JPanel();
		contentPane.add(north, BorderLayout.NORTH);
		
		JLabel JokoIzen = new JLabel("FLOTA URPERATU");
		JokoIzen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		north.add(JokoIzen);
		
		JPanel center = new JPanel();
		contentPane.add(center, BorderLayout.CENTER);
		center.setLayout(new GridLayout(5, 1, 0, 0));
		
		JButton botoi1 = new JButton("Jokoa hasi");
		botoi1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		center.add(botoi1);
		
		JButton botoi2 = new JButton("Ranking ikusi");
		botoi2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		center.add(botoi2);
		
		JButton botoi3 = new JButton("Partida kargatu");
		botoi3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		center.add(botoi3);
		
		JButton botoi4 = new JButton("Arauak ikusi");
		botoi4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		center.add(botoi4);
		
		JButton botoi5 = new JButton("Jokoa itxi");
		botoi5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		center.add(botoi5);
	}

}
