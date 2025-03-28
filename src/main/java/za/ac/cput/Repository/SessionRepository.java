package za.ac.cput.Repository;
/*Session.java
Session Repository class
Author: Hope Ringane(221174109)
Date 28 March 2.25
 */
import za.ac.cput.domain.Session;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SessionRepository implements ISessionRepository {
    private static SessionRepository repository = null;
    private List<Session> sessionList;

    private SessionRepository() {
        this.sessionList = new ArrayList<>();
    }

    public static SessionRepository getInstance() {
        if (repository == null) {
            repository = new SessionRepository();
        }
        return repository;
    }

    @Override
    public Session create(Session session) {
        this.sessionList.add(session);
        return session;
    }

    @Override
    public Optional<Session> read(String sessionId) {
        return sessionList.stream()
                .filter(session -> session.getSessionID().equals(sessionId))
                .findFirst();
    }

    @Override
    public Session update(Session session) {
        Optional<Session> existingSession = read(session.getSessionID());
        if (existingSession.isPresent()) {
            sessionList.remove(existingSession.get());
            sessionList.add(session);
            return session;
        }
        return null;
    }

    @Override
    public boolean delete(String sessionId) {
        Optional<Session> session = read(sessionId);
        if (session.isPresent()) {
            sessionList.remove(session.get());
            return true;
        }
        return false;
    }

    @Override
    public List<Session> getAll() {
        return new ArrayList<>(sessionList);
    }
}
