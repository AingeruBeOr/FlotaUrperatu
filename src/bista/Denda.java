package bista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;

public class Denda extends JFrame {

	private JPanel contentPane;
	private JPanel center;
	private JPanel north;
	private JLabel lblGoiburua;
	private JLabel lblDirua;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Denda frame = new Denda();
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
	public Denda() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getCenter(), BorderLayout.CENTER);
		contentPane.add(getNorth(), BorderLayout.NORTH);
	}
	private JPanel getCenter() {
		if (center == null) {
			center = new JPanel();
			center.setLayout(new GridLayout(4, 5, 0, 0));
			center.add(getLblNewLabel());
			center.add(getLblNewLabel_1());
			center.add(getLblNewLabel_2());
			center.add(getLblNewLabel_12());
			center.add(getLblNewLabel_3());
			center.add(getLblNewLabel_14());
			center.add(getLblNewLabel_8());
			center.add(getBtnNewButton());
			center.add(getLblNewLabel_19());
			center.add(getBtnNewButton_5());
			center.add(getLblNewLabel_7());
			center.add(getLblNewLabel_9());
			center.add(getBtnNewButton_2());
			center.add(getLblNewLabel_11());
			center.add(getBtnNewButton_1());
			center.add(getLblNewLabel_18());
			center.add(getLblNewLabel_13());
			center.add(getBtnNewButton_4());
			center.add(getLblNewLabel_15());
			center.add(getBtnNewButton_3());
		}
		return center;
	}
	private JPanel getNorth() {
		if (north == null) {
			north = new JPanel();
			north.setLayout(new GridLayout(2, 1, 0, 0));
			north.add(getLblGoiburua());
			north.add(getLblDirua());
		}
		return north;
	}
	private JLabel getLblGoiburua() {
		if (lblGoiburua == null) {
			lblGoiburua = new JLabel("DENDA");
			lblGoiburua.setHorizontalAlignment(SwingConstants.CENTER);
			lblGoiburua.setFont(new Font("Tahoma", Font.PLAIN, 30));
		}
		return lblGoiburua;
	}
	private JLabel getLblDirua() {
		if (lblDirua == null) {
			lblDirua = new JLabel("Dirua:");
			lblDirua.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblDirua.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblDirua;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Arma");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Prezioa");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("Ezkutu");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_7;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("New label");
			lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_8;
	}
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("New label");
			lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_9;
	}
	private JLabel getLblNewLabel_11() {
		if (lblNewLabel_11 == null) {
			lblNewLabel_11 = new JLabel("New label");
			lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_11;
	}
	private JLabel getLblNewLabel_12() {
		if (lblNewLabel_12 == null) {
			lblNewLabel_12 = new JLabel("Erositako kopurua");
			lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_12;
	}
	private JLabel getLblNewLabel_13() {
		if (lblNewLabel_13 == null) {
			lblNewLabel_13 = new JLabel("New label");
			lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_13;
	}
	private JLabel getLblNewLabel_14() {
		if (lblNewLabel_14 == null) {
			lblNewLabel_14 = new JLabel("Misil");
			lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_14;
	}
	private JLabel getLblNewLabel_15() {
		if (lblNewLabel_15 == null) {
			lblNewLabel_15 = new JLabel("New label");
			lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_15;
	}
	private JLabel getLblNewLabel_18() {
		if (lblNewLabel_18 == null) {
			lblNewLabel_18 = new JLabel("Radar");
			lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_18;
	}
	private JLabel getLblNewLabel_19() {
		if (lblNewLabel_19 == null) {
			lblNewLabel_19 = new JLabel("New label");
			lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_19;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("+");
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("-");
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("+");
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("-");
		}
		return btnNewButton_3;
	}
	private JButton getBtnNewButton_4() {
		if (btnNewButton_4 == null) {
			btnNewButton_4 = new JButton("+");
		}
		return btnNewButton_4;
	}
	private JButton getBtnNewButton_5() {
		if (btnNewButton_5 == null) {
			btnNewButton_5 = new JButton("-");
		}
		return btnNewButton_5;
	}
}
