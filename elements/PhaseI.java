package elements;

import java.util.List;
import java.util.Scanner;

public class PhaseI implements Phase {

    private final String NOMPHASE = "PhaseI";
    private Joueurs joueursPhaseI;
    private Themes themes;

    public PhaseI() {
        themes = new Themes();
    }

    @Override
    public Joueurs selectJoueurs() {
        joueursPhaseI.selectRandomParticipants();
        return joueursPhaseI;
    }

    public void initQuestionsPhaseI() {
        //Création des themes
        Theme maths = new Theme("maths");
        themes.addTheme(maths);
        Theme jeuxVideos = new Theme("jeuxVideos");
        themes.addTheme(jeuxVideos);
        Theme series = new Theme("series");
        themes.addTheme(series);
        Theme films = new Theme("films");
        themes.addTheme(films);
        Theme histoire = new Theme("histoire");
        themes.addTheme(histoire);
        Theme nourriture = new Theme("nourriture");
        themes.addTheme(nourriture);
        Theme musique = new Theme("musique");
        themes.addTheme(musique);
        Theme geographie = new Theme("geographie");
        themes.addTheme(geographie);
        Theme sciences = new Theme("sciences");
        themes.addTheme(sciences);
        Theme animaux = new Theme("animaux");
        themes.addTheme(animaux);
        Theme super_heros = new Theme("super_heros");
        themes.addTheme(super_heros);
        Theme corps_humain = new Theme("corps_humain");
        themes.addTheme(corps_humain);
        Theme pays = new Theme("pays");
        themes.addTheme(pays);
        Theme pokemon = new Theme("pokemon");
        themes.addTheme(pokemon);
        Theme fruits = new Theme("fruits");
        themes.addTheme(fruits);
        Theme economie = new Theme("economie");
        themes.addTheme(economie);
        Theme monuments = new Theme("monuments");
        themes.addTheme(monuments);
        Theme energies_renouvelables = new Theme("energies_renouvelables");
        themes.addTheme(energies_renouvelables);
        Theme francais = new Theme("francais");
        themes.addTheme(francais);
        Theme nature = new Theme("nature");
        themes.addTheme(nature);

        //Création des qcm
        Qcm qcm1 = new Qcm("Calculer le volume d'un cylindre de 3 cm de rayon et 6 cm de hauteur",1, "149", "159",
                "169", 3, maths);
        Qcm qcm2 = new Qcm("Si l'on parcourt 240 km en 3h, quelle est notre vitesse approximative en m/s ?",2,"22", "27",
                "35", 1, maths);
        Qcm qcm3 = new Qcm("Un flan à la vanille contient 9% de sucre. Quel est le pourcentage de sucre contenu dans 6 flancs?",3,"9", "19",
                "54", 1, maths);
        Qcm qcm4 = new Qcm("Quel est le jeu ayant eu le plus de récompenses en titre de jeu de l'année 2020?",1, "Red Dead Redemption", "The Witcher 3",
                "The Last of Us", 3, jeuxVideos);
        Qcm qcm5 = new Qcm("En quelle année les premières bornes d'arcades ont été installées",2, "1980", "1970",
                "1984", 1, jeuxVideos);
        Qcm qcm6 = new Qcm("Parmi ces 3 consoles, laquelle est la plus vendue",3, "Wii", "Play Station",
                "XBox", 2, jeuxVideos);
        Qcm qcm7 = new Qcm("Comment s'appelle le personnage principal de la série Mentalist ?",1, "Patrick Jane", "Horatio Caine",
                "Spencer Reid", 1, series);
        Qcm qcm8 = new Qcm("Comment s'appelle l'acteur qui joue Sherlock dans la série du même nom ?",2, "Benedict Cumberbatch", "Rupert Graves",
                "Mark Gatiss", 1, series);
        Qcm qcm9 = new Qcm("Combien de temps le personnage d'Arrow est-il resté sur une île déserte ?",3, "6 ans", "4 ans",
                "5 ans", 3, series);
        Qcm qcm10 = new Qcm("Complétez le titre de ce dessin animé devenu culte ''Alice au pays des ... ?",2, "merveilles", "horreurs",
                "tapis vollants", 1, films);
        Qcm qcm11 = new Qcm("Quel film Disney se passe au Mexique et a pour titre le prénom de la grand-mère de Miguel",2, "Tata", "Abuela",
                "coco", 3, films);
        Qcm qcm12 = new Qcm("Quel film américain de super-héros, coécrit et réalisé par Ryan Coogler, est sorti en 2018 ?",3, "Batman", "Black panther",
                "Deadpool", 2, films);
        Qcm qcm13 = new Qcm("1+1 = ",2, "6", "2",
                "3", 2, histoire);
        Qcm qcm14 = new Qcm("Quand débutent les combats de la Première Guerre mondiale",2, "Aout 1914", "Juillet 1914",
                "Septembre 1914", 1, histoire);
        Qcm qcm15 = new Qcm("Quelle est la conséquence politique du congrès de Tours (1920) ?",3, "les ligues racistes sont crées", "le parti communiste est interdit",
                "la SFIO se divise en 2 parties", 3, histoire);
        Qcm qcm16 = new Qcm("La barbe à papa est composée de :",1, "Lait", "fécole de maïs",
                "sucre", 3, nourriture);
        Qcm qcm17 = new Qcm("Quel est en kg la quantité de pommes produite par un pommier cultivé chaque année? ",2, "365 Kg", "280",
                "412", 1, nourriture);
        Qcm qcm18 = new Qcm("Quel nom donne t'on au jus rougeatre qui sort de la viande?",2, "sang", "myoglobine",
                "plasma", 3, nourriture);
        Qcm qcm19 = new Qcm("Quel est le titre du premier album de Pascal Obispo, sorti en 1990 ?",1, "Le long du fleuve", "Soledad",
                "Superflu", 1, musique);
        Qcm qcm20 = new Qcm("Quel est le prénom de la femme du DJ David Guetta ?",2, "Cathy", "Rose",
                "Cindy", 1, musique);
        Qcm qcm21 = new Qcm("Dans quel boys-band Robbie Williams a-t-il commencé sa carrière ?",3, "Backstreet Boys", "Take that",
                "East 17", 2, musique);
        Qcm qcm22 = new Qcm("Dans quelle ville italienne se trouve la tour Pirelli",1, "Rome", "Turin",
                "Milan", 3, geographie);
        Qcm qcm23 = new Qcm("Quelle ville est surnommée <<la Fiancée de la Méditerranée>>?",2, "Tunis", "Tel-Aviv",
                "Alexandrie", 2, geographie);
        Qcm qcm24 = new Qcm("Outre la Belgique et le Luxembourg, quel est le troisième pays formant le Benelux?",3, "Pays-Bas", "Allemagne",
                "Autriche", 1, geographie);
        Qcm qcm25 = new Qcm("Quelle est la formule de l'intensité de la pesanteur ?",1, "G x ma x mb / d2", "Fa/b=G x ma x mb / d2",
                "P=m x g", 3, sciences);
        Qcm qcm26 = new Qcm("Combien de chromosomes une cellule reproductrice contient-elle ?",2, "46", "23",
                "60", 2, sciences);
        Qcm qcm27 = new Qcm("Parmi ces éléments, lequel est le plus léger?",3, "électron", "proton",
                "nucléon", 1, sciences);
        Qcm qcm28 = new Qcm("Combien mesure une giraffe?",1, "2.8m", "5.5m",
                "7.2m", 2, animaux);
        Qcm qcm29 = new Qcm("De quoi se nourrit le Bison d'Amérique du Nord?",2, "petits mammifères", "insectes",
                "Herbacées", 1, animaux);
        Qcm qcm30 = new Qcm("Combien de temps dure la gestation d'un zèbre",3, "10 mois", "13 mois",
                "15 mois", 2, animaux);
        Qcm qcm31 = new Qcm("Quel est le métier de superman",1, "journaliste", "facteur",
                "medecin", 1, super_heros);
        Qcm qcm32 = new Qcm("Quelle est la particularité de Daredevil ?",2, "Il a des pouvoirs divinatoires", "C'est un anti-héros",
                "Il est aveugle", 3, super_heros);
        Qcm qcm33 = new Qcm("A quel groupe appartiennent Flèche noire et Medusa",3, "les inhumains", "les x-men",
                "les avengers", 1, super_heros);
        Qcm qcm34 = new Qcm("Combien la langue compte-t-elle de muscles ?",1, "15", "11",
                "20", 1, corps_humain);
        Qcm qcm35 = new Qcm("Combien y a-t-il de cellules dans le corps ?",2, "7500 milliards", "75 000 milliards",
                "75 milliards", 2, corps_humain);
        Qcm qcm36 = new Qcm("De combien d'os est constitué le crâne humain",3, "12", "14",
                "8", 2, corps_humain);
        Qcm qcm37 = new Qcm("Parmi ces pays, lequel est limitrophe à la France ?",1, "Italie", "Angleterre",
                "Grèce", 1, pays);
        Qcm qcm38 = new Qcm("Quelle est la capitale du Cameroun ?",2, "Ouagadougou", "Yaoundé",
                "Brazzaville", 2, pays);
        Qcm qcm39 = new Qcm("Combien de pays compte l'Afrique ?",3, "58", "52",
                "54", 3, pays);
        Qcm qcm40 = new Qcm("Qu'est la première évolution de Roucool",1, "Roucoups", "Roucattak",
                "Roucarnage", 1, pokemon);
        Qcm qcm41 = new Qcm("Quel est le Pokémon qui bloque le pont dans presque tous les Pokémon ?",2, "Ronflex", "Goinfrex",
                "Grotademorv", 1, pokemon);
        Qcm qcm42 = new Qcm("Quelle est la couleur de la toute première version de Pokémon ?",3, "version rouge et bleu", "Version verte",
                "version perle", 2, pokemon);
        Qcm qcm43 = new Qcm("Quel est l'autre nom de la pomme d'amour",1, "le melon", "l'orange",
                "la tomate", 3, fruits);
        Qcm qcm44 = new Qcm("Il est vert, rouge ou blanc de qui s'agit-il ?",2, "du poivron", "du concombre",
                "du haricot", 3, fruits);
        Qcm qcm45 = new Qcm("le citron est un fruit d'origine",3, "indienne", "sud américaine",
                "méditérannenne", 1, fruits);
        Qcm qcm46 = new Qcm("Indiquez ci-dessous ce qui n'est PAS un facteur de production",1, "le travail", "le capital",
                "un prêt bancaire", 3, economie);
        Qcm qcm47 = new Qcm("La microéconomie ne s'occupe pas du comportement ...",2, "de la demande agrégée", "des entreprises",
                "des inustries", 1, economie);
        Qcm qcm48 = new Qcm("L'étude de l'inflation fait partie de ...",3, "l'économie normative", "la microéconomie",
                "la macroéconomie", 3, economie);
        Qcm qcm49 = new Qcm("Quand la Tour Eiffel a-t-elle été construite?",1, "XXème siècle", "XVIème siècle",
                "XIX ème siècle", 3, monuments);
        Qcm qcm50 = new Qcm("Quel célèbre musée se situe dans la ville de Bilbao?",2, "Guggenheim", "Berardo",
                "Tolstoï", 1, monuments);
        Qcm qcm51 = new Qcm("Dans quelle ville se situe le Manneken Pis?",3, "Cologne", "Bruxelles",
                "Amsterdam", 2, monuments);
        Qcm qcm52 = new Qcm("Quelle est l'énergie renouvelable la plus rentable ",1, "énergie éolienne", "énergie nucléaire",
                "Energie hydraulique", 3, energies_renouvelables);
        Qcm qcm53 = new Qcm("Quelle est l'énergie issue de la combustion des déchets organiques ?",2, "Energie de la biomasse", "Energie géothermique",
                "Energie hydraulique", 1, energies_renouvelables);
        Qcm qcm54 = new Qcm("Une dynamo fonctionne par l'énergie...",3, "cinétique", "mécanique",
                "électrique", 2, energies_renouvelables);
        Qcm qcm55 = new Qcm("Complétez : \" Voilà ... il est question.",1, "De quoi", "Ce dont",
                "Les deux", 3, francais);
        Qcm qcm56 = new Qcm("\" Qu'il est grand cet enfant ! \" Pouvez-vous donner la nature de \"qu'\" (que)",2, "pronom relatif", "conjonction de subordination",
                "adverbe", 3, francais);
        Qcm qcm57 = new Qcm("Quelle artiste disait avec humour . \" Fermer les maisons closes, c'est plus qu'un crime, c'est un pléonasme.\"",3, "Jacky Sardou", "Arletty",
                "Edith Piaf", 2, francais);
        Qcm qcm58 = new Qcm("Lequel de ces animaux vit dans la jungle",1, "la hyène", "le rhinocéros",
                "le babouin", 3, nature);
        Qcm qcm59 = new Qcm("De quelle famille les crocodiles sont-ils",2, "Alligatoridés", "les amphibiens",
                "Crocodilidés", 3, nature);
        Qcm qcm60 = new Qcm("Lequel de ces animaux est en voie de disparition ?",3, "le pélican", "l'ornithorynque",
                "le tigre blanc", 3, nature);

        qcm1.getTheme().getQuestions().addQuestion(qcm1);
        qcm2.getTheme().getQuestions().addQuestion(qcm2);
        qcm3.getTheme().getQuestions().addQuestion(qcm3);
        qcm4.getTheme().getQuestions().addQuestion(qcm4);
        qcm5.getTheme().getQuestions().addQuestion(qcm5);
        qcm6.getTheme().getQuestions().addQuestion(qcm6);
        qcm7.getTheme().getQuestions().addQuestion(qcm7);
        qcm8.getTheme().getQuestions().addQuestion(qcm8);
        qcm9.getTheme().getQuestions().addQuestion(qcm9);
        qcm10.getTheme().getQuestions().addQuestion(qcm10);
        qcm11.getTheme().getQuestions().addQuestion(qcm11);
        qcm12.getTheme().getQuestions().addQuestion(qcm12);
        qcm13.getTheme().getQuestions().addQuestion(qcm13);
        qcm14.getTheme().getQuestions().addQuestion(qcm14);
        qcm15.getTheme().getQuestions().addQuestion(qcm15);
        qcm16.getTheme().getQuestions().addQuestion(qcm16);
        qcm17.getTheme().getQuestions().addQuestion(qcm17);
        qcm18.getTheme().getQuestions().addQuestion(qcm18);
        qcm19.getTheme().getQuestions().addQuestion(qcm19);
        qcm20.getTheme().getQuestions().addQuestion(qcm20);
        qcm21.getTheme().getQuestions().addQuestion(qcm21);
        qcm22.getTheme().getQuestions().addQuestion(qcm22);
        qcm23.getTheme().getQuestions().addQuestion(qcm23);
        qcm24.getTheme().getQuestions().addQuestion(qcm24);
        qcm25.getTheme().getQuestions().addQuestion(qcm25);
        qcm26.getTheme().getQuestions().addQuestion(qcm26);
        qcm27.getTheme().getQuestions().addQuestion(qcm27);
        qcm28.getTheme().getQuestions().addQuestion(qcm28);
        qcm29.getTheme().getQuestions().addQuestion(qcm29);
        qcm30.getTheme().getQuestions().addQuestion(qcm30);
        qcm31.getTheme().getQuestions().addQuestion(qcm31);
        qcm32.getTheme().getQuestions().addQuestion(qcm32);
        qcm33.getTheme().getQuestions().addQuestion(qcm33);
        qcm34.getTheme().getQuestions().addQuestion(qcm34);
        qcm35.getTheme().getQuestions().addQuestion(qcm35);
        qcm36.getTheme().getQuestions().addQuestion(qcm36);
        qcm37.getTheme().getQuestions().addQuestion(qcm37);
        qcm38.getTheme().getQuestions().addQuestion(qcm38);
        qcm39.getTheme().getQuestions().addQuestion(qcm39);
        qcm40.getTheme().getQuestions().addQuestion(qcm40);
        qcm41.getTheme().getQuestions().addQuestion(qcm41);
        qcm42.getTheme().getQuestions().addQuestion(qcm42);
        qcm43.getTheme().getQuestions().addQuestion(qcm43);
        qcm44.getTheme().getQuestions().addQuestion(qcm44);
        qcm45.getTheme().getQuestions().addQuestion(qcm45);
        qcm46.getTheme().getQuestions().addQuestion(qcm46);
        qcm47.getTheme().getQuestions().addQuestion(qcm47);
        qcm48.getTheme().getQuestions().addQuestion(qcm48);
        qcm49.getTheme().getQuestions().addQuestion(qcm49);
        qcm50.getTheme().getQuestions().addQuestion(qcm50);
        qcm51.getTheme().getQuestions().addQuestion(qcm51);
        qcm52.getTheme().getQuestions().addQuestion(qcm52);
        qcm53.getTheme().getQuestions().addQuestion(qcm53);
        qcm54.getTheme().getQuestions().addQuestion(qcm54);
        qcm55.getTheme().getQuestions().addQuestion(qcm55);
        qcm56.getTheme().getQuestions().addQuestion(qcm56);
        qcm57.getTheme().getQuestions().addQuestion(qcm57);
        qcm58.getTheme().getQuestions().addQuestion(qcm58);
        qcm59.getTheme().getQuestions().addQuestion(qcm59);
        qcm60.getTheme().getQuestions().addQuestion(qcm60);

        //Creation des rc
        Rc rc1 = new Rc("8 x 9 = ? ",1, "72", maths);
        Rc rc2 = new Rc("(a+b)^2 = ?",2, "a^2 + 2ab + b^2", maths);
        Rc rc3 = new Rc("Quelle est la valeur de Pi à 10^-4 près?",3, "3,1416", maths);
        Rc rc4 = new Rc("Comment s'appelle le dinosaure vert accompagnant Mario? ",1, "yoshi", jeuxVideos);
        Rc rc5 = new Rc("De quelle nationalité est l'entreprise Ubisoft?",2, "française", jeuxVideos);
        Rc rc6 = new Rc("Quel est le nom de l'entreprise de jeux racheté par Microsoft en 2002?",3, "rareware", jeuxVideos);
        Rc rc7 = new Rc("Dans La Casa de Papel, où se retrouvent Raquel et le Professeur?",1, "philippines", series);
        Rc rc8 = new Rc("Comment s'appelle en réalité Michael Scofield?",2, "wentworth miller", series);
        Rc rc9 = new Rc("Dans Black Mirror, à quelle série fait allusion l'épsiode 'USS Calister?'",3, "star trek", series);
        Rc rc10 = new Rc("Dans Intouchables quel est le prénom d'Omar Sy?",1, "driss", films);
        Rc rc11 = new Rc("Combien y-a-t-il eu de 'Pirates des Caraïbes'? ",2, "5", films);
        Rc rc12 = new Rc("Combien de membres composent les gardiens de la Galaxie dans le premier film?",3, "4", films);
        Rc rc13 = new Rc("Comment est morte Jeanne D'arc?",1, "brulé", histoire);
        Rc rc14 = new Rc("Quand est-ce que la révolution bolchévique a eu lieu?",2, "1917", histoire);
        Rc rc15 = new Rc("Quel est le nom du Premier ministre canadien?",3, "trudeau", histoire);
        Rc rc16 = new Rc("jaune d'oeuf + huile =",1, "mayonnaise", nourriture);
        Rc rc17 = new Rc("D'après la légende, qui a inventé les pâtes?",2, "chine", nourriture);
        Rc rc18 = new Rc("Quel fromage contenant des asticots est interdit en france?",3, "casu marzu", nourriture);
        Rc rc19 = new Rc("Qui est l'interprète du titre Billie Jean? ",1, "michael jackson", musique);
        Rc rc20 = new Rc("Quel est l'album le plus vendu de tous les temps?",2, "thriller", musique);
        Rc rc21 = new Rc("Quelle est l'artiste feminine ayant remporté le plus de Grammys?",3, "beyonce", musique);
        Rc rc22 = new Rc("Combien y a-t-il de continents?",1, "6", geographie);
        Rc rc23 = new Rc("Sur quel continent se situe le Malawi?",2, "afrique", geographie);
        Rc rc24 = new Rc("Quelle est la ville la plus peuplée au monde?",3, "shanghai", geographie);
        Rc rc25 = new Rc("Quelle est la découverte réalisée par Alexandre Fleming?",1, "pénicilline", sciences);
        Rc rc26 = new Rc("Quelle est la plus grande planète du système solaire?",2, "jupiter", sciences);
        Rc rc27 = new Rc("Quel est l'élément le plus présent dans l'air?",3, "azote", sciences);
        Rc rc28 = new Rc("Avec quels organes repirent les poissons? ",1, "branchies", animaux);
        Rc rc29 = new Rc("De quelle région du monde le puma est-il originaire",2, "amérique", animaux);
        Rc rc30 = new Rc("Quel genre d'animaux un enthomolgiste étudie-t-il?",3, "insectes", animaux);
        Rc rc31 = new Rc("Quel est le nom civil de spiderman ?",1, "peter parker", super_heros);
        Rc rc32 = new Rc("de quel type sont les rayons ayant provoqué la transformation de Bruce Banner en hulk ?",2, "gamma", super_heros);
        Rc rc33 = new Rc("en quelle année est apparu dans les comics le tout premier super-héros au sens moderne du terme?",3, "1938", super_heros);
        Rc rc34 = new Rc("quel est en moyenne et en litres le volume de sang d'un homme adulte ?",1, "5", corps_humain);
        Rc rc35 = new Rc("Quelle est la partie du cerveau qui controle l'équilibre ?",2, "cervelet", corps_humain);
        Rc rc36 = new Rc("Quel est l'os le plus court du corps humain ?",3, "étrier", corps_humain);
        Rc rc37 = new Rc("Quelle est la capitale des Philippines?",1,"manille", pays);
        Rc rc38 = new Rc("Quel est le nom actuel du pays qui fut autrefois appelé République populaire de Kampuchéa ?",2, "cambodge", pays);
        Rc rc39 = new Rc("Quel pays signifie littéralement le pays des hommes intègres en langue Mossa",3, "burkina faso", pays);
        Rc rc40 = new Rc("Comment s'appelle la forme évoluée de Pikatchu ?",1, "raichu", pokemon);
        Rc rc41 = new Rc("De quel type est le pokémon tiplouf ?",2, "eau", pokemon);
        Rc rc42 = new Rc("Comment s'appelle la chef du conseil des quatre de Sinnoh ?",3, "cynthia", pokemon);
        Rc rc43 = new Rc("A base de quel fruit confectionne t'on le guacamole ?",1, "avocat", fruits);
        Rc rc44 = new Rc("De quel fruit la guariguette est elle une variété ?",2, "fraise", fruits);
        Rc rc45 = new Rc("En France, quel département est le plus gros producteur de cerise ?",3, "vaucluse", fruits);
        Rc rc46 = new Rc("Qu'est ce que l'OMC?",1, "organisation mondiale du commerce", economie);
        Rc rc47 = new Rc("Qui est l'inventeur de la main invisible?",2, "adam smith", economie);
        Rc rc48 = new Rc("A qui attribue-t-on la théorie de l'avantage comparatif?",3, "david ricardo", economie);
        Rc rc49 = new Rc("Quel monument donne son nom à un roman de Victor Hugo ?",1, "notre-dame de paris", monuments);
        Rc rc50 = new Rc("Quel roi est à l'origine du château de Versailles?",2, "louis 13", monuments);
        Rc rc51 = new Rc("De quelle couleur est le célèbre Golden Gate Bridge qui relie San Francisco à Sausalito?",3, "orange", monuments);
        Rc rc52 = new Rc("En quelle année a été créé le concept de développement durable?",1, "1987", energies_renouvelables);
        Rc rc53 = new Rc("Quel pays est le premier producteur d'énergie solaire au monde? ",2, "allemagne", energies_renouvelables);
        Rc rc54 = new Rc("Quelle était le nom de la plus ancienne centrale nucléaire de France encore en activité?",3, "fessenheim", energies_renouvelables);
        Rc rc55 = new Rc("Conjuguez le verbe mouvoir à la 2ème personne du pluriel au passé simple ",1, "mûtes", francais);
        Rc rc56 = new Rc("Quel est le pluriel du mot 'banal'?",2, "ça dépend", francais);
        Rc rc57 = new Rc("Quel est le mot qui a détrôné en longeur 'anticonstitutionnellement'",3, "intergouvernementalisations", francais);
        Rc rc58 = new Rc("Quelle plante est composée de petites clochettes blanches?",1, "muguet", nature);
        Rc rc59 = new Rc("Quelle est la couleur de la fleur la camomille?",2, "blanche", nature);
        Rc rc60 = new Rc("En quelle année a été signé le Protocole de Kyoto?",3, "1997", nature);

        rc1.getTheme().getQuestions().addQuestion(rc1);
        rc2.getTheme().getQuestions().addQuestion(rc2);
        rc3.getTheme().getQuestions().addQuestion(rc3);
        rc4.getTheme().getQuestions().addQuestion(rc4);
        rc5.getTheme().getQuestions().addQuestion(rc5);
        rc6.getTheme().getQuestions().addQuestion(rc6);
        rc7.getTheme().getQuestions().addQuestion(rc7);
        rc8.getTheme().getQuestions().addQuestion(rc8);
        rc9.getTheme().getQuestions().addQuestion(rc9);
        rc10.getTheme().getQuestions().addQuestion(rc10);
        rc11.getTheme().getQuestions().addQuestion(rc11);
        rc12.getTheme().getQuestions().addQuestion(rc12);
        rc13.getTheme().getQuestions().addQuestion(rc13);
        rc14.getTheme().getQuestions().addQuestion(rc14);
        rc15.getTheme().getQuestions().addQuestion(rc15);
        rc16.getTheme().getQuestions().addQuestion(rc16);
        rc17.getTheme().getQuestions().addQuestion(rc17);
        rc18.getTheme().getQuestions().addQuestion(rc18);
        rc19.getTheme().getQuestions().addQuestion(rc19);
        rc20.getTheme().getQuestions().addQuestion(rc20);
        rc21.getTheme().getQuestions().addQuestion(rc21);
        rc22.getTheme().getQuestions().addQuestion(rc22);
        rc23.getTheme().getQuestions().addQuestion(rc23);
        rc24.getTheme().getQuestions().addQuestion(rc24);
        rc25.getTheme().getQuestions().addQuestion(rc25);
        rc26.getTheme().getQuestions().addQuestion(rc26);
        rc27.getTheme().getQuestions().addQuestion(rc27);
        rc28.getTheme().getQuestions().addQuestion(rc28);
        rc29.getTheme().getQuestions().addQuestion(rc29);
        rc30.getTheme().getQuestions().addQuestion(rc30);
        rc31.getTheme().getQuestions().addQuestion(rc31);
        rc32.getTheme().getQuestions().addQuestion(rc32);
        rc33.getTheme().getQuestions().addQuestion(rc33);
        rc34.getTheme().getQuestions().addQuestion(rc34);
        rc35.getTheme().getQuestions().addQuestion(rc35);
        rc36.getTheme().getQuestions().addQuestion(rc36);
        rc37.getTheme().getQuestions().addQuestion(rc37);
        rc38.getTheme().getQuestions().addQuestion(rc38);
        rc39.getTheme().getQuestions().addQuestion(rc39);
        rc40.getTheme().getQuestions().addQuestion(rc40);
        rc41.getTheme().getQuestions().addQuestion(rc41);
        rc42.getTheme().getQuestions().addQuestion(rc42);
        rc43.getTheme().getQuestions().addQuestion(rc43);
        rc44.getTheme().getQuestions().addQuestion(rc44);
        rc45.getTheme().getQuestions().addQuestion(rc45);
        rc46.getTheme().getQuestions().addQuestion(rc46);
        rc47.getTheme().getQuestions().addQuestion(rc47);
        rc48.getTheme().getQuestions().addQuestion(rc48);
        rc49.getTheme().getQuestions().addQuestion(rc49);
        rc50.getTheme().getQuestions().addQuestion(rc50);
        rc51.getTheme().getQuestions().addQuestion(rc51);
        rc52.getTheme().getQuestions().addQuestion(rc52);
        rc53.getTheme().getQuestions().addQuestion(rc53);
        rc54.getTheme().getQuestions().addQuestion(rc54);
        rc55.getTheme().getQuestions().addQuestion(rc55);
        rc56.getTheme().getQuestions().addQuestion(rc56);
        rc57.getTheme().getQuestions().addQuestion(rc57);
        rc58.getTheme().getQuestions().addQuestion(rc58);
        rc59.getTheme().getQuestions().addQuestion(rc59);
        rc60.getTheme().getQuestions().addQuestion(rc60);

        // Creation des vf
        Vf vf1 = new Vf("1+1 = 10", 1, false, maths);
        Vf vf2 = new Vf("2x8 + 4 = 4x5", 2, true, maths);
        Vf vf3 = new Vf("(45x167 - 15x9823 = -139820", 3, false, maths);
        Vf vf4 = new Vf("Yoshi est un champignon", 1, false, jeuxVideos);
        Vf vf5 = new Vf("Mario Kart a été créé par les japonais", 2, true, jeuxVideos);
        Vf vf6 = new Vf("Ubisoft est le développeur de Clash of Clans", 3, false, jeuxVideos);
        Vf vf7 = new Vf("C'est Cooper Barnes qui incarne Kid Danger dans Henry Danger", 1, false, series);
        Vf vf8 = new Vf("Phoebe est le prénom du personnage principal dans Les Thunderman", 2, true, series);
        Vf vf9 = new Vf("Dans la Casa de Papel, Tokyo menace le Professeur avec un couteau sous la gorge lors de leur première rencontre", 3, false, series);
        Vf vf10 = new Vf("L'acteur principal de la trilogie Le Transporteur est Ryan Reynolds", 1, false, films);
        Vf vf11 = new Vf("Kev Adams fait une apparition dans le film LOL", 2, true, films);
        Vf vf12 = new Vf("Amélie Poulain est conçue à 18h 28min 12sec", 3,false, films);
        Vf vf13 = new Vf("Christophe Colomb a découvert l'Amérique", 1, false, histoire);
        Vf vf14 = new Vf("L'état d'Haïti a été fondé en 1806", 2, true, histoire);
        Vf vf15 = new Vf("La bataille d'Hastings s'est déroulé en 1067", 3, false, histoire);
        Vf vf16 = new Vf("Il existe 700 variétés de pommes dans le monde", 1, false, nourriture);
        Vf vf17 = new Vf("C'est le compte Sandwich qui est l'inventeur du sandwich", 2, true, nourriture);
        Vf vf18 = new Vf("L'inventeur de la barbe à papa était un dentiste", 3, true, nourriture);
        Vf vf19 = new Vf("Jean-Jacques Goldman a écrit 'Je te le donne'", 1, true, musique);
        Vf vf20 = new Vf("Une portée contient 5 lignes ", 2, true, musique);
        Vf vf21 = new Vf("Les Enfoirés existe depuis 1970", 3, false, musique);
        Vf vf22 = new Vf("Le Machu Picchu se trouve au Pérou", 1, true, geographie);
        Vf vf23 = new Vf("Les pays baltes sont la Norvège, la Suède et la Finlande", 2, false, geographie);
        Vf vf24 = new Vf("L'île de la Corse est divisé en 2 départements", 3, true, geographie);
        Vf vf25 = new Vf("Les champignons sont des plantes", 1, false, sciences);
        Vf vf26 = new Vf("Les chats sont la 1ère cause de mortalités chez les oiseaux", 2, true, sciences);
        Vf vf27 = new Vf("L'eau froide gèle plus vite que l'eau chaude", 3, false, sciences);
        Vf vf28 = new Vf("La baleine bleue est le plus grand animal du monde", 1, true, animaux);
        Vf vf29 = new Vf("Le jars est le mâle de l'oie", 2, true, animaux);
        Vf vf30 = new Vf("Le loup est un canidé", 3, true, animaux);
        Vf vf31 = new Vf("L'action du film Captain Marvel se déroule dans les années 1990", 1, true, super_heros);
        Vf vf32 = new Vf("Le film Watchmen a été réalisé par Zack Synder", 2, true, super_heros);
        Vf vf33 = new Vf("Dans Venom, Eddie Brock présente sa propre émission intitulée Eddie Brock Show", 3, false, super_heros);
        Vf vf34 = new Vf("Les cellules sanguines sont produites dans le foie", 1, false, corps_humain);
        Vf vf35 = new Vf("Pendant sa vie, une personne produira environ 500L de salive", 2, false, corps_humain);
        Vf vf36 = new Vf("Les tendons assurent la stabilité des articulations", 3, false, corps_humain);
        Vf vf37 = new Vf("Les 2 couleurs du drapeau suédois sont le jaune et le vert", 1, false, pays);
        Vf vf38 = new Vf("Tétouan est une ville algérienne", 2, false, pays);
        Vf vf39 = new Vf("Le Chiemsee est un lac situé en Allemagne", 3, true, pays);
        Vf vf40 = new Vf("Phyllali est un Pokémon de type Plante", 1, true, pokemon);
        Vf vf41 = new Vf("Pikachu a été le tout premier Pokémon dessiné", 2, false, pokemon);
        Vf vf42 = new Vf("La couleur de Brutapode est le pourpre", 3, true, pokemon);
        Vf vf43 = new Vf("Les fruits secs sont riches en magnésium", 1, true, fruits);
        Vf vf44 = new Vf("Le jamblon est un fruit", 2, true, fruits);
        Vf vf45 = new Vf("La Chantecler est une variété de poire", 3, false, fruits);
        Vf vf46 = new Vf("Le pouvoir d'achat est influencé par l'inflation", 1, true, economie);
        Vf vf47 = new Vf("Un Etat qualifié d'Etat-gendarme assure un certain niveau de sécurité et de bien-être social à l'ensemble de la population", 2, false, economie);
        Vf vf48 = new Vf("Le principe du pollueur-payeur a été mis en place par Greenpeace en 2019", 3, false, economie);
        Vf vf49 = new Vf("Gustave Eiffel a participé à la construction de la Tour Eiffel et de la statie de la Liberté", 1, true, monuments);
        Vf vf50 = new Vf("L'inclinaison de la tour de Pise s'explique par la construction dun métro qui en a affaibli les fondations", 2, false, monuments);
        Vf vf51 = new Vf("Le monastère bouddhiste du mont Popa est construit sur un volcan", 3, true, monuments);
        Vf vf52 = new Vf("La combustion de biomasse produit directement de l'électricité", 1, false, energies_renouvelables);
        Vf vf53 = new Vf("Les panneaux photovoltaïques sont généralement formés de plusieurs couches superposées", 2, true, energies_renouvelables);
        Vf vf54 = new Vf("La géothermie de surface est utilisée principalement pour le chauffage et la climatisation des immeubles", 3, true, energies_renouvelables);
        Vf vf55 = new Vf("La phrase est correcte : Je bouille de colère face à cette injustice", 1, false, francais);
        Vf vf56 = new Vf("Le verbe 'traire' n'a pas de passé simple", 2, true, francais);
        Vf vf57 = new Vf("Il n'y a pas de faute : Jules s'est converti au bouddhisme", 3, true, francais);
        Vf vf58 = new Vf("Un espace sans arbres qui se situe dans une forêt est une clairière", 1, true, nature);
        Vf vf59 = new Vf("Un herbier est une collection de feuilles et de plantes séchées, conservée entre des feuilles de papier", 2, true, nature);
        Vf vf60 = new Vf("Un phycologue étudie les coquillages", 3, false, nature);

        vf1.getTheme().getQuestions().addQuestion(vf1);
        vf2.getTheme().getQuestions().addQuestion(vf2);
        vf3.getTheme().getQuestions().addQuestion(vf3);
        vf4.getTheme().getQuestions().addQuestion(vf4);
        vf5.getTheme().getQuestions().addQuestion(vf5);
        vf6.getTheme().getQuestions().addQuestion(vf6);
        vf7.getTheme().getQuestions().addQuestion(vf7);
        vf8.getTheme().getQuestions().addQuestion(vf8);
        vf9.getTheme().getQuestions().addQuestion(vf9);
        vf10.getTheme().getQuestions().addQuestion(vf10);
        vf11.getTheme().getQuestions().addQuestion(vf11);
        vf12.getTheme().getQuestions().addQuestion(vf12);
        vf13.getTheme().getQuestions().addQuestion(vf13);
        vf14.getTheme().getQuestions().addQuestion(vf14);
        vf15.getTheme().getQuestions().addQuestion(vf15);
        vf16.getTheme().getQuestions().addQuestion(vf16);
        vf17.getTheme().getQuestions().addQuestion(vf17);
        vf18.getTheme().getQuestions().addQuestion(vf18);
        vf19.getTheme().getQuestions().addQuestion(vf19);
        vf20.getTheme().getQuestions().addQuestion(vf20);
        vf21.getTheme().getQuestions().addQuestion(vf21);
        vf22.getTheme().getQuestions().addQuestion(vf22);
        vf23.getTheme().getQuestions().addQuestion(vf23);
        vf24.getTheme().getQuestions().addQuestion(vf24);
        vf25.getTheme().getQuestions().addQuestion(vf25);
        vf26.getTheme().getQuestions().addQuestion(vf26);
        vf27.getTheme().getQuestions().addQuestion(vf27);
        vf28.getTheme().getQuestions().addQuestion(vf28);
        vf29.getTheme().getQuestions().addQuestion(vf29);
        vf30.getTheme().getQuestions().addQuestion(vf30);
        vf31.getTheme().getQuestions().addQuestion(vf31);
        vf32.getTheme().getQuestions().addQuestion(vf32);
        vf33.getTheme().getQuestions().addQuestion(vf33);
        vf34.getTheme().getQuestions().addQuestion(vf34);
        vf35.getTheme().getQuestions().addQuestion(vf35);
        vf36.getTheme().getQuestions().addQuestion(vf36);
        vf37.getTheme().getQuestions().addQuestion(vf37);
        vf38.getTheme().getQuestions().addQuestion(vf38);
        vf39.getTheme().getQuestions().addQuestion(vf39);
        vf40.getTheme().getQuestions().addQuestion(vf40);
        vf41.getTheme().getQuestions().addQuestion(vf41);
        vf42.getTheme().getQuestions().addQuestion(vf42);
        vf43.getTheme().getQuestions().addQuestion(vf43);
        vf44.getTheme().getQuestions().addQuestion(vf44);
        vf45.getTheme().getQuestions().addQuestion(vf45);
        vf46.getTheme().getQuestions().addQuestion(vf46);
        vf47.getTheme().getQuestions().addQuestion(vf47);
        vf48.getTheme().getQuestions().addQuestion(vf48);
        vf49.getTheme().getQuestions().addQuestion(vf49);
        vf50.getTheme().getQuestions().addQuestion(vf50);
        vf51.getTheme().getQuestions().addQuestion(vf51);
        vf52.getTheme().getQuestions().addQuestion(vf52);
        vf53.getTheme().getQuestions().addQuestion(vf53);
        vf54.getTheme().getQuestions().addQuestion(vf54);
        vf55.getTheme().getQuestions().addQuestion(vf55);
        vf56.getTheme().getQuestions().addQuestion(vf56);
        vf57.getTheme().getQuestions().addQuestion(vf57);
        vf58.getTheme().getQuestions().addQuestion(vf58);
        vf59.getTheme().getQuestions().addQuestion(vf59);
        vf60.getTheme().getQuestions().addQuestion(vf60);
    }

