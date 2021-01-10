package android.example.workoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ProgramAbs extends AppCompatActivity {
    String nextActivity;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jumping_jack_description);
        ImageButton startpushup = findViewById(R.id.playButton);
        startpushup.setOnClickListener(view -> openNewActivity());

    }
    public void openNewActivity(){
        //Intent intent = new Intent(this, CameraActivity.class);
        Intent intent = new Intent(this, Exercise_jumpingjack.class);
        startActivityForResult(intent, 1);
    }
}