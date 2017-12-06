package comqueues.example.user.ormlitecrudexample.util;

/**
 * Created by user on 12/6/2017.
 */

public class Util {

    public static boolean checkIfNameEmptyOrNull(String s) {

        if(s.equalsIgnoreCase("") || s == null){
            return true;
        }
        return false;
    }
}
