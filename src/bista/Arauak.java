package bista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class Arauak extends JFrame {

	private JPanel contentPane;
	private JTextArea txtrLoremIpsumDolor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arauak frame = new Arauak();
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
	public Arauak() {
		initialize();
	}
	private void initialize() {
		setTitle("Arauak");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getTxtrLoremIpsumDolor(), BorderLayout.CENTER);
	}

	private JTextArea getTxtrLoremIpsumDolor() {
		if (txtrLoremIpsumDolor == null) {
			txtrLoremIpsumDolor = new JTextArea();
			txtrLoremIpsumDolor.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut luctus dolor quam, vitae\\n lobortis tellus vestibulum ut. Pellentesque at massa interdum lorem pellentesque vulputate. \\n Mauris dapibus blandit nisl quis consequat. Maecenas ut blandit ipsum, vitae molestie\\n nibh. Cras in eleifend diam. In semper, ex ac lacinia blandit, erat urna mollis sem, sit amet finibus quam turpis sit amet tellus. Proin finibus facilisis aliquam. Vestibulum nibh lectus, ornare ut lectus a, egestas pulvinar felis. Curabitur dictum bibendum urna, ut lacinia justo pulvinar sed. Donec suscipit turpis vel tortor tristique tempus. Proin eu vulputate nulla, at rhoncus erat. Duis blandit ipsum erat, in rhoncus tellus egestas in. Aliquam bibendum aliquam neque at dapibus. Mauris quis sollicitudin odio, vel dapibus nibh. Nam vulputate mattis nunc in sagittis.\r\n\r\nDonec vestibulum condimentum porttitor. Quisque tempus, metus eget consequat molestie, nisi ex mattis mi, pellentesque dignissim massa nisl at arcu. Cras elementum libero ut eros ultricies, sed porta elit ullamcorper. Ut interdum suscipit lectus vulputate cursus. Sed et enim sed nisi vehicula porttitor. Duis quis est at lectus cursus aliquet. Mauris eleifend eget magna accumsan ultrices. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Quisque dapibus ligula et dui semper scelerisque. Aliquam gravida ultricies rhoncus. Sed consectetur ullamcorper dolor at laoreet.\r\n\r\nPellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Suspendisse non iaculis turpis, nec dapibus ipsum. Mauris ullamcorper purus at leo iaculis mattis. Nunc nec leo sed nisi ultrices vehicula. Maecenas vel purus mattis, scelerisque enim ut, ultrices leo. Nam ullamcorper est et lorem accumsan euismod. Sed vel tortor nisl. In rutrum rhoncus convallis. Morbi ullamcorper imperdiet purus ac semper. Nam at laoreet risus. Quisque feugiat mollis turpis, ac ultricies sapien tempus et.\r\n\r\nDuis feugiat at quam eu viverra. Donec bibendum, nisl nec auctor egestas, erat arcu commodo mi, id pretium est orci eget nibh. Fusce sit amet elementum velit, eu porttitor lectus. Morbi non ipsum venenatis, efficitur turpis quis, semper libero. Mauris vitae pharetra eros. Ut in dui turpis. Curabitur vehicula ante a est mollis, sed semper felis pellentesque. Cras porta, ligula id ultrices commodo, mi nunc laoreet ante, interdum volutpat dui quam nec massa. Suspendisse accumsan et nisl non dignissim. Praesent imperdiet felis nec odio dictum imperdiet. Nam non lobortis felis.\r\n\r\nOrci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vestibulum dapibus dolor ac tempor suscipit. Praesent semper mollis nisi faucibus vulputate. Nam varius, massa vitae commodo cursus, massa elit cursus augue, ut ultrices elit felis in arcu. Nam pretium velit non neque scelerisque consequat nec vitae libero. Proin auctor nunc in justo dictum, vitae imperdiet arcu cursus. Vestibulum vulputate tortor eget orci scelerisque, vitae congue dui viverra. Praesent fringilla auctor mattis. Nullam id purus at nulla sagittis aliquet quis eget lorem. Nullam id euismod ante. Duis ante ligula, pellentesque at lorem ac, volutpat facilisis tellus. Etiam eget nisl eget nulla venenatis placerat.");
		}
		return txtrLoremIpsumDolor;
	}
}
