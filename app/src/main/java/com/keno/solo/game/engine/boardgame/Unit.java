package com.keno.solo.game.engine.boardgame;

import com.keno.solo.game.engine.boardgame.Position;

public class Unit 
{
    private int value;
    private Position position;

    public Unit(int value, Position position)
    {
        setPosition(position);
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }

    public Position getPosition()
    {
        return position;
    }
}
