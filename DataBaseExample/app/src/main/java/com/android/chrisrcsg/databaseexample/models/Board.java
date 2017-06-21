package com.android.chrisrcsg.databaseexample.models;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by ChrisRCSG on 21/06/17.
 */

public class Board extends RealmObject {
    @PrimaryKey
    private int id;
    @Required
    private String title;
    @Required
    private Date date;


    private RealmList<Note> notas;

    public Board(){}

    //constructor
    public Board(String title){
        this.id = 0;
        this.title = title;
        this.date = new Date();
        this.notas = new RealmList<Note>();

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }


    public RealmList<Note> getNotas() {
        return notas;
    }

}
