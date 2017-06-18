package com.android.chrisrcsg.menusexamples;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private static final int MenuOP1 = 1;
    private static final int MenuOP2 = 2;
    private static final int MenuOP3 = 3;

    private static final int SubmenuOPC1 = 31;
    private static final int SubmenuOPC2 = 32;

    private TextView LblMensaje;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionSubMenu(Menu menu) {
        //Indicar en que opcion nos encontramos
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return true;
    }
}
