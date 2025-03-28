package za.ac.cput.repository;
/*Session.java
Session ISession class
Author: Hope Ringane(221174109)
Date 28 March 2025
 */

import za.ac.cput.domain.Session;

import java.util.List;
import java.util.Optional;

public interface ISessionRepository extends IRepository<Session, String> {
    List<Session> getAll();
}
