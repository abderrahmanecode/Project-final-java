package prasentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.Etudiant;
import persistance.gestionEtudiant;

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

public class ModifierEtudiant extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Nom;
	private JTextField textField_Prenom;
	private JTextField textField_Email;
	private JTextField textField_Niveau;
	private JTextField textField_Filiére;
	private JTextField textField_ID;
	private ArrayList<Etudiant> list;
    public void fermer() {
    dispose();
}
	public ModifierEtudiant(String a,String b,String c,String d,String e,String f) {
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
		
		JLabel lblNewLabel = new JLabel("Espace Etudiants");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblNewLabel.setBounds(383, 11, 141, 29);
		contentPane.add(lblNewLabel);
		
		JLabel LabelNom = new JLabel("Nom :");
		LabelNom.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelNom.setBounds(65, 54, 59, 21);
		contentPane.add(LabelNom);
		
		JLabel LabelPrenom = new JLabel("Prenom :");
		LabelPrenom.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelPrenom.setBounds(65, 86, 78, 21);
		contentPane.add(LabelPrenom);
		
		JLabel LabelEmail = new JLabel("Email :");
		LabelEmail.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelEmail.setBounds(65, 118, 59, 21);
		contentPane.add(LabelEmail);
		
		JLabel LabelNiveau = new JLabel("Niveau :");
		LabelNiveau.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelNiveau.setBounds(65, 150, 78, 21);
		contentPane.add(LabelNiveau);
		
		JLabel LabelFiliére = new JLabel("Fili\u00E9re :");
		LabelFiliére.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelFiliére.setBounds(65, 182, 78, 21);
		contentPane.add(LabelFiliére);
		
		JLabel LabelID = new JLabel("ID :");
		LabelID.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelID.setBounds(65, 31, 59, 21);
		contentPane.add(LabelID);
		
		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(158, 25, 173, 20);
		contentPane.add(textField_ID);
		textField_ID.setText(a);
		
		textField_Nom = new JTextField();
		textField_Nom.setBounds(162, 56, 169, 20);
		contentPane.add(textField_Nom);
		textField_Nom.setColumns(10);
		textField_Nom.setText(b);
		
		textField_Prenom = new JTextField();
		textField_Prenom.setColumns(10);
		textField_Prenom.setBounds(162, 88, 169, 20);
		contentPane.add(textField_Prenom);
		textField_Prenom.setText(c);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(162, 120, 169, 20);
		contentPane.add(textField_Email);
		textField_Email.setText(d);
		
		textField_Niveau = new JTextField();
		textField_Niveau.setColumns(10);
		textField_Niveau.setBounds(162, 152, 169, 20);
		contentPane.add(textField_Niveau);
		textField_Niveau.setText(e);
		
		textField_Filiére = new JTextField();
		textField_Filiére.setColumns(10);
		textField_Filiére.setBounds(162, 184, 169, 20);
		contentPane.add(textField_Filiére);
		textField_Filiére.setText(f);
		
		JButton ButtonValider = new JButton("");
		ButtonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   
				String id=textField_ID.getText();
		        String nom=textField_Nom.getText();
		        String prenom=textField_Prenom.getText();
		        String email=textField_Email.getText();
		        String niveau=textField_Niveau.getText();
		        String filiére=textField_Filiére.getText();
		        
		        gestionEtudiant G=new gestionEtudiant();
				
				Etudiant etudiant=new Etudiant(id,nom,prenom,email,niveau,filiére);
				
			    try {
			    	
		        	if( id.isEmpty() || nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || niveau.isEmpty() || filiére.isEmpty()) {
		        		JOptionPane.showMessageDialog(null, "Remplisez tous les champs","champs vide",JOptionPane.OK_OPTION);
		        	}
		        	else {
		        	G.SuppresionEtudiant(id);
					G.AdditionEtudiant(etudiant);
					EspaceEtudiant f=new EspaceEtudiant(list);
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
		ButtonValider.setBounds(449, 183, 49, 41);
		contentPane.add(ButtonValider);
		
		JLabel LabelValider = new JLabel("Valider");
		LabelValider.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		LabelValider.setBounds(449, 225, 49, 14);
		contentPane.add(LabelValider);
		
	
	}
}
