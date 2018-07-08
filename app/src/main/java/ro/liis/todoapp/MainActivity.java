package ro.liis.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MainActivity", "Aplicatia a pornit!");
        Toast t = Toast.makeText(getApplicationContext(), "A pornit!",
                Toast.LENGTH_LONG);
        t.show();
    }
}
