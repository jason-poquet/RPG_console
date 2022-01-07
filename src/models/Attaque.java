package models;

import enums.AttackType;

public class Attaque {
    private String libelleAttaque;
    private double puissance;
    private double coutMana;
    private AttackType type;

    public Attaque(){

    }
    public Attaque(String libelleAttaque,double puissance,double coutMana,AttackType type){
        this.libelleAttaque=libelleAttaque;
        this.puissance=puissance;
        this.coutMana=coutMana;
        this.type=type;
    }

    public String getLibelleAttaque() {
        return libelleAttaque;
    }

    public void setLibelleAttaque(String libelleAttaque) {
        this.libelleAttaque = libelleAttaque;
    }

    public double getPuissance() {
        return puissance;
    }

    public void setPuissance(double puissance) {
        this.puissance = puissance;
    }

    public double getCoutMana() {
        return coutMana;
    }

    public void setCoutMana(double coutMana) {
        this.coutMana = coutMana;
    }

    public AttackType getType() {
        return type;
    }

    public void setType(AttackType type) {
        this.type = type;
    }
}
