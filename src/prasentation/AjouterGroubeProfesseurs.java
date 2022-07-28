package prasentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import metier.Etudiant;
import metier.Professeur;
import persistance.gestionEtudiant;
import persistance.gestionProfesseur;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AjouterGroubeProfesseurs extends JFrame {

	private JPanel contentPane;
	private String path;
	private ArrayList<Professeur> list;
    public void fermer() {
    	dispose();
    	}
	public AjouterGroubeProfesseurs() {
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
		
		JLabel lblEspaceProfesseurs = new JLabel("Espace Professeurs");
		lblEspaceProfesseurs.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblEspaceProfesseurs.setBounds(365, 11, 159, 29);
		contentPane.add(lblEspaceProfesseurs);
		
		JLabel LabelFichier = new JLabel("votre fichier excel :");
		LabelFichier.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelFichier.setBounds(57, 101, 158, 21);
		contentPane.add(LabelFichier);
		
		JLabel lblLienFichier = new JLabel("lien fichier");
		lblLienFichier.setBounds(150, 136, 254, 14);
		contentPane.add(lblLienFichier);

		JButton ButtonFichier = new JButton("selectionner un fichier");
		ButtonFichier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser=new JFileChooser();
				FileNameExtensionFilter filter =new FileNameExtensionFilter("excel","csv");
				chooser.addChoosableFileFilter(filter);
				chooser.setDialogTitle("choisir un fichier excel");
				int i=chooser.showDialog(null, "OK");
				if(i==JFileChooser.APPROVE_OPTION) {
					File selectExcel=chooser.getSelectedFile();
					path=selectExcel.getAbsolutePath();
					lblLienFichier.setText(path);
					
				}
			}
		});
		ButtonFichier.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		ButtonFichier.setBounds(292, 102, 175, 23);
		contentPane.add(ButtonFichier);
		
		
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionProfesseur G=new gestionProfesseur();
				try {
					G.AdditionProfesseurGroube(path);
					dispose();
					EspaceProfesseur f=new EspaceProfesseur(list);
					f.setVisible(true);
					f.setLocationRelativeTo(null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnValider.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnValider.setBackground(SystemColor.activeCaption);
		btnValider.setBounds(219, 161, 94, 29);
		contentPane.add(btnValider);
	}

}
