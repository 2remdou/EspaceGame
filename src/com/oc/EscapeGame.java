package com.oc;

public class EscapeGame {
    private int mode;
    private int nbreChiffres;
    private int min;
    private int max;
    /**
     *
     * @param mode le mode [1- Challenger,2- Défense, 3- Duel]
     */
    public EscapeGame(int mode,int nbreChiffres){
        if(mode<1 || mode>3) throw new MauvaisModeGameException();
        this.mode = mode;
        this.nbreChiffres = nbreChiffres;
        int [] borne = Utilitaire.getBorne(nbreChiffres);
        this.min = borne[0];
        this.max = borne[1];
    }

    public int getMode() {
        return mode;
    }


    public void startModeChallenger(){
        int combinaison = Utilitaire.generationCombinaison(this.nbreChiffres);
        int proposition;
        Joueur defenseur = new Joueur(combinaison);
        Joueur attaquant = new Joueur();
        do{
            System.out.print("Propostion : ");
            proposition = Utilitaire.getIntInput(this.min,this.max);
            attaquant.getProposition().add(proposition);
            String res = defenseur.recevoirPropostion(proposition);
            System.out.println("Réponse : "+res);
        }while (defenseur.getCombinaison()!=proposition);
    }

    public void startModeDefense(){
        System.out.println("Donner une combinaison de "+ this.nbreChiffres +" chiffres");
        int combinaison = Utilitaire.getIntInput(this.min,this.max);
        Joueur defenseur = new Joueur(combinaison);
        Joueur attaquant = new Joueur();
        String reponse=null;
        int i = 1;
        do{
            int propostion = attaquant.faireProposition(this.nbreChiffres,reponse);
            attaquant.getProposition().add(propostion);
            reponse = defenseur.recevoirPropostion(propostion);
            System.out.println(i++ +" - "+"Propostion "+propostion+" -> Réponse : "+reponse);
        }while (defenseur.getCombinaison()!=attaquant.getProposition().get(attaquant.getProposition().size()-1));
    }

    public void start(){
        Joueur defenseur;
        Joueur attaquant;
        switch (this.mode){
            case 1:
                this.startModeChallenger();
                break;
            case 2:
                this.startModeDefense();
                break;
            case 3:
                break;
        }

    }

    public Joueur creationJoueurHumain(){
        int combinaison = Utilitaire.generationCombinaison(this.nbreChiffres);
        Joueur joueur = new Joueur(combinaison);
        return joueur;
    }

    public Joueur creationJoueurIA(){
        int combinaison = Utilitaire.generationCombinaison(this.nbreChiffres);
        return  new Joueur(combinaison);
    }
}
