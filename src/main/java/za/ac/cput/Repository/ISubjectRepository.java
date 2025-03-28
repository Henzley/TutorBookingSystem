package za.ac.cput.Repository;

import za.ac.cput.domain.Subject;

import java.util.List;

public interface ISubjectRepository<T,ID>  {
    T create(T t);
    T read(ID id);
    T update(T t);

    List<Subject> getAll();

    Subject create(Subject subject);

    Subject read(String subjectname);

    Subject update(Subject subject);

    boolean delete(ID id);


    boolean delete(Subject subject);
}
