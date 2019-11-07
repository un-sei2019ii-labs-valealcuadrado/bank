package co.edu.unal.se1.businessLogic.controller;

import org.junit.Test;


import co.edu.unal.se1.dataAccess.model.User;


import static org.junit.Assert.*;

public class UserControllerTest {

    @Test
    public void sendMoneySiPasa(){

        User sourceUser = new User();
        sourceUser.id = 1234;
        sourceUser.name = "Valentina V";
        sourceUser.balance = 40000;
        //assertEquals(user1.id,1234);

        User targetUser = new User();
        targetUser.id = 5678;
        targetUser.name = "Valentina B";
        targetUser.balance = 10000;
        //assertEquals(user2.id,5678);

        double value = 10000;

        //YO CONOZCO QUE EL VALOR DEBE SER VERDADERO
        boolean result=true;

        //COMPARACION DE LOS METODOS
        assertEquals(result, UserController.sendMoneyMod(sourceUser,targetUser,value));
    }

    @Test
    public void sendMoneyNoPasa(){

        User sourceUser = new User();
        sourceUser.id = 1234;
        sourceUser.name = "Valentina V";
        sourceUser.balance = 4000;
        //assertEquals(user1.id,1234);

        User targetUser = new User();
        targetUser.id = 5678;
        targetUser.name = "Valentina B";
        targetUser.balance = 10000;
        //assertEquals(user2.id,5678);

        double value = 10000;

        //YO CONOZCO QUE EL VALOR DEBE SER FALSO
        boolean result=false;

        //COMPARACION DE LOS METODOS
        assertEquals(result, UserController.sendMoneyMod(sourceUser,targetUser,value));
    }
}