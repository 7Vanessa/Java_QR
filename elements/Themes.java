/**
 * @author Vanessa MOHAMMEDI
 * @author Kévin HUY
 * @author Thushanthy THEIVENDIRAN
 * @author Lionel NGNINTEDEM
 *
 * Projet Questions Réponses
 *
 * Classe Themes : Cette classe permet de définir un objet Themes
 * qui est une liste de thèmes servant dans les phases.
 *
 * Avec méthodes permettant de selectionner des thèmes dans cette liste.
 */

package elements;

import java.util.*;

public class Themes {

    private List<Theme> themes;

    /**
     * Constructeur de Themes :
     * Initialise une liste de thèmes
     */
    public Themes() {
        themes = new ArrayList<>();
    }

    /**
     * Permet d'ajouter un thème à la liste de thèmes
     * @param theme correspond au thème à ajouter à la liste
     * Pas de @return car cette méthode modifie juste l'attribut questions
     */
    public void addTheme(Theme theme) {
        themes.add(theme);
    }

    /**
     * Selection d'un theme
     * @param theme correspond au theme specifique que l'on veut recuperer
     * @return un entier correspondant soit à l'indice du thème selectionné,
     * soit -1 si le thème n'est pas présent dans la liste
     */
    public int selectTheme(Theme theme) {
        for(int i = 0 ; i < themes.size() ; i++) {
            if(themes.get(i).equals(theme))
                return i;
        }
        System.out.println("Erreur : ce theme n'appartient pas a la liste");
        return -1;
    }

    /**
     * Selection de n themes parmis tous les themes de la banque
     * @param nbThemes correspond au nombre de themes à selectionné
     * @return la liste des n themes choisis au hasard
     */
    public List<Theme> selectNThemes(int nbThemes) {
        List<Theme> themesChoisis = new ArrayList<>();
        int rand;

        while(themesChoisis.size() < nbThemes) { // selection N themes
            rand = (int) Math.floor(Math.random() * themes.size()); // indice theme choisi aleatoirement
            // s'il ne le contient pas, l'ajoute
            if(!themesChoisis.contains(themes.get(rand))) {
                themesChoisis.add(themes.get(rand));
            }
        }
        return themesChoisis;
    }

    /**
     * Getter de themes
     * @return l'attribut themes de Themes correspondant à la liste des thèmes
     */
    public List<Theme> getThemes() {
        return themes;
    }

    /**
     * Méthode toString
     * @return une représentation textuelle d'un objet Themes
     */
    @Override
    public String toString() {
        String str = "";
        for(Theme theme : themes) {
            str += theme.getNom() + '\n';
        }
        return str;
    }
}
