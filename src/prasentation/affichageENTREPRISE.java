package prasentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class affichageENTREPRISE extends JFrame{

	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	
	public affichageENTREPRISE() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 680, 471);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Entreprise");
		lblNewLabel.setBounds(10, 11, 132, 25);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("id");
		lblNewLabel_1.setBounds(10, 47, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("raison");
		lblNewLabel_1_1.setBounds(10, 82, 46, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("email");
		lblNewLabel_1_2.setBounds(10, 116, 46, 14);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("idEtape");
		lblNewLabel_1_3.setBounds(10, 154, 46, 14);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("tel");
		lblNewLabel_1_4.setBounds(10, 195, 46, 14);
		getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("codepostal");
		lblNewLabel_1_5.setBounds(10, 239, 46, 14);
		getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("ville");
		lblNewLabel_1_6.setBounds(10, 276, 46, 14);
		getContentPane().add(lblNewLabel_1_6);
		
		textField = new JTextField();
		textField.setBounds(66, 44, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(66, 79, 86, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(66, 113, 86, 20);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(66, 151, 86, 20);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(66, 192, 86, 20);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(66, 273, 86, 20);
		getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(66, 236, 86, 20);
		getContentPane().add(textField_6);
		
		JButton btnajouter = new JButton("+");
		btnajouter.setBounds(215, 309, 41, 23);
		getContentPane().add(btnajouter);
		
		JButton btnmodifier = new JButton("modifier");
		btnmodifier.setBounds(116, 309, 89, 23);
		getContentPane().add(btnmodifier);
		
		JButton btnsupprimer = new JButton("supprimer");
		btnsupprimer.setBounds(10, 309, 89, 23);
		getContentPane().add(btnsupprimer);
		
		JList list = new JList();
		list.setBounds(266, 31, 395, 313);
		getContentPane().add(list);
	}
}
