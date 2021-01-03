package android.example.workoutapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListExercisesActivity extends AppCompatActivity {

    ListView simpleList;
    String[] exerciseList = new String[] {
            "Exercise 1", "Exercise 2", "Exercise 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_exercises);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        CustomAdapter customAdapter = new  CustomAdapter();

        simpleList = (ListView) findViewById(R.id.listViewExercisesID);
        simpleList.setAdapter(customAdapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Intent intent = new Intent(getApplicationContext(), Exercise1Activity.class);
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(ListExercisesActivity.this, "I am the case n° " + customAdapter.getItem(position), Toast.LENGTH_SHORT).show();
                };

            }
        });
    }
    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            // return ListViewImages.length();
            return 3;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.activity_list_view, null);
            TextView name = view1.findViewById(R.id.exerciseTitleID);
            TextView descp = view1.findViewById(R.id.exerciseDescriptionID);
            // ImageView image = view1.findViewById(R.id.list_view_images);

            name.setText(exerciseList[i]);
            // descp.setText(exerciseDescription[i]);
            // image.setImageResource(ListImage[i]);
            return view1;
        }
    }
}