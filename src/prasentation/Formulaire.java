package prasentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Formulaire extends JFrame {

	private JPanel contentPane;
	void colsing() {
		this.dispose();
	}
	public Formulaire() {
		setTitle("LISTE  DES PROJET");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("PFA");
		btnNewButton.setBounds(66, 134, 125, 36);
		btnNewButton.setBackground(new Color(102, 0, 153));
		btnNewButton.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setForeground(new Color(51, 102, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			PFAF f2=new PFAF();
			f2.show();
			f2.setLocationRelativeTo(null);
			colsing();
			
			}

		});
		
		JButton btnNewButton_1 = new JButton("DOCTORAT");
		btnNewButton_1.setBounds(66, 194, 125, 34);
		btnNewButton_1.setBackground(new Color(102, 0, 153));
		btnNewButton_1.setForeground(new Color(51, 102, 102));
		btnNewButton_1.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			FormuleDoctorat f2=new FormuleDoctorat();
			f2.show();
			f2.setLocationRelativeTo(null);
			colsing();
			}
		});
		
		JButton btnNewButton_2 = new JButton("PFE");
		btnNewButton_2.setBounds(258, 135, 125, 34);
		btnNewButton_2.setBackground(new Color(102, 0, 153));
		btnNewButton_2.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_2.setForeground(new Color(51, 102, 102));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			FormulairePFE f2=new FormulairePFE();
			f2.show();
			f2.setLocationRelativeTo(null);
			colsing();
			}
		});
		
		JButton btnNewButton_3 = new JButton("Etapes");
		btnNewButton_3.setBounds(258, 195, 125, 33);
		btnNewButton_3.setBackground(new Color(102, 0, 153));
		btnNewButton_3.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_3.setForeground(new Color(51, 102, 102));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				ETAPES f2=new ETAPES();
				f2.show();
				f2.setLocationRelativeTo(null);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Biblioth\u00E9que de tous les projets");
		lblNewLabel.setBounds(89, 61, 343, 49);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(Color.BLACK);
		
		JButton ButtonArriére = new JButton("");
		ButtonArriére.setBounds(10, 283, 49, 49);
		ButtonArriére.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EspaceAdministration f=new EspaceAdministration();
				f.setVisible(true);
				f.setLocationRelativeTo(null);
			}
		});
		ButtonArriére.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\circled-left--v3.png"));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_3);
		contentPane.add(ButtonArriére);
	}
}
