package com.nahid_islam.sharedpreferencewithhashmap;

/**
 * Created by Nahid_Islam on 3/9/2016.
 */
public class User {

    private String userName;
    private String userPassword;

    public User(String userName, String userPassword) {
        setUserName(userName);
        setUserPassword(userPassword);
    }

    public User() {


    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
