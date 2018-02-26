package fr.eni.lokacar.bo;

public class Agence {
    private int idAgence;
    private String nomAgence;
    private String villeAgence;
    private int codePostalAgence;

    public Agence() {
    }

    public Agence(int idAgence, String nomAgence, String villeAgence, int codePostalAgence) {
        this.idAgence = idAgence;
        this.nomAgence = nomAgence;
        this.villeAgence = villeAgence;
        this.codePostalAgence = codePostalAgence;
    }

    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public String getVilleAgence() {
        return villeAgence;
    }

    public void setVilleAgence(String villeAgence) {
        this.villeAgence = villeAgence;
    }

    public int getCodePostalAgence() {
        return codePostalAgence;
    }

    public void setCodePostalAgence(int codePostalAgence) {
        this.codePostalAgence = codePostalAgence;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "idAgence=" + idAgence +
                ", nomAgence='" + nomAgence + '\'' +
                ", villeAgence='" + villeAgence + '\'' +
                ", codePostalAgence=" + codePostalAgence +
                '}';
    }
}