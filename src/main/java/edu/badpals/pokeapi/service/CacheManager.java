package edu.badpals.pokeapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.badpals.pokeapi.model.Area;
import edu.badpals.pokeapi.model.Pokemon;
import edu.badpals.pokeapi.model.PokemonData;

import java.io.File;
import java.io.IOException;
import java.lang.runtime.ObjectMethods;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheManager {
    private static final String DIR_CACHE = "cache/";

    public static void saveCache(PokemonData data){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(DIR_CACHE + data.getPokemon().getName() + ".json"),data);
        }catch (IOException e){
            System.out.println("Error saving cache.");
            e.printStackTrace();
        }
    }

    public static PokemonData loadCache(String pokemonName){
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(DIR_CACHE + pokemonName + ".json"), PokemonData.class);
        } catch (IOException e) {
            System.out.println("Error loading cache. ");
            e.printStackTrace();
        }
        return null;
    }

}
