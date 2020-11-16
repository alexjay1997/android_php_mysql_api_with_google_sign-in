package com.al.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Update_user extends AppCompatActivity {

    TextView user_idTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);


        String users_id = getIntent().getStringExtra("id");

        user_idTextView = (TextView) findViewById(R.id.userId_textView);
        user_idTextView.setText(users_id);
    }
}
