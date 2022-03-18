package fr.llanterne.mentalcounting.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import fr.llanterne.mentalcounting.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play_homeButton = findViewById(R.id.play_homeButton);
        Button score_homeButton = findViewById(R.id.score_homeButton);

        play_homeButton.setOnClickListener(view -> openGameActivity());
        score_homeButton.setOnClickListener(view -> openScoreActivity());

    }

    private void openGameActivity() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    private void openScoreActivity() {
        Intent intent = new Intent(this, ScoreActivity.class);
        startActivity(intent);
    }

}