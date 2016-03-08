package com.nahid_islam.sharedpreferencewithhashmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText userNameEt;
    EditText userPasswordEt;
    TextView showNameTv;
    TextView showPasswordTv;
    Preference preference;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameEt = (EditText) findViewById(R.id.editTextName);
        userPasswordEt = (EditText) findViewById(R.id.editTextpassword);
        showNameTv = (TextView) findViewById(R.id.nameTv);
        showPasswordTv = (TextView) findViewById(R.id.passwordTv);

        preference = new Preference(this);

    }

    public void btnSave(View view) {

        String inputUserName = userNameEt.getText().toString();
        String inputPassword = userPasswordEt.getText().toString();
        user = new User();
        user.setUserPassword(inputPassword);
        user.setUserName(inputUserName);
        String name = user.getUserName();
        String password = user.getUserPassword();

        if (inputUserName.length() > 0 && inputPassword.length() > 0) {

            preference.saveInformation(name, password);

            userPasswordEt.getText().clear();
            userNameEt.getText().clear();
        } else {
            String error = "Insert Username!!!";
            String error2 = "Insert Password!!!";
            showNameTv.setText(error);
            showPasswordTv.setText(error2);
        }
    }


    public void btnShow(View view) {

        Map<String, String> userInformationMap = preference.retrieveData();

        String userName = userInformationMap.get("userName");
        String userPassword = userInformationMap.get("userPassword");
        showNameTv.setText(userName);
        showPasswordTv.setText(userPassword);


    }

    public void btnDelete(View view) {

        preference.deleteData();
        showNameTv.setText("Deleted ");
        showPasswordTv.setText("Deleted ");
    }
}
