package com.keno.solo.game_logic.game_engine.boardgame;

public class BoardPosition<Piece>
{
    private int row, col;
    private Piece board_piece;

    public BoardPosition
    (
        int row, 
        int col, 
        Piece board_piece)
    {
        this.row = row;
        this.col = col;
        this.board_piece = board_piece;
    }

    public void setBoard_Piece(Piece board_piece){this.board_piece = board_piece;}

    public int getRow(){return row;}
    public int getCol(){return col;}

    public Piece getBoard_Piece(){return board_piece;}
}
