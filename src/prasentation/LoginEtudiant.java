package prasentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import persistance.gestionAdmin;
import persistance.gestionEtudiant;

public class LoginEtudiant extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private String email;
	private String id;
    public void fermer() {
    	dispose();
    }
	public LoginEtudiant() {
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
		
		JLabel lblNewLabel = new JLabel("Espace d'Etudiant");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(146, 41, 233, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Votre email :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblNewLabel_1.setBounds(115, 106, 105, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Votre identifiant :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(115, 150, 137, 20);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(293, 108, 160, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		Border  borderField_1=BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		textField.setBorder(borderField_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(293, 148, 160, 29);
		contentPane.add(textField_1);
		Border  borderField_2=BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		textField_1.setBorder(borderField_2);
		
		
		
		JButton btnNewButton = new JButton("Connexion");
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(50,205,50));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(128,128,128));
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				email=textField.getText();
				id=textField_1.getText();
				gestionEtudiant Admin=new gestionEtudiant();
				if(Admin.ExsiteEtudiant(email,id)==true) {
					dispose();
					//Admin.Exsite(email,identifiant);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(204, 201, 137, 23);
		contentPane.add(btnNewButton);
		
		JButton ButtonArriére = new JButton("");
		ButtonArriére.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Acceuil f=new Acceuil();
				f.setVisible(true);
				f.setLocationRelativeTo(null);
			}
		});
		ButtonArriére.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\circled-left--v3.png"));
		ButtonArriére.setBounds(10, 201, 49, 49);
		contentPane.add(ButtonArriére);
		
	}

}
