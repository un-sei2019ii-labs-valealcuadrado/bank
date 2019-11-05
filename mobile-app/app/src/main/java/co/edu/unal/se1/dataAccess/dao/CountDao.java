package co.edu.unal.se1.dataAccess.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

import co.edu.unal.se1.dataAccess.model.Count;
import co.edu.unal.se1.dataAccess.model.User;

@Dao
public interface CountDao {

    @Query("SELECT * FROM count")
    List<Count> getAllCounts();

    @Query("SELECT * FROM count WHERE idC = :id")
    Count getCountById(int id);

    @Query("SELECT * FROM count WHERE idC = (SELECT max(idC) FROM count)")
    int getMaxCountId();

    @Query("SELECT idUser FROM count WHERE idUser = :id")
    int getUserId(int id);

    @Insert
    void createCount(Count count);

    @Update
    void updateCount(Count count);

    @Delete
    void deleteCount(Count count);
}
