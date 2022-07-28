package prasentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.filiere;
import persistance.connexion;
import persistance.filiereDao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;

public class Espace_filiere extends JFrame {

	private JPanel contentPane;
	controlleur controleur;
	JButton ButtonAjouter = new JButton("OK");
	JButton ButtonSupprimer = new JButton("OK");
	JButton ButtonAfficherTout = new JButton("OK");
	JButton ButtonAfficher = new JButton("OK");
	JButton ButtonModifier = new JButton("Ok");
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					controlleur controleur=new controlleur();
					Espace_filiere frame = new Espace_filiere(controleur);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	private void closing() {
		this.dispose();
	}
	private void executerButtonAfficherTout() {
		ButtonAfficherTout.setBounds(181, 70, 53, 25);
		ButtonAfficherTout.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						controleur.affichetout();;
						 closing();
						}
						});
		           
	}
	private void executerButtonSupprimer() {
		ButtonSupprimer.setBounds(415, 113, 53, 25);
		ButtonSupprimer.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						controleur.supprimer();
						 closing();
						}
						});
		           
	}
	private void executerButtonAjouter() {
		ButtonAjouter.setBounds(181, 113, 53, 25);
		ButtonAjouter.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						controleur.ajouter();
						 closing();
						}
						});
		           
	}
	private void executerButtonafficher() {
		ButtonAfficher.setBounds(415, 70, 53, 25);
		ButtonAfficher.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						controleur.affiche();
						 closing();
						}
						});}
	private void executerButtonModifier() {
		ButtonModifier.setBounds(275, 156, 51, 25);
		ButtonModifier.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						controleur.modifier();
						 closing();
						}
						});
		           
	}

	/**
	 * Create the frame.
	 */
	//private void colsing() {
		//this.dispose();
	//}
	public Espace_filiere(controlleur controleur) {
		setBackground(Color.LIGHT_GRAY);
		setTitle("Espace filiere");
		this.controleur=controleur;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ESPACE FILIERE");
		lblNewLabel.setBounds(383, 11, 141, 19);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel.setBackground(new Color(139, 0, 139));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Veulliez choisir votre traitement sur les filieres!");
		lblNewLabel_1.setBounds(105, 41, 355, 17);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		
		JLabel labelAfficherTout = new JLabel("afficher tout");
		labelAfficherTout.setBounds(50, 74, 113, 19);
		labelAfficherTout.setForeground(Color.WHITE);
		labelAfficherTout.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		
		JLabel labelAfficher = new JLabel("afficher un filiere");
		labelAfficher.setBounds(253, 74, 148, 19);
		labelAfficher.setForeground(Color.WHITE);
		labelAfficher.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		
		JLabel labelAjouter = new JLabel("ajouter un filiere");
		labelAjouter.setBounds(37, 119, 176, 19);
		labelAjouter.setForeground(Color.WHITE);
		labelAjouter.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		
		JLabel labelSupprimer = new JLabel("supprimer un filiere");
		labelSupprimer.setBounds(253, 119, 169, 15);
		labelSupprimer.setForeground(Color.WHITE);
		labelSupprimer.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		
		JLabel labelModifier = new JLabel("modifier un filiere");
		labelModifier.setBounds(93, 162, 141, 19);
		labelModifier.setForeground(Color.WHITE);
		labelModifier.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		
		ButtonAfficherTout.setFont(new Font("Tahoma", Font.BOLD, 14));
		ButtonAfficherTout.setBackground(Color.WHITE);
		ButtonAfficherTout.setForeground(Color.BLACK);
		
		
		ButtonAfficher.setBackground(Color.WHITE);
		ButtonAfficher.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		ButtonAjouter.setFont(new Font("Tahoma", Font.BOLD, 14));
		ButtonAjouter.setBackground(Color.WHITE);
		
		ButtonSupprimer.setFont(new Font("Tahoma", Font.BOLD, 14));
		ButtonSupprimer.setBackground(Color.WHITE);
		
		
		ButtonModifier.setBackground(Color.WHITE);
		ButtonModifier.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton Button_Back = new JButton("back");
		Button_Back.setBounds(405, 208, 63, 25);
		Button_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EspaceAdministration A=new EspaceAdministration();
				A.setVisible(true);
				A.setLocationRelativeTo(null);
				
			}
		});
		Button_Back.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel);
		contentPane.add(labelAfficher);
		contentPane.add(labelAjouter);
		contentPane.add(labelSupprimer);
		contentPane.add(labelAfficherTout);
		contentPane.add(ButtonAfficher);
		contentPane.add(ButtonAfficherTout);
		contentPane.add(ButtonAjouter);
		contentPane.add(ButtonSupprimer);
		contentPane.add(ButtonModifier);
		contentPane.add(labelModifier);
		contentPane.add(Button_Back);
		this.executerButtonAjouter();
		this.executerButtonSupprimer();
		executerButtonAfficherTout();
		executerButtonafficher();
		executerButtonModifier();
	}
}
