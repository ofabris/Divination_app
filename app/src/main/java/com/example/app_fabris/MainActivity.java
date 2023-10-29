package com.example.app_fabris;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int numberToGuess;
    private EditText editText;
    private Button button;
    private TextView textView;
    private int attempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        initializeGame();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess();
            }
        });
    }

    private void initializeGame() {
        Random random = new Random();
        numberToGuess = random.nextInt(100) + 1;
        attempts = 0;
    }

    private void checkGuess() {
        String input = editText.getText().toString();
        if (!input.isEmpty()) {
            int userGuess = Integer.parseInt(input);
            attempts++;

            if (userGuess == numberToGuess) {
                Toast.makeText(MainActivity.this, "Parabéns! Você adivinhou o número em " + attempts + " tentativas!", Toast.LENGTH_LONG).show();
                initializeGame();
            } else if (userGuess < numberToGuess) {
                Toast.makeText(MainActivity.this, "Tente um número maior", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Tente um número menor", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Por favor, coloque um numero", Toast.LENGTH_SHORT).show();
        }
    }
}