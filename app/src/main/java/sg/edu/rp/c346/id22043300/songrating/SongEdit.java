package sg.edu.rp.c346.id22043300.songrating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SongEdit extends AppCompatActivity {

    Button btnUpdate, btnDelete, btnCancel;
    EditText etSongID, etSongTitle, etSinger, etYear;
    RadioGroup rg_no_stars;
    Song data;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_edit);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);
        etSongTitle = findViewById(R.id.et_st2);
        etSinger = findViewById(R.id.et_sn2);
        etYear = findViewById(R.id.et_y2);
        rg_no_stars = findViewById(R.id.rg_stars2);


        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        etSongID.setText(String.valueOf(data.getId()));
        etSongTitle.setText(data.getTitle());
        etSinger.setText(data.getSingers());
        etYear.setText(String.valueOf(data.getYear()));

        int selected = data.getStar();

        if (selected == 1) {
            radioButton = findViewById(R.id.rb_1s_2);
        } else if (selected == 2) {
            radioButton = findViewById(R.id.rb_2s_2);
        } else if (selected == 3) {
            radioButton = findViewById(R.id.rb_3s_2);
        } else if (selected == 4) {
            radioButton = findViewById(R.id.rb_4s_2);
        } else if (selected == 5) {
            radioButton = findViewById(R.id.rb_5s_2);
        }
        radioButton.setChecked(true);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
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

                DBHelper dbh = new DBHelper(SongEdit.this);
                data.setTitle(etSongTitle.getText().toString());
                data.setSingers(etSinger.getText().toString());
                data.setYear(Integer.parseInt(etYear.getText().toString()));
                data.setTitle(etSongTitle.getText().toString());
                data.setStar(rating);
                dbh.updateSong(data);
                dbh.close();

                Intent intent = new Intent(SongEdit.this, SongList.class);
                startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(SongEdit.this);
                dbh.deleteSong(data.getId());

                Intent i = new Intent(SongEdit.this,
                        SongList.class);
                startActivity(i);
            }
        });
    }
}