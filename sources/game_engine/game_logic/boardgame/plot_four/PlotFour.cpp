#pragma once
#include "PlotFour.hpp"

PlotFour::PlotFour
(
    std::string name,
    std::string description,
    std::vector<std::string> genres

) : Boardgame

(
    name, 
    "E",
    "Playable",
    description,
    genres,
    0
)
{
    setBoard();
}

void PlotFour::setBoard()
{
    board = std::vector<std::vector<BoardPosition<PlotFourPiece>>>();

    for(int row = 0; row < ROWS; row++)
    {
        board.push_back(std::vector<BoardPosition<PlotFourPiece>>());
        for(int col = 0; col < COLS; col++)
        {
            board.at(row).push_back(BoardPosition<PlotFourPiece>(row, col, nullptr));
        }
    }
}

BoardPosition<PlotFourPiece> PlotFour::move(int col)
{
}

bool PlotFour::isWithinBounds(int r, int c) const
{
}

int PlotFour::countDirection
(
    BoardPosition<PlotFourPiece> pos, 
    int dx, 
    int dy
) const
{
}

