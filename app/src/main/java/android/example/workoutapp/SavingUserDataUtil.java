package android.example.workoutapp;

import android.content.SharedPreferences;
import android.view.View;

public class SavingUserDataUtil {


    public void saveDataWorkout(View view, int duration, int kcal, int number, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String newDuration = String.valueOf(duration + Integer.valueOf(sharedPreferences.getString("duration", "")));
        String newKcal = String.valueOf(kcal + Integer.valueOf(sharedPreferences.getString("kcal", "")));
        String newNumber = String.valueOf(number + Integer.valueOf(sharedPreferences.getString("numberWorkout", "")));

        editor.putString("duration", newDuration);
        editor.putString("kcal", newKcal);
        editor.putString("numberWorkout", newNumber);
        editor.commit();
    }
}
