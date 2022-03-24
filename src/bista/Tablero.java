package bista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
	private JPanel gohia;
	private JPanel erdia;
	private JPanel bEzker;
	private JPanel bErdia;
	private JPanel bEskuin;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;

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
		contentPane.add(getGohia(), BorderLayout.NORTH);
		contentPane.add(getErdia(), BorderLayout.CENTER);
		matrizeaSortu();
	}
	private void matrizeaSortu() {
		
		for(int l=0;l<10;l++) {
			for(int z=0;z<10;z++) {
				bEskuin.add(getLaukia(""));
				bEzker.add(getLaukia(""));
			}
		}
}
	private JPanel getGohia() {
		if (gohia == null) {
			gohia = new JPanel();
			gohia.add(getLblNewLabel_1());
			gohia.add(getLblNewLabel());
			gohia.add(getLblNewLabel_2());
		}
		return gohia;
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
			bEzker.setLayout(new GridLayout(10, 10, 0, 0));
		}
		return bEzker;
	}
	private JPanel getBErdia() {
		if (bErdia == null) {
			bErdia = new JPanel();
			bErdia.setLayout(new GridLayout(15, 2, 0, 0));
		}
		return bErdia;
	}
	private JPanel getBEskuin() {
		if (bEskuin == null) {
			bEskuin = new JPanel();
			bEskuin.setLayout(new GridLayout(10, 10, 0, 0));
		}
		return bEskuin;
	}
	private JLabel getLaukia(String pMezua) {
		JLabel lauki = new JLabel(pMezua);
		lauki.setOpaque(true);
		lauki.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lauki.setBackground(Color.CYAN);
		lauki.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		return lauki;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("JOKALARI FLOTA  ");
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("INFO  ");
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("BOTAREN FLOTA  ");
		}
		return lblNewLabel_2;
	}
}
