package sg.edu.rp.c346.id22043300.songrating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SongList extends AppCompatActivity {

    ListView lv;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        lv = findViewById(R.id.lv);
        btnback = findViewById(R.id.btn_back);

        DBHelper db = new DBHelper(SongList.this);

        // Insert a task
        ArrayList<Song> data = db.getSongs();
        db.close();

        ArrayAdapter adapter =  new ArrayAdapter<>(SongList.this, android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);

        btnback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SongList.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}