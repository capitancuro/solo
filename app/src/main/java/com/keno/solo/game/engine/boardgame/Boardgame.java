package com.keno.solo.game.engine.boardgame;

import java.util.List;
import java.util.ArrayList;

import com.keno.solo.game.Playable;
import com.keno.solo.game.engine.boardgame.Position;
import com.keno.solo.game.engine.boardgame.Unit;

public abstract class Boardgame extends Playable
{
    protected ArrayList<Unit> units;
    protected ArrayList<ArrayList<Position>> board;

    public Boardgame
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

    public ArrayList<ArrayList<Position>> getBoard()
    {
        return board;
    }

    protected abstract void setUnits();
    protected abstract void setBoard();
}
