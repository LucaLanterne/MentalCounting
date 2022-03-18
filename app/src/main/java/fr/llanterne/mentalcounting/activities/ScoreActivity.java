package fr.llanterne.mentalcounting.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import fr.llanterne.mentalcounting.R;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Button button = findViewById(R.id.previous_scoreButton);
        button.setOnClickListener(view -> goToPreviousActivity());
    }

    private void goToPreviousActivity() {
        finish();
    }
}

