package com.example.iwtgh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListSong extends Activity {

    ArrayList<Song> list = new ArrayList<Song>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_list);

        list.add(new Song("고고베베 - 마마무", R.drawable.first));
        list.add(new Song("답을 찾지 못한 날 - 윤하", R.drawable.first));
        list.add(new Song("STAY - BlackPink", R.drawable.first));
        list.add(new Song("Perfect - Ed Sheeran", R.drawable.first));
        list.add(new Song("Bad guy - Billie Eilish", R.drawable.first));

        MyAdapter adapter = new MyAdapter(
                getApplicationContext(), // 현재화면의 제어권자
                R.layout.song,  // 리스트뷰의 한행의 레이아웃
                list);         // 데이터

        ListView lv = (ListView)findViewById(R.id.select_dialog_listview);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // 상세정보 화면으로 이동하기(인텐트 날리기)
                // 1. 다음화면을 만든다
                // 2. AndroidManifest.xml 에 화면을 등록한다
                // 3. Intent 객체를 생성하여 날린다
                Intent intent = new Intent(
                        getApplicationContext(), // 현재화면의 제어권자
                        Game.class); // 다음넘어갈 화면

                // intent 객체에 데이터를 실어서 보내기
                // 리스트뷰 클릭시 인텐트 (Intent) 생성하고 position 값을 이용하여 인텐트로 넘길값들을 넘긴다
                intent.putExtra("title", list.get(position).title);

                startActivity(intent);
            }
        });
    }
}

class MyAdapter extends BaseAdapter { // 리스트 뷰의 아답타
    Context context;
    int layout;
    ArrayList<Song> al;
    LayoutInflater inf;
    public MyAdapter(Context context, int layout, ArrayList<Song> al) {
        this.context = context;
        this.layout = layout;
        this.al = al;
        inf = (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return al.size();
    }
    @Override
    public Object getItem(int position) {
        return al.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView = inf.inflate(layout, null);
        }
        ImageView iv = (ImageView)convertView.findViewById(R.id.imageView1);
        TextView tvName = (TextView)convertView.findViewById(R.id.textView1);

        Song m = al.get(position);
        iv.setImageResource(m.img);
        tvName.setText(m.title);

        return convertView;
    }
}

class Song {
    String title = ""; // 곡 title
    int img; // 앨범 이미지
    public Song(String title, int img) {
        super();
        this.title = title;
        this.img = img;
    }
}