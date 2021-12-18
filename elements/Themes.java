package elements;

import java.util.*;

public class Themes {

    private List<Theme> themes;

    public Themes() {
        themes = new ArrayList<>();
    }

    public void addTheme(Theme theme) {
        themes.add(theme);
    }

    public List<Theme> getThemes() {
        return themes;
    }

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

    @Override
    public String toString() {
        String str = "";
        for(Theme theme : themes) {
            str += theme.getNom() + '\n';
        }
        return str;
    }
}