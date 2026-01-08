#include "game_engine/game_logic/boardgame/Boardgame.hpp"

template <typename BoardPiece>
Boardgame<BoardPiece>::Boardgame
(
    std::string name,
    std::string rating,
    std::string type,
    std::string description,
    std::vector<std::string> genres,
    int price
) : Game
(
    name, 
    rating, 
    type, 
    description, 
    genres, 
    price
)
{
}

template <typename BoardPiece>
std::vector<std::vector<BoardPosition<BoardPiece>>> Boardgame<BoardPiece>::getBoard() const
{
    return board;
}