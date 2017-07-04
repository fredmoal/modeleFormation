package modele;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * enregistrement de la dernière date/heure de login d'un utilisateur
 */
public class LastLoginLog {
    private static Map<String, LastLoginLog> lastLogings = new HashMap<>();

    private LocalDateTime dateTime;
    private User user;

    private LastLoginLog(User user) {
        this.user = user;
        this.dateTime = LocalDateTime.now();
    }

    public static synchronized void newLogin(User user) {
        lastLogings.put(user.getPseudo(), new LastLoginLog(user));
    }

    public static LocalDateTime lastLogin(String pseudo) {
        return lastLogings.get(pseudo) == null ? null : lastLogings.get(pseudo).dateTime;
    }
}
