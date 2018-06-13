package com.example.auseg.navigationcompat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmptyActivity extends AppCompatActivity {

    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        back = findViewById(R.id.Back);
        final Intent intent = new Intent(EmptyActivity.this, MainActivity.class);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
