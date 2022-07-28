package prasentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Acceuil extends JFrame {
	
	private JPanel contentPane;
	private void fermer() {
		dispose();
	}
	public Acceuil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion Des Projets Acad\u00E9mique");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(20, 40, 268, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblGdpa = new JLabel("GDPA");
		lblGdpa.setForeground(Color.WHITE);
		lblGdpa.setFont(new Font("Script MT Bold", Font.PLAIN, 18));
		lblGdpa.setBounds(10, 11, 49, 29);
		contentPane.add(lblGdpa);
		
		JLabel lblDxv = new JLabel("la gestion des projets est un processus difficile \r\n\u00E0 maitrisser car interviennent plusieurs facteurs\r\n de risque tels nque les couts et les d\u00E9lais \u00E0 respecter   ");
		lblDxv.setForeground(Color.WHITE);
		lblDxv.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDxv.setBounds(10, 80, 380, 122);
		contentPane.add(lblDxv);
		
		JLabel lblAcceuil = new JLabel("Acceuil");
		lblAcceuil.setForeground(Color.WHITE);
		lblAcceuil.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblAcceuil.setBounds(436, 12, 88, 29);
		contentPane.add(lblAcceuil);
		
		JButton btnNewButton = new JButton("Contacts");
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Contacts f =new Contacts();
				f.setVisible(true);
				f.setLocationRelativeTo(null);
				
			}
		});
		btnNewButton.setBounds(421, 192, 91, 20);
		contentPane.add(btnNewButton);
		
		JButton btnAdministration = new JButton("Administration");
		btnAdministration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginAdministration f=new LoginAdministration();
				f.setVisible(true);		
			    f.setLocationRelativeTo(null);	
			}
		});
		btnAdministration.setForeground(Color.BLACK);
		btnAdministration.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		btnAdministration.setBackground(Color.LIGHT_GRAY);
		btnAdministration.setBounds(421, 102, 91, 20);
		contentPane.add(btnAdministration);
		
		JButton btnProfesseur = new JButton("Professeur");
		btnProfesseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginProfesseur L=new LoginProfesseur();
				L.setVisible(true);
				L.setLocationRelativeTo(null);
			}
		});
		btnProfesseur.setForeground(Color.BLACK);
		btnProfesseur.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		btnProfesseur.setBackground(Color.LIGHT_GRAY);
		btnProfesseur.setBounds(421, 132, 91, 20);
		contentPane.add(btnProfesseur);
		
		JButton btnEtudiant = new JButton("Etudiant");
		btnEtudiant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginEtudiant L=new LoginEtudiant();
				L.setVisible(true);
				L.setLocationRelativeTo(null);
			}
		});
		btnEtudiant.setForeground(Color.BLACK);
		btnEtudiant.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		btnEtudiant.setBackground(Color.LIGHT_GRAY);
		btnEtudiant.setBounds(421, 162, 91, 20);
		contentPane.add(btnEtudiant);
		
		JButton Button_Quitter = new JButton("Quitter");
		Button_Quitter.setBackground(Color.LIGHT_GRAY);
		Button_Quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		Button_Quitter.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		Button_Quitter.setBounds(421, 222, 91, 20);
		contentPane.add(Button_Quitter);
	}
}
