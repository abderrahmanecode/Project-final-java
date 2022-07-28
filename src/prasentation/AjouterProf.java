package prasentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.Etudiant;
import metier.Professeur;
import persistance.gestionEtudiant;
import persistance.gestionProfesseur;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AjouterProf extends JFrame {

	private JPanel contentPane;
	private JTextField textField_IDP;
	private JTextField textField_Iddepart;
	private JTextField textField_Nom;
	private JTextField textField_Prenom;
	private JTextField textField_Email;
	private JTextField textField_Grade;
	private JTextField textField_Role;
	private ArrayList<Professeur> list;
	private final JLabel lblValider = new JLabel("Valider");
    public void fermer() {
    	dispose();
    }
	public AjouterProf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGdpa = new JLabel("GDPA");
		lblGdpa.setForeground(Color.WHITE);
		lblGdpa.setFont(new Font("Script MT Bold", Font.PLAIN, 18));
		lblGdpa.setBounds(10, 11, 49, 29);
		contentPane.add(lblGdpa);
		
		JLabel lblEspaceProfesseurs = new JLabel("Espace Professeur");
		lblEspaceProfesseurs.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblEspaceProfesseurs.setBounds(357, 11, 167, 29);
		contentPane.add(lblEspaceProfesseurs);
		
		JLabel lblIdp = new JLabel("IDP :");
		lblIdp.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblIdp.setBounds(60, 42, 59, 21);
		contentPane.add(lblIdp);
		
		JLabel lblIddepart = new JLabel("ID_depart :");
		lblIddepart.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblIddepart.setBounds(60, 74, 93, 21);
		contentPane.add(lblIddepart);
		
		JLabel LabelNom = new JLabel("Nom :");
		LabelNom.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelNom.setBounds(60, 99, 59, 21);
		contentPane.add(LabelNom);
		
		JLabel LabelPrenom = new JLabel("Prenom :");
		LabelPrenom.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelPrenom.setBounds(60, 125, 78, 21);
		contentPane.add(LabelPrenom);
		
		JLabel LabelEmail = new JLabel("Email :");
		LabelEmail.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelEmail.setBounds(60, 153, 59, 21);
		contentPane.add(LabelEmail);
		
		JLabel lblGrade = new JLabel("Grade:");
		lblGrade.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblGrade.setBounds(60, 184, 78, 21);
		contentPane.add(lblGrade);
		
		JLabel lblRole = new JLabel("Role :");
		lblRole.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblRole.setBounds(60, 212, 78, 21);
		contentPane.add(lblRole);
		
		textField_IDP = new JTextField();
		textField_IDP.setColumns(10);
		textField_IDP.setBounds(152, 44, 173, 20);
		contentPane.add(textField_IDP);
		
		textField_Iddepart = new JTextField();
		textField_Iddepart.setColumns(10);
		textField_Iddepart.setBounds(152, 76, 173, 20);
		contentPane.add(textField_Iddepart);
		
		textField_Nom = new JTextField();
		textField_Nom.setColumns(10);
		textField_Nom.setBounds(152, 101, 173, 20);
		contentPane.add(textField_Nom);
		
		textField_Prenom = new JTextField();
		textField_Prenom.setColumns(10);
		textField_Prenom.setBounds(152, 127, 173, 20);
		contentPane.add(textField_Prenom);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(152, 155, 173, 20);
		contentPane.add(textField_Email);
		
		textField_Grade = new JTextField();
		textField_Grade.setColumns(10);
		textField_Grade.setBounds(152, 186, 173, 20);
		contentPane.add(textField_Grade);
		
		textField_Role = new JTextField();
		textField_Role.setColumns(10);
		textField_Role.setBounds(152, 214, 173, 20);
		contentPane.add(textField_Role);
		
		JButton ButtonValider = new JButton("");
		ButtonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
		            String id_depart; 		
				    String idp;
				    String nom;
			        String prenom;
			        String email;
			        String grade;
			        String role;
			        
			        id_depart=textField_Iddepart.getText();
			        idp=textField_IDP.getText();
			        nom=textField_Nom.getText();
			        prenom=textField_Prenom.getText();
			        email=textField_Email.getText();
			        grade=textField_Grade.getText();
			        role=textField_Role.getText();
			        
			        Professeur P=new Professeur(id_depart,idp,nom,prenom,email,grade,role);
			        
			        gestionProfesseur G =new gestionProfesseur();
			        EspaceProfesseur f =new EspaceProfesseur(list);
			        
			        try {
			        	if(id_depart.isEmpty() ||idp.isEmpty() || nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || grade.isEmpty() || role.isEmpty()) {
			        		JOptionPane.showMessageDialog(f, "Remplisez tous les champs","champs vide",JOptionPane.OK_OPTION);
			        	}
			        	else {
						G.AdditionProfesseur(P);
						dispose();
						f.setVisible(true);
						f.setLocationRelativeTo(null);
			        	}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		ButtonValider.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\checked-checkbox.png"));
		ButtonValider.setBounds(462, 184, 49, 41);
		contentPane.add(ButtonValider);
		lblValider.setBounds(465, 225, 59, 25);
		contentPane.add(lblValider);
		lblValider.setFont(new Font("Times New Roman", Font.ITALIC, 16));
	}

}
