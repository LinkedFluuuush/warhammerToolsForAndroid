package com.linkedFluuuush.warhammerToolsForAndroid.core.entities;

import java.io.Serializable;

/**
 * User: Linked
 * Date: 18/11/13
 * Time: 20:21
 */
public class AstralSign implements Serializable {
    private String name;
    private String description;

    public AstralSign(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name;
    }
}
