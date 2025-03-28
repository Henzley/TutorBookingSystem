package za.ac.cput.repository;
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
    public Session read(String sessionID) {
        return sessionList.stream()
                .filter(s -> s.getSessionID().equals(sessionID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Session update(Session session) {
        Optional<Session> existingSession = Optional.ofNullable(read(session.getSessionID()));
        if (existingSession.isPresent()) {
            sessionList.remove(existingSession.get());
            sessionList.add(session);
            return session;
        }
        return null;
    }

    @Override
    public boolean delete(String sessionId) {
        Optional<Session> session = Optional.ofNullable(read(sessionId));
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