package com.example.examenfinal.models;

import android.util.Log;

import java.util.List;

public class Item {
    private String name;
    private Category category;
    private int cost;
    private List<Effect> effects;

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getCost() {
        return cost;
    }

    public List<Effect> getEffects() {
        return effects;
    }

    public String getEffectsAsString() {
        Log.d("ITEM_EFFECTS", "Efectos: " + effects);
        if (effects == null) {
            return "No hay efectos disponibles";
        }
        StringBuilder effectsAsString = new StringBuilder();
        for (Effect effect : effects) {
            effectsAsString.append(effect.getShortEffect()).append("\n");
        }
        return effectsAsString.toString();
    }
}