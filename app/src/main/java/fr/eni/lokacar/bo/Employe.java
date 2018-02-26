package fr.eni.lokacar.bo;

public class Employe {

    private int idEmploye;
    private String nomEmploye;
    private String prenomEmploye;
    private String emailEmploye;
    private String motDePasse;

    public Employe() {
    }

    public Employe(int idEmploye, String nomEmploye, String prenomEmploye, String emailEmploye, String motDePasse) {
        this.idEmploye = idEmploye;
        this.nomEmploye = nomEmploye;
        this.prenomEmploye = prenomEmploye;
        this.emailEmploye = emailEmploye;
        this.motDePasse = motDePasse;
    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getNomEmploye() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public String getPrenomEmploye() {
        return prenomEmploye;
    }

    public void setPrenomEmploye(String prenomEmploye) {
        this.prenomEmploye = prenomEmploye;
    }

    public String getEmailEmploye() {
        return emailEmploye;
    }

    public void setEmailEmploye(String emailEmploye) {
        this.emailEmploye = emailEmploye;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "idEmploye=" + idEmploye +
                ", nomEmploye='" + nomEmploye + '\'' +
                ", prenomEmploye='" + prenomEmploye + '\'' +
                ", emailEmploye='" + emailEmploye + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                '}';
    }
}