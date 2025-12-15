package com.keno.solo.game.engine.boardgame;

import com.keno.solo.game.engine.boardgame.Unit;

public class Position 
{
    private int x, y;
    private Unit unit;

    public Position(int x, int y, Unit unit)
    {
        setUnit(unit);
    }

    public void setUnit(Unit unit)
    {
        this.unit = unit;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Unit getUnit()
    {
        return unit;
    }
}
