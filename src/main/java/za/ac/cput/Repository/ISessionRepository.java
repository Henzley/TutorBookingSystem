package za.ac.cput.Repository;

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
