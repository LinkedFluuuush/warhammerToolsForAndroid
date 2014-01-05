package com.linkedFluuuush.warhammerToolsForAndroid.core.characteristics;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Linked
 * Date: 12/11/13
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class Skill implements Serializable {
    private String name;
    private String characteristics;

    public Skill(String name, String characteristics) {
        this.name = name;
        this.characteristics = characteristics;
    }

    public String getName() {
        return name;
    }

    public String getCharacteristics() {
        return characteristics;
    }
}
