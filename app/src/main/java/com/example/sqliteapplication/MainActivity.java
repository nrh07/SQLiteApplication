package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Button simpanButton, btnGetall;
    private EditText namaEditText;
    private DatabaseHelper databaseHelper;
    private TextView tvnames;
    private ArrayList<String > namaArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        simpanButton = (Button) findViewById( R.id.simpanButton );
        btnGetall = (Button) findViewById( R.id.btnGetall );
        namaEditText = (EditText) findViewById( R.id.namaEditText );
        tvnames = (TextView) findViewById( R.id.tvnames );

        databaseHelper = new DatabaseHelper( this );

        simpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addStudentDetail(namaEditText.getText().toString());
                namaEditText.setText("");
                Toast.makeText(MainActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
            }
        } );

        btnGetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namaArrayList = databaseHelper.getAllStudentList();
                tvnames.setText( "" );
                for (int i = 0; i < namaArrayList.size(); i++) {
                    if (i == 0) {
                        tvnames.setText( namaArrayList.get( i ) );
                    } else {

                        tvnames.setText( tvnames.getText().toString() + namaArrayList.get( i ) + ", " );
                    }
                }
            }

        } );
    }
}