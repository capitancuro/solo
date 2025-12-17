package com.keno.solo.game.engine.plot_four;

import java.util.List;

import com.keno.solo.game.engine.boardgame.Boardgame;
import com.keno.solo.game.engine.boardgame.Position;

public abstract class PlotFour extends Boardgame
{
    protected final int ROWS = 6, COLS = 7;
    
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

    protected abstract Position move(int col);
}
