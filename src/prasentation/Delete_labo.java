package prasentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.filiere;
import persistance.connexion;
import persistance.filiereDao;
import persistance.laboratoireDoa;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Delete_labo extends JFrame {

	private JPanel contentPane;
	private JTextField Id_case;
	JButton deletebutton = new JButton("supprimer");
    private String id;
    private JButton ButtonAnnuler;
    
    private void closing() {
		this.dispose();
	}
    private void executer() {
    	deletebutton.setFont(new Font("Times New Roman", Font.BOLD, 17));
    	deletebutton.setBounds(95, 132, 111, 23);
    	deletebutton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						connexion conex=new connexion();
						controlleur controleur=new controlleur();
						id=Id_case.getText();
						laboratoireDoa nouveauDoa=new laboratoireDoa();
						nouveauDoa.delete(id);
						Espace_laboratoire frame= new Espace_laboratoire(controleur);
						frame.show();
						frame.setLocationRelativeTo(null);
						closing();
						}
						});
	}
    private void executerAnnuler() {
    	ButtonAnnuler.addActionListener(
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
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_Filiere frame = new Delete_Filiere();
					frame.setVisible(true);
					frame.executer();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Delete_labo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("veuillez enter Id du laboratoire que vous voulez supprimer:");
		lblNewLabel.setBounds(34, 28, 464, 31);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		Id_case = new JTextField();
		Id_case.setBounds(95, 83, 305, 20);
		Id_case.setColumns(10);
		
		deletebutton.setForeground(Color.BLACK);
		
		ButtonAnnuler = new JButton("Annuler");
		ButtonAnnuler.setBounds(308, 131, 92, 23);
		ButtonAnnuler.setForeground(Color.BLACK);
		ButtonAnnuler.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(Id_case);
		contentPane.add(ButtonAnnuler);
		contentPane.add(deletebutton);
		executer();
		executerAnnuler();
	}
}
