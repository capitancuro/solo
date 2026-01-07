#pragma once
#include "BoardPosition.hpp"

template <typename BoardPiece>
BoardPosition<BoardPiece>::BoardPosition
(
    int row, 
    int col, 
    BoardPiece* piece = nullptr
)
{
    this->row = row;
    this-col = col;
    this->board_piece = board_piece;
}

template <typename BoardPiece>
BoardPiece BoardPosition<BoardPiece>::getBoardPiece() const
{
    return board_piece;
}

template <typename BoardPiece>
int BoardPosition<BoardPiece>::getRow() const
{
    return row;
}

template <typename BoardPiece>
int BoardPosition<BoardPiece>::getCol() const
{
    return col;
}