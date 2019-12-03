package sample;

public class AllApprenant {

    private String nom, prenom, specialite;

    public AllApprenant(String nom, String prenom, String specialite){
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    public String toString(){
        return nom+" "+prenom+" "+specialite;
    }
}
