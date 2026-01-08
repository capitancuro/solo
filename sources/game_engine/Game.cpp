#include "game_engine/Game.hpp"

Game::Game
(
        std::string name,
        std::string rating,
        std::string type,
        std::string description,
        std::vector<std::string> genres,
        int price
)
{
        this->name = name;
        this->rating = rating;
        this->type = type;
        this->description = description;
        this->genres = genres;
        this->price = price;
}

std::string Game::getName() const {return name;}
std::string Game::getRating() const {return rating;}
std::string Game::getType() const {return type;}
std::string Game::getDescription() const {return description;}
std::vector<std::string> Game::getGenres() const {return genres;}
int Game::getPrice() const {return price;}