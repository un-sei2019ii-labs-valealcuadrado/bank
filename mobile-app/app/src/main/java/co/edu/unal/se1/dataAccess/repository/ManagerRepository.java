package co.edu.unal.se1.dataAccess.repository;

import android.content.Context;
import androidx.room.Room;
import java.util.List;

import co.edu.unal.se1.dataAccess.db.Database;
import co.edu.unal.se1.dataAccess.model.Manager;

public class ManagerRepository {

    private String DB_NAME = "se1_db_bank";

    private Database database;
    public ManagerRepository(Context context) {
        database = Room.databaseBuilder(context, Database.class, DB_NAME).
                allowMainThreadQueries().build();
    }

    public List<Manager> getAllManagers() {
        return database.managerDao().getAllManagers();
    }

    public Manager getManagerById(int id) {
        return database.managerDao().getManagerById(id);
    }

    public void createManager(final Manager manager) {
        database.managerDao().createManager(manager);
    }

    public void updateManager(Manager manager) {
        database.managerDao().updateManager(manager);
    }

    public void deleteManager(int id) {
        Manager manager = database.managerDao().getManagerById(id);
        database.managerDao().deleteManager(manager);
    }
}
