package com.androidarchitecture.learn.noteapplication;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class EditNoteActivity extends AppCompatActivity {

    public static final String NOTE_ID = "note_id";
    static final String UPDATED_NOTE = "note_text";
    static final String UPDATE_TEXT = "text_note";
    private EditText etNote;
    private EditText updateNote;
    private Bundle bundle;
    private String noteId;
    private LiveData<Note> note;

    EditNoteViewModel noteModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etNote = findViewById(R.id.etNote);
        updateNote = findViewById(R.id.updateText);

        bundle = getIntent().getExtras();

        if (bundle != null) {
            noteId = bundle.getString("note_id");
        }

        noteModel = ViewModelProviders.of(this).get(EditNoteViewModel.class);
        note = noteModel.getNote(noteId);
        note.observe(this, new Observer<Note>() {
            @Override
            public void onChanged(@Nullable Note note) {
                etNote.setText(note.getNote());
                updateNote.setText(note.getTextNote());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_note_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                String updatedNote = etNote.getText().toString();
                String updateText = updateNote.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra(NOTE_ID, noteId);
                resultIntent.putExtra(UPDATED_NOTE, updatedNote).putExtra(UPDATE_TEXT, updateText);
                setResult(RESULT_OK, resultIntent);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
