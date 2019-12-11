package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ToDoViewHolder> {

    //    private String[] mDataset;
    private List<Todo> todoList;

    public class ToDoViewHolder extends RecyclerView.ViewHolder {

        public TextView txtName;
        public TextView txtNo;
        public TextView txtDesc;
        public TextView txtCategory;
        public CardView cardView;

        public ToDoViewHolder(View view) {
            super(view);

            txtNo = view.findViewById(R.id.txtNo);
            txtName = view.findViewById(R.id.txtName);
            txtDesc = view.findViewById(R.id.txtDesc);
            txtCategory = view.findViewById(R.id.txtCategory);
            cardView = view.findViewById(R.id.cardView);

        }
    }

    public TodoAdapter(List<Todo> todoList) {
//        this.mDataset = mDataset;
//        this.todoList = new ArrayList<>();
        this.todoList = todoList;
    }

    @Override
    public TodoAdapter.ToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_layout, parent, false);

        ToDoViewHolder myViewHolder = new ToDoViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ToDoViewHolder toDoViewHolder, int position) {
//        toDoViewHolder.txtCategory.setText(this.mDataset[position]);

        Todo todo = this.todoList.get(position);

        toDoViewHolder.txtName.setText(todo.name);
        toDoViewHolder.txtNo.setText("#" + String.valueOf(todo.todo_id));
        toDoViewHolder.txtDesc.setText(todo.description);
        toDoViewHolder.txtCategory.setText(todo.category);
    }

    @Override
    public int getItemCount() {
        return this.todoList.size();
    }
}
