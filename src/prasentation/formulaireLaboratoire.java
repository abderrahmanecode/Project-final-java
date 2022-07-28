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

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class formulaireLaboratoire extends JFrame {
	private String Id_labo;
	private String Nom_l;
	private String Email;
	private String Id_respo;

	private JPanel contentPane;
	private JTextField Id_case;
	private JTextField Nom_case;
	private JTextField Email_case;
	private JTextField respo_case;
	JButton btnNewButton = new JButton("enregister");
	private JButton AnnulerBoutton;
	
	
	private void closing() {
		this.dispose();
	}
	private void executer() {
		btnNewButton.setBounds(301, 185, 91, 23);
		btnNewButton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						connexion conex=new connexion();
						System.out.println("khadmi 3afaak");
						Id_labo=Id_case.getText();
						Nom_l=Nom_case.getText();
						Email=Email_case.getText();
						Id_respo=respo_case.getText();
						laboratoire nouveau=new laboratoire( Id_labo, Nom_l, Email,Id_respo);
						laboratoireDoa nouveauDoa=new laboratoireDoa();
						nouveauDoa.save(nouveau);
						controlleur controleur=new controlleur();
						Espace_laboratoire frame= new Espace_laboratoire(controleur);
						frame.show();
						frame.setLocationRelativeTo(null);
						 closing();
						}
						});
		                 
	}
	private void executerAnnuler() {
		AnnulerBoutton.addActionListener(
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formulaireLaboratoire frame = new formulaireLaboratoire();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					//frame.btnNewButtonActionPerformed(null);
					//frame.executer();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public formulaireLaboratoire() {
		setTitle("FORMULAIRE DU FILIERE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("entrez les informations du nouveau laboratoire");
		lblNewLabel.setBounds(86, 11, 368, 17);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Id  :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(47, 40, 57, 15);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		Id_case = new JTextField();
		Id_case.setBounds(186, 38, 268, 20);
		Id_case.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nom :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(47, 71, 57, 15);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		Nom_case = new JTextField();
		Nom_case.setBounds(186, 69, 268, 20);
		Nom_case.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(47, 102, 57, 15);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		Email_case = new JTextField();
		Email_case.setBounds(186, 100, 268, 20);
		Email_case.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Id du responsable :");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(47, 133, 129, 15);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		respo_case = new JTextField();
		respo_case.setBounds(186, 131, 268, 20);
		respo_case.setColumns(10);
		
		btnNewButton.setIcon(null);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		AnnulerBoutton = new JButton("Annuler");
		AnnulerBoutton.setBounds(109, 185, 77, 23);
		AnnulerBoutton.setFont(new Font("Tahoma", Font.BOLD, 11));
		AnnulerBoutton.setForeground(Color.BLACK);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_4);
		contentPane.add(respo_case);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_3);
		contentPane.add(Id_case);
		contentPane.add(Nom_case);
		contentPane.add(Email_case);
		contentPane.add(AnnulerBoutton);
		contentPane.add(btnNewButton);
		this.executer();
		this.executerAnnuler();
	}
}
