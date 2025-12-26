package com.keno.solo.game_logic;

import java.util.ArrayList;
import java.util.List;

public abstract class Game 
{
    private String name, rating, type, description;
    private ArrayList<String> genres;
    private int price;

    public Game
    (
        String name,
        String rating,
        String type,
        String description,
        List<String> genres,
        int price
    )
    {
        this.name = name;
        this.rating = rating;
        this.type = type;
        this.description = description;
        this.genres = new ArrayList<>(genres);
    }

    public String getName(){return name;}
    public String getRating(){return rating;}
    public String getType(){return type;}
    public String getDescription(){return description;}

    public ArrayList<String> getGenres(){return genres;}

    public int getPrice(){return price;}
}
