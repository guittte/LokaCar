package fr.eni.lokacar.bo;

public class Location {

    private int idLocation;
    private String dateDebutLocation;
    private String dateFinLocation;
    private String etatLieuxEntrant;
    private String etatLieuxSortant;

    public Location() {
    }

    public Location(int idLocation, String dateDebutLocation, String dateFinLocation, String etatLieuxEntrant, String etatLieuxSortant) {
        this.idLocation = idLocation;
        this.dateDebutLocation = dateDebutLocation;
        this.dateFinLocation = dateFinLocation;
        this.etatLieuxEntrant = etatLieuxEntrant;
        this.etatLieuxSortant = etatLieuxSortant;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getDateDebutLocation() {
        return dateDebutLocation;
    }

    public void setDateDebutLocation(String dateDebutLocation) {
        this.dateDebutLocation = dateDebutLocation;
    }

    public String getDateFinLocation() {
        return dateFinLocation;
    }

    public void setDateFinLocation(String dateFinLocation) {
        this.dateFinLocation = dateFinLocation;
    }

    public String getEtatLieuxEntrant() {
        return etatLieuxEntrant;
    }

    public void setEtatLieuxEntrant(String etatLieuxEntrant) {
        this.etatLieuxEntrant = etatLieuxEntrant;
    }

    public String getEtatLieuxSortant() {
        return etatLieuxSortant;
    }

    public void setEtatLieuxSortant(String etatLieuxSortant) {
        this.etatLieuxSortant = etatLieuxSortant;
    }

    @Override
    public String toString() {
        return "Location{" +
                "idLocation=" + idLocation +
                ", dateDebutLocation='" + dateDebutLocation + '\'' +
                ", dateFinLocation='" + dateFinLocation + '\'' +
                ", etatLieuxEntrant='" + etatLieuxEntrant + '\'' +
                ", etatLieuxSortant='" + etatLieuxSortant + '\'' +
                '}';
    }
}