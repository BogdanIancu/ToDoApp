package ro.liis.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Vector;

import ro.liis.todoapp.model.Task;
import ro.liis.todoapp.model.User;

public class MenuActivity extends AppCompatActivity {
    public static User currentUser = null;
    private ArrayList<Task> taskVector = new ArrayList<>();

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
        startActivityForResult(intent, 100);
    }

    public void goToTaskList(View view) {
        Intent intent = new Intent(MenuActivity.this,
                TaskListActivity.class);
        intent.putExtra("list", taskVector);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 100 && resultCode == RESULT_OK) {
            Task t = (Task)data.getSerializableExtra("task");
            taskVector.add(t);
        }
    }
}
