package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ToDoViewHolder> {

    private String[] mDataset;
    private List<Todo> todoList;

    public class ToDoViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ToDoViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.my_text_view);

        }
    }

    public TodoAdapter(String[] mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public TodoAdapter.ToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_layout, parent, false);

        ToDoViewHolder myViewHolder = new ToDoViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ToDoViewHolder toDoViewHolder, int position) {
        toDoViewHolder.textView.setText(this.mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
