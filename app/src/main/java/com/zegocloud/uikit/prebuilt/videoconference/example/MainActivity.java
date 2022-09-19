package com.zegocloud.uikit.prebuilt.videoconference.example;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.join_btn).setOnClickListener(v -> {
            TextInputLayout textInputLayout = findViewById(R.id.text_input_layout);
            String conferenceID = textInputLayout.getEditText().getText().toString();
            if (conferenceID.isEmpty()) {
                textInputLayout.setError("please input conferenceID");
                return;
            }
            textInputLayout.setError("");
            Intent intent = new Intent(MainActivity.this, CallActivity.class);
            intent.putExtra("conferenceID", conferenceID);
            startActivity(intent);
        });
    }
}