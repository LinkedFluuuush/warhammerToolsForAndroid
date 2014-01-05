package com.linkedFluuuush.warhammerToolsForAndroid.core;

import android.content.Context;
import android.widget.TextView;
import com.linkedFluuuush.warhammerToolsForAndroid.core.characteristics.Career;
import com.linkedFluuuush.warhammerToolsForAndroid.core.characteristics.Race;
import com.linkedFluuuush.warhammerToolsForAndroid.core.characteristics.Skill;
import com.linkedFluuuush.warhammerToolsForAndroid.core.characteristics.Talent;
import com.linkedFluuuush.warhammerToolsForAndroid.core.entities.AstralSign;
import com.linkedFluuuush.warhammerToolsForAndroid.core.entities.God;
import com.linkedFluuuush.warhammerToolsForAndroid.core.equipment.Armour;
import com.linkedFluuuush.warhammerToolsForAndroid.core.equipment.Equipment;
import com.linkedFluuuush.warhammerToolsForAndroid.core.equipment.Weapon;
import com.linkedFluuuush.warhammerToolsForAndroid.core.xmlHelper.xmlLoader;
import com.linkedFluuuush.warhammerToolsForAndroid.core.xmlHelper.xmlSaver;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: linked
 * Date: 13/11/13
 * Time: 17:57
 *
 * @author Jean-Baptiste Louvet jbaptiste.louvet@gmail.com
 * @version 1.0
 */
public class World {
    public static LinkedList<Skill> SKILLS;
    public static LinkedList<Talent> TALENTS;
    public static LinkedList<Weapon> WEAPONS;
    public static LinkedList<Armour> ARMOURS;
    public static LinkedList<Equipment> EQUIPMENTS;
    public static LinkedList<Race> RACES;
    public static LinkedList<Career> CAREERS;
    public static LinkedList<God> GODS;
    public static LinkedList<AstralSign> ASTRALSIGNS;
    public static LinkedList<String> DISTINGUISHINGSIGNS;

    public static void loadAll(Context context){
        SKILLS = xmlLoader.skillLoader(context);
        TALENTS = xmlLoader.talentLoader(context);
        WEAPONS = xmlLoader.weaponLoader(context);
        ARMOURS = xmlLoader.armourLoader(context);
        EQUIPMENTS = xmlLoader.equipmentLoader(context);
        GODS = xmlLoader.godLoader(context);
        ASTRALSIGNS = xmlLoader.astralSignsLoader(context);
        DISTINGUISHINGSIGNS = xmlLoader.distinguishingSignsLoader(context);
        RACES = xmlLoader.raceLoader(context);
        CAREERS = xmlLoader.careerLoader(context);

        xmlLoader.careerLinker(context);
    }

    public static Skill searchSkillByName(String name){
        for (Skill SKILL : SKILLS) {
            if (SKILL.getName().equals(name)) {
                return SKILL;
            }
        }

        System.out.println("Compétence non reconnue : " + name);

        return null;
    }

    public static Talent searchTalentByName(String name){
        for (Talent TALENT : TALENTS) {
            if (TALENT.getName().equals(name)) {
                return TALENT;
            }
        }

        System.out.println("Talent non reconnu : " + name);

        return null;
    }

    public static Weapon searchWeaponByName(String name){
        for (Weapon WEAPON : WEAPONS) {
            if (WEAPON.getName().equals(name)) {
                return WEAPON;
            }
        }

        System.out.println("Arme non reconnue : " + name);

        return null;
    }

    public static Armour searchArmourByName(String name){
        for (Armour ARMOUR : ARMOURS) {
            if (ARMOUR.getName().equals(name)) {
                return ARMOUR;
            }
        }

        System.out.println("Armure non reconnue : " + name);

        return null;
    }

    public static Equipment searchEquipmentByName(String name){
        for (Equipment EQUIPMENT : EQUIPMENTS) {
            if (EQUIPMENT.getName().equals(name)) {
                return EQUIPMENT;
            }
        }

        System.out.println("Equipement non reconnu : " + name);

        return null;
    }

    public static God searchGodByName(String name){
        for (God GOD : GODS) {
            if (GOD.getName().equals(name)) {
                return GOD;
            }
        }

        System.out.println("Dieu non reconnu : " + name);

        return null;
    }

    public static AstralSign searchAstralSignByName(String name){
        for (AstralSign ASTRALSIGN : ASTRALSIGNS) {
            if (ASTRALSIGN.getName().equals(name)) {
                return ASTRALSIGN;
            }
        }

        System.out.println("Signe non reconnu : " + name);

        return null;
    }

    public static String searchDistinguishingSignByName(String name){
        for (String DISTINGUISHINGSIGN : DISTINGUISHINGSIGNS) {
            if (DISTINGUISHINGSIGN.equals(name)) {
                return DISTINGUISHINGSIGN;
            }
        }

        System.out.println("Marque non reconnue : " + name);

        return null;
    }

    public static Race searchRaceByName(String name){
        for (Race RACE : RACES) {
            if (RACE.getName().equals(name)) {
                return RACE;
            }
        }

        if(!name.equals("")){
            System.out.println("Race non reconnue : " + name);
        }

        return null;
    }

    public static Career searchCareerByName(String name){
        for (Career CAREER : CAREERS) {
            if (CAREER.getName().equals(name)) {
                return CAREER;
            }
        }

        System.out.println("Carrière non reconnue : " + name);

        return null;
    }
}
