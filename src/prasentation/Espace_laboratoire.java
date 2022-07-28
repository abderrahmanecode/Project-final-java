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

public class Espace_laboratoire extends JFrame {

	private JPanel contentPane;
	controlleur controleur;
	JButton ButtonAjouter = new JButton("OK");
	JButton ButtonSupprimer = new JButton("OK");
	JButton ButtonAfficherTout = new JButton("OK");
	JButton ButtonAfficher = new JButton("OK");
	JButton ButtonModifier = new JButton("Ok");
	JButton ButtonMembre = new JButton("Ajouter Membre");
	JButton btnNewButton = new JButton("Afficher les membres");
	private final JButton btnNewButton_1 = new JButton("Supprimer Membre");
	private final JButton Button_Back = new JButton("back");
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					controlleur controleur=new controlleur();
					Espace_laboratoire frame = new Espace_laboratoire(controleur);
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
		ButtonAfficherTout.setBounds(163, 78, 53, 25);
		ButtonAfficherTout.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						controleur.affiche_labo_tout();
						 closing();
						}
						});
		           
	}
	private void executerButtonSupprimer() {
		ButtonSupprimer.setBounds(466, 114, 53, 25);
		ButtonSupprimer.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						controleur.deleteLabo();
						 closing();
						}
						});
		           
	}
	private void executerButtonMenbre() {
		ButtonMembre.setBounds(10, 188, 142, 23);
		ButtonMembre.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						controleur.ajouterMembre();
						 closing();
						}
						});
		           
	}
	private void executerButtonAjouter() {
		ButtonAjouter.setBounds(192, 114, 53, 25);
		ButtonAjouter.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						controleur.ajouterLabo();
						 closing();
						}
						});
		           
	}
	private void executerButtonafficher() {
		ButtonAfficher.setBounds(466, 78, 53, 25);
		ButtonAfficher.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						controleur.affiche_labo();
						 closing();
						}
						});}
	private void executerButtonModifier() {
		ButtonModifier.setBounds(252, 145, 51, 25);
		ButtonModifier.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						controleur.modifierlabo();
						 closing();
						}
						});
		           
	}
	private void executerButtonListerMembre() {
		btnNewButton.setBounds(189, 188, 153, 23);
		btnNewButton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						controleur.listerMembres();
						 closing();
						}
						});
		           
	}
	private void executerSupprimerMembre() {
		btnNewButton_1.setBounds(371, 188, 153, 23);
		btnNewButton_1.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						controleur.deleteMembre() ;
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
	public Espace_laboratoire(controlleur controleur) {
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.LIGHT_GRAY);
		setTitle("Espace laboratoire");
		this.controleur=controleur;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 324);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ESPACE LABORATOIRE");
		lblNewLabel.setBounds(345, 12, 179, 19);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel.setBackground(new Color(139, 0, 139));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Veulliez choisir votre traitement sur les laboratoires!");
		lblNewLabel_1.setBounds(93, 42, 355, 17);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		
		JLabel labelAfficherTout = new JLabel("afficher tout");
		labelAfficherTout.setBounds(15, 83, 117, 15);
		labelAfficherTout.setForeground(Color.WHITE);
		labelAfficherTout.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		
		JLabel labelAfficher = new JLabel("Afficher un laboratoire");
		labelAfficher.setBounds(252, 83, 179, 15);
		labelAfficher.setForeground(Color.WHITE);
		labelAfficher.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		
		JLabel labelAjouter = new JLabel("Ajouter un laboratoire");
		labelAjouter.setBounds(15, 114, 202, 15);
		labelAjouter.setForeground(Color.WHITE);
		labelAjouter.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		
		JLabel labelSupprimer = new JLabel("Supprimer un Laboratoire");
		labelSupprimer.setBounds(252, 119, 203, 15);
		labelSupprimer.setForeground(Color.WHITE);
		labelSupprimer.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		
		JLabel labelModifier = new JLabel("Modifier un laboratoire");
		labelModifier.setBounds(38, 150, 165, 15);
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
		
		ButtonMembre.setBackground(Color.WHITE);
		ButtonMembre.setForeground(new Color(0, 0, 0));
		ButtonMembre.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(labelAfficher);
		contentPane.add(labelAfficherTout);
		contentPane.add(ButtonAfficher);
		contentPane.add(ButtonAfficherTout);
		contentPane.add(ButtonAjouter);
		contentPane.add(ButtonSupprimer);
		contentPane.add(ButtonModifier);
		contentPane.add(labelModifier);
		contentPane.add(labelAjouter);
		contentPane.add(labelSupprimer);
		contentPane.add(btnNewButton);
		contentPane.add(ButtonMembre);
		contentPane.add(btnNewButton_1);
		{
			Button_Back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					EspaceAdministration A=new EspaceAdministration();
					A.setVisible(true);
					A.setLocationRelativeTo(null);
				}
			});
			Button_Back.setFont(new Font("Tahoma", Font.BOLD, 13));
			Button_Back.setBounds(428, 249, 63, 25);
			contentPane.add(Button_Back);
		}
		this.executerButtonAjouter();
		this.executerButtonSupprimer();
		this.executerButtonAfficherTout();
		this.executerButtonafficher();
		this.executerButtonModifier();
		this.executerButtonListerMembre();
		this.executerButtonMenbre();
		this.executerSupprimerMembre() ;
	}
}
