package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add_todo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
        Button doneButton = findViewById(R.id.btnDone);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Database database = Room.databaseBuilder(getApplicationContext(), Database.class, Database.DB_NAME).allowMainThreadQueries().build();;
                Todo todo = new Todo();

                EditText inTitle = findViewById(R.id.inTitle);
                EditText inCategory = findViewById(R.id.inCategory);
                EditText inDesc = findViewById(R.id.inDescription);

                System.out.println("In title: ["+inTitle.getText()+"] - in category: ["+inCategory.getText()+"] - in desc: ["+inDesc.getText()+"]");

                todo.setName(inTitle.getText().toString());
                todo.setCategory(inCategory.getText().toString());
                todo.setDescription(inDesc.getText().toString());

                database.daoTodo().InsertTodo(todo);

                finish();

            }
        });
    }

}
