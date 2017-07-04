package modele;

/**
 * Un titre ce chanson
 */
public class Titre {
    private String groupe;
    private String chanson;
    private long place;

    public Titre(String groupe, String chanson, long place) {
        this.groupe = groupe;
        this.chanson = chanson;
        this.place = place;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public long getPlace() {
        return place;
    }

    public void setPlace(long place) {
        this.place = place;
    }

    public String getChanson() {
        return chanson;
    }

    public void setChanson(String chanson) {
        this.chanson = chanson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Titre titre = (Titre) o;

        if (groupe != null ? !groupe.equals(titre.groupe) : titre.groupe != null) return false;
        return chanson != null ? chanson.equals(titre.chanson) : titre.chanson == null;
    }

    @Override
    public int hashCode() {
        int result = groupe != null ? groupe.hashCode() : 0;
        result = 31 * result + (chanson != null ? chanson.hashCode() : 0);
        return result;
    }
}
