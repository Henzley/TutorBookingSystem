package za.ac.cput.Repository;

/*  Tutor.java
    Tutor domain class
    Author: Angelo Kane Smidt (230688020)
    Date: 28 March 2025
 */
import za.ac.cput.domain.Tutor;

import java.util.ArrayList;
import java.util.List;

public class TutorRepository implements ITutorRepository{
    private static TutorRepository repo = null;
    private List<Tutor>  tutorDB;

    private TutorRepository() {
        tutorDB = new ArrayList<Tutor>();
    }
    public static TutorRepository getRepo(){
        if (repo == null){
            repo = new TutorRepository();
        }
        return repo;
    }
    @Override
    public Tutor create(Tutor tutor) {
        tutorDB.add(tutor);
        return tutor;
    }
    @Override
    public Tutor read(String tutorId) {
        return tutorDB.stream()
                .filter(s -> s.getTutorId().equals(tutorId))
                .findAny()
                .orElse(null);
    }
    @Override
    public Tutor update(Tutor tutor) {
        Tutor oldTutor = read(tutor.getTutorId());
        if (oldTutor != null) {
            tutorDB.remove(oldTutor);
            tutorDB.add(tutor);
            return tutor;
        }
        return null;
    }
    @Override
    public boolean delete(String tutorId) {
        Tutor tutor = read(tutorId);
        if (tutor != null) {
            tutorDB.remove(tutor);
            return true;
        }
        return false;
    }
    @Override
    public List<Tutor> getAll() {
        return new ArrayList<>(tutorDB);
    }
}
