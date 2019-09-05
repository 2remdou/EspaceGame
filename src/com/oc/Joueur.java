package com.oc;

public class Joueur {
    private Boolean ia; // intelligence artificielle
    private int combinaison;

    public Joueur(Boolean ia) {
        this.ia = ia;
    }

    public Boolean getIa() {
        return ia;
    }

    public int getCombinaison() {
        return combinaison;
    }

    public void setCombinaison(int combinaison) {
        this.combinaison = combinaison;
    }
}
