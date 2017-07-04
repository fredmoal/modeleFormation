package modele;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fred on 13/06/2017.
 */
public class User {
    private String pseudo;
    private String motDePasse;
    private Map<String,Playlist> mesPlaylists;

    public User(String pseudo, String motDePasse) {
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        mesPlaylists = new HashMap<>();
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Map<String, Playlist> getMesPlaylists() {
        return mesPlaylists;
    }

    public void setMesPlaylists(Map<String, Playlist> mesPlaylists) {
        this.mesPlaylists = mesPlaylists;
    }

    public void putMesPlaylists(String playListName, Playlist maPlaylist) {
        maPlaylist.setProprietaire(this);
        this.mesPlaylists.put(playListName,maPlaylist);
    }

    public void supprimerTitreDePlayList(String nomPlayList, long idTitre) {
        if (this.mesPlaylists.get(nomPlayList)!= null) {
            this.mesPlaylists.get(nomPlayList).supprimerTitre(idTitre);
        }
    }

}
