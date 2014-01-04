package com.linkedFluuuush.warhammerToolsForAndroid.core.characteristics;

import com.linkedFluuuush.warhammerToolsForAndroid.core.equipment.Armour;
import com.linkedFluuuush.warhammerToolsForAndroid.core.equipment.Equipment;
import com.linkedFluuuush.warhammerToolsForAndroid.core.equipment.Weapon;

import java.util.LinkedList;

/**
 * User: Linked
 * Date: 12/11/13
 * Time: 15:20
 */
public class Career implements Comparable {
    private String name;
    private Profile profile;
    private int type;

    private LinkedList<LinkedList<Skill>> skills;
    private LinkedList<LinkedList<Talent>> talents;
    private LinkedList<LinkedList<Equipment>> equipments;
    private LinkedList<LinkedList<Weapon>> weapons;
    private LinkedList<LinkedList<Armour>> armours;

    private LinkedList<Career> accessCareers;
    private LinkedList<Career> openingCareers;

    private LinkedList<Race> availableRaces;

    public Career(String name, Profile profile, LinkedList<LinkedList<Skill>> skills,
                  LinkedList<LinkedList<Talent>> talents, LinkedList<LinkedList<Equipment>> equipments,
                  LinkedList<LinkedList<Weapon>> weapons, LinkedList<LinkedList<Armour>> armours, LinkedList<Race> availableRaces, int type) {
        this.name = name;
        this.profile = profile;
        this.skills = skills;
        this.talents = talents;
        this.equipments = equipments;
        this.weapons = weapons;
        this.armours = armours;
        this.availableRaces = availableRaces;
        this.type = type;
        this.accessCareers = new LinkedList<Career>();
        this.openingCareers = new LinkedList<Career>();
    }

