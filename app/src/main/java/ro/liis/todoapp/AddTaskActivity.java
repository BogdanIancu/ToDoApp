package ro.liis.todoapp;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
    }

    public void AddTaskToCalendar(View view) {
        Intent intent = new Intent(Intent.ACTION_INSERT,
                CalendarContract.Events.CONTENT_URI);
        Calendar calendar = Calendar.getInstance();
        EditText dueDateEditTxt = findViewById(R.id.dueDateEditText);
        String dueDate = dueDateEditTxt.getText().toString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(dueDate);
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        EditText titleEditTxt = findViewById(R.id.titleEditText);
        intent.putExtra(CalendarContract.Events.TITLE, titleEditTxt.getText().toString());
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, calendar.getTimeInMillis());
        startActivity(intent);
    }
}
