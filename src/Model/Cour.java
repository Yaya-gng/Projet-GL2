package Model;

import java.sql.Date;

public class Cour extends Formation{
	
	private int numC, numF;
	private String module,titre,contenu;
		
	public Cour(int numC, int numF, String module, String titre, String contenu,String nomF, Date dateC, int id) {
		super(numF,nomF,dateC,id);
		this.numC = numC;
		this.numF = numF;
		this.module = module;
		this.titre = titre;
		this.contenu = contenu;
	}
	
	public int getNumC() {
		return numC;
	}
	public void setNumC(int numC) {
		this.numC = numC;
	}
	public int getNumF() {
		return numF;
	}
	public void setNumF(int numF) {
		this.numF = numF;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	
	

}