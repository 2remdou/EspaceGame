package com.oc;

import org.apache.logging.log4j.LogManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    static final Properties config = new Properties();
    static String[] modes = {"Challenger", "Défense", "Duel"};
    public static void main(String[] args) {
        lectureConfig();
        try {
            int nbreChiffres = Integer.parseInt(config.getProperty("NBRE_CHIFFRES"));
            boolean modeDev = Boolean.parseBoolean(config.getProperty("MODE_DEV"));
            int nbreEssais = Integer.parseInt(config.getProperty("NBRE_ESSAIS"));
            int mode = choixMode();
            EscapeGame escapeGame = new EscapeGame(mode,nbreChiffres,nbreEssais,modeDev);
            Logger.info("Nouvelle partie avec "+nbreChiffres+" chiffres "+nbreEssais+" essais en mode "+modes[mode-1]);
            escapeGame.start();
            boolean continuer = true;
            do{
                String[] options = {"Rejouer au même mode","Lancer un autre mode","Quitter"};
                int choix = Utilitaire.poserQuestion(options, "Choisissez une option");
                Logger.info(options[choix-1]);
                switch (choix){
                    case 1:
                        Logger.info(options[choix]);
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
            Logger.error("Format configuration incorrect");
        }
    }
    private static int choixMode(){
        int mode = Utilitaire.poserQuestion(modes, "Choisissez un mode");
        return mode;
    }
    private static void lectureConfig(){
        try {
            Logger.info("Lecture fichier de configuration");
            config.load(new FileInputStream("src/main/resources/espaceGame.properties"));
        } catch (IOException e) {
            Logger.error("Erreur lors de la lecture du fichier de config");
//            e.printStackTrace();
        }
    }

}
