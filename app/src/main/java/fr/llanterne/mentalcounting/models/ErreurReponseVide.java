package fr.llanterne.mentalcounting.models;

public class ErreurReponseVide extends Exception {

    public ErreurReponseVide(String message) {
        super(message);
    }

    public ErreurReponseVide(String message, Throwable innerException) {
        super(message, innerException);
    }
//Faire apparaître le message d'erreur sur la page activity_game.xml
}