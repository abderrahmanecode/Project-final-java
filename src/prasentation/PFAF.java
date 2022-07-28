package prasentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import metier.Etape;
import metier.ProjetPFA;
import persistance.connexion;
import persistance.DAOProjetpfa;
import persistance.DAOetape;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class PFAF extends JFrame {
	private JPanel contentPane;
	
	connexion conn=new connexion();
	Statement stm;
	ResultSet rs;
		DefaultTableModel model = new DefaultTableModel(); 
		private JTable table1;
		private JTextField textid;
		private JTextField textT;
		private JTextField textmc;
		private JTextField textd;
		private JTextField textdd;
		private JTextField textp;
		private JTextField texte;
		private JTextField textlabo;
		private JButton btnNewButton;
		private JButton btnActualiser;
		private JButton btnModifier;
		private JButton btnSupprimer;
		private JButton ButtonArriére;
		private void deplace(int i) {
			try {
				textid.setText(model.getValueAt(i, 0).toString());
				textT.setText(model.getValueAt(i, 1).toString());
				textmc.setText(model.getValueAt(i, 2).toString());
				textd.setText(model.getValueAt(i, 3).toString());
				textdd.setText(model.getValueAt(i, 4).toString());
				textp.setText(model.getValueAt(i, 5).toString());
				texte.setText(model.getValueAt(i, 6).toString());
				textlabo.setText(model.getValueAt(i, 7).toString());
			}catch(Exception e) {System.err.println(e);
			JOptionPane.showMessageDialog(null, "erruer de deplacement"+e.getLocalizedMessage());}
		
	
	
	   }
		public void colsing() {
			this.dispose();
		}
		
	public PFAF() {
		setTitle("PROJET EIN D'ANNEE");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 367);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table1 = new JTable();
		table1.setBounds(245, 21, 310, 196);
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				try {
					int i=table1.getSelectedRow();
					deplace(i);
					}catch(Exception e ) {JOptionPane.showMessageDialog(null, "erruer de deplacement"+e  .getLocalizedMessage());}
			}
			
		});
		table1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		model.addColumn("id");
		model.addColumn("titre");
		model.addColumn("motcle");
		model.addColumn("duree");
		model.addColumn("dateDepart");
		model.addColumn("nometape");
		model.addColumn("idP");
		model.addColumn("idEnt");
		model.addColumn("idLabo");
		try {
			stm=conn.getConnexion().createStatement();
			ResultSet res=stm.executeQuery("SELECT * FROM projetpfa");
			while(res.next()) {
				model.addRow(new Object[] {res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getDate(5),res.getString(6),res.getString(7),res.getString(8),});


			}
		}catch(Exception e) {System.err.println(e);}
		
		 table1.setModel(model);
		
		textid = new JTextField();
		textid.setBounds(114, 14, 86, 20);
		textid.setColumns(10);
		
		textT = new JTextField();
		textT.setBounds(114, 41, 86, 20);
		textT.setColumns(10);
		
		textmc = new JTextField();
		textmc.setBounds(114, 70, 86, 20);
		textmc.setColumns(10);
		
		textd = new JTextField();
		textd.setBounds(114, 100, 86, 20);
		textd.setColumns(10);
		
		textdd = new JTextField();
		textdd.setBounds(124, 132, 86, 20);
		textdd.setColumns(10);
		
		textp = new JTextField();
		textp.setBounds(114, 162, 86, 20);
		textp.setColumns(10);
		
		texte = new JTextField();
		texte.setBounds(114, 195, 86, 20);
		texte.setColumns(10);
		
		textlabo = new JTextField();
		textlabo.setBounds(114, 231, 86, 20);
		textlabo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID projet\r\n");
		lblNewLabel.setBounds(15, 11, 143, 22);
		lblNewLabel.setForeground(new Color(128, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		
		JLabel lblNewLabel_1 = new JLabel("Titre projet");
		lblNewLabel_1.setBounds(15, 38, 102, 22);
		lblNewLabel_1.setForeground(new Color(128, 0, 128));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		
		JLabel lblNewLabel_2 = new JLabel("Mot-Cle");
		lblNewLabel_2.setBounds(15, 67, 143, 22);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_2.setForeground(new Color(128, 0, 128));
		
		JLabel lblNewLabel_3 = new JLabel("Dur\u00E9e");
		lblNewLabel_3.setBounds(15, 96, 85, 22);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_3.setForeground(new Color(128, 0, 128));
		
		JLabel lblNewLabel_4 = new JLabel("Date e depart");
		lblNewLabel_4.setBounds(15, 129, 143, 22);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_4.setForeground(new Color(128, 0, 128));
		
		JLabel lblNewLabel_5 = new JLabel("Professeur");
		lblNewLabel_5.setBounds(15, 162, 107, 22);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_5.setForeground(new Color(128, 0, 128));
		
		JLabel lblNewLabel_6 = new JLabel("Entreprise");
		lblNewLabel_6.setBounds(15, 195, 106, 22);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_6.setForeground(new Color(128, 0, 128));
		
		JLabel lblNewLabel_7 = new JLabel("Laboratoire");
		lblNewLabel_7.setBounds(15, 228, 117, 22);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_7.setForeground(new Color(128, 0, 128));
		
		btnNewButton = new JButton("Creation");
		btnNewButton.setBounds(20, 261, 97, 27);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("SimSun", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				 String id=textid.getText();
				 String titre=textT.getText();
				 String motcle=textmc.getText();
				 String duree=textd.getText();
				 String dateDepart=textdd.getText();
				 String idP=textp.getText();
				 String idEnt=texte.getText();
				 String idLabo=textlabo.getText();
				
				 try {
					 
					DAOProjetpfa dao=new DAOProjetpfa();
					ProjetPFA p=new ProjetPFA(id,titre,motcle,duree,dateDepart,idP,idEnt,idLabo);
					dao.Creation(p);
					JOptionPane.showMessageDialog(null, "bien ajouter");
					/*textid.setText("");textT.setText("");textmc.setText("");textd.setText("");textdd.setText("");
					textp.setText("");texte.setText("");textlabo.setText("");*/
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					
				 JOptionPane.showMessageDialog(null, "erruer de deplacement"+e  .getLocalizedMessage());}
				 
			}
		});
		
		btnActualiser = new JButton("Actualiser");
		btnActualiser.setBounds(173, 262, 127, 27);
		btnActualiser.setFont(new Font("SimSun", Font.PLAIN, 15));
		btnActualiser.setForeground(new Color(0, 128, 128));
		btnActualiser.setBackground(new Color(255, 255, 255));
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					model.setRowCount(0);
					stm=conn.getConnexion().createStatement();
					ResultSet res=stm.executeQuery("SELECT * FROM projetpfa");
					while(res.next()) {
						model.addRow(new Object[] {res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getDate(5),res.getString(6),res.getString(7),res.getString(8),});


					}
				}catch(Exception e) {System.err.println(e);}
				 table1.setModel(model);
			}
		});
		
		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(326, 261, 107, 27);
		btnModifier.setFont(new Font("SimSun", Font.PLAIN, 15));
		btnModifier.setBackground(new Color(255, 255, 255));
		btnModifier.setForeground(new Color(0, 128, 128));
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				 String id=textid.getText();
				 String titre=textT.getText();
				 String motcle=textmc.getText();
				 String duree=textd.getText();
				 String dateDepart=textdd.getText();
				 String idP=textp.getText();
				 String idEnt=texte.getText();
				 String idLabo=textlabo.getText();
				 try {
					 if(JOptionPane.showConfirmDialog(null, "confirmer la modification","modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION) {
						 DAOProjetpfa dao=new DAOProjetpfa();
							ProjetPFA p=new ProjetPFA(id,titre,motcle,duree,dateDepart,idP,idEnt,idLabo); 
							dao.Modifier(p);
					 }
				 }catch (SQLException | IOException e) {
						// TODO Auto-generated catch block
						
					 JOptionPane.showMessageDialog(null, "erruer de modification"+e  .getLocalizedMessage());} 
			}
		});
		
		btnSupprimer = new JButton("supprimer");
		btnSupprimer.setBounds(455, 261, 130, 27);
		btnSupprimer.setBackground(new Color(255, 255, 255));
		btnSupprimer.setFont(new Font("SimSun", Font.PLAIN, 15));
		btnSupprimer.setForeground(new Color(0, 128, 128));
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String titre=textT.getText();
				try {
					
					 if(JOptionPane.showConfirmDialog(null, "Attention vous avez sur de supprimer ce projet","supprimer",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION) {
						if(titre.length()!=0) {
							 DAOProjetpfa dao=new DAOProjetpfa();
								ProjetPFA p=new ProjetPFA(titre); 
								dao.Supprimer(p);
						}
						//else{(JOptionPane.showMessageDialog(null, "titre inconnu");}
					 }
				 }catch (SQLException | IOException e) {
						// TODO Auto-generated catch block
						
					 JOptionPane.showMessageDialog(null, "erruer de supression"+e  .getLocalizedMessage());} 
			}
		});
		
		ButtonArriére = new JButton("Back");
		ButtonArriére.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ButtonArriére.setBounds(10, 299, 77, 22);
		ButtonArriére.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Formulaire f=new Formulaire();
				f.setVisible(true);
				f.setLocationRelativeTo(null);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_3);
		contentPane.add(lblNewLabel_4);
		contentPane.add(lblNewLabel_7);
		contentPane.add(lblNewLabel_5);
		contentPane.add(lblNewLabel_6);
		contentPane.add(textid);
		contentPane.add(textT);
		contentPane.add(textmc);
		contentPane.add(textdd);
		contentPane.add(textp);
		contentPane.add(texte);
		contentPane.add(textd);
		contentPane.add(textlabo);
		contentPane.add(table1);
		contentPane.add(btnNewButton);
		contentPane.add(btnActualiser);
		contentPane.add(btnModifier);
		contentPane.add(btnSupprimer);
		contentPane.add(ButtonArriére);
	}
	public JTextField getTextid() {
		return textid;
	}
	
	public JTextField getTextT() {
		return textT;
	}
	
	public void setTextid(JTextField textid) {
		this.textid = textid;
	}
	
	public void setTextT(JTextField textT) {
		this.textT = textT;
	}
}
