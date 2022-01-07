package main;

import enums.AttackType;
import enums.Race;
import gameplay.EnigmeGame;
import interfaces.Images.GraphicTools;
import models.Adversaire;
import models.Attaque;
import models.Classe;
import models.Joueur;
import gameplay.combat.Combat;
import setup.Setup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Classe> lstClasses= Setup.setupClasses();
        Scanner sc =new Scanner(System.in);
        System.out.println("**************************************************************");
        System.out.println("==============================================================");
        System.out.println("|                         RPG  CONSOLE                       |");
        GraphicTools.drawWolf();
        System.out.println("==============================================================");
        System.out.println("|                     Création du personnage                 |");
        System.out.println("==============================================================");
        System.out.println("|            Entrez un nom pour votre personnage :           |");
        String name = sc.nextLine();
        Race[] races = Race.values();
        int raceId = -1;
        while(raceId<0 || raceId> races.length-1 ) {
            System.out.println("|   Sélectionner une race pour votre personnage(0 - "+(races.length-1)+")  :|");
            for(Race r : races){
                System.out.print(r.ordinal() + " : " + r + "\t\t" );
                System.out.println();
            }
            raceId = sc.nextInt();
        }

        int i = 0;
        while(i < races.length-1 &&  races[i].ordinal() != raceId ){
            i++;
        }

        Race race = races[i];
        int classeId = -1;
        while (classeId < 0 || classeId > lstClasses.size() - 1 ){
            System.out.println("| Sélectionner une classe pour votre personnage : |");
            for (Classe c : lstClasses){
                System.out.println(lstClasses.indexOf(c)+ " " + c.getLibelle());
            }
            classeId = sc.nextInt();
        }
         Classe classe= lstClasses.get(classeId);
        

        Joueur j1 = new Joueur(1, name, race, classe, 100, 100, 1, 0, 0);

        System.out.println("Votre joueur : " + j1.toString());
        System.out.println();
        System.out.println(j1.getName()+ " était en train de se promener dans les bois quand soudain un adversaire apparaît !");

        //EnigmeGame.playEnigme();
        Classe advClass = new Classe("Démon");
        Attaque sortInutile= new Attaque("Trempette",5,30,AttackType.TENEBRE);
        Attaque sortPuissance= new Attaque("Boule de la mort qui tue",80,50,AttackType.TENEBRE);
        Attaque attaque= new Attaque("Coup d'épée",30,5,AttackType.TENEBRE);
        advClass.addAttack(sortInutile);
        advClass.addAttack(sortPuissance);
        advClass.addAttack(attaque);

        Race raceR = Race.values()[(int)(Math.random()*Race.values().length)];
        Adversaire a1 = new Adversaire(2,"MagiMon",raceR,advClass,100,100,2);
        Combat.launchCombat(j1,a1);
    }
}
