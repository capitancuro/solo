package com.keno.solo.game.engine.boardgame;

import java.util.ArrayList;

import com.keno.solo.game.Playable;
import com.keno.solo.game.engine.boardgame.Position;
import com.keno.solo.game.engine.boardgame.Unit;

public abstract class Boardgame extends Playable
{
    ArrayList<Unit> units;
    ArrayList<ArrayList<Position>> board;

    public Boardgame
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

    protected abstract void setUnits();
    protected abstract void setBoard(int x, int y);
}
