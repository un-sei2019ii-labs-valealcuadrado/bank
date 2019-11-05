package co.edu.unal.se1.businessLogic.controller;

import android.content.Context;

import co.edu.unal.se1.dataAccess.model.Count;
import co.edu.unal.se1.dataAccess.model.User;
import co.edu.unal.se1.dataAccess.repository.CountRepository;
import co.edu.unal.se1.dataAccess.repository.UserRepository;

public class UserController {

    private UserRepository userRepository;
    private CountRepository countRepository;

    public UserController() {

    }

    public void createUser(User user, Context context) {

        userRepository = new UserRepository(context);
        userRepository.createUser(user);
        System.out.println("¡Usuario creado satisfactoriamente!");
    }

    public boolean sendMoney(int sourceId, int targetId, double value, Context context) {

        countRepository = new CountRepository(context);

        final Count sourceUserC = countRepository.getCountById(sourceId);
        final User sourceUser = countRepository.getUserByIdC(sourceId);

        System.out.println("Count Source User - ID: " + sourceUserC.getId() +
                "Source User - ID: " + sourceUser.getId() +
                ", Name: " + sourceUser.getName() +
                ", Balance: " + sourceUserC.getBalance());

        if (sourceUserC.getBalance() >= value) {

            final Count targetUserC = countRepository.getCountById(targetId);
            final User targetUser = countRepository.getUserByIdC(sourceId);

            System.out.println("Count Target User - ID: " + targetUserC.getId() +
                    "Target User - ID: " + targetUser.getId() +
                    ", Name: " + targetUser.getName() +
                    ", Balance: " + targetUserC.getBalance());

            sourceUserC.setBalance(sourceUserC.getBalance() - value);
            targetUserC.setBalance(targetUserC.getBalance() + value);

            countRepository.updateCount(sourceUserC);
            countRepository.updateCount(targetUserC);

            final Count updatedSourceUserC = countRepository.getCountById(sourceId);
            final User updatedSourceUser = countRepository.getUserByIdC(sourceId);
            System.out.println("Source User (updated) - ID: " + updatedSourceUser.getId() +
                    ", Name: " + updatedSourceUser.getName() +
                    ", Balance: " + updatedSourceUserC.getBalance());

            final Count updatedTargetUserC = countRepository.getCountById(targetId);
            final User updatedTargetUser = countRepository.getUserByIdC(sourceId);
            System.out.println("Target User (updated) - ID: " + updatedTargetUser.getId() +
                    ", Name: " + updatedTargetUser.getName() +
                    ", Balance: " + updatedTargetUserC.getBalance());

            return true;

        } else {

            return false;
        }

    }
}
