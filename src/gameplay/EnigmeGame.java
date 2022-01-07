package gameplay;

import interfaces.Images.GraphicTools;
import models.Personnage;

import java.util.Random;
import java.util.Scanner;

public class EnigmeGame {
   public static void playEnigme () {
       // Répond à l'énigme du squelette et gagne jusqu'à 50 points de vie
       // Tu ne peux en perdre que 15, c'est quand même un bon deal

        //Data
        Random r = new Random();
        int essai = 0;
        int agePNJ = r.nextInt(200);
        int response = 0;
        System.out.println("");
        System.out.println("Bonjour jeune survivant.e");
        System.out.println("");
        //V1Text
        //System.out.println("Si tu veux traverser le pont, tu devras deviner mon âge..");

        //V2Graphique
        GraphicTools.imgSkullOnly();
        System.out.println("Devines quel est mon âge ?");
       while (agePNJ != response){
            //Demander age du personnage et retravailler fonction pour 0 -> Age hero + age mini PNJ et 200
            System.out.println("(Entrez un age entre 0 et 200) :");
            Scanner scanResponse = new Scanner(System.in);
            response = scanResponse.nextInt();

            if(response > agePNJ){
                System.out.println("C'est moins.");
            } else if(response < agePNJ) {
                System.out.println("C'est plus.");
            }
            essai++;

        }
        // Laisser passer ) plus de x essai, possion 10 point mons 105 essai, potion 30 points moins de 5 essai
        System.out.println("Bravo! Comme tu l'as deviné, j'ai bien " + agePNJ + " an(s)" );
        System.out.println("En " + essai + " essais ");
        // Parole laisser passer + récompenses attributs ou objets héro

    }
}
