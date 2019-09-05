package com.oc;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Utilitaire {
    static Scanner sc = new Scanner(System.in);

    /**
     * Afficher une liste de choix
     * @param choix la liste des choix
     * @param message le message à afficher
     * @return le choix
     */
    public static int poserQuestion(String[] choix,String message){

        String texte = "";
        System.out.println(message);
        for(int i=0;i<=choix.length-1;i++){
            System.out.println((i+1)+" - "+ choix[i]);
        }
        System.out.println("Veuillez choisir :");
        return getIntInput(1,choix.length);
    }

    /**
     *
     * @param min la valeur minimale
     * @param max la valeur maximal
     * @return la saisie
     */
    public static int getIntInput(int min,int max){
        int input = -1;
        boolean isNotValid = false;
        do {
            try {
                if (!sc.hasNext()){sc = new Scanner(System.in);}
                input = sc.nextInt();
                isNotValid = (input<min || input>max);
            }catch (InputMismatchException e){
                isNotValid = true;
                sc.next();
            }
            if(isNotValid) {
                System.out.println("Veuillez recommencez, la saisie est incorrecte");
            }
        }while (isNotValid);
        return input;
    }

    /**
     *
     * @param nbreChiffres nombre de chiffres de la combinaison
     * @return la combinaison
     */
    public static int generationCombinaison(int nbreChiffres){
        String min = "";
        String max = "";
        for(int i=1;i<=nbreChiffres;i++) {
            min +="1";
            max +="9";
        }
        Random random = new Random();
        int nb = Integer.parseInt(min)+random.nextInt(Integer.parseInt(max)-Integer.parseInt(min));
        return  nb;
    }
}