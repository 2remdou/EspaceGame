package com.oc;

import java.util.Random;

public class Joueur {
    private Boolean ia; // intelligence artificielle
    private long combinaison;

    public Joueur() {
        this.ia = true;
        combinaison = Math.round(Math.random()*1000);
    }

    public Joueur(int combinaison){
        this.combinaison = combinaison;
        this.ia = false;
    }

    public Boolean getIa() {
        return ia;
    }

    public long getCombinaison() {
        return combinaison;
    }

    public void setCombinaison(int combinaison) {
        this.combinaison = combinaison;
    }
}
