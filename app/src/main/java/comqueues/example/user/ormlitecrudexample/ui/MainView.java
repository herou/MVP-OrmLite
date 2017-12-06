package comqueues.example.user.ormlitecrudexample.ui;

/**
 * Created by user on 12/1/2017.
 */

public interface MainView {

    void showFieldEmpty();
    void showAdded();
    void showDeleted();
    void showUpdated();
    void showAll(String s);
    void showError(String s);
}
