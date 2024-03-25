package com.example.examenfinal.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Move {
    private String accuracy;
    private String name;

    @SerializedName("learned_by_pokemon")
    private List<PokemonListItem> learned_by_pokemon;

    public String getAccuracy() {
        return accuracy;
    }

    public String getName() {
        return name;
    }

    public List<PokemonListItem> getLearned_by_pokemon() {
        return learned_by_pokemon;
    }

    /**
     *  Junta todo el listado de nombres de Pokémon en una cadena y la devuelve.
     *
     * @return      Una cadena con el nombre de todos los Pokémon que aprenden este movimiento.
     */
    public String getPokemonsString() {
        String s = "";
        for (int i = 0; learned_by_pokemon != null && i<learned_by_pokemon.size(); i++) {
            s += learned_by_pokemon.get(i).getName() + " ";
        }
        return  s;
    }

}