package co.edu.unal.se1.dataAccess.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity
public class Manager implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "idM")
    public int id_m;

    @ColumnInfo(name = "nameM")
    public String name_m;

    @ColumnInfo(name = "mailM")
    public String mail_m;

    @ColumnInfo(name = "passwordM")
    public String password_m;

    public int getId() {
        return id_m;
    }

    public void setId(int id) {
        this.id_m = id;
    }

    public String getName() {
        return name_m;
    }

    public void setName(String name) {
        this.name_m = name;
    }

    public String getMail() {
        return mail_m;
    }

    public void setMail(String mail) {
        this.mail_m = mail;
    }

    public String getPassword() {
        return password_m;
    }

    public void setPassword(String password) {
        this.password_m = password;
    }
}
