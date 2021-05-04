package com.example.mapchermyanin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTxt);
        searchBtn = findViewById(R.id.searchBtn);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                char[] val = editText.getText().toString().toCharArray();
                for (char ch : val) {
                    if(Character.isLetter(ch)) {
                        intent.setData(Uri.parse("geo:?q=" + editText.getText().toString()));
                        break;
                    } else {
                        intent.setData(Uri.parse("geo:" + editText.getText().toString()));
                    }
                }

                if(intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("Intent", "Activity not found");
                }
            }
        });

    }
}