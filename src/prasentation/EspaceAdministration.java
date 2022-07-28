package prasentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.Etudiant;
import metier.Professeur;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class EspaceAdministration extends JFrame {

	private JPanel contentPane;
    private ArrayList<Etudiant> list;
    private ArrayList<Professeur> liste;
	public EspaceAdministration() {
		setBackground(Color.GRAY);
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
		
		JLabel lblNewLabel = new JLabel("Administration");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(224, 26, 130, 29);
		contentPane.add(lblNewLabel);
		
		JButton ButtonEtudiant = new JButton("");
		ButtonEtudiant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EspaceEtudiant f=new EspaceEtudiant(list);
				f.setVisible(true);
				f.setLocationRelativeTo(null);
			}
		});
		ButtonEtudiant.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\student-male.png"));
		ButtonEtudiant.setBounds(10, 81, 64, 62);
		contentPane.add(ButtonEtudiant);
		
		JButton ButtonProf = new JButton("");
		ButtonProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EspaceProfesseur f=new EspaceProfesseur(liste);
				f.setVisible(true);
				f.setLocationRelativeTo(null);
			}
		});
		ButtonProf.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\teacher.png"));
		ButtonProf.setBounds(84, 81, 64, 62);
		contentPane.add(ButtonProf);
		
		JButton ButtonLabo = new JButton("");
		ButtonLabo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlleur c=new controlleur();
				dispose();
				Espace_laboratoire L=new Espace_laboratoire(c);
				L.setVisible(true);
				L.setLocationRelativeTo(null);
			}
		});
		ButtonLabo.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\test-tube.png"));
		ButtonLabo.setBounds(158, 81, 64, 62);
		contentPane.add(ButtonLabo);
		
		JButton ButtonDepart = new JButton("");
		ButtonDepart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame;
				affichage_departement D=new affichage_departement();
				D.setVisible(true);
				D.setLocationRelativeTo(null);
			}
		});
		ButtonDepart.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\department.png"));
		ButtonDepart.setBounds(232, 81, 64, 62);
		contentPane.add(ButtonDepart);
		
		JButton ButtonFliére = new JButton("");
		ButtonFliére.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlleur c=new controlleur();
				dispose();
				Espace_filiere L=new Espace_filiere(c);
				L.setVisible(true);
				L.setLocationRelativeTo(null);
			}
		});
		ButtonFliére.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\section.png"));
		ButtonFliére.setBounds(306, 81, 64, 62);
		contentPane.add(ButtonFliére);
		
		JButton ButtonEntreprise = new JButton("");
		ButtonEntreprise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichageENTREPRISE E=new affichageENTREPRISE();
				E.setVisible(true);
				E.setLocationRelativeTo(null);
			}
		});
		ButtonEntreprise.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\erp-system.png"));
		ButtonEntreprise.setBounds(380, 81, 64, 62);
		contentPane.add(ButtonEntreprise);
		
		JButton ButtonProjet = new JButton("");
		ButtonProjet.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\project.png"));
		ButtonProjet.setBounds(454, 81, 64, 62);
		contentPane.add(ButtonProjet);
		
		JButton Button_Accueil = new JButton("Acceuil");
		Button_Accueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Acceuil f=new Acceuil();
				f.setVisible(true);
				f.setLocationRelativeTo(null);
			}
		});
		Button_Accueil.setBackground(Color.LIGHT_GRAY);
		Button_Accueil.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		Button_Accueil.setBounds(10, 214, 89, 23);
		contentPane.add(Button_Accueil);
		ButtonProjet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Formulaire f=new Formulaire();
				f.setVisible(true);
				f.setLocationRelativeTo(null);
			}
		});
	}

}
