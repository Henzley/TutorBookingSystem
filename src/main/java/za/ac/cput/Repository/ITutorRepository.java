package za.ac.cput.Repository;
/*  ITutorRepository.java
    Tutor repository interface
    Author: Angelo Kane Smidt (230688020)
    Date: 27 March 2025
 */
import za.ac.cput.domain.Tutor;

import java.util.List;

public interface ITutorRepository extends IRepository<Tutor, String>{
    List<Tutor> getAll();
}
