package com.example.iwtgh;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListSong extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_list);

        ListView lv = (ListView)findViewById(R.id.select_dialog_listview);

        ArrayList <String> list = new ArrayList<String>();

        list.add("고고베베 - 마마무");

        ArrayAdapter <String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        lv.setAdapter(adapter);
    }
}
