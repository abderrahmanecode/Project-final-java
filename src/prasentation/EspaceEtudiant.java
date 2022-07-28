package prasentation;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import metier.Etudiant;
import metier.Professeur;
import metier.tableauEtudiants;
import persistance.gestionEtudiant;
import persistance.gestionProfesseur;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EspaceEtudiant extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTable table;
	private DefaultTableModel modele;
    public void fermer() {
    	dispose();
    }

	public EspaceEtudiant(ArrayList<Etudiant> list) {
		list=new ArrayList<Etudiant>();
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGdpa = new JLabel("GDPA");
		lblGdpa.setBounds(10, 11, 49, 29);
		lblGdpa.setForeground(Color.WHITE);
		lblGdpa.setFont(new Font("Script MT Bold", Font.PLAIN, 18));
		contentPane.add(lblGdpa);
		
		JLabel lblNewLabel = new JLabel("Espace Etudiants");
		lblNewLabel.setBounds(383, 12, 141, 29);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		contentPane.add(lblNewLabel);
		
		//ArrayList<Etudiant> list=new ArrayList<Etudiant>();
		gestionEtudiant G=new gestionEtudiant();
		list=G.getAll();
		tableauEtudiants tab = new tableauEtudiants(list);
		table = new JTable(tab);
		
		JScrollPane scrollPane =new JScrollPane();
		scrollPane.setBounds(72, 52, 350, 139);
		scrollPane.setViewportView(table);
		getContentPane().add(scrollPane);	
		
		JButton ButtonAjouter = new JButton("");
		ButtonAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AjouterEtudiant f=new AjouterEtudiant();
				f.setVisible(true);
				f.setLocationRelativeTo(null);
				
			}
		});
		ButtonAjouter.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\add-user.png"));
		ButtonAjouter.setBounds(156, 202, 49, 29);
		contentPane.add(ButtonAjouter);
		
		JButton ButtonAjouterGroube = new JButton("");
		ButtonAjouterGroube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AjouterGroubeEtudiants f =new AjouterGroubeEtudiants();
				f.setVisible(true);
				f.setLocationRelativeTo(null);
			}
		});
		ButtonAjouterGroube.setBackground(Color.LIGHT_GRAY);
		ButtonAjouterGroube.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\create-group-button (1).png"));
		ButtonAjouterGroube.setBounds(82, 202, 49, 29);
		contentPane.add(ButtonAjouterGroube);
		
		JButton ButtonSupp = new JButton("");
		ButtonSupp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contacts f=new Contacts();
				gestionEtudiant G=new gestionEtudiant();
				int indice=table.getSelectedRow();
				String id=table.getModel().getValueAt(indice, 0).toString(); 
						if(indice!=-1) {
							 try {
									G.SuppresionEtudiant(id);
								} catch (IOException e1) {
									// TODO Auto-generated catch block	
									JOptionPane.showMessageDialog(f, "selectionner une ligne","supprision",JOptionPane.ERROR_MESSAGE);
								}
							 dispose();
							 ArrayList<Etudiant> L=new ArrayList<Etudiant>();
							 gestionEtudiant g=new gestionEtudiant();
							 L=g.getAll();
						     EspaceEtudiant f1=new EspaceEtudiant(L);
                             f1.setVisible(true);
                             f1.setLocationRelativeTo(null);
							}
			}
		});
		ButtonSupp.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\delete (1).png"));
		ButtonSupp.setBounds(227, 202, 49, 29);
		contentPane.add(ButtonSupp);
		
		JButton ButtonModifier = new JButton("");
		ButtonModifier.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\refresh.png"));
		ButtonModifier.setBounds(297, 202, 49, 29);
		contentPane.add(ButtonModifier);
		
		JButton ButtonArriére = new JButton("");
		ButtonArriére.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EspaceAdministration f=new EspaceAdministration();
				f.setVisible(true);
				f.setLocationRelativeTo(null);
			}
		});
		ButtonArriére.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\circled-left--v3.png"));
		ButtonArriére.setBounds(10, 201, 49, 49);
		contentPane.add(ButtonArriére);
		
		
		ButtonModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice=table.getSelectedRow();
				String id=table.getModel().getValueAt(indice, 0).toString();
				String nom=table.getModel().getValueAt(indice, 1).toString();;
				String prenom=table.getModel().getValueAt(indice, 2).toString();;
				String email=table.getModel().getValueAt(indice, 3).toString();;
				String niveau=table.getModel().getValueAt(indice, 4).toString();;
				String nomfiliére=table.getModel().getValueAt(indice, 5).toString();
				ModifierEtudiant f1=new ModifierEtudiant(id,nom,prenom,email,niveau,nomfiliére);
				//JOptionPane.showMessageDialog(f1, "Seletionnez une ligne","selectionne",JOptionPane.OK_CANCEL_OPTION);
				dispose();
				 f1.setVisible(true);
                 f1.setLocationRelativeTo(null);
			}
		});
	
		
		JButton ButtonEdition = new JButton("");
		ButtonEdition.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\edit.png"));
		ButtonEdition.setBounds(368, 202, 49, 29);
		contentPane.add(ButtonEdition);
		
		ButtonEdition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titre="liste des impriments";
				gestionEtudiant G=new gestionEtudiant();
				G.EditionTable(table, titre);
			
			}
		});
	}
	
	
}
