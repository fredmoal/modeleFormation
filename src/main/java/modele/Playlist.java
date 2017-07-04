package modele;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Une liste de titres d'un utilisateur
 */
public class Playlist {
    private User proprietaire;
    private String nomListe;
    private List<Titre> liste;
    private LocalDateTime creation;

    public Playlist(User user, String nomPlaylist) {
        proprietaire = user;
        nomListe = nomPlaylist;
        liste = new ArrayList<>();
        creation = LocalDateTime.now();
    }

    public User getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(User proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getNomListe() {
        return nomListe;
    }

    public void setNomListe(String nomListe) {
        this.nomListe = nomListe;
    }

    public List<Titre> getListe() {
        return liste;
    }

    public void setListe(List<Titre> liste) {
        this.liste = liste;
    }

    public void addListe(Titre titre) {
        liste.add(titre);
    }

    public void supprimerTitre(long id) {
        Titre aSupprimer =null;

        for(Titre t : this.liste) {
            if (t.getPlace() == id) {
                aSupprimer = t;
            }
        }
        if (aSupprimer != null) {
            this.liste.remove(aSupprimer);
        }
    }

    public LocalDateTime getCreation() {
        return creation;
    }

    public Playlist copie(User user) {
        Playlist copie = new Playlist(user,getNomListe());
        copie.setListe(new ArrayList<>(getListe()));

        return copie;
    }
}
