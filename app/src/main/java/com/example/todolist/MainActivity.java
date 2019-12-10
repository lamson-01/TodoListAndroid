package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.Spinner;

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

//        build database
        this.database = Room.databaseBuilder(getApplicationContext(), Database.class, Database.DB_NAME).build();

//        insert database
        Todo todo = new Todo();


            todo.setCategory("danh muc: ");
            todo.setDescription("mo ta: " );
            todo.setName("ten: " );
            todo.setPriority("uu tien: ");

            //        save database
            this.database.daoTodo().InsertTodo(todo);
//            this.database.daoTodo().InsertTodo();

//        System.out.println("data in db: "+this.database.daoTodo().fetchAllTodos().toArray());

        // use this setting to improve performance if you know that changes
        this.recyclerView.setHasFixedSize(true);

        this.layoutManager = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(this.layoutManager);

        String[] mDataset = {"sdfsdf", "dsfsdf", "sdfsdfs"};

        this.mAdapter = new TodoAdapter(mDataset);
        this.recyclerView.setAdapter(this.mAdapter);

    }
}
