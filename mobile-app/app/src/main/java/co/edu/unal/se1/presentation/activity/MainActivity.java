package co.edu.unal.se1.presentation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import co.edu.unal.se1.R;
import co.edu.unal.se1.businessLogic.controller.CountController;
import co.edu.unal.se1.businessLogic.controller.UserController;
import co.edu.unal.se1.dataAccess.model.User;
import co.edu.unal.se1.dataAccess.model.Count;
import co.edu.unal.se1.dataAccess.repository.UserRepository;
import co.edu.unal.se1.dataAccess.repository.CountRepository;

public class MainActivity extends AppCompatActivity {

    private UserController userController;
    private CountController countController;
    private CountRepository countRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextInputEditText idInput = findViewById(R.id.id);
        final TextInputEditText nameInput = findViewById(R.id.name);
        final TextInputEditText mailInput = findViewById(R.id.mail);
        final TextInputEditText passwordInput = findViewById(R.id.password);
        final TextInputEditText balanceInput = findViewById(R.id.balance);

        Button createButton = findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();
                Count count = new Count();
                user.setId(Integer.parseInt(idInput.getText().toString()));
                user.setName(nameInput.getText().toString());
                user.setMail(mailInput.getText().toString());
                user.setPassword(passwordInput.getText().toString());
                count.setId_c(countRepository.getMaxCountId()+1);
                count.setIdUser(user.getId());
                count.setBalance(Double.parseDouble(balanceInput.getText().toString()));

                userController = new UserController();
                userController.createUser(user, getApplicationContext());
                countController = new CountController();
                countController.createCount(count, getApplicationContext());
            }
        });

        final TextView sourceIdInput = findViewById(R.id.sourceId);
        final TextView targetIdInput = findViewById(R.id.targetId);
        final TextView valueInput = findViewById(R.id.value);

        Button sendMoneyButton = findViewById(R.id.sendMoneyButton);
        sendMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int sourceId = Integer.parseInt(sourceIdInput.getText().toString());
                int targetId = Integer.parseInt(targetIdInput.getText().toString());
                double value = Double.parseDouble(valueInput.getText().toString());

                boolean transaction = userController.sendMoney(sourceId, targetId, value, getApplicationContext());

                if (transaction) {
                    System.out.println("¡Transacción satisfactoria!");
                } else {
                    System.out.println("¡Transacción no satisfactoria!");
                }
            }
        });
    }
}