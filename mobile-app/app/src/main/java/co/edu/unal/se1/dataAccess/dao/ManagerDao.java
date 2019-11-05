package co.edu.unal.se1.dataAccess.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

import co.edu.unal.se1.dataAccess.model.Manager;

@Dao
public interface ManagerDao {

    @Query("SELECT * FROM manager")
    List<Manager> getAllManagers();

    @Query("SELECT * FROM user WHERE idU = :id")
    Manager getManagerById(int id);

    @Insert
    void createManager(Manager manager);

    @Update
    void updateManager(Manager manager);

    @Delete
    void deleteManager(Manager manager);
}