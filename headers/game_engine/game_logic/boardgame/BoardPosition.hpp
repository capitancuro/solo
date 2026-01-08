#pragma once
template <typename BoardPiece>
struct BoardPosition
{
    friend class PlotFour;

    private:
    BoardPiece board_piece;
    int row, col;

    public:
    BoardPosition(int row, int col, BoardPiece board_piece);
    
    BoardPiece getBoardPiece() const;
    int getRow() const;
    int getCol() const;

    private:
    void setBoardPiece(BoardPiece board_piece);
};