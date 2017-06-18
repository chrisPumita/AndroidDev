package com.android.chrisrcsg.intenimplicito;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btn_camara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Creando y casteando el boton del XML
        btn_camara = (Button)findViewById(R.id.btn_camara);
        btn_camara.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        Intent tomarFoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(tomarFoto,1);
                    }

                });
    }
    //Obteniendo lo que se revuelve la otra aplicacion
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        ImageView iv_foto;
        if (requestCode == 1 && resultCode == Activity.RESULT_OK)
        {
            Bitmap foto = (Bitmap)data.getExtras().get("data");
            iv_foto = (ImageView) findViewById(R.id.imgFoto);
            iv_foto.setImageBitmap(foto);
        }
    }

    public void visitaWebPage(View view)
    {
        Intent intent_sitio = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.google.com"));
        //Comenzar la aplicacion
        startActivity(intent_sitio);
    }
}
