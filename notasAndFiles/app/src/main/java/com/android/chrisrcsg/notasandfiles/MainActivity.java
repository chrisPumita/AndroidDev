package com.android.chrisrcsg.notasandfiles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText nomb_arch;
    EditText cont_arch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomb_arch = (EditText)findViewById(R.id.nomb_archivo);
        cont_arch = (EditText)findViewById(R.id.cont_arch);

    }

    public void guardar(View v){
        String nombre_arch = nomb_arch.getText().toString();
        String contenido = cont_arch.getText().toString();

        try {
            FileOutputStream flujo = openFileOutput(nombre_arch,MODE_PRIVATE);
            flujo.write(contenido.getBytes());
            //limpiar el flujo
            flujo.flush();

            //cerrar el flujo
            flujo.close();
            Toast.makeText(this, "Los datos fueron guardados correctamente", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e){
            Toast.makeText(this, "Ocurrio un error al guardar", Toast.LENGTH_SHORT).show();
        }
    }

    public void abrir(View v){
        String nombre_arch = nomb_arch.getText().toString();
        String datos = "";
        int c;

        try {
            FileInputStream flujo = openFileInput(nombre_arch);
            while ((c = flujo.read())!= -1){
                datos = datos + (char)c;
                //cerrar el flujo
                flujo.close();
                cont_arch.setText(datos);
                Toast.makeText(this, "Los datos fueron leidos correctamente", Toast.LENGTH_SHORT).show();
            }
        }
        catch (IOException e){
            Toast.makeText(this, "Ocurrio un error al abrir", Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminar(View v){
        String nombre_arch = nomb_arch.getText().toString();
        File dir = getFilesDir();
        File file = new File(dir,nombre_arch);

        if (file.delete()){
            nomb_arch.setText("");
            cont_arch.setText("");
            Toast.makeText(this, "Se elimino el archivo", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Ocurrio un error al eliminar o no existe el archivo", Toast.LENGTH_SHORT).show();
        }
    }
}
