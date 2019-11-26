package Model;

import java.sql.Date;

public class Sondage {
	
	private int numS,vote,idIns;
	private String contenu;
	private Date dateC;
	
	public Sondage(int numS, String contenu, Date dateC, int vote, int id) {
		this.setNumS(numS);
		this.setContenu(contenu);
		this.setDateC(dateC);
		this.setVote(vote);
		setIdIns(id);
	}

	public int getNumS() {
		return numS;
	}

	public void setNumS(int numS) {
		this.numS = numS;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDateC() {
		return dateC;
	}

	public void setDateC(Date dateC) {
		this.dateC = dateC;
	}

	public int getIdIns() {
		return idIns;
	}

	public void setIdIns(int idIns) {
		this.idIns = idIns;
	}

	
	
	

}
