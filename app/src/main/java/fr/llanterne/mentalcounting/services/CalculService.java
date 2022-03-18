package fr.llanterne.mentalcounting.services;

import java.util.Random;

public class CalculService {
    //Attributs
    private int valeur1;
    private int valeur2;
    private int res;
    private String operateur;

    //Fonction pour les aléatoires
    public int randomizer(){
        Random random = new Random();
        valeur1 = random.nextInt(11);//Chiffre comprit entre 0 et 20
        valeur2 = random.nextInt(11);
        int operateur = random.nextInt(3);//Chiffre comprit entre 0 et 2
        //Operation(operator);
        switch (operateur){
            case 0:
                this.operateur = "-";
                res = valeur1 - valeur2;
                operateurValide();
                break;
            case 1:
                this.operateur = "+";
                res = valeur1 + valeur2;
                operateurValide();
                break;
            case 2:
                this.operateur = "*";
                res = valeur1 * valeur2;
                operateurValide();
                break;
            default:
                randomizer();
        }
        return res;
    }

    public boolean operateurValide(){
        return true;
    }

    //Accesseurs
    public int getValeur1() {
        return valeur1;
    }

    public int getValeur2() {return valeur2;}

    public String getOperateur() {
        return operateur;
    }
}


