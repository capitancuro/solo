#include "Game.hpp"
#include "BoardPosition.hpp"

template <typename BoardPiece>
class Boardgame : Game
{
    protected:
    std::vector<std::vector<BoardPosition<BoardPiece>>> board;

    public:
    Boardgame
    (
        std::string name,
        std::string rating,
        std::string type,
        std::string description,
        std::vector<std::string> genres,
        int price
    );

    protected:
    virtual void setPieces();
    virtual void setBoard();

    public:
    std::vector<std::vector<BoardPosition<BoardPiece>>> getBoard() const;
};