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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("********************************************");
        System.out.println("==================================================");
        System.out.println("|                  RPG CONSOLE                    |");
        GraphicTools.drawWolf();
        System.out.println("==================================================");
        System.out.println("|            Création du personnage               |");
        System.out.println("==================================================");
        System.out.println("|       Entrez un nom pour votre personnage :     |");
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
        System.out.println("| Sélectionner une classe pour votre personnage : |");


        Classe enchanteur = new Classe("Enchanteur");
        Attaque sortDeFeu = new Attaque("Sort de Feu", 50.0, 15.0, AttackType.FEU);
        enchanteur.addAttack(sortDeFeu);
        Joueur j1 = new Joueur(1, name, race, enchanteur, 100, 25.2, 1, 0, 0);
        for(Attaque a : j1.getClasse().getLstAtk()){
            System.out.println(a.getLibelleAttaque());
        }
        System.out.println(j1.toString());

        //EnigmeGame.playEnigme();
        Classe advClass = new Classe("Démon");
        Attaque sortInutile= new Attaque("Trempette",5,30,AttackType.TENEBRE);
        advClass.addAttack(sortInutile);
        Adversaire a1 = new Adversaire(2,"MagiMon",Race.GNOME,advClass,55,30,2);
        Combat.launchCombat(j1,a1);
    }
}
