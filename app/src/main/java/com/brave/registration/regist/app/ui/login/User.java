package com.brave.registration.regist.app.ui.login;

public class User {

    String id;
    String phone_num;
    public User(String id, String phone_num)
    {
        this.id=id;
        this.phone_num=phone_num;
    }

    public String getId() {
        return id;
    }

    public String getPhone_num() {
        return phone_num;
    }
}