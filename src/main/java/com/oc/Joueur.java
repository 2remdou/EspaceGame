package com.oc;

import java.util.ArrayList;
import java.util.Random;

public class Joueur {
    private int combinaison;
    private ArrayList<Integer> proposition = new ArrayList<Integer>();

    public Joueur(){ }

    public Joueur(int combinaison){
        Logger.info("Creation d'un joueur avec "+combinaison+" comme combinaison");
        this.combinaison = combinaison;
    }

    /**
     * Analyse la proposition d'un attaquant
     * @param proposition la proposition de l'attaquant
     * @return le resultat ++-=
     */
    public String recevoirPropostion(int proposition){
        String reponse = "";
        for(int i=0;i<Integer.toString(this.combinaison).length();i++){
            if(Integer.toString(this.combinaison).charAt(i)==Integer.toString(proposition).charAt(i)) reponse+="=";
            else if(Integer.toString(this.combinaison).charAt(i)<Integer.toString(proposition).charAt(i)) reponse+="-";
            else reponse+="+";
        }
        return reponse;
    }

    /**
     *
     * @param nbreChiffres le nombre de chiffre de la proposition
     * @param reponsePrecedente la reponse precedente format(+-=+)
     * @return une proposition de nbreChiffres
     */
    public int faireProposition(int nbreChiffres,String reponsePrecedente){
        String proposition = "";
        if(this.proposition.size()==0 || reponsePrecedente==null){
            return Utilitaire.generationCombinaison(nbreChiffres);
        }
        int propositionPrecedente = this.proposition.get(this.proposition.size()-1);
        for (int i=0;i<reponsePrecedente.length();i++){
            if(reponsePrecedente.charAt(i)=="=".charAt(0)) proposition += Integer.toString(propositionPrecedente).charAt(i);
            else if(reponsePrecedente.charAt(i)=="-".charAt(0)){
                proposition += Utilitaire.generationNbreAletoire(1,Utilitaire.getChiffreWithIndex(propositionPrecedente,i));
            }else{
                proposition += Utilitaire.generationNbreAletoire(Utilitaire.getChiffreWithIndex(propositionPrecedente,i),9);
            }
        }
        return Integer.parseInt(proposition);
    }

    public int getCombinaison() {
        return combinaison;
    }

    public void setCombinaison(int combinaison) {
        this.combinaison = combinaison;
    }

    public ArrayList<Integer> getProposition() {
        return proposition;
    }

    public void setProposition(ArrayList<Integer> proposition) {
        this.proposition = proposition;
    }

}
