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

import metier.ProjetPFA;
import metier.ProjetPFE;
import persistance.connexion;
import persistance.DAOProjetpfa;
import persistance.DAOProjetpfe;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;

public class FormulairePFE extends JFrame {

	private JPanel contentPane;
	connexion conn=new connexion();
	Statement stm;
	ResultSet rs;
		DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	private JTextField textlabo;
	private JTextField texte;
	private JTextField textp;
	private JTextField textdd;
	private JTextField textd;
	private JTextField textmc;
	private JTextField textT;
	private JTextField textid;
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
	
	
	public FormulairePFE() {
		setTitle("PROJET FIN D'ETUDE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 539);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JTable();
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
			ResultSet res=stm.executeQuery("SELECT * FROM projetpfe");
			while(res.next()) {
				model.addRow(new Object[] {res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getDate(5),res.getInt(6),res.getInt(7),res.getInt(8),});


			}
		}catch(Exception e) {System.err.println(e);}
		
		 table.setModel(model);
		JButton btnNewButton = new JButton("Creation");
		btnNewButton.setToolTipText("bn\r\n");
		btnNewButton.setBackground(new Color(128, 0, 128));
		btnNewButton.setFont(new Font("SimSun", Font.PLAIN, 16));
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
					 
					DAOProjetpfe dao=new DAOProjetpfe();
					ProjetPFE p=new ProjetPFE(id,titre,motcle,duree,dateDepart,idP,idEnt,idLabo);
					dao.Creation(p);
					JOptionPane.showMessageDialog(null, "bien ajouter");
					/*textid.setText("");textT.setText("");textmc.setText("");textd.setText("");textdd.setText("");
					textp.setText("");texte.setText("");textlabo.setText("");*/
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					
				 JOptionPane.showMessageDialog(null, "erruer de deplacement"+e  .getLocalizedMessage());}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Supprimer");
		btnNewButton_1.setBackground(new Color(128, 0, 128));
		btnNewButton_1.setForeground(new Color(0, 128, 128));
		btnNewButton_1.setFont(new Font("SimSun", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String titre=textT.getText();
				try {
					
					 if(JOptionPane.showConfirmDialog(null, "Attention vous avez sur de supprimer ce projet","supprimer",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION) {
						if(titre.length()!=0) {
							 DAOProjetpfe dao=new DAOProjetpfe();
								ProjetPFE p=new ProjetPFE(titre); 
								dao.Supprimer(p);
						}
						//else{(JOptionPane.showMessageDialog(null, "titre inconnu");}
					 }
				 }catch (SQLException | IOException e) {
						// TODO Auto-generated catch block
						
					 JOptionPane.showMessageDialog(null, "erruer de supression"+e  .getLocalizedMessage());} 
			}
		});
		
		JButton btnNewButton_2 = new JButton("Actualiser");
		btnNewButton_2.setBackground(new Color(128, 0, 128));
		btnNewButton_2.setFont(new Font("SimSun", Font.PLAIN, 16));
		btnNewButton_2.setForeground(new Color(0, 128, 128));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					model.setRowCount(0);
					stm=conn.getConnexion().createStatement();
					ResultSet res=stm.executeQuery("SELECT * FROM projetpfe");
					while(res.next()) {
						model.addRow(new Object[] {res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getDate(5),res.getInt(6),res.getInt(7),res.getInt(8),});


					}
				}catch(Exception e) {System.err.println(e);}
				 table.setModel(model);
				
			}
		});
		JButton btnNewButton_3 = new JButton("Modifier");
		btnNewButton_3.setForeground(new Color(0, 128, 128));
		btnNewButton_3.setFont(new Font("SimSun", Font.PLAIN, 15));
		btnNewButton_3.setBackground(new Color(128, 0, 128));
		btnNewButton_3.addActionListener(new ActionListener() {
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
						 DAOProjetpfe dao=new DAOProjetpfe();
							ProjetPFE p=new ProjetPFE(id,titre,motcle,duree,dateDepart,idP,idEnt,idLabo); 
							dao.Modifier(p);
					 }
				 }catch (SQLException | IOException e) {
						// TODO Auto-generated catch block
						
					 JOptionPane.showMessageDialog(null, "erruer de modification"+e  .getLocalizedMessage());} 
			}
		});
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(new Color(75, 0, 130));
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		
		JLabel lblNewLabel_1 = new JLabel("Titre de projrt");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_1.setForeground(new Color(75, 0, 130));
		
		JLabel lblNewLabel_2 = new JLabel("Dur\u00E9e");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_2.setForeground(new Color(75, 0, 130));
		
		JLabel lblNewLabel_3 = new JLabel("Date de depart");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_3.setForeground(new Color(75, 0, 130));
		
		JLabel lblNewLabel_4 = new JLabel("Professeur");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_4.setForeground(new Color(75, 0, 130));
		
		JLabel lblNewLabel_5 = new JLabel("Mot-Cle");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_5.setForeground(new Color(72, 61, 139));
		
		JLabel lblNewLabel_6 = new JLabel("Entreprise");
		lblNewLabel_6.setForeground(new Color(75, 0, 130));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		
		JLabel lblNewLabel_7 = new JLabel("Laboratoire");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_7.setForeground(new Color(75, 0, 130));
		
		textlabo = new JTextField();
		textlabo.setColumns(10);
		
		texte = new JTextField();
		texte.setColumns(10);
		
		textp = new JTextField();
		textp.setColumns(10);
		
		textdd = new JTextField();
		textdd.setColumns(10);
		
		textd = new JTextField();
		textd.setColumns(10);
		
		textmc = new JTextField();
		textmc.setColumns(10);
		
		textT = new JTextField();
		textT.setColumns(10);
		
		textid = new JTextField();
		textid.setColumns(10);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(84))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
								.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
										.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							.addGap(18)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textdd)
								.addComponent(textd)
								.addComponent(textmc)
								.addComponent(textid, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
								.addComponent(textT)
								.addComponent(textp)
								.addComponent(texte, Alignment.TRAILING)
								.addComponent(textlabo))
							.addPreferredGap(ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(57)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(textid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_5)
								.addComponent(textmc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(textd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(textdd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(textp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_6)
								.addComponent(texte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_7)
								.addComponent(textlabo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(47)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)))
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_2))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
