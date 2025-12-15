package com.keno.solo.game;

import java.util.ArrayList;

public abstract class Game 
{
    private String name, rating, type, description;
    private ArrayList<String> genres;
    private int price;

    protected Game
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

    public String getName()
    {
        return name;
    }

    public String getRating()
    {
        return rating;
    }

    public String getType()
    {
        return type;
    }

    public String getDescription()
    {
        return description;
    }

    public ArrayList<String> getGenres()
    {
        return genres;
    }

    public int getPrice()
    {
        return price;
    }

    public abstract void launch();
}
