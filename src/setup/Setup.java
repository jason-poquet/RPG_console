package setup;

import enums.AttackType;
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
                new Attaque("Rayon de givre",20,10,AttackType.GLACE),
                new Attaque("Aspersion acide",40,15,AttackType.TERRE)
                )
        ));
        return classeList;
    }
}
