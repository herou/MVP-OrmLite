package comqueues.example.user.ormlitecrudexample.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import comqueues.example.user.ormlitecrudexample.R;
import comqueues.example.user.ormlitecrudexample.data.db.DatabaseOperationsImp;
import comqueues.example.user.ormlitecrudexample.data.db.model.Person;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.nameEdiText)
    EditText nameEdiText;
    @BindView(R.id.addButton)
    Button addButton;
    @BindView(R.id.deleteButton)
    Button deleteButton;
    @BindView(R.id.editButton)
    Button editButton;

    Person p;

    MainPresenterImpl mainPresenter;
    DatabaseOperationsImp databaseOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

     
        mainPresenter = new MainPresenterImpl(this,databaseOperations);

        p = new Person();

    }

    @OnClick(R.id.addButton)
    public void addPerson(View view){
        p.setFirstName(nameEdiText.getText().toString());
        mainPresenter.addPerson(p);

    }

    @OnClick(R.id.deleteButton)
    public void deletePerson(View view){
        p.setFirstName(nameEdiText.getText().toString());
        mainPresenter.deletePerson(p);

    }

    @OnClick(R.id.editButton)
    public void editPerson(View view){
        p.setFirstName(nameEdiText.getText().toString());
        mainPresenter.editPerson(p);

    }

    @OnClick(R.id.showButton)
    public void showPeople(View view){
        mainPresenter.showAll();

    }

    @Override
    public void showFieldEmpty() {
        Toast.makeText(getApplicationContext(), R.string.field_empty,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showAdded() {
        Toast.makeText(getApplicationContext(), R.string.person_added,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showDeleted() {
        Toast.makeText(getApplicationContext(), R.string.person_deleted,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUpdated() {
        Toast.makeText(getApplicationContext(), R.string.person_updated,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showAll(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }
}
