package com.keno.solo.game_logic.game_engine.plot_four;

import java.util.List;

import com.keno.solo.game_logic.game_engine.boardgame.BoardPosition;
import com.keno.solo.game_logic.game_engine.boardgame.Boardgame;

enum PlotFourPiece{RED, YELLOW};

public abstract class PlotFour extends Boardgame<PlotFourPiece>
{
    protected final int ROWS = 6;
    protected final int COLS = 7;

    protected boolean red_turn = true;
    
    public PlotFour
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
            "Playable",
            description,
            genres,
            0
        );
    }

    public abstract BoardPosition<PlotFourPiece> move(int col);

    public abstract PlotFourPiece win
    (
        BoardPosition<PlotFourPiece> position, 
        int x, 
        int y, 
        int n
    );
}
