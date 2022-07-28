package prasentation;

	public class controlleur {


		public controlleur() {
			super();
		}
		
		public void demmarrer() {
			Acceuil f=new Acceuil();
			f.setVisible(true);
			f.setLocationRelativeTo(null);
			
			//Espace_filiere espace_filiere = new Espace_filiere(this);
			//espace_filiere.show();
		}
		public void affichetout() {
			affichage_filieres frame =new affichage_filieres();
			frame.show();
			frame.setLocationRelativeTo(null);

		}
		public void modifier() {
			Modifier frame= new Modifier();
			frame.show();
			frame.setLocationRelativeTo(null);

		}
        public void supprimer() {
        	Delete_Filiere frame = new Delete_Filiere();
        	frame.show();
			frame.setLocationRelativeTo(null);

		}
        public void affiche() {
			Affiche1 frame=new Affiche1();
			frame.show();
			frame.setLocationRelativeTo(null);

		} 
         public void ajouter() {
        	 FormulaireFiliere frame = new FormulaireFiliere();
        	 frame.show();
				frame.setLocationRelativeTo(null);

		} 
         public void ajouterLabo() {
        	 formulaireLaboratoire frame = new formulaireLaboratoire();
        	 frame.show();
				frame.setLocationRelativeTo(null);

		} 
         public void ajouterMembre() {
        	 formulaireMembre frame = new formulaireMembre();
        	 frame.show();
			frame.setLocationRelativeTo(null);

		} 
         public void deleteMembre() {
        	 DeleteMembre frame = new DeleteMembre();
        	 frame.show();
				frame.setLocationRelativeTo(null);

		} 
         public void listerMembres() {
        	 AffichetoutMb frame = new AffichetoutMb();
        	 frame.show();
				frame.setLocationRelativeTo(null);

		} 
         public void affiche_labo() {
        	 AfficheLabo frame = new AfficheLabo();
        	 frame.show();
				frame.setLocationRelativeTo(null);

		} 
         public void affiche_labo_tout() {
        	 Affichage_tout_labo frame = new Affichage_tout_labo();
        	 frame.show();
				frame.setLocationRelativeTo(null);

		} 
         public void deleteLabo() {
        	 Delete_labo frame = new  Delete_labo();
        	 frame.show();
				frame.setLocationRelativeTo(null);

		} 
         public void modifierlabo() {
 			UpdateLabo frame= new UpdateLabo();
 			frame.show();
			frame.setLocationRelativeTo(null);

 		}
}