package co.edu.unal.se1.dataAccess.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.google.common.collect.TreeRangeMap;

import java.util.List;

import co.edu.unal.se1.dataAccess.model.Count;
import co.edu.unal.se1.dataAccess.model.Transaction;
import co.edu.unal.se1.dataAccess.model.User;

@Dao
public interface TransactionDao {

    @Query("SELECT * FROM `transaction`")
    List<Transaction> getAllTransactions();

    @Query("SELECT * FROM `transaction` WHERE idT = :id")
    Transaction getTransactionById(int id);

    @Query("SELECT CountD FROM `transaction` WHERE CountD = :id")
    int getCountId(int id);

    @Insert
    void createTransaction(Transaction transaction);

    @Update
    void updateTransaction(Transaction transaction);

    @Delete
    void deleteTransaction(Transaction transaction);
}
