package prasentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import metier.Departement;
import persistance.DaoDepartement;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class affichage_departement extends JFrame {

	//private JFrame frame;
	private JTextField txtidDep;
	private JTextField txtnom;
	private JTextField txtemail;
	
	 String idDep;
	 String nomDep;
	 String emailDep;
	 DaoDepartement DAO =new DaoDepartement();
	 List<Departement> L=DAO.getAll();
	 


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					affichage_departement window = new affichage_departement();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public affichage_departement() {
		initialize( );
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		setBounds(100, 100, 838, 603);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DEPARTEMENTS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 260, 39);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(26, 50, 59, 24);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom");
		lblNewLabel_1_1.setBounds(26, 84, 70, 24);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("e-mail");
		lblNewLabel_1_2.setBounds(26, 119, 59, 24);
		getContentPane().add(lblNewLabel_1_2);
		
		txtidDep = new JTextField();
		txtidDep.setColumns(10);
		txtidDep.setBounds(117, 52, 133, 20);
	    getContentPane().add(txtidDep);
		
		txtnom = new JTextField();
		txtnom.setColumns(10);
		txtnom.setBounds(117, 86, 133, 20);
		getContentPane().add(txtnom);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(117, 121, 133, 20);
		getContentPane().add(txtemail);
		
		JButton btnajouter = new JButton("+");
		btnajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 DaoDepartement DAO =new DaoDepartement();
				 
				 idDep=txtidDep.getText();
				 nomDep=txtnom.getText();
				 emailDep=txtemail.getText();
				 Departement DEP=new Departement(idDep,nomDep,emailDep);
				 DAO.save(DEP); 
			}
		});

		btnajouter.setBounds(219, 172, 41, 23);
		getContentPane().add(btnajouter);
		
		JButton btnsupp = new JButton("supprimer");
		btnsupp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DaoDepartement DAO =new DaoDepartement();
				 
				 idDep=txtidDep.getText();
				 DAO.delete(idDep); 
			}
		});
		btnsupp.setBounds(109, 172, 103, 23);
		getContentPane().add(btnsupp);
		
		JButton btnmodifier = new JButton("modifier");
		btnmodifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DaoDepartement DAO =new DaoDepartement();
				 
				 idDep=txtidDep.getText();
				 nomDep=txtnom.getText();
				 emailDep=txtemail.getText();
				 Departement DEP=new Departement(idDep,nomDep,emailDep);
				 DAO.update(DEP);; 		
				
				
				
			}
		});
		btnmodifier.setBounds(10, 172, 89, 23);
		getContentPane().add(btnmodifier);
		
		JList list = new JList(L.toArray());
		list.setBounds(314, 34, 470, 315);
		getContentPane().add(list);
	}
}
