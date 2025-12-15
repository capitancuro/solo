package com.keno.solo.game;

import java.util.ArrayList;

import com.keno.solo.game.Game;

public abstract class Playable extends Game
{

    public Playable
    (
        String name, 
        String rating,
        String type,
        String description,
        ArrayList<String> genres,
        int price
    )
    {
        super
        (
            name,
            rating,
            type,
            description,
            genres,
            price

        );
    }
    
    public abstract void play();

}
