package com.keno.solo.game.engine.plot_four;

import java.util.List;
import java.util.ArrayList;

import com.keno.solo.game.engine.boardgame.Position;
import com.keno.solo.game.engine.boardgame.Unit;

public class PlotFourOffline extends PlotFour
{
    public PlotFourOffline()
    {
        super
        (
            "Plot Four Offline", 
            "Play plot four offline! \n Take turns using shared peripherals \n or connect using bluetooth",
            List.of("boardgame", "tabletop", "strategy")
        );
        setUnits();
    }

    public void setUnits()
    {
        units = new ArrayList<Unit>();
        units.add(new Unit(0, null));
        units.add(new Unit(1, null));
    }

    public  void setBoard(int x, int y)
    {
        board = new ArrayList<ArrayList<Position>>();

        for(int row = 0; row < ROWS; row++)
        {
            board.add(new ArrayList<Position>());

            for(int col = 0; col < COLS; col++)
            {
                board.get(row).add(new Position(row, col, null));
            }
        }
    }

    public void play()
    {

    }
}
