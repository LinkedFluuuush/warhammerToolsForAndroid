package com.linkedFluuuush.warhammerToolsForAndroid.core.entities;

import com.linkedFluuuush.warhammerToolsForAndroid.core.World;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Linked
 * Date: 12/11/13
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
public class PersonalDetails {
    private boolean male;
    private int age;
    private String birthplace;
    private God favoriteGod;
    private int height;
    private int weight;
    private String eyeColour;
    private String hairColour;
    private AstralSign astralSign;
    private LinkedList<String> distinguishingMarks;

    public PersonalDetails(){
        male = true;
        age = 0;
        birthplace = "Unknown";
        favoriteGod = World.searchGodByName("Sigmar");
        height = 0;
        weight = 0;
        eyeColour = "Unknown";
        hairColour = "Unknown";
        distinguishingMarks = new LinkedList<String>();
    }

    public PersonalDetails(boolean male, int age, String birthplace,
                           God favoriteGod, int height, int weight, String eyeColour,
                           String hairColour, AstralSign astralSign, LinkedList<String> distinguishingMarks) {
        this.male = male;
        this.age = age;
        this.birthplace = birthplace;
        this.favoriteGod = favoriteGod;
        this.height = height;
        this.weight = weight;
        this.eyeColour = eyeColour;
        this.hairColour = hairColour;
        this.astralSign = astralSign;
        this.distinguishingMarks = distinguishingMarks;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public God getFavoriteGod() {
        return favoriteGod;
    }

    public void setFavoriteGod(God favoriteGod) {
        this.favoriteGod = favoriteGod;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

   public String getEyeColour() {
       return eyeColour;
   }

    public void setEyeColour(String eyeColour){
        this.eyeColour = eyeColour;
    }

    public String getHairColour() {
        return hairColour;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public LinkedList<String> getDistinguishingMarks() {
        return distinguishingMarks;
    }

    public void setDistinguishingMarks(LinkedList<String> distinguishingMarks) {
        this.distinguishingMarks = distinguishingMarks;
    }

    public AstralSign getAstralSign() {
        return astralSign;
    }

    public void setAstralSign(AstralSign astralSign) {
        this.astralSign = astralSign;
    }

    public String toString(){
        String res;

        if (male){
            res = "Sexe : Masculin\n";
        } else {
            res = "Sexe : Féminin\n";
        }

        res += "Age : " + age + "\n";

        if(((height % 100) + "").length() == 1)
            res += "Taille : " + height / 100 + "m0" + height % 100 + "\n";
        else
            res += "Taille : " + height / 100 + "m" + height % 100 + "\n";

        res += "Poids : " + weight + "kg\n";
        res += "Couleur de cheveux : " + hairColour + "\n";

        res += "Couleur des yeux : " + eyeColour + "\n";

        res += "Lieu de Naissance : " + birthplace + "\n";

        res += "Dieu favori : " + favoriteGod + "\n";

        res += "Signes distinctifs : \n";

        for(String mark : distinguishingMarks){
            res += " - " + mark + "\n";
        }

        return res;
    }
}
