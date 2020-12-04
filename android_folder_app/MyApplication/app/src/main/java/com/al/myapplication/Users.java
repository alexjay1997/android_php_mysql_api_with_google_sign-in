package com.al.myapplication;

public class Users {

    private  String user_id;
    private  String fullname;
    private  String username;
    private  String password;

    public Users(String user_id ,String fullname ,String username,String password) {
        this.setUser_id(user_id);
        this.setFullname(fullname);
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

