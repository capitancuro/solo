package com.keno.solo.game_logic.boardgame;

import java.util.ArrayList;
import java.util.List;

import com.keno.solo.game_logic.Game;
import com.keno.solo.game_logic.boardgame.BoardPosition;

public abstract class Boardgame<Piece>  extends Game
{
    protected ArrayList<ArrayList<BoardPosition<Piece>>> board;

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

    protected abstract void setBoard();
    public ArrayList<ArrayList<BoardPosition<Piece>>> getBoard()
    {
        return board;
    }
}
