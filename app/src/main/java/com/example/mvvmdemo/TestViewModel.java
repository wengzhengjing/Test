package com.example.mvvmdemo;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class TestViewModel extends ViewModel {
    private MutableLiveData<User> user;
    private MutableLiveData<List<User>> userList;
    private User myUser;

    @Override
    protected void onCleared() {
        super.onCleared();
        System.out.println("postDelayed");
    }


    public LiveData<User> getTime() {
        if (user == null)
            user = new MutableLiveData<>();



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                System.out.println("postDelayed1");
                myUser = new User();
                myUser.setName("default_name");
                user.setValue(myUser);
            }
        }, 15000);


        return user;
    }
}