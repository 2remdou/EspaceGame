package com.oc;

public class EscapeGame {
    private int mode;

    public int getMode() {
        return mode;
    }

    /**
     *
     * @param mode le mode [1- Challenger,2- Défense, 3- Duel]
     */
    public EscapeGame(int mode){
        if(mode<1 || mode>3) throw new MauvaisModeGameException();
    }

    public void start(){

    }

    /*public Joueur creationJoueurHumain(int combinaison){
        long combinaire
    }*/
}
