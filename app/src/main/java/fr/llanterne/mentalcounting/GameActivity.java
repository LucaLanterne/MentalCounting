package fr.llanterne.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button home_gameButton = findViewById(R.id.home_gameButton);
        Button score_gameButton = findViewById(R.id.score_gameButton);

        home_gameButton.setOnClickListener(view -> openMainActivity());
        score_gameButton.setOnClickListener(view -> openScoreActivity());

    }

    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void openScoreActivity() {
        Intent intent = new Intent(this, ScoreActivity.class);
        startActivity(intent);
    }

}