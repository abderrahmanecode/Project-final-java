package prasentation;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import metier.Etape;
import metier.ProjetPFA;
import persistance.connexion;
import persistance.DAOProjetpfa;
import persistance.DAOetape;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Font;
import java.awt.Color;

public class ETAPES extends JFrame {

	private JPanel contentPane;
	connexion conn=new connexion();
	
	Statement stm;
	ResultSet rs;
	DefaultTableModel model = new DefaultTableModel(); 
	private JTable table;
	private JTextField textT;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textpro;
	private JTextField textid;
	private JTextField textdd;
	private JTextField texted;
	private JTextField textidp;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JLabel lblNewLabel_5;
	private void deplace(int i) {
		try {
			textidp.setText(model.getValueAt(i, 0).toString());
			texted.setText(model.getValueAt(i, 1).toString());
			textdd.setText(model.getValueAt(i, 2).toString());
			textid.setText(model.getValueAt(i, 3).toString());
			textpro.setText(model.getValueAt(i, 4).toString());
			

		}catch(Exception e) {System.err.println(e);
		JOptionPane.showMessageDialog(null, "erruer de deplacement"+e.getLocalizedMessage());}
	
	}

	
	public ETAPES() {
		setTitle("EATPES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 299);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JTable();
		table.setBounds(252, 79, 285, 80);
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
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"idEtape", "etape depart", "Dur\u00E9e", "idProjet", "titre Projet"
			}
		));
		table.getColumnModel().getColumn(4).setPreferredWidth(93);
		
		textT = new JTextField();
		textT.setBounds(169, 8, 206, 27);
		textT.setColumns(10);
		
		JButton btnNewButton = new JButton("Recherche");
		btnNewButton.setBounds(385, 4, 111, 31);
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				model.addColumn("idP");
				model.addColumn("etapeD");
				model.addColumn("dureeEtape");
				model.addColumn("id");
				model.addColumn("titrepro");
				try {
				    model.setRowCount(0);
				    {
				    	stm=conn.getConnexion().createStatement();
						
						 rs =stm.executeQuery("SELECT * FROM etape WHERE titrepro='"+textT.getText()+"'");	
				    }while(rs.next()) {
				    	model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
				    	//model.addRow(ep);
				   
				    }if (model.getRowCount()==0) {JOptionPane.showMessageDialog(null, "il y a aucun etape ");
				    
				    }else {int i=0;
				      deplace(i);	
				    }
				}catch(Exception e) {
					System.err.println(e);
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				    
				table.setModel(model);
				
			}
		});
		
		lblNewLabel = new JLabel("Etape D\u00E9part");
		lblNewLabel.setBounds(10, 73, 121, 22);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel.setForeground(new Color(102, 0, 102));
		
		lblNewLabel_1 = new JLabel("Dur\u00E9e d'etape");
		lblNewLabel_1.setBounds(10, 102, 121, 22);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_1.setForeground(new Color(102, 0, 102));
		
		lblNewLabel_2 = new JLabel("Id projet");
		lblNewLabel_2.setBounds(10, 130, 121, 22);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_2.setForeground(new Color(102, 0, 102));
		
		lblNewLabel_3 = new JLabel("Titre de projet");
		lblNewLabel_3.setBounds(10, 163, 108, 22);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_3.setForeground(new Color(102, 0, 102));
		
		lblNewLabel_4 = new JLabel("ID Etape");
		lblNewLabel_4.setBounds(10, 40, 89, 22);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_4.setForeground(new Color(102, 0, 102));
		
		textpro = new JTextField();
		textpro.setBounds(156, 166, 86, 20);
		textpro.setColumns(10);
		
		textid = new JTextField();
		textid.setBounds(156, 133, 86, 20);
		textid.setColumns(10);
		
		textdd = new JTextField();
		textdd.setBounds(156, 105, 86, 20);
		textdd.setColumns(10);
		
		texted = new JTextField();
		texted.setBounds(156, 77, 86, 20);
		texted.setColumns(10);
		
		textidp = new JTextField();
		textidp.setBounds(156, 46, 86, 20);
		textidp.setColumns(10);
		
		btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.setBounds(10, 196, 105, 27);
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("SimSun", Font.PLAIN, 15));
		btnNewButton_1.setForeground(new Color(51, 102, 102));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				 String id=textidp.getText();
				 String titre=texted.getText();
				 String motcle=textdd.getText();
				 String duree=textid.getText();
				 String dateDepart=textpro.getText();
				 
				
				 try {
					 
					 DAOetape dao=new DAOetape();
					 Etape p=new Etape(id,titre,motcle,duree,dateDepart);
					 dao.Ajouter(p);
					JOptionPane.showMessageDialog(null, "bien ajouter");
					/*textid.setText("");textT.setText("");textmc.setText("");textd.setText("");textdd.setText("");
					textp.setText("");texte.setText("");textlabo.setText("");*/
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					
				 JOptionPane.showMessageDialog(null, "erruer de deplacement"+e  .getLocalizedMessage());}
			}
		});
		
		btnNewButton_2 = new JButton("Actualiser");
		btnNewButton_2.setBounds(403, 196, 113, 27);
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("SimSun", Font.PLAIN, 15));
		btnNewButton_2.setForeground(new Color(51, 102, 102));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				model.addColumn("idP");
				model.addColumn("etapeD");
				model.addColumn("dureeEtape");
				model.addColumn("id");
				model.addColumn("titrepro");
				try {
				    model.setRowCount(0);
				    {
				    	stm=conn.getConnexion().createStatement();
						
						 rs =stm.executeQuery("SELECT * FROM etape WHERE titrepro='"+textT.getText()+"'");	
				    }while(rs.next()) {
				    	model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
				    	//model.addRow(ep);
				   
				    
				    }
				}catch(Exception e) {
					System.err.println(e);
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				    
				table.setModel(model);
				
			}
		});
		
		btnNewButton_3 = new JButton("Supprimer");
		btnNewButton_3.setBounds(137, 196, 105, 27);
		btnNewButton_3.setForeground(new Color(51, 102, 102));
		btnNewButton_3.setFont(new Font("SimSun", Font.PLAIN, 15));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String titre=textidp.getText();
				try {
					
					 if(JOptionPane.showConfirmDialog(null, "Attention vous avez sur de supprimer ce projet","supprimer",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION) {
						if(titre.length()!=0) {
							DAOetape dao=new DAOetape();
							 Etape p=new Etape(titre);
								dao.Delet(p);
						}
						//else{(JOptionPane.showMessageDialog(null, "titre inconnu");}
					 }
				 }catch (SQLException | IOException e) {
						// TODO Auto-generated catch block
						
					 JOptionPane.showMessageDialog(null, "erruer de supression"+e  .getLocalizedMessage());} 
			}
		});
		
		btnNewButton_4 = new JButton("Modifier");
		btnNewButton_4.setBounds(270, 196, 113, 27);
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setFont(new Font("SimSun", Font.PLAIN, 15));
		btnNewButton_4.setForeground(new Color(51, 102, 102));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String id=textidp.getText();
				 String titre=texted.getText();
				 String motcle=textdd.getText();
				 String duree=textid.getText();
				 String dateDepart=textpro.getText();
				 
				
				 try {
					 if(JOptionPane.showConfirmDialog(null, "confirmer la modification","modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION) {
					 DAOetape dao=new DAOetape();
					 Etape p=new Etape(id,titre,motcle,duree,dateDepart);
					dao.Modifier(p);
					 }
				 }catch (SQLException | IOException e) {
						// TODO Auto-generated catch block
						
					 JOptionPane.showMessageDialog(null, "erruer de modification"+e  .getLocalizedMessage());}
			}
		});
		
		lblNewLabel_5 = new JLabel("Entrez le titre de projet :");
		lblNewLabel_5.setBounds(10, 11, 171, 18);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		contentPane.setLayout(null);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton_3);
		contentPane.add(btnNewButton_4);
		contentPane.add(btnNewButton_2);
		contentPane.add(lblNewLabel_5);
		contentPane.add(textT);
		contentPane.add(btnNewButton);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_3);
		contentPane.add(lblNewLabel_4);
		contentPane.add(textidp);
		contentPane.add(textid);
		contentPane.add(texted);
		contentPane.add(textdd);
		contentPane.add(table);
		contentPane.add(textpro);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Formulaire E=new Formulaire();
				E.setVisible(true);
				E.setLocationRelativeTo(null);
				
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(440, 234, 76, 23);
		contentPane.add(btnBack);
	}
}
