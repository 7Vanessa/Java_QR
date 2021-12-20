/**
 * @author Vanessa MOHAMMEDI
 * @author Kévin HUY
 * @author Thushanthy THEIVENDIRAN
 * @author Lionel NGNINTEDEM
 *
 * Projet Questions Réponses
 *
 * Classe Joueur : Création de la classe Joueur composé de
 * son numéro, son nom, son état et d'un dictionnaire contenant
 * l'ensemble des états possibles.
 * + méthode toString et getters sur les attributs
 *
 */

package elements;

import java.util.HashMap;
import java.util.Map;

public class Joueur {

    private static int compteur = 100;
    private final String nom;
    private final int numero;
    private int score = 0;

    // Dictionnaire avec : cle = nom simplifie de l'etat, valeur = nom de l'etat
    // Utilite : rends plus simple l'acces des etats
    private final Map<String, String> etats;
    private String etat;

    // Compteur pour le nom
    private static int compteurNom = 0;

    /**
     * Constructeur de Joueur :
     * Initialise la map contenant les differents états
     * du joueur au fil de la partie et ajoute ces états à la map etats.
     * Attribut l'état "En attente" au joueur lors de sa création.
     * Affecte un nom au joueur lors de sa création
     */
    public Joueur() {
        this.numero = compteur;
        compteur = compteur + 10;
        nom = "" + (char)('A' + compteurNom);
        compteurNom++;
        etats = new HashMap<>();
        etats.put("s", "Sélectionné");
        etats.put("g", "Gagnant");
        etats.put("sg", "Super Gagnant");
        etats.put("e", "Eliminé");
        etats.put("a", "En attente");
        etat = etats.get("a");
    }

    /**
     * Permet de mettre à jour le score du joueur en fonction de la phase
     * @param nomPhase nom de la phase en cours
     * Pas de @return car cette méthode permet de modifier l'attribut score du joueur
     */
    public void updateScore(String nomPhase) {
        switch (nomPhase) {
            case "PhaseI" -> score += 2;
            case "PhaseII" -> score += 3;
            case "PhaseIII" -> score += 5;
        }
    }

    /**
     * Permet de mettre à jour l'etat du joueur
     * @param etat nouvel état du joueur
     * Pas de @return car cette méthode permet de modifier l'attribut etat du joueur
     */
    public void updateEtat(String etat) {
        this.etat = etats.get(etat);
    }

    /**
     * Getter de score
     * @return l'attribut score du joueur
     */
    public int getScore() {
        return score;
    }

    /**
     * Getter de etat
     * @return l'attribut etat du joueur
     */
    public String getEtat() {
        return etat;
    }

    /**
     * Getter de nom
     * @return l'attribut nom du joueur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de numero
     * @return l'attribut numero du joueur
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Setter de compteurNom
     * @param nouveauCompteur modifie l'attribut compteurNom du joueur
     * Pas de @return pour un setter, modifie juste l'attribut compteurNom
     */
    public void setCompteurNom(int nouveauCompteur) {
        compteurNom = nouveauCompteur;
    }

    /**
     * Setter de compteur
     * @param nouveauCompteur modifie l'attribut compteur du joueur
     * Pas de @return pour un setter, modifie juste l'attribut compteur
     */
    public void setCompteur(int nouveauCompteur) {
        compteur = nouveauCompteur;
    }

    /**
     * Méthode toString
     * @return une représentation textuelle d'un objet joueur
     */
    @Override
    public String toString() {
        return "Joueur " + nom + "  n°" + numero + "  Score : " + score + "  Etat : " + etat;
    }
}
