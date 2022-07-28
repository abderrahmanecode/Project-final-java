package prasentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.Membre;
import metier.filiere;
import persistance.connexion;
import persistance.filiereDao;
import persistance.membreDao;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

public class AffichetoutMb extends JFrame {

	private JPanel contentPane;
	
	
	JButton ButtonRtour = new JButton("back");
	private JTextField Id_CASE;
	JButton ButtonOK = new JButton("OK");
	JLabel lblNewLabel_2 = new JLabel();
	String Id;
	List<Membre> liste;
	private void closing() {
		this.dispose();
	}
	private void executer() {
		ButtonRtour.setBounds(427, 225, 65, 25);
		ButtonRtour.addActionListener(
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
	private void executerButtonOK() {
		ButtonOK.setBounds(423, 33, 49, 23);
		ButtonOK.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Id=Id_CASE.getText();
						membreDao dao=new membreDao();
						liste=dao.getAllByIdLabo(Id);
						lblNewLabel_2.setText("execute"+liste.toString());
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
					affichage_filieres frame = new affichage_filieres();
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
	public AffichetoutMb() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,593, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel lblNewLabel = new JLabel(" LES MEMBRES:");
		lblNewLabel.setBounds(383, 10, 159, 17);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		ButtonRtour.setFont(new Font("Tahoma", Font.BOLD, 14));
		ButtonRtour.setForeground(Color.BLACK);
		
		Id_CASE = new JTextField();
		Id_CASE.setBounds(171, 35, 218, 20);
		Id_CASE.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Entrez Id du laboratoire:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 38, 152, 14);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		
		ButtonOK.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.setLayout(null);
		contentPane.add(ButtonRtour);
		lblNewLabel_2.setBounds(10, 63, 567, 163);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel);
		contentPane.add(Id_CASE);
		contentPane.add(ButtonOK);
		this.executer();
		this.executerButtonOK();
	}
}
