package com.androidarchitecture.learn.noteapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewNoteActivity extends AppCompatActivity {

    public static final String NOTE_ADDED = "new_note";
    public static final String TEXT_ADDED = "new_text";

    private EditText etNewNote;
    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        etNewNote = findViewById(R.id.etNewNote);
        editText = findViewById(R.id.editText);
        editText.setSelection(0);
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
                Intent resultIntent = new Intent();

                if (TextUtils.isEmpty(etNewNote.getText())) {
                    setResult(RESULT_CANCELED, resultIntent);
                } else {
                    String note = etNewNote.getText().toString();
                    String text = editText.getText().toString();
                    resultIntent.putExtra(NOTE_ADDED, note).putExtra(TEXT_ADDED, text);
                    setResult(RESULT_OK, resultIntent);
                }
                break;

            case R.id.attach_to_note:
                showImageSelectionDialog();
                return true;

        } finish();
        return super.onOptionsItemSelected(item);
    }

    private void showImageSelectionDialog() {


    }
}
