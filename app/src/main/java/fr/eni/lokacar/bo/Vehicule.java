package fr.eni.lokacar.bo;

public class Vehicule {

    private int idVehicule;
    private String marque;
    private String modele;
    private String description;
    private String immatriculation;
    private float prix;
    private boolean loue;
    private String photo;

    public Vehicule() {
    }

    public Vehicule(int idVehicule, String marque, String modele, String description, String immatriculation, float prix, boolean loue, String photo) {
        this.idVehicule = idVehicule;
        this.marque = marque;
        this.modele = modele;
        this.description = description;
        this.immatriculation = immatriculation;
        this.prix = prix;
        this.loue = loue;
        this.photo = photo;
    }

    public int getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(int idVehicule) {
        this.idVehicule = idVehicule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public boolean isLoue() {
        return loue;
    }

    public void setLoue(boolean loue) {
        this.loue = loue;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "idVehicule=" + idVehicule +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", description='" + description + '\'' +
                ", immatriculation='" + immatriculation + '\'' +
                ", prix=" + prix +
                ", loue=" + loue +
                ", photo='" + photo + '\'' +
                '}';
    }
}