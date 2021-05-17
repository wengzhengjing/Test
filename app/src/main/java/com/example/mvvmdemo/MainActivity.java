package com.example.mvvmdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mvvmdemo.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //    TextView tvName;
    MyViewModel viewModel;
    private ActivityMainBinding binding;
    List<User> list = new ArrayList<>();
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        test();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        tvName = findViewById(R.id.tv_name);
        adapter = new MyAdapter(MainActivity.this, BR.user, list);
        binding.rv.setAdapter(adapter);

        LinearLayoutManager manager=new LinearLayoutManager(this){
            @Override
            public boolean canScrollVertically() {
                return super.canScrollVertically();
            }
        };

        viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);
//        binding.setLifecycleOwner(this);

        viewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                System.out.println("onChanged1");
                binding.setUser(user);
            }
        });

        viewModel.getUserList().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                list.addAll(users);
                adapter.notifyDataSetChanged();
            }
        });

        viewModel.getAllName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.setStr(s);
            }
        });


    }

    void test() {
        int[] list = new int[]{1, 5, 2, 8, 9, 77, 45, 68, 24, 78};
        for (int i = 0; i < list.length; i++) {
            for (int j = i; j < list.length  - 1; j++) {
                int temp = list[j];
                if (list[j] > list[j + 1]) {
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }

    }


    public void updateClick(View view) {
        System.out.println("onChanged");
        viewModel.setUsername("update");
        startActivity(new Intent(this, TestActivity.class));
//        startActivity(new Intent(this,KotlinActivity.class));
    }


}