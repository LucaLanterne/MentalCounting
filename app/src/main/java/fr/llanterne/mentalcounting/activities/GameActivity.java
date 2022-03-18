package fr.llanterne.mentalcounting.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fr.llanterne.mentalcounting.R;
import fr.llanterne.mentalcounting.models.ErreurReponse;
import fr.llanterne.mentalcounting.models.ErreurReponseVide;
import fr.llanterne.mentalcounting.services.CalculService;
import fr.llanterne.mentalcounting.services.VerificationService;

public class GameActivity extends AppCompatActivity {

    private int resultat;//vrai résultat
    private EditText responseText;//Ce que l'utilisateur entre
    private TextView calculText;//"calcul :"
    private TextView incorrectText;//"rate: XX"
    private TextView correctText;//"bravo"
    private CharSequence textCalcul;
    private CharSequence textF;

    //Services externes :
    private final CalculService operation = new CalculService();//Service de création d'une opération
    private final VerificationService verification = new VerificationService();//Service de vérification d'un calcul

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);//Dire que c'est le code de activity_game.xml

        correctText = findViewById(R.id.wrong_answer_text);
        incorrectText = findViewById(R.id.good_answer_text);
        responseText = findViewById(R.id.edit_text);//réponse de l'utilisateur
        calculText = findViewById(R.id.calcul_text);


        //Récupération du texte de départ :
        textCalcul = this.calculText.getText();//ce qui est déjà écrit

        //On récupère les valeurs du calcul pour les afficher :
        calcul();

        //On vérifie la réponse de l'utilisateur :
        Button submitMenuButton = findViewById(R.id.submit_button);
        submitMenuButton.setOnClickListener(view -> verification());
        textF = this.incorrectText.getText();//Message : "Rate"

        //Boutton pour une nouvelle operation :
        Button nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(view -> OperationSuivante());


    }

    //Ajoute game_menu à la page gameActivity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.submit_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Ouvre la page home et result
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {



        int id = item.getItemId();

        switch (id){
            case R.id.score_menu_button:
                Intent intent = new Intent(this, ScoreActivity.class);
                startActivity(intent);
                break;
            case R.id.home_menu_button:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("SetTextI18n")
    private void calcul(){
        resultat = operation.randomizer();//génére 2 int et un string

        boolean calcul = operation.operateurValide();//L'opération est correcte : 2 int et un String
        if (calcul) {//Récupération des valeurs de l'opération car elle est correcte
            int valeur1 = operation.getValeur1();
            String operateur = operation.getOperateur();
            int valeur2 = operation.getValeur2();
            String affichage = getString(
                    // le template
                    R.string.operation_template,
                    // les variables qui sont injectées
                    valeur1,
                    operateur,
                    valeur2
            );
            this.calculText.setText(textCalcul + affichage);
        }
    }

    @SuppressLint("SetTextI18n")
    private void verification(){
        try {
            int valeur;
            String value = responseText.getText().toString();
            valeur = Integer.parseInt(value);

            verification.Verification(valeur, resultat);

            // il faut récupérer le composant : c est pas l ID qui change de visibility
            correctText.setVisibility(View.VISIBLE);
            findViewById(R.id.calcul_text);
        } catch ( ErreurReponse erreurReponse) {
            // View.VISIBLE => la valeur qui va t afficher le truc
            incorrectText.setVisibility(View.VISIBLE);//on rend le message visible
            erreurReponse.printStackTrace();
            //Affichage du message d'erreur avec le bon résultat:

            int reponse = verification.getResultatCorrect();//reponse correcte
            String rep = Integer.toString(reponse);
            this.incorrectText.setText(textF+rep);//Affichage
        } catch (ErreurReponseVide erreurReponseVide) {
            erreurReponseVide.printStackTrace();
        }
        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setVisibility(View.INVISIBLE);
    }

    private void OperationSuivante(){
        //On efface les messages précédents :
        correctText.setVisibility(View.INVISIBLE);
        incorrectText.setVisibility(View.INVISIBLE);
        //On change d'operation :
        calcul();
        //On remet le bouton Valider:
        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setVisibility(View.VISIBLE);
    }
}