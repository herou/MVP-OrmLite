package comqueues.example.user.ormlitecrudexample.ui;

import comqueues.example.user.ormlitecrudexample.data.db.model.Person;

/**
 * Created by user on 12/1/2017.
 */

public interface MainPresenter {

    void addPerson(Person p);
    void deletePerson(Person p);
    void editPerson(Person p);
    void showAll();
}
