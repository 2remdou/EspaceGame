package com.oc;

public class Main {

    public static void main(String[] args) {
        String[] modes = {"Challenger","Défense","Duel"};
        int mode = Utilitaire.poserQuestion(modes,"Choisissez un mode");
        EscapeGame escapeGame = new EscapeGame(mode,4);
        escapeGame.start();
    }
}
