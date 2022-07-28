package prasentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import metier.Etudiant;
import persistance.gestionEtudiant;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class AjouterGroubeEtudiants extends JFrame {

	private JPanel contentPane;
	private String path;
	private ArrayList<Etudiant> list;
	public void fremer() {
		dispose();
	}
	public AjouterGroubeEtudiants() {
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
		
		JLabel LabelFichier = new JLabel("votre fichier excel :");
		LabelFichier.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		LabelFichier.setBounds(87, 118, 158, 21);
		contentPane.add(LabelFichier);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnValider.setBounds(208, 176, 94, 29);
		contentPane.add(btnValider);
		btnValider.setBackground(SystemColor.activeCaption);
		
		JButton ButtonFichier = new JButton("selectionner un fichier");
		ButtonFichier.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		ButtonFichier.setBounds(278, 119, 175, 23);
		contentPane.add(ButtonFichier);
		
		JLabel Labellien = new JLabel("lien fichier");
		Labellien.setBounds(230, 153, 254, 14);
		contentPane.add(Labellien);
		
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
					Labellien.setText(path);
					
				}
			}
		});
		
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionEtudiant G=new gestionEtudiant();
				try {
					G.AdditionEtudiantGroube(path);
					dispose();
					EspaceEtudiant f=new EspaceEtudiant(list);
					f.setVisible(true);
					f.setLocationRelativeTo(null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	
	}

}
