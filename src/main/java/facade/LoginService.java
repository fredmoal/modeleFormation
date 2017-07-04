package facade;

import facade.erreurs.*;

import java.time.LocalDateTime;

/**
 * Created by Fred on 04/07/2017.
 */
public interface LoginService {
    /**
     *  Login de l'utilisateur
     * @param pseudo
     * @param motDePasse
     * @return la date/heure du précédent login
     * @throws MauvaisUserPassException
     */
    public LocalDateTime login(String pseudo, String motDePasse) throws MauvaisUserPassException, UserDejaConnecteException, UserDejaConnecteException;

    /**
     *  Logout
     * @param pseudo
     * @throws UserNotConnectedException
     */
    public void logout(String pseudo) throws UserNotConnectedException;
    /**
     *  Enregistrement d'un nouvel utilisateur et connection de celui-ci
     * @param pseudo    : pseudo de l'utilisateur
     * @param motDePasse: mot de passe de l'utilisateur
     *
     * @throws UserExistException
     * @throws MauvaisFormatPseudoPassException
     */
    public void enregistrerEtLogin(String pseudo, String motDePasse) throws UserExistException, MauvaisFormatPseudoPassException;

    /**
     * Dernier login de l'utilisateur
     * @param pseudo
     * @return Date/Heure du dernier login
     */
    public LocalDateTime lastLogin(String pseudo);
}
