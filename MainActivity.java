package com.mybrand.newlab3_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> studentArrayList;
    StudentAdapter adapter;

    ListView listView;
    EditText inputName, inputDepartment, inputContact;
    Button btnAddStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = findViewById(R.id.inputName);
        inputDepartment = findViewById(R.id.inputDepartment);
        inputContact = findViewById(R.id.inputContact);
        btnAddStudent = findViewById(R.id.btnAddStudent);
        listView = findViewById(R.id.listView);

        studentArrayList = new ArrayList<>();

        studentArrayList.add(new Student("Ahmed", "CS", "ahmed@test.com"));
        studentArrayList.add(new Student("Amina", "Math", "amina@test.com"));

        adapter = new StudentAdapter(this, studentArrayList);
        listView.setAdapter(adapter);

        // ➜ Add student
        btnAddStudent.setOnClickListener(v -> {

            String name = inputName.getText().toString().trim();
            String department = inputDepartment.getText().toString().trim();
            String contact = inputContact.getText().toString().trim();

            if (name.isEmpty() || department.isEmpty() || contact.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                studentArrayList.add(new Student(name, department, contact));
                adapter.notifyDataSetChanged();

                inputName.setText("");
                inputDepartment.setText("");
                inputContact.setText("");
            }
        });

        // ➜ Click item → Profile
        listView.setOnItemClickListener((parent, view, position, id) -> {

            Student student = studentArrayList.get(position);

            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("name", student.getName());
            intent.putExtra("dept", student.getDepartment());
            intent.putExtra("contact", student.getContact());

            startActivity(intent);
        });
    }
}
