package com.android.chrisrcsg.toolbarexample2;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Accedemos a Tablayout
        TabLayout tabLayout = (TabLayout)findViewById(R.id.toolbar);
        //Agregamos cada de uno de los tabs
        tabLayout.addTab(tabLayout.newTab().setText("uno"));
        tabLayout.addTab(tabLayout.newTab().setText("dos"));
        tabLayout.addTab(tabLayout.newTab().setText("tres"));

        //Agregando el ViewPager
        final ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);

        PageAdapter pageAdapter = new PageAdapter(
                getSupportFragmentManager(),
                tabLayout.getTabCount());

        viewPager.setAdapter(pageAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "Seleccionaste: "+tab.getText(), Toast.LENGTH_SHORT).show();
                int position = tab.getPosition();
                //hacer un barrido a la posicion
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "Dejaste: "+tab.getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "Volviste: "+tab.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
