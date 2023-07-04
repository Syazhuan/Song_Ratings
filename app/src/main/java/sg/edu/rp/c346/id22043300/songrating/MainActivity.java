package sg.edu.rp.c346.id22043300.songrating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button btn_ins, btn_sl;
    EditText etSongTitle, etSinger, etYear;
    RadioGroup rg_no_stars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_ins = findViewById(R.id.btn_insert);
        etSongTitle = findViewById(R.id.et_st);
        etSinger = findViewById(R.id.et_sn);
        etYear = findViewById(R.id.et_y);
        rg_no_stars = findViewById(R.id.rg_stars);
        btn_sl = findViewById(R.id.btn_sl);

        btn_ins.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                int rating = 1;
                int checkedRadioId = rg_no_stars.getCheckedRadioButtonId();
                if(checkedRadioId == R.id.rb_1s){
                    rating = 1;
                }
                else if(checkedRadioId == R.id.rb_2s){
                    rating = 2;
                }
                else if(checkedRadioId == R.id.rb_3s){
                    rating = 3;
                }
                else if(checkedRadioId == R.id.rb_4s){
                    rating = 4;
                }
                else if(checkedRadioId == R.id.rb_5s){
                    rating = 5;
                }

                //Convert all input into String
                String title = etSongTitle.getText().toString();
                String singer = etSinger.getText().toString();
                String year= etYear.getText().toString();
                int finalYear=Integer.parseInt(year);

                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask(title, singer, finalYear, rating);

            }
        });

        btn_sl.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SongList.class);
                startActivity(intent);
            }
        });
    }
}