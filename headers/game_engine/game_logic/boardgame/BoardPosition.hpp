#pragma once
template <typename BoardPiece>
struct BoardPosition
{
    friend class PlotFour;

    private:
    BoardPiece board_piece;
    int row, col;

    public:

    BoardPosition
    (
        int row, 
        int col, 
        BoardPiece board_piece
    )
    {
        this->row = row;
        this->col = col;
        this->board_piece = board_piece;
    }

    BoardPiece getBoardPiece() const
    {
        return board_piece;
    }

    int getRow() const
    {
        return row;
    }

    int getCol() const
    {
        return col;
    }

    private:

    void setBoardPiece(BoardPiece board_piece)
    {
        this->board_piece = board_piece;
    }
};