package ro.liis.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ro.liis.todoapp.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MainActivity", "Aplicatia a pornit!");

        Button registerBtn = findViewById(R.id.registerButton);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        EditText userEditTxt = findViewById(R.id.userEditText);
        EditText passEditTxt = findViewById(R.id.passwordEditText);
        userEditTxt.setText("");
        passEditTxt.setText("");
    }

    public void Login(View view){
        EditText userEditTxt = findViewById(R.id.userEditText);
        EditText passEditTxt = findViewById(R.id.passwordEditText);
        if(userEditTxt.getText().toString().trim().length() > 4 &&
                passEditTxt.getText().toString().trim().length() > 4) {
            if(userEditTxt.getText().toString().equals("admin") &&
                    passEditTxt.getText().toString().equals("admin")) {
                User user = new User("admin", "admin");
                MenuActivity.currentUser = user;
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(),
                        R.string.incorrect_login,
                        Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(),
                    R.string.login_error,
                    Toast.LENGTH_LONG).show();
        }
    }
}
