package com.keno.solo.game;

import com.keno.solo.game.Game;

import java.util.ArrayList;

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
    
    public abstract void launch();

}
