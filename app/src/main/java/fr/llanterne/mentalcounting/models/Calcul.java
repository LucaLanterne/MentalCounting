package fr.llanterne.mentalcounting.models;

import fr.llanterne.mentalcounting.services.CalculService;

public class Calcul {

        //Service de création d'une opération
        CalculService operation = new CalculService();
        int valeur1;
        int valeur2;
        String operateur;

        public String GetOperateur(){
            this.operateur = operation.getOperateur();
            return (operateur);
        }

        public int GetValeur1(){
            this.valeur1 = operation.getValeur1();
            return (valeur1);
        }

        public int GetValeur2(){
            this.valeur2 = operation.getValeur2();
            return (valeur2);
        }
}
