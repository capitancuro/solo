package com.keno.solo.game.engine.boardgame;

import com.keno.solo.game.engine.boardgame.Unit;

public class Position 
{
    private int row, col;
    private Unit unit;

    public Position(int row, int col, Unit unit)
    {
        setUnit(unit);
    }

    public void setUnit(Unit unit)
    {
        this.unit = unit;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public Unit getUnit()
    {
        return unit;
    }
}
