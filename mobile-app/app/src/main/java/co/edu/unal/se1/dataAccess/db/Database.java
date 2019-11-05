package co.edu.unal.se1.dataAccess.db;

import androidx.room.RoomDatabase;

import co.edu.unal.se1.dataAccess.dao.CountDao;
import co.edu.unal.se1.dataAccess.dao.UserDao;
import co.edu.unal.se1.dataAccess.dao.ManagerDao;
import co.edu.unal.se1.dataAccess.dao.TransactionDao;
import co.edu.unal.se1.dataAccess.model.Count;
import co.edu.unal.se1.dataAccess.model.User;
import co.edu.unal.se1.dataAccess.model.Manager;
import co.edu.unal.se1.dataAccess.model.Transaction;

@androidx.room.Database(entities = {User.class, Count.class, Manager.class, Transaction.class}, version = 1)

public abstract class Database extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract CountDao countDao();
    public abstract ManagerDao managerDao();
    public abstract TransactionDao transactionDao();
}
