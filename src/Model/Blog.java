package Model;

import java.sql.Date;

public class Blog {

	private String nomB,contenu, image1, image2,createur;
	private int numUser;
	private boolean partager;

	public Blog( String nomB, String contenu, String image1, String image2, int numUser, String createur, boolean partager) {
		this.setNomB(nomB);
		this.setContenu(contenu);
		this.setImage1(image1);
		this.setImage2(image2);
		this.setNumUser(numUser);
		this.setCreateur(createur);
		this.setPartager(partager);
		
	}

	public String getNomB() {
		return nomB;
	}
	public void setNomB(String nomB) {
		this.nomB = nomB;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getCreateur() {
		return createur;
	}

	public void setCreateur(String createur) {
		this.createur = createur;
	}

	public int getNumUser() {
		return numUser;
	}

	public void setNumUser(int numUser) {
		this.numUser = numUser;
	}

	public boolean isPartager() {
		return partager;
	}

	public void setPartager(boolean partager) {
		this.partager = partager;
	}
}
