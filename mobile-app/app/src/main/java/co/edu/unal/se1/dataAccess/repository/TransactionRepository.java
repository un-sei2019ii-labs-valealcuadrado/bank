package co.edu.unal.se1.dataAccess.repository;

import android.content.Context;
import androidx.room.Room;
import java.util.List;

import co.edu.unal.se1.dataAccess.db.Database;
import co.edu.unal.se1.dataAccess.model.Count;
import co.edu.unal.se1.dataAccess.model.Manager;
import co.edu.unal.se1.dataAccess.model.Transaction;
import co.edu.unal.se1.dataAccess.model.User;

public class TransactionRepository {

    private String DB_NAME = "se1_db_bank";

    private Database database;
    public TransactionRepository(Context context) {
        database = Room.databaseBuilder(context, Database.class, DB_NAME).
                allowMainThreadQueries().build();
    }

    public List<Transaction> getAllTransactions() {
        return database.transactionDao().getAllTransactions();
    }

    public Transaction getTransactionById(int id) {
        return database.transactionDao().getTransactionById(id);
    }

    public Count getCountByIdC(int id){
        return database.countDao().getCountById(id);
    }

    public Manager getManagerByIdC(int id){
        return database.managerDao().getManagerById(id);
    }

    public void createTransaction(final Transaction transaction) {
        database.transactionDao().createTransaction(transaction);
    }

    public void updateTransaction(Transaction transaction) {
        database.transactionDao().updateTransaction(transaction);
    }

    public void deleteTransaction(int id) {
        Transaction transaction = database.transactionDao().getTransactionById(id);
        database.transactionDao().deleteTransaction(transaction);
    }
}