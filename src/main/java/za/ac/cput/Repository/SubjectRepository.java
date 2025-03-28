package za.ac.cput.Repository;
import za.ac.cput.domain.Subject;

import java.util.ArrayList;
import java.util.List;

public  class SubjectRepository implements ISubjectRepository {
    public static ISubjectRepository repository = null;
    private List<Subject> subjectslist;

    private SubjectRepository() {
        subjectslist = new ArrayList<Subject>();
    }

    public static IRepository getRepository() {
        if (repository == null) {

            repository = new SubjectRepository();


        }
        return repository;

    }


    @Override
    public List<Subject>getAll() {
        return subjectslist;
    }




    @Override
    public Subject create(Subject subject) {
        boolean success = subjectslist.add(subject);
        if (subject!=null){
            subjectslist.add(subject);
            return subject;



}
        return null;
    }

    @Override
    public Subject read(String subjectname) {
        for(Subject subject:subjectslist){
            if(subject.getSubjectName().equalsIgnoreCase(subjectname)){
                return subject;
            }




        }

        return null;
    }

    @Override
    public Subject update(Subject subject) {
        boolean update = subjectslist.add(subject);
        if (subject!=null){
            subjectslist.add(subject);
            return subject;
        }



        return null;
    }

    @Override
    public boolean delete(Subject subject) {
        for(Subject subject1:subjectslist){
            if(subject1.getSubjectName().equalsIgnoreCase(subject.getSubjectName())){
                subjectslist.remove(subject1);
                return true;
            }
        }
        return false;


    }


}















