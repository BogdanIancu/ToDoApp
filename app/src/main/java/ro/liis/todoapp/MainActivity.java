package ro.liis.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MainActivity", "Aplicatia a pornit!");
    }

    public void Login(View view){
        EditText userEditTxt = findViewById(R.id.userEditText);
        EditText passEditTxt = findViewById(R.id.passwordEditText);
        if(userEditTxt.getText().toString().trim().length() > 4 &&
                passEditTxt.getText().toString().trim().length() > 4) {

        }
        else {
            Toast.makeText(getApplicationContext(),
                    R.string.login_error,
                    Toast.LENGTH_LONG).show();
        }
    }
}
