package com.android.chrisrcsg.call;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Actvando el display la barra para ir hacia atras
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Activar flecha ir atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView = (TextView) findViewById(R.id.textViewMain);
        btnNext = (Button) findViewById(R.id.buttonGoSharing);

        // Tomar los datos del intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.getString("greeter") != null) {
            String greeter = bundle.getString("greeter");
            Toast.makeText(SecondActivity.this, greeter, Toast.LENGTH_LONG).show();
            textView.setText(greeter);
        } else {
            Toast.makeText(SecondActivity.this, "Está vacío", Toast.LENGTH_LONG).show();
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}