    @Override
    public Joueur[] playPhase() {
        //Creation des themes et questions
        initQuestionsPhaseI();

        // Creation des joueurs
        System.out.println("Rentrez le nombre de joueurs : ");
        Scanner scanner = new Scanner(System.in);
        int nbJoueurs = scanner.nextInt();

        while (nbJoueurs < 4 || nbJoueurs > 20) {
            System.out.println("Saisie incorrrecte : le nombre de joueurs doit être compris entre 4 et 20.\nRecommencez : ");
            nbJoueurs = scanner.nextInt();
        }

        joueursPhaseI = new Joueurs(nbJoueurs);
        joueursPhaseI = selectJoueurs();

        for (Joueur joueur : joueursPhaseI.getParticipants()) {
            joueur.updateEtat("s");
        }

        System.out.println(joueursPhaseI);

        // Selection des n themes
        List<Theme> listThemesPI = themes.selectNThemes((int) (Math.random() * 11) + 10);
        /*String str = "[";
        for(Theme theme : listThemesPI) {
            str += theme.getNom() + ", ";
        }
        str += "]";*/
        System.out.println("Thèmes de la phase I :\n" + listThemesPI + "\n");

        // Selection aleatoire d'un theme parmis ces n themes
        int indiceTheme = (int) (Math.random() * listThemesPI.size());
        Theme unTheme = listThemesPI.get(indiceTheme);
        System.out.println("Thème du 1er Round : " + unTheme.getNom());

        // Choix du nombre de questions par joueurs
        int nbQuestions = (int) (Math.random() * 4) + 1;
        //System.out.println("Nombre de questions par joueur : "+nbQuestions);
        System.out.println("Nombre de questions par joueur : 2");

        // Les joueurs repondent aux questions (dans l'ordre de selection)
        int tour = 1;

        // a) round avec que des questions faciles + AJOUTER CONDITION FACILE
        System.out.println("Tour " + tour + " :\n");
        tour++;
        for (int i = 0; i < 1; i++) {
            for (Joueur joueur : joueursPhaseI.getParticipants()) {
                System.out.println("Joueur " + joueur.getNom() + " n°" + joueur.getNumero());
                Question randQuestion = unTheme.getQuestions().selectRandQuestion();

                //on veut des questions de difficulte 1
                while (randQuestion.getDifficulte() != 1) {
                    randQuestion = unTheme.getQuestions().selectRandQuestion();
                }

                System.out.println(randQuestion);
                try {
                    randQuestion.testBonneReponse(joueur, NOMPHASE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // b) round avec le nombre de questions restant

        int j = 0;

        while(j < 1) { // nombre de questions, -1 a cause du premier tour avec questions faciles
            for (int k = 0; k < listThemesPI.size(); k++) { // nombre de themes au total
                if(j < 1) {
                    indiceTheme++;
                    if(indiceTheme >= listThemesPI.size())
                        indiceTheme = 0;
                    unTheme = listThemesPI.get(indiceTheme);
                    System.out.println("Tour " + tour + " :\n");
                    tour++;
                    for (Joueur joueur : joueursPhaseI.getParticipants()) {
                        System.out.println("Joueur " + joueur.getNom() + " n°" + joueur.getNumero());
                        Question randQuestion = unTheme.getQuestions().selectRandQuestion();
                        System.out.println(randQuestion);
                        try {
                            randQuestion.testBonneReponse(joueur, NOMPHASE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    j++;
                }
                else
                    break;
            }
        }
        System.out.println("Phase I terminée.\n");

        // 6) elimination des joueurs : on enleve les plus faibles
        int nbDemiFinalistes = nbJoueurs;
        while (nbDemiFinalistes > 3) {
            int k = 0;
            int min;
            do {
                min = joueursPhaseI.getParticipants()[k].getScore();;
                k++;
            } while(joueursPhaseI.getParticipants()[k-1].getEtat().equals("Eliminé"));
            int indiceMin = k-1;
            for (int i = 1; i < nbJoueurs; i++) {
                if (joueursPhaseI.getParticipants()[i].getScore() < min && !joueursPhaseI.getParticipants()[i].getEtat().equals("Eliminé")) {
                    min = joueursPhaseI.getParticipants()[i].getScore();
                    indiceMin = i;
                }
            }
            joueursPhaseI.getParticipants()[indiceMin].updateEtat("e");
            nbDemiFinalistes--;
        }
        System.out.println("Joueurs encore en lice : ");
        for (Joueur joueur : joueursPhaseI.getParticipants()) {
            System.out.println(joueur);
        }
        return joueursPhaseI.getParticipants();
    }

    @Override
    public String getNomPhase() {
        return NOMPHASE;
    }

    public Themes getThemes() {
        return themes;
    }

}
