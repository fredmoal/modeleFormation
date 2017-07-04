package facade;

import facade.erreurs.*;
import modele.LastLoginLog;
import modele.User;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Fred on 04/07/2017.
 */
public class ServiceImpl implements LoginService{
    public static final int PSEUDO_MIN_SIZE = 4;
    public static final int PASS_MIN_SIZE = 2;
    private Map<String, User> users;
    private Set<String> connectes;

    private static ServiceImpl singleton;

    private ServiceImpl() {
        users = new HashMap<>();
        connectes = new HashSet<>();
    }

    public static synchronized ServiceImpl getInstance() {
        if (singleton==null) {
            singleton = new ServiceImpl();
        }
        return singleton;
    }
    @Override
    public LocalDateTime login(String pseudo, String motDePasse) throws MauvaisUserPassException, UserDejaConnecteException {
        if ((!users.containsKey(pseudo)) || (!users.get(pseudo).getMotDePasse().equals(motDePasse))) {
            throw new MauvaisUserPassException();
        }
        if (connectes.contains(pseudo)) {
            throw new UserDejaConnecteException();
        }
        LocalDateTime dateTime = LastLoginLog.lastLogin(pseudo);
        LastLoginLog.newLogin(users.get(pseudo));
        connectes.add(pseudo);

        return dateTime;
    }

    @Override
    public void logout(String pseudo) throws UserNotConnectedException {
        if (!connectes.contains(pseudo)) {
            throw new UserNotConnectedException();
        }
        connectes.remove(pseudo);
    }

    @Override
    public void enregistrerEtLogin(String pseudo, String motDePasse) throws UserExistException, MauvaisFormatPseudoPassException {
        if (users.containsKey(pseudo)) {
            throw new UserExistException();
        }
        if ((pseudo.length()< PSEUDO_MIN_SIZE) ||(motDePasse.length()< PASS_MIN_SIZE)) {
            throw new MauvaisFormatPseudoPassException();
        }
        LastLoginLog.newLogin(users.get(pseudo));
        users.put(pseudo, new User(pseudo,motDePasse));
        connectes.add(pseudo);
    }

    @Override
    public LocalDateTime lastLogin(String pseudo) {
        return LastLoginLog.lastLogin(pseudo);
    }
}
