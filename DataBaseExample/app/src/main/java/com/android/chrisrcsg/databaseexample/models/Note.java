package com.android.chrisrcsg.databaseexample.models;

import com.android.chrisrcsg.databaseexample.app.MyAplication;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by ChrisRCSG on 21/06/17.
 */

public class Note extends RealmObject {
    @PrimaryKey
    private int id;  //Create Table
    @Required
    private String description;
    @Required
    private Date date; //*String = "CREATE TBALE NOTE( DESCRIPION VARCHAR(25) NOT NULL)"

    public Note(){}

    public Note(String description){
        this.id = MyAplication.NoteID.getAndIncrement();
        this.description = description;
        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }


}
