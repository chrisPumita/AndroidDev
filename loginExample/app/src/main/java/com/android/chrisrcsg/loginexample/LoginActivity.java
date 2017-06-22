package com.android.chrisrcsg.loginexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by ChrisRCSG on 22/06/17.
 */

public class LoginActivity extends AppCompatActivity {
    SharedPreferences preferences;
    EditText editTextEmail;
    EditText editTextPass;
    Switch switchRecordar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferences = getSharedPreferences("datos_login", Context.MODE_PRIVATE);

        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextPass = (EditText)findViewById(R.id.editTextPass);

        switchRecordar = (Switch) findViewById(R.id.swithRecordar);

        generarLasCredencialesSiExiste();
    }

    private boolean login(String email, String password){
        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this,"Email no valido", Toast.LENGTH_SHORT).show();
            return  false;
        }
        else if(!(password.length() >4)){
            Toast.makeText(this,"Contraseña no valido", Toast.LENGTH_SHORT).show();
            return  false;
        }

        else{
            return  true;
        }
    }


    public void iniciarSesion(View v){
        String email = editTextEmail.getText().toString();
        String password = editTextPass.getText().toString();

        if (login(email,password)){
            Intent intent = new Intent(this,MainActivity.class);
            //no regresa al login, por seguridad
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            guardaPreferencias(email,password);
        }

    }

    private void guardaPreferencias(String email, String password){
        if (switchRecordar.isChecked()){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("email",email);
            editor.putString("password",password);
            Toast.makeText(this, "Guardando credencial", Toast.LENGTH_SHORT).show();
        }
    }

    private  void generarLasCredencialesSiExiste(){
        String email = preferences.getString("email","");
        String password = preferences.getString("password","");

        editTextEmail.setText(email);
        editTextPass.setText(password);
    }
}
