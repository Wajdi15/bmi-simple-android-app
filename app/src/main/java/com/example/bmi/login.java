package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText user, password;
    TextView msgg;
    private int wrongPass = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.editTextUser);
        password = findViewById(R.id.editPassword);
        msgg = findViewById(R.id.textViewTry);
        Button btn = (Button)findViewById(R.id.button);

        CountDownTimer timer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Do nothing on each tick
            }

            @Override
            public void onFinish() {
                // Re-enable the button after 30 seconds
                btn.setEnabled(true);
            }
        };

        btn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String userName = user.getText().toString();
                String passwordUser = password.getText().toString();


                    if (passwordUser.equals("1717")) {
                        Intent bmiActivity = new Intent(login.this, MainActivity.class);
                        bmiActivity.putExtra("user", userName);
                        startActivity(bmiActivity);
                    } else {
                        login.this.wrongPass++;
                        msgg.setText(String.format("Try again You got only %s left", login.this.wrongPass));
                        if (login.this.wrongPass == 5) {
                            Toast.makeText(login.this, "Invalid password. Please try again. after 30 sec", Toast.LENGTH_LONG).show();
                            btn.setEnabled(false);
                            timer.start();
                            msgg.setText("");
                            login.this.wrongPass = 0;
                        }
                    }


            }
        });


    }

}