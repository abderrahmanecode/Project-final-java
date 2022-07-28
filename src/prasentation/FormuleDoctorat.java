package prasentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import metier.Doctorat;
import metier.ProjetPFA;
import persistance.connexion;
import persistance.DAOProjetdoctorat;
import persistance.DAOProjetpfa;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;

public class FormuleDoctorat extends JFrame {
 
	private JPanel contentPane;
	connexion conn=new connexion();
	Statement stm;
	ResultSet rs;
		DefaultTableModel model = new DefaultTableModel(); 
	private JTable table;
	private JTextField textid;
	private JTextField textT;
	private JTextField textmc;
	private JTextField textd;
	private JTextField textdd;
	private JTextField textp;
	private JTextField textm;
	private JTextField textlabo;
     
	private void deplace(int i) {
		try {
			textid.setText(model.getValueAt(i, 0).toString());
			textT.setText(model.getValueAt(i, 1).toString());
			textmc.setText(model.getValueAt(i, 2).toString());
			textd.setText(model.getValueAt(i, 3).toString());
			textdd.setText(model.getValueAt(i, 4).toString());
			textp.setText(model.getValueAt(i, 5).toString());
			textm.setText(model.getValueAt(i, 6).toString());
			textlabo.setText(model.getValueAt(i, 7).toString());
		}catch(Exception e) {System.err.println(e);
		JOptionPane.showMessageDialog(null, "erruer de deplacement"+e.getLocalizedMessage());}
		}
	
