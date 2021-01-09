package android.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

public class Exercice2Activity extends AppCompatActivity  {
    ImageButton startsitup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice2);

        startsitup = (ImageButton) findViewById(R.id.playButton);
        startsitup.setOnClickListener(view -> openNewActivity());

    }

    private void openNewActivity() {
        //Intent intent = new Intent(this, CameraActivity.class);
        Intent intent = new Intent(this, PushupActivity.class);
        startActivityForResult(intent, 1);
    }

}
