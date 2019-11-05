package co.edu.unal.se1.dataAccess.repository;

import android.content.Context;
import androidx.room.Room;
import java.util.List;

import co.edu.unal.se1.dataAccess.db.Database;
import co.edu.unal.se1.dataAccess.model.Count;
import co.edu.unal.se1.dataAccess.model.User;

public class CountRepository {

    private String DB_NAME = "se1_db_bank";

    private Database database;
    public CountRepository(Context context) {
        database = Room.databaseBuilder(context, Database.class, DB_NAME).
                allowMainThreadQueries().build();
    }

    public List<Count> getAllCounts() {
        return database.countDao().getAllCounts();
    }

    public Count getCountById(int id) {
        return database.countDao().getCountById(id);
    }

    public int getMaxCountId(){
        return database.countDao().getMaxCountId();
    }

    public User getUserByIdC(int id){
        return database.userDao().getUserById(id);
    }

    public void createCount(final Count count) {
        database.countDao().createCount(count);
    }

    public void updateCount(Count count) {
        database.countDao().updateCount(count);
    }

    public void deleteCount(int id) {
        Count count = database.countDao().getCountById(id);
        database.countDao().deleteCount(count);
    }
}