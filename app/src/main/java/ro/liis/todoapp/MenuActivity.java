package ro.liis.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ro.liis.todoapp.model.User;

public class MenuActivity extends AppCompatActivity {
    public static User currentUser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void goToProfile(View view){
        Intent intent =
                new Intent(MenuActivity.this,
                        ProfileActivity.class);
        intent.putExtra("userName", currentUser.getName());
        startActivity(intent);
    }

    public void goToAddTask(View view) {
        Intent intent = new Intent(MenuActivity.this, AddTaskActivity.class);
        startActivity(intent);
    }
}
