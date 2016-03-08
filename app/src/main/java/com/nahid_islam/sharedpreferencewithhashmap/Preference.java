package com.nahid_islam.sharedpreferencewithhashmap;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by Nahid_Islam on 3/9/2016.
 */
public class Preference {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    Context context;

    private static final String PREFERENCE_NAME = "log_In";
    private static final String NAME_KEY = "userName";
    private static final String PASSWORD_KEY = "userPassword";


    public Preference(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_APPEND);
        editor = sharedPreferences.edit();
    }

    public void saveInformation(String userName, String userPassword) {

        editor.putString(NAME_KEY, userName);
        editor.putString(PASSWORD_KEY, userPassword);
        editor.commit();
    }

    public HashMap<String, String> retrieveData() {
        String userName = sharedPreferences.getString(NAME_KEY, "Data Not Found");
        String userPassword = sharedPreferences.getString(PASSWORD_KEY, "Data Not Found");

        HashMap<String, String> userHashMap = new HashMap<String, String>();
        userHashMap.put(NAME_KEY, userName);
        userHashMap.put(PASSWORD_KEY, userPassword);

        return userHashMap;
    }

    public void deleteData() {

        editor.remove(NAME_KEY);
        editor.remove(PASSWORD_KEY);
        editor.commit();

    }
}
