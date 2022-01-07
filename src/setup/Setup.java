package setup;

import enums.AttackType;
import models.Adversaire;
import models.Attaque;
import models.Classe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Setup {

    public static List<Classe> setupClasses(){
        Attaque attaqueBasique=new Attaque("Attaque de base",5,0,AttackType.TENEBRE);
        List<Classe> classeList= new ArrayList<>();
        Classe magicien= new Classe("Magicien élémentaliste");
        magicien.setLstAtk(new ArrayList<>(Arrays.asList(
                new Attaque("Sort de feu",20,10,AttackType.FEU),
                new Attaque("Rayon de givre",20,10,AttackType.GLACE),
                new Attaque("Aspersion acide",40,15,AttackType.TERRE),
                attaqueBasique
        )
        ));
        Classe chevalier= new Classe("Chevalier");
        chevalier.setLstAtk(new ArrayList<>(Arrays.asList(
                new Attaque("Attaque à épée ",40,10,AttackType.TERRE),
                new Attaque("Coup de bouclier",30,15,AttackType.TERRE),
                attaqueBasique
        )
        ));
        Classe archer = new Classe("Archer");
        archer.setLstAtk(new ArrayList<>(Arrays.asList(
                new Attaque("Flèche maudite",70,30,AttackType.TERRE),
                new Attaque("Pluie de flèches",40,15,AttackType.TERRE),
                attaqueBasique
        )
        ));
        Classe bouffon = new Classe("Bouffon");
        bouffon.setLstAtk(new ArrayList<>(Arrays.asList(
                new Attaque("Taquinerie",30,20,AttackType.TERRE),
                new Attaque("Jonglage",20,15,AttackType.TERRE),
                attaqueBasique
        )
        ));
        classeList.add(magicien);
        classeList.add(chevalier);
        classeList.add(archer);
        classeList.add(bouffon);
        return classeList;
    }

    /*public static Adversaire generateAdversaire(){

    }*/
}
