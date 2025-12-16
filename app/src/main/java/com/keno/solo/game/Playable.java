package com.keno.solo.game;

import java.util.List;

import com.keno.solo.game.Game;

public abstract class Playable extends Game
{

    public Playable
    (
        String name, 
        String rating,
        String type,
        String description,
        List<String> genres,
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
