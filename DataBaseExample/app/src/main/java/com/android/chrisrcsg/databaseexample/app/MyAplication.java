package com.android.chrisrcsg.databaseexample.app;

import android.app.Application;

import com.android.chrisrcsg.databaseexample.models.Board;
import com.android.chrisrcsg.databaseexample.models.Note;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by ChrisRCSG on 21/06/17.
 */

public class MyAplication extends Application {

    //los enteros para los IDs
    public static AtomicInteger BoardID = new AtomicInteger();
    public static AtomicInteger NoteID;


    @Override
    public void onCreate() {
        super.onCreate();

        setUpRealConfig();;
        Realm realm = Realm.getDefaultInstance();
        BoardID = getIDByTable(realm, Board.class);
        NoteID = getIDByTable(realm, Note.class);
        realm.close();
    }

    private void setUpRealConfig(){
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(configuration);


    }

    //Para aumentar el ID
    private <T extends RealmObject>AtomicInteger getIDByTable(Realm realm, Class<T> anyClass){
        //Regresara el ID de cualquier entidad,

        //Accediendo al la BD medinate la consulta y almacenando en memoria los resultados obenidos
        // eje Note.class
        RealmResults<T> results = realm.where(anyClass).findAll(); // SELECT  * FROM

        //Regresa el primer valor ID para que lo incremente
        return (results.size()>0)? new AtomicInteger(results.max("id").intValue()) : new AtomicInteger();

    }
}
