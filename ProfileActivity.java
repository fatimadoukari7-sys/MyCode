package com.mybrand.newlab3_1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView name, dept, contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = findViewById(R.id.profileName);
        dept = findViewById(R.id.profileDepartment);
        contact = findViewById(R.id.profileContact);

        name.setText(getIntent().getStringExtra("name"));
        dept.setText(getIntent().getStringExtra("dept"));
        contact.setText(getIntent().getStringExtra("contact"));
    }
}
