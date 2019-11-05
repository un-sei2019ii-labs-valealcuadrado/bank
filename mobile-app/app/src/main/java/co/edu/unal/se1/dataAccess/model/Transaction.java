package co.edu.unal.se1.dataAccess.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.Date;
import java.lang.System;

@Entity (foreignKeys ={
        @ForeignKey(entity = Count.class,
                parentColumns = "idC",
                childColumns = "CountD",
                onDelete = ForeignKey.NO_ACTION),
        @ForeignKey(entity = Manager.class,
                parentColumns = "idM",
                childColumns = "idManager",
                onDelete = ForeignKey.NO_ACTION)
})
public class Transaction implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "idT")
    public int id_t;

    @ColumnInfo(name = "date")
    public Text date;

    @ColumnInfo(name = "money")
    public float money;

    @ColumnInfo(name = "CountD")
    public int id_count;

    @ColumnInfo(name = "idManager")
    public int id_manager;

    public int getId() {
        return id_t;
    }

    public void setId(int id) {
        this.id_t = id;
    }

    public Text getDate() {
        return date;
    }

    public void setDate(Text date) {
        this.date = date;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public int getIdCount(){
        return id_count;
    }

    public void setIdCount(int id_c){
        this.id_count=id_c;
    }

    public int getIdManager(){
        return id_manager;
    }

    public void setIdManager(int id_m){
        this.id_manager=id_m;
    }
}