    public Career(String name, int ws, int bs, int s, int t, int ag, int intel, int wp,
                  int fel, int a, int w, int m, int mag,
                  LinkedList<LinkedList<Skill>> skills,
                  LinkedList<LinkedList<Talent>> talents, LinkedList<LinkedList<Equipment>> equipments,
                  LinkedList<LinkedList<Weapon>> weapons, LinkedList<LinkedList<Armour>> armours, LinkedList<Race> availableRaces, int type) {
        this.name = name;
        this.profile = new Profile(ws, bs, s, t, ag, intel, wp, fel, a, w, m, mag);
        this.skills = skills;
        this.talents = talents;
        this.equipments = equipments;
        this.weapons = weapons;
        this.armours = armours;
        this.availableRaces = availableRaces;
        this.type = type;
        this.accessCareers = new LinkedList<Career>();
        this.openingCareers = new LinkedList<Career>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public LinkedList<LinkedList<Skill>> getSkills() {
        return skills;
    }

    public void setSkills(LinkedList<LinkedList<Skill>> skills) {
        this.skills = skills;
    }

    public LinkedList<LinkedList<Talent>> getTalents() {
        return talents;
    }

    public void setTalents(LinkedList<LinkedList<Talent>> talents) {
        this.talents = talents;
    }

    public LinkedList<LinkedList<Equipment>> getEquipments() {
        return equipments;
    }

    public void setEquipments(LinkedList<LinkedList<Equipment>> equipments) {
        this.equipments = equipments;
    }

    public LinkedList<LinkedList<Weapon>> getWeapons() {
        return weapons;
    }

    public void setWeapons(LinkedList<LinkedList<Weapon>> weapons) {
        this.weapons = weapons;
    }

    public LinkedList<LinkedList<Armour>> getArmours() {
        return armours;
    }

    public void setArmours(LinkedList<LinkedList<Armour>> armours) {
        this.armours = armours;
    }

    public LinkedList<Career> getAccessCareers() {
        return accessCareers;
    }

    public void setAccessCareers(LinkedList<Career> accessCareers) {
        this.accessCareers = accessCareers;
    }

    public void addAccessCareer(Career career){
        this.accessCareers.add(career);
    }

    public LinkedList<Career> getOpeningCareers() {
        return openingCareers;
    }

    public void setOpeningCareers(LinkedList<Career> openingCareers) {
        this.openingCareers = openingCareers;
    }

    public void addOpeningCareer(Career career){
        this.openingCareers.add(career);
    }

    public LinkedList<Race> getAvailableRaces() {
        return availableRaces;
    }

    public void setAvailableRaces(LinkedList<Race> availableRaces) {
        this.availableRaces = availableRaces;
    }

    public LinkedList<Career> getRandomPreviousCareers(int depth, int minDepth, LinkedList<Career> previousCareers, LinkedList<LinkedList<Career>> allPossibilities){
        for(Career career : this.getAccessCareers()){
            if(this.type != 1){
                depth++;
                previousCareers.add(career);
                return career.getRandomPreviousCareers(depth, minDepth, previousCareers, allPossibilities);
            }

            if(depth < minDepth){
                minDepth = depth;
            }

            allPossibilities.add(previousCareers);
            previousCareers = new LinkedList<Career>();
        }

        for(LinkedList<Career> aPossibility : allPossibilities){
            if(aPossibility.size() == minDepth){
                previousCareers = aPossibility;
            }
        }

        return previousCareers;
    }

    @Override
    public String toString(){
        return this.getName();
    }

    public String allToString(){
        String res = "Carrière : " + name + " (Carrière";

        if(type == 1){
            res += " de base)\n";
        } else {
            res += " avancée)\n";
        }

        res += profile + "\n";
        res += "Compétences : \n";

        for(int i = 0; i < skills.size() ; i++){
            for (int j = 0 ; j < skills.get(i).size() ; j++){
                res += skills.get(i).get(j).getName();

                if(j < skills.get(i).size() - 1){
                    res += " ou ";
                }
            }

            if(i < skills.size() - 1){
                res += ", ";
            } else {
                res += "\n";
            }
        }

        res += "Talents : \n";

        for(int i = 0; i < talents.size() ; i++){
            for (int j = 0 ; j < talents.get(i).size() ; j++){
                res += talents.get(i).get(j).getName();

                if(j < talents.get(i).size() - 1){
                    res += " ou ";
                }
            }

            if(i < talents.size() - 1){
                res += ", ";
            } else {
                res += "\n";
            }
        }

        res += "Equipement : \n";

        for(int i = 0; i < equipments.size() ; i++){
            for (int j = 0 ; j < equipments.get(i).size() ; j++){
                res += equipments.get(i).get(j).getName();

                if(j < equipments.get(i).size() - 1){
                    res += " ou ";
                }
            }

            if(i < equipments.size() - 1){
                res += ", ";
            }
        }

        if(armours.size() != 0){
            res += ", ";
        }

        for(int i = 0; i < armours.size() ; i++){
            for (int j = 0 ; j < armours.get(i).size() ; j++){
                res += armours.get(i).get(j).getName();

                if(j < armours.get(i).size() - 1){
                    res += " ou ";
                }
            }

            if(i < armours.size() - 1){
                res += ", ";
            }
        }

        if(weapons.size() != 0){
            res += ", ";
        }

        for(int i = 0; i < weapons.size() ; i++){
            for (int j = 0 ; j < weapons.get(i).size() ; j++){
                res += weapons.get(i).get(j).getName();

                if(j < weapons.get(i).size() - 1){
                    res += " ou ";
                }
            }

            if(i < weapons.size() - 1){
                res += ", ";
            }
        }

        res += "\n\n";
        res += "Accès : \n";

        for(int i = 0; i < accessCareers.size() ; i++){
            res += accessCareers.get(i).getName();

            if (i < accessCareers.size() - 1){
                res += ", ";
            }
        }

        res += "\n\n";
        res += "Débouchés : \n";

        for(int i = 0; i < openingCareers.size() ; i++){
            res += openingCareers.get(i).getName();

            if (i < openingCareers.size() - 1){
                res += ", ";
            }
        }

        return res;
    }

    @Override
    public int compareTo(Object o) {
        Career c = (Career)o;

        return this.getName().compareTo(c.getName());
    }
}
