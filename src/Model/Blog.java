package Model;

import java.sql.Date;

public class Blog {

	private String nomB,contenu, image1, image2,createur, proposC;
	private int numB,numUser;
	private boolean partager;

	public Blog( int numB,String nomB, String contenu, String image1, String image2, int numUser, String createur, String proposC, boolean partager) {
		this.setNumB(numB);
		this.setNomB(nomB);
		this.setContenu(contenu);
		this.setImage1(image1);
		this.setImage2(image2);
		this.setNumUser(numUser);
		this.setCreateur(createur);
		this.setPartager(partager);
		this.setProposC(proposC);
		
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

	public String getProposC() {
		return proposC;
	}

	public void setProposC(String proposC) {
		this.proposC = proposC;
	}

	public int getNumB() {
		return numB;
	}

	public void setNumB(int numB) {
		this.numB = numB;
	}
}
