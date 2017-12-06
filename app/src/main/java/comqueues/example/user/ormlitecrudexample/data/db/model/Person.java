package comqueues.example.user.ormlitecrudexample.data.db.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by user on 11/14/2017.
 */

@DatabaseTable(tableName = "person")
public class Person {

    // Fields

    // Primary key defined as an auto generated integer
    // If the database table column name differs than the Model class variable name, the way to map to use columnName

    @DatabaseField(columnName = "id",generatedId = true)
    public int id;

    @DatabaseField(columnName = "first_name")
    public String firstName;


    // Getter and Setter method of fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}