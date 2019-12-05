package com.example.todolist;

import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Todo.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    public static final String DB_NAME = "app_db";
    public static final String TABLE_NAME_TODO ="todo";

    public abstract DaoTodo daoTodo();
}
