package bista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eredua.Ezkutua;
import eredua.JokNormal;
import eredua.Misil;
import eredua.Radarra;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JLabel lblMisilPrezioa;
	private JLabel lblEzkutuPrezioa;
	private JLabel lblEzkutuKop;
	private JLabel lblNewLabel_12;
	private JLabel lblRadarPrezioa;
	private JLabel lblNewLabel_14;
	private JLabel lblRadarKop;
	private JLabel lblNewLabel_18;
	private JLabel lblMisilKop;
	private JButton btnMisilKendu;
	private JButton btnEzkutuGehitu;
	private JButton btnEzktuKendu;
	private JButton btnRadarGehitu;
	private JButton btnRadarKendu;
	private JButton btnMisilGehitu;
	private JPanel south;
	private JLabel lblTotala;
	private JButton btnErosi;
	private int misilKop;
	private int ezkutuKop;
	private int radarKop;
	private int misilPrezio;
	private int ezkutuPrezio;
	private int radarPrezio;
	private int geratzenDirua;
	private Kontroladore kontroladore;
	private Tablero nagusia;

	/**
	 * Launch the application.
	 */
	public static void main(Tablero pNagusia) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Denda frame = new Denda(pNagusia);
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
	public Denda(Tablero pNagusia) {
		nagusia = pNagusia;
		geratzenDirua = JokNormal.getNireJok().getDirua();
		misilKop = 0;
		ezkutuKop = 0;
		radarKop = 0;
		misilPrezio = new Misil().getPrezioa();
		ezkutuPrezio = new Ezkutua().getPrezioa();
		radarPrezio = new Radarra().getPrezioa();
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 522, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getCenter(), BorderLayout.CENTER);
		contentPane.add(getNorth(), BorderLayout.NORTH);
		contentPane.add(getSouth(), BorderLayout.SOUTH);
		setLocationRelativeTo(null);
	}
	private JPanel getCenter() {
		if (center == null) {
			center = new JPanel();
			GridBagLayout gbl_center = new GridBagLayout();
			gbl_center.columnWidths = new int[] {124, 124, 56, 130, 56, 0};
			gbl_center.rowHeights = new int[]{49, 49, 49, 49, 0};
			gbl_center.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_center.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			center.setLayout(gbl_center);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			center.add(getLblNewLabel(), gbc_lblNewLabel);
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 0;
			center.add(getLblNewLabel_1(), gbc_lblNewLabel_1);
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 2;
			gbc_lblNewLabel_2.gridy = 0;
			center.add(getLblNewLabel_2(), gbc_lblNewLabel_2);
			GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
			gbc_lblNewLabel_12.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_12.gridx = 3;
			gbc_lblNewLabel_12.gridy = 0;
			center.add(getLblNewLabel_12(), gbc_lblNewLabel_12);
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_3.gridx = 4;
			gbc_lblNewLabel_3.gridy = 0;
			center.add(getLblNewLabel_3(), gbc_lblNewLabel_3);
			GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
			gbc_lblNewLabel_14.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_14.gridx = 0;
			gbc_lblNewLabel_14.gridy = 1;
			center.add(getLblNewLabel_14(), gbc_lblNewLabel_14);
			GridBagConstraints gbc_lblMisilPrezioa = new GridBagConstraints();
			gbc_lblMisilPrezioa.fill = GridBagConstraints.BOTH;
			gbc_lblMisilPrezioa.insets = new Insets(0, 0, 5, 5);
			gbc_lblMisilPrezioa.gridx = 1;
			gbc_lblMisilPrezioa.gridy = 1;
			center.add(getLblMisilPrezioa(), gbc_lblMisilPrezioa);
			GridBagConstraints gbc_btnMisilKendu = new GridBagConstraints();
			gbc_btnMisilKendu.fill = GridBagConstraints.BOTH;
			gbc_btnMisilKendu.insets = new Insets(0, 0, 5, 5);
			gbc_btnMisilKendu.gridx = 2;
			gbc_btnMisilKendu.gridy = 1;
			center.add(getBtnMisilKendu(), gbc_btnMisilKendu);
			GridBagConstraints gbc_lblMisilKop = new GridBagConstraints();
			gbc_lblMisilKop.fill = GridBagConstraints.BOTH;
			gbc_lblMisilKop.insets = new Insets(0, 0, 5, 5);
			gbc_lblMisilKop.gridx = 3;
			gbc_lblMisilKop.gridy = 1;
			center.add(getLblMisilKop(), gbc_lblMisilKop);
			GridBagConstraints gbc_btnMisilGehitu = new GridBagConstraints();
			gbc_btnMisilGehitu.fill = GridBagConstraints.BOTH;
			gbc_btnMisilGehitu.insets = new Insets(0, 0, 5, 0);
			gbc_btnMisilGehitu.gridx = 4;
			gbc_btnMisilGehitu.gridy = 1;
			center.add(getBtnMisilGehitu(), gbc_btnMisilGehitu);
			GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
			gbc_lblNewLabel_7.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_7.gridx = 0;
			gbc_lblNewLabel_7.gridy = 2;
			center.add(getLblNewLabel_7(), gbc_lblNewLabel_7);
			GridBagConstraints gbc_lblEzkutuPrezioa = new GridBagConstraints();
			gbc_lblEzkutuPrezioa.fill = GridBagConstraints.BOTH;
			gbc_lblEzkutuPrezioa.insets = new Insets(0, 0, 5, 5);
			gbc_lblEzkutuPrezioa.gridx = 1;
			gbc_lblEzkutuPrezioa.gridy = 2;
			center.add(getLblEzkutuPrezioa(), gbc_lblEzkutuPrezioa);
			GridBagConstraints gbc_btnEzktuKendu = new GridBagConstraints();
			gbc_btnEzktuKendu.fill = GridBagConstraints.BOTH;
			gbc_btnEzktuKendu.insets = new Insets(0, 0, 5, 5);
			gbc_btnEzktuKendu.gridx = 2;
			gbc_btnEzktuKendu.gridy = 2;
			center.add(getBtnEzktuKendu(), gbc_btnEzktuKendu);
			GridBagConstraints gbc_lblEzkutuKop = new GridBagConstraints();
			gbc_lblEzkutuKop.fill = GridBagConstraints.BOTH;
			gbc_lblEzkutuKop.insets = new Insets(0, 0, 5, 5);
			gbc_lblEzkutuKop.gridx = 3;
			gbc_lblEzkutuKop.gridy = 2;
			center.add(getLblEzkutuKop(), gbc_lblEzkutuKop);
			GridBagConstraints gbc_btnEzkutuGehitu = new GridBagConstraints();
			gbc_btnEzkutuGehitu.fill = GridBagConstraints.BOTH;
			gbc_btnEzkutuGehitu.insets = new Insets(0, 0, 5, 0);
			gbc_btnEzkutuGehitu.gridx = 4;
			gbc_btnEzkutuGehitu.gridy = 2;
			center.add(getBtnEzkutuGehitu(), gbc_btnEzkutuGehitu);
			GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
			gbc_lblNewLabel_18.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_18.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_18.gridx = 0;
			gbc_lblNewLabel_18.gridy = 3;
			center.add(getLblNewLabel_18(), gbc_lblNewLabel_18);
			GridBagConstraints gbc_lblRadarPrezioa = new GridBagConstraints();
			gbc_lblRadarPrezioa.fill = GridBagConstraints.BOTH;
			gbc_lblRadarPrezioa.insets = new Insets(0, 0, 0, 5);
			gbc_lblRadarPrezioa.gridx = 1;
			gbc_lblRadarPrezioa.gridy = 3;
			center.add(getLblRadarPrezioa(), gbc_lblRadarPrezioa);
			GridBagConstraints gbc_btnRadarKendu = new GridBagConstraints();
			gbc_btnRadarKendu.fill = GridBagConstraints.BOTH;
			gbc_btnRadarKendu.insets = new Insets(0, 0, 0, 5);
			gbc_btnRadarKendu.gridx = 2;
			gbc_btnRadarKendu.gridy = 3;
			center.add(getBtnRadarKendu(), gbc_btnRadarKendu);
			GridBagConstraints gbc_lblRadarKop = new GridBagConstraints();
			gbc_lblRadarKop.fill = GridBagConstraints.BOTH;
			gbc_lblRadarKop.insets = new Insets(0, 0, 0, 5);
			gbc_lblRadarKop.gridx = 3;
			gbc_lblRadarKop.gridy = 3;
			center.add(getLblRadarKop(), gbc_lblRadarKop);
			GridBagConstraints gbc_btnRadarGehitu = new GridBagConstraints();
			gbc_btnRadarGehitu.fill = GridBagConstraints.BOTH;
			gbc_btnRadarGehitu.gridx = 4;
			gbc_btnRadarGehitu.gridy = 3;
			center.add(getBtnRadarGehitu(), gbc_btnRadarGehitu);
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
			lblDirua = new JLabel("Dirua: " + geratzenDirua);
			lblDirua.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
	private JLabel getLblMisilPrezioa() {
		if (lblMisilPrezioa == null) {
			lblMisilPrezioa = new JLabel(String.valueOf(misilPrezio));
			lblMisilPrezioa.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblMisilPrezioa.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblMisilPrezioa;
	}
	private JLabel getLblEzkutuPrezioa() {
		if (lblEzkutuPrezioa == null) {
			lblEzkutuPrezioa = new JLabel(String.valueOf(ezkutuPrezio));
			lblEzkutuPrezioa.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblEzkutuPrezioa.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblEzkutuPrezioa;
	}
	private JLabel getLblEzkutuKop() {
		if (lblEzkutuKop == null) {
			lblEzkutuKop = new JLabel("0");
			lblEzkutuKop.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblEzkutuKop.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblEzkutuKop;
	}
	private JLabel getLblNewLabel_12() {
		if (lblNewLabel_12 == null) {
			lblNewLabel_12 = new JLabel("Erositako kopurua");
			lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_12;
	}
	private JLabel getLblRadarPrezioa() {
		if (lblRadarPrezioa == null) {
			lblRadarPrezioa = new JLabel(String.valueOf(radarPrezio));
			lblRadarPrezioa.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblRadarPrezioa.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblRadarPrezioa;
	}
	private JLabel getLblNewLabel_14() {
		if (lblNewLabel_14 == null) {
			lblNewLabel_14 = new JLabel("Misil");
			lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_14;
	}
	private JLabel getLblRadarKop() {
		if (lblRadarKop == null) {
			lblRadarKop = new JLabel("0");
			lblRadarKop.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblRadarKop.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblRadarKop;
	}
	private JLabel getLblNewLabel_18() {
		if (lblNewLabel_18 == null) {
			lblNewLabel_18 = new JLabel("Radar");
			lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_18;
	}
	private JLabel getLblMisilKop() {
		if (lblMisilKop == null) {
			lblMisilKop = new JLabel("0");
			lblMisilKop.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblMisilKop.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblMisilKop;
	}
	private JButton getBtnMisilKendu() {
		if (btnMisilKendu == null) {
			btnMisilKendu = new JButton("-");
			btnMisilKendu.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnMisilKendu.addActionListener(getKontroladore());
			btnMisilKendu.setEnabled(false);
		}
		return btnMisilKendu;
	}
	private JButton getBtnEzkutuGehitu() {
		if (btnEzkutuGehitu == null) {
			btnEzkutuGehitu = new JButton("+");
			btnEzkutuGehitu.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnEzkutuGehitu.addActionListener(getKontroladore());
		}
		return btnEzkutuGehitu;
	}
	private JButton getBtnEzktuKendu() {
		if (btnEzktuKendu == null) {
			btnEzktuKendu = new JButton("-");
			btnEzktuKendu.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnEzktuKendu.addActionListener(getKontroladore());
			btnEzktuKendu.setEnabled(false);
		}
		return btnEzktuKendu;
	}
	private JButton getBtnRadarGehitu() {
		if (btnRadarGehitu == null) {
			btnRadarGehitu = new JButton("+");
			btnRadarGehitu.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnRadarGehitu.addActionListener(getKontroladore());
		}
		return btnRadarGehitu;
	}
	private JButton getBtnRadarKendu() {
		if (btnRadarKendu == null) {
			btnRadarKendu = new JButton("-");
			btnRadarKendu.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnRadarKendu.addActionListener(getKontroladore());
			btnRadarKendu.setEnabled(false);
		}
		return btnRadarKendu;
	}
	private JButton getBtnMisilGehitu() {
		if (btnMisilGehitu == null) {
			btnMisilGehitu = new JButton("+");
			btnMisilGehitu.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnMisilGehitu.addActionListener(getKontroladore());
		}
		return btnMisilGehitu;
	}
	private JPanel getSouth() {
		if (south == null) {
			south = new JPanel();
			south.setLayout(new GridLayout(2, 1, 0, 0));
			south.add(getLblTotala());
			south.add(getBtnErosi());
		}
		return south;
	}
	private JLabel getLblTotala() {
		if (lblTotala == null) {
			lblTotala = new JLabel("Totala: ");
			lblTotala.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblTotala.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblTotala;
	}
	private JButton getBtnErosi() {
		if (btnErosi == null) {
			btnErosi = new JButton("Erosi");
		}
		btnErosi.addActionListener(getKontroladore());
		return btnErosi;
	}
	private void eguneratu() {
		int dirua = JokNormal.getNireJok().getDirua();
		int gastatutakoDirua = (misilKop*misilPrezio) + (ezkutuKop*ezkutuPrezio) + (radarKop*radarPrezio);
		geratzenDirua = dirua - (gastatutakoDirua);
		getLblDirua().setText("Dirua: " + geratzenDirua);
		getLblTotala().setText("Totala: "+ gastatutakoDirua);
		
		//botoiak eguneratu:
		if(geratzenDirua < misilPrezio) getBtnMisilGehitu().setEnabled(false);
		else getBtnMisilGehitu().setEnabled(true);
		if(geratzenDirua < ezkutuPrezio) getBtnEzkutuGehitu().setEnabled(false);
		else getBtnEzkutuGehitu().setEnabled(true);
		if(geratzenDirua < radarPrezio) getBtnRadarGehitu().setEnabled(false);
		else getBtnRadarGehitu().setEnabled(true);
	}
	
	
	
	
	
	/************* KONTROLADOREA *****************************/
	private Kontroladore getKontroladore() {
		if(kontroladore == null) {
			kontroladore = new Kontroladore();
		}
		return kontroladore;
	}
	
	private class Kontroladore implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton botoi = (JButton) e.getSource();
			if(botoi.equals(btnMisilKendu)) {
				getLblMisilKop().setText(String.valueOf(--misilKop));
				if(misilKop == 0) botoi.setEnabled(false);
			}
			else if(botoi.equals(btnMisilGehitu)) {
				getLblMisilKop().setText(String.valueOf(++misilKop));
				getBtnMisilKendu().setEnabled(true);
			}
			else if(botoi.equals(btnEzktuKendu)) {
				getLblEzkutuKop().setText(String.valueOf(--ezkutuKop));
				if(ezkutuKop == 0) botoi.setEnabled(false);
			}
			else if(botoi.equals(btnEzkutuGehitu)) {
				getLblEzkutuKop().setText(String.valueOf(++ezkutuKop));
				getBtnEzktuKendu().setEnabled(true);
			}
			else if(botoi.equals(btnRadarKendu)) {
				getLblRadarKop().setText(String.valueOf(--radarKop));
				if(radarKop == 0) botoi.setEnabled(false);
			}
			else if(botoi.equals(btnRadarGehitu)) {
				getLblRadarKop().setText(String.valueOf(++radarKop));
				getBtnRadarKendu().setEnabled(true);
			}
			else if(botoi.equals(btnErosi)) {
				JokNormal.getNireJok().setDirua(geratzenDirua);
				JokNormal.getNireJok().armamentuaErosi(new Misil(), misilKop);
				JokNormal.getNireJok().armamentuaErosi(new Ezkutua(), ezkutuKop);
				JokNormal.getNireJok().armamentuaErosi(new Radarra(), radarKop);
			//TODO
				setVisible(false);
				nagusia.dendaIrekiItxi(false);
			}
			eguneratu();
		}
	}

}
