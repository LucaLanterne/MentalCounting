package fr.llanterne.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Button home_scoreButton = findViewById(R.id.home_scoreButton);
        Button game_scoreButton = findViewById(R.id.game_scoreButton);

        home_scoreButton.setOnClickListener(view -> openMainActivity());
        game_scoreButton.setOnClickListener(view -> openGameActivity());

    }

    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void openGameActivity() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}