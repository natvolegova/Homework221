package com.example.homework221;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inputNote;
    private Button btnSaveNote;
    private SharedPreferences myShPreference;
    private static String NOTE_TEXT = "note_text"; //значение переменной

    private TextView resultNote; //добавим поле для вывода

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getDateFromSharedPref();
    }
    private void initView(){
        inputNote = findViewById(R.id.inputNote);
        btnSaveNote = findViewById(R.id.btnSaveNote);
        myShPreference = getSharedPreferences("MyNote", MODE_PRIVATE); //создали файл MyNote с переменными

             btnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = myShPreference.edit();
                String inputresult = inputNote.getText().toString();
                editor.putString(NOTE_TEXT, inputresult); // добавили в переменную NOTE_TEXT текущее значение
                editor.apply();
                Toast.makeText(MainActivity.this, getString(R.string.message_add_note) + inputresult, Toast.LENGTH_LONG).show();

                inputNote.setText(inputresult);  //добавим вывод заметок в поле со списком значений
            }
        });
    }
    private void getDateFromSharedPref(){
        String inputresult = myShPreference.getString(NOTE_TEXT, "");
        inputNote.setText(inputresult);  //добавим вывод заметок в поле со списком значений
    }

}
