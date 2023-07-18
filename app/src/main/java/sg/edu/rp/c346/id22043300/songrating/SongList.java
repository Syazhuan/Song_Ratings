package sg.edu.rp.c346.id22043300.songrating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SongList extends AppCompatActivity {

    ListView lv;
    Button btnback;
    Button btn5stars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        lv = findViewById(R.id.lv);
        btnback = findViewById(R.id.btn_back);
        btn5stars = findViewById(R.id.btn5stars);

        DBHelper db = new DBHelper(SongList.this);

        // Insert a task
        ArrayList<Song> data = db.getSongs();
        db.close();

        CustomAdapter adapter =  new CustomAdapter(SongList.this, R.layout.row, data);
        lv.setAdapter(adapter);

        btnback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SongList.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn5stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(SongList.this);
                data.clear();
                Integer filter = 5;
                // Insert a task
                data.addAll(db.getSongs(filter));
                adapter.notifyDataSetChanged();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long id) {
                Song song = data.get(position);
                Intent i = new Intent(SongList.this,
                        SongEdit.class);
                i.putExtra("data", song);
                startActivity(i);
            }
        });
    }
}