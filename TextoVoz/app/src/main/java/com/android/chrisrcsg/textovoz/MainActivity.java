package com.android.chrisrcsg.textovoz;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{


    //declarando objetos de la interfaz grafica
    TextToSpeech textToSpeech;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnES = (Button)findViewById(R.id.btnSpanish);
        Button btnEN = (Button)findViewById(R.id.btnEnglish);
        editText = (EditText)findViewById(R.id.texto);
        textToSpeech = new TextToSpeech(this, this);

        btnES.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                textToSpeech.setLanguage(new Locale("spa","ESP"));
                hablar(editText.getText().toString());
            }
        });

        btnEN.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                textToSpeech.setLanguage(Locale.ENGLISH);
                hablar(editText.getText().toString());
            }
        });
    }

    public  void hablar(String str){
        textToSpeech.speak(str,TextToSpeech.QUEUE_FLUSH, null);
        textToSpeech.setSpeechRate(0.5f);
    }

    @Override
    public void onInit(int status) {
        if(status ==textToSpeech.LANG_MISSING_DATA || status == TextToSpeech.LANG_NOT_SUPPORTED){
            Toast.makeText(this,"No se pudo inicializar",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}
