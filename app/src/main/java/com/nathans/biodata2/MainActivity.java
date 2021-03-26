package com.nathans.biodata2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Hasil;
    EditText Name, Gender, NPM, Phone;
    Button Submit;
    Button Clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Hasil = (TextView) findViewById(R.id.txtNpmDanNama);
        Name = (EditText) findViewById(R.id.edtName);
        Gender = (EditText) findViewById(R.id.edtGender);
        NPM = (EditText) findViewById(R.id.edtNPM);
        Phone = (EditText) findViewById(R.id.edtPhone);
        Submit = (Button) findViewById(R.id.btnSubmit);
        Clear = (Button) findViewById(R.id.btnClear);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNama = Name.getText().toString();
                String strGender = Gender.getText().toString();
                String strNPM = NPM.getText().toString();
                String strPhone = Phone.getText().toString();

                Hasil.setText(strNama + "\n" + strGender + "\n" + strNPM + "\n" + strPhone);
            }
        });

        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name.setText("");
                Gender.setText("");
                NPM.setText("");
                Phone.setText("");
                Hasil.setText("");
            }
        });
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.bioicon)
                .setTitle("Exit App")
                .setMessage("Are you sure?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
    }
}