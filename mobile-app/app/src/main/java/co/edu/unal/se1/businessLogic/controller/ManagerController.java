package co.edu.unal.se1.businessLogic.controller;

import android.content.Context;

import co.edu.unal.se1.dataAccess.model.Manager;
import co.edu.unal.se1.dataAccess.repository.ManagerRepository;



public class ManagerController {

    private ManagerRepository managerRepository;


    public ManagerController() {

    }

    public void createManager(Manager manager, Context context) {

        managerRepository = new ManagerRepository(context);
        managerRepository.createManager(manager);
        System.out.println("¡Administrador creado satisfactoriamente!");
    }
}