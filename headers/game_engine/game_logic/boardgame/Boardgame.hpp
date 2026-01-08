#pragma once
#include "game_engine/Game.hpp"
#include "BoardPosition.hpp"

template <typename BoardPiece>
class Boardgame : public Game
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
    ) : Game
    (
        name, 
        rating, 
        type, 
        description, 
        genres, 
        price
    )
    {}

    protected:

    virtual void setBoard() = 0;

    public:

    virtual std::vector<std::vector<BoardPosition<BoardPiece>>> getBoard() const final 
    {
        return board;
    }
};