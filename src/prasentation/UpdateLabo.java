package prasentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.filiere;
import metier.laboratoire;
import persistance.connexion;
import persistance.filiereDao;
import persistance.laboratoireDoa;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class UpdateLabo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldNom;
	private JTextField textFieldEmail;
	private JTextField textFieldResponsable;
	JButton ButtonValider = new JButton("Valider");
	JButton ButtonAnuller = new JButton("Annuler");
	String Id;
	String Nom_l;
	String Email;
	String Id_Responsable;

	private void closing() {
		this.dispose();
	}
	private void executerButtonAnuller() {
		ButtonAnuller.setBounds(109, 196, 81, 23);
		ButtonAnuller.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						controlleur controleur=new controlleur();
						Espace_laboratoire frame= new Espace_laboratoire(controleur);
						frame.show();
						frame.setLocationRelativeTo(null);
						 closing();
						}
						});
		                 
	}
	private void executerButtonValider() {
		ButtonValider.setBounds(316, 196, 73, 23);
		ButtonValider.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						connexion conex=new connexion();
						System.out.println("khadmi 3afaak");
						Id=textFieldId.getText();
						Nom_l=textFieldNom.getText();
						Email=textFieldEmail.getText();
						Id_Responsable=textFieldResponsable .getText();
						laboratoire nouveau=new laboratoire( Id, Nom_l, Email,Id_Responsable);
						laboratoireDoa nouveauDoa=new laboratoireDoa();
						nouveauDoa.update(nouveau);
						controlleur controleur=new controlleur();
						Espace_laboratoire frame= new Espace_laboratoire(controleur);
						frame.show();
						frame.setLocationRelativeTo(null);
						 closing();
						}
						});
		                 
	}

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modifier frame = new Modifier();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public  UpdateLabo () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Entrez les nouvelles informations du laboratoire:");
		lblNewLabel.setBounds(48, 12, 375, 15);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(15, 43, 30, 15);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Nom:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(15, 81, 54, 15);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(15, 116, 54, 15);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		JLabel lblNewLabel_4 = new JLabel("Id_responsable:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(15, 157, 115, 15);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		textFieldId = new JTextField();
		textFieldId.setBounds(153, 38, 236, 20);
		textFieldId.setColumns(10);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(153, 76, 236, 20);
		textFieldNom.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(153, 114, 236, 20);
		textFieldEmail.setColumns(10);
		
		textFieldResponsable = new JTextField();
		textFieldResponsable.setBounds(153, 152, 236, 20);
		textFieldResponsable.setColumns(10);
		
		
		ButtonValider.setForeground(Color.BLACK);
		ButtonValider.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		ButtonAnuller.setForeground(Color.BLACK);
		ButtonAnuller.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_3);
		contentPane.add(lblNewLabel_4);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(textFieldNom);
		contentPane.add(textFieldId);
		contentPane.add(textFieldEmail);
		contentPane.add(textFieldResponsable);
		contentPane.add(ButtonAnuller);
		contentPane.add(ButtonValider);
		this.executerButtonAnuller();
		this.executerButtonValider();
	}

}
