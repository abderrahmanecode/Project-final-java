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
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Affiche1 extends JFrame {

	private JPanel contentPane;
	JButton btnNewButton = new JButton("BACK");
	private JTextField textField;
	JButton btnNewButton_1 = new JButton("OK");
	String id;
	JLabel labelIDFiliere = new JLabel();
	
	JLabel labelNom = new JLabel();
	
	JLabel labelIdCoordinateur = new JLabel();
	
	JLabel labelIdDepart = new JLabel();

	/**
	 * Launch the application.
	 */
	private void closing() {
		this.dispose();
	}
	private void executer() {
		btnNewButton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						controlleur controleur=new controlleur();
						Espace_filiere frame= new Espace_filiere(controleur);
						frame.show();
						frame.setLocationRelativeTo(null);
						 closing();
						 
						}
						});
		                 
	}
	private void executer1() {
		btnNewButton_1.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						filiere fil;
						id=textField.getText();
						filiereDao fildao=new filiereDao();
						fil=fildao.getById(id);
						labelIDFiliere.setText("Id du filiére: "+fil.getId_filiere());
						labelNom.setText("Nom du filiére: "+fil.getNom_F());
						labelIdCoordinateur.setText(" Id_coordinateur: "+fil.getId_coordinateu());
						labelIdDepart.setText(" Id_Departement: "+fil.getId_deparetement());
						}
						});
		                 
	}
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Affiche1 frame = new Affiche1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Affiche1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("les informations d'une fili\u00E9re");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		
		
		
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_1 = new JLabel("Entrez Id du fili\u00E9re :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(labelIdCoordinateur, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
						.addComponent(labelIdDepart, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
					.addGap(190))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelNom, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
					.addGap(186))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelIDFiliere, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
					.addGap(186))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, Alignment.LEADING)
						.addComponent(btnNewButton_1, Alignment.LEADING))
					.addGap(27))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(141)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(150, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(btnNewButton_1))
					.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
					.addComponent(labelIDFiliere)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelNom)
					.addGap(11)
					.addComponent(labelIdCoordinateur)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(labelIdDepart)
							.addGap(37))))
		);
		contentPane.setLayout(gl_contentPane);
		this.executer();
		this.executer1();
	}
}
