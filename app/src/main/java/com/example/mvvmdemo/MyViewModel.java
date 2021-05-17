package com.example.mvvmdemo;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MyViewModel extends AndroidViewModel {
    private MutableLiveData<User> user;
    private MutableLiveData<String> str;
    private MutableLiveData<List<User>> userList;
    private User myUser;

    public MyViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<User> getUser() {
        if (user == null)
            user = new MutableLiveData<>();
        myUser = new User();
        myUser.setName("default_name");
        user.setValue(myUser);
        return user;
    }

    public void setUsername(String username) {
        if (myUser == null) {
            myUser = new User();
        }
        myUser.setName(username);
        user.setValue(myUser);
    }

    public LiveData<List<User>> getUserList() {
        if (userList == null)
            userList = new MutableLiveData<>();

        User user1 = new User("1");
        User user2 = new User("2");
        User user3 = new User("3");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        userList.setValue(users);
        return userList;
    }


    public LiveData<String> getAllName() {
        if (str == null)
            str = new MutableLiveData<>();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                str.setValue("all_name");
            }
        }, 5000);


        return str;
    }

    public Observable getUserForRx() {

        return new Observable();
    }

}