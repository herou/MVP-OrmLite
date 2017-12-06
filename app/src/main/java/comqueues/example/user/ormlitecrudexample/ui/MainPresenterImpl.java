package comqueues.example.user.ormlitecrudexample.ui;


import java.util.List;

import comqueues.example.user.ormlitecrudexample.R;
import comqueues.example.user.ormlitecrudexample.data.db.DatabaseOperationsImp;
import comqueues.example.user.ormlitecrudexample.data.db.model.Person;
import comqueues.example.user.ormlitecrudexample.util.Util;

/**
 * Created by user on 12/1/2017.
 */

public class MainPresenterImpl implements MainPresenter {

    MainActivity mainActivity;
    DatabaseOperationsImp databaseOperations;

    public MainPresenterImpl(MainActivity mainActivity,DatabaseOperationsImp databaseOperations) {
        this.mainActivity = mainActivity;
        this.databaseOperations = databaseOperations;
    }

    public MainPresenterImpl() {}

    @Override
    public void addPerson(Person p) {
        if(Util.checkIfNameEmptyOrNull(p.getFirstName()) == true){
            mainActivity.showFieldEmpty();
        }else{
            if(databaseOperations.create(p) == true){
                mainActivity.showAdded();
            }else{
                mainActivity.showError(mainActivity.getString(R.string.error_while_adding));
            }
        }
    }

    @Override
    public void deletePerson(Person p) {
        if(Util.checkIfNameEmptyOrNull(p.getFirstName()) == true){
            mainActivity.showFieldEmpty();
        }else{
            if(databaseOperations.delete(p) == true){
                mainActivity.showDeleted();
            }else{
                mainActivity.showError(mainActivity.getString(R.string.there_is_not_any_person_with_this_name));
            }
        }
    }

    @Override
    public void editPerson(Person p) {
        if(Util.checkIfNameEmptyOrNull(p.getFirstName()) == true){
            mainActivity.showFieldEmpty();
        }else{
            if( databaseOperations.update(p) == true){
                mainActivity.showUpdated();
            }else{
                mainActivity.showError(mainActivity.getString(R.string.there_is_not_any_person_with_this_name));
            }
        }
    }

    @Override
    public void showAll() {
        List<Person> studentList =  databaseOperations.read();

        if(studentList.isEmpty()){
            mainActivity.showError(mainActivity.getString(R.string.there_is_not_any_person_in_db));
        }else{
            for(int i=0 ; i<studentList.size();i++){
                mainActivity.showAll(mainActivity.getString(R.string.id)+studentList.get(i).getId()+mainActivity.getString(R.string.name)+studentList.get(i).getFirstName());
            }
        }
    }
}
