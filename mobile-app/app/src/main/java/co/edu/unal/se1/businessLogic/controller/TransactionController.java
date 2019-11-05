package co.edu.unal.se1.businessLogic.controller;

import android.content.Context;

import co.edu.unal.se1.dataAccess.model.Transaction;
import co.edu.unal.se1.dataAccess.repository.TransactionRepository;



public class TransactionController {

    private TransactionRepository transactionRepository;


    public TransactionController() {

    }

    public void createTransaction(Transaction transaction, Context context) {

        transactionRepository = new TransactionRepository(context);
        transactionRepository.createTransaction(transaction);
        System.out.println("¡Transacción creada satisfactoriamente!");
    }
}