package com.example.mvvmdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.mvvmdemo.databinding.ItemBinding;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private int BR_ID;
    private List<User> list;

    public MyAdapter(Context context, int BR_ID, List<User> list) {
        this.context = context;
        this.BR_ID = BR_ID;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        System.out.println("onCreateViewHolder");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        System.out.println("onBindViewHolder");
//        holder.getBinding().setVariable(BR_ID,list.get(position));
        holder.getBinding().setUser(list.get(position));
        //立即执行绑定
//        holder.getBinding().executePendingBindings();
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends ViewHolder {
        private ItemBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public ItemBinding getBinding() {
            return binding;
        }
    }
}
