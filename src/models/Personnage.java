package models;

import enums.Race;

import java.io.Serializable;

public abstract class Personnage implements Serializable {
    private int id;
    private String name;
    private Race race;
    private Classe classe;
    private double pv;
    private double pm; //Point de Mana ou point d'attaque
    private double lv;

    public Personnage() {
    }

    public Personnage(int id, String name, Race race, Classe classe, double pv, double pm, double lv) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.classe = classe;
        this.pv = pv;
        this.pm = pm;
        this.lv = lv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public double getPv() {
        return pv;
    }

    public void setPv(double pv) {
        this.pv = pv;
    }

    public double getPm() {
        return pm;
    }

    public void setPm(double pm) {
        this.pm = pm;
    }

    public double getLv() {
        return lv;
    }

    public void setLv(double lv) {
        this.lv = lv;
    }
}
