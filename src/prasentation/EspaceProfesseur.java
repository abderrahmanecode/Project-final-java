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

import metier.Professeur;
import metier.TableauProfesseur;
import persistance.gestionEtudiant;
import persistance.gestionProfesseur;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EspaceProfesseur extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTable table;
	private DefaultTableModel modele;
    public void fermer() {
    	dispose();
    }
	public EspaceProfesseur(ArrayList<Professeur> list) {
		list=new ArrayList<Professeur>();
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
		
		JLabel lblNewLabel = new JLabel("Espace Professeurs");
		lblNewLabel.setBounds(383, 12, 141, 29);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		contentPane.add(lblNewLabel);
		
		//ArrayList<Etudiant> list=new ArrayList<Etudiant>();
		gestionProfesseur G=new gestionProfesseur();
		list=G.getAll();
		TableauProfesseur tab = new TableauProfesseur(list);
		table = new JTable(tab);
		
		JScrollPane scrollPane =new JScrollPane();
		scrollPane.setBounds(72, 52, 350, 139);
		scrollPane.setViewportView(table);
		getContentPane().add(scrollPane);	
		
		JButton ButtonAjouter = new JButton("");
		ButtonAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AjouterProf f=new AjouterProf();
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
				AjouterGroubeProfesseurs f =new AjouterGroubeProfesseurs();
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
				gestionProfesseur G=new gestionProfesseur();
				int indice=table.getSelectedRow();
				String id=table.getModel().getValueAt(indice, 1).toString(); 
						if(indice!=-1) {
							 try {
									int i=G.SuppresionProfesseur(id);
									if(i==0) {
										JOptionPane.showMessageDialog(null, "impossible de supprimer","Erreur",JOptionPane.ERROR_MESSAGE);
									}
									else {
								 dispose();
								 ArrayList<Professeur> L=new ArrayList<Professeur>();
								 gestionProfesseur g=new gestionProfesseur();
								 L=g.getAll();
							     EspaceProfesseur f1=new EspaceProfesseur(L);
	                             f1.setVisible(true);
	                             f1.setLocationRelativeTo(null);
									}
									
								} catch (IOException e1) {
									// TODO Auto-generated catch block	
									JOptionPane.showMessageDialog(f, "selectionner une ligne","supprision",JOptionPane.ERROR_MESSAGE);
								}
							     
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
				String id_depart=table.getModel().getValueAt(indice, 0).toString();
				String idp=table.getModel().getValueAt(indice, 1).toString();
				String nom=table.getModel().getValueAt(indice, 2).toString();;
				String prenom=table.getModel().getValueAt(indice, 3).toString();;
				String email=table.getModel().getValueAt(indice, 4).toString();;
				String grade=table.getModel().getValueAt(indice, 5).toString();;
				String role=table.getModel().getValueAt(indice, 6).toString();
				ModifierProfesseur f1=new ModifierProfesseur(id_depart,idp,nom,prenom,email,grade,role);
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
				gestionProfesseur G=new gestionProfesseur();
				G.EditionTable(table, titre);
			
			}
		});
	}
	
	
}

