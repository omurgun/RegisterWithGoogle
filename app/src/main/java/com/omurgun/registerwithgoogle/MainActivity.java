package com.omurgun.registerwithgoogle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    private Button btnRegister;
    private FirebaseUser firebaseUser;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        if(checkCurrentUser()) {
            goLogin();
        }
        else {

            btnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentRegister = new Intent(MainActivity.this,RegisterActivity.class);
                    startActivity(intentRegister);
                    finish();
                }
            });
        }


    }

    private void init(){

        btnRegister = findViewById(R.id.btnRegister);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

    }
    private boolean checkCurrentUser() {

        boolean result = false;
        if(firebaseUser!= null)
        {
            result =true;
        }
        return result;
    }
    private void goLogin() {
        Intent intentLogin = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intentLogin);
        finish();
    }
}
