package prasentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.filiere;
import metier.laboratoire;
import persistance.connexion;
import persistance.filiereDao;
import persistance.laboratoireDoa;

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
 
public class AfficheLabo extends JFrame {

	private JPanel contentPane;
	JButton backButton = new JButton("BACK");
	private JTextField textField;
	JButton OKbutton = new JButton("OK");
	  static String id;
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
		backButton.setBounds(450, 227, 65, 23);
		backButton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						controlleur controleur=new controlleur();
						Espace_laboratoire frame= new Espace_laboratoire(controleur);
						frame.show();
						frame.setLocationRelativeTo(null);
						 closing();
						}
						});
		                 
	}
	private void executer1() {
		OKbutton.setBounds(466, 71, 49, 23);
		OKbutton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						laboratoire fil;
						id=textField.getText();
						laboratoireDoa fildao=new laboratoireDoa();
						fil=fildao.getById(id);
						labelIDFiliere.setText("Id du laboratoire: "+fil.getId_laboratoire());
						labelNom.setText("Nom du filiére: "+fil.getNom_L());
						labelIdCoordinateur.setText(" Id_coordinateur: "+fil.getEmail_L());
						labelIdDepart.setText(" Id_Departement: "+fil.getId_responsable());
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
	public AfficheLabo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("les informations d'une laboratoire");
		lblNewLabel.setBounds(97, 26, 372, 21);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		
		
		
		backButton.setForeground(Color.BLACK);
		backButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_1 = new JLabel("Entrez Id du laboratoire");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(15, 73, 143, 17);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		textField = new JTextField();
		textField.setBounds(176, 73, 242, 20);
		textField.setColumns(10);
		
		OKbutton.setForeground(Color.BLACK);
		OKbutton.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.setLayout(null);
		labelNom.setBounds(15, 185, 358, 0);
		contentPane.add(labelNom);
		labelIDFiliere.setBounds(15, 174, 358, 0);
		contentPane.add(labelIDFiliere);
		labelIdCoordinateur.setBounds(15, 196, 354, 0);
		contentPane.add(labelIdCoordinateur);
		labelIdDepart.setBounds(15, 207, 354, 0);
		contentPane.add(labelIdDepart);
		contentPane.add(lblNewLabel_1);
		contentPane.add(textField);
		contentPane.add(OKbutton);
		contentPane.add(lblNewLabel);
		contentPane.add(backButton);
		this.executer();
		this.executer1();
	}
}
