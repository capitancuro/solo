package com.keno.solo.game;

import java.util.ArrayList;

public abstract class Game 
{
    protected String name, rating, type, description;
    protected ArrayList<String> genres;
    protected int price;

    public Game
    (
        String name, 
        String rating,
        String type,
        String description,
        ArrayList<String> genres,
        int price
    )
    {
        this.name = name;
        this.rating = rating;
        this.type = type;
        this.description = description;
        this.genres = genres;
        this.price = price;
    }

}
