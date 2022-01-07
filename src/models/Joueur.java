package models;

import enums.Race;

public class Joueur extends Personnage {
    private int victoire;
    private int defaite;

    public Joueur() {
    }

    public Joueur(int id, String name, Race race, Classe classe, double pv, double pm, double lv, int victoire, int defaite) {
        super(id, name, race, classe, pv, pm, lv);
        this.victoire = victoire;
        this.defaite = defaite;
    }

    public int getVictoire() {
        return victoire;
    }

    public void setVictoire(int victoire) {
        this.victoire = victoire;
    }

    public int getDefaite() {
        return defaite;
    }

    public void setDefaite(int defaite) {
        this.defaite = defaite;
    }

    public double getRatio()
    {
        return this.victoire / (this.defaite+this.victoire);
    }

    @Override
    public String toString() {
        return String.join("\n",this.getName(),this.getRace().toString(),
                this.getClasse().getLibelle(),"mana : "+this.getPm(),"pv : "+this.getPv(),"niveau : "+this.getLv());
    }
}
