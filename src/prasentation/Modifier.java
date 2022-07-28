package prasentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.filiere;
import persistance.connexion;
import persistance.filiereDao;

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

public class Modifier extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldNom;
	private JTextField textFieldCoordinateur;
	private JTextField textFieldDepartement;
	JButton ButtonValider = new JButton("Valider");
	JButton ButtonAnuller = new JButton("Annuler");
	String Id_filiere;
	String Nom_F;
	String Id_coordinateu;
	String Id_deparetement;

	private void closing() {
		this.dispose();
	}
	private void executerButtonAnuller() {
		ButtonAnuller.setBounds(112, 203, 81, 23);
		ButtonAnuller.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						controlleur controleur=new controlleur();
						Espace_filiere frame= new Espace_filiere(controleur);
						frame.show();
						 closing();
						}
						});
		                 
	}
	private void executerButtonValider() {
		ButtonValider.setBounds(327, 203, 73, 23);
		ButtonValider.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						connexion conex=new connexion();
						if (conex != null) {
							System.out.println("Database Connected successfully");
						} else {
							System.out.println("Database Connection failed");
						}
						System.out.println("khadmi 3afaak");
						Id_filiere=textFieldId.getText();
						Nom_F=textFieldNom.getText();
						Id_coordinateu=textFieldCoordinateur.getText();
						Id_deparetement=textFieldDepartement .getText();
						filiere nouveau=new filiere( Id_filiere, Nom_F,  Id_coordinateu,Id_deparetement);
						filiereDao nouveauDoa=new filiereDao();
						nouveauDoa.update(nouveau);
						controlleur controleur=new controlleur();
						Espace_filiere frame= new Espace_filiere(controleur);
						frame.show();
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
	public Modifier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Entrez les nouvelles informations de votre fili\u00E9re");
		lblNewLabel.setBounds(58, 12, 431, 21);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(15, 49, 64, 15);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		
		JLabel lblNewLabel_2 = new JLabel("Nom:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(15, 87, 64, 15);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		
		JLabel lblNewLabel_3 = new JLabel("Id_coordinateur:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(15, 122, 125, 15);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		
		JLabel lblNewLabel_4 = new JLabel("Id_Departement:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(15, 163, 136, 15);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		
		textFieldId = new JTextField();
		textFieldId.setBounds(164, 44, 236, 20);
		textFieldId.setColumns(10);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(164, 85, 236, 20);
		textFieldNom.setColumns(10);
		
		textFieldCoordinateur = new JTextField();
		textFieldCoordinateur.setBounds(164, 120, 236, 20);
		textFieldCoordinateur.setColumns(10);
		
		textFieldDepartement = new JTextField();
		textFieldDepartement.setBounds(164, 162, 236, 20);
		textFieldDepartement.setColumns(10);
		
		
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
		contentPane.add(textFieldCoordinateur);
		contentPane.add(textFieldDepartement);
		contentPane.add(ButtonAnuller);
		contentPane.add(ButtonValider);
		this.executerButtonAnuller();
		this.executerButtonValider();
	}

}
