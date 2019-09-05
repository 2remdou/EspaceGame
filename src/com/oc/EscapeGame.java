package com.oc;

public class EscapeGame {
    private String[] modes = {"Challenger","Défenseur","Duel"};

    public void start(){
        Utilitaire.poserQuestion(modes,"Choisissez un mode");
    }
}
