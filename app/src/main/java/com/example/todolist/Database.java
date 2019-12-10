package com.example.todolist;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@androidx.room.Database(entities = {Todo.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    public static final String DB_NAME = "app_db";
    public static final String TABLE_NAME_TODO ="todo";

    public abstract DaoTodo daoTodo();

//    handle synchronized
    private static volatile Database INSTANCE;
    private static final int NUMBBER_OF_THREADS = 4;
    static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(NUMBBER_OF_THREADS);

    static Database getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (Database.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, DB_NAME)
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}
