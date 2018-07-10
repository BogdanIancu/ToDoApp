package ro.liis.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ro.liis.todoapp.model.User;

public class MenuActivity extends AppCompatActivity {
    public static User currentUser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
}
