package co.edu.unal.se1.dataAccess.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.io.Serializable;
import co.edu.unal.se1.dataAccess.model.User;

@Entity (foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "idU",
        childColumns = "idC",
        onDelete = ForeignKey.NO_ACTION))

public class Count implements Serializable {

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "idC")
    public int id_c;

    @ColumnInfo(name = "balance")
    public double balance;

    @ColumnInfo(name = "idUser")
    public int id_user;

    public int getId() {
        return id_c;
    }

    public void setId_c(int id) {
        this.id_c = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getIdUser(){
        return id_user;
    }

    public void setIdUser(int id_u){
        this.id_user=id_u;
    }
}
