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

public class AjouterEtudiant extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ID;
	private JTextField textField_Nom;
	private JTextField textField_Prenom;
	private JTextField textField_Email;
	private JTextField textField_Niveau;
	private JTextField textField_Filiére;
	private ArrayList<Etudiant> list;
    public void fermer() {
    	dispose();
    }
	public AjouterEtudiant() {
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
		lblNewLabel.setBounds(383, 12, 141, 29);
		contentPane.add(lblNewLabel);
		
		JLabel LabelID = new JLabel("ID :");
		LabelID.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelID.setBounds(69, 55, 59, 21);
		contentPane.add(LabelID);
		
		JLabel LabelNom = new JLabel("Nom :");
		LabelNom.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelNom.setBounds(69, 87, 59, 21);
		contentPane.add(LabelNom);
		
		JLabel LabelPrenom = new JLabel("Prenom :");
		LabelPrenom.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelPrenom.setBounds(69, 117, 78, 21);
		contentPane.add(LabelPrenom);
		
		JLabel LabelEmail = new JLabel("Email :");
		LabelEmail.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelEmail.setBounds(69, 145, 59, 21);
		contentPane.add(LabelEmail);
		
		JLabel LabelNiveau = new JLabel("Niveau :");
		LabelNiveau.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelNiveau.setBounds(69, 173, 78, 21);
		contentPane.add(LabelNiveau);
		
		JLabel LabelFiliére = new JLabel("Fili\u00E9re :");
		LabelFiliére.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelFiliére.setBounds(69, 199, 78, 21);
		contentPane.add(LabelFiliére);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(182, 57, 173, 20);
		contentPane.add(textField_ID);
		textField_ID.setColumns(10);
		
		textField_Nom = new JTextField();
		textField_Nom.setColumns(10);
		textField_Nom.setBounds(182, 89, 173, 20);
		contentPane.add(textField_Nom);
		
		textField_Prenom = new JTextField();
		textField_Prenom.setColumns(10);
		textField_Prenom.setBounds(182, 119, 173, 20);
		contentPane.add(textField_Prenom);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(182, 147, 173, 20);
		contentPane.add(textField_Email);
		
		textField_Niveau = new JTextField();
		textField_Niveau.setColumns(10);
		textField_Niveau.setBounds(182, 175, 173, 20);
		contentPane.add(textField_Niveau);
		
		textField_Filiére = new JTextField();
		textField_Filiére.setColumns(10);
		textField_Filiére.setBounds(182, 201, 173, 20);
		contentPane.add(textField_Filiére);
		
		JButton ButtonValider = new JButton("");
		ButtonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				    String id;
				    String nom;
			        String prenom;
			        String email;
			        String niveau;
			        String filiére;
			        
			        id=textField_ID.getText();
			        nom=textField_Nom.getText();
			        prenom=textField_Prenom.getText();
			        email=textField_Email.getText();
			        niveau=textField_Niveau.getText();
			        filiére=textField_Filiére.getText();
			        
			        Etudiant etudiant=new Etudiant(id,nom,prenom,email,niveau,filiére);
			        
			        gestionEtudiant G =new gestionEtudiant();
			        EspaceEtudiant f =new EspaceEtudiant(list);
			        try {
			        	if(id.isEmpty() || nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || niveau.isEmpty() || filiére.isEmpty()) {
			        		JOptionPane.showMessageDialog(f, "Remplisez tous les champs","champs vide",JOptionPane.OK_OPTION);
			        	}
			        	else {
						G.AdditionEtudiant(etudiant);
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
		ButtonValider.setBounds(446, 179, 49, 41);
		contentPane.add(ButtonValider);
		
		JLabel LabelValider = new JLabel("Valider");
		LabelValider.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		LabelValider.setBounds(446, 225, 49, 14);
		contentPane.add(LabelValider);
	}

}
