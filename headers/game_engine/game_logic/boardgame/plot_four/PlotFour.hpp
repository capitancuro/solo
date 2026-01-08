#include "Boardgame.hpp"
#include "PlotFourPiece.h"

class PlotFour : Boardgame<PlotFourPiece>
{
    protected:
    const int ROWS = 6, COLS = 7;
    bool red_turn = true;

    public:
    PlotFour
    (
        std::string name,
        std::string description,
        std::vector<std::string> genres
    );

    public:

    virtual BoardPosition<PlotFourPiece> move(int col) final;

    protected:
    
    virtual bool isWithinBounds(int r, int c) const final;
    virtual int countDirection(BoardPosition<PlotFourPiece> pos, int dx, int dy) const final;
    virtual int countInLine(BoardPosition<PlotFourPiece> pos, int dx, int dy) const final;

    public:

    virtual PlotFourPiece win
    (
        BoardPosition<PlotFourPiece> position,
        int x,
        int y
    ) final;
};