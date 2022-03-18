package fr.llanterne.mentalcounting.services;

import fr.llanterne.mentalcounting.models.ErreurReponse;
import fr.llanterne.mentalcounting.models.ErreurReponseVide;

public class VerificationService {

        private int resultatCorrect;//vrai résultat

        public void Verification(int resultat, int res) throws ErreurReponse, ErreurReponseVide {
            resultatCorrect = res;
            if (resultatCorrect == resultat) {//l'utilisateur a bon
                return;
            }
            else//l'utilisateur a faux
            {
                if (resultat == -11)//resultat vide car impossible d'aller à + de -10 (0-10 max)
                    throw new ErreurReponseVide("Entrer un resultat");// (ou mettre le bouton valider en enable)
                else//resultat incorrect
                    throw new ErreurReponse("Raté : XX");// XX = res
            }
        }

        public int getResultatCorrect() {
            return resultatCorrect;
        }

}

