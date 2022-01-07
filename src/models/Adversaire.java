package models;

import enums.Race;

import java.util.List;
import java.util.Random;

public class Adversaire extends Personnage{
    public Adversaire(int id, String name, Race race, Classe classe, double pv, double pm, double lv) {
        super(id, name, race, classe, pv, pm, lv);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
