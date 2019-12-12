package com.example.todolist;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        Button deleteBtn = findViewById(R.id.btnDelete);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Todo todo = (Todo) getIntent().getSerializableExtra();
//                deleteTodo(todo);
//                int todo_id = getIntent().getIntExtra("id",-100);
//
//                System.out.println("Todo Id: "+todo_id);
                System.out.println("fghfdghdfhdfghdf");
            }
        });
    }
}
