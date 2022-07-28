package prasentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.Membre;
import persistance.connexion;
import persistance.membreDao;

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

public class formulaireMembre extends JFrame {
	private String Id;
	private String Nom;
	private String prenom;
	private String Id_labo;

	private JPanel contentPane;
	private JTextField Id_case;
	private JTextField Nom_case;
	private JTextField Prenom_case;
	private JTextField labo_case;
	JButton btnNewButton = new JButton("enregister");
	private JButton terminerBoutton;
	
	
	private void closing() {
		this.dispose();
	}
	private void executer() {
		btnNewButton.setBounds(317, 188, 91, 23);
		btnNewButton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						connexion conex=new connexion();
					//	if (conex != null) {
					//		System.out.println("Database Connected successfully");
					//	} else {
					//		System.out.println("Database Connection failed");
				//		}
						System.out.println("khadmi 3afaak");
						Id=Id_case.getText();
						Nom=Nom_case.getText();
						prenom=Prenom_case.getText();
						Id_labo=labo_case.getText();
						Membre nouveau=new Membre( Id, Id_labo, Nom,prenom);
						membreDao nouveauDoa=new membreDao();
						nouveauDoa.save(nouveau);
						}
						});
		                 
	}
	private void executerterminer() {
		terminerBoutton.addActionListener(
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
	
	public formulaireMembre() {
		setTitle("FORMULAIRE DU MEMBRE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("entrez les informations du nouveau membre:");
		lblNewLabel.setBounds(47, 10, 387, 17);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Id ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(47, 40, 57, 15);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		Id_case = new JTextField();
		Id_case.setBounds(124, 38, 232, 20);
		Id_case.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nom");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(47, 71, 57, 15);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		Nom_case = new JTextField();
		Nom_case.setBounds(124, 69, 232, 20);
		Nom_case.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Pr\u00E9nom");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(47, 102, 57, 15);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		Prenom_case = new JTextField();
		Prenom_case.setBounds(124, 100, 232, 20);
		Prenom_case.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Id du laboratoire");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(47, 133, 129, 15);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		labo_case = new JTextField();
		labo_case.setBounds(186, 131, 170, 20);
		labo_case.setColumns(10);
		
		btnNewButton.setIcon(null);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		terminerBoutton = new JButton("retourner");
		terminerBoutton.setBounds(70, 188, 87, 23);
		terminerBoutton.setFont(new Font("Tahoma", Font.BOLD, 11));
		terminerBoutton.setForeground(Color.BLACK);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_4);
		contentPane.add(labo_case);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_3);
		contentPane.add(Id_case);
		contentPane.add(Nom_case);
		contentPane.add(Prenom_case);
		contentPane.add(terminerBoutton);
		contentPane.add(btnNewButton);
		this.executer();
		this.executerterminer();
	}
}
