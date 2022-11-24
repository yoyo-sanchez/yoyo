package com.example.myapplication.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

//<>覆盖基类方法,自定义子类替代基类
public class Myadapter extends RecyclerView.Adapter<Myadapter.Myholder> {
    private View view;
    private Context context;
    private List<String> list;

    public Myadapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        Myholder holder;
        holder = new Myholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        //one holder to 一行
        holder.textView.setText(list.get(position));

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        private TextView textView;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView2);

        }
    }


}
