package com.example.pocketwit;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MedicalRecord extends AppCompatActivity {

    EditText firstName, lastName, studentID, healthStat, studentAge, studentHeight, studentWeight;

    private static final String KEY_FIRSTNAME= "firstname_key";
    private static final String KEY_LASTNAME= "lastname_key";
    private static final String KEY_HEALTHSTAT= "healthStat_key";
    private static final String KEY_STUDENTID = "studentID_key";
    private static final String KEY_STUDENTAGE = "studentAge_key";
    private static final String KEY_STUDENTHEIGHT = "studentHeight_key";
    private static final String KEY_STUDENTWEIGHT = "studentWeight_key";

    //private String mFirstName, mLastName, mID, mHealth, mAge, mHeight, mWeight;
    TextView first, last, id, health, age, height, weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicalrecord);

        firstName = (EditText) findViewById(R.id.edit_student_firstname);
        lastName = (EditText) findViewById(R.id.edit_student_lastname);
        healthStat = (EditText) findViewById(R.id.edit_student_health);
        studentID = (EditText) findViewById(R.id.edit_student_id);
        studentAge = (EditText) findViewById(R.id.edit_student_age);
        studentHeight = (EditText) findViewById(R.id.edit_student_height);
        studentWeight = (EditText) findViewById(R.id.edit_student_weight);

        first = (TextView) findViewById(R.id.stuFirst);
        last = (TextView) findViewById(R.id.stuLast);
        id = (TextView) findViewById(R.id.stuID);
        health = (TextView) findViewById(R.id.stuHealth);
        age = (TextView) findViewById(R.id.stuAge);
        height = (TextView) findViewById(R.id.stuHeight);
        weight = (TextView) findViewById(R.id.stuWeight);

        if (savedInstanceState != null) {
            String savedFirstName = savedInstanceState.getString(KEY_FIRSTNAME);
            first.setText(savedFirstName);

            String savedLastName = savedInstanceState.getString(KEY_LASTNAME);
            last.setText(savedLastName);

            String savedStudentID = savedInstanceState.getString(KEY_STUDENTID);
            id.setText(savedStudentID);

            String savedHealthStat = savedInstanceState.getString(KEY_HEALTHSTAT);
            health.setText(savedHealthStat);

            int savedStudentAge = savedInstanceState.getInt(KEY_STUDENTAGE);
            age.setText(savedStudentAge);

            int savedStudentHeight = savedInstanceState.getInt(KEY_STUDENTHEIGHT);
            height.setText(savedStudentHeight);

            int savedStudentWeight = savedInstanceState.getInt(KEY_STUDENTWEIGHT);
            weight.setText(savedStudentWeight);
        }

        else {
            Toast.makeText(this, "New entry", Toast.LENGTH_SHORT).show();
        }

    }




    @Override
    public void onSaveInstanceState (Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(KEY_FIRSTNAME, first.getText().toString());
        savedInstanceState.putString(KEY_LASTNAME, last.getText().toString());
        savedInstanceState.putString(KEY_STUDENTID, id.getText().toString());
        savedInstanceState.putString(KEY_HEALTHSTAT, health.getText().toString());
        savedInstanceState.putString(KEY_STUDENTAGE, age.getText().toString());
        savedInstanceState.putString(KEY_STUDENTHEIGHT, height.getText().toString());
        savedInstanceState.putString(KEY_STUDENTWEIGHT, weight.getText().toString());

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        String firstname_key = savedInstanceState.getString("MyString");
    }


    public void saveView(View view){
        first.setText(firstName.getText().toString().trim());
        last.setText(lastName.getText().toString().trim());
        id.setText(studentID.getText().toString().trim());
        health.setText(healthStat.getText().toString().trim());
        age.setText(studentAge.getText().toString().trim());
        height.setText(studentHeight.getText().toString().trim());
        weight.setText(studentWeight.getText().toString().trim());
    }


}