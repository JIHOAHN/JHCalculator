package com.example.a1694174.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public String expected;
    public EditText answer;
    public TextView question;



    public void submitButton(View v) {
        if (answer.getText().toString().equals(expected)) {
            Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "What an useless Brain! ", Toast.LENGTH_SHORT).show();
        }
        answer.setText("");
        setQuestion();
    }

    public void setQuestion() {
        Random rand = new Random();
        int x = rand.nextInt(3);
        int lhs = rand.nextInt(21)-10;
        int rhs = rand.nextInt(21)-10;

        if (x==0) {
            question.setText("What is " + lhs + " X " + rhs + "?");
            expected = "" + (lhs * rhs);
        }
        else if (x==1) {
            question.setText("What is " + lhs + " - " + rhs + "?");
            expected = "" + (lhs - rhs);
        }
        else {
            question.setText("What is " + lhs + " + " + rhs + "?");
            expected = "" + (lhs + rhs);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer = (EditText) findViewById(R.id.answer);
        question = (TextView) findViewById(R.id.question);
        setQuestion();

    }
}