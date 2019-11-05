package co.edu.unal.se1.businessLogic.controller;

import android.content.Context;

import co.edu.unal.se1.dataAccess.model.Count;
import co.edu.unal.se1.dataAccess.repository.CountRepository;



public class CountController {

    private CountRepository countRepository;


    public CountController() {

    }

    public void createCount(Count count, Context context) {

        countRepository = new CountRepository(context);
        countRepository.createCount(count);
        System.out.println("¡Cuenta creada satisfactoriamente!");
    }
}