package comqueues.example.user.ormlitecrudexample.data.db;

import android.content.Context;
import android.database.SQLException;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;

import java.util.List;
import comqueues.example.user.ormlitecrudexample.data.db.model.Person;
import comqueues.example.user.ormlitecrudexample.ui.MainPresenter;
import comqueues.example.user.ormlitecrudexample.ui.MainPresenterImpl;


/**
 * Created by root on 12/1/17.
 */

public class DatabaseOperationsImp implements DatabaseOperations{

    DBHelper helper;
    RuntimeExceptionDao<Person, Integer> userDao;
    MainPresenterImpl mainPresenter;

    public DatabaseOperationsImp(Context contex, MainPresenterImpl mainPresenter) {
        helper = new DBHelper(contex);
        mainPresenter = new MainPresenterImpl();
        userDao = helper.getRuntimeExceptionDao(Person.class);

    }

    @Override
    public boolean create(Person p) {
        try {
            userDao.create(p);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Person> read() {

        List<Person> studentList = userDao.queryForAll();

        if(studentList.size() != 0){
            return studentList;
        }

        return studentList;
    }

    @Override
    public boolean update(Person p) {

        if(checkIfExist(p) == true){
            UpdateBuilder<Person, Integer> updateBuilder = userDao.updateBuilder();

            try {
                updateBuilder.where().eq("first_name", p.getFirstName());
                updateBuilder.updateColumnValue("first_name" , "Your name changed to Eljo");

                updateBuilder.update();
                return true;
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
                return false;

            }
        }
       return false;
    }

    @Override
    public boolean delete(Person p) {

        if(checkIfExist(p) == true){
            DeleteBuilder<Person, Integer> deleteBuilder = userDao.deleteBuilder();
            try {
                deleteBuilder.where().eq("first_name", p.getFirstName());
                deleteBuilder.delete();
                return true;
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
                return false;
            }
        }else{
            return false;
        }

    }

    @Override
    public boolean checkIfExist(Person p) {
        List<Person> results = null;
        try {
            results = userDao.queryBuilder().where().eq("first_name",p.getFirstName()).query();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return false;
        }
        if(results.size() == 0){
            return false;
        }else{
            return true;
        }
    }
}
