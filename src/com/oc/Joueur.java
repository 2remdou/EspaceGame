package com.oc;

import java.util.Random;

public class Joueur {
    private int combinaison;
    private int proposition;

    public Joueur(){ }

    public Joueur(int combinaison){
        this.combinaison = combinaison;
    }

    public String defense(Joueur attaquant){
        String reponse = "";

        for(int i=0;i<Integer.toString(this.combinaison).length();i++){
            if(Integer.toString(this.combinaison).charAt(i)==Integer.toString(attaquant.getProposition()).charAt(i)) reponse+="=";
            else if(Integer.toString(this.combinaison).charAt(i)<Integer.toString(attaquant.getProposition()).charAt(i)) reponse+="-";
            else reponse+="+";
        }
        return reponse;
    }

    public int getCombinaison() {
        return combinaison;
    }

    public void setCombinaison(int combinaison) {
        this.combinaison = combinaison;
    }

    public int getProposition() {
        return proposition;
    }

    public void setProposition(int proposition) {
        this.proposition = proposition;
    }
}
