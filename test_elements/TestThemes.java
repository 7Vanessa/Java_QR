/**
 * @author Vanessa MOHAMMEDI
 * @author Kévin HUY
 * @author Thushanthy THEIVENDIRAN
 * @author Lionel NGNINTEDEM
 *
 * Projet Questions Réponses
 *
 * Classe TestThemes : Permet de tester la classe Themes.
 */

package test_elements;

import elements.*;

public class TestThemes {
    public static void main(String []args) {
        // Initialisation de la "liste" de themes
        Themes themes = new Themes();

        // Initialisation de themes
        Theme sciences = new Theme("sciences");
        Theme maths = new Theme("maths");
        Theme geographie = new Theme("geographie");

        // Ajout des themes dans la liste
        themes.addTheme(sciences);
        themes.addTheme(maths);
        themes.addTheme(geographie);

        System.out.println(themes);
    }
}
