package comqueues.example.user.ormlitecrudexample.data.db;

import java.util.List;

import comqueues.example.user.ormlitecrudexample.data.db.model.Person;

/**
 * Created by root on 12/1/17.
 */

public interface DatabaseOperations {

    boolean create(Person p);
    List<Person> read();
    boolean update(Person p);
    boolean delete(Person p);
    boolean checkIfExist(Person p);
}
