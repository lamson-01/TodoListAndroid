package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclerView = findViewById(R.id.recyclerView);
        database = Room.databaseBuilder(getApplicationContext(), Database.class, Database.DB_NAME).allowMainThreadQueries().build();

////        insert database
//        Todo todo = new Todo();
//
//
//        todo.setCategory("danh muc: ");
//        todo.setDescription("mo ta: ");
//        todo.setName("ten: ");
//        todo.setPriority("uu tien: ");
//
//        //        save database
//        this.database.daoTodo().InsertTodo(todo);

        // use this setting to improve performance if you know that changes
        this.recyclerView.setHasFixedSize(true);

        this.layoutManager = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(this.layoutManager);


        showTodoOnScreen();


    }

    @Override
    protected void onResume() {
        super.onResume();
        showTodoOnScreen();
    }

    public void showTodoOnScreen() {
        //        fetch data from DB
        List<Todo> todoList = this.database.daoTodo().fetchAllTodos();

        for (int i = 0; i < todoList.size(); i++) {
            System.out.println("" + i + " - cate: " + todoList.get(i).getCategory());
        }

        this.mAdapter = new TodoAdapter(todoList);

        this.recyclerView.setAdapter(this.mAdapter);
        this.mAdapter.notifyDataSetChanged();
    }

    public void deleteTodo(Todo todo){

    }
    public void openAddingTodo(View view) {
        Intent intent = new Intent(this, add_todo.class);
        startActivity(intent);
    }
}
