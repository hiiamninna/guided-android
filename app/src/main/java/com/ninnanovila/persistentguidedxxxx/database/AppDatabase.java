package com.ninnanovila.persistentguidedxxxx.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ninnanovila.persistentguidedxxxx.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}



