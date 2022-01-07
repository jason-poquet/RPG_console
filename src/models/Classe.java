package models;

import java.util.ArrayList;
import java.util.List;

public class Classe {
    private String libelle;
    private List<Attaque> lstAtk;

    public Classe()
    {
        this.lstAtk = new ArrayList<>();
    }
    public Classe(String lib )
    {
        this.libelle = lib;
        this.lstAtk = new ArrayList<>();
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Attaque> getLstAtk() {
        return lstAtk;
    }

    public void setLstAtk(List<Attaque> lstAtk) {
        this.lstAtk = lstAtk;
    }
    public void addAttack(Attaque attaque){
        if (this.lstAtk == null){
            this.lstAtk = new ArrayList<>();
        }
        this.lstAtk.add(attaque);
    }
}
