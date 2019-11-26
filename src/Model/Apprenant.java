package Model;

import java.sql.Date;

public class Apprenant extends User implements GestionResInsApp{

	private int matricule;
	private String section,niveau,filiere,specialite;
	
	public Apprenant(int matricule,String nom, String prenom, Date date, String adresse,int tel,String password ,String s,String niv,String sp) {
		super(nom, prenom, date, adresse,tel,password);
		
		this.matricule = matricule;
		section = s;
		niveau = niv;
		
		specialite = sp;
	
	}
	
	public void setMatricule(int mat) {
		matricule = mat;
	}
	public int getMatricule() {
		return matricule;
	}
	
	public String getSection() {
		return section;
	}
	
	public void setSection(String s) {
		section = s;
	}
	
	public String getNiv() {
		return niveau;
	}
	
	public void setNiv(String n) {
		niveau = n;
	}
	
	public String getfiliere() {
		return filiere;
	}
	
	public void setFiliere(String f) {
		filiere = f;
	}
	
	public String getSpec() {
		return specialite;
	}
	
	public void setSpec(String sp) {
		specialite = sp;
	}

	@Override
	public void deposer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gererDroitA(Apprenant a) {
		// TODO Auto-generated method stub
		
	}

}
