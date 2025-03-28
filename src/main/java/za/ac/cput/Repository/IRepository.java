package za.ac.cput.Repository;
/**
 * IRepository.java
 * Main Repository interface
 * Author: [Cameron Savage] ([230582567])
 * Date: [27/03/2025]
 */
//CRUD
public interface IRepository<T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
