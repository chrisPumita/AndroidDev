package com.android.chrisrcsg.recycleviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;

    RecyclerView.LayoutManager layoutManager;
    List<String> names;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = getAllNames();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);

        mAdapter = new MyAdapter(names, R.layout.recycler, new MyAdapter.onItemClickListener(){
            public void onItemClick(String name, int position){
                Toast.makeText(MainActivity.this, name + " - "+ position, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    public List<String>getAllNames(){
        return new ArrayList<String>(){{
            add("Rodfrigo");
            add("Alan");
            add("Lizbeth");
            add("Luis");
            add("Jose");

            add("Rodfrigo1");
            add("Alan1");
            add("Lizbeth1");
            add("Luis1");
            add("Jose1");

            add("Rodfrigo2");
            add("Alan2");
            add("Lizbeth2");
            add("Luis2");
            add("Jose2");
        }};
    }
}
