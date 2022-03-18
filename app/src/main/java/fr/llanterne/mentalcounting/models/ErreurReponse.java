package fr.llanterne.mentalcounting.models;

public class ErreurReponse extends Exception {

    public ErreurReponse(String message) {
        super(message);
    }

    public ErreurReponse(String message, Throwable innerException) {
        super(message, innerException);
    }
//Faire apparaître le message d'erreur sur la page activity_game.xml
}