package bista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;

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
		setTitle("Nola jokatu");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getTxtrLoremIpsumDolor(), BorderLayout.CENTER);
		
		JScrollBar scrollBar = new JScrollBar();
		contentPane.add(scrollBar, BorderLayout.EAST);
	}

	private JTextArea getTxtrLoremIpsumDolor() {
		if (txtrLoremIpsumDolor == null) {
			txtrLoremIpsumDolor = new JTextArea();
			txtrLoremIpsumDolor.setText("Ongi etorri “Flota urperatu” jokora! Zure zortea eta estrategia probatzeko prest zaude? "
									+ "\n "
									+ "\n    Arauak aipatu baino lehen, garrantzitsua da jolasa garatzen den ingurunea aipatzea. "
									+ "\n Borroka bi taula independentez osatutako tablero batean gertatzen da, taula bat "
								  	+ "\n jokalariarentzat eta bestea aurkariarentzat izanda. Gainera, jokalari bakoitzak hamar ontziz "
									+ "\n osatutako flota independente bat du. "
									+ "\n "
									+ "\n    Jolasa hasieratu bezain laster, menu bat ikusiko dugu. \"Joko berria\" aukera hautatu "
									+ "\n ondoren, gure taulan (10x10 tamainakoa) hamar ontzi jartzea beharrezkoa da.\r\n"
									+ "\n "
									+ "\n    \"Hasieraketak\" izeneko leihoa agertuko zaigu, eta bertan ontziak horizontalki eta "
									+ "\n bertikalean kokatu beharko ditugu (aukera hau eskuineko botoietan klik eginez hauta dezakegu, "
									+ "\n berdea unean hautatutako aukera izanik). Jarraian, kokatu nahi dugun itsasontzi mota hautatu "
									+ "\n behar dugu. Hauek dira ontzien ezaugarriak: "
									+ "\n    - Hegazkin-ontzia: lau tarte hartzen dituen itsasontzi bat. "
									+ "\n    - Itsaspekoa: hiru tarte hartzen dituzten bi itsasontzi. "
									+ "\n    - Suntzitzailea: bi tarte hartzen dituzten hiru itsasontzi. "
									+ "\n    - Fragata: tarte bat hartzen duten lau itsasontzi. "
									+ "\n "
									+ "\n"
									+ "\n    Ontzi guztiak kokatu ondoren, tableroa agertuko da gure aurrean. Ezkerrean gure "
									+ "\n itsasoa ikus dezakegu eta eskuinan aurkariarena. Erdian eskura ditugun armak ikus ditzakegu:\r\n"
									+ "\n    - Bonba: posizio bakarra suntsitu dezakete. Bonben kopurua infinitua da."
									+ "\n    - Misila: ontzi bat ikutuz gero, ontzi osoa suntzitzen dute. Misilen kopurua bi da."
									+ "\n    - Radarra: posizio batean kokatuz gero, ingurunean dauden itsasontzien posizioak "
									+ "\n                      ikusiko ditugu. Radarren kopurua bi da."
									+ "\n    - Ezkutua: gainerako tresnak ez bezala, ezkutua gure taula gainean jarri behar da, eta"
									+ "\n                      honek ontzia babesten du misil batetik edo bi bonbetatik. Ezkutuen kopurua bi da."
									+ "\n"
									+ "\n    Kontuan hartu beharreko oinarrizko kontzeptu batzuk ezagututa, jolasa nola garatzen "
									+ "\n den hitz egitera pasa gaitezke. Txandaka, jokalari bakoitzak bere aurkariaren tableroan tiro egin"
									+ "\n behar du posizio batean, erabili nahi duen arma aldez aurretik aukeratuz. Izan ere, Ezkutuaren"
									+ "\n kasuan, jokalariak bere tableroan dagoen ontzi baten gainean kokatu egin behar du tresna hau."
									+ "\n Hau egin ondoren, hainbat gauza gerta daiteke."
									+ "\n"
									+ "\n    Alde batetik, bonba bat erabiliz, ontzi bat ikutuz gero, ikutu dugun posizioan X gorria"
									+ "\n duen itsasontzi bat agertuko da eta tarte bateko itsasontzia izanez gero “Ontzi osoa urperatu"
									+ "\n duzu!” mezua agertuko zaigu pantailan. Misil bat erabiliz gero, bonbekin ez bezala, itsasontzi"
									+ "\n osoa hondoratu egingo da. Bestalde, ezkutu bat ikutuz gero, ezkutu baten ikono morea agertuko"
									+ "\n zaigu pantailan itsasontziaren gainean. Bonba batekin berriro emanez gero, ezkutua"
									+ "\n desagertuko da, baina ontzia ez da hondoratuko. Misil bat erabiliz gero, ordea, ontzia suntsituko"
									+ "\n da. Bukatzeko, tirokatutako posizioan ura egonez gero, posizioan ura  ikusiko dugu bakarrik."
									+ "\n"
									+ "\n    Bonbak eta misilak erabiltzeaz gain, radarrak ere erabili ahal ditugu gure aukariaren"
									+ "\n tableroaren gainean. Aukeratutako posizioan edo ingurunekoetan itsasontzirik egonez gero,"
									+ "\n hauek okupatzen dituzten laukientan radar bat ikusiko dugu uraren gaienan, eta “Ontzia aurkitu"
									+ "\n duzu!” mezua agertuko zaigu. Ingurunean itsasontzirik ez badago, ordea, ura agertuko zaigu"
									+ "\n tableroan, eta aurkariaren txanda izango da."
									+ "\n "
									+ "\n Bukatzeko, ezkutuak erabili ahal ditugu gure itsasontziak babesteko. Ezkutua aukeratuz"
									+ "\n gero babestu nahi dugun itsasontziaren gainean klikatu egin behar dugu. Itsasontziaren"
									+ "\n gaienean kolore moreko ezkutu baten ikonoa agertuko zaigu, bere barnean izar bat duena."
									+ "\n Aurkariak bonba batekin ezkutua joz gero, izartxoa desagertuko da, eta bakarrik ezkutuaren"
									+ "\n silueta agertuko zaigu itsasontziaren gainean. Berriro erasotua izanez gero, ordea, ezkutua"
									+ "\n hautsiko da, eta gure ontziak babes hori galduko du."
									+ "\n "
									+ "\n    Aurkariaren itsasoan ezkutu bat ikutuz gero, hautatutako posizioan ezkutu baten ikonoa"
									+ "\n agertuko zaigu (ezkutu batek hor egoteak bertan itsasontzi bat dagoela adierazi nahi du). "
									+ "\n Ezkutuaren bizitza eta iraupena berdina izango da jokalari guztientzat."
									+ "\n "
									+ "\n "
									+ "\n "
									+ "\n Jokoaren helburu nagusia, bere izenak adierazten duen bezala, etsaiaren flota"
									+ "\n hondoratzea da. Horretarako, estrategia bat garatu behar dugu gure armak eta asmamena ahalik"
									+ "\n eta modu eraginkorrenean erabiliz." );
		
		}
		return txtrLoremIpsumDolor;
	}
	
	
	
	// Scroll Bar
	/*
	   	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		
		if(e.getSource()== rojo)
		{
			crojo= rojo.getValue();	
		}
		if(e.getSource()== verde)
		{
			cverde= verde.getValue();
		}
		if(e.getSource()== azul)
		{
			cazul= azul.getValue();
		}
		mostrar();
		
		
	}
	public void mostrar()
	{
		getContentPane().setBackground( new Color( crojo,cverde,cazul));
		lRojo.setText(" Rojo ="+rojo.getValue());
		lVerde.setText(" Verde ="+verde.getValue());
		lAzul.setText(" Azul ="+azul.getValue());
	}
	public static void main(String args[])
	{
		Barras x;
		x = new Barras();
	}
	  
	 
	 */
	
	
}
