package com.linkedFluuuush.warhammerToolsForAndroid.core.characteristics;

/**
 * Created with IntelliJ IDEA.
 * User: Linked
 * Date: 12/11/13
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
public class Talent {
    private String name;
    private String description;

    public Talent(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


}
