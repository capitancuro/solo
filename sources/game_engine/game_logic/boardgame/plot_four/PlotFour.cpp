#include "game_engine/game_logic/boardgame/plot_four/PlotFour.hpp"

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
            board.at(row).push_back(BoardPosition<PlotFourPiece>(row, col, PlotFourPiece::NONE));
    }
}

BoardPosition<PlotFourPiece> PlotFour::move(int col)
{
    for (int row = ROWS - 1; row >= 0; row--)
    {
        if (board.at(row).at(col).board_piece == PlotFourPiece::NONE)
        {
            if (red_turn)
            {
                board.at(row).at(col).board_piece = PlotFourPiece::RED;
                red_turn = !red_turn;
                return board.at(row).at(col);
            }
            else
            {
                board.at(row).at(col).board_piece = PlotFourPiece::YELLOW;
                red_turn = !red_turn;
                return board.at(row).at(col);
            }
        }
    }

    return BoardPosition<PlotFourPiece>(-1, -1, PlotFourPiece::NONE);
}

bool PlotFour::isWithinBounds(int r, int c) const
{
    return r >= 0 && r < ROWS && c >= 0 && c < COLS;
}

int PlotFour::countDirection
(
    BoardPosition<PlotFourPiece> pos, 
    int dx, 
    int dy
) const
{
    int count = 0, r = pos.row + dx, c = pos.col + dy;
    while (isWithinBounds(r, c) && board.at(r).at(c).board_piece == pos.board_piece)
    {
        count++;
        r += dx;
        c += dy;
    }

    return count;
}

int PlotFour::countInLine
(
    BoardPosition<PlotFourPiece> pos,
    int dx, 
    int dy
) const
{
    return 1 + countDirection(pos, dx, dy) + countDirection(pos, -dx, -dy);
}

PlotFourPiece PlotFour::win(BoardPosition<PlotFourPiece> position)
{
    if (position.board_piece == PlotFourPiece::NONE) return PlotFourPiece::NONE;
    
    int directions[4][2] = {
        {0, 1},
        {1, 0},
        {1, 1},
        {1, -1}
    };

   for (auto dir : directions)
   {
    int dx = dir[0];
    int dy = dir[1];

    if (countInLine(position, dx, dy) >=  4)
        return position.board_piece;
   }

   return PlotFourPiece::NONE;
}
