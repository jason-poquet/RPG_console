package gameplay.combat;

import enums.AttackType;
import enums.Race;
import interfaces.Images.GraphicTools;
import models.Adversaire;
import models.Attaque;
import models.Joueur;
import models.Personnage;

import java.util.Scanner;

public class Combat {

    static Scanner sc = new Scanner(System.in);
    static boolean fuite = false;
    public static void launchCombat(Joueur j1, Adversaire a1)
    {
        System.out.println("Préparez-vous à combattre !");
        System.out.println("                                  " + a1.getName() + "["+a1.getRace()+"] veut se battre !");

        while (j1.getPv() > 0 && a1.getPv() > 0 && !fuite)
        {
            System.out.println("Points de vie "+j1.getName()+" : "+j1.getPv());
            System.out.println("Point de mana "+j1.getName()+" : "+j1.getPm());
            System.out.println("");
            System.out.println("                                  Points de vie "+a1.getName()+" : "+a1.getPv());
            System.out.println("                                  Point de mana "+a1.getName()+" : "+a1.getPm());
            playerRound(j1,a1);
            if(a1.getPv() >= 0)
            {
                adversaireRound(j1,a1);
            }
        }
        finCombat(j1,a1);


    }

    public static void finCombat(Joueur j1, Adversaire a1)
    {
        if(j1.getPv() <= 0)
        {
            j1.setDefaite(j1.getDefaite()+1);
            System.out.println("GAME OVER ---- vous êtes mort");
            GraphicTools.gameOver();
        }
        else{
            j1.setVictoire(j1.getVictoire() + 1);
            System.out.println("VICTOIRE ---- vous avez vaincu "+a1.getName());
            j1.setLv(j1.getLv() + 1);
        }
        System.out.println("Vous avez " + j1.getVictoire() + "victoire(s)");
        System.out.println("Vous avez " + j1.getDefaite() + "défaite(s)");
        System.out.println("Ratio V/D : "+j1.getRatio());
    }
    public static void finCombatFuite(Joueur j1, Adversaire a1)
    {
        int noChance = (int)(Math.random() * 10);
        if(noChance > 8)
        {
            System.out.println("La peur vous empêche de fuir");
        }
        else{
            System.out.println("Vous avez fui ! Vous ne méritez pas de représenter la tribut "+j1.getClasse().getLibelle());
            j1.setLv(j1.getLv() - 1);
            j1.setDefaite(j1.getDefaite() - 1);
            fuite = true;
        }

    }

    public static void launchAttaque(Attaque atk, Personnage target, Personnage launcher)
    {
        System.out.println(atk.getLibelleAttaque() + "  attention ça va faire mal");
        if(launcher.getPm() >= atk.getCoutMana())
        {
            double damage = atk.getPuissance() * calcFaiblesse(target,atk);
            double newPM = launcher.getPm() - atk.getCoutMana();
            double newPV = target.getPv() - damage;
            target.setPm(newPM);
            target.setPv(newPV);
            System.out.println(target.getName() + "touché");
            System.out.println(target.getName() + " subit " + atk.getPuissance());
            System.out.println();
        }
        else{
            System.out.println("Pas assez de mana, cible manquée");
        }

    }
    public static double calcFaiblesse(Personnage p1, Attaque atk)
    {
        double faiblesse = 1;
        switch (p1.getRace()){
            case HUMAIN :
                if(atk.getType() == AttackType.TENEBRE)
                {
                    System.out.println("Coup critique !!!!");
                    faiblesse = 1.2;
                }
                break;
            case VAMPIRE :
                if(atk.getType() == AttackType.VENT)
                {
                    System.out.println("Coup critique !!!!");
                    faiblesse = 2;
                }
         };
        return faiblesse;
    }

    public static void adversaireRound(Joueur j1,Adversaire a1)
    {
        int nbAtk = a1.getClasse().getLstAtk().size();
        int selAtk = (int)(Math.random() * nbAtk);
        launchAttaque(a1.getClasse().getLstAtk().get(selAtk),j1,a1);
    }
    public static void playerRound(Joueur j1, Adversaire a1)
    {
        System.out.println("Liste des attaques :");
        int index = 0;
        System.out.println("100 : fuir comme un lâche");
        for (Attaque at : j1.getClasse().getLstAtk()) {
            System.out.println(j1.getClasse().getLstAtk().indexOf(at)+" "+at.getLibelleAttaque());
        }
        int chAtk = sc.nextInt();
        while(chAtk > j1.getClasse().getLstAtk().size() && chAtk < j1.getClasse().getLstAtk().size() && chAtk != 100){
            chAtk = sc.nextInt();
        }
        if(chAtk == 100)
        {
            finCombatFuite(j1,a1);
        }
        launchAttaque(j1.getClasse().getLstAtk().get(chAtk),a1,j1);

    }
}
