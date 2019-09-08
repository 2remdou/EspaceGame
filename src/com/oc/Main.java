package com.oc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    static final Properties config = new Properties();
    public static void main(String[] args) {
        lectureConfig();
        try {
            int nbreChiffres = Integer.parseInt(config.getProperty("NBRE_CHIFFRES"));
            boolean modeDev = Boolean.parseBoolean(config.getProperty("MODE_DEV"));
            int nbreEssais = Integer.parseInt(config.getProperty("NBRE_ESSAIS"));
            int mode = choixMode();
            EscapeGame escapeGame = new EscapeGame(mode,nbreChiffres,nbreEssais,modeDev);
            escapeGame.start();
            boolean continuer = true;
            do{
                String[] options = {"Rejouer au même mode","Lancer un autre mode","Quitter"};
                int choix = Utilitaire.poserQuestion(options, "Choisissez une option");
                switch (choix){
                    case 1:
                        escapeGame.start();
                        break;
                    case 2:
                        mode = choixMode();
                        escapeGame.setMode(mode);
                        escapeGame.start();
                        break;
                    case 3:
                        continuer = false;
                        break;
                }
            }while (continuer);
        }catch (NumberFormatException e){
            System.out.println("Format configuration incorrect");
        }
    }
    private static int choixMode(){
        String[] modes = {"Challenger", "Défense", "Duel"};
        int mode = Utilitaire.poserQuestion(modes, "Choisissez un mode");
        return mode;
    }
    private static void lectureConfig(){
        try {
            config.load(new FileInputStream("espaceGame.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
