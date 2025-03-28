package za.ac.cput.Repository;
/*Session.java
Session ISession class
Author: Hope Ringane(221174109)
Date 28 March 2025
 */
import za.ac.cput.domain.Session;
import java.util.List;
import java.util.Optional;

public interface ISessionRepository {
    Session create(Session session);
    Optional<Session> read(String sessionId);
    Session update(Session session);
    boolean delete(String sessionId);
    List<Session> getAll();
}
