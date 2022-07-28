package prasentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.Etudiant;
import metier.Professeur;
import persistance.gestionProfesseur;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ModifierProfesseur extends JFrame {

	private JPanel contentPane;
	private JTextField textField_IDP;
	private JTextField textField_iddepart;
	private JTextField textField_Nom;
	private JTextField textField_Prenom;
	private JTextField textField_Email;
	private JTextField textField_Grade;
	private JTextField textField_Role;
	private ArrayList<Professeur> list;
   public void fermer() {
	   dispose();
   }
	public ModifierProfesseur(String a,String b,String c,String d,String e,String f,String g) {
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
		lblEspaceProfesseurs.setBounds(345, 11, 167, 29);
		contentPane.add(lblEspaceProfesseurs);
		
		JLabel lblIdp = new JLabel("IDP :");
		lblIdp.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblIdp.setBounds(64, 34, 59, 21);
		contentPane.add(lblIdp);
		
		textField_IDP = new JTextField();
		textField_IDP.setColumns(10);
		textField_IDP.setBounds(188, 36, 173, 20);
		contentPane.add(textField_IDP);
		textField_IDP.setText(a);
		
		JLabel lblIddepart = new JLabel("ID_depart :");
		lblIddepart.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblIddepart.setBounds(60, 66, 93, 21);
		contentPane.add(lblIddepart);
		
		textField_iddepart = new JTextField();
		textField_iddepart.setColumns(10);
		textField_iddepart.setBounds(188, 68, 173, 20);
		contentPane.add(textField_iddepart);
		textField_iddepart.setText(b);
		
		JLabel LabelNom = new JLabel("Nom :");
		LabelNom.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelNom.setBounds(60, 98, 59, 21);
		contentPane.add(LabelNom);
		
		JLabel LabelPrenom = new JLabel("Prenom :");
		LabelPrenom.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelPrenom.setBounds(48, 122, 78, 21);
		contentPane.add(LabelPrenom);
		
		JLabel LabelEmail = new JLabel("Email :");
		LabelEmail.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelEmail.setBounds(64, 149, 59, 21);
		contentPane.add(LabelEmail);
		
		JLabel lblGrade = new JLabel("Grade:");
		lblGrade.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblGrade.setBounds(48, 175, 78, 21);
		contentPane.add(lblGrade);
		
		JLabel lblRole = new JLabel("Role :");
		lblRole.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblRole.setBounds(45, 200, 78, 21);
		contentPane.add(lblRole);
		
		textField_Nom = new JTextField();
		textField_Nom.setColumns(10);
		textField_Nom.setBounds(188, 99, 173, 20);
		contentPane.add(textField_Nom);
		textField_Nom.setText(c);
		
		textField_Prenom = new JTextField();
		textField_Prenom.setColumns(10);
		textField_Prenom.setBounds(188, 124, 173, 20);
		contentPane.add(textField_Prenom);
		textField_Prenom.setText(d);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(188, 151, 173, 20);
		contentPane.add(textField_Email);
		textField_Email.setText(e);
		
		textField_Grade = new JTextField();
		textField_Grade.setColumns(10);
		textField_Grade.setBounds(188, 177, 173, 20);
		contentPane.add(textField_Grade);
		textField_Grade.setText(f);
		
		textField_Role = new JTextField();
		textField_Role.setColumns(10);
		textField_Role.setBounds(188, 202, 173, 20);
		contentPane.add(textField_Role);
		textField_Role.setText(g);
		
		JButton ButtonValider = new JButton("");
		ButtonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		       
				String id_depart=textField_iddepart.getText();
				String idp=textField_IDP.getText();
		       String nom=textField_Nom.getText();
		       String prenom=textField_Prenom.getText();
		       String email=textField_Email.getText();
		       String grade=textField_Grade.getText();
		       String  role=textField_Role.getText();
		        
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
		ButtonValider.setBounds(463, 177, 49, 41);
		contentPane.add(ButtonValider);
		
		JLabel LabelValider = new JLabel("Valider");
		LabelValider.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		LabelValider.setBounds(463, 221, 49, 14);
		contentPane.add(LabelValider);
	}

}
