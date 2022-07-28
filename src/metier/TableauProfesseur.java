package metier;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;



public class TableauProfesseur extends AbstractTableModel {
	private ArrayList<Professeur> list;
   private Etudiant etd;
	public TableauProfesseur(ArrayList<Professeur> list) {
		super();
		this.list = list;
	}
	

	public TableauProfesseur(Etudiant etd) {
		super();
		this.etd = etd;
	}


	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return Etudiant.getAttributs().length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.list.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		 return this.list.get(rowIndex).get(columnIndex);
	}
	@Override
	 public String getColumnName(int i){
		return Professeur.getAttributs()[i];
	}
	@Override
	public Class getColumnClass(int i ) {
		switch (i){
		case 0 : return String.class;
		case 1 : return String.class;
		case 2 : return String.class;
		case 3 : return String.class;
		case 4 : return String.class;
		case 5 : return String.class;
		}
		return Object.class;
	}
	@Override
	public  boolean isCellEditable(int ligne, int colonne){
		return true;
	}
	@Override
	public void setValueAt(Object o, int i,int j){
		switch (j){
		case 0 : this.list.get(i).setId_depart((String)o) ;
		case 1 : this.list.get(i).setIdP((String) o);
		case 2 : this.list.get(i).setNom((String) o);
		case 3 : this.list.get(i).setPrenom((String) o);
		case 4 : this.list.get(i).setEmail((String) o);
		case 5 : this.list.get(i).setGrade((String) o);
		case 6 : this.list.get(i).setRole((String) o);
		}
	}

}