	public FormuleDoctorat() {
		setTitle("PROJET DOCTORAT\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 364);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JTable();
		table.setBounds(231, 10, 435, 248);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				try {
					int i=table.getSelectedRow();
					deplace(i);
					}catch(Exception e ) {JOptionPane.showMessageDialog(null, "erruer de deplacement"+e  .getLocalizedMessage());}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
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
			ResultSet res=stm.executeQuery("SELECT * FROM doctorat");
			while(res.next()) {
				model.addRow(new Object[] {res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getDate(5),res.getString(6),res.getString(7),res.getString(8),});


			}
		}catch(Exception e) {System.err.println(e);}
		
		 table.setModel(model);
		textid = new JTextField();
		textid.setBounds(125, 13, 86, 20);
		textid.setColumns(10);
		
		textT = new JTextField();
		textT.setBounds(128, 44, 86, 20);
		textT.setColumns(10);
		
		textmc = new JTextField();
		textmc.setBounds(125, 73, 86, 20);
		textmc.setColumns(10);
		
		textd = new JTextField();
		textd.setBounds(135, 102, 86, 20);
		textd.setColumns(10);
		
		textdd = new JTextField();
		textdd.setBounds(125, 135, 86, 20);
		textdd.setColumns(10);
		
		textp = new JTextField();
		textp.setBounds(125, 165, 86, 20);
		textp.setColumns(10);
		
		textm = new JTextField();
		textm.setBounds(125, 190, 86, 20);
		textm.setColumns(10);
		
		textlabo = new JTextField();
		textlabo.setBounds(125, 221, 86, 20);
		textlabo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID projet");
		lblNewLabel.setBounds(10, 10, 83, 22);
		lblNewLabel.setForeground(new Color(128, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		
		JLabel lblNewLabel_1 = new JLabel("Titre de projet");
		lblNewLabel_1.setBounds(10, 41, 108, 22);
		lblNewLabel_1.setForeground(new Color(128, 0, 128));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		
		JLabel lblNewLabel_2 = new JLabel("Dur\u00E9e");
		lblNewLabel_2.setBounds(10, 70, 101, 22);
		lblNewLabel_2.setForeground(new Color(128, 0, 128));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		
		JLabel lblNewLabel_3 = new JLabel("Date de depart");
		lblNewLabel_3.setBounds(10, 99, 115, 22);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_3.setForeground(new Color(128, 0, 128));
		
		JLabel lblNewLabel_4 = new JLabel("Mot-Cle");
		lblNewLabel_4.setBounds(10, 132, 126, 22);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_4.setForeground(new Color(128, 0, 128));
		
		JLabel lblNewLabel_5 = new JLabel("Professeur");
		lblNewLabel_5.setBounds(10, 162, 126, 22);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_5.setForeground(new Color(128, 0, 128));
		
		JLabel lblNewLabel_6 = new JLabel("Menbre");
		lblNewLabel_6.setBounds(10, 187, 126, 22);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_6.setForeground(new Color(128, 0, 128));
		
		JLabel lblNewLabel_7 = new JLabel("Laboratoire");
		lblNewLabel_7.setBounds(10, 218, 105, 22);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_7.setForeground(new Color(128, 0, 128));
		
		JButton btnNewButton = new JButton("Creation");
		btnNewButton.setBounds(10, 267, 126, 27);
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setBackground(new Color(128, 0, 128));
		btnNewButton.setFont(new Font("SimSun", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				 String id=textid.getText();
				 String titre=textT.getText();
				 String motcle=textmc.getText();
				 String duree=textd.getText();
				 String dateDepart=textdd.getText();
				 String idP=textp.getText();
				 String mem=textm.getText();
				 String idLabo=textlabo.getText();
				
				 try {
					 
					DAOProjetdoctorat dao=new DAOProjetdoctorat();
					Doctorat d=new Doctorat(id,titre,motcle,duree,dateDepart,idP,mem,idLabo);
					dao.Creation(d);
					JOptionPane.showMessageDialog(null, "bien ajouter");
					/*textid.setText("");textT.setText("");textmc.setText("");textd.setText("");textdd.setText("");
					textp.setText("");texte.setText("");textlabo.setText("");*/
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					
				 JOptionPane.showMessageDialog(null, "erruer de deplacement"+e  .getLocalizedMessage());}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Actualiser");
		btnNewButton_1.setBounds(163, 267, 125, 27);
		btnNewButton_1.setBackground(new Color(128, 0, 128));
		btnNewButton_1.setFont(new Font("SimSun", Font.PLAIN, 15));
		btnNewButton_1.setForeground(new Color(0, 128, 128));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					model.setRowCount(0);
					stm=conn.getConnexion().createStatement();
					ResultSet res=stm.executeQuery("SELECT * FROM doctorat");
					while(res.next()) {
						model.addRow(new Object[] {res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getDate(5),res.getString(6),res.getString(7),res.getString(8),});


					}
				}catch(Exception e) {System.err.println(e);}
				 table.setModel(model);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Modifier");
		btnNewButton_2.setBounds(310, 267, 111, 27);
		btnNewButton_2.setFont(new Font("SimSun", Font.PLAIN, 15));
		btnNewButton_2.setBackground(new Color(128, 0, 128));
		btnNewButton_2.setForeground(new Color(0, 128, 128));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String id=textid.getText();
				 String titre=textT.getText();
				 String motcle=textmc.getText();
				 String duree=textd.getText();
				 String dateDepart=textdd.getText();
				 String idP=textp.getText();
				 String mem=textm.getText();
				 String idLabo=textlabo.getText();
				 try {
					 if(JOptionPane.showConfirmDialog(null, "confirmer la modification","modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION) {
							DAOProjetdoctorat dao=new DAOProjetdoctorat();
							Doctorat d=new Doctorat(id,titre,motcle,duree,dateDepart,idP,mem,idLabo);
							dao.Modifier(d);
					 }
				 }catch (SQLException | IOException e) {
						// TODO Auto-generated catch block
						
					 JOptionPane.showMessageDialog(null, "erruer de modification"+e  .getLocalizedMessage());} 
			}
			
		});
		
		JButton btnNewButton_3 = new JButton("Supprimer");
		btnNewButton_3.setBounds(431, 267, 115, 27);
		btnNewButton_3.setBackground(new Color(128, 0, 128));
		btnNewButton_3.setFont(new Font("SimSun", Font.PLAIN, 15));
		btnNewButton_3.setForeground(new Color(0, 128, 128));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String titre=textT.getText();
				try {
					
					 if(JOptionPane.showConfirmDialog(null, "Attention vous avez sur de supprimer ce projet","supprimer",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION) {
						if(titre.length()!=0) {
							DAOProjetdoctorat dao=new DAOProjetdoctorat();
							Doctorat d=new Doctorat(titre);
								dao.Supprimer(d);
						}
						//else{(JOptionPane.showMessageDialog(null, "titre inconnu");}
					 }
				 }catch (SQLException | IOException e) {
						// TODO Auto-generated catch block
						
					 JOptionPane.showMessageDialog(null, "erruer de supression"+e  .getLocalizedMessage());} 
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_3);
		contentPane.add(lblNewLabel_4);
		contentPane.add(lblNewLabel_5);
		contentPane.add(lblNewLabel_7);
		contentPane.add(lblNewLabel_6);
		contentPane.add(textid);
		contentPane.add(textT);
		contentPane.add(textmc);
		contentPane.add(textd);
		contentPane.add(textdd);
		contentPane.add(textp);
		contentPane.add(textm);
		contentPane.add(textlabo);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_3);
		contentPane.add(table);
		
		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formulaire F=new Formulaire();
				F.setVisible(true);
				F.setLocationRelativeTo(null);
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_4.setBounds(573, 291, 72, 23);
		contentPane.add(btnNewButton_4);
	}

}
