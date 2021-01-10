package android.example.workoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Exercise2ActivityDone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1_done);
        Bundle extras = getIntent().getExtras();
        int duration = Integer.parseInt(extras.getString("duration"));
        int number = Integer.parseInt(extras.getString("number"));
        int kcal = (int)(number * 0.5);

        ((TextView)findViewById(R.id.textView5)).setText("SQUATS DONE");

        if (duration > 59){
            ((TextView)findViewById(R.id.textView9)).setText("You just did " + number + " squats in " +
                    (int)(duration/60) +" Minutes and " + duration%60 +" seconds.");
        }
        else{
            ((TextView)findViewById(R.id.textView9)).setText("You just did " + number + " squats in " + duration +" seconds.");
        }
        int average  = 0;
        if (duration==0){
            average = 0;
        }else{
            average = (60*number)/duration;
        }
        ((TextView)findViewById(R.id.textView14)).setText("Thats "+ average +" squats per minute on average.");
        ((TextView)findViewById(R.id.textView11)).setText("You burned " +kcal+" kcal.\n");


        Button donebutton = (Button) findViewById(R.id.button);
        donebutton.setOnClickListener(view -> openNewActivity());


    }

    public void openNewActivity(){
        //Intent intent = new Intent(this, CameraActivity.class);
        Intent intent = new Intent(this, ListExercisesActivity.class);
        startActivityForResult(intent, 1);
    }
/*
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String incMessage = data.getStringExtra("message");
                Toast.makeText(getApplicationContext(), incMessage, Toast.LENGTH_LONG).show();

            }
        }
    }
*/
}