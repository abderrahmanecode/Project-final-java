package prasentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.filiere;
import persistance.connexion;
import persistance.filiereDao;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class FormulaireFiliere extends JFrame {
	private String Id_filiere;
	private String Nom_F;
	private String Id_coordinateu;
	private String Id_deparetement;

	private JPanel contentPane;
	private JTextField Id_case;
	private JTextField Nom_case;
	private JTextField Id_coordinateur_case;
	private JTextField Id_departement_case;
	JButton btnNewButton = new JButton("enregister");
	
	
	private void closing() {
		this.dispose();
	}
	private void executer() {
		btnNewButton.setBounds(200, 184, 91, 23);
		btnNewButton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						connexion conex=new connexion();
						//if (conex != null) {
							//System.out.println("Database Connected successfully");
						//} else {
							//System.out.println("Database Connection failed");
						//}
						Id_filiere=Id_case.getText();
						Nom_F=Nom_case.getText();
						Id_coordinateu=Id_coordinateur_case.getText();
						Id_deparetement= Id_departement_case.getText();
						filiere nouveau=new filiere( Id_filiere, Nom_F,  Id_coordinateu,Id_deparetement);
						filiereDao nouveauDoa=new filiereDao();
						nouveauDoa.save(nouveau);
						controlleur controleur=new controlleur();
						Espace_filiere frame= new Espace_filiere(controleur);
						frame.show();
						frame.setLocationRelativeTo(null);
						 closing();
						}
						});
		                 
	}
	public FormulaireFiliere() {
		setTitle("FORMULAIRE DU FILIERE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("entrez les informations du nouveau fili\u00E8re:");
		lblNewLabel.setBounds(77, 12, 369, 17);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel(" Id :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(47, 71, 115, 15);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		Id_case = new JTextField();
		Id_case.setBounds(222, 57, 182, 20);
		Id_case.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nom :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(47, 103, 115, 15);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		
		Nom_case = new JTextField();
		Nom_case.setBounds(222, 88, 182, 20);
		Nom_case.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Id de coordinateur");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(47, 129, 140, 15);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		
		Id_coordinateur_case = new JTextField();
		Id_coordinateur_case.setBounds(222, 122, 182, 20);
		Id_coordinateur_case.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Id du d\u00E9partement associ\u00E9");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(47, 155, 174, 15);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		
		Id_departement_case = new JTextField();
		Id_departement_case.setBounds(222, 153, 182, 20);
		Id_departement_case.setColumns(10);
		
		btnNewButton.setIcon(null);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_4);
		contentPane.add(Id_departement_case);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_3);
		contentPane.add(Id_coordinateur_case);
		contentPane.add(Nom_case);
		contentPane.add(Id_case);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlleur c=new controlleur();
				Espace_filiere E=new Espace_filiere(c);
				E.setVisible(true);
				E.setLocationRelativeTo(null);
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBounds(438, 227, 75, 23);
		contentPane.add(btnNewButton_1);
		this.executer();
	}
}
