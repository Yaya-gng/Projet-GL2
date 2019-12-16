package Model;

public class Wiki {
	
	private int numW,numUser;
	private String nomW, problem, contenu, createur,editeur;

	public Wiki(int numW, String nomW, String problem, String contenu,int numUser, String createur, String editeur) {
		setNumW(numW);
		setNomW(nomW);
		setProblem(problem);
		setContenu(contenu);
		setNumUser(numUser);
		setCreateur(createur);
		setEditeur(editeur);
	}


	public int getNumW() {
		return numW;
	}

	public void setNumW(int numW) {
		this.numW = numW;
	}

	public int getNumUser() {
		return numUser;
	}

	public void setNumUser(int numUser) {
		this.numUser = numUser;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getCreateur() {
		return createur;
	}

	public void setCreateur(String createur) {
		this.createur = createur;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public String getNomW() {
		return nomW;
	}

	public void setNomW(String nomW) {
		this.nomW = nomW;
	}
}
