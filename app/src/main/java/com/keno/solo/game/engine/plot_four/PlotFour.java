package com.keno.solo.game.engine.plot_four;

import java.util.List;

import com.keno.solo.game.engine.boardgame.Boardgame;

public abstract class PlotFour extends Boardgame
{
    protected PlotFour
    (
        String name, 
        String description, 
        List<String> genres
    )
    {
        super
        (
            name, 
            "E", 
            "playable", 
            description, 
            genres, 
            0
        );
    }
}
