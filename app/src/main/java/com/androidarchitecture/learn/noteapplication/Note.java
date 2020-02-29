package com.androidarchitecture.learn.noteapplication;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;

@Entity(tableName = "notes")
public class Note {

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getNote() {
        return this.mNote;
    }

    public String getTextNote() {
        return this.textNote;
    }

    @PrimaryKey
    @NonNull
    private String id;

    @NonNull
    @ColumnInfo(name = "note")
    private String mNote;

    @ColumnInfo(name = "text_note")
    private String textNote;

    public Note(@NonNull String id, @NonNull String mNote, String textNote) {
        this.id = id;
        this.mNote = mNote;
        this.textNote = textNote;
    }

    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE notes ADD COLUMN text_note TEXT");
        }
    };
}
